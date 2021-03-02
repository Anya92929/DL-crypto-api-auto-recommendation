# DL-crypto-api-auto-recommendation
## An open-sourced work for deep learning based cryptographic API recommendation solution.
It includes:
* The original Android apps that are used as data source.
* The program analysis context (program slices, API dependence graphs) of each Java Cryptographic API method invoation extracted from the Android apps. 
* The code to extract program analysis context for each API method call
* The code for training our Multi-HyLSTM

## Program Analysis Part

### CryptoSlicer: Interprocedural Backward slicing
It is a slicing program to extract interprocedural program slices for Java Cryptographic APIs from Android Apps.
#### Running with Command:
* Run CryptoSlicer on an app using the command:

`java -jar ../CryptoSlicer.jar "app_name" "./output_dir/"`

#### Prerequisites (Environment Variables)
1. `JAVA_HOME`: Point to a valid Java 8 JDK Installation
2. `ANDROID_SDK_HOME`: Point to a valid Android JDK Installation




### APIDepG: API dependence graph build and path extraction
The directory Graph_reconstruct includes the program to reconstruct the API dependence graph and extract paths. 

## Deep Learning Part
### Deep learning experiments including embedding training, API recommendation
The directory deep_Learning_experiments includes our code for API recommendtation training and testing, as well as extensive comparisons with intermediate baselines.  

## Comparison with Codota
We compare our approach with the state-of-the-art code completion plugin Codota. We manually collect 245 test cases by decompiling 9 Android apps and locating the cryptographic API method invocations in the codebase. The decompiled java source code can be found [here](https://github.com/Anya92929/DL-crypto-api-auto-recommendation/tree/main/Comparison_with_Codota). We marked each test case location with the note "CRYPTOGRAPHIC API CALLSITE xx" so that the test case can be located by searching the keywords "CRYPTOGRAPHIC API CALLSITE". 

An example of the cryptographic API method call in the codebase is as follows:

<img src="Comparison_with_Codota/testcase_example.png" alt="example" width="600"/>

## Data
The data is [here](https://drive.google.com/drive/folders/1fc3A3ORcVJUDcPsH2jVHadpgTkbTs8nt?usp=sharing) (preserves viewer anonymity).
