package com.google.android.gms.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: com.google.android.gms.common.a */
class C1338a extends Handler {

    /* renamed from: a */
    private final Context f4286a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1338a(Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f4286a = context.getApplicationContext();
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f4286a);
                if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                    GooglePlayServicesUtil.m5951b(isGooglePlayServicesAvailable, this.f4286a);
                    return;
                }
                return;
            default:
                Log.w("GooglePlayServicesUtil", new StringBuilder(50).append("Don't know how to handle this message: ").append(message.what).toString());
                return;
        }
    }
}
