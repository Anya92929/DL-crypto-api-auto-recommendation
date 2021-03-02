package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.dynamic.C0169e;
import com.google.android.gms.internal.C0405dk;

/* renamed from: com.google.android.gms.internal.dn */
public final class C0412dn extends C0169e<C0405dk> {

    /* renamed from: ll */
    private static final C0412dn f1137ll = new C0412dn();

    private C0412dn() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: d */
    public static View m949d(Context context, int i, int i2) throws C0169e.C0170a {
        return f1137ll.m950e(context, i, i2);
    }

    /* renamed from: e */
    private View m950e(Context context, int i, int i2) throws C0169e.C0170a {
        try {
            return (View) C0167c.m378b(((C0405dk) mo3683t(context)).mo4385a(C0167c.m379g(context), i, i2));
        } catch (Exception e) {
            throw new C0169e.C0170a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    /* renamed from: y */
    public C0405dk mo3682d(IBinder iBinder) {
        return C0405dk.C0406a.m936x(iBinder);
    }
}
