from bert import modeling
from bert import optimization
import argparse
import csv
import numpy as np
import tensorflow as tf
import os


'''Restore the pretrained code LM;
Fine-tune with training data;
Test with test data.'''

parser = argparse.ArgumentParser()
parser.add_argument('--train_data',dest='train_data',type=str,help='The .csv file of training sequences')
parser.add_argument('--test_data',dest='test_data',type=str, help ='The .csv file of test sequences')
parser.add_argument('--log',dest='log',type=str,default = 'log.txt', help='The .txt file to record configuration and results')
parser.add_argument('--output_dir',dest='output_dir',type=str, help='The dir to store checkpoint, log')
parser.add_argument('--bert_checkpoint',dest='bert_checkpoint',type=str,help='The checkpoint to restore for pretrained BERT LM')
parser.add_argument('--bert_config',dest='bert_config',type=str,default = './bert_config.json', help='The .json file to specify the model hyper parameters')

parser.add_argument('--epoch',dest='epoch',type=int,default= 10, help='The number of epoch to train the task-specific model')
parser.add_argument('--batch_size',dest='batch_size',default = 64, type=int,help='The batch_size for training and testing')
parser.add_argument('--lr',dest='lr',type=float,default = 5e-5, help='learning rate')
parser.add_argument('--warmup_proportion',dest='warmup_proportion',type=float, default=0.1)
#parser configurations
args = parser.parse_args()
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '0'
tf.logging.set_verbosity(tf.logging.INFO)
train_data = args.train_data
test_data = args.test_data
log = args.log
output_dir = args.output_dir
bert_checkpoint = args.bert_checkpoint
bert_config = args.bert_config

epoch = args.epoch
batch_size = args.batch_size
lr = args.lr
warmup_proportion = args.warmup_proportion


output_dir = args.output_dir
n_voca = 4543

if output_dir.endswith('/'):
	output_dir = output_dir.strip()

with open(output_dir+'/'+log,'w') as logfile:
	logfile.write(f"Model configuration: [bert_checkpoint: {bert_checkpoint}]")


def create_model(bert_config, is_training, input_ids, input_mask, segment_ids,
                 labels, num_labels, use_one_hot_embeddings):
	"""Creates a classification model."""
	model = modeling.BertModel(
		config=bert_config,
		is_training=is_training,
		input_ids=input_ids,
		input_mask=input_mask,
		token_type_ids=segment_ids,
		use_one_hot_embeddings=use_one_hot_embeddings)

	# In the demo, we are doing a simple classification task on the entire
	# segment.
    #
	# If you want to use the token-level output, use model.get_sequence_output()
	# instead.
	output_layer = model.get_pooled_output()

	hidden_size = output_layer.shape[-1].value

	output_weights = tf.get_variable(
		"output_weights", [num_labels, hidden_size],
		initializer=tf.truncated_normal_initializer(stddev=0.02))
	output_bias = tf.get_variable(
		"output_bias", [num_labels], initializer=tf.zeros_initializer())

	with tf.variable_scope("loss"):
		if is_training:
		    # I.e., 0.1 dropout
		    output_layer = tf.nn.dropout(output_layer, keep_prob=0.9)

		logits = tf.matmul(output_layer, output_weights, transpose_b=True)
		logits = tf.nn.bias_add(logits, output_bias)
		probabilities = tf.nn.softmax(logits, axis=-1)
		log_probs = tf.nn.log_softmax(logits, axis=-1)

		one_hot_labels = tf.one_hot(labels, depth=num_labels, dtype=tf.float32)
		per_example_loss = -tf.reduce_sum(one_hot_labels * log_probs, axis=-1)
		loss = tf.reduce_mean(per_example_loss)

		return (loss, per_example_loss, logits, probabilities)

def data_reader(input_file,max_len=10,debug=True):
    # read out the raw input
    with open(input_file,'r') as file:
        reader = csv.reader(file)
        sentences = [[int(i) for i in row] for row in reader]

    keys = ['input_ids','input_mask','segment_ids','label_ids']
    features = dict([(key, []) for key in keys])
    
    for row in sentences:
        if len(row) >1:
        	if len(row)>max_len+1:
        		row = row[-(max_len+1):]
        input_ids = row[:-1]
        real_len = len(input_ids)
        input_mask = [1]*real_len
        input_ids = np.pad(input_ids, (0, max_len-real_len), 'constant', constant_values=(0, 0))
        input_mask = np.pad(input_mask,(0,max_len-real_len),'constant',constant_values=(0,0))
        segment_ids = [0]*max_len
        label_id = row[-1]
     
        
        features['input_ids'].append(list(input_ids))
        features['input_mask'].append(list(input_mask))
        features['segment_ids'].append(segment_ids)
        features['label_ids'].append(label_id)
    
    return features

