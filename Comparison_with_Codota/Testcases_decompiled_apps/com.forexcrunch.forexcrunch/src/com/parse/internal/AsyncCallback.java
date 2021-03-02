package com.parse.internal;

public interface AsyncCallback {
    void onCancel();

    void onFailure(Throwable th);

    void onSuccess(Object obj);
}
