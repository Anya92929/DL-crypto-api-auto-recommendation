package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.C0603l;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.f */
public abstract class C0518f extends C0430e {

    /* renamed from: dk */
    private static Method f1299dk;

    /* renamed from: dl */
    private static Method f1300dl;

    /* renamed from: dm */
    private static Method f1301dm;

    /* renamed from: dn */
    private static Method f1302dn;

    /* renamed from: do */
    private static Method f1303do;

    /* renamed from: dp */
    private static Method f1304dp;

    /* renamed from: dq */
    private static String f1305dq;

    /* renamed from: dr */
    private static C0603l f1306dr;

    /* renamed from: ds */
    static boolean f1307ds = false;
    private static long startTime = 0;

    /* renamed from: com.google.android.gms.internal.f$a */
    static class C0519a extends Exception {
        public C0519a() {
        }

        public C0519a(Throwable th) {
            super(th);
        }
    }

    protected C0518f(Context context, C0601j jVar, C0602k kVar) {
        super(context, jVar, kVar);
    }

    /* renamed from: a */
    static String m1530a(Context context, C0601j jVar) throws C0519a {
        if (f1301dm == null) {
            throw new C0519a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f1301dm.invoke((Object) null, new Object[]{context});
            if (byteBuffer != null) {
                return jVar.mo4005a(byteBuffer.array(), true);
            }
            throw new C0519a();
        } catch (IllegalAccessException e) {
            throw new C0519a(e);
        } catch (InvocationTargetException e2) {
            throw new C0519a(e2);
        }
    }

    /* renamed from: a */
    static ArrayList<Long> m1531a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C0519a {
        if (f1302dn == null || motionEvent == null) {
            throw new C0519a();
        }
        try {
            return (ArrayList) f1302dn.invoke((Object) null, new Object[]{motionEvent, displayMetrics});
        } catch (IllegalAccessException e) {
            throw new C0519a(e);
        } catch (InvocationTargetException e2) {
            throw new C0519a(e2);
        }
    }

    /* renamed from: a */
    protected static synchronized void m1532a(String str, Context context, C0601j jVar) {
        synchronized (C0518f.class) {
            if (!f1307ds) {
                try {
                    f1306dr = new C0603l(jVar, (SecureRandom) null);
                    f1305dq = str;
                    m1538e(context);
                    startTime = m1537e().longValue();
                    f1307ds = true;
                } catch (C0519a | UnsupportedOperationException e) {
                }
            }
        }
    }

    /* renamed from: b */
    static String m1533b(Context context, C0601j jVar) throws C0519a {
        if (f1304dp == null) {
            throw new C0519a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f1304dp.invoke((Object) null, new Object[]{context});
            if (byteBuffer != null) {
                return jVar.mo4005a(byteBuffer.array(), true);
            }
            throw new C0519a();
        } catch (IllegalAccessException e) {
            throw new C0519a(e);
        } catch (InvocationTargetException e2) {
            throw new C0519a(e2);
        }
    }

    /* renamed from: b */
    private static String m1534b(byte[] bArr, String str) throws C0519a {
        try {
            return new String(f1306dr.mo5310c(bArr, str), "UTF-8");
        } catch (C0603l.C0604a e) {
            throw new C0519a(e);
        } catch (UnsupportedEncodingException e2) {
            throw new C0519a(e2);
        }
    }

    /* renamed from: d */
    static String m1535d() throws C0519a {
        if (f1305dq != null) {
            return f1305dq;
        }
        throw new C0519a();
    }