def input_fn_builder(features, is_training):
	"""Creates an `input_fn` closure to be passed to TPUEstimator."""
	all_input_ids = features['input_ids']
	all_input_mask = features['input_mask']
	all_segment_ids = features['segment_ids']
	all_label_ids = features['label_ids']
	seq_length = len(all_input_ids[0])

	name_to_features = {
    	"input_ids": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_mask": tf.FixedLenFeature([seq_length], tf.int64),
    	"segment_ids": tf.FixedLenFeature([seq_length], tf.int64),
    	"label_ids": tf.FixedLenFeature([], tf.int64),
    	"is_real_example": tf.FixedLenFeature([], tf.int64),
    }

	
	def input_fn(params):
		"""The actual input function."""
		batch_size = params["batch_size"]
		num_examples = len(all_input_ids)

    	# For training, we want a lot of parallel reading and shuffling.
    	# For eval, we want no shuffling and parallel reading doesn't matter.
		d = tf.data.Dataset.from_tensor_slices({
			"input_ids":
				tf.constant(all_input_ids,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_mask":
				tf.constant(all_input_mask,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"segment_ids":
				tf.constant(all_segment_ids,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"label_ids":
				tf.constant(all_label_ids,
					shape=[num_examples],
					dtype=tf.int32),
		})
		if is_training:
			d = d.repeat()
			d = d.shuffle(buffer_size=100)
		d = d.batch(batch_size=batch_size)

		return d
	return input_fn


def model_fn_builder(bert_config, num_labels, init_checkpoint, learning_rate,
                     num_train_steps, num_warmup_steps, use_tpu=False,
                     use_one_hot_embeddings=True):
	"""Returns `model_fn` closure for TPUEstimator."""

	def model_fn(features, labels, mode, params):  # pylint: disable=unused-argument
		"""The `model_fn` for TPUEstimator."""

		input_ids = features["input_ids"]
		input_mask = features["input_mask"]
		segment_ids = features["segment_ids"]
		label_ids = features["label_ids"]
		is_real_example = None
		if "is_real_example" in features:
			is_real_example = tf.cast(features["is_real_example"], dtype=tf.float32)
		else:
			is_real_example = tf.ones(tf.shape(label_ids), dtype=tf.float32)

		is_training = (mode == tf.estimator.ModeKeys.TRAIN)

		(total_loss, per_example_loss, logits, probabilities) = create_model(
        	bert_config, is_training, input_ids, input_mask, segment_ids, label_ids,
        	num_labels, use_one_hot_embeddings)

		tvars = tf.trainable_variables()
		initialized_variable_names = {}
		scaffold_fn = None
		if init_checkpoint:
			(assignment_map, initialized_variable_names) = modeling.get_assignment_map_from_checkpoint(tvars, init_checkpoint)

			tf.train.init_from_checkpoint(init_checkpoint, assignment_map)

		tf.logging.info("**** Trainable Variables ****")
		for var in tvars:
			init_string = ""
			if var.name in initialized_variable_names:
				init_string = ", *INIT_FROM_CKPT*"
			tf.logging.info("  name = %s, shape = %s%s", var.name, var.shape,
                      init_string)
		tf.logging.info("**** Restored Variables ****")
		for var_name in assignment_map:
			
			tf.logging.info("  name = %s", var_name)
		output_spec = None
		if mode == tf.estimator.ModeKeys.TRAIN:
			train_op = optimization.create_optimizer(
    			total_loss, learning_rate, num_train_steps, num_warmup_steps, use_tpu)

			output_spec = tf.contrib.tpu.TPUEstimatorSpec(
				mode=mode,
				loss=total_loss,
				train_op=train_op,
				scaffold_fn=scaffold_fn)
		elif mode == tf.estimator.ModeKeys.EVAL:

			def metric_fn(per_example_loss, label_ids, logits, is_real_example):
				predictions = tf.argmax(logits, axis=-1, output_type=tf.int32)
				accuracy = tf.metrics.accuracy(
					labels=label_ids, predictions=predictions, weights=is_real_example)
				loss = tf.metrics.mean(values=per_example_loss, weights=is_real_example)
				return {
				"eval_accuracy": accuracy,
				"eval_loss": loss,
				}

			eval_metrics = (metric_fn,
				[per_example_loss, label_ids, logits, is_real_example])
			output_spec = tf.contrib.tpu.TPUEstimatorSpec(
				mode=mode,
				loss=total_loss,
				eval_metrics=eval_metrics,
				scaffold_fn=scaffold_fn)
		else:
			output_spec = tf.contrib.tpu.TPUEstimatorSpec(
				mode=mode,
				predictions={"probabilities": probabilities},
				scaffold_fn=scaffold_fn)
		return output_spec

	return model_fn



bert_config = modeling.BertConfig.from_json_file(bert_config)


# update with train_data
train_features = data_reader(train_data,10)
num_train_steps_one_epoch = int(
	len(train_features['label_ids']) / batch_size)+1
num_train_steps = int(
	len(train_features['label_ids']) / batch_size * epoch)
num_warmup_steps = int(num_train_steps * warmup_proportion)

model_fn = model_fn_builder(
    bert_config=bert_config,
    num_labels=n_voca,
    init_checkpoint=bert_checkpoint,
    learning_rate=lr,
    num_train_steps=num_train_steps,
    num_warmup_steps=num_warmup_steps)

SAVE_SUMMARY_STEPS = 5
SAVE_CHECKPOINTS_STEPS = 2000
#run_config = tf.estimator.RunConfig(
#    model_dir=output_dir,
#    save_summary_steps=SAVE_SUMMARY_STEPS,
#    save_checkpoints_steps=SAVE_CHECKPOINTS_STEPS)
# Specify output directory and number of checkpoint steps to save
run_config = tf.contrib.tpu.RunConfig(
      cluster=None,
      master=None,
      model_dir=output_dir,
      save_checkpoints_steps=SAVE_CHECKPOINTS_STEPS,
      tpu_config=tf.contrib.tpu.TPUConfig(
          iterations_per_loop=1000,
          num_shards=8,
          per_host_input_for_training=tf.contrib.tpu.InputPipelineConfig.PER_HOST_V2))


  # If TPU is not available, this will fall back to normal Estimator on CPU
  # or GPU.
estimator = tf.contrib.tpu.TPUEstimator(
      use_tpu=False,
      model_fn=model_fn,
      config=run_config,
      train_batch_size=batch_size,
      eval_batch_size=batch_size,
      predict_batch_size=batch_size)

#start training and evaluation

tf.logging.info("***** Running training *****")
tf.logging.info("  Num examples = %d", len(train_features['label_ids']))
tf.logging.info("  Batch size = %d", batch_size)
tf.logging.info("  Num steps = %d", num_train_steps)
train_input_fn = input_fn_builder(train_features,is_training=True)
eval_features = data_reader(test_data,10)
num_actual_eval_examples = len(eval_features['label_ids'])
output_eval_file = os.path.join(output_dir, "eval_results.txt")
with tf.gfile.GFile(output_eval_file, "w") as writer:
	writer.write(f"evaluation results for test data {test_data}\n")


for i in range(epoch):
	estimator.train(input_fn=train_input_fn, steps=num_train_steps_one_epoch)

	tf.logging.info("***** Running evaluation after training epoch %d*****",(i+1))
	tf.logging.info("  Num examples = %d",
                    len(eval_features['label_ids']))
	tf.logging.info("  Batch size = %d", batch_size)
	# This tells the estimator to run through the entire set.
	eval_steps = None
	# However, if running eval on the TPU, you will need to specify the
	# number of steps.

	eval_input_fn = input_fn_builder(eval_features,False)

	result = estimator.evaluate(input_fn=eval_input_fn, steps=eval_steps)
	
	with tf.gfile.GFile(output_eval_file, "a") as writer:
		tf.logging.info("***** Eval results *****")
		writer.write("Evaluation result after epoch {}\n".format(i+1))
		for key in sorted(result.keys()):
			tf.logging.info("  %s = %s", key, str(result[key]))
			writer.write("%s = %s\n" % (key, str(result[key])))









# start predict:
 
#predict_features = data_reader(test_data,10)
#num_actual_predict_examples = len(predict_features['label_ids'])

#tf.logging.info("***** Running prediction*****")
#tf.logging.info("  Num examples = %d ",
#                len(predict_features['label_ids']), num_actual_predict_examples)
#tf.logging.info("  Batch size = %d", batch_size)


#predict_input_fn = input_fn_builder(predict_features,False)

#result = estimator.predict(input_fn=predict_input_fn)

#output_predict_file = os.path.join(output_dir, "test_results.csv")
#with open(output_predict_file, "w") as writer:
#    num_written_lines = 0
#    tf.logging.info("***** Predict results *****")
#    for (i, prediction) in enumerate(result):
#        probabilities = prediction["probabilities"]
#        if i >= num_actual_predict_examples:
#          break
#        output_line = "\t".join(
#            str(class_probability)
#            for class_probability in probabilities) + "\n"
#        writer.write(output_line)
#        num_written_lines += 1
#    assert num_written_lines == num_actual_predict_examples

