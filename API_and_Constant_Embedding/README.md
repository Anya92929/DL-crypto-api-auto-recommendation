## The API and Constant Embedding
We use skip-gram model to embed the token-level API methods and constants from the API methods and constants sequences.

### Dep2vec
We train dep2vec by applying skip-gram on the extracted dependence paths from API dependence graphs.

### Comparison Setting
To compare the program analysis design choices, we compare several settings.


|Embedding Name | Dep2vec         | Slice2vec  |  Byte2vec |
|---------------|-----------------|------------|-----------|
|Sequences      | Dependence paths| Slices     |  Byte code|
