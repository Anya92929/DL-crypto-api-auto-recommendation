
# coding: utf-8

# In[1]:

import tensorflow as tf
from datetime import datetime
import numpy as np
import csv
import argparse


#import bert
#from bert import run_classifier
from bert import optimization
from bert import modeling



parser = argparse.ArgumentParser(description='Process some integers.')
parser.add_argument('--output_dir', dest ='output_dir', type=str, default = '../output',
                    help='place to store checkpoints')
parser.add_argument('--batch_size', dest='batch_size', type=int, default = 32, 
                    help='batch size in training')
parser.add_argument('--lr', dest ='lr', type=float, default = 2e-5)
parser.add_argument('--epoch', dest = 'epoch', type=int, default=10)

parser.add_argument('--warmup_proportion', dest='warmup_proportion', type=float, default=0.1)
parser.add_argument('--save_checkpoints_steps', dest='save_checkpoints_steps', type=int, default=1000)
parser.add_argument('--save_summary_steps', dest='save_summary_steps', type=int, default=100)
parser.add_argument('--bert_config', dest='bert_config', type=str, default='./bert_config.json')
parser.add_argument('--train_data', dest='train_data', type=str, default='../../data/tasks/dep2vec/train/dependency_traces_training_ordered.csv')
parser.add_argument('--test_data', dest='test_data', type=str, default='../../data/tasks/dep2vec/test/dependency_traces_test.csv')
parser.add_argument('--logfile', dest='logfile', type=str, default='../output/evaluation_log.txt')

args = parser.parse_args()
# In[3]:

OUTPUT_DIR = args.output_dir



# Compute train and warmup steps from batch size
# These hyperparameters are copied from this colab notebook (https://colab.sandbox.google.com/github/tensorflow/tpu/blob/master/tools/colab/bert_finetuning_with_cloud_tpus.ipynb)
BATCH_SIZE = args.batch_size
LEARNING_RATE = args.lr
NUM_TRAIN_EPOCHS = args.epoch
# Warmup is a period of time where hte learning rate 
# is small and gradually increases--usually helps training.
WARMUP_PROPORTION = args.warmup_proportion
# Model configs
SAVE_CHECKPOINTS_STEPS = args.save_checkpoints_steps
SAVE_SUMMARY_STEPS = args.save_summary_steps

tf.logging.set_verbosity(tf.logging.INFO)
# In[4]:

def gather_indexes(sequence_tensor, positions):
    """Gathers the vectors at the specific positions over a minibatch."""
    sequence_shape = modeling.get_shape_list(sequence_tensor, expected_rank=3)
    
    batch_size = sequence_shape[0]
    seq_length = sequence_shape[1]
    width = sequence_shape[2]
    
    flat_offsets = tf.reshape(
        tf.range(0, batch_size, dtype=tf.int32) * seq_length, [-1, 1])
    flat_positions = tf.reshape(positions + flat_offsets, [-1])
    flat_sequence_tensor = tf.reshape(sequence_tensor,
                                    [batch_size * seq_length, width])
    output_tensor = tf.gather(flat_sequence_tensor, flat_positions)
    return output_tensor


# In[5]:

