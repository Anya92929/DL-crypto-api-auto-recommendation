package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C2121g extends C1998aj {

    /* renamed from: ID */
    private static final String f4589ID = C0880a.APP_NAME.toString();
    private final Context mContext;

    public C2121g(Context context) {
        super(f4589ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return C2114di.m7124u(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (PackageManager.NameNotFoundException e) {
            C2028bh.m6820b("App name is not found.", e);
            return C2114di.m7119pI();
        }
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
