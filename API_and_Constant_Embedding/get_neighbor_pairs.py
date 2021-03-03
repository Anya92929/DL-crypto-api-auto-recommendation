
# coding: utf-8

# This file aims to extract neighbor pairs from traces (i.e. traces_sequence.csv).
# 
# The neighbor pairs are the input and output of an embedding network of dataflow2vec.

# In[1]:


import csv
from collections import Counter
import sys


# In[2]:


input_file = sys.argv[1]
out_file = sys.argv[2]
sliding_window = int(sys.argv[3])



# In[3]:


# open and read the trace data
with open (input_file,'r') as  csv_file:
    reader = csv.reader(csv_file)
    # reader is a collection of traces, each traces is a list of numbers (index of a token).
    
    trace_counter = Counter(tuple(item) for item in reader if "P" not in item and "F" not in item and "a" not in item and len(item)>1)


# In[4]:


# statistical info of traces
print("We have {} unique sequences.".format(len(trace_counter)))
print("Most common 35 are:")
print(trace_counter.most_common(35))



# accept trace tuple, get neibhors pairs out
def get_neighbor_pairs(trace, window=5):
    neighbors = []
    for i in range(len(trace)):
        for j in range(max(0,i-window),min(len(trace),i+window)):
            if i!=j:
                neighbors.append((trace[i],trace[j]))
    return neighbors


# ## Q1: How to deal with the duplicates?
# We should keep some duplicates to keep their distribution. However, there are too many duplicates. The traces themselves appear repeatedly. Moreover, there are many traces like: 
# 
# 1, 2, 3, 4, 5, 6; 
# 
# 1, 2, 3, 4, 5; 
# 
# 1, 2, 3, 4;

# In[21]:
# for slice sequence, we do it for all the sequences

# check whether short is a sebpart of long
def is_sub_trace(long, short):
    # if long==short, we keep it, in case of comparing a sequence and itself in the two-layered for loop
    if len(short)>=len(long):
        return False 
    else:
        for i in range(len(long)-len(short)):
            if long[i:i+len(short)] == short:
                return True
        return False







#print("We have {} mutually-exclusive unique sequences".format(len(unique_traces)))
import math
factor = 1e-6
original_freq = [trace_counter[trace] for trace in trace_counter]
total_trace = sum(original_freq)

new_freq = [int(min(1.0,(math.sqrt(float(i)/float(total_trace)/factor)+1)*factor/(float(i)/float(total_trace)))*i) for i in original_freq]
if 0 in new_freq:
    print("There are removed sequences")
index = 0
for key in trace_counter:
    trace_counter[key] = new_freq[index]
    index += 1
new_total_trace = sum(new_freq)
print("We have {} sequences in total".format(total_trace))
print("Adjust sequence frequency, now have {} sequences in total".format(new_total_trace))


# Due to too many duplicated traces, we deal with unique, longest traces to get neighbor pairs.
trace_neighbor_pairs = dict()
for trace in trace_counter:
    if (len(trace))> 1:
        neibhors_from_trace = get_neighbor_pairs(trace,sliding_window)
        # To keep the distribution, we record the pars with the trace
        trace_neighbor_pairs[trace] = neibhors_from_trace



# store these neighbor pairs
writer =  open(out_file,'w')
cnt = 0
for key in trace_neighbor_pairs:
    
    for freq in range(trace_counter[key]):
    	for pair in trace_neighbor_pairs[key]:        
    	    writer.write("{} {}\n".format(pair[0],pair[1]))
    	    cnt += 1
writer.close()
    
print("Collected {} neighbor pairs (has duplicates) in total".format(cnt))
