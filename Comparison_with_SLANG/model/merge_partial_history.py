import csv
import numpy as np
import argparse


# considering the size of the data file, we may not be able to read it in memory with once
# we can read chunk by chunk and use df.groupby(['app','callsite']).mean(), however, not sure the complexity of groupby
# deal with it line by line
parser = argparse.ArgumentParser()
parser.add_argument('--prob_file',dest='prob_file',type=str)  # input file
parser.add_argument('--answer_file',dest='answer_file',type=str) # output file

args = parser.parse_args()
prob_file = args.prob_file
answer_file = args.answer_file

app_callsite = None
with open(prob_file,'r') as file, open(answer_file,'w') as answer_file:
	reader = csv.reader(file)
	writer = csv.writer(answer_file)
	writer.writerow(['app','callsite','answer'])
	next(reader) # header
	prob_multi_history = []
	for row in reader:
		current_app_callsite = row[-2]+row[-1]
		prob = [float(i) for i in row[:-2]]
		if not app_callsite:
		    app_callsite = current_app_callsite 
		if (app_callsite != current_app_callsite):
			# summary for app callsite
			merge_prob = np.mean(np.array(prob_multi_history),axis=0)
			answer = np.argmax(merge_prob)
			split = app_callsite.index('.apk')+4
			app = app_callsite[:split]
			callsite = app_callsite[split:]
			writer.writerow([app,callsite,answer])
			app_callsite = current_app_callsite
			prob_multi_history = [prob]
		else:
			prob_multi_history.append(prob)



