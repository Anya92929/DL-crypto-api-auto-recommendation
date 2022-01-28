# DL-crypto-api-auto-recommendation
## An open-sourced work for deep learning based cryptographic API recommendation solution.
It includes:
* The code to extract program analysis context for each API method call (Program Analysis Part)
* The code for training our Multi-HyLSTM (Deep Learning Part)
* The Android apps that are used as data source. (Original Data)
* The program analysis context (program slices, API dependence graphs) of each Java Cryptographic API method invoation extracted from the Android apps. (Preprocessed Data)

## Program Analysis Part

### CryptoSlicer: Interprocedural Backward slicing
It is a slicing program to extract interprocedural program slices for Java Cryptographic APIs from Android Apps.
#### Running CryptoSlicer with Command:
Run CryptoSlicer interatively on all apps through command: `java -jar CryptoSlicer.jar "app_name" "./output_dir_CryptoSlicer/"`


#### Outputs:
* Slice.txt: A file includes the extracted slices of all the scanned apps.
* {app_name}_graph.txt: A file for each scanned app. It includes the information needed to build API dependence graphs for this app. 

#### Prerequisites (Environment Variables)
1. `JAVA_HOME`: Point to a valid Java 8 JDK Installation
2. `ANDROID_SDK_HOME`: Point to a valid Android JDK Installation




### APIDepG: API dependence graph build and path extraction
It builds the API dependence graph on top of the program slices. 
#### Running APIDepG with Command:
* Run APIDepG interately on all the output  {app_name}_graph.txt files from the CryptoSlicer through command:
`python3 APIDepG/Graph_backward.py --data_dir "output_dir" --file {app_name}_graph.txt --vocab_dir "./Data/Vocabulary/Vocabulary.csv"`


A script to do that:

    FILES=output_dir_CryptoSlicer/*_graph.txt
    for f in $FILES
    do
        echo "Processing $f..."
        output=${f##*/}
        python3 APIDepG/Graph_backward.py --data_dir 'output_dir_paths' --file $f --vocab_dir './APIDepG/Vocabulary.csv'
    done

#### Outputs:
* `dataflow_paths.csv`: A file includes the single paths of all the apps.

## Neural Network Part
### API and Constant Embedding
We embed the APIs and associated constants as vectors by applying skip-gram model on the extracted dependence paths.

* Extract neighbor pairs of API methods and constants from sequences (dependence paths) 

`python3 get_neighbor_pairs.py dependence_path_file.csv neighbor_pairs.csv 1` 

* Run command for embedding:
```
python3 embedding_from_pairs.py --training-set-folder 'path/to/neighbor_pairs' 
                                --neighbor-pair-file 'neighbor_pairs.csv' 
                                --embedding-save-path 'embedding_output_dir' 
                                --embedding-name 'dep2vec' 
                                --epoch 100 
                                --batch-size 1024
```
### Single-path Pretraining (HyLSTM):
Pretrain HyLSTM model with all the single-path data:
```
python3 hylstm_path_pretraining.py --logfile 'log.txt'
                                   --output_dir 'save_dir'
                                   --embedding_checkpoint_dir 'dir/to/dep2vec'
                                   --embedding_checkpoint 'dep2vec'
                                   --data_dir 'dir/to/training/data'
                                   --pretraining_data ''
                                   --epoch 10
                                   --batch_size 1024
                                   --save_checkpoint 'pretrained_hylstm'

```

### Multi-path API Recommendation (Multi-HyLSTM)
* Split data as train.csv and test.csv

* API Recommendation Model Training and Testing
```
python3 Multi-HyLSTM_train.py --output_path 'save_dir'
                              --logfile 'log_multi_HyLSTM.txt'
                              --save_checkpoint 'save_multi_hylstm'
                              --embedding_checkpoint_path 'dir/to/dep2vec'
                              --embedding_checkpoint 'dep2vec'
                              --path_checkpoint_path 'dir/to/path/pretraining'
                              --path_checkpoint 'pretrained_hylstm'
                              --data_path 'dir/to/training/data'
                              --test_data 'test.csv'
                              --train_data 'train.csv'
                              --epoch 10
                              --batch_size 1024
```


