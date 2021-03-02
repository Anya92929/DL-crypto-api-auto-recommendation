package com.google.firebase.iid;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.firebase.iid.b */
public class C1980b {
    /* renamed from: a */
    public static KeyPair m8138a() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA"); // CRYPTOGRAPHIC API CALLSITE 9
            instance.initialize(2048); // CRYPTOGRAPHIC API CALLSITE 10
            return instance.generateKeyPair(); // CRYPTOGRAPHIC API CALLSITE 8
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
