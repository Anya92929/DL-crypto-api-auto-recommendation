package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.dynamic.C0599g;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C1949c;

/* renamed from: com.google.android.gms.plus.internal.g */
public final class C1965g extends C0599g<C1949c> {
    private static final C1965g alr = new C1965g();

    private C1965g() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    /* renamed from: a */
    public static View m6648a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0597e.m1742f(((C1949c) alr.mo5547L(context)).mo11326a(C0597e.m1743k(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bI */
    public C1949c mo4552d(IBinder iBinder) {
        return C1949c.C1950a.m6577bF(iBinder);
    }
}