## Comparison with Codota
We compare our approach with the state-of-the-art code completion plugin Codota. We manually collect 245 test cases by decompiling 9 Android apps and locating the cryptographic API method invocations in the codebase. The decompiled java source code can be found [here](https://github.com/Anya92929/DL-crypto-api-auto-recommendation/tree/main/Comparison_with_Codota). We marked each test case location with the note "CRYPTOGRAPHIC API CALLSITE xx" so that the test case can be located by searching the keywords "CRYPTOGRAPHIC API CALLSITE". 

An example of the cryptographic API method call in the codebase is as follows:

<img src="Comparison_with_Codota/testcase_example.png" alt="example" width="600"/>

## Comparison with SLANG
We reproduce the preprocessing and model used by SLANG. 

Enter the directory `Comparison_with_SLANG` : 
`cd Comparison_with_SLANG`


### SLANG preprocessing
Enter the directory `Comparison_with_SLANG/preprocessing` : 
`cd preprocessing`

#### Extract the partial object histories from Android Apps
Run the following command to perform SLANG's preprocessing on Android Apps:
`java -jar ObjectHistoryExtractor.jar 'path/to/app' './preprocessing_output/' `

##### Outputs:
* History.txt: A file includes the extracted partial object histories from Android Apps.

To scanning more Apps, put the paths to the Apps in a file (Apps.txt), use this script:
```
#!/bin/bash

declare -i count=0
file="Apps.txt"
TOTALLINES=$(wc -l < "$file")
while IFS= read -r line
do
    timeout 600 java -jar ../ObjectHistoryExtractor.jar "$line" "./preprocessing_output"
    count=$((count+1))
        echo "Finish No. $count apk: $line, in $ToTOALLINES"
done <"$file"
```

##### Prerequisites (Environment Variables)
1. `JAVA_HOME`: Point to a valid Java 8 JDK Installation
2. `ANDROID_SDK_HOME`: Point to a valid Android JDK Installation

#### Parse extracted partial histories to generate the data
```
python3 DatasetMaker.py --raw_data './preprocessing_output/Histories.txt' 
                        --vocabulary '../../Data/Vocabulary/Vocabulary.csv' --data_save_dir 'preprocessing_output/'
```

##### Output: 
* Partial_history_int.csv: A file includes all the partial object histories extracted from the Android Apps. A partial object history is a sequence of API method calls associated with an object that happens in temprary order. 

#### Split training and testing data
```
# split partial_history_int.csv into train.csv and test.csv
python3 split_train_test_via_callsite.py --data_save_dir './preprocessing_output/'
                                         --data 'partial_history_int.csv'
```

### SLANG modeling training
SLANG includes two models, RNN and n-gram. The output probabilities of the two models are combined to produce the final probability. 

Direct to directory `Comparison_with_SLANG/model`:
`cd ../model`

#### Train RNN on Partial Histroies
SLANG trains a RNN model on obtained partial histories.  
Run the following command:
```
python3 slang_rnn_tf.py --logfile 'log.txt'
                        --output_dir 'directory/to/save/output'
                        --save_checkpoints 'rnn_checkpoint'
                        --output_prob_save 'rnn_output_prob.csv'
                        --data_dir 'path/to/data/'
                        --train_data "train.csv"
                        --test_data "test.csv"
                        --rnn_units 512
                        --epoch 10
                        --batch_size 1024
```


#### Build N-gram model on Partail Histories
SLANG builds n-gram model on the obtained partial histories.  
Run the following command:
```
python3 N-gram_model.py --train-data 'path/to/training/data/train.csv'
                        --test_data 'path/to/test/data/test.csv' 
                        --n 3 
                        --output_prob_save 'ngram_prob.csv' 
                        --output_dir 'path/to/output/'
```

#### Merge probabilities from two models
The output probabilities from RNN and N-gram are combined to get the overall probability given each partial history.  
Run the following command:
```
python3 merge_rnn_ngram.py --rnn_prob 'path/to/rnn_output/rnn_prob.csv' 
                           --n_gram_prob 'path/to/ngram_prob.csv' 
                           --chunksize 5000 
                           --merged_prob_save 'merged_rnn_ngram_prob.csv'

```

#### Merge probabilities for partial histories
To generate API completion, SLANG combines several partial histories to genrate an optimal answer.  
Run the following command:
```
# merge partial history to get callsite answer
python3 merge_partial_history.py --prob_file 'merged_rnn_ngram_prob.csv' 
                                --answer_file 'callsite_answer.csv' # generated anwser
```

#### Calculate the accuracy based on generated answer
```
python3 cal_callsite_acc.py --answer_file 'callsite_answer.csv' 
                            --vocab_file '../../Data/Vocabulary/Vocabulary.csv' 
                            --acc_file 'calsite_acc.txt'  # output accuracy
```
#### 


## Data
Due to the storage limit, we only give a data sample (small part of the data) here. The full data can be found at [here](https://drive.google.com/drive/folders/1fc3A3ORcVJUDcPsH2jVHadpgTkbTs8nt?usp=sharing) (preserves viewer anonymity).
Our data includes:
* Some sample Android apps
* Program-analysis Context
   * Slices 
   * Dependence Paths
   * Multi-path Combinations
