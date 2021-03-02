package com.jackhenry.godough.core.rda;

import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.p038e.C1585n;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.jackhenry.godough.core.rda.aa */
public class C1805aa {
    /* renamed from: a */
    public static String m6703a(int i) {
        C1585n nVar = new C1585n(GoDoughApp.getApp());
        String i2 = nVar.mo9818i();
        if (i2 == null) {
            i2 = String.valueOf(Calendar.getInstance().getTimeInMillis());
            nVar.mo9814e(i2);
        }
        switch (i) {
            case 0:
                return "JHA-RDA-Image-" + i2 + "-front" + ".jpg";
            case 1:
                return "JHA-RDA-Image-" + i2 + "-back" + ".jpg";
            default:
                return "JHA-RDA-Image-" + i2 + "-front" + ".jpg";
        }
    }

    /* renamed from: a */
    private static void m6704a() {
        if (GoDoughApp.getRdacode() == null && GoDoughApp.getRdaIV() == null) {
            try {
                KeyGenerator instance = KeyGenerator.getInstance("AES");
                instance.init(128);
                GoDoughApp.setRdacode(instance.generateKey());
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                GoDoughApp.setRdaIV(bArr);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m6705a(String str) {
        File[] listFiles = new File(str).listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].getName().contains("JHA-RDA-Image-")) {
                listFiles[i].delete();
            }
        }
    }

    /* renamed from: a */
    public static boolean m6706a(String str, byte[] bArr) {
        boolean z = false;
        try {
            FileOutputStream openFileOutput = GoDoughApp.getApp().openFileOutput(str, 0);
            if (openFileOutput != null) {
                try {
                    openFileOutput.write(m6708a(bArr));
                    openFileOutput.close();
                    z = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        System.gc();
        return z;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0057=Splitter:B:23:0x0057, B:15:0x0049=Splitter:B:15:0x0049} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m6707a(int r7, android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = m6703a((int) r7)
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r4 = r8.getFilesDir()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = java.io.File.separator
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r3.<init>(r1)
            boolean r1 = r3.exists()
            if (r1 == 0) goto L_0x0041
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0055, all -> 0x0063 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0055, all -> 0x0063 }
            long r4 = r3.length()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0071 }
            int r1 = (int) r4     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0071 }
            byte[] r1 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0071 }
            r2.read(r1)     // Catch:{ FileNotFoundException -> 0x007a, IOException -> 0x0073 }
            byte[] r0 = m6710b(r1)     // Catch:{ FileNotFoundException -> 0x007a, IOException -> 0x0073 }
            r2.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0041:
            return r0
        L_0x0042:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0041
        L_0x0047:
            r1 = move-exception
            r2 = r0
        L_0x0049:
            r1.printStackTrace()     // Catch:{ all -> 0x006f }
            r2.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0041
        L_0x0050:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0041
        L_0x0055:
            r1 = move-exception
            r2 = r0
        L_0x0057:
            r1.printStackTrace()     // Catch:{ all -> 0x006f }
            r2.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0041
        L_0x005e:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0041
        L_0x0063:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0066:
            r2.close()     // Catch:{ IOException -> 0x006a }
        L_0x0069:
            throw r0
        L_0x006a:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0069
        L_0x006f:
            r0 = move-exception
            goto L_0x0066
        L_0x0071:
            r1 = move-exception
            goto L_0x0057
        L_0x0073:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x0057
        L_0x0078:
            r1 = move-exception
            goto L_0x0049
        L_0x007a:
            r0 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jackhenry.godough.core.rda.C1805aa.m6707a(int, android.content.Context):byte[]");
    }

    /* renamed from: a */
    private static byte[] m6708a(byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            m6704a();
            instance.init(1, GoDoughApp.getRdacode(), new IvParameterSpec(GoDoughApp.getRdaIV()));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            try {
                Cipher instance2 = Cipher.getInstance("DESede/CBC/PKCS5Padding");
                m6709b();
                instance2.init(1, GoDoughApp.getRdacode2(), new IvParameterSpec(GoDoughApp.getRdaIV()));
                return instance2.doFinal(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return bArr;
            }
        }
    }

    /* renamed from: b */
    private static void m6709b() {
        if (GoDoughApp.getRdacode2() == null) {
            GoDoughApp.wipeRDACodes();
            try {
                KeyGenerator instance = KeyGenerator.getInstance("DESede");
                instance.init(168);
                GoDoughApp.setRdacode2(instance.generateKey());
                byte[] bArr = new byte[8];
                new SecureRandom().nextBytes(bArr);
                GoDoughApp.setRdaIV(bArr);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private static byte[] m6710b(byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, GoDoughApp.getRdacode(), new IvParameterSpec(GoDoughApp.getRdaIV()));
            return instance.doFinal(bArr);
        } catch (Exception e) {
            try {
                Cipher instance2 = Cipher.getInstance("DESede/CBC/PKCS5Padding");
                instance2.init(2, GoDoughApp.getRdacode2(), new IvParameterSpec(GoDoughApp.getRdaIV()));
                return instance2.doFinal(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return bArr;
            }
        }
    }
}
