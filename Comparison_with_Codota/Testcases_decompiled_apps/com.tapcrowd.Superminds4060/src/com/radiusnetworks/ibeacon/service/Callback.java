package com.radiusnetworks.ibeacon.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;

public class Callback {
    private String TAG = "Callback";
    private Intent intent;
    private Messenger messenger;

    public Callback(String intentPackageName) {
        if (intentPackageName != null) {
            this.intent = new Intent();
            this.intent.setComponent(new ComponentName(intentPackageName, "com.radiusnetworks.ibeacon.IBeaconIntentProcessor"));
        }
    }

    public Intent getIntent() {
        return this.intent;
    }

    public void setIntent(Intent intent2) {
        this.intent = intent2;
    }

    public boolean call(Context context, String dataName, Parcelable data) {
        if (this.intent == null) {
            return false;
        }
        Log.d(this.TAG, "attempting callback via intent: " + this.intent.getComponent());
        this.intent.putExtra(dataName, data);
        context.startService(this.intent);
        return true;
    }
}
