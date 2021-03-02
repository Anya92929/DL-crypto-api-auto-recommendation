package com.google.gson;

interface Cache<K, V> {
    void addElement(K k, V v);

    void clear();

    V getElement(K k);

    V removeElement(K k);

    int size();
}
