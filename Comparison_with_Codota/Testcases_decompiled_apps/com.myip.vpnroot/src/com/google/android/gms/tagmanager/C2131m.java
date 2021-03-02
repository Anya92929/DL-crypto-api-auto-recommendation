package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C2131m extends C1998aj {

    /* renamed from: ID */
    private static final String f4593ID = C0880a.CONSTANT.toString();
    private static final String VALUE = C0929b.VALUE.toString();

    public C2131m() {
        super(f4593ID, VALUE);
    }

    /* renamed from: nO */
    public static String m7175nO() {
        return f4593ID;
    }

    /* renamed from: nP */
    public static String m7176nP() {
        return VALUE;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        return map.get(VALUE);
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
