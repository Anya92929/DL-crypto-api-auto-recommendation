package com.google.android.gms.internal;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* renamed from: com.google.android.gms.internal.cf */
public final class C0331cf {

    /* renamed from: gL */
    private static final Object f996gL = new Object();

    /* renamed from: hB */
    public static final String f997hB;

    /* renamed from: hC */
    private static BigInteger f998hC = BigInteger.ONE;

    static {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(byteArray);
                instance.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(instance.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        f997hB = bigInteger;
    }

    /* renamed from: al */
    public static String m685al() {
        String bigInteger;
        synchronized (f996gL) {
            bigInteger = f998hC.toString();
            f998hC.add(BigInteger.ONE);
        }
        return bigInteger;
    }
}