def get_lm_output(bert_config, input_tensor, output_weights, positions,
                         label_ids, label_weights):
    """Get loss and log probs for the masked LM."""
    input_tensor = gather_indexes(input_tensor, positions)
    
    with tf.variable_scope("cls/predictions"):
        # We apply one more non-linear transformation before the output layer.
        # This matrix is not used after pre-training.
        with tf.variable_scope("transform"):
            input_tensor = tf.layers.dense(
                input_tensor,
                units=bert_config.hidden_size,
                activation=modeling.get_activation(bert_config.hidden_act),
                kernel_initializer=modeling.create_initializer(
                    bert_config.initializer_range))
            input_tensor = modeling.layer_norm(input_tensor)

        # The output weights are the same as the input embeddings, but there is
        # an output-only bias for each token.
        output_bias = tf.get_variable(
            "output_bias",
            shape=[bert_config.vocab_size],
            initializer=tf.zeros_initializer())
        logits = tf.matmul(input_tensor, output_weights, transpose_b=True)
        logits = tf.nn.bias_add(logits, output_bias)
        
        log_probs = tf.nn.log_softmax(logits, axis=-1)
        predicted_labels = tf.squeeze(tf.argmax(log_probs, axis=-1, output_type=tf.int32)) #batch_size * num_mask
        
        #accuracy = tf.metrics.accuracy(label_ids,predicted_labels,label_weights)
        label_ids = tf.reshape(label_ids, [-1])
        pred = tf.reshape(predicted_labels, [-1])
        correctPred = tf.equal(tf.cast(pred,tf.int64),tf.cast(label_ids,tf.int64))
        mask = tf.reshape(label_weights,[-1])
        correctPred = tf.boolean_mask(correctPred, mask)
        accuracy = tf.reduce_mean(tf.cast(correctPred,tf.float32))
        
        

        label_weights = tf.reshape(label_weights, [-1])

        one_hot_labels = tf.one_hot(
            label_ids, depth=bert_config.vocab_size, dtype=tf.float32)

        # The `positions` tensor might be zero-padded (if the sequence is too
        # short to have the maximum number of predictions). The `label_weights`
        # tensor has a value of 1.0 for every real prediction and 0.0 for the
        # padding predictions.
        per_example_loss = -tf.reduce_sum(log_probs * one_hot_labels, axis=[-1])
        numerator = tf.reduce_sum(label_weights * per_example_loss)
        denominator = tf.reduce_sum(label_weights) + 1e-5
        loss = numerator / denominator
    
    return (loss, predicted_labels, log_probs, accuracy)


# In[6]:

def create_model(mode, input_ids, input_mask, segment_ids, masked_lm_positions, masked_lm_ids, masked_lm_weights, use_one_hot_embeddings):
    """Creates a classification model."""
    is_training = (mode==tf.estimator.ModeKeys.TRAIN)
    is_evaluating = (mode==tf.estimator.ModeKeys.EVAL)
    model = modeling.BertModel(
        config=bert_config,
        is_training=is_training,
        input_ids=input_ids,
        input_mask=input_mask,
        token_type_ids=segment_ids,
        use_one_hot_embeddings=use_one_hot_embeddings)
    
    (lm_loss, lm_predicted_labels, lm_log_probs, lm_accuracy) = get_lm_output(
         bert_config, model.get_sequence_output(), model.get_embedding_table(),
         masked_lm_positions, masked_lm_ids, masked_lm_weights)

    if is_training or is_evaluating:
        return (lm_loss, lm_predicted_labels, lm_log_probs, lm_accuracy)
    else:
        return (lm_predicted_labels,lm_log_probs)


# In[7]:

