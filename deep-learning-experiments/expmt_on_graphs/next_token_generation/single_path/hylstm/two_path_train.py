
# coding: utf-8

# In[1]:

'''Original LSTM sequence + order-free LSTM sequence'''


# In[1]:

import csv
import tensorflow as tf
import numpy as np
import random
import argparse

parser = argparse.ArgumentParser()
parser.add_argument('--data_path',dest='data_path',type=str,default='../../data/tasks/slice2vec')
parser.add_argument('--embedding_checkpoint_path',dest='embedding_checkpoint_path',type=str,default=None)
parser.add_argument('--output_path',dest='output_path',type=str, default='../../logs')
parser.add_argument('--n_voca', dest='n_voca', type=int, default=4543)
parser.add_argument('--n_embedding', dest='n_embedding',type=int, default=300)
parser.add_argument('--lstm_units', dest='lstm_units', type=int, default= 256)
parser.add_argument('--epoch', dest='epoch', type=int, default=10)
parser.add_argument('--batch_size', dest='batch_size', type=int, default=64)
parser.add_argument('--use_embedding', dest='use_embedding', type=int, default=0)
parser.add_argument('--logfile', dest='logfile', type=str)
parser.add_argument('--train_data', dest='train_data',type=str,default='training.csv')
parser.add_argument('--test_data',dest='test_data',type=str,default='test1.csv')
parser.add_argument('--embedding_checkpoint',dest='embedding_checkpoint',type=str,default='slice2vec_checkpoints')
parser.add_argument('--save_checkpoint',dest='save_checkpoint',type=str,help='name of the checkpoint files')
parser.add_argument('--normalized_embedding',dest='normalized_embedding',default=0, type=int)
parser.add_argument('--regular_order_initial',dest='regular_order_initial',default=1, type=int)


args = parser.parse_args()

#lstm_checkpoint = '../../checkpoints/tasks/lstm_oneline/slice2vec/lstm_no_embedding_checkpoint'
n_voca = args.n_voca
n_embedding = args.n_embedding
lstm_units = args.lstm_units
epoch = args.epoch
batch_size = args.batch_size
use_embedding = (args.use_embedding == 1)
test_file = args.data_path+'/'+args.test_data
train_file = args.data_path+'/'+args.train_data
embedding_checkpoint = args.embedding_checkpoint_path+'/'+args.embedding_checkpoint
logfile = args.output_path+'/'+args.logfile
save_checkpoint = args.output_path+'/'+args.save_checkpoint+'/'+args.save_checkpoint
normalized_embedding = (args.normalized_embedding==1)
regular_order_initial = (args.regular_order_initial==1)

with open(logfile,'w') as log:
    log.write("Using Parameters:\n")
    log.write("[save_checkpoint: {}; train_data: {}; test_data: {}; use_embedding: {}; embedding_checkpoint: {}; normalized_embedding: {}; regular_order_initial:{}; lstm_units: {}; epoch: {}; batch_size: {}]\n"
        .format(save_checkpoint,train_file, test_file, use_embedding,embedding_checkpoint,normalized_embedding,regular_order_initial,lstm_units,epoch,batch_size))

