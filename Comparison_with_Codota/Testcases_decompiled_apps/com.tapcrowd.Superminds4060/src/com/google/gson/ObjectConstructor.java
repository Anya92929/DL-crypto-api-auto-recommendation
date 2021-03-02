package com.google.gson;

import java.lang.reflect.Type;

interface ObjectConstructor {
    <T> T construct(Type type);

    Object constructArray(Type type, int i);
}
