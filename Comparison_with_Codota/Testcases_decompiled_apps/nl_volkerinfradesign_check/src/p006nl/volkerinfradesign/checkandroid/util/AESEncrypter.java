package p006nl.volkerinfradesign.checkandroid.util;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import p006nl.volkerinfradesign.checkandroid.App;

/* renamed from: nl.volkerinfradesign.checkandroid.util.AESEncrypter */
public class AESEncrypter {

    /* renamed from: a */
    SecretKey f5661a = null;

    public AESEncrypter() {
        SharedPreferences sharedPreferences = App.getAppContext().getSharedPreferences("KeyPair", 0);
        try {
            if (!sharedPreferences.contains("picturesKey")) {
                String encodeToString = Base64.encodeToString(new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(UUID.randomUUID().toString().toCharArray(), generateSalt(), 2000, 256)).getEncoded(), "AES").getEncoded(), 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("picturesKey", encodeToString);
                edit.commit();
            }
            this.f5661a = new SecretKeySpec(Base64.decode(sharedPreferences.getString("picturesKey", (String) null), 0), "AES");
        } catch (Exception e) {
            Log.e("OOPS", e.getMessage());
        }
    }

    public byte[] generateSalt() {
        byte[] bArr = new byte[20];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public byte[] generateInitialisationVector() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public PrivateKey getPrivateKey(String str) {
        KeyFactory keyFactory;
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(str, 0));
        try {
            keyFactory = KeyFactory.getInstance("RSA", "BC");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            keyFactory = null;
        } catch (NoSuchProviderException e2) {
            e2.printStackTrace();
            keyFactory = null;
        }
        try {
            return keyFactory.generatePrivate(x509EncodedKeySpec);
        } catch (InvalidKeySpecException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void encryptFile(File file, File file2) throws Exception {
        byte[] generateInitialisationVector = generateInitialisationVector();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(generateInitialisationVector);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, this.f5661a, ivParameterSpec);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(generateInitialisationVector);
        CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, instance);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = cipherInputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.close();
                cipherInputStream.close();
                return;
            }
        }
    }

    public void decryptFile(File file, File file2) throws Exception {
        file2.delete();
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[16];
        fileInputStream.read(bArr, 0, 16);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr, 0, 16);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, this.f5661a, ivParameterSpec);
        CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream, instance);
        byte[] bArr2 = new byte[4096];
        while (true) {
            int read = cipherInputStream.read(bArr2, 17, 4096);
            if (read != -1) {
                fileOutputStream.write(bArr2, 17, read);
            } else {
                fileInputStream.close();
                fileOutputStream.close();
                cipherInputStream.close();
                return;
            }
        }
    }

    @Deprecated
    public byte[] encrypt(byte[] bArr) throws Exception {
        byte[] generateInitialisationVector = generateInitialisationVector();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(generateInitialisationVector);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, this.f5661a, ivParameterSpec);
        byte[] doFinal = instance.doFinal(bArr);
        byte[] bArr2 = new byte[(generateInitialisationVector.length + doFinal.length)];
        System.arraycopy(generateInitialisationVector, 0, bArr2, 0, generateInitialisationVector.length);
        System.arraycopy(doFinal, 0, bArr2, generateInitialisationVector.length, doFinal.length);
        return bArr2;
    }

    @Deprecated
    public byte[] decrypt(byte[] bArr) throws Exception {
        byte[] bArr2 = new byte[(bArr.length - 16)];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr, 0, 16);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, this.f5661a, ivParameterSpec);
        return instance.doFinal(bArr2);
    }
}
