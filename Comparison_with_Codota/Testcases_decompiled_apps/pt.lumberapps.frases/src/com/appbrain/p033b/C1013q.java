package com.appbrain.p033b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.appbrain.b.q */
public final class C1013q {

    /* renamed from: a */
    public static final byte[] f2662a;

    /* renamed from: b */
    public static final ByteBuffer f2663b;

    static {
        byte[] bArr = new byte[0];
        f2662a = bArr;
        f2663b = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    public static boolean m4247a(byte[] bArr) {
        return C0996ak.m4141a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public static String m4248b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }
}