# model_fn_builder actually creates our model function
# using the passed parameters for num_labels, learning_rate, etc.
def model_fn_builder(bert_config, learning_rate,
                     num_train_steps, num_warmup_steps, use_tpu=False,
                     use_one_hot_embeddings=True):
    """Returns `model_fn` closure for TPUEstimator."""
    def model_fn(features, labels, mode, params):  # pylint: disable=unused-argument
        """The `model_fn` for TPUEstimator."""

        input_ids = features["input_ids"]
        input_mask = features["input_mask"]
        segment_ids = features["segment_ids"]
        masked_lm_positions = features["masked_lm_positions"]
        masked_lm_ids = features["masked_lm_ids"]
        masked_lm_weights = features["masked_lm_weights"]

        is_predicting = (mode == tf.estimator.ModeKeys.PREDICT)
        is_training = (mode==tf.estimator.ModeKeys.TRAIN)
        # TRAIN and EVAL
        if not is_predicting:
        
            (loss, predicted_labels, log_probs, accuracy) = create_model(
                mode, input_ids, input_mask, segment_ids, masked_lm_positions, masked_lm_ids, masked_lm_weights, use_one_hot_embeddings)
        
            train_op = optimization.create_optimizer(
                loss, learning_rate, num_train_steps, num_warmup_steps, use_tpu=False)
        
             #Calculate evaluation metrics. 
            def metric_fn(label_ids, predicted_labels,sample_weights):
                #label_ids = tf.reshape(label_ids,[-1])
                predicted_labels = tf.reshape(predicted_labels,[tf.shape(label_ids)[0],-1])
                accuracy = tf.metrics.accuracy(label_ids, predicted_labels,sample_weights)
                
                return {
                    "eval_accuracy": accuracy
                }
            
            eval_metrics = metric_fn(masked_lm_ids, predicted_labels,masked_lm_weights)
            if mode == tf.estimator.ModeKeys.TRAIN:
                #label_ids = tf.reshape(masked_lm_ids, [-1])
                #accuracy = tf.metrics.accuracy(label_ids, predicted_labels)
                logging_hook = tf.train.LoggingTensorHook({"ya:train loss" : loss, "ya:train accuracy": accuracy}, every_n_iter=1)
                return tf.estimator.EstimatorSpec(mode=tf.estimator.ModeKeys.TRAIN,
                    loss=loss,
                    train_op=train_op, training_hooks = [logging_hook])
            else:
                return tf.estimator.EstimatorSpec(mode=mode,
                    loss=loss,
                    eval_metric_ops=eval_metrics)
        else:
            (predicted_labels, log_probs) = create_model(
                is_training, input_ids, input_mask, segment_ids, masked_lm_positions, masked_lm_ids, masked_lm_weights, use_one_hot_embeddings)
            predictions = {
              'probabilities': log_probs,
              'labels': predicted_labels
            }
            return tf.estimator.EstimatorSpec(mode, predictions=predictions)

    # Return the actual model function in the closure
    return model_fn


# In[8]:

# Specify output directory and number of checkpoint steps to save
run_config = tf.estimator.RunConfig(
    model_dir=OUTPUT_DIR,
    save_summary_steps=SAVE_SUMMARY_STEPS,
    save_checkpoints_steps=SAVE_CHECKPOINTS_STEPS)


# In[9]:
bert_config_file = args.bert_config
bert_config = modeling.BertConfig.from_json_file(bert_config_file)


def str_list_to_num(row_input, to_int=True):
    row = row_input[1:-1]
    row = row.split(',')
    if to_int:
        row = [int(i) for i in row]
    else:
        row = [float(i) for i in row]
    return row

def data_reader(input_file,debug=True):
    # read out the raw input
    with open(input_file,'r') as file:
        reader = csv.reader(file)
        header = next(reader)
        sentences = [row for row in reader]
    keys = ['input_ids','input_mask','segment_ids', 'masked_lm_positions', 'masked_lm_ids','masked_lm_weights']
    features = dict([(key, []) for key in header])
    
    for row in sentences:
        
        input_ids = str_list_to_num(row[0])
        segment_ids = str_list_to_num(row[1])
        input_mask = str_list_to_num(row[2])
        masked_lm_positions = str_list_to_num(row[3])
        masked_lm_ids = str_list_to_num(row[4])
        masked_lm_weights = str_list_to_num(row[5],False)
        
        features['input_ids'].append(list(input_ids))
        features['input_mask'].append(list(input_mask))
        features['segment_ids'].append(segment_ids)
        features['masked_lm_positions'].append(masked_lm_positions)
        features['masked_lm_ids'].append(masked_lm_ids)
        features['masked_lm_weights'].append(masked_lm_weights)
    
    return features
        
        
    



