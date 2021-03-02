package com.parse;

import android.os.AsyncTask;

abstract class BackgroundTask<T> extends AsyncTask<Void, Void, Void> {
    private ParseCallback<T> callback;
    private ParseException exception = null;
    private T result = null;

    public abstract T run() throws ParseException;

    BackgroundTask(ParseCallback<T> theCallback) {
        this.callback = theCallback;
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Void... params) {
        try {
            this.result = run();
        } catch (ParseException e) {
            this.exception = e;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Void v) {
        if (this.callback != null) {
            this.callback.internalDone(this.result, this.exception);
        }
    }

    /* access modifiers changed from: package-private */
    public void executeInThisThread() {
        doInBackground(new Void[0]);
        onPostExecute((Void) null);
    }

    static int executeTask(BackgroundTask<?> task) {
        task.execute(new Void[0]);
        return 0;
    }
}
