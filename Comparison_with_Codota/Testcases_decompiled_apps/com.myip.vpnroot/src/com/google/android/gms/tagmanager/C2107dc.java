package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.dc */
class C2107dc extends C2108dd {

    /* renamed from: ID */
    private static final String f4581ID = C0880a.STARTS_WITH.toString();

    public C2107dc() {
        super(f4581ID);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11541a(String str, String str2, Map<String, C1026d.C1027a> map) {
        return str.startsWith(str2);
    }
}
