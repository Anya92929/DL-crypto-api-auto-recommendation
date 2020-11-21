
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


class Input_fn:
    def __init__(self,data_file):

        if data_file.endswith('.csv'):
            self._data = pd.read_csv(data_file) 
        else:
            raise ValueError
        self.pad_id = 0
        self.max_window_steps = 10
        self.n_data = len(self._data)
        self.data_file = data_file
        self._multi_answers = dict() #hash,label_set
        #self.order_data_by_length()

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
    
    def collect_multiple_answers(self):
        self._multi_answers = dict() # hash -> label_set
        for index, row in self._data.iterrows():
        	
        	label = row['label']   	
        	path_len, input_paths = self.transfer_df_row_to_inputs(row)
        	row_hash = self.hash_instance(input_paths,path_len)
        	if row_hash in self._multi_answers:
        		self._multi_answers[row_hash].add(label)
        	else:
        		labels = set()
        		labels.add(label)
        		self._multi_answers[row_hash] = labels
            
    def transfer_df_row_to_inputs(self,row):
    	path_len = [row[key] for key in ['path1_len','path2_len','path3_len','path4_len','path5_len']]
    	paths = [[row[key] for key in ['token_p1s1','token_p1s2','token_p1s3','token_p1s4','token_p1s5','token_p1s6','token_p1s7','token_p1s8','token_p1s9','token_p1s10']],
		[row[key] for key in ['token_p2s1','token_p2s2','token_p2s3','token_p2s4','token_p2s5','token_p2s6','token_p2s7','token_p2s8','token_p2s9','token_p2s10']],
		[row[key] for key in ['token_p3s1','token_p3s2','token_p3s3','token_p3s4','token_p3s5','token_p3s6','token_p3s7','token_p3s8','token_p3s9','token_p3s10']],
		[row[key] for key in ['token_p4s1','token_p4s2','token_p4s3','token_p4s4','token_p4s5','token_p4s6','token_p4s7','token_p4s8','token_p4s9','token_p4s10']],
		[row[key] for key in ['token_p5s1','token_p5s2','token_p5s3','token_p5s4','token_p5s5','token_p5s6','token_p5s7','token_p5s8','token_p5s9','token_p5s10']]]
    	return path_len, paths
    def hash_instance(self, input_paths, path_len):
    	path_len = tuple(np.sort(path_len))
    	paths = [tuple(input_paths[i]) for i in range(5)]
    	paths.sort()

    	paths = tuple(paths)
    	
    	key = (path_len,paths)
    	#rint(type(key))
    	return key

    def correct_acc(self,test_inputs,length,n_path,test_labels,prediction):
        if not self._multi_answers:
        	print("collecting multiple answers...")
        	self.collect_multiple_answers()
        	print("Finish collecting multiple answers")
        n_correct = 0
        answers = []
        for i_input, i_path_len, i_n_path, pred, i_label in zip(test_inputs,length,n_path, prediction,test_labels):
            i_hash = self.hash_instance(i_input,i_path_len)
            if i_hash in self._multi_answers:
                multi_answers = self._multi_answers[i_hash]
                multi_answers.add(i_label)
                
            else:
                multi_answers = set()
                multi_answers.add(i_label)
            answers.append(multi_answers)    
            if pred in multi_answers or pred==i_label:
                n_correct += 1
        acc = n_correct/len(test_inputs)
        return acc, answers

    
        
    def get_batches(self,batch_size):
        return self.get_batches_from_data(self._data,batch_size)
   
    

    def get_batches_from_data(self,data,batch_size):
        counter = 0
        input_seq = []
        output_label = []
        
    
        for start_id in range(0,data.shape[0],batch_size):
            end_id = min(start_id+batch_size, data.shape[0])
            batch_data = data.iloc[start_id:end_id]
            input_seq = batch_data[['token_p1s1','token_p1s2','token_p1s3','token_p1s4','token_p1s5',\
            'token_p1s6','token_p1s7','token_p1s8','token_p1s9','token_p1s10',\
            'token_p2s1','token_p2s2','token_p2s3','token_p2s4','token_p2s5',\
            'token_p2s6','token_p2s7','token_p2s8','token_p2s9','token_p2s10',\
            'token_p3s1','token_p3s2','token_p3s3','token_p3s4','token_p3s5',\
            'token_p3s6','token_p3s7','token_p3s8','token_p3s9','token_p3s10',\
            'token_p4s1','token_p4s2','token_p4s3','token_p4s4','token_p4s5',\
            'token_p4s6','token_p4s7','token_p4s8','token_p4s9','token_p4s10',\
            'token_p5s1','token_p5s2','token_p5s3','token_p5s4','token_p5s5',\
            'token_p5s6','token_p5s7','token_p5s8','token_p5s9','token_p5s10']].values
            input_seq = np.reshape(input_seq,(end_id-start_id,5,10))
            output_seq = batch_data['label'].values
            output_seq = np.reshape(output_seq,(-1))
            n_path = batch_data['n_path'].values
            paths_len = batch_data[['path1_len','path2_len','path3_len','path4_len','path5_len']].values
            #print("input_seq")
            #print(input_seq)
            #print("paths_len")
            #print(paths_len)
            #print("output_seq")
            #print(output_seq)
            yield input_seq, paths_len,n_path, output_seq
        
    def pre_padding(self, tensor):
        padded = list()
        tensor_len = [len(i) for i in tensor]
        time_step = max(tensor_len)
        for i in tensor:
            new_in = np.pad(i,[(time_step-len(i),0)],'constant',constant_values=(self.pad_id,0))
            padded.append(new_in)
        return padded
        
    def post_padding(self, tensor):
        
        #print(self.pad_id)
        tensor_len = [len(i) for i in tensor]
        time_step = max(tensor_len)
        padded = []
        for row in tensor:
            new_in = np.pad(row,[(0,time_step-len(row))],'constant',constant_values=(0,self.pad_id))
            padded.append(new_in)
        padded = np.array(padded)
        return padded
        
    def padding(self,inputs,mode=0):
        '''if mode = 0, post_padding;
           if mode = 1, pre_padding'''
        if mode == 0:
            padded = self.post_padding(inputs)
        else:
            padded = self.pre_padding(inputs)
        return padded


