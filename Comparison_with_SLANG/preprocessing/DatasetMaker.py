
# coding: utf-8



import csv
import os
import argparse


def event_to_vocab(event):
    # event: (api,param_id)   
    api = event[event.index('(<')+1:event.rindex('>, ')+1]
    return api
    
        

def vocab_to_int(vocab,vocabulary):
    if vocab in vocabulary:
        return vocabulary.index(vocab)
    else:
        return len(vocabulary)-1

limit_app_categories = ['COMMUNICATION','BUSINESS','FINANCE']
parser = argparse.ArgumentParser()
parser.add_argument('--raw_data',dest='raw_data',type=str,help='The History.txt got from the ObjectHistoryExtractor.jar')
parser.add_argument('--vocabulary',dest='vocab_file',type=str)
parser.add_argument('--data_save_dir',dest='data_save_dir',type=str)

app_category = None
args = parser.parse_args()
with open(args.vocab_file,'r') as file:
    reader = csv.reader(file)
    vocabulary = [row[1] for row in reader]

# from History.txt to partial_history.csv and partial_history_int.csv
with open(args.raw_data,'r') as file, open(os.path.join(args.data_save_dir,'partial_history.csv'),'w') as wf, open(os.path.join(args.data_save_dir,'partial_history_int.csv'),'w') as wf2:
    writer = csv.writer(wf)
    writer2 = csv.writer(wf2)
    for row in file:
        row = row.strip()
        
        if row.startswith("Analyzing "): 
            #update app category, app name
            app = row[len("Analyzing "):row.index(".apk=")+len(".apk")]
            app_category_and_name = app[len('/home/yax99/Projects/Smart_API/Android_APKs/'):]
            app_category, app_name = app_category_and_name.split('/')
        elif "Analyzing " in row:
            #If the former app ends with exception so Analyzing does not appear at the begining of a row.
            row = row[row.index("Analyzing "):]
            app = row[len("Analyzing "):row.index(".apk=")+len(".apk")]
            app_category_and_name = app[len('/home/yax99/Projects/Smart_API/Android_APKs/'):]
            app_category, app_name = app_category_and_name.split('/')
        elif row.startswith("Record Histories for callsite ") and row.endswith("---") and app_category in limit_app_categories:
            # update callsite, answer_api
            try:
                row = row[:row.index('---')]
            except:
                print(row)
            callsite = row[len("Record Histories for callsite "):]
            answer_api = row[row.index("callee=")+len("callee="):row.index(", caller=")]
        elif row.startswith("Obj ") and row.endswith(");") and '(null, null)' not in row and app_category in limit_app_categories:# in case that this row is not complete due to exception
            # update history
            param_id = int(row[len("Obj "):row.index(":")])
            answer = "({}, {})".format(answer_api,param_id)
            try:
                history = row[row.index("("):row.rindex(");")+1]
            except:
                print(row)
            history = history.split(";")
            #try:
                # Some versions have a bug here to put wrong parm id in this histories.d
            #    assert history[-1]==answer
            #except:
            #    print("Answer: {}".format(answer))
            #    print("History[-1]:{}".format(history[-1]))
            partial_history = [event_to_vocab(event) for event in history]
            partial_history_int = [vocab_to_int(event,vocabulary) for event in partial_history]
            writer.writerow([app_name,callsite]+partial_history)
            writer2.writerow([app_name,callsite]+partial_history_int)
            



