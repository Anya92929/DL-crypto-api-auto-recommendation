package com.p028a.p031c;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.app.NotificationCompat;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.a.c.a */
public class C0776a {

    /* renamed from: a */
    public static boolean f2003a = false;

    /* renamed from: b */
    private static boolean f2004b = false;

    /* renamed from: c */
    private static Object f2005c;

    /* renamed from: d */
    private static Thread.UncaughtExceptionHandler f2006d;

    /* renamed from: e */
    private static Map f2007e = new HashMap();

    /* renamed from: f */
    private static Handler f2008f;

    /* renamed from: g */
    private static ScheduledExecutorService f2009g;

    /* renamed from: h */
    private static File f2010h;

    /* renamed from: i */
    private static File f2011i;

    /* renamed from: j */
    private static final char[] f2012j = new char[64];

    /* renamed from: k */
    private static final byte[] f2013k = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            f2012j[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            f2012j[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            f2012j[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        int i2 = i + 1;
        f2012j[i] = '+';
        int i3 = i2 + 1;
        f2012j[i2] = '/';
        for (int i4 = 0; i4 < f2013k.length; i4++) {
            f2013k[i4] = -1;
        }
        for (int i5 = 0; i5 < 64; i5++) {
            f2013k[f2012j[i5]] = (byte) i5;
        }
    }

    /* renamed from: a */
    public static File m3510a(Context context) {
        if (f2010h == null) {
            f2010h = new File(context.getCacheDir(), "aquery");
            f2010h.mkdirs();
        }
        return f2010h;
    }

    /* renamed from: a */
    public static File m3511a(Context context, int i) {
        if (i != 1) {
            return m3510a(context);
        }
        if (f2011i != null) {
            return f2011i;
        }
        f2011i = new File(m3510a(context), "persistent");
        f2011i.mkdirs();
        return f2011i;
    }

    /* renamed from: a */
    public static File m3512a(File file, String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith(File.separator) ? new File(str) : m3539c(file, m3532b(str));
    }

    /* renamed from: a */
    public static Object m3513a(Object obj, String str, boolean z, boolean z2, Class[] clsArr, Class[] clsArr2, Object... objArr) {
        try {
            return m3515a(obj, str, z, clsArr, clsArr2, objArr);
        } catch (Exception e) {
            if (z2) {
                m3535b((Throwable) e);
            } else {
                m3527a((Throwable) e);
            }
            return null;
        }
    }

    /* renamed from: a */
    public static Object m3514a(Object obj, String str, boolean z, boolean z2, Class[] clsArr, Object... objArr) {
        return m3513a(obj, str, z, z2, clsArr, (Class[]) null, objArr);
    }

    /* renamed from: a */
    private static Object m3515a(Object obj, String str, boolean z, Class[] clsArr, Class[] clsArr2, Object... objArr) {
        if (obj == null || str == null) {
            return null;
        }
        if (clsArr == null) {
            try {
                clsArr = new Class[0];
            } catch (NoSuchMethodException e) {
                if (!z) {
                    return null;
                }
                if (clsArr2 != null) {
                    return obj.getClass().getMethod(str, clsArr2).invoke(obj, objArr);
                }
                try {
                    return obj.getClass().getMethod(str, new Class[0]).invoke(obj, new Object[0]);
                } catch (NoSuchMethodException e2) {
                    return null;
                }
            }
        }
        return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
    }

    /* renamed from: a */
    private static String m3516a(String str) {
        return new BigInteger(m3530a(str.getBytes())).abs().toString(36);
    }

    /* renamed from: a */
    public static void m3517a() {
        if (f2004b && f2005c != null) {
            synchronized (f2005c) {
                f2005c.notifyAll();
            }
        }
    }

    /* renamed from: a */
    public static void m3518a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static void m3519a(File file, long j, long j2) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles, new C0778c());
                if (m3528a(listFiles, j)) {
                    m3536b(listFiles, j2);
                }
                File d = m3540d();
                if (d != null && d.exists()) {
                    m3536b(d.listFiles(), 0);
                }
            }
        } catch (Exception e) {
            m3535b((Throwable) e);
        }
    }

    /* renamed from: a */
    public static void m3520a(File file, byte[] bArr) {
        try {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    m3534b((Object) "file create fail", (Object) file);
                    m3535b((Throwable) e);
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e2) {
            m3535b((Throwable) e2);
        }
    }

    /* renamed from: a */
    public static void m3521a(File file, byte[] bArr, long j) {
        m3541e().schedule(new C0778c().mo3561a(1, file, bArr), j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public static void m3522a(InputStream inputStream, OutputStream outputStream) {
        m3523a(inputStream, outputStream, 0, (C0780e) null);
    }

    /* renamed from: a */
    public static void m3523a(InputStream inputStream, OutputStream outputStream, int i, C0780e eVar) {
        if (eVar != null) {
            eVar.mo3575a();
            eVar.mo3576a(i);
        }
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_ENTER_MASK];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i2++;
                if (f2003a && i2 > 2) {
                    m3524a((Object) "simulating internet error");
                    throw new IOException();
                } else if (eVar != null) {
                    eVar.mo3578b(read);
                }
            } else if (eVar != null) {
                eVar.mo3577b();
                return;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m3524a(Object obj) {
        if (f2004b) {
            Log.w("AQuery", new StringBuilder().append(obj).toString());
        }
    }

    /* renamed from: a */
    public static void m3525a(Object obj, Object obj2) {
        Log.w("AQuery", obj + ":" + obj2);
    }

    /* renamed from: a */
    public static void m3526a(Runnable runnable) {
        m3538c().post(runnable);
    }

    /* renamed from: a */
    public static void m3527a(Throwable th) {
        if (f2004b) {
            Log.w("AQuery", Log.getStackTraceString(th));
        }
    }

    /* renamed from: a */
    private static boolean m3528a(File[] fileArr, long j) {
        long j2 = 0;
        for (File length : fileArr) {
            j2 += length.length();
            if (j2 > j) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static byte[] m3529a(InputStream inputStream) {
        byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m3522a(inputStream, (OutputStream) byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            m3535b((Throwable) e);
        }
        m3518a((Closeable) inputStream);
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m3530a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5"); // CRYPTOGRAPHIC API CALLSITE 16
            instance.update(bArr);
            return instance.digest(); // CRYPTOGRAPHIC API CALLSITE 15
        } catch (NoSuchAlgorithmException e) {
            m3535b((Throwable) e);
            return null;
        }
    }

    /* renamed from: b */
    public static File m3531b(File file, String str) {
        File a = m3512a(file, str);
        if (a == null || !a.exists() || a.length() == 0) {
            return null;
        }
        return a;
    }

    /* renamed from: b */
    private static String m3532b(String str) {
        return m3516a(str);
    }

    /* renamed from: b */
    public static void m3533b(File file, byte[] bArr) {
        if (file != null) {
            try {
                m3520a(file, bArr);
            } catch (Exception e) {
                m3535b((Throwable) e);
            }
        }
    }

    /* renamed from: b */
    public static void m3534b(Object obj, Object obj2) {
        if (f2004b) {
            Log.w("AQuery", obj + ":" + obj2);
        }
    }

    /* renamed from: b */
    public static void m3535b(Throwable th) {
        if (th != null) {
            try {
                m3525a((Object) "reporting", (Object) Log.getStackTraceString(th));
                if (f2006d != null) {
                    f2006d.uncaughtException(Thread.currentThread(), th);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private static void m3536b(File[] fileArr, long j) {
        long j2 = 0;
        int i = 0;
        for (File file : fileArr) {
            if (file.isFile()) {
                j2 += file.length();
                if (j2 >= j) {
                    file.delete();
                    i++;
                }
            }
        }
        m3534b((Object) "deleted", (Object) Integer.valueOf(i));
    }

    /* renamed from: b */
    public static boolean m3537b() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    /* renamed from: c */
    public static Handler m3538c() {
        if (f2008f == null) {
            f2008f = new Handler(Looper.getMainLooper());
        }
        return f2008f;
    }

    /* renamed from: c */
    private static File m3539c(File file, String str) {
        return new File(file, str);
    }

    /* renamed from: d */
    public static File m3540d() {
        File file = new File(Environment.getExternalStorageDirectory(), "aquery/temp");
        file.mkdirs();
        if (!file.exists() || !file.canWrite()) {
            return null;
        }
        return file;
    }

    /* renamed from: e */
    private static ScheduledExecutorService m3541e() {
        if (f2009g == null) {
            f2009g = Executors.newSingleThreadScheduledExecutor();
        }
        return f2009g;
    }
}
