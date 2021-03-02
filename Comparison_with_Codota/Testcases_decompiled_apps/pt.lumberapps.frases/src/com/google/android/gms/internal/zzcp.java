package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zzin
public abstract class zzcp {

    /* renamed from: b */
    private static MessageDigest f6075b = null;

    /* renamed from: a */
    protected Object f6076a = new Object();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MessageDigest mo8234a() {
        MessageDigest messageDigest;
        synchronized (this.f6076a) {
            if (f6075b != null) {
                messageDigest = f6075b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        f6075b = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = f6075b;
            }
        }
        return messageDigest;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] zzaa(String str);
}
