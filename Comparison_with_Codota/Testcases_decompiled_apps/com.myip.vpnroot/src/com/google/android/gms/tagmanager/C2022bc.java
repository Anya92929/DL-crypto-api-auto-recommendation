package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.bc */
class C2022bc extends C1998aj {

    /* renamed from: ID */
    private static final String f4544ID = C0880a.LANGUAGE.toString();

    public C2022bc() {
        super(f4544ID, new String[0]);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return C2114di.m7119pI();
        }
        String language = locale.getLanguage();
        return language == null ? C2114di.m7119pI() : C2114di.m7124u(language.toLowerCase());
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return false;
    }
}
