package com.parse;

public abstract class ProgressCallback extends ParseCallback<Integer> {
    Integer maxProgressSoFar = 0;

    public abstract void done(Integer num);

    /* access modifiers changed from: package-private */
    public final void internalDone(Integer percentDone, ParseException e) {
        if (percentDone.intValue() > this.maxProgressSoFar.intValue()) {
            this.maxProgressSoFar = percentDone;
            done(percentDone);
        }
    }
}
