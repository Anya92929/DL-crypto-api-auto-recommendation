package com.nostra13.universalimageloader.cache.disc.naming;

import com.nostra13.universalimageloader.utils.C0847L;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5FileNameGenerator implements FileNameGenerator {
    private static final String HASH_ALGORITHM = "MD5";
    private static final int RADIX = 36;

    public String generate(String imageUri) {
        return new BigInteger(getMD5(imageUri.getBytes())).abs().toString(36);
    }

    private byte[] getMD5(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM); // CRYPTOGRAPHIC API CALLSITE 2
            digest.update(data); // CRYPTOGRAPHIC API CALLSITE 3
            return digest.digest(); // CRYPTOGRAPHIC API CALLSITE 1
        } catch (NoSuchAlgorithmException e) {
            C0847L.m2147e(e);
            return null;
        }
    }
}
