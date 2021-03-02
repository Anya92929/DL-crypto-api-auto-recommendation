package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.google.android.gms.tagmanager.ch */
class C2059ch extends C1998aj {

    /* renamed from: ID */
    private static final String f4568ID = C0880a.REGEX_GROUP.toString();
    private static final String aqc = C0929b.ARG0.toString();
    private static final String aqd = C0929b.ARG1.toString();
    private static final String aqe = C0929b.IGNORE_CASE.toString();
    private static final String aqf = C0929b.GROUP.toString();

    public C2059ch() {
        super(f4568ID, aqc, aqd);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        int i;
        C1026d.C1027a aVar = map.get(aqc);
        C1026d.C1027a aVar2 = map.get(aqd);
        if (aVar == null || aVar == C2114di.m7119pI() || aVar2 == null || aVar2 == C2114di.m7119pI()) {
            return C2114di.m7119pI();
        }
        int i2 = 64;
        if (C2114di.m7110n(map.get(aqe)).booleanValue()) {
            i2 = 66;
        }
        C1026d.C1027a aVar3 = map.get(aqf);
        if (aVar3 != null) {
            Long l = C2114di.m7108l(aVar3);
            if (l == C2114di.m7114pD()) {
                return C2114di.m7119pI();
            }
            i = l.intValue();
            if (i < 0) {
                return C2114di.m7119pI();
            }
        } else {
            i = 1;
        }
        try {
            String j = C2114di.m7106j(aVar);
            String str = null;
            Matcher matcher = Pattern.compile(C2114di.m7106j(aVar2), i2).matcher(j);
            if (matcher.find() && matcher.groupCount() >= i) {
                str = matcher.group(i);
            }
            return str == null ? C2114di.m7119pI() : C2114di.m7124u(str);
        } catch (PatternSyntaxException e) {
            return C2114di.m7119pI();
        }
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
