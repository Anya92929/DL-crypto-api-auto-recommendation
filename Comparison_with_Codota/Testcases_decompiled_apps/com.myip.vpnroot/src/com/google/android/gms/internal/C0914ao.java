package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.internal.ao */
public abstract class C0914ao {

    /* renamed from: nI */
    private static MessageDigest f2597nI = null;

    /* renamed from: mw */
    protected Object f2598mw = new Object();

    /* access modifiers changed from: protected */
    /* renamed from: ba */
    public MessageDigest mo8000ba() {
        MessageDigest messageDigest;
        synchronized (this.f2598mw) {
            if (f2597nI != null) {
                messageDigest = f2597nI;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        f2597nI = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = f2597nI;
            }
        }
        return messageDigest;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public abstract byte[] mo8001l(String str);
}
