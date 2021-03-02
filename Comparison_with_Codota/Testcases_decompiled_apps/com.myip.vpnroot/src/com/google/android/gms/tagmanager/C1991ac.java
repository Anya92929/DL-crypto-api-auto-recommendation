package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ac */
class C1991ac extends C1998aj {

    /* renamed from: ID */
    private static final String f4528ID = C0880a.ENCODE.toString();
    private static final String aoU = C0929b.ARG0.toString();
    private static final String aoV = C0929b.NO_PADDING.toString();
    private static final String aoW = C0929b.INPUT_FORMAT.toString();
    private static final String aoX = C0929b.OUTPUT_FORMAT.toString();

    public C1991ac() {
        super(f4528ID, aoU);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        byte[] decode;
        String encodeToString;
        C1026d.C1027a aVar = map.get(aoU);
        if (aVar == null || aVar == C2114di.m7119pI()) {
            return C2114di.m7119pI();
        }
        String j = C2114di.m7106j(aVar);
        C1026d.C1027a aVar2 = map.get(aoW);
        String j2 = aVar2 == null ? "text" : C2114di.m7106j(aVar2);
        C1026d.C1027a aVar3 = map.get(aoX);
        String j3 = aVar3 == null ? "base16" : C2114di.m7106j(aVar3);
        C1026d.C1027a aVar4 = map.get(aoV);
        int i = (aVar4 == null || !C2114di.m7110n(aVar4).booleanValue()) ? 2 : 3;
        try {
            if ("text".equals(j2)) {
                decode = j.getBytes();
            } else if ("base16".equals(j2)) {
                decode = C2126j.m7170cj(j);
            } else if ("base64".equals(j2)) {
                decode = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                decode = Base64.decode(j, i | 8);
            } else {
                C2028bh.m6816T("Encode: unknown input format: " + j2);
                return C2114di.m7119pI();
            }
            if ("base16".equals(j3)) {
                encodeToString = C2126j.m7171d(decode);
            } else if ("base64".equals(j3)) {
                encodeToString = Base64.encodeToString(decode, i);
            } else if ("base64url".equals(j3)) {
                encodeToString = Base64.encodeToString(decode, i | 8);
            } else {
                C2028bh.m6816T("Encode: unknown output format: " + j3);
                return C2114di.m7119pI();
            }
            return C2114di.m7124u(encodeToString);
        } catch (IllegalArgumentException e) {
            C2028bh.m6816T("Encode: invalid input:");
            return C2114di.m7119pI();
        }
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
