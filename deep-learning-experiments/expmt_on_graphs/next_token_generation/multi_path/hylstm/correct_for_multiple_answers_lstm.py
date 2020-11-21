
from LSTM_multi_paths import Model, Input_fn
import csv
import tensorflow as tf
import numpy as np 
import argparse

parser = argparse.ArgumentParser()
# output
parser.add_argument('--output_path', dest='output_path', type=str)
parser.add_argument('--logfile',dest='logfile',type=str)
parser.add_argument('--correct_file',dest='correct_file',type=str)
parser.add_argument('--wrong_file',dest='wrong_file',type=str)

# input
parser.add_argument('--embedding_checkpoint_path',dest='embedding_checkpoint_path',type=str)
parser.add_argument('--embedding_checkpoint',dest='embedding_checkpoint',type=str,default='slice2vec_checkpoints')
parser.add_argument('--multi_path_checkpoint_path',dest='multi_path_checkpoint_path',type=str)
parser.add_argument('--multi_path_checkpoint', dest = 'multi_path_checkpoint',type=str,help='The trained LSTM model for single path')
parser.add_argument('--data_path',dest='data_path',type=str)
parser.add_argument('--test_data',dest='test_data',type=str,default='../../data/tasks/slice2vec/test/test1.csv')
parser.add_argument('--train_data',dest='train_data',type=str)

parser.add_argument('--n_voca',dest='n_voca',type=int, default=4543)
parser.add_argument('--n_embedding', dest='n_embedding',type=int,default=300)
parser.add_argument('--lstm_units',dest='lstm_units',type=int,default=256)
parser.add_argument('--batch_size',dest='batch_size',type=int,default=64)
parser.add_argument('--use_embedding',dest='use_embedding',type=int,default=1)
parser.add_argument('--n_embedding_voca', dest='n_embedding_voca', type=int, default=4543,help='In case that it is different from n_voca')
parser.add_argument('--normalized_embedding',dest='normalized_embedding',default=0, type=int)

#parameters

args = parser.parse_args()

logfile = args.output_path+'/'+args.logfile
embedding_checkpoint = args.embedding_checkpoint_path +'/'+args.embedding_checkpoint
multi_path_checkpoint = args.multi_path_checkpoint_path +'/' + args.multi_path_checkpoint
test_file = args.data_path + '/' + args.test_data
train_file = args.data_path + '/' + args.train_data
voca_size = args.n_voca
n_embedding = args.n_embedding
n_embedding_voca = args.n_embedding_voca
normalized_embedding = (args.normalized_embedding==1)
lstm_units = args.lstm_units
use_embedding = (args.use_embedding == 1)
correct_file = args.output_path + '/'+ args.correct_file
wrong_file = args.output_path + '/' + args.wrong_file
batch_size = args.batch_size


with open(logfile,'w') as f_out:
	f_out.write("output_params: ")
	f_out.write(f"[logfile: {logfile}; correct_file: {correct_file}; wrong_file: {wrong_file}]\n")
	f_out.write("Input_params: ")
	f_out.write(f"[embedding_checkpoint: {embedding_checkpoint}; multi_path_checkpoint: {multi_path_checkpoint}; train_data: {train_file}; test_data: {test_file}]\n")
	f_out.write("hyperparams: ")
	f_out.write("use_embedding: {}; use_normalized_embedding: {}; batch_size: {}; lstm_units: {}; n_voca: {}; n_embedding:{}]\n".format(use_embedding,normalized_embedding,batch_size,lstm_units,voca_size,n_embedding))
model = Model(voca_size,n_embedding,embedding_checkpoint,n_embedding_voca,logfile,normalized_embedding)
model.build(lstm_units,use_embedding)
test_input = Input_fn(test_file)
train_input = Input_fn(train_file)
model.test_for_multiple_answers(multi_path_checkpoint=multi_path_checkpoint,test_input=test_input,train_input=train_input,batch_size=batch_size,correct_file=correct_file,wrong_file=wrong_file)

