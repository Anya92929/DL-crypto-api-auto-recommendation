package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.google.android.gms.tagmanager.ci */
class C2060ci extends C2108dd {

    /* renamed from: ID */
    private static final String f4569ID = C0880a.REGEX.toString();
    private static final String aqe = C0929b.IGNORE_CASE.toString();

    public C2060ci() {
        super(f4569ID);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo11541a(String str, String str2, Map<String, C1026d.C1027a> map) {
        try {
            return Pattern.compile(str2, C2114di.m7110n(map.get(aqe)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
