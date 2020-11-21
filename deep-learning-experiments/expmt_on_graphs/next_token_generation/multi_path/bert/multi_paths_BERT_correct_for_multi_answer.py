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
parser.add_argument('--batch_size',dest='batch_size',type=int,default=16)
parser.add_argument('--correct_file', dest='correct_file',type=str, help='The .csv file to store the correct predicted cases')
parser.add_argument('--wrong_file', dest='wrong_file',type = str, help='The .csv file to store the wrong predicted cases')
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
batch_size = args.batch_size
correct_file = args.correct_file
wrong_file = args.wrong_file

output_dir = args.output_dir
n_voca = 4543

if output_dir.endswith('/'):
	output_dir = output_dir.strip()

with open(output_dir+'/'+log,'w') as logfile:
	logfile.write("Correcting accuracy for multiple answers.")
	logfile.write("Data configuration: \n")
	logfile.write("[train_data: {}; test_data: {}; output_dir: {}; correct_file: {}; wrong_file: {}]".format(train_data,test_data,output_dir,correct_file,wrong_file))
	logfile.write("Model configuration: ")
	logfile.write(f"[BERT config: {bert_config}; bert_checkpoint: {bert_checkpoint}]")


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


def model_fn_builder(bert_config, num_labels, init_checkpoint, learning_rate=2e-5,
                     num_train_steps=None, num_warmup_steps=None, use_tpu=False,
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
		predictions = tf.argmax(logits, axis=-1, output_type=tf.int32)
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
				predictions={"input_ids0":input_ids0, "input_ids1":input_ids1, 
					"input_ids2":input_ids2, "input_ids3":input_ids3,
					"input_ids4":input_ids4, "predictions":predictions,
					"labels":label_ids},
				scaffold_fn=scaffold_fn)
		return output_spec

	return model_fn

class MultiAnswerCorrector:
	def __init__(self,train_data):
		self.data_file = train_data
		self.multi_answer_map = dict()

	def hash_instance(self, input_ids0,input_ids1,input_ids2,input_ids3,input_ids4):
		paths = [tuple(input_ids0),tuple(input_ids1),tuple(input_ids2),tuple(input_ids3),tuple(input_ids4)]
		paths.sort()
		paths = tuple(paths)
		# use the tuple direct to save time. If the memory is used up, then use hash.
		# key = hash(paths), return key
		return paths

	def collect_multi_answer_map(self):
		with open(self.data_file,'r') as file:
			reader = csv.reader(file)
			next(reader)
			sentences = [[int(i) for i in row[3:]] for row in reader]
		for row in sentences:
			label_id = row[0]
			input_ids0 = row[7 :17]
			input_ids1 = row[17:27]
			input_ids2 = row[27:37]
			input_ids3 = row[37:47]
			input_ids4 = row[47:-1]
			key = self.hash_instance(input_ids0,input_ids1,input_ids2,input_ids3,input_ids4)
			if key in self.multi_answer_map:
				self.multi_answer_map[key].add(label_id)
			else:
				label_set = set()
				label_set.add(label_id)
				self.multi_answer_map[key] = label_set
    	



	def correct_acc(self, results_iter,output_dir,correct_file,wrong_file,n_predict,predict_file):
		if not self.multi_answer_map:
			self.collect_multi_answer_map()

		n_correct = 0
		n_wrong = 0
		with open(output_dir+'/'+correct_file,'w') as correct_f, open(output_dir+'/'+wrong_file,'w') as wrong_f, open(predict_file,'r') as pred_f:
			correct_writer = csv.writer(correct_f)
			wrong_writer = csv.writer(wrong_f)
			test_reader = csv.reader(predict_f)
			next(test_reader)
			num_written_lines = 0
			for (i, i_result), test_row in zip(enumerate(results_iter),test_reader):
				if i >= num_actual_predict_examples:
					break
				input_ids0 = i_result["input_ids0"]
				input_ids1 = i_result["input_ids1"]
				input_ids2 = i_result["input_ids2"]
				input_ids3 = i_result["input_ids3"]
				input_ids4 = i_result["input_ids4"]
				pred = i_result["predictions"]
				label = i_result["labels"]
				key = self.hash_instance(input_ids0,input_ids1,input_ids2,input_ids3,input_ids4)
				if key not in self.multi_answer_map:
					label_set = set()
					label_set.add(label)
					self.multi_answer_map[key] = label_set
				if label not in self.multi_answer_map[key]:
					self.multi_answer_map[key].add(label)
				#row = tuple(input_ids0) + tuple(input_ids1) + tuple(input_ids2) + tuple(input_ids3) + tuple(input_ids4) + (-111,pred,-222) + tuple(self.multi_answer_map[key])
				row = tuple([int(i) for i in row[10:60]]) + (-111,pred,-222)+tuple(self.multi_answer_map[key])
				#row = tuple(input_0) + tuple(input_1) + tuple(input_2) + tuple(input_3) + tuple(input_4) + (-111,pred,-222) + tuple(self.multi_answer_map[key])
				
				if pred in self.multi_answer_map[key]:
					n_correct += 1
					correct_writer.writerow(row)
				else:
					n_wrong += 1
					wrong_writer.writerow(row)
				num_written_lines += 1
			assert num_written_lines == n_predict
		real_acc = float(n_correct)/float((n_correct+n_wrong))
		return real_acc


bert_config = modeling.BertConfig.from_json_file(bert_config)


# update with train_data
#train_features = data_reader(train_data,10)
#num_train_steps_one_epoch = int(
#	len(train_features['label_ids']) / batch_size)+1
#num_train_steps = int(
#	len(train_features['label_ids']) / batch_size * epoch)
#num_warmup_steps = int(num_train_steps * warmup_proportion)

model_fn = model_fn_builder(
    bert_config=bert_config,
    num_labels=n_voca,
    init_checkpoint=bert_checkpoint)

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

predict_features = data_reader(test_data,10)
num_actual_predict_examples = len(predict_features['label_ids'])
tf.logging.info("***** Running prediction*****")
tf.logging.info("  Num examples = %d ", num_actual_predict_examples)
tf.logging.info("  Batch size = %d", batch_size)
test_input_fn = input_fn_builder(predict_features,is_training=False)



results = estimator.predict(input_fn=test_input_fn)

tf.logging.info("***** Finish prediction *****")
#num_written_lines =0 
#assert i_count == num_actual_predict_examples
#print("Finish prediction for {} cases.".format(i_count)


multi_answer_corrector = MultiAnswerCorrector(train_data)
real_acc = multi_answer_corrector.correct_acc(results,output_dir,correct_file,wrong_file,num_actual_predict_examples,test_data)


with open(output_dir+'/'+log, 'a') as f:
	f.write("The accuracy after correcting for multi-answers: {}".format(real_acc))

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