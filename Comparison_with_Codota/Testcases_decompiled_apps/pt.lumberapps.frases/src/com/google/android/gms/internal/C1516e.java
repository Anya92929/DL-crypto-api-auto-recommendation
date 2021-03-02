package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.e */
final class C1516e implements Runnable {
    private C1516e() {
    }

    public void run() {
        try {
            MessageDigest unused = C1462c.f4909c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        } finally {
            C1462c.f4908b.countDown();
        }
    }
}
