package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0371c;
import com.google.android.gms.internal.C0522bq;
import com.google.android.gms.plus.PlusOneDummyView;

/* renamed from: com.google.android.gms.internal.bu */
public final class C0538bu {

    /* renamed from: gN */
    private static Context f1171gN;

    /* renamed from: iy */
    private static C0522bq f1172iy;

    /* renamed from: com.google.android.gms.internal.bu$a */
    public static class C0539a extends Exception {
        public C0539a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static View m1531a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0371c.m701a(m1533m(context).mo4866a(C0371c.m702f(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    /* renamed from: a */
    public static View m1532a(Context context, int i, int i2, String str, String str2) {
        if (str != null) {
            return (View) C0371c.m701a(m1533m(context).mo4867a(C0371c.m702f(context), i, i2, str, str2));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    /* renamed from: m */
    private static C0522bq m1533m(Context context) throws C0539a {
        C0621s.m1890d(context);
        if (f1172iy == null) {
            if (f1171gN == null) {
                f1171gN = GooglePlayServicesUtil.getRemoteContext(context);
                if (f1171gN == null) {
                    throw new C0539a("Could not get remote context.");
                }
            }
            try {
                f1172iy = C0522bq.C0523a.m1437Z((IBinder) f1171gN.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0539a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0539a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0539a("Could not access creator.");
            }
        }
        return f1172iy;
    }
}