# In[13]:

class Model:
    def __init__(self,voca_size,n_embedding,embedding_checkpoint,n_embedding_voca,logfile,normalized_embedding=False):
        self.n_voca = voca_size
        self.n_embedding_voca = n_embedding_voca
        self.n_embedding = n_embedding
        self.logfile=logfile
        self.embedding_mat = self.get_embedding_mat(embedding_checkpoint,normalized_embedding)
        #self.logfile.write("Successfully restore embedding model from {} with normalized {}.\n".format(embedding_checkpoint,normalized_embedding))
        print(f"successfully restore embedding model")
        #self.data_helper= data_helper
        tf.reset_default_graph()
        
    def get_embedding_mat(self, embedding_checkpoint, normalized):
        n_sampled = 100

        # Build Traning Graph
        train_graph = tf.Graph()
        with train_graph.as_default():
            inputs = tf.placeholder(tf.int32, [None], name='inputs')  # layer 1
            labels = tf.placeholder(tf.int32, [None, None], name='labels')  # layer 3

            
            embedding = tf.Variable(tf.random_uniform((self.n_embedding_voca, self.n_embedding), -1, 1))
            embed = tf.nn.embedding_lookup(embedding,
                                           inputs)  # use tf.nn.embedding_lookup to get the hidden layer output

            softmax_w = tf.Variable(tf.truncated_normal((self.n_embedding_voca, self.n_embedding)))  # create softmax weight matrix here
            softmax_b = tf.Variable(tf.zeros(self.n_embedding_voca), name="softmax_bias")  # create softmax biases here

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
                if not normalized:
                    embed_mat = sess.run(embedding)
                else:
                    embed_mat = sess.run(normalized_embedding)
                return embed_mat
   
        
    def build(self,lstm_units,use_embedding=True):
        with open(self.logfile,'a') as file:
            file.write("Build file with Parameters:\n")
            file.write("[lstm_units: {}; use_embedding: {};]\n".format(lstm_units,use_embedding))
        #graph build        
        self.outputs = tf.placeholder(tf.int32, [None],name='output_layer') #batch_size
        self.inputs = tf.placeholder(tf.int32, [None, 5, None],name='input_layer')
        self.n_path = tf.placeholder(tf.int32,[None],name='n_path') # batch_size
        self.target_len = tf.placeholder(tf.int32,[None,5],name='target_length')

        n_time_step = tf.reduce_max(self.target_len,0)
        
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
        lstmCell = tf.contrib.rnn.MultiRNNCell([tf.contrib.rnn.BasicLSTMCell(lstm_units),tf.contrib.rnn.BasicLSTMCell(lstm_units)])
        '''hidden_output is the output vectors of lstm cells [batch_size * time_steps * lstm_units]'''
        
        embedding_vec0 = tf.gather(embedding_vec,axis=1,indices=0)  
        embedding_vec1 = tf.gather(embedding_vec,axis=1,indices=1)
        embedding_vec2 = tf.gather(embedding_vec,axis=1,indices=2)
        embedding_vec3 = tf.gather(embedding_vec,axis=1,indices=3)
        embedding_vec4 = tf.gather(embedding_vec,axis=1,indices=4)

        self.embedding_vec0 = embedding_vec0
        self.embedding_vec1 = embedding_vec1
        self.embedding_vec2 = embedding_vec2
        self.embedding_vec3 = embedding_vec3
        self.embedding_vec4 = embedding_vec4
        
        #embedding_vec0 = tf.Print(embedding_vec0,[tf.shape(embedding_vec0)],"embedding_vec0:")
        #embedding_vec1 = tf.Print(embedding_vec1,[tf.shape(embedding_vec1)],"embedding_vec1:")
        #embedding_vec2 = tf.Print(embedding_vec2,[tf.shape(embedding_vec2)],"embedding_vec2:")
        #embedding_vec3 = tf.Print(embedding_vec3,[tf.shape(embedding_vec3)],"embedding_vec3:")
        #embedding_vec4 = tf.Print(embedding_vec4,[tf.shape(embedding_vec4)],"embedding_vec4:")
        #assert embedding_vec1.get_shape().as_list()== embedding_vec2.get_shape().as_list() == embedding_vec3.get_shape().as_list()== embedding_vec4.get_shape().as_list() == embedding_vec0.get_shape().as_list()


        hidden_output0, _ = tf.nn.dynamic_rnn(lstmCell,embedding_vec0,dtype=tf.float32)
        
        hidden_output1, _ = tf.nn.dynamic_rnn(lstmCell,embedding_vec1,dtype=tf.float32) 
        hidden_output2, _ = tf.nn.dynamic_rnn(lstmCell,embedding_vec2,dtype=tf.float32)
        hidden_output3, _ = tf.nn.dynamic_rnn(lstmCell,embedding_vec3,dtype=tf.float32)
        hidden_output4, _ = tf.nn.dynamic_rnn(lstmCell,embedding_vec4,dtype=tf.float32)

        self.hidden_output0 = hidden_output0
        self.hidden_output1 = hidden_output1
        self.hidden_output2 = hidden_output2
        self.hidden_output3 = hidden_output3
        self.hidden_output4 = hidden_output4

        #hidden_output0 = tf.Print(hidden_output0,[tf.shape(hidden_output0)],"hidden_output0:")
        #hidden_output1 = tf.Print(hidden_output1,[tf.shape(hidden_output1)],"hidden_output1:")
        #hidden_output2 = tf.Print(hidden_output2,[tf.shape(hidden_output2)],"hidden_output2:")
        #hidden_output3 = tf.Print(hidden_output3,[tf.shape(hidden_output3)],"hidden_output3:")
        #hidden_output4 = tf.Print(hidden_output4,[tf.shape(hidden_output4)],"hidden_output4:")


        #assert hidden_output1.get_shape().as_list()== hidden_output2.get_shape().as_list() == hidden_output3.get_shape().as_list()== hidden_output4.get_shape().as_list() == hidden_output0.get_shape().as_list()
        '''select the last effective time step according to the length info'''
        seq0_len = tf.gather(self.target_len,axis=1, indices=0) # batch_size*n_paths --> batch_size
        seq0_len = tf.where(tf.not_equal(seq0_len,tf.constant(0)),tf.add(seq0_len,tf.ones_like(seq0_len)*(-1)),tf.ones_like(seq0_len))
        #seq0_len = tf.Print(seq0_len,[seq0_len],'Seq0_len:')
        seq0_mask = tf.one_hot(seq0_len,depth=10)
        #seq0_mask = tf.Print(seq0_mask,[seq0_mask],'Seq0_mask:',first_n=20)
        hidden_output0 = tf.boolean_mask(hidden_output0,seq0_mask) #batch_size*n_step*lstm_units --> # batch_size * lstm_units
        #hidden_output0 = tf.Print(hidden_output0,[tf.shape(hidden_output0)],"hidden_output0 after masking")
        hidden_output0 = tf.reshape(hidden_output0,[-1,lstm_units])
        
        seq1_len = tf.gather(self.target_len,axis=1,indices=1)
        seq1_len = tf.where(tf.not_equal(seq1_len,tf.constant(0)),tf.add(seq1_len,tf.ones_like(seq1_len)*(-1)),tf.ones_like(seq1_len))
        #seq1_len = tf.Print(seq1_len,[seq1_len],'Seq1_len:')
        seq1_mask = tf.one_hot(seq1_len,depth=10)
        #seq1_mask = tf.Print(seq1_mask,[seq1_mask],'Seq1_mask:',first_n=20)
        hidden_output1 = tf.boolean_mask(hidden_output1,seq1_mask)
        #hidden_output1 = tf.Print(hidden_output1,[tf.shape(hidden_output1)],"hidden_output1 after masking")
        hidden_output1 = tf.reshape(hidden_output1,[-1,lstm_units])

        seq2_len = tf.gather(self.target_len,axis=1,indices=2)
        seq2_len = tf.where(tf.not_equal(seq2_len,tf.constant(0)),tf.add(seq2_len,tf.ones_like(seq2_len)*(-1)),tf.ones_like(seq2_len))
        #seq2_len = tf.Print(seq2_len,[seq2_len],'Seq2_len:')
        seq2_mask = tf.one_hot(seq2_len,depth=10)
        #seq2_mask = tf.Print(seq2_mask,[seq2_mask],'Seq2_mask:',first_n = 20)
        hidden_output2 = tf.boolean_mask(hidden_output2,seq2_mask)
        #hidden_output2 = tf.Print(hidden_output2,[tf.shape(hidden_output2)],"hidden_output2 after masking")
        hidden_output2 = tf.reshape(hidden_output2,[-1,lstm_units])
        
        seq3_len = tf.gather(self.target_len,axis=1,indices=3)
        seq3_len = tf.where(tf.not_equal(seq3_len,tf.constant(0)),tf.add(seq3_len,tf.ones_like(seq3_len)*(-1)),tf.ones_like(seq3_len))
        #seq3_len = tf.Print(seq3_len,[seq3_len],'Seq3_len:')
        seq3_mask = tf.one_hot(seq3_len,depth=10)
        #seq3_mask = tf.Print(seq3_mask,[seq3_mask],'Seq3_mask:',first_n = 20)
        hidden_output3 = tf.boolean_mask(hidden_output3,seq3_mask)
        #hidden_output3 = tf.Print(hidden_output3,[tf.shape(hidden_output3)],"hidden_output3 after masking")
        hidden_output3 = tf.reshape(hidden_output3,[-1,lstm_units])

        seq4_len = tf.gather(self.target_len,axis=1,indices=4)
        seq4_len = tf.where(tf.not_equal(seq4_len,tf.constant(0)),tf.add(seq4_len,tf.ones_like(seq4_len)*(-1)),tf.ones_like(seq4_len))
        #seq4_len = tf.Print(seq4_len,[seq4_len],'Seq4_len:')
        seq4_mask = tf.one_hot(seq4_len,depth=10)
        #seq4_mask = tf.Print(seq4_mask,[seq4_mask],'Seq4_mask:',first_n = 20)
        hidden_output4 = tf.boolean_mask(hidden_output4,seq4_mask)
        #hidden_output4 = tf.Print(hidden_output4,[tf.shape(hidden_output4)],"hidden_output4 after masking")
        hidden_output4 = tf.reshape(hidden_output4,[-1,lstm_units])

        #hidden_output0 = tf.Print(hidden_output0,[tf.shape(hidden_output0)],"hidden_output0:")
        #hidden_output1 = tf.Print(hidden_output1,[tf.shape(hidden_output1)],"hidden_output1:")
        #hidden_output2 = tf.Print(hidden_output2,[tf.shape(hidden_output2)],"hidden_output2:")
        #hidden_output3 = tf.Print(hidden_output3,[tf.shape(hidden_output3)],"hidden_output3:")
        #hidden_output4 = tf.Print(hidden_output4,[tf.shape(hidden_output4)],"hidden_output4:")

        self.selected_hidden0 = hidden_output0
        self.selected_hidden1 = hidden_output1
        self.selected_hidden2 = hidden_output2
        self.selected_hidden3 = hidden_output3
        self.selected_hidden4 = hidden_output4
        #assert hidden_output1.get_shape().as_list()== hidden_output2.get_shape().as_list() == hidden_output3.get_shape().as_list()== hidden_output4.get_shape().as_list() == hidden_output0.get_shape().as_list()
        hidden_output = tf.stack([hidden_output0,hidden_output1,hidden_output2,hidden_output3,hidden_output4],axis=1) #batch_size *5 *lstm_units

        self.five_hidden_output = hidden_output
        
        softmax_weight = tf.Variable(tf.truncated_normal([lstm_units,self.n_voca]), name="softmax_weight")
        softmax_bias = tf.Variable(tf.constant(0.1, shape=[self.n_voca]))
        self.softmax_weight = softmax_weight
        self.softmax_bias = softmax_bias

        
        
        hidden_output = tf.reshape(hidden_output,[-1,lstm_units])
        logits = tf.matmul(hidden_output,softmax_weight)+softmax_bias
        logits = tf.reshape(logits, [-1,5,self.n_voca]) #mask padded paths
        self.logits = logits
        #logits [batch*5*self.n_voca]
        pred_per_path = tf.argmax(logits,axis=-1) # batch_size*5
        self.pred_per_path = pred_per_path
        label_per_path = tf.stack([self.outputs,self.outputs,self.outputs,self.outputs,self.outputs],axis=1)
        correct_per_path = tf.equal(pred_per_path,tf.cast(label_per_path,tf.int64))
        

        

        mask_path = tf.sequence_mask(self.n_path,5) #batch_size*5
        # change padded paths as 0
        correct_per_path = tf.where(mask_path,correct_per_path,tf.zeros_like(correct_per_path))
        n_correct_per_path = tf.reduce_sum(tf.cast(correct_per_path,dtype=tf.float32))
        n_all_path = tf.cast(tf.reduce_sum(self.n_path),dtype=tf.float32)
        self.single_path_acc = tf.divide(n_correct_per_path,n_all_path)

        mask_path = tf.expand_dims(mask_path,2)
        mask_path = tf.tile(mask_path,tf.constant([1,1,self.n_voca]))
        logits = tf.where(mask_path,logits,tf.zeros_like(logits))
        #logits = tf.ragged.boolean_mask(logits,masked_path)
        
        
        # maybe add activation here
        # we want reduce_mean with the n_path
        #logits_ave = tf.reduce_mean(logits,axis = 1)
        logits_sum = tf.reduce_sum(logits,axis=1) # batch_size*n_voca
        logits_ave = logits_sum/tf.cast(tf.reshape(self.n_path,(-1,1)),tf.float32)
        
        self.prediction = tf.argmax(logits_ave,axis=-1) # batch_size
        correct_prediction = tf.equal(self.prediction,tf.cast(self.outputs,tf.int64))
        self.accuracy = tf.reduce_mean(tf.cast(correct_prediction,tf.float32))
        
        prob_labels = tf.one_hot(self.outputs,depth=self.n_voca)
        self.loss = tf.nn.softmax_cross_entropy_with_logits_v2(labels=prob_labels,logits=logits_ave)
        self.optimizer = tf.train.AdamOptimizer().minimize(self.loss)       
        self.lstm_saver = tf.train.Saver()
        
    def debug_retrive_model(self,lstm_checkpoint):
    	init = tf.global_variables_initializer()

    	with tf.Session() as sess:
    		sess.run(init)
    		self.lstm_saver.restore(sess,tf.train.latest_checkpoint(lstm_checkpoint))
    		sfm_w = sess.run(self.softmax_weight)
    		sfm_b = sess.run(self.softmax_bias)
    		np.savetxt('./softmax_weigth.txt',sfm_w)
    		np.savetxt('./softmax_bias.txt',sfm_b)

    def debug_retrive_model(self,lstm_checkpoint,debug_sequence):
    	init = tf.global_variables_initializer()

    	with tf.Session() as sess:
    		sess.run(init)
    		self.lstm_saver.restore(sess,tf.train.latest_checkpoint(lstm_checkpoint))
    		_,los, accur, per_path_acc =sess.run([self.optimizer,self.loss,self.accuracy,self.single_path_acc], feed_dict= {self.inputs:train_inputs, self.outputs:train_labels, self.target_len:label_len,self.n_path:n_train_path})
    		
    def debug_sequence(self,lstm_checkpoint,df_file):

        init = tf.global_variables_initializer()
        with open('./debug_info.txt','w') as f_out:
            f_out.write("Debug Info for LSTM oneline:\n")

        with tf.Session() as sess:
            sess.run(init)
            self.lstm_saver.restore(sess,tf.train.latest_checkpoint(lstm_checkpoint))
            with open(df_file,'r') as f_in:
                next(f_in)
                for row in f_in:
                    row = row.strip()
                    row = row.split(',')
                    label = [int(row[2])]
                    n_path = [int(row[3])]
                    path_len = [[int(i) for i in row[4:9]]]

                    path_in = [int(i) for i in row[9:]]
                    path_in = np.reshape(path_in,(1,5,10))

                    embedding_vec0, embedding_vec1,embedding_vec2,embedding_vec3,embedding_vec4,hidden_output0,hidden_output1,hidden_output2,hidden_output3,hidden_output4, selected_hidden0,selected_hidden1,selected_hidden2,selected_hidden3,selected_hidden4,five_hidden_output,logits,pred_per_path = sess.run([self.embedding_vec0,self.embedding_vec1,self.embedding_vec2,self.embedding_vec3,self.embedding_vec4,self.hidden_output0,self.hidden_output1,self.hidden_output2,self.hidden_output3,self.hidden_output4, self.selected_hidden0,self.selected_hidden1,self.selected_hidden2,self.selected_hidden3,self.selected_hidden4,self.five_hidden_output,self.logits,self.pred_per_path], feed_dict= {self.inputs:path_in, self.outputs:label, self.target_len:path_len,self.n_path:n_path})

                    
                    
                    with open('./debug_info.txt','a') as f_out:
                    	f_out.write("-------------------\n")
                    	f_out.write("Test sequences input: {}\n".format(path_in))
                    	f_out.write("label: {}\n".format(label))
                    	f_out.write("path_len: {}\n".format(path_len))
                    	f_out.write("n_path: {}\n".format(n_path))
                    	f_out.write("Embedding_vec0: \n")
                    	f_out.write("{}\n".format(embedding_vec0))
                    	f_out.write("Embedding_vec1: \n")
                    	f_out.write("{}\n".format(embedding_vec1))
                    	f_out.write("Embedding_vec2: \n")
                    	f_out.write("{}\n".format(embedding_vec2))
                    	f_out.write("Embedding_vec3: \n")
                    	f_out.write("{}\n".format(embedding_vec3))
                    	f_out.write("Embedding_vec4: \n")
                    	f_out.write("{}\n".format(embedding_vec4))
                    	f_out.write("Hidden output0:\n")
                    	f_out.write("{}\n".format(hidden_output0))
                    	f_out.write("Hidden output1:\n")
                    	f_out.write("{}\n".format(hidden_output1))
                    	f_out.write("Hidden output2:\n")
                    	f_out.write("{}\n".format(hidden_output2))
                    	f_out.write("Hidden output3:\n")
                    	f_out.write("{}\n".format(hidden_output3))
                    	f_out.write("Hidden output4:\n")
                    	f_out.write("{}\n".format(hidden_output4))
                    	f_out.write("Selected Hidden output0:\n")
                    	f_out.write("{}\n".format(selected_hidden0))
                    	f_out.write("Selected Hidden output1:\n")
                    	f_out.write("{}\n".format(selected_hidden1))
                    	f_out.write("Selected Hidden output2:\n")
                    	f_out.write("{}\n".format(selected_hidden2))
                    	f_out.write("Selected Hidden output3:\n")
                    	f_out.write("{}\n".format(selected_hidden3))
                    	f_out.write("Selected Hidden output4:\n")
                    	f_out.write("{}\n".format(selected_hidden4))
                    	f_out.write("stack five hidden output:\n")
                    	f_out.write("{}\n".format(five_hidden_output))
                    	f_out.write("Logits:\n")
                    	f_out.write("{}\n".format(logits))
                    	f_out.write("pred_per_path:\n")
                    	f_out.write("{}\n".format(pred_per_path))

    def train_and_test(self,train_input,test_input,epoch,batch_size,lstm_checkpoint,save_checkpoint):
        init = tf.global_variables_initializer()
        log = open(self.logfile,'a')
       
        with tf.Session() as sess:
            sess.run(init)
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore lstm model')
            #iter_total=0
            #batch_count = 0
            
            for e in range(epoch):
                #print("===============Epoch {}/{}=================".format(e+1,epoch))
                #log.write("===============Epoch {}=================\n".format(e+1,epoch))
                #n_batch = train_input.n_data//batch_size+1
                #i_batch = 0
                #for train_inputs,label_len, n_train_path, train_labels in train_input.get_batches(batch_size):
                #    i_batch += 1
                    
                #    _,los, accur, per_path_acc =sess.run([self.optimizer,self.loss,self.accuracy,self.single_path_acc], feed_dict= {self.inputs:train_inputs, self.outputs:train_labels, self.target_len:label_len,self.n_path:n_train_path})
                #    if i_batch % 100==0:
                #        print("Epoch {}, Iteration {}/{}: Training accuracy {}, Single path accuracy {},Training loss {}".format(e+1,i_batch,n_batch,accur,per_path_acc,los))
                #        log.write("Epoch {}, Iteration {}/{}: Training accuracy {}, Single path accuracy {}, Training loss {}\n".format(e+1,i_batch,n_batch,accur,per_path_acc,los))
                
                #self.lstm_saver.save(sess, "{}_{}.ckpt".format(save_checkpoint,e+1))
                print("====================Testing phase===================================")
                log.write("====================Testing phase===================================\n")
                correct_total = 0
                n_test = 0
                correct_per_path = 0
                n_path = 0
                for test_inputs, test_label_len, n_test_path, test_labels in test_input.get_batches(batch_size):
                    
                    accur_test, los_test, per_path_acc = sess.run([self.accuracy, self.loss,self.single_path_acc], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len,self.n_path:n_test_path})
                    
                    i_test = len(test_labels)
                    correct_total += accur_test *i_test
                    n_test += i_test

                    i_path = np.sum(n_test_path)
                    correct_per_path += per_path_acc*i_path
                    n_path += i_path

                accuracy_ave = correct_total/n_test
                per_path_acc_ave = correct_per_path/n_path
              
                
                print("Test Accuracy after epoch {}: {}; single path accuracy: {}.".format(e+1,accuracy_ave,per_path_acc_ave))
                log.write("Test Accuracy after epoch {}: {}; single path accuracy: {}; test loss: {}\n".format(e+1,accuracy_ave,per_path_acc_ave, los_test))
        log.close()

    def fine_tune_with_a_new_layer(self,lstm_checkpoint, train_input,test_input,epoch,batch_size,save_checkpoint):
        
        log = open(self.logfile,'a')
        init = tf.global_variables_initializer()
        with tf.Session() as sess:
            
            #iter_total=0
            #batch_count = 0
            sess.run(init)
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore lstm model')
            log.write(f"Retrieve lstm_model from {lstm_checkpoint}\n")
            log.write(f"Starting fine tune model with training data {train_input.data_file}\n")
            for e in range(epoch):
                print("===============Epoch {}/{}=================".format(e+1,epoch))
                log.write("===============Epoch {}=================\n".format(e+1,epoch))
                n_batch = train_input.n_data//batch_size+1
                i_batch = 0
                for train_inputs,label_len, train_labels in train_input.get_batches(batch_size):
                    i_batch += 1
                    #print("Iteration:{}".format(batch_cnt))
                    _,los, accur=sess.run([self.optimizer_finetune,self.loss_finetune,self.last_acc_finetune], feed_dict= {self.inputs:train_inputs, self.outputs:train_labels, self.target_len:label_len})
                    if i_batch % 500==0:
                        print("Epoch {}, Iteration {}/{}: Training accuracy {}, Training loss {}".format(e+1,i_batch,n_batch,accur,los))
                        log.write("Epoch {}, Iteration {}/{}: Training accuracy {}, Training loss {}\n".format(e+1,i_batch,n_batch,accur,los))
                
                self.lstm_saver.save(sess, "{}_{}.ckpt".format(save_checkpoint,e+1))
                print("====================Testing phase===================================")
                log.write("====================Testing phase===================================\n")
                accuracy_total = 0
                test_batch = 0
                for test_inputs, test_label_len,test_labels in test_input.get_batches(batch_size):
                    
                    accur_test, los_test = sess.run([self.last_acc_finetune, self.loss_finetune], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len})
                    accuracy_total += accur_test
                    test_batch += 1
                    accuracy_ave = accuracy_total/test_batch
              
                
                print("Test Accuracy after epoch {}: {}".format(e+1,accuracy_ave))
                log.write("Test Accuracy after epoch {}: {}, test loss: {}\n".format(e+1,accuracy_ave,los_test))
        log.close()
        
        
               
    def test(self,lstm_checkpoint,test_input,batch_size,logfile):
        #correct_recorder = open(correct_file,'w')
        #correct_writer = csv.writer(correct_recorder)
        #wrong_recorder = open(wrong_file,'w')
        #wrong_writer = csv.writer(wrong_recorder)
        log = open(logfile,'a')
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore lstm model')
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
                #log.write("Testing {}/{}\n".format(i_batch,n_batch))
                #log.write("Test Accuracy for last token: {}\n".format(last_acc))
                #log.write("Test Accuracy for second last token: {}\n".format(second_last_acc))
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
    
    def test_by_length(self,lstm_checkpoint,test_input,batch_size,leng,logfile):
        #correct_recorder = open(correct_file,'w')
        #correct_writer = csv.writer(correct_recorder)
        #wrong_recorder = open(wrong_file,'w')
        #wrong_writer = csv.writer(wrong_recorder)
        log = open(logfile,'a')
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
                #log.write("Testing {}/{}\n".format(i_batch,n_batch))
                #log.write("Test Accuracy for last token: {}\n".format(last_acc))
                #log.write("Test Accuracy for second last token: {}\n".format(second_last_acc))
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
            
        
    def test_for_multiple_answers(self,multi_path_checkpoint,test_input,train_input,batch_size,correct_file,wrong_file):
        correct_recorder = open(correct_file,'w')
        correct_writer = csv.writer(correct_recorder)
        wrong_recorder = open(wrong_file,'w')
        wrong_writer = csv.writer(wrong_recorder)
        log = open(self.logfile,'a')
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(multi_path_checkpoint))
            print('successfully restore lstm model')
            n_correct = 0
            n_test = 0
            n_batch = test_input.n_data//batch_size+1
            i_batch = 0
            n_correct_multi = 0
            for test_inputs, test_label_len, test_n_path, test_labels in test_input.get_batches(batch_size):
                i_batch += 1
                
                accuracy, prediction = sess.run([self.accuracy, self.prediction], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len,self.n_path:test_n_path})
                i_test = len(test_labels)
                n_test += i_test
                n_correct += int(accuracy*i_test) 
                
                
                #log.write("Testing {}/{}\n".format(i_batch,n_batch))
                #log.write("Test Accuracy for last token: {}\n".format(last_acc))
                #log.write("Test Accuracy for second last token: {}\n".format(second_last_acc))
                print("Testing {}/{}".format(i_batch,n_batch))
                print("Test Accuracy for last token: {}".format(accuracy))

                multi_acc, multi_answers = train_input.correct_acc(test_inputs,test_label_len, test_n_path, test_labels,prediction)
                print("Multi_acc: {}".format(multi_acc))
                n_correct_multi += int(multi_acc*i_test)
                for i in range(len(prediction)):
                    answers = multi_answers[i]
                    if prediction[i] in answers:
                        test_case_res = list(np.reshape(test_inputs[i],[-1]))
                        test_case_res.append('-111')
                        test_case_res.append(prediction[i])
                        test_case_res.append('-222')
                        test_case_res.append(answers)
                                
                        correct_writer.writerow(test_case_res)
                    else:
                        test_case_res = list(np.reshape(test_inputs[i],[-1]))
                        test_case_res.append('-111')
                        test_case_res.append(prediction[i])
                        test_case_res.append('-222')
                        test_case_res.append(answers)
                
                        wrong_writer.writerow(test_case_res)
                        
            
            acc_test = n_correct/n_test
            acc_multi = float = n_correct_multi/n_test
            log.write("Test Accuracy for last token: {}\n".format(acc_test))
            log.write("Test Accuracy (multi-answers) for last token: {}\n".format(acc_multi))
            print("Test Accuracy for last token: {}".format(acc_test))
        log.close()
    





