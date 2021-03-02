package com.jackhenry.godough.core.rda;

import android.os.AsyncTask;
import android.os.Build;
import android.support.p000v4.app.FragmentActivity;

/* renamed from: com.jackhenry.godough.core.rda.v */
public class C1879v {
    /* renamed from: a */
    public static void m6836a(FragmentActivity fragmentActivity, int i) {
        m6837a(fragmentActivity, i, 0);
    }

    /* renamed from: a */
    public static void m6837a(FragmentActivity fragmentActivity, int i, int i2) {
        C1880w wVar = new C1880w(fragmentActivity, i2, i);
        String str = fragmentActivity.getFilesDir() + "/" + C1805aa.m6703a(i);
        if (Build.VERSION.SDK_INT >= 11) {
            wVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
            return;
        }
        wVar.execute(new String[]{str});
    }
}
