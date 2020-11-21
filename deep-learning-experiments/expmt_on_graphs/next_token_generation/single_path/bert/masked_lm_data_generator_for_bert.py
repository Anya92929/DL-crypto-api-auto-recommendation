import argparse
import csv
import random

'''Convert the single path to masked single path for embedding usage
'''

parser = argparse.ArgumentParser()
parser.add_argument('--file_in', dest='file_in', type=str, help='The .csv file that include each path as a row')
parser.add_argument('--file_out', dest='file_out',type=str, help ='The .csv file that include the features the BERT model takes')
parser.add_argument('--log',dest='log',type=str,help='Record the configuration')
parser.add_argument('--masked_lm_prob', dest='masked_lm_prob',type=float, help='The percentage of masked token')
parser.add_argument('--max_predictions_per_seq',dest='max_predictions_per_seq',type=int,help='The maximum number of the masked token in each sentence')

args = parser.parse_args()
file_in = args.file_in
file_out = args.file_out
log = args.log
with open(log,'w') as f_log:
	f_log.write(f"Run input_processer.py on file {file_in}. Output the file {file_out}.\n")
	f_log.write(f"File {file_in} is the single sequences extracted from api_graph.txt for embedding usage.\n")
	f_log.write(f"File {file_out} is the masked language model pre-training data input for BERT model pretraining.\n")
	f_log.write("Parameters: [masked_lm_prob: {}; max_predictions_per_seq: {}; max_seq_len: 11;]\n")
	
# the percentage of masked token
MASK_PROB = args.masked_lm_prob 
# max number of masked token per sequence
MAX_MASK_LM = args.max_predictions_per_seq
def convert_masked_tokens(input_ids, masked_lm_positions, mask_per=0.8, original_per=0.5, masked_token_id = 1)
'''for the masked tokens in the inputs, 
mask_per (default 80%) of them are replaced by a special token symbol [MASK], 
for the remained part (20%), original_per (50%, overall 10%) of them are kept, 
the remained part (overall 10%) is randomly replaced by other tokens'''
    for i in masked_lm_positions:
    	if random.random() <mask_per:
    		input_ids[i] = masked_token_id
    	else:
    		if random.random()>original_per:
    			random_token_id = random.randint(2,4542)
    			input_ids[i] = random_token_id
    return input_ids

def mask_sentence(sentence, mask_prob, max_mask_lm,max_leng=11):

	if len(sentence)> max_leng:
		sentence = sentence[-max_leng:]
	input_ids = [i for i in sentence]
	segment_ids = [0 for i in sentence]
	input_mask = [1 for i in sentence]
	while len(input_ids)<max_leng:
		input_ids.append(0)
		segment_ids.append(0)
		input_mask.append(0)

	# select masked_lm
	masked_lm_positions = []
	masked_lm_ids = []
	masked_lm_weights = []
	n_mask = min(max_mask_lm,max(1,round(len(sentence)*mask_prob)))
	index = [i for i in range(len(sentence))]
    random.shuffle(index)
    
    for i in index:
    	if i >= n_mask:
    		break
    	masked_lm_positions.append(i)
    	masked_lm_ids.append(sentence[i])
    	masked_lm_weights.append(1.0)

    while len(masked_lm_ids)<max_mask_lm:
    	masked_lm_positions.append(0)
    	masked_lm_ids.append(0)
    	masked_lm_weights.append(0.0)

    input_ids = convert_masked_tokens(input_ids,masked_lm_positions)

    return input_ids,segment_ids,input_mask,masked_lm_positions,masked_lm_ids,masked_lm_weights

with open(file_in,'r') as f_in, open(file_out,'w') as f_out:
	reader = csv.reader(f_in)
	writer = csv.writer(f_out)
	writer.writerow(["input_ids","segment_ids","input_mask","masked_lm_positions","masked_lm_ids","masked_lm_weights"])
	for row in reader:
		sentence = [int(i) for i in row]
		features = mask_sentence(sentence,MASK_PROB,MAX_MASK_LM)
		writer.writerow(features)






