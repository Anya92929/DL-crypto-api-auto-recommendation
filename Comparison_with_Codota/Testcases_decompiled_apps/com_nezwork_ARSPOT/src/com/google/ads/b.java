package com.google.ads;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class b {
    private static b c = null;
    private final BigInteger a = d();
    private BigInteger b = BigInteger.ONE;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    public synchronized BigInteger b() {
        return this.a;
    }

    public synchronized BigInteger c() {
        BigInteger bigInteger;
        bigInteger = this.b;
        this.b = this.b.add(BigInteger.ONE);
        return bigInteger;
    }

    private b() {
    }

    private static BigInteger d() {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");  //CRYPTOGRAPHIC API CALLSITE 22
            UUID randomUUID = UUID.randomUUID();
            instance.update(a(randomUUID.getLeastSignificantBits()));  //CRYPTOGRAPHIC API CALLSITE 23
            instance.update(a(randomUUID.getMostSignificantBits()));   ////CRYPTOGRAPHIC API CALLSITE 24
            byte[] bArr = new byte[9];
            bArr[0] = 0;
            System.arraycopy(instance.digest(), 0, bArr, 1, 8); //CRYPTOGRAPHIC API CALLSITE 21
            return new BigInteger(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot find MD5 message digest algorithm.");
        }
    }

    private static byte[] a(long j) {
        return BigInteger.valueOf(j).toByteArray();
    }
}
