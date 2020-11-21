
# coding: utf-8

# In[1]:

'''Retrieve trained model, return accuracy on test set, split on sequence length'''


# In[1]:

import csv
import tensorflow as tf
import numpy as np
import random
import argparse



class Input_fn:
    def __init__(self,data_file):
        if data_file.endswith('.csv'):
            with open(data_file,'r') as f:
                reader = csv.reader(f)
                self._data = [[int(i) for i in row] for row in reader]
        else:
            raise ValueError
        self.data_file = data_file
        self.pad_id = 0
        self.max_window_steps = 10
        self.n_data = len(self._data)
        self.order_data_by_length()
        self._multi_answers = dict()
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
                input_padded = self.padding(input_seq,0)
                output_padded = self.padding(output_label,0)
                label_len = np.array([len(i) for i in output_label])
                yield input_padded, label_len,output_padded
        input_padded = self.padding(input_seq,0)
        output_padded = self.padding(output_label,0)
        label_len = np.array([len(i) for i in output_label])
        yield input_padded, label_len,output_padded
        
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

    def collect_multiple_answers(self):
        self._multi_answers = dict()
        for row in self._data:
            if len(row)>1:
                if len(row)>11:
                    row = row[-11:]
                inputs = tuple(row[:-1])
                label = row[-1]
                if inputs in self._multi_answers:
                    self._multi_answers[inputs].add(label)
                else:
                    labels = set()
                    labels.add(label)
                    self._multi_answers[inputs] = labels



    def correct_acc(self,test_inputs,length,test_labels,prediction):
        if not self._multi_answers:
            self.collect_multiple_answers()
        n_correct = 0
        answers = []
        for row, leng, pred, test_label in zip(test_inputs,length,prediction,test_labels):
            row = row[:leng]
            row = tuple(row)
            label = test_label[leng-1]
            if row in self._multi_answers:
                multi_answers = self._multi_answers[tuple(row)]
                multi_answers.add(label)
                
            else:
                multi_answers = set()
                multi_answers.add(label)
            answers.append(multi_answers)    
            if pred in multi_answers or pred==label:
                n_correct += 1
        acc = n_correct/len(test_inputs)
        return acc, answers


    def correct_acc_for_2_answers(self,test_inputs,length,test_labels,pred_next,pred_last):
        if not self._multi_answers: 
            self.collect_multiple_answers()
        n_correct_last = 0
        n_correct_next = 0
        n_correct_global = 0

        answers = []
        for row, leng, pred1, pred2, test_label in zip(test_inputs,length,pred_next, pred_last,test_labels):
            row = row[:leng]
            row = tuple(row)
            label = test_label[leng-1]
            if row in self._multi_answers:
                multi_answers = self._multi_answers[tuple(row)]
                multi_answers.add(label)
                
            else:
                multi_answers = set()
                multi_answers.add(label)
            answers.append(multi_answers)
            flag = False   
            if pred1 in multi_answers or pred1==label:
                n_correct_next += 1
                flag = True
            if pred2 in multi_answers or pred2 == label:
                n_correct_last += 1
                flag = True
            if flag:
                n_correct_global += 1

        acc_next = n_correct_next/len(test_inputs) 
        acc_last = n_correct_last/len(test_inputs)
        acc_global = n_correct_global/len(test_inputs)
        return acc_next, acc_last, acc_global, answers



# In[13]:

