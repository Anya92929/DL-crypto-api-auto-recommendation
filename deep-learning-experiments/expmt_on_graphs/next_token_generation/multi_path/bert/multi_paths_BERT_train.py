from bert_multi_paths import modeling
from bert_multi_paths import optimization
import argparse
import csv
import numpy as np
import tensorflow as tf
import os


'''Restore the pretrained code LM;
Fine-tune with training data (multi-paths);
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
parser.add_argument('--debug' ,dest='debug', type=bool, default=False)
#parser configurations
args = parser.parse_args()
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


def create_model(bert_config, is_training, 
	input_ids0, input_mask0, segment_ids0, 
	input_ids1, input_mask1, segment_ids1,
	input_ids2, input_mask2, segment_ids2,
	input_ids3, input_mask3, segment_ids3,
	input_ids4, input_mask4, segment_ids4,
	path_mask, labels, num_labels, use_one_hot_embeddings):
	"""Creates a classification model."""
	path0 = modeling.BertModel(
		config=bert_config,
		is_training=is_training,
		input_ids=input_ids0,
		input_mask=input_mask0,
		token_type_ids=segment_ids0,
		use_one_hot_embeddings=use_one_hot_embeddings)

	path1 = modeling.BertModel(
		config=bert_config,
		is_training=is_training,
		input_ids=input_ids1,
		input_mask=input_mask1,
		token_type_ids=segment_ids1,
		use_one_hot_embeddings=use_one_hot_embeddings)

	path2 = modeling.BertModel(
		config=bert_config,
		is_training=is_training,
		input_ids=input_ids2,
		input_mask=input_mask2,
		token_type_ids=segment_ids2,
		use_one_hot_embeddings=use_one_hot_embeddings)

	path3 = modeling.BertModel(
		config=bert_config,
		is_training=is_training,
		input_ids=input_ids3,
		input_mask=input_mask3,
		token_type_ids=segment_ids3,
		use_one_hot_embeddings=use_one_hot_embeddings)

	path4 = modeling.BertModel(
		config=bert_config,
		is_training=is_training,
		input_ids=input_ids4,
		input_mask=input_mask4,
		token_type_ids=segment_ids4,
		use_one_hot_embeddings=use_one_hot_embeddings)
	# In the demo, we are doing a simple classification task on the entire
	# segment.
    #
	# If you want to use the token-level output, use model.get_sequence_output()
	# instead.
	output_layer0 = path0.get_pooled_output() #batch_size * hidden_size
	output_layer1 = path1.get_pooled_output()
	output_layer2 = path2.get_pooled_output()
	output_layer3 = path3.get_pooled_output()
	output_layer4 = path4.get_pooled_output()

	hidden_size = output_layer0.shape[-1].value

	output_weights = tf.get_variable(
		"output_weights", [num_labels, hidden_size],
		initializer=tf.truncated_normal_initializer(stddev=0.02))
	output_bias = tf.get_variable(
		"output_bias", [num_labels], initializer=tf.zeros_initializer())

	with tf.variable_scope("loss"):
		if is_training:
		    # I.e., 0.1 dropout
		    output_layer0 = tf.nn.dropout(output_layer0, keep_prob=0.9)
		    output_layer1 = tf.nn.dropout(output_layer1, keep_prob=0.9)
		    output_layer2 = tf.nn.dropout(output_layer2, keep_prob=0.9)
		    output_layer3 = tf.nn.dropout(output_layer3, keep_prob=0.9)
		    output_layer4 = tf.nn.dropout(output_layer4, keep_prob=0.9)

		logits0 = tf.matmul(output_layer0, output_weights, transpose_b=True)
		logits0 = tf.nn.bias_add(logits0, output_bias)
		logits1 = tf.matmul(output_layer1, output_weights, transpose_b=True)
		logits1 = tf.nn.bias_add(logits1, output_bias)
		logits2 = tf.matmul(output_layer2, output_weights, transpose_b=True)
		logits2 = tf.nn.bias_add(logits2, output_bias)
		logits3 = tf.matmul(output_layer3, output_weights, transpose_b=True)
		logits3 = tf.nn.bias_add(logits3, output_bias)
		logits4 = tf.matmul(output_layer4, output_weights, transpose_b=True)
		logits4 = tf.nn.bias_add(logits4, output_bias) # batch_size * hidden_size
		# pool five logits with path_mask [1, 1, 1, 0, 0] only average the first three
		# path_mask batch_size * 5
		logits = tf.stack([logits0,logits1,logits2,logits3,logits4],axis=1) # batch_size *5*hidden_size
		#set masked position as 0
		path_mask = tf.expand_dims(path_mask,2) #batch_size *5 *1
		path_mask = tf.tile(path_mask,tf.constant([1,1,n_voca])) #batch_size *5 *n_voca
		mask = tf.equal(tf.cast(path_mask,tf.int32), tf.ones_like(path_mask,dtype = tf.int32))
		logits = tf.where(mask,logits,tf.zeros_like(logits)) #batch_size * 5 * n_voca
		logits_sum = tf.reduce_sum(logits, axis=1) #batch_size *n_voca
		logits_ave = tf.math.divide(logits_sum,tf.cast(tf.reduce_sum(path_mask,axis=1),tf.float32)) # batch_size*hidden_size
		

		probabilities = tf.nn.softmax(logits_ave, axis=-1)
		log_probs = tf.nn.log_softmax(logits_ave, axis=-1)

		one_hot_labels = tf.one_hot(labels, depth=num_labels, dtype=tf.float32)
		per_example_loss = -tf.reduce_sum(one_hot_labels * log_probs, axis=-1)
		loss = tf.reduce_mean(per_example_loss)

		return (loss, per_example_loss, logits_ave, probabilities)

def data_reader(input_file,max_len=10,debug=True):
    # read out the raw input

    keys = ['input_ids0','input_mask0','segment_ids0',
    	'input_ids1','input_mask1','segment_ids1',
    	'input_ids2','input_mask2','segment_ids2',
    	'input_ids3','input_mask3','segment_ids3',
    	'input_ids4','input_mask4','segment_ids4',
    	'path_mask', 'label_ids']
    features = dict([(key, []) for key in keys])
    
    

    with open(input_file,'r') as file:
        reader = csv.reader(file)
        next(reader)
        sentences = [[int(i) for i in row[3:]] for row in reader]
    for row in sentences:
    	label_id = row[0]
    	n_path = row[1]
    	path_mask = [True if i < n_path else False for i in range(5)]
    	input_ids0 = row[7 :17]
    	input_mask0 = [1 if i!=0 else 0 for i in input_ids0]
    	segment_ids0 = [0] * max_len
    	input_ids1 = row[17:27]
    	input_mask1 = [1 if i!=0 else 0 for i in input_ids1]
    	segment_ids1 = [0] * max_len
    	input_ids2 = row[27:37]
    	input_mask2 = [1 if i!=0 else 0 for i in input_ids2]
    	segment_ids2 = [0] * max_len
    	input_ids3 = row[37:47]
    	input_mask3 = [1 if i!=0 else 0 for i in input_ids3]
    	segment_ids3 = [0] * max_len
    	input_ids4 = row[47:-1]
    	input_mask4 = [1 if i!=0 else 0 for i in input_ids4]
    	segment_ids4 = [0] * max_len

    	features['input_ids0'].append(list(input_ids0))
    	features['input_mask0'].append(list(input_mask0))
    	features['segment_ids0'].append(segment_ids0)
    	features['input_ids1'].append(list(input_ids1))
    	features['input_mask1'].append(list(input_mask1))
    	features['segment_ids1'].append(segment_ids1)
    	features['input_ids2'].append(list(input_ids2))
    	features['input_mask2'].append(list(input_mask2))
    	features['segment_ids2'].append(segment_ids2)
    	features['input_ids3'].append(list(input_ids3))
    	features['input_mask3'].append(list(input_mask3))
    	features['segment_ids3'].append(segment_ids3)
    	features['input_ids4'].append(list(input_ids4))
    	features['input_mask4'].append(list(input_mask4))
    	features['segment_ids4'].append(segment_ids4)
    	features['path_mask'].append(path_mask)
    	features['label_ids'].append(label_id)
    
    return features

def input_fn_builder(features, is_training):
	"""Creates an `input_fn` closure to be passed to TPUEstimator."""
	all_input_ids0 = features['input_ids0']
	all_input_mask0 = features['input_mask0']
	all_segment_ids0 = features['segment_ids0']
	all_input_ids1 = features['input_ids1']
	all_input_mask1 = features['input_mask1']
	all_segment_ids1 = features['segment_ids1']
	all_input_ids2 = features['input_ids2']
	all_input_mask2 = features['input_mask2']
	all_segment_ids2 = features['segment_ids2']
	all_input_ids3 = features['input_ids3']
	all_input_mask3 = features['input_mask3']
	all_segment_ids3 = features['segment_ids3']
	all_input_ids4 = features['input_ids4']
	all_input_mask4 = features['input_mask4']
	all_segment_ids4 = features['segment_ids4']
	all_path_mask = features['path_mask']
	all_label_ids = features['label_ids']
	seq_length = len(all_input_ids0[0])

	name_to_features = {
    	"input_ids0": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_mask0": tf.FixedLenFeature([seq_length], tf.int64),
    	"segment_ids0": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_ids1": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_mask1": tf.FixedLenFeature([seq_length], tf.int64),
    	"segment_ids1": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_ids2": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_mask2": tf.FixedLenFeature([seq_length], tf.int64),
    	"segment_ids2": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_ids3": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_mask3": tf.FixedLenFeature([seq_length], tf.int64),
    	"segment_ids3": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_ids4": tf.FixedLenFeature([seq_length], tf.int64),
    	"input_mask4": tf.FixedLenFeature([seq_length], tf.int64),
    	"segment_ids4": tf.FixedLenFeature([seq_length], tf.int64),
    	"path_mask": tf.FixedLenFeature([5],tf.int64),
    	"label_ids": tf.FixedLenFeature([], tf.int64),
    	"is_real_example": tf.FixedLenFeature([], tf.int64),
    }

	
	def input_fn(params):
		"""The actual input function."""
		batch_size = params["batch_size"]
		num_examples = len(all_input_ids0)

    	# For training, we want a lot of parallel reading and shuffling.
    	# For eval, we want no shuffling and parallel reading doesn't matter.
		d = tf.data.Dataset.from_tensor_slices({
			"input_ids0":
				tf.constant(all_input_ids0,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_mask0":
				tf.constant(all_input_mask0,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"segment_ids0":
				tf.constant(all_segment_ids0,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_ids1":
				tf.constant(all_input_ids1,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_mask1":
				tf.constant(all_input_mask1,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"segment_ids1":
				tf.constant(all_segment_ids1,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_ids2":
				tf.constant(all_input_ids2,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_mask2":
				tf.constant(all_input_mask2,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"segment_ids2":
				tf.constant(all_segment_ids2,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_ids3":
				tf.constant(all_input_ids3,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_mask3":
				tf.constant(all_input_mask3,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"segment_ids3":
				tf.constant(all_segment_ids3,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_ids4":
				tf.constant(all_input_ids4,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"input_mask4":
				tf.constant(all_input_mask4,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"segment_ids4":
				tf.constant(all_segment_ids4,
					shape=[num_examples,seq_length],
					dtype=tf.int32),
			"path_mask":
				tf.constant(all_path_mask,
					shape=[num_examples,5],
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

		input_ids0 = features["input_ids0"] 
		input_mask0 = features["input_mask0"] 
		segment_ids0 = features["segment_ids0"]
		input_ids1 = features["input_ids1"] 
		input_mask1 = features["input_mask1"] 
		segment_ids1 = features["segment_ids1"]
		input_ids2 = features["input_ids2"] 
		input_mask2 = features["input_mask2"] 
		segment_ids2 = features["segment_ids2"]
		input_ids3 = features["input_ids3"] 
		input_mask3 = features["input_mask3"] 
		segment_ids3 = features["segment_ids3"]
		input_ids4 = features["input_ids4"] 
		input_mask4 = features["input_mask4"] 
		segment_ids4 = features["segment_ids4"]
		path_mask = features["path_mask"]
		label_ids = features["label_ids"]
		is_real_example = None
		if "is_real_example" in features:
			is_real_example = tf.cast(features["is_real_example"], dtype=tf.float32)
		else:
			is_real_example = tf.ones(tf.shape(label_ids), dtype=tf.float32)

		is_training = (mode == tf.estimator.ModeKeys.TRAIN)

		(total_loss, per_example_loss, logits, probabilities) = create_model(bert_config, is_training, 
			input_ids0, input_mask0, segment_ids0,
			input_ids1, input_mask1, segment_ids1,
			input_ids2, input_mask2, segment_ids2,
			input_ids3, input_mask3, segment_ids3,
			input_ids4, input_mask4, segment_ids4,
			path_mask, label_ids, num_labels, use_one_hot_embeddings)

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
	if args.debug:
		num_train_steps_one_epoch = 10
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

