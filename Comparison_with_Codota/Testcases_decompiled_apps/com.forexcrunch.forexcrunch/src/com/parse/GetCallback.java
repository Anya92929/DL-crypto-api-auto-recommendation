package com.parse;

import com.parse.ParseObject;

public abstract class GetCallback<T extends ParseObject> extends ParseCallback<T> {
    public abstract void done(T t, ParseException parseException);

    /* access modifiers changed from: package-private */
    public final void internalDone(T returnValue, ParseException e) {
        done(returnValue, e);
    }
}
