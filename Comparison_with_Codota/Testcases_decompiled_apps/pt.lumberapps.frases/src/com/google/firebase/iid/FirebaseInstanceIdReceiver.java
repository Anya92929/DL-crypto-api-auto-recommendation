package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.p009v4.p010a.C0060z;
import android.util.Base64;
import android.util.Log;

public final class FirebaseInstanceIdReceiver extends C0060z {
    public void onReceive(Context context, Intent intent) {
        String str;
        if (isOrderedBroadcast()) {
            setResultCode(500);
        }
        intent.setComponent((ComponentName) null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        String stringExtra2 = intent.getStringExtra("from");
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction()) || "google.com/iid".equals(stringExtra2) || "gcm.googleapis.com/refresh".equals(stringExtra2)) {
            str = "com.google.firebase.INSTANCE_ID_EVENT";
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            str = "com.google.firebase.MESSAGING_EVENT";
        } else {
            Log.d("FirebaseInstanceId", "Unexpected intent");
            str = null;
        }
        int i = -1;
        if (str != null) {
            i = FirebaseInstanceIdInternalReceiver.m8115a(context, str, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(i);
        }
    }
}