    /* renamed from: d */
    static String m1536d(Context context) throws C0519a {
        if (f1303do == null) {
            throw new C0519a();
        }
        try {
            String str = (String) f1303do.invoke((Object) null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C0519a();
        } catch (IllegalAccessException e) {
            throw new C0519a(e);
        } catch (InvocationTargetException e2) {
            throw new C0519a(e2);
        }
    }

    /* renamed from: e */
    static Long m1537e() throws C0519a {
        if (f1299dk == null) {
            throw new C0519a();
        }
        try {
            return (Long) f1299dk.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C0519a(e);
        } catch (InvocationTargetException e2) {
            throw new C0519a(e2);
        }
    }

    /* renamed from: e */
    private static void m1538e(Context context) throws C0519a {
        try {
            byte[] b = f1306dr.mo5309b(C0606n.getKey());
            byte[] c = f1306dr.mo5310c(b, C0606n.m1895i());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null && (cacheDir = context.getDir("dex", 0)) == null) {
                throw new C0519a();
            }
            File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), (String) null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(m1534b(b, C0606n.m1896j()));
            Class loadClass2 = dexClassLoader.loadClass(m1534b(b, C0606n.m1902p()));
            Class loadClass3 = dexClassLoader.loadClass(m1534b(b, C0606n.m1900n()));
            Class loadClass4 = dexClassLoader.loadClass(m1534b(b, C0606n.m1906t()));
            Class loadClass5 = dexClassLoader.loadClass(m1534b(b, C0606n.m1898l()));
            Class loadClass6 = dexClassLoader.loadClass(m1534b(b, C0606n.m1904r()));
            f1299dk = loadClass.getMethod(m1534b(b, C0606n.m1897k()), new Class[0]);
            f1300dl = loadClass2.getMethod(m1534b(b, C0606n.m1903q()), new Class[0]);
            f1301dm = loadClass3.getMethod(m1534b(b, C0606n.m1901o()), new Class[]{Context.class});
            f1302dn = loadClass4.getMethod(m1534b(b, C0606n.m1907u()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            f1303do = loadClass5.getMethod(m1534b(b, C0606n.m1899m()), new Class[]{Context.class});
            f1304dp = loadClass6.getMethod(m1534b(b, C0606n.m1905s()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(cacheDir, name.replace(".jar", ".dex")).delete();
        } catch (FileNotFoundException e) {
            throw new C0519a(e);
        } catch (IOException e2) {
            throw new C0519a(e2);
        } catch (ClassNotFoundException e3) {
            throw new C0519a(e3);
        } catch (C0603l.C0604a e4) {
            throw new C0519a(e4);
        } catch (NoSuchMethodException e5) {
            throw new C0519a(e5);
        } catch (NullPointerException e6) {
            throw new C0519a(e6);
        }
    }

    /* renamed from: f */
    static String m1539f() throws C0519a {
        if (f1300dl == null) {
            throw new C0519a();
        }
        try {
            return (String) f1300dl.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C0519a(e);
        } catch (InvocationTargetException e2) {
            throw new C0519a(e2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:1:0x0001] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4484b(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 1
            java.lang.String r1 = m1539f()     // Catch:{ a -> 0x002f, IOException -> 0x0027 }
            r3.mo4482a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x002f, IOException -> 0x0027 }
        L_0x0008:
            r0 = 2
            java.lang.String r1 = m1535d()     // Catch:{ a -> 0x002d, IOException -> 0x0027 }
            r3.mo4482a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x002d, IOException -> 0x0027 }
        L_0x0010:
            r0 = 25
            java.lang.Long r1 = m1537e()     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
            long r1 = r1.longValue()     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
            r3.mo4481a((int) r0, (long) r1)     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
        L_0x001d:
            r0 = 24
            java.lang.String r1 = m1536d(r4)     // Catch:{ a -> 0x0029, IOException -> 0x0027 }
            r3.mo4482a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0029, IOException -> 0x0027 }
        L_0x0026:
            return
        L_0x0027:
            r0 = move-exception
            goto L_0x0026
        L_0x0029:
            r0 = move-exception
            goto L_0x0026
        L_0x002b:
            r0 = move-exception
            goto L_0x001d
        L_0x002d:
            r0 = move-exception
            goto L_0x0010
        L_0x002f:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0518f.mo4484b(android.content.Context):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A[ExcHandler: IOException (e java.io.IOException), Splitter:B:6:0x0010] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4485c(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 2
            java.lang.String r1 = m1535d()     // Catch:{ a -> 0x0097, IOException -> 0x008a }
            r6.mo4482a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0097, IOException -> 0x008a }
        L_0x0008:
            r0 = 1
            java.lang.String r1 = m1539f()     // Catch:{ a -> 0x0094, IOException -> 0x008a }
            r6.mo4482a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0094, IOException -> 0x008a }
        L_0x0010:
            java.lang.Long r0 = m1537e()     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            long r0 = r0.longValue()     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            r2 = 25
            r6.mo4481a((int) r2, (long) r0)     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            long r2 = startTime     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0034
            r2 = 17
            long r3 = startTime     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            long r0 = r0 - r3
            r6.mo4481a((int) r2, (long) r0)     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            r0 = 23
            long r1 = startTime     // Catch:{ a -> 0x0092, IOException -> 0x008a }
            r6.mo4481a((int) r0, (long) r1)     // Catch:{ a -> 0x0092, IOException -> 0x008a }
        L_0x0034:
            android.view.MotionEvent r0 = r6.f1171dg     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            android.util.DisplayMetrics r1 = r6.f1172dh     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            java.util.ArrayList r1 = m1531a((android.view.MotionEvent) r0, (android.util.DisplayMetrics) r1)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r2 = 14
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            long r3 = r0.longValue()     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r6.mo4481a((int) r2, (long) r3)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r2 = 15
            r0 = 1
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            long r3 = r0.longValue()     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r6.mo4481a((int) r2, (long) r3)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            int r0 = r1.size()     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r2 = 3
            if (r0 < r2) goto L_0x0073
            r2 = 16
            r0 = 2
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            long r0 = r0.longValue()     // Catch:{ a -> 0x0090, IOException -> 0x008a }
            r6.mo4481a((int) r2, (long) r0)     // Catch:{ a -> 0x0090, IOException -> 0x008a }
        L_0x0073:
            r0 = 27
            com.google.android.gms.internal.j r1 = r6.f1173di     // Catch:{ a -> 0x008e, IOException -> 0x008a }
            java.lang.String r1 = m1530a((android.content.Context) r7, (com.google.android.gms.internal.C0601j) r1)     // Catch:{ a -> 0x008e, IOException -> 0x008a }
            r6.mo4482a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x008e, IOException -> 0x008a }
        L_0x007e:
            r0 = 29
            com.google.android.gms.internal.j r1 = r6.f1173di     // Catch:{ a -> 0x008c, IOException -> 0x008a }
            java.lang.String r1 = m1533b((android.content.Context) r7, (com.google.android.gms.internal.C0601j) r1)     // Catch:{ a -> 0x008c, IOException -> 0x008a }
            r6.mo4482a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x008c, IOException -> 0x008a }
        L_0x0089:
            return
        L_0x008a:
            r0 = move-exception
            goto L_0x0089
        L_0x008c:
            r0 = move-exception
            goto L_0x0089
        L_0x008e:
            r0 = move-exception
            goto L_0x007e
        L_0x0090:
            r0 = move-exception
            goto L_0x0073
        L_0x0092:
            r0 = move-exception
            goto L_0x0034
        L_0x0094:
            r0 = move-exception
            goto L_0x0010
        L_0x0097:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0518f.mo4485c(android.content.Context):void");
    }
}
