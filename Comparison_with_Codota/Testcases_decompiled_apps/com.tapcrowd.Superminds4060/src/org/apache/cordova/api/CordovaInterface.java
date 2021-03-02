package org.apache.cordova.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.ExecutorService;

public interface CordovaInterface {
    @Deprecated
    void cancelLoadUrl();

    Activity getActivity();

    @Deprecated
    Context getContext();

    ExecutorService getThreadPool();

    Object onMessage(String str, Object obj);

    void setActivityResultCallback(CordovaPlugin cordovaPlugin);

    void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i);
}
