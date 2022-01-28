import pandas as pd
import argparse
import csv

parser = argparse.ArgumentParser()
parser.add_argument('--rnn_prob',dest='rnn_prob',type=str)
parser.add_argument('--n_gram_prob',dest='n_gram_prob',type=str)
parser.add_argument('--chunksize', dest='chunksize',type=int)
parser.add_argument('--merged_prob_save',dest='merged_prob_save',type=str)
args = parser.parse_args()


n_candidate = 4543
columns = ["vocab_{}".format(i) for i in range(n_candidate)]
with open(args.merged_prob_save,'w') as file:
    writer = csv.writer(file)
    writer.writerow(columns+['app','callsite'])
for rnn_df, n_gram_df in zip(pd.read_csv(args.rnn_prob,usecols=['app','callsite']+columns,chunksize=args.chunksize),pd.read_csv(args.n_gram_prob,usecols=columns,chunksize=args.chunksize)):
    merged_data = (rnn_df[columns].values+n_gram_df.values)/2
    merged_df = pd.DataFrame(data=merged_data,columns=columns)
    merged_df['app'] = rnn_df['app']
    merged_df['callsite'] = rnn_df['callsite']
    merged_df.to_csv(args.merged_prob_save,mode='a', header=False,index=False)

