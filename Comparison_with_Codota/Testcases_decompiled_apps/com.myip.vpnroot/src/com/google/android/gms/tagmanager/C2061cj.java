package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.cj */
class C2061cj extends C1998aj {

    /* renamed from: ID */
    private static final String f4570ID = C0880a.RESOLUTION.toString();
    private final Context mContext;

    public C2061cj(Context context) {
        super(f4570ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return C2114di.m7124u(i + "x" + displayMetrics.heightPixels);
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
