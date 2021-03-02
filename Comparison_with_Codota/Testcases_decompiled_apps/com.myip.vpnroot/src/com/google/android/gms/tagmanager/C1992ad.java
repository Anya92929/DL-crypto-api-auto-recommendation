package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ad */
class C1992ad extends C2108dd {

    /* renamed from: ID */
    private static final String f4529ID = C0880a.ENDS_WITH.toString();

    public C1992ad() {
        super(f4529ID);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11541a(String str, String str2, Map<String, C1026d.C1027a> map) {
        return str.endsWith(str2);
    }
}
