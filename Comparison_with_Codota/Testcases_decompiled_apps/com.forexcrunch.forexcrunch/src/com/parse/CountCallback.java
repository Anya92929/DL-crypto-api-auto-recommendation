package com.parse;

public abstract class CountCallback extends ParseCallback<Integer> {
    public abstract void done(int i, ParseException parseException);

    /* access modifiers changed from: package-private */
    public void internalDone(Integer returnValue, ParseException e) {
        if (e == null) {
            done(returnValue.intValue(), (ParseException) null);
        } else {
            done(-1, e);
        }
    }
}
