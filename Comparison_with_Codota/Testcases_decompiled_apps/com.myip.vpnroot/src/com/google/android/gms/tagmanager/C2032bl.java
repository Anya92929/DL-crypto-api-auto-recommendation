package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.bl */
class C2032bl extends C1998aj {

    /* renamed from: ID */
    private static final String f4555ID = C0880a.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context mContext;

    public C2032bl(Context context) {
        super(f4555ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        String X = mo11586X(this.mContext);
        return X == null ? C2114di.m7119pI() : C2114di.m7124u(X);
    }

    /* access modifiers changed from: protected */
    /* renamed from: X */
    public String mo11586X(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
