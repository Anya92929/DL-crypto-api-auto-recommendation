
# coding: utf-8

# In[1]:

import nltk
from nltk.lm import MLE
import csv
import pandas as pd
from functools import partial
from itertools import chain
import os

from nltk.util import everygrams, pad_sequence
import argparse
parser = argparse.ArgumentParser()
parser.add_argument('--train_data',dest='train_data',type=str)
parser.add_argument('--test_data',dest='test_data',type=str)
parser.add_argument('--n',dest='n',type=int)
parser.add_argument('--output_prob_save',dest='output_prob_save',type=str)
parser.add_argument('--output_dir', dest='output_dir',type=str)
args = parser.parse_args()
n = args.n
data_file = args.train_data
test_file = args.test_data
output_prob_save = os.path.join(args.output_dir,args.output_prob_save)


# customized preprocessing for training grams and vocabulary without padding
flatten = chain.from_iterable
# changed to no pad
pad_both_ends = partial(
    pad_sequence,
    pad_left=False,
    left_pad_symbol=None,
    pad_right=False,
    right_pad_symbol=None,
)

def padded_everygrams(order, sentence):
    """Helper with some useful defaults.
    Applies pad_both_ends to sentence and follows it up with everygrams.
    """
    return everygrams(list(pad_both_ends(sentence, n=order)), max_len=order)


def prepare_train_gram_and_vocab(order, text):
    # changed from padded_everygram_pipeline
    # do not pad
    """Default preprocessing for a sequence of sentences.
    Creates two iterators:
    - sentences padded and turned into sequences of `nltk.util.everygrams`
    - sentences padded as above and chained together for a flat stream of words
    :param order: Largest ngram length produced by `everygrams`.
    :param text: Text to iterate over. Expected to be an iterable of sentences:
    Iterable[Iterable[str]]
    :return: iterator over text as ngrams, iterator over text as vocabulary data
    """
    padding_fn = partial(pad_both_ends, n=order)
    return (
        (everygrams(list(padding_fn(sent)), max_len=order) for sent in text),
        flatten(map(padding_fn, text)),
    )


# In[3]:

# prepare text 
def prepare_text(data_file):
    # data_file: train.csv from partial_history_int.csv 
    # each row of this file: app, callsite, 9, 2, 4, 2 (index of token in vocabulary)
    text = []
    with open(data_file,'r') as csv_file:
        reader = csv.reader(csv_file)
        for row in reader:
            sequence = [str(i) for i in row[2:]]
            text.append(sequence)    
    return text


# In[4]:

# training n-gram
#text = prepare_text(args.data_file)
n = 3
text = prepare_text(data_file)
train, vocab = prepare_train_gram_and_vocab(n, text)
lm = MLE(n)
lm.fit(train, vocab)






n_candidate = 4543
# test and calcualte output_prob
with open(test_file,'r') as csv_file,open(output_prob_save,'w') as savefile:
    reader = csv.reader(csv_file)
    writer = csv.writer(savefile)
    columns = ['vocab_{}'.format(i) for i in range(n_candidate)]
    writer.writerow(['app','callsite']+columns)
    for row in reader:
        sequence = [str(i) for i in row[2:]]
        if len(sequence) >1:
            output_prob = [lm.score(str(i),sequence[:-1]) for i in range(n_candidate)]
            writer.writerow(row[:2]+output_prob)
            
            


