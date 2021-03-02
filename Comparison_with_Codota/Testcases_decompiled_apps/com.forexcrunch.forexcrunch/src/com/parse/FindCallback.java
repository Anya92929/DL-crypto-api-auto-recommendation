package com.parse;

import com.parse.ParseObject;
import java.util.List;

public abstract class FindCallback<T extends ParseObject> extends ParseCallback<List<T>> {
    public abstract void done(List<T> list, ParseException parseException);

    /* access modifiers changed from: package-private */
    public final void internalDone(List<T> returnValue, ParseException e) {
        done(returnValue, e);
    }
}
