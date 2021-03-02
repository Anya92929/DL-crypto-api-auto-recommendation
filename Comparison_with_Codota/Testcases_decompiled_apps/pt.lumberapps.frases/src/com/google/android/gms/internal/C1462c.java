package com.google.android.gms.internal;

import android.support.p009v4.app.NotificationCompat;
import com.google.android.gms.internal.zzae;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.c */
final class C1462c {

    /* renamed from: a */
    static boolean f4907a = false;

    /* renamed from: b */
    static CountDownLatch f4908b = new CountDownLatch(1);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static MessageDigest f4909c = null;

    /* renamed from: d */
    private static final Object f4910d = new Object();

    /* renamed from: e */
    private static final Object f4911e = new Object();

    /* renamed from: a */
    private static int m6289a(boolean z) {
        return z ? 239 : 255;
    }

    /* renamed from: a */
    static zzae.zza m6290a(long j) {
        zzae.zza zza = new zzae.zza();
        zza.zzdl = Long.valueOf(j);
        return zza;
    }

    /* renamed from: a */
    static String m6291a(zzae.zza zza, String str, boolean z) {
        return m6293a(zzapv.zzf(zza), str, z);
    }

    /* renamed from: a */
    static String m6292a(String str, String str2, boolean z) {
        byte[] b = m6301b(str, str2, z);
        return b != null ? zzaj.zza(b, true) : Integer.toString(7);
    }

    /* renamed from: a */
    static String m6293a(byte[] bArr, String str, boolean z) {
        return zzaj.zza(z ? m6302b(bArr, str) : m6299a(bArr, str), true);
    }

    /* renamed from: a */
    static Vector m6295a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + i) - 1) / i;
        Vector vector = new Vector();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * i;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > i ? i3 + i : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return vector;
    }

    /* renamed from: a */
    static void m6296a() {
        synchronized (f4911e) {
            if (!f4907a) {
                f4907a = true;
                new Thread(new C1516e()).start();
            }
        }
    }

    /* renamed from: a */
    static void m6297a(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new zzaoq(str.getBytes("UTF-8")).zzax(bArr);
    }

    /* renamed from: a */
    public static byte[] m6298a(byte[] bArr) {
        byte[] digest;
        synchronized (f4910d) {
            MessageDigest b = m6300b();
            if (b == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            b.reset();
            b.update(bArr);
            digest = f4909c.digest();
        }
        return digest;
    }

    /* renamed from: a */
    static byte[] m6299a(byte[] bArr, String str) {
        Vector a = m6295a(bArr, 255);
        if (a == null || a.size() == 0) {
            return m6302b(zzapv.zzf(m6290a(4096)), str);
        }
        zzae.zzf zzf = new zzae.zzf();
        zzf.zzey = new byte[a.size()][];
        Iterator it = a.iterator();
        int i = 0;
        while (it.hasNext()) {
            zzf.zzey[i] = m6303b((byte[]) it.next(), str, false);
            i++;
        }
        zzf.zzet = m6298a(bArr);
        return zzapv.zzf(zzf);
    }

    /* renamed from: b */
    static MessageDigest m6300b() {
        m6296a();
        boolean z = false;
        try {
            z = f4908b.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        if (z && f4909c != null) {
            return f4909c;
        }
        return null;
    }

    /* renamed from: b */
    static byte[] m6301b(String str, String str2, boolean z) {
        zzae.zzc zzc = new zzae.zzc();
        try {
            zzc.zzer = str.length() < 3 ? str.getBytes("ISO-8859-1") : zzaj.zza(str, true);
            zzc.zzes = z ? str2.length() < 3 ? str2.getBytes("ISO-8859-1") : zzaj.zza(str2, true) : (str2 == null || str2.length() == 0) ? Integer.toString(5).getBytes("ISO-8859-1") : zzaj.zza(m6293a(str2.getBytes("ISO-8859-1"), (String) null, true), true);
            return zzapv.zzf(zzc);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* renamed from: b */
    static byte[] m6302b(byte[] bArr, String str) {
        return m6303b(bArr, str, true);
    }

    /* renamed from: b */
    private static byte[] m6303b(byte[] bArr, String str, boolean z) {
        byte[] array;
        int a = m6289a(z);
        if (bArr.length > a) {
            bArr = zzapv.zzf(m6290a(4096));
        }
        if (bArr.length < a) {
            byte[] bArr2 = new byte[(a - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(a + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(a + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(NotificationCompat.FLAG_LOCAL_ONLY).put(m6298a(array)).put(array).array();
        }
        byte[] bArr3 = new byte[NotificationCompat.FLAG_LOCAL_ONLY];
        new zzal().mo7775a(array, bArr3);
        if (str != null && str.length() > 0) {
            m6297a(str, bArr3);
        }
        return bArr3;
    }
}
