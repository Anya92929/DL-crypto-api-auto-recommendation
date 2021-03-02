package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C2122h extends C1998aj {

    /* renamed from: ID */
    private static final String f4590ID = C0880a.APP_VERSION.toString();
    private final Context mContext;

    public C2122h(Context context) {
        super(f4590ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        try {
            return C2114di.m7124u(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            C2028bh.m6816T("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return C2114di.m7119pI();
        }
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
