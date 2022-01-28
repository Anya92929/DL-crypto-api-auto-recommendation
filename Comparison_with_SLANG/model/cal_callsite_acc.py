import pandas as pd 
import argparse
import csv
import numpy as np

parser = argparse.ArgumentParser()
parser.add_argument('--answer_file',dest='answer_file',type=str)
parser.add_argument('--vocab_file',dest='vocab_file',type=str)
parser.add_argument('--acc_file',dest='acc_file',type=str)
args = parser.parse_args()


def parse_answer(callsite,vocabulary):
	api = callsite[callsite.index('callee=')+len('callee='):callsite.index(', caller=')]
	try:
		return vocabulary.index(api)
	except:
		print(f"Unexpected callsite out of vocabulary: {callsite}")
		return 4542

with open(args.vocab_file,'r') as csv_file:
	reader = csv.reader(csv_file)
	vocab = [row[1] for row in reader]

answer_df = pd.read_csv(args.answer_file)
correct_count = []
for callsite, answer in zip(answer_df['callsite'].values,answer_df['answer'].values):
	answer_id = parse_answer(callsite,vocab)
	correct_count.append(answer_id == int(answer))

answer_df['Correct'] = correct_count

print("Callsite accuracy is {}".format(np.mean(correct_count)))
with open(args.acc_file,'w') as file:
	file.write("Callsite accuracy is {}\n".format(np.mean(correct_count)))

answer_df.to_csv(args.answer_file[:-4]+'_with_flag.csv')


