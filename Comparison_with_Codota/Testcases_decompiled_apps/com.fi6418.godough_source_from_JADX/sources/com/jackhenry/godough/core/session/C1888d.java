package com.jackhenry.godough.core.session;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jackhenry.godough.core.GoDoughApp;
import java.io.Serializable;

/* renamed from: com.jackhenry.godough.core.session.d */
public class C1888d extends BroadcastReceiver implements Serializable {
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra(SessionTimeoutWarningActivity.EXTRA_TIMEOUT, Long.MIN_VALUE);
        Intent intent2 = new Intent(GoDoughApp.getApp(), SessionTimeoutWarningActivity.class);
        intent2.putExtra(SessionTimeoutWarningActivity.EXTRA_TIMEOUT, longExtra);
        intent2.addFlags(268435456);
        intent2.addFlags(131072);
        intent2.addFlags(1073741824);
        intent2.addFlags(8388608);
        GoDoughApp.getApp().startActivity(intent2);
    }
}
