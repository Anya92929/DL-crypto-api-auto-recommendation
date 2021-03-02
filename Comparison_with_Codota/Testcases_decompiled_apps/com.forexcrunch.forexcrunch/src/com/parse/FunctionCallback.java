package com.parse;

public abstract class FunctionCallback<T> extends ParseCallback<T> {
    public abstract void done(T t, ParseException parseException);

    /* access modifiers changed from: package-private */
    public final void internalDone(T returnValue, ParseException e) {
        done(returnValue, e);
    }
}
