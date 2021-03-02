package com.jackhenry.godough.core.rda;

import android.content.Context;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1585n;

/* renamed from: com.jackhenry.godough.core.rda.ad */
public class C1808ad {

    /* renamed from: a */
    private static C1808ad f6649a;

    public C1808ad(Context context) {
    }

    /* renamed from: a */
    public static C1808ad m6711a(Context context) {
        if (f6649a == null) {
            f6649a = new C1808ad(context);
        }
        return f6649a;
    }

    /* renamed from: a */
    public boolean mo11013a(String str, Context context) {
        C1805aa.m6705a(str);
        new C1585n(context).mo9814e((String) null);
        GoDoughApp.wipeRDACodes();
        return true;
    }
}
