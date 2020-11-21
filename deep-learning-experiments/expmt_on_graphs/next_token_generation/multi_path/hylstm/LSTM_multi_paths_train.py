
# coding: utf-8

# In[1]:

'''Retrieve trained model, return accuracy on test set, split on sequence length'''


# In[1]:

import csv
import tensorflow as tf
import numpy as np
import random
import argparse
import pandas as pd
from LSTM_multi_paths import Model

parser = argparse.ArgumentParser()
# output
parser.add_argument('--output_path', dest='output_path', type=str)
parser.add_argument('--logfile',dest='logfile',type=str)
parser.add_argument('--save_checkpoint',dest='save_checkpoint',type=str,help='name of the checkpoint files')

#input
parser.add_argument('--embedding_checkpoint_path',dest='embedding_checkpoint_path',type=str)
parser.add_argument('--embedding_checkpoint',dest='embedding_checkpoint',type=str,default='slice2vec_checkpoints')
parser.add_argument('--path_checkpoint_path',dest='path_checkpoint_path',type=str)
parser.add_argument('--path_checkpoint', dest = 'path_checkpoint',type=str,help='The trained LSTM model for single path')
parser.add_argument('--data_path',dest='data_path',type=str)
parser.add_argument('--test_data',dest='test_data',type=str,default='../../data/tasks/slice2vec/test/test1.csv')
parser.add_argument('--train_data',dest='train_data',type=str)

#parameters
parser.add_argument('--n_voca',dest='n_voca',type=int, default=4543)
parser.add_argument('--n_embedding', dest='n_embedding',type=int,default=300)
parser.add_argument('--lstm_units',dest='lstm_units',type=int,default=256)
parser.add_argument('--epoch', dest='epoch', type=int, default=10)
parser.add_argument('--batch_size',dest='batch_size',type=int,default=64)
parser.add_argument('--use_embedding',dest='use_embedding',type=int,default=1)
parser.add_argument('--n_embedding_voca', dest='n_embedding_voca', type=int, default=4543,help='In case that it is different from n_voca')
parser.add_argument('--normalized_embedding',dest='normalized_embedding',default=0, type=int)

parser.add_argument('--debug_file_in',dest='debug_file_in', type=str, default = './multi_paths_data.csv')
#parser.add_argument('--update_next', dest='update_next',type=int, default=0)
#parser.add_argument('--correct_file',dest='correct_file',type=str,default='../../output/correct_samples.csv')
#parser.add_argument('--wrong_file',dest='wrong_file',type=str,default='../../output/wrong_samples.csv')


args = parser.parse_args()


# In[33]:

#output
save_checkpoint = args.output_path+'/'+args.save_checkpoint+'/'+args.save_checkpoint
logfile = args.output_path + '/'+ args.logfile

#input
test_file = args.data_path+'/'+args.test_data
train_file = args.data_path+'/'+args.train_data
embedding_checkpoint = args.embedding_checkpoint_path+'/'+args.embedding_checkpoint
lstm_checkpoint = args.path_checkpoint_path+'/'+args.path_checkpoint

#parameters
n_voca = args.n_voca
n_embedding = args.n_embedding
lstm_units = args.lstm_units
epoch = args.epoch
batch_size = args.batch_size
use_embedding = (args.use_embedding==1)
normalized_embedding = (args.normalized_embedding==1)


with open(logfile,'w') as f:
    f.write("Output: ")
    f.write(f"[logfile: {logfile}; save_checkpoint: {save_checkpoint}]\n")
    f.write("Input: ")
    f.write(f"training_data: {train_file}; testing_data: {test_file}; token_embedding_checkpoint: {embedding_checkpoint}; path_checkpoint: {lstm_checkpoint}\n")
    f.write("Parameters: ")
    f.write("[Use token embedding: {}; Use normalized_token_embedding: {}; lstm_units: {}; epoch: {}; batch_size: {}; n_embedding: {}; n_voca: {}]\n"
        .format(use_embedding, normalized_embedding, lstm_units, epoch,batch_size, n_embedding, n_voca))

print("parameters:")
print("[train_data: {}; test_data: {}; Use embedding: {}; Embedding_checkpoint: {};  epoch: {}; batch_size: {}; save_checkpoint: {}]"
        .format(train_file,test_file,use_embedding,embedding_checkpoint,epoch,batch_size,save_checkpoint))



lstm_model = Model(voca_size=n_voca,n_embedding=n_embedding,embedding_checkpoint=embedding_checkpoint,n_embedding_voca=args.n_embedding_voca,logfile=logfile,normalized_embedding=normalized_embedding)


lstm_model.build(lstm_units,use_embedding=use_embedding)


df_file = args.debug_file_in

test_input = Input_fn(test_file)
train_input = Input_fn(train_file)


lstm_model.train_and_test(train_input,test_input,epoch,batch_size,lstm_checkpoint,save_checkpoint)

#lstm_model.fine_tune_with_a_new_layer(lstm_checkpoint,train_input,test_input,epoch,batch_size,save_checkpoint)