class Model:
    def __init__(self,voca_size,n_embedding,embedding_checkpoint,n_embedding_voca,logfile,normalized_embedding=False):
        self.n_voca = voca_size
        self.n_embedding_voca = n_embedding_voca
        self.n_embedding = n_embedding
        self.logfile = logfile
        if embedding_checkpoint:
            self.embedding_mat = self.get_embedding_mat(embedding_checkpoint,normalized_embedding)
            print(f"successfully restore embedding model")
        else:
            self.embedding_mat = None
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
                with open(self.logfile,'a') as file:
                    file.write(f"===>Restore embedding from checkpoint: {embedding_checkpoint}.\n")
                    file.write("===>Normalize on embedding: {}.\n".format(normalized))
                if not normalized:
                    embed_mat = sess.run(embedding)
                else:
                    embed_mat = sess.run(normalized_embedding)
                return embed_mat
   
        
    def build(self,lstm_units,use_embedding=False,update_next=False):
        with open(self.logfile,'a') as file:
            file.write("Build file with Parameters:\n")
            file.write("[lstm_units: {}; use_embedding: {}; update_next: {};]\n".format(lstm_units,use_embedding, update_next))
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
        self.embedding_vec = embedding_vec
        lstmCell = tf.contrib.rnn.MultiRNNCell([tf.contrib.rnn.BasicLSTMCell(lstm_units),tf.contrib.rnn.BasicLSTMCell(lstm_units)])
        '''hidden_output is the output vectors of lstm cells [batch_size * time_steps * lstm_units]'''
        hidden_output, _ = tf.nn.dynamic_rnn(lstmCell,embedding_vec,dtype=tf.float32)
        self.hidden_output = hidden_output
        '''flatten it, but when update, only use the target one to update the network'''
        hidden_output = tf.reshape(hidden_output,[-1,lstm_units])
        
        softmax_weight = tf.Variable(tf.truncated_normal([lstm_units,self.n_voca]), name="softmax_weight")
        softmax_bias = tf.Variable(tf.constant(0.1, shape=[self.n_voca]))
        
        #hidden_output = tf.transpose(hidden_output,[1,0,2])  #batch_size * time_steps * lstm_units --> time_steps * batch_size * lstm_units
        #target_output = tf.gather(hidden_output, int(hidden_output.get_shape()[0])-1)
        '''pred is the vectors of all the timesteps, use last one or every step for update'''
        logits = tf.matmul(hidden_output,softmax_weight)+softmax_bias
        logits = tf.reshape(logits, [-1,n_time_step,self.n_voca])
        self.logits = logits
        #assert logits.get_shape().as_list() == [None,None,self.n_voca]            #targets = tf.one_hot(outputs,self.n_voca,axis=-1)
        index_offset = tf.fill(tf.stack([tf.shape(self.target_len)[0]]),-1)
        target_indices = tf.add(self.target_len,index_offset)
        mask = tf.one_hot(target_indices,n_time_step,dtype=tf.float32)
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
        self.pred = pred
        mask_pred = tf.multiply(tf.cast(pred,tf.float32),mask)
        self.mask = mask
        self.mask_pred = mask_pred

        
        pred_logits = tf.boolean_mask(logits,mask)
        pred_logits = tf.reshape(pred_logits,[-1,self.n_voca])
        self.softmax_prob = tf.nn.softmax(pred_logits)

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
        
    def train_and_test(self,train_input,test_input,epoch,batch_size):
        init = tf.global_variables_initializer()
        
       
        with tf.Session() as sess:
            sess.run(init)
            #iter_total=0
            #batch_count = 0
            
            for e in range(epoch):
                print("===============Start epoch {}=================".format(e+1))
                accuracy_writer.write("===============Start epoch {}=================\n".format(e+1))
                batch_cnt = 0
                for train_inputs,label_len, train_labels in train_input.get_batches(batch_size):
                    batch_cnt += 1
                    #print("get_batches out is type {}".format(type(train_inputs)))
                    input_len = np.array([len(i) for i in train_inputs])
                    train_inputs = self.data_helper.padding(train_inputs,0)
                    label_len = np.array([len(i) for i in train_labels])
                    train_labels = self.data_helper.padding(train_labels,0)
                    train_inputs.astype(int)
                    train_labels.astype(int)
                    label_len.astype(int)
                    #print("inputs")
                    #print(train_inputs)
                    #print("labels")
                    #print(train_labels)
                    #print("labels_len")
                    #print(label_len)
                    _,los, accur=sess.run([self.optimizer,self.loss,self.accuracy], feed_dict= {self.inputs:train_inputs, self.outputs:train_labels, self.target_len:label_len})
                    if batch_cnt % 100==0:
                        print("Epoch {}, Iteration {}: Training accuracy {}, Training loss {}".format(e+1,batch_cnt,accur,los))
                        accuracy_writer.write("Epoch {}, Iteration {}: Training accuracy {}, Training loss {}\n".format(e+1,batch_cnt,accur,los))
                
                self.lstm_saver.save(sess, "./lstm_{}.ckpt".format(e+1))
                print("====================Testing phase===================================")
                accuracy_writer.write("====================Testing phase===================================\n")
                accuracy_total = 0
                test_batch = 0
                for test_inputs, test_labels in self.data_helper.get_batches(test_file,batch_size):
                    test_input_len = np.array([len(i) for i in test_inputs])
                    test_inputs = self.data_helper.padding(test_inputs,0)
                    test_label_len = np.array([len(i) for i in test_labels])
                    test_labels = self.data_helper.padding(test_labels,0)
                    accur_test = sess.run(accuracy, feed_dict={inputs:test_inputs,outputs:test_labels,target_len:test_label_len})
                    accuracy_total += accur_test
                    test_batch += 1
                    accuracy_ave = accuracy_total/test_batch
              
                
                print("Test Accuracy after epoch {}: {}".format(e+1,accuracy_ave))
                accuracy_writer.write("Test Accuracy after epoch {}: {}\n".format(e+1,accuracy_ave))
                
    def sequence_embedding(self,train_input,epoch,batch_size,save_checkpoint):
        init = tf.global_variables_initializer()
        
        log = open(self.logfile,'a')
        log.write(f"Starting embedding sequence model with data {train_input.data_file}\n")
        with tf.Session() as sess:
            sess.run(init)
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
            

    def test_and_record(self,lstm_checkpoint,test_input,batch_size,correct_file,wrong_file):
        correct_recorder = open(correct_file,'w')
        correct_writer = csv.writer(correct_recorder)
        wrong_recorder = open(wrong_file,'w')
        wrong_writer = csv.writer(wrong_recorder)
        log = open(self.logfile,'a')
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore lstm model')
            log.write(f"Resotre lstm model from checkpoint: {lstm_checkpoint}.\n")
            log.write(f"Test with data: {test_input.data_file}.\n")
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
                for i in range(len(prediction)):
                    label = test_labels[i][test_label_len[i]-1]
                    if prediction[i] == label:
                        test_case_res = list(test_inputs[i])
                        test_case_res = test_case_res[:test_label_len[i]]
                        test_case_res.append('-111')
                        test_case_res.append(prediction[i])
                        test_case_res.append('-222')
                        test_case_res.append(label)  
                        
                                   
                        correct_writer.writerow(test_case_res)
                    else:
                        test_case_res = list(test_inputs[i])
                        test_case_res = test_case_res[:test_label_len[i]]
                        test_case_res.append('-111')
                        test_case_res.append(prediction[i])
                        test_case_res.append('-222')
                        test_case_res.append(label) 

                        wrong_writer.writerow(test_case_res)
                        
            
            acc_test = float(n_correct)/float(n_test)
            acc_second_last = float(n_correct_second)/float(n_test)
            log.write("Test Accuracy for last token: {}\n".format(acc_test))
            log.write("Test Accuracy for second last token: {}\n".format(acc_second_last))
            print("Test Accuracy for last token: {}".format(acc_test))
            print("Test Accuracy for second last token: {}".format(acc_second_last))
        log.write(f"Store correct cases in file: {correct_file}.\n")
        log.write(f"Store wrong cases in file: {wrong_file}\n")
        log.close()
        correct_recorder.close()
        wrong_recorder.close()
               
    def test_sq(self,sq,label,lstm_checkpoint):
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore lstm model')

            test_inputs = [sq]
            test_labels = [list(sq[1:])+[label]]
            test_label_len = np.array([len(sq)])
            last_acc, second_last_acc, prediction = sess.run([self.last_acc, self.second_last_acc,self.last_pred], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len})
            return prediction

    def test_for_case(self,inp,label,lstm_checkpoint):
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore lstm model')

            test_inputs = [inp]
            test_labels = [list(inp[1:])+[label]]
            test_label_len = np.array([len(inp)])
            prediction = sess.run([self.last_acc, self.second_last_acc,self.last_pred], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len})
            return prediction


    def test(self,lstm_checkpoint,test_input,batch_size):
        #correct_recorder = open(correct_file,'w')
        #correct_writer = csv.writer(correct_recorder)
        #wrong_recorder = open(wrong_file,'w')
        #wrong_writer = csv.writer(wrong_recorder)
        log = open(self.logfile,'a')
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

    def test_for_multiple_answers(self,lstm_checkpoint,test_input,train_input,batch_size,correct_file,wrong_file):
        correct_recorder = open(correct_file,'w')
        correct_writer = csv.writer(correct_recorder)
        wrong_recorder = open(wrong_file,'w')
        wrong_writer = csv.writer(wrong_recorder)
        log = open(self.logfile,'a')
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore lstm model')
            n_correct = 0
            n_correct_second = 0
            n_test = 0
            n_batch = test_input.n_data//batch_size+1
            i_batch = 0
            n_correct_multi = 0
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

                multi_acc, multi_answers = train_input.correct_acc(test_inputs,test_label_len,test_labels,prediction)
                n_correct_multi += int(multi_acc*len(test_inputs))
                for i in range(len(prediction)):
                    answers = multi_answers[i]
                    if prediction[i] in answers:
                        test_case_res = list(test_inputs[i])
                        test_case_res = test_case_res[:test_label_len[i]]
                        test_case_res.append('-111')
                        test_case_res.append(prediction[i])
                        test_case_res.append('-222')
                        test_case_res.append(answers)
                                
                        correct_writer.writerow(test_case_res)
                    else:
                        test_case_res = list(test_inputs[i])
                        test_case_res = test_case_res[:test_label_len[i]]
                        test_case_res.append('-111')
                        test_case_res.append(prediction[i])
                        test_case_res.append('-222')
                        test_case_res.append(answers)
                
                        wrong_writer.writerow(test_case_res)
                        
            
            acc_test = n_correct/n_test
            acc_second_last = n_correct_second/n_test
            acc_multi = float = n_correct_multi/n_test
            log.write("Test Accuracy for last token: {}\n".format(acc_test))
            log.write("Test Accuracy for second last token: {}\n".format(acc_second_last))
            log.write("Test Accuracy (multi-answers) for last token: {}\n".format(acc_multi))
            print("Test Accuracy for last token: {}".format(acc_test))
            print("Test Accuracy for second last token: {}".format(acc_second_last))
        log.close()

    def test_for_one_instance(self,lstm_checkpoint,sample_sequence,K,vocabulary):
        '''Given one input sequence, output the top k next tokens'''
        with tf.Session() as sess:
            # restore model
            self.lstm_saver.restore(sess, tf.train.latest_checkpoint(lstm_checkpoint))
            print('successfully restore lstm model')
            test_inputs = [sample_sequence[:-1]]
            test_labels = [sample_sequence[1:]]
            test_label_len = [len(sample_sequence)-1]

            # test for input sample:
            pred, prob = sess.run([self.last_pred,self.softmax_prob], feed_dict={self.inputs:test_inputs,self.outputs:test_labels,self.target_len:test_label_len})

            prob = prob[0]
            top_k = np.argsort(prob)[::-1]
            top_k = top_k[:K]
            print("==========================")
            print("Test input:",end = ' ')
            print([vocabulary[i] for i in sample_sequence[:-1]])
            print("Label:", end = ' ')
            print(vocabulary[sample_sequence[-1]])
            print("Top {} predictions:".format(K))
            for i in top_k:
                print("{}:{}".format(vocabulary[i],prob[i]))

            print("===========================")
    def debug_retrive_model(self,lstm_checkpoint):
        init = tf.global_variables_initializer()

        with tf.Session() as sess:
            sess.run(init)
            self.lstm_saver.restore(sess,tf.train.latest_checkpoint(lstm_checkpoint))
            sfm_w = sess.run(self.softmax_weight)
            sfm_b = sess.run(self.softmax_bias)
            np.savetxt('./softmax_weigth.txt',sfm_w)
            np.savetxt('./softmax_bias.txt',sfm_b)

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
                    label = int(row[2])
                    n_path = int(row[3])
                    path_len = [int(i) for i in row[4:9]]

                    
                    for path_id in range(n_path):
                        leng = path_len[path_id]
                        path = [int(i) for i in row[9+10*path_id:9+10*path_id+leng]]+[label]
                        path_in = [path[:-1]]
                        path_out = [path[1:]]
                        path_in_len = [len(path)-1]


                        last_pred, logits, hidden_output, embedding_vec = sess.run([self.last_pred,self.logits,self.hidden_output,self.embedding_vec], feed_dict={self.inputs:path_in,self.outputs:path_out,self.target_len:path_in_len})

                        with open('./debug_info.txt','a') as f_out:
                            f_out.write("Test sequence: {}\n".format(path))
                            f_out.write("length: {}\n".format(path_in_len))
                            f_out.write("Embedding_vec: \n")
                            f_out.write("{}\n".format(embedding_vec))
                            f_out.write("Hidden output:\n")
                            f_out.write("{}\n".format(hidden_output))
                            f_out.write("Logits:\n")
                            f_out.write("{}\n".format(logits))
                            f_out.write("Last_pred:\n")
                            f_out.write("{}\n".format(last_pred))
                            
        



            
        
        
    

