# coding: utf-8

# In[1]:

'''Restore the trained position weights from order_free_lstm checkpoint'''


# In[38]:

import csv
import tensorflow as tf
import numpy as np
import random
import argparse
from LSTM_oneline import Model as lstm_oneline_model
from LSTM_oneline import Input_fn
from lstm_2_labels import Model as lstm_2_labels_model



parser = argparse.ArgumentParser()
parser.add_argument('--lstm_checkpoint',dest='lstm_checkpoint',type=str,default='../../../checkpoints/tasks/lstm_oneline/lstm_2_labels_dep2vec_050320_explore1')
parser.add_argument('--embedding_checkpoint_path',dest='embedding_checkpoint_path',type=str,default='../../../checkpoints/embedding/slice2vec')
parser.add_argument('--output_path',dest='output_path',type=str, default='../../../output/tasks/lstm_reorder_oneline')
parser.add_argument('--n_voca', dest='n_voca', type=int, default=4543)
parser.add_argument('--n_embedding', dest='n_embedding',type=int, default=300)
parser.add_argument('--lstm_units', dest='lstm_units', type=int, default= 256)
parser.add_argument('--use_embedding', dest='use_embedding', type=int, default=1)
parser.add_argument('--logfile', dest='logfile', type=str)
parser.add_argument('--train_data', dest='train_data', type=str,default='../../../data/tasks/slice2vec/train/training.csv')
parser.add_argument('--test_data',dest='test_data',type=str,default='../../../data/tasks/slice2vec/test/test1.csv')
parser.add_argument('--embedding_checkpoint',dest='embedding_checkpoint',type=str,default='slice2vec_checkpoints')
parser.add_argument('--batch_size',dest='batch_size',type=int,default=128)
parser.add_argument('--normalized_embedding',dest='normalized_embedding',default=0, type=int)
parser.add_argument('--correct_file',dest='correct_file',type=str,default='correct_cases_in_test_explore1.csv')
parser.add_argument('--wrong_file',dest='wrong_file',type=str,default='correct_cases_in_test_explore1.csv')
parser.add_argument('--update_next', dest='update_next', type=int, default=0)
parser.add_argument('--model',dest ='model', type=str, default ='lstm_2_labels')

args = parser.parse_args()









lstm_checkpoint = args.lstm_checkpoint
n_voca = args.n_voca
n_embedding = args.n_embedding
lstm_units = args.lstm_units
use_embedding = (args.use_embedding == 1)
embedding_checkpoint = args.embedding_checkpoint_path+'/'+args.embedding_checkpoint
output_path = args.output_path
logfile = output_path+'/'+args.logfile
normalized_embedding = (args.normalized_embedding==1)
test_file = args.test_data
train_file = args.train_data
correct_file = args.output_path + '/' + args.correct_file
wrong_file = args.output_path + '/' + args.wrong_file
batch_size = args.batch_size
update_next = (args.update_next == 1)
model = args.model


with open(logfile,'w') as file:
    file.write("Parameters:\n")
    file.write("[lstm_checkpoint: {}; train_data: {}; test_data: {}; Use embedding: {}; Embedding checkpoint: {}; Use normalized embedding: {}; Lstm units: {}; batch_size: {}; correct_file: {}; wrong_file: {}]\n"
        .format(lstm_checkpoint,train_file, test_file,use_embedding,embedding_checkpoint,normalized_embedding,lstm_units,batch_size,correct_file,wrong_file))
print("[lstm_checkpoint: {}; Use embedding: {}; Embedding checkpoint: {}; Use normalized embedding: {}; Lstm units: {}; correct_file: {}; wrong_file: {};]\n"
        .format(lstm_checkpoint,use_embedding,embedding_checkpoint,normalized_embedding,lstm_units,correct_file,wrong_file))

if model=='lstm_oneline':
	lstm_model = lstm_oneline_model(voca_size=n_voca,n_embedding=n_embedding,embedding_checkpoint=embedding_checkpoint,n_embedding_voca=n_voca,logfile=logfile)
elif model =='lstm_2_labels':
	lstm_model = lstm_2_labels_model(voca_size=n_voca,n_embedding=n_embedding,embedding_checkpoint=embedding_checkpoint,n_embedding_voca=n_voca,logfile=logfile)
lstm_model.build(lstm_units=lstm_units,use_embedding=use_embedding,update_next=update_next)
test_input = Input_fn(test_file)
train_input = Input_fn(train_file)
lstm_model.test_for_multiple_answers(lstm_checkpoint=lstm_checkpoint,test_input=test_input,train_input=train_input,batch_size=batch_size,correct_file=correct_file,wrong_file=wrong_file)




