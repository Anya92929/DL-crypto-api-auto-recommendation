package com.google.ads;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* renamed from: com.google.ads.b */
public class C0207b {

    /* renamed from: c */
    private static C0207b f376c = null;

    /* renamed from: a */
    private final BigInteger f377a = m134d();

    /* renamed from: b */
    private BigInteger f378b = BigInteger.ONE;

    /* renamed from: a */
    public static synchronized C0207b m132a() {
        C0207b bVar;
        synchronized (C0207b.class) {
            if (f376c == null) {
                f376c = new C0207b();
            }
            bVar = f376c;
        }
        return bVar;
    }

    /* renamed from: b */
    public synchronized BigInteger mo3360b() {
        return this.f377a;
    }

    /* renamed from: c */
    public synchronized BigInteger mo3361c() {
        BigInteger bigInteger;
        bigInteger = this.f378b;
        this.f378b = this.f378b.add(BigInteger.ONE);
        return bigInteger;
    }

    private C0207b() {
    }

    /* renamed from: d */
    private static BigInteger m134d() {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 17
            UUID randomUUID = UUID.randomUUID();
            instance.update(m133a(randomUUID.getLeastSignificantBits())); // CRYPTOGRAPHIC API CALLSITE 18
            instance.update(m133a(randomUUID.getMostSignificantBits())); // CRYPTOGRAPHIC API CALLSITE 19
            byte[] bArr = new byte[9];
            bArr[0] = 0;
            System.arraycopy(instance.digest(), 0, bArr, 1, 8); // CRYPTOGRAPHIC API CALLSITE 16
            return new BigInteger(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot find MD5 message digest algorithm.");
        }
    }

    /* renamed from: a */
    private static byte[] m133a(long j) {
        return BigInteger.valueOf(j).toByteArray();
    }
}