class Input_fn:
    def __init__(self,data_file):
        if data_file.endswith('.csv'):
            with open(data_file,'r') as f:
                reader = csv.reader(f)
                self._data = [[int(i) for i in row] for row in reader]
        else:
            raise ValueError
        self.pad_id = 0
        self.max_window_steps = 10
        self.n_data = len(self._data)
        self.order_data_by_length()
        #self.embedding_mat=self.retrieve_embedding(dataPath+modelfile,n_embedding,n_voca)
        
    def order_data_by_length(self):
        self._data_by_length = {}
        for i in range(self.max_window_steps+1):
            self._data_by_length[i] = []
        for row in self._data:
            leng = len(row)-1
            if leng>10:
                leng = 10
            self._data_by_length[leng].append(row)
    
    def get_batches_for_length(self, batch_size,leng):
        _data = self._data_by_length[leng]
        print("Data for length {}: {}".format(leng,len(_data)))
        return self.get_batches_from_data(_data,batch_size)
        
    
    
        
    def get_batches(self,batch_size):
        return self.get_batches_from_data(self._data,batch_size)
   
      
    def get_batches_from_data(self,data,batch_size):
        counter = 0
        input_seq = []
        output_label = []
        
    
        for row in data:
            
            if len(row) >1:
                if counter == 0:
                    input_seq = []
                    output_label = []
                if len(row)> 11:
                    row = row[-11:]
                input_seq.append(row[:-1])
                output_label.append(row[1:])
                counter += 1
            if counter == batch_size:
                counter = 0
                input_padded = self.padding(input_seq,0,self.max_window_steps)
                output_padded = self.padding(output_label,0,self.max_window_steps)
                label_len = np.array([len(i) for i in output_label])
                yield input_padded, label_len,output_padded
        input_padded = self.padding(input_seq,0,self.max_window_steps)
        output_padded = self.padding(output_label,0,self.max_window_steps)
        label_len = np.array([len(i) for i in output_label])
        yield input_padded, label_len,output_padded
        
    def pre_padding(self, tensor,fix_leng=None):
        padded = list()
        tensor_len = [len(i) for i in tensor]
        if fix_leng:
        	time_step = fix_leng
        else:
        	time_step = max(tensor_len)
        for i in tensor:
            new_in = np.pad(i,[(time_step-len(i),0)],'constant',constant_values=(self.pad_id,0))
            padded.append(new_in)
        return padded
        
    def post_padding(self, tensor,fix_leng=None):
        
        #print(self.pad_id)
        tensor_len = [len(i) for i in tensor]
        if fix_leng:
        	time_step = fix_leng
        else:
        	time_step = max(tensor_len)
        padded = []
        for row in tensor:
            new_in = np.pad(row,[(0,time_step-len(row))],'constant',constant_values=(0,self.pad_id))
            padded.append(new_in)
        padded = np.array(padded)
        return padded
        
    def padding(self,inputs,mode=0,fix_leng=None):
        '''if mode = 0, post_padding;
           if mode = 1, pre_padding'''
        if mode == 0:
            padded = self.post_padding(inputs,fix_leng)
        else:
            padded = self.pre_padding(inputs,fix_leng)
        return padded


# In[19]:

