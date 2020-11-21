from bert import modeling
from bert import optimization
import argparse
import csv
import numpy as np
import tensorflow as tf

parser = argparse.ArgumentParser()
parser.add_argument('--bert_checkpoint',dest='bert_checkpoint',type=str,help='The checkpoint to restore for pretrained BERT LM')
parser.add_argument('--bert_config',dest='bert_config',type=str,default = './bert_config.json', help='The .json file to specify the model hyper parameters')
parser.add_argument('--log',dest='log',type=str,default = 'log.txt', help='The .txt file to record configuration and results')
parser.add_argument('--output_dir',dest='output_dir',type=str, help='The dir to store checkpoint, log')
parser.add_argument('--train_data',dest='train_data',type=str,help='The .csv file of training sequences')
parser.add_argument('--test_data',dest='test_data',type=str, help ='The .csv file of test sequences')
parser.add_argument('--batch_size',dest='batch_size',default = 64, type=int,help='The batch_size for training and testing')

args = parser.parse_args()
bert_checkpoint = args.bert_checkpoint
bert_config = args.bert_config
train_data = args.train_data
test_data = args.test_data
log = args.log
batch_size = args.batch_size
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
		pred = tf.argmax(probabilities,axis=-1)
		log_probs = tf.nn.log_softmax(logits, axis=-1)

		one_hot_labels = tf.one_hot(labels, depth=num_labels, dtype=tf.float32)
		per_example_loss = -tf.reduce_sum(one_hot_labels * log_probs, axis=-1)
		loss = tf.reduce_mean(per_example_loss)

		return (loss, per_example_loss, logits, probabilities,pred)

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

		(total_loss, per_example_loss, logits, probabilities,pred) = create_model(
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
				predictions={"input_ids":input_ids,"input_mask":input_mask,"pred": pred,"probabilities": probabilities},
				scaffold_fn=scaffold_fn)
		return output_spec

	return model_fn
def collect_multiple_answers(features,test_features):
	multi_answers = dict()
	for input_ids, input_mask, segment_ids, label in zip(features['input_ids'], features['input_mask'], features['segment_ids'],features['label_ids']):
		inputs = tuple(input_ids)+tuple(input_mask)
		if inputs in multi_answers:
			multi_answers[inputs].add(label)
		else:
			labels = set()
			labels.add(label)
			multi_answers[inputs] = labels
	for input_ids, input_mask, label in zip(test_features['input_ids'], test_features['input_mask'],test_features['label_ids']):
		inputs = tuple(input_ids)+tuple(input_mask)
		if inputs in multi_answers:
			multi_answers[inputs].add(label)
		else:
			labels = set()
			labels.add(label)
			multi_answers[inputs] = labels
	return multi_answers

bert_config = modeling.BertConfig.from_json_file(bert_config)

model_fn = model_fn_builder(
    bert_config=bert_config,
    num_labels=n_voca,
    init_checkpoint=bert_checkpoint,
    learning_rate=0,
    num_train_steps=0,
    num_warmup_steps=0)

run_config = tf.contrib.tpu.RunConfig(
	cluster=None,
	master=None,
	model_dir=output_dir,
	save_checkpoints_steps=10,
	tpu_config=tf.contrib.tpu.TPUConfig(
		iterations_per_loop=1000,
		num_shards=8,
		per_host_input_for_training=tf.contrib.tpu.InputPipelineConfig.PER_HOST_V2))
estimator = tf.contrib.tpu.TPUEstimator(
      use_tpu=False,
      model_fn=model_fn,
      config=run_config,
      train_batch_size=batch_size,
      eval_batch_size=batch_size,
      predict_batch_size=batch_size)

predict_features = data_reader(test_data,10)
num_actual_predict_examples = len(predict_features['label_ids'])
predict_input_fn = input_fn_builder(predict_features,False)
print("Start prediction.")
result = estimator.predict(input_fn=predict_input_fn)
num_written_lines = 0

train_features = data_reader(train_data,10)
multi_answers = collect_multiple_answers(train_features, predict_features)
n_correct = 0
n_wrong = 0
print("Start writing correct and failed cases.")
with open(output_dir+'/'+'corrected_cases.csv','w') as corrected, open(output_dir+'/'+'failed_cases.csv','w') as failed:
	corrected_writer = csv.writer(corrected)
	failed_writer = csv.writer(failed)
	for (i, prediction) in enumerate(result):
		
		if i >= num_actual_predict_examples:
			break
		pred = prediction["pred"]
		input_ids = prediction["input_ids"]
		input_mask = prediction["input_mask"]
		inputs = tuple(input_ids)+tuple(input_mask)
		record = list(inputs)
		record.append(-111)
		record.append(pred)
		record.append(-222)
		record.append([i for i in multi_answers[inputs]])
		if pred in multi_answers[inputs]:
			n_correct += 1
			corrected_writer.writerow(record)
		else:
			n_wrong += 1
			failed_writer.writerow(record)

acc = float(n_correct)/float(n_correct+n_wrong)
print("Accuracy after multi-answer correction: {}".format(acc))
with open(output_dir+'/'+log,'a') as logfile:
	logfile.write("Accuracy after multi-answer correction: {}\n".format(acc))
