package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0371c;
import com.google.android.gms.dynamic.C0373e;
import com.google.android.gms.internal.C0615q;

/* renamed from: com.google.android.gms.internal.t */
public final class C0622t extends C0373e<C0615q> {

    /* renamed from: ca */
    private static final C0622t f1432ca = new C0622t();

    private C0622t() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: d */
    public static View m1891d(Context context, int i, int i2) throws C0373e.C0374a {
        return f1432ca.m1892e(context, i, i2);
    }

    /* renamed from: e */
    private View m1892e(Context context, int i, int i2) throws C0373e.C0374a {
        try {
            return (View) C0371c.m701a(((C0615q) mo4132h(context)).mo5483a(C0371c.m702f(context), i, i2));
        } catch (Exception e) {
            throw new C0373e.C0374a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    /* renamed from: j */
    public C0615q mo4133k(IBinder iBinder) {
        return C0615q.C0616a.m1879i(iBinder);
    }
}
