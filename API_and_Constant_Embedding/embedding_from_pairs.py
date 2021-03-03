# coding: utf-8

import time

import numpy as np
import tensorflow as tf
import argparse



# Load the embedding_training.txt, a file of neighbor pairs.

from collections import Counter
import random
import math
import re
from collections import Counter




def get_batches(dataPath, file, batch_size):
    ''' Create a generator of word batches as a tuple (inputs, targets) '''
    with open(dataPath+"/"+file,"r") as f:
        count =0
        for line in f:
            if count == 0:
                x, y = [],[]
            count += 1
            line = line.strip()
            pair = line.split()
            id_1 = int(pair[0])
            id_2 = int(pair[1])
            x.append(id_1)
            #x.append(id_2)
            y.append(id_2)
            #y.append(id_1)
            if count == batch_size:
                count = 0
                yield x,y

parser = argparse.ArgumentParser()
parser.add_argument('--training-set-folder', type=str, dest='data_folder', help='data folder mounting point')
parser.add_argument('--neighbor-pair-file',type=str,dest='training_file',help='pairs of neighbors')
parser.add_argument('--model-save-path',type=str,dest='model_save_path',help='path to save the embedding model')
parser.add_argument('--model-name',type=str,dest='model_name',help='embedding model name')
parser.add_argument('--epoch',type=int,dest='epoch',help='how many epoch to train')
parser.add_argument('--batch-size',type=int,dest='batch_size',help='batch size')
args = parser.parse_args()
dataPath = args.data_folder
training_file = args.training_file
modelSavePath = args.model_save_path
model_name = args.model_name
os.makedirs('./'+modelSavePath, exist_ok=True)




    




train_graph = tf.Graph()
with train_graph.as_default():
    inputs = tf.placeholder(tf.int32, [None], name='inputs')
#     labels = tf.placeholder(tf.int32, [None, None], name='labels')
    labels = tf.placeholder(tf.int32, [None, None], name='labels')


# In[10]:

n_vocab = 4542
n_embedding =  300
epochs = args.epoch
batch_size = args.batch_size
#window_size = 5
n_sampled = 100


with train_graph.as_default():
    embedding = tf.Variable(tf.random_uniform((n_vocab, n_embedding), -1, 1))
    embed = tf.nn.embedding_lookup(embedding, inputs) # use tf.nn.embedding_lookup to get the hidden layer output

# Number of negative labels to sample
with train_graph.as_default():
    softmax_w = tf.Variable(tf.truncated_normal((n_vocab, n_embedding))) # create softmax weight matrix here
    softmax_b = tf.Variable(tf.zeros(n_vocab), name="softmax_bias") # create softmax biases here
    
    # Calculate the loss using negative sampling
    loss = tf.nn.sampled_softmax_loss(
        weights=softmax_w,
        biases=softmax_b,
        labels=labels,
        inputs=embed,
        num_sampled=n_sampled,
        num_classes=n_vocab)
    
    cost = tf.reduce_mean(loss)
    optimizer = tf.train.AdamOptimizer().minimize(cost)


# In[12]:

with train_graph.as_default():
    ## From Thushan Ganegedara's implementation
    valid_size = 16 # Random set of words to evaluate similarity on.
    valid_window = 100
    # pick 8 samples from (0,100) and (1000,1100) each ranges. lower id implies more frequent 
    valid_examples = np.array(random.sample(range(valid_window), valid_size//2))
    valid_examples = np.append(valid_examples, 
                               random.sample(range(1000,1000+valid_window), valid_size//2))

    valid_dataset = tf.constant(valid_examples, dtype=tf.int32)
    
    # We use the cosine distance:
    norm = tf.sqrt(tf.reduce_sum(tf.square(embedding), 1, keep_dims=True))
    normalized_embedding = embedding / norm
    valid_embedding = tf.nn.embedding_lookup(normalized_embedding, valid_dataset)
    similarity = tf.matmul(valid_embedding, tf.transpose(normalized_embedding))




with train_graph.as_default():
    saver = tf.train.Saver()

with tf.Session(graph=train_graph) as sess:
    iteration = 1
    loss = 0
    sess.run(tf.global_variables_initializer())

    for e in range(1, epochs+1):
        batches = get_batches(dataPath,training_file, batch_size)
        start = time.time()
        for x, y in batches:
            
            feed = {inputs: x,
                    labels: np.array(y)[:, None]}
            train_loss, _ = sess.run([cost, optimizer], feed_dict=feed)
            
            loss += train_loss
            
            if iteration % 100 == 0: 
                end = time.time()
                print("Epoch {}/{}".format(e, epochs),
                      "Iteration: {}".format(iteration),
                      "Avg. Training loss: {:.4f}".format(loss/100),
                      "{:.4f} sec/batch".format((end-start)/100))
                loss = 0
                start = time.time()
            
            
            
            iteration += 1
    save_path = saver.save(sess, modelSavePath+model_name)