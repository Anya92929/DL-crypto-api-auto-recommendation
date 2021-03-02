package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.internal.C0342l;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0599g;

/* renamed from: com.google.android.gms.common.internal.o */
public final class C0349o extends C0599g<C0342l> {

    /* renamed from: Ma */
    private static final C0349o f796Ma = new C0349o();

    private C0349o() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: b */
    public static View m862b(Context context, int i, int i2) throws C0599g.C0600a {
        return f796Ma.m863c(context, i, i2);
    }

    /* renamed from: c */
    private View m863c(Context context, int i, int i2) throws C0599g.C0600a {
        try {
            return (View) C0597e.m1742f(((C0342l) mo5547L(context)).mo4546a(C0597e.m1743k(context), i, i2));
        } catch (Exception e) {
            throw new C0599g.C0600a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    /* renamed from: S */
    public C0342l mo4552d(IBinder iBinder) {
        return C0342l.C0343a.m846R(iBinder);
    }
}