def input_fn_builder(features, is_training):
  """Creates an `input_fn` closure to be passed to TPUEstimator."""

  all_input_ids = features['input_ids']
  all_input_mask = features['input_mask']
  all_segment_ids = features['segment_ids']
  all_masked_lm_positions = features['masked_lm_positions']
  all_masked_lm_ids = features['masked_lm_ids']
  all_masked_lm_weights = features['masked_lm_weights']

  seq_length = len(all_input_ids[0])
  n_masked = len(all_masked_lm_positions[0])
  def input_fn(params):
    """The actual input function."""
    batch_size = params["batch_size"]

    num_examples = len(all_input_ids)


    # This is for demo purposes and does NOT scale to large data sets. We do
    # not use Dataset.from_generator() because that uses tf.py_func which is
    # not TPU compatible. The right way to load data is with TFRecordReader.
    d = tf.data.Dataset.from_tensor_slices({
        "input_ids":
            tf.constant(
                all_input_ids, shape=[num_examples, seq_length],
                dtype=tf.int32),
        "input_mask":
            tf.constant(
                all_input_mask,
                shape=[num_examples, seq_length],
                dtype=tf.int32),
        "segment_ids":
            tf.constant(
                all_segment_ids,
                shape=[num_examples, seq_length],
                dtype=tf.int32),
        "masked_lm_positions":
            tf.constant(all_masked_lm_positions, shape=[num_examples,n_masked], dtype=tf.int32),
        "masked_lm_ids":
            tf.constant(all_masked_lm_ids, shape=[num_examples,n_masked], dtype=tf.int32),
        "masked_lm_weights":
            tf.constant(all_masked_lm_weights, shape = [num_examples,n_masked], dtype=tf.float32),
    })

    if is_training:
      d = d.repeat()
      d = d.shuffle(buffer_size=100)

    d = d.batch(batch_size=batch_size)
    return d

  return input_fn



train_data = args.train_data
train_feature_reader = data_reader(train_data)
train_input_fn = input_fn_builder(train_feature_reader, is_training=True)



# Compute # train and warmup steps from batch size
num_epoch_steps = len(train_feature_reader['input_ids'])/BATCH_SIZE+1
num_train_steps = int(len(train_feature_reader['input_ids']) / BATCH_SIZE * NUM_TRAIN_EPOCHS)
num_warmup_steps = int(num_train_steps * WARMUP_PROPORTION)


# In[33]:

print(len(train_feature_reader['input_ids']))


# In[14]:

model_fn = model_fn_builder(bert_config,  
                            learning_rate=LEARNING_RATE,
                            num_train_steps=num_train_steps, 
                            num_warmup_steps=num_warmup_steps, 
                            use_tpu=False,
                            use_one_hot_embeddings=True)

estimator = tf.estimator.Estimator(
  model_fn=model_fn,
  config=run_config,
  params={"batch_size": BATCH_SIZE})



print(f'Beginning Training!')
current_time = datetime.now()
#train_spec = tf.estimator.TrainSpec(input_fn=train_input_fn, max_steps=num_train_steps)
test_data = args.test_data
test_feature_reader = data_reader(test_data)
test_input_fn = input_fn_builder(test_feature_reader,is_training=False)
#eval_spec = tf.estimator.EvalSpec(input_fn=test_input_fn)

#tf.estimator.train_and_evaluate(estimator, train_spec, eval_spec)
for i in range(0,int(num_train_steps),int(num_epoch_steps)):
    estimator.train(input_fn=train_input_fn, steps=num_epoch_steps)
    print("Training for one epoch took time ", datetime.now() - current_time)
    print(f'Sitart test!')
    metrics=estimator.evaluate(input_fn=test_input_fn,steps=None)
    print("Metrics: ",end=' ')
    print(metrics)
    with open(args.logfile,'a') as file:
        file.write("Global step: {}, eval_accuracy: {}, loss: {}\n".format(metrics['global_step'], metrics['eval_accuracy'], metrics['loss']))
print(f'Finish training')
print("Training epoch took time ", datetime.now() - current_time)




