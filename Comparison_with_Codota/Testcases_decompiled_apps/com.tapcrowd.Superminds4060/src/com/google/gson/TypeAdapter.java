package com.google.gson;

interface TypeAdapter {
    <T> T adaptType(Object obj, Class<T> cls);
}
