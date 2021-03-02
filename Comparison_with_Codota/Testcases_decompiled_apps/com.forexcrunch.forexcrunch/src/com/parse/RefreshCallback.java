package com.parse;

public abstract class RefreshCallback extends ParseCallback<ParseObject> {
    public abstract void done(ParseObject parseObject, ParseException parseException);

    /* access modifiers changed from: package-private */
    public final void internalDone(ParseObject returnValue, ParseException e) {
        done(returnValue, e);
    }
}