class Model:
    def __init__(self,voca_size,n_embedding,embedding_checkpoint, normalized_embedding,logfile):
        self.n_voca = voca_size
        self.n_embedding = n_embedding
        self.logfile=logfile
        if embedding_checkpoint:
            self.embedding_mat = self.get_embedding_mat(embedding_checkpoint,normalized_embedding)
        else:
            self.embedding_mat = None
        #self.data_helper= data_helper
        tf.reset_default_graph()
        
    def get_embedding_mat(self, embedding_checkpoint, normalized=False):
        n_sampled = 100

        # Build Traning Graph
        train_graph = tf.Graph()
        with train_graph.as_default():
            inputs = tf.placeholder(tf.int32, [None], name='inputs')  # layer 1
            labels = tf.placeholder(tf.int32, [None, None], name='labels')  # layer 3

            
            embedding = tf.Variable(tf.random_uniform((self.n_voca, self.n_embedding), -1, 1))
            embed = tf.nn.embedding_lookup(embedding,
                                           inputs)  # use tf.nn.embedding_lookup to get the hidden layer output

            softmax_w = tf.Variable(tf.truncated_normal((self.n_voca, n_embedding)))  # create softmax weight matrix here
            softmax_b = tf.Variable(tf.zeros(self.n_voca), name="softmax_bias")  # create softmax biases here

            # Calculate the loss using negative sampling
            loss = tf.nn.sampled_softmax_loss(
                weights=softmax_w,
                biases=softmax_b,
                labels=labels,
                inputs=embed,
                num_sampled=n_sampled,
                num_classes=self.n_voca)

            cost = tf.reduce_mean(loss)
            optimizer = tf.train.AdamOptimizer().minimize(cost)

           
            # We use the cosine distance:
            norm = tf.sqrt(tf.reduce_sum(tf.square(embedding), 1, keepdims=True))
            normalized_embedding = embedding / norm
            
            # API_Voca=[]
            with train_graph.as_default():
                saver = tf.train.Saver()
            with tf.Session(graph=train_graph) as sess:
                saver.restore(sess, tf.train.latest_checkpoint(embedding_checkpoint))
                with open(logfile,'a') as f:
                    f.write(f"Restore embedding from checkpoint {embedding_checkpoint}\n")
                if not normalized:
                    embed_mat = sess.run(embedding)
                else:
                    embed_mat = sess.run(normalized_embedding)
                return embed_mat
   
        
    def build(self,lstm_units,use_embedding=False,update_next=False,max_step=10,regular_order_initial=True):
        #graph build        
        self.outputs = tf.placeholder(tf.int32, [None,None],name='output_layer') #batch_size * time_steps
        self.inputs = tf.placeholder(tf.int32, [None, None],name='input_layer')
        self.target_len = tf.placeholder(tf.int32,[None],name='target_length')
        n_time_step = tf.reduce_max(self.target_len)
        # task-specific embedding
        #print_op = tf.print("tensors:", {'outputs': outputs},output_stream=sys.stdout)
        #with tf.control_dependencies([print_op]):
        #embedding_mat = tf.Variable(tf.truncated_normal([self.n_voca,n_embedding]), name="task-specific-embedding-mat")
        #embedding_vec = tf.fill(tf.stack([tf.shape(inputs)[0],max_len, embed_size]),0.0)
        if use_embedding:
            embedding_vec = tf.nn.embedding_lookup(self.embedding_mat,self.inputs)
        else:
            # one-hot encoding        
            embedding_vec = tf.one_hot(self.inputs,self.n_voca,axis=-1)
        
        # original lstm path:
        lstmCell = tf.contrib.rnn.MultiRNNCell([tf.contrib.rnn.BasicLSTMCell(lstm_units),tf.contrib.rnn.BasicLSTMCell(lstm_units)])
        '''hidden_output is the output vectors of lstm cells [batch_size * time_steps * lstm_units]'''
        #hidden_output, _ = tf.nn.dynamic_rnn(lstmCell,embedding_vec,dtype=tf.float32)
        hidden_output = tf.keras.layers.RNN(lstmCell,return_sequences=True)(embedding_vec)
        '''flatten it, but when update, only use the target one to update the network'''
        hidden_output = tf.reshape(hidden_output,[-1,lstm_units])
        
        #re-order by weight
        position_id = tf.constant([0,1,2,3,4,5,6,7,8,9])
        if regular_order_initial:
            weights=tf.Variable(tf.one_hot(position_id,max_step),name="weights")
        else:
            weights=tf.Variable(tf.truncated_normal([max_step,max_step]),name="weights")
        input_mat = tf.transpose(embedding_vec,[1,0,2])
        
        weighted_inputs=tf.tensordot(weights,input_mat,axes=[[1], [0]])
        weighted_inputs = tf.transpose(weighted_inputs,[1,0,2])
        
        lstmCell_2 = tf.contrib.rnn.MultiRNNCell([tf.contrib.rnn.BasicLSTMCell(lstm_units),tf.contrib.rnn.BasicLSTMCell(lstm_units)])
        #'''hidden_output is the output vectors of lstm cells [batch_size * time_steps * lstm_units]'''
        #hidden_output_2, _ = tf.nn.dynamic_rnn(lstmCell_2,weighted_inputs,dtype=tf.float32)
        hidden_output_2 = tf.keras.layers.RNN(lstmCell,return_sequences=True)(weighted_inputs)
        #'''flatten it, but when update, only use the target one to update the network'''
        hidden_output_2 = tf.reshape(hidden_output_2,[-1,lstm_units])
        
        hidden_compound = tf.concat([hidden_output,hidden_output_2],1)
        
        softmax_weight = tf.Variable(tf.truncated_normal([2*lstm_units,self.n_voca]), name="softmax_weight")
        softmax_bias = tf.Variable(tf.constant(0.1, shape=[self.n_voca]))
        #hidden_output = tf.transpose(hidden_output,[1,0,2])  #batch_size * time_steps * lstm_units --> time_steps * batch_size * lstm_units
        #target_output = tf.gather(hidden_output, int(hidden_output.get_shape()[0])-1)
        '''pred is the vectors of all the timesteps, use last one or every step for update'''
        logits = tf.matmul(hidden_compound,softmax_weight)+softmax_bias
        logits = tf.reshape(logits, [-1,max_step,self.n_voca])
        #assert logits.get_shape().as_list() == [None,None,self.n_voca]            #targets = tf.one_hot(outputs,self.n_voca,axis=-1)
        index_offset = tf.fill(tf.stack([tf.shape(self.target_len)[0]]),-1)
        target_indices = tf.add(self.target_len,index_offset)
        mask = tf.one_hot(target_indices,max_step,dtype=tf.float32)
        '''mask_for_padding to guarantee update on every next token'''
        mask_for_padding = tf.sequence_mask(self.target_len,dtype=tf.float32)
        if update_next:
            # use every time steps to supervise the model.
            self.loss = tf.contrib.seq2seq.sequence_loss(
                logits,
                self.outputs,
                mask_for_padding,
                average_across_timesteps=False,
                average_across_batch=True)     
        else:
            self.loss = tf.contrib.seq2seq.sequence_loss(
                logits,
                self.outputs,
                mask,
                average_across_timesteps=False,
                average_across_batch=True) 
        
        
        self.optimizer = tf.train.AdamOptimizer().minimize(self.loss)
        # answer
        pred = tf.argmax(logits,2) #batch_size*time_step
        mask_pred = tf.multiply(tf.cast(pred,tf.float32),mask)
        # answer
        self.last_pred = tf.reduce_sum(mask_pred,1)
        mask_output = tf.multiply(tf.cast(self.outputs,tf.float32),mask)
        # label
        last_output = tf.reduce_sum(mask_output,1)
        correctPred = tf.equal(tf.cast(self.last_pred,tf.int64),tf.cast(last_output,tf.int64))
        self.last_acc = tf.reduce_mean(tf.cast(correctPred,tf.float32))
        
        # second last
        second_target_indices = tf.add(tf.cast(target_indices,tf.int32),index_offset)
        mask_second_last = tf.one_hot(second_target_indices,n_time_step,dtype=tf.float32)
        second_mask_pred = tf.multiply(tf.cast(pred,tf.float32),mask_second_last)
        self.second_last_pred = tf.reduce_sum(second_mask_pred,1)
        second_mask_output = tf.multiply(tf.cast(self.outputs,tf.float32),mask_second_last)
        second_last_output = tf.reduce_sum(second_mask_output,1)
        second_correct = tf.equal(tf.cast(self.second_last_pred,tf.int64),tf.cast(second_last_output,tf.int64))
        self.second_last_acc = tf.reduce_mean(tf.cast(second_correct,tf.float32))
        
        self.lstm_saver = tf.train.Saver()
        
    def train_and_test(self,train_input,test_input,epoch,batch_size,save_checkpoint):
        init = tf.global_variables_initializer()
        log = open(self.logfile,'a')
       
        with tf.Session() as sess:
            sess.run(init)
            #iter_total=0
            #batch_count = 0
            
            for e in range(epoch):
                print("===============Epoch {}/{}=================".format(e+1,epoch))
                log.write("===============Epoch {}=================\n".format(e+1,epoch))
                n_batch = train_input.n_data//batch_size+1
                i_batch = 0
                for train_inputs,label_len, train_labels in train_input.get_batches(batch_size):
                    i_batch += 1
                    #print("Iteration:{}".format(batch_cnt))
                    _,los, accur=sess.run([self.optimizer,self.loss,self.last_acc], feed_dict= {self.inputs:train_inputs, self.outputs:train_labels, self.target_len:label_len})
                    if i_batch % 100==0:
                        print("Epoch {}, Iteration {}/{}: Training accuracy {}, Training loss {}".format(e+1,i_batch,n_batch,accur,los))
                        log.write("Epoch {}, Iteration {}/{}: Training accuracy {}, Training loss {}\n".format(e+1,i_batch,n_batch,accur,los))
                
                self.lstm_saver.save(sess, "{}_{}.ckpt".format(save_checkpoint,e+1))
                print("====================Testing phase===================================")
                log.write("====================Testing phase===================================\n")
                accuracy_total = 0
                test_batch = 0
                for test_inputs, test_label_len,test_labels in test_input.get_batches(batch_size):
                    
                    accur_test, los_test = sess.run([self.last_acc, self.loss], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len})
                    accuracy_total += accur_test
                    test_batch += 1
                    accuracy_ave = accuracy_total/test_batch
              
                
                print("Test Accuracy after epoch {}: {}".format(e+1,accuracy_ave))
                log.write("Test Accuracy after epoch {}: {}, test loss: {}\n".format(e+1,accuracy_ave,los_test))
        log.close()
        
               
    def test(self,lstm_checkpoint,test_input,batch_size):
        #correct_recorder = open(correct_file,'w')
        #correct_writer = csv.writer(correct_recorder)
        #wrong_recorder = open(wrong_file,'w')
        #wrong_writer = csv.writer(wrong_recorder)
        log = open(self.logfile,'a')
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore model')
            n_correct = 0
            n_correct_second = 0
            n_test = 0
            n_batch = test_input.n_data//batch_size+1
            i_batch = 0
            for test_inputs, test_label_len, test_labels in test_input.get_batches(batch_size):
                i_batch += 1
                
                last_acc, second_last_acc, prediction = sess.run([self.last_acc, self.second_last_acc,self.last_pred], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len})
                n_test += len(test_inputs)
                n_correct += int(last_acc*len(test_inputs)) 
                
                n_correct_second += int(second_last_acc*len(test_inputs))
                log.write("Testing {}/{}\n".format(i_batch,n_batch))
                log.write("Test Accuracy for last token: {}\n".format(last_acc))
                log.write("Test Accuracy for second last token: {}\n".format(second_last_acc))
                print("Testing {}/{}".format(i_batch,n_batch))
                print("Test Accuracy for last token: {}".format(last_acc))
                print("Test Accuracy for second last token: {}".format(second_last_acc))
                #for i in range(len(prediction)):
                #    if prediction[i] == test_labels[i][-1]:
                #        test_case_res = list(test_inputs)
                #        test_case_res.append(test_labels[i][-1])  
                #        test_case_res.append('-111')
                #        test_case_res.append(prediction[i])                    
                #        correct_writer.writerow(test_case_res)
                #    else:
                #        test_case_res = list(test_inputs)
                #    
                #        test_case_res.append(test_labels[i][-1])
                #        test_case_res.append('-111')
                #        test_case_res.append(prediction[i])
                #        wrong_writer.writerow(test_case_res)
                        
            
            acc_test = float(n_correct)/float(n_test)
            acc_second_last = float(n_correct_second)/float(n_test)
            log.write("Test Accuracy for last token: {}\n".format(acc_test))
            log.write("Test Accuracy for second last token: {}\n".format(acc_second_last))
            print("Test Accuracy for last token: {}".format(acc_test))
            print("Test Accuracy for second last token: {}".format(acc_second_last))
        log.close()
        #correct_recorder.close()
        #wrong_recorder.close()
    
    def test_by_length(self,lstm_checkpoint,test_input,batch_size,leng):
        #correct_recorder = open(correct_file,'w')
        #correct_writer = csv.writer(correct_recorder)
        #wrong_recorder = open(wrong_file,'w')
        #wrong_writer = csv.writer(wrong_recorder)
        log = open(self.logfile,'a')
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore model')
            n_correct = 0
            n_correct_second = 0
            n_test = 0
            n_batch = len(test_input._data_by_length[leng])//batch_size+1
            i_batch = 0
            for test_inputs, test_label_len, test_labels in test_input.get_batches_for_length(batch_size,leng):
                i_batch += 1
                
                last_acc, second_last_acc, prediction = sess.run([self.last_acc, self.second_last_acc,self.last_pred], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len})
                n_test += len(test_inputs)
                n_correct += int(last_acc*len(test_inputs))                
                n_correct_second += int(second_last_acc*len(test_inputs))
                log.write("Testing {}/{}\n".format(i_batch,n_batch))
                log.write("Test Accuracy for last token: {}\n".format(last_acc))
                log.write("Test Accuracy for second last token: {}\n".format(second_last_acc))
                print("Testing {}/{}".format(i_batch,n_batch))
                print("Test Accuracy for last token: {}".format(last_acc))
                print("Test Accuracy for second last token: {}".format(second_last_acc))
                #for i in range(len(prediction)):
                #    if prediction[i] == test_labels[i][-1]:
                #        test_case_res = list(test_inputs)
                #        test_case_res.append(test_labels[i][-1])  
                #        test_case_res.append('-111')
                #        test_case_res.append(prediction[i])                    
                #        correct_writer.writerow(test_case_res)
                #    else:
                #        test_case_res = list(test_inputs)
                #    
                #        test_case_res.append(test_labels[i][-1])
                #        test_case_res.append('-111')
                #        test_case_res.append(prediction[i])
                #        wrong_writer.writerow(test_case_res)
                        
            if n_test>0:
                acc_test = float(n_correct)/float(n_test)
                acc_second_last = float(n_correct_second)/float(n_test)
                log.write("Test Accuracy for last token: {}\n".format(acc_test))
                log.write("Test Accuracy for second last token: {}\n".format(acc_second_last))
                print("Test Accuracy for last token: {}".format(acc_test))
                print("Test Accuracy for second last token: {}".format(acc_second_last))
            else:
                print("No samples for input length {}".format(leng))
        log.close()
        #correct_recorder.close()
        #wrong_recorder.close()
    def test_for_length_range(self,lstm_checkpoint,test_input,batch_size,min_leng,max_leng,logfile):
        for i in range(min_leng,max_leng+1):
            with open(logfile,'a') as f:
                f.write("---------Length {}:{} samples-------------\n".format(i,len(test_input._data_by_length[i])))
            print("---------Length {}:{} samples-------------\n".format(i,len(test_input._data_by_length[i])))
            self.test_by_length(lstm_checkpoint,test_input,batch_size,i,logfile)




lstm_model = Model(n_voca,n_embedding,embedding_checkpoint,normalized_embedding,logfile)
lstm_model.build(lstm_units,use_embedding=use_embedding,update_next=False,max_step=10,regular_order_initial=regular_order_initial)
train_input = Input_fn(train_file)
test_input = Input_fn(test_file)
lstm_model.train_and_test(train_input,test_input,epoch,batch_size,save_checkpoint)      


# In[ ]:



