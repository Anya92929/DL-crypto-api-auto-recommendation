package com.tapcrowd.app.utils.images;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Utils {
    public static void CopyStream(InputStream is, OutputStream os) {
        try {
            byte[] bytes = new byte[1024];
            while (true) {
                int count = is.read(bytes, 0, 1024);
                if (count != -1) {
                    os.write(bytes, 0, count);
                } else {
                    return;
                }
            }
        } catch (Exception e) {
        }
    }

    public static String generateId() {
        return md5("TC" + new Date().getTime());
    }

    public static String md5(String in) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 9
            digest.reset(); // CRYPTOGRAPHIC API CALLSITE 10
            digest.update(in.getBytes()); // CRYPTOGRAPHIC API CALLSITE 8
            byte[] a = digest.digest(); // CRYPTOGRAPHIC API CALLSITE 7
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
