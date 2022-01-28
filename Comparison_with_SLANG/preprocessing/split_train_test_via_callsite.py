import os
import argparse
import random
import numpy as np
import csv
import pandas as pd

parser = argparse.ArgumentParser()
parser.add_argument('--data_save_dir', dest='data_save_dir',type=str)
parser.add_argument('--data',dest='data',type=str)
parser.add_argument('--train_ratio', dest='train_ratio',type=int, default = 4)
parser.add_argument('--test_ratio',dest='test_ratio',type=int,default = 1)
args = parser.parse_args()


#test_prob = float(args.test_ratio)/float(args.test_ratio+args.train_ratio)
row_id_to_callsite = dict()
callsite_to_case_id = dict()

row_id = 0
with open(args.data,'r') as csv_file:
	reader = csv.reader(csv_file)
	for row in reader:
		app_callsite = row[0]+row[1]
		row_id_to_callsite[row_id] = app_callsite
		row_id += 1


#app_callsites: [callsite1, callsite1, callsite 2, callsite 2, callsite 3...]
#rowId_to_callsiteIds: [1, 1, 2, 2, 3...]

#callsiteId to rowId: case 1: (row 1, 2); case 2: (row 3, 4)
# callsiteIds: [1, ]
case_id = 0
for callsite in set(row_id_to_callsite.values()):
	callsite_to_case_id[callsite] = case_id
	case_id += 1


n_case = case_id
n_test = int(n_case*args.test_ratio/float(args.test_ratio+args.train_ratio))
n_train = n_case - n_test

is_test = [True for i in range(n_test)] + [False for i in range(n_train)]
random.shuffle(is_test)


rowId = 0
with open(args.data,'r') as csv_file, open(os.path.join(args.data_save_dir,'train.csv'),'w') as trainf, open(os.path.join(args.data_save_dir,'test.csv'),'w') as testf:
	reader = csv.reader(csv_file)
	train_writer = csv.writer(trainf)
	test_writer = csv.writer(testf)
	for row in reader:
		if is_test[callsite_to_case_id[row_id_to_callsite[rowId]]]:
		    test_writer.writerow(row)
		else:
			train_writer.writerow(row)
		rowId += 1


print("There are {} callsites in total!".format(n_case))
