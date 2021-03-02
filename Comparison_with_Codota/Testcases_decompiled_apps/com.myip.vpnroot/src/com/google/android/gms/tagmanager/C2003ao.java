package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ao */
class C2003ao extends C1998aj {

    /* renamed from: ID */
    private static final String f4535ID = C0880a.HASH.toString();
    private static final String aoU = C0929b.ARG0.toString();
    private static final String aoW = C0929b.INPUT_FORMAT.toString();
    private static final String apa = C0929b.ALGORITHM.toString();

    public C2003ao() {
        super(f4535ID, aoU);
    }

    /* renamed from: d */
    private byte[] m6760d(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        byte[] cj;
        C1026d.C1027a aVar = map.get(aoU);
        if (aVar == null || aVar == C2114di.m7119pI()) {
            return C2114di.m7119pI();
        }
        String j = C2114di.m7106j(aVar);
        C1026d.C1027a aVar2 = map.get(apa);
        String j2 = aVar2 == null ? "MD5" : C2114di.m7106j(aVar2);
        C1026d.C1027a aVar3 = map.get(aoW);
        String j3 = aVar3 == null ? "text" : C2114di.m7106j(aVar3);
        if ("text".equals(j3)) {
            cj = j.getBytes();
        } else if ("base16".equals(j3)) {
            cj = C2126j.m7170cj(j);
        } else {
            C2028bh.m6816T("Hash: unknown input format: " + j3);
            return C2114di.m7119pI();
        }
        try {
            return C2114di.m7124u(C2126j.m7171d(m6760d(j2, cj)));
        } catch (NoSuchAlgorithmException e) {
            C2028bh.m6816T("Hash: unknown algorithm: " + j2);
            return C2114di.m7119pI();
        }
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
