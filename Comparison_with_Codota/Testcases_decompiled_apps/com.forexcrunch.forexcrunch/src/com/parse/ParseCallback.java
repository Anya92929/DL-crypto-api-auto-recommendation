package com.parse;

abstract class ParseCallback<T> {
    /* access modifiers changed from: package-private */
    public abstract void internalDone(T t, ParseException parseException);
}
