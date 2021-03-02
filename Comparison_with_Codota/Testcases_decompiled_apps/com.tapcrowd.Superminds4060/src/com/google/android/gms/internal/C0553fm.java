package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.internal.C0537fi;
import com.google.android.gms.plus.PlusOneDummyView;

/* renamed from: com.google.android.gms.internal.fm */
public final class C0553fm {

    /* renamed from: pW */
    private static Context f1351pW;

    /* renamed from: rx */
    private static C0537fi f1352rx;

    /* renamed from: com.google.android.gms.internal.fm$a */
    public static class C0554a extends Exception {
        public C0554a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static View m1658a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0167c.m378b(m1660x(context).mo4805a(C0167c.m379g(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    /* renamed from: a */
    public static View m1659a(Context context, int i, int i2, String str, String str2) {
        if (str != null) {
            return (View) C0167c.m378b(m1660x(context).mo4806a(C0167c.m379g(context), i, i2, str, str2));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    /* renamed from: x */
    private static C0537fi m1660x(Context context) throws C0554a {
        C0411dm.m944e(context);
        if (f1352rx == null) {
            if (f1351pW == null) {
                f1351pW = GooglePlayServicesUtil.getRemoteContext(context);
                if (f1351pW == null) {
                    throw new C0554a("Could not get remote context.");
                }
            }
            try {
                f1352rx = C0537fi.C0538a.m1604ao((IBinder) f1351pW.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0554a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0554a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0554a("Could not access creator.");
            }
        }
        return f1352rx;
    }
}
