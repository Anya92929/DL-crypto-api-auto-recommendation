package com.myip.vpnroot;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class mCrypt {
    static char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String SecretKey = "fdaf4g6789ebxfef";
    private Cipher cipher;

    /* renamed from: iv */
    private String f4692iv = "671229acd654f210";
    //  new IvParameterSpec(iv);
    private IvParameterSpec ivspec = new IvParameterSpec(this.f4692iv.getBytes()); // CRYPTOGRAPHIC API CALLSITE 9
    // new SecretKeySpec(key, algorithm);
	private SecretKeySpec keyspec = new SecretKeySpec(this.SecretKey.getBytes(), "AES"); // CRYPTOGRAPHIC API CALLSITE 22

    public mCrypt() {
        try {
            this.cipher = Cipher.getInstance("AES/CBC/NoPadding"); // CRYPTOGRAPHIC API CALLSITE 21
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        }
    }

    public byte[] encrypt(String text) throws Exception {
        if (text == null || text.length() == 0) {
            text = "";
        }
        try {
            this.cipher.init(1, this.keyspec, this.ivspec); // CRYPTOGRAPHIC API CALLSITE 25
            return this.cipher.doFinal(padString(text).getBytes());
        } catch (Exception e) {
            throw new Exception("[encrypt] " + e.getMessage());
        }
    }

    public byte[] decrypt(String code) throws Exception {
        if (code == null || code.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            this.cipher.init(2, this.keyspec, this.ivspec); // CRYPTOGRAPHIC API CALLSITE 10
            byte[] decrypted = this.cipher.doFinal(hexToBytes(code)); // CRYPTOGRAPHIC API CALLSITE 8
            if (decrypted.length <= 0) {
                return decrypted;
            }
            int trim = 0;
            for (int i = decrypted.length - 1; i >= 0; i--) {
                if (decrypted[i] == 0) {
                    trim++;
                }
            }
            if (trim <= 0) {
                return decrypted;
            }
            byte[] newArray = new byte[(decrypted.length - trim)];
            System.arraycopy(decrypted, 0, newArray, 0, decrypted.length - trim);
            return newArray;
        } catch (Exception e) {
            throw new Exception("[decrypt] " + e.getMessage());
        }
    }

    public static String bytesToHex(byte[] buf) {
        char[] chars = new char[(buf.length * 2)];
        for (int i = 0; i < buf.length; i++) {
            chars[i * 2] = HEX_CHARS[(buf[i] & 240) >>> 4];
            chars[(i * 2) + 1] = HEX_CHARS[buf[i] & 15];
        }
        return new String(chars);
    }

    public static byte[] hexToBytes(String str) {
        byte[] buffer = null;
        if (str != null && str.length() >= 2) {
            int len = str.length() / 2;
            buffer = new byte[len];
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
            }
        }
        return buffer;
    }

    private static String padString(String source) {
        int padLength = 16 - (source.length() % 16);
        for (int i = 0; i < padLength; i++) {
            source = source + 0;
        }
        return source;
    }
}
