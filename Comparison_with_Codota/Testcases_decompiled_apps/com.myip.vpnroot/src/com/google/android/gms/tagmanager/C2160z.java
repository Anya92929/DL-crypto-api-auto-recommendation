package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C2160z extends C1998aj {

    /* renamed from: ID */
    private static final String f4609ID = C0880a.DEVICE_ID.toString();
    private final Context mContext;

    public C2160z(Context context) {
        super(f4609ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        String X = mo11783X(this.mContext);
        return X == null ? C2114di.m7119pI() : C2114di.m7124u(X);
    }

    /* access modifiers changed from: protected */
    /* renamed from: X */
    public String mo11783X(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
