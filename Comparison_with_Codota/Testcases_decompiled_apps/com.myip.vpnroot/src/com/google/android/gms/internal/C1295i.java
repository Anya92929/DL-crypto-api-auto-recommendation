package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.C1651o;
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

/* renamed from: com.google.android.gms.internal.i */
public abstract class C1295i extends C1247h {

    /* renamed from: kA */
    private static Method f3895kA;

    /* renamed from: kB */
    private static Method f3896kB;

    /* renamed from: kC */
    private static Method f3897kC;

    /* renamed from: kD */
    private static Method f3898kD;

    /* renamed from: kE */
    private static Method f3899kE;

    /* renamed from: kF */
    private static Method f3900kF;

    /* renamed from: kG */
    private static Method f3901kG;

    /* renamed from: kH */
    private static Method f3902kH;

    /* renamed from: kI */
    private static Method f3903kI;

    /* renamed from: kJ */
    private static String f3904kJ;

    /* renamed from: kK */
    private static String f3905kK;

    /* renamed from: kL */
    private static String f3906kL;

    /* renamed from: kM */
    private static C1651o f3907kM;

    /* renamed from: kN */
    static boolean f3908kN = false;
    private static long startTime = 0;

    /* renamed from: com.google.android.gms.internal.i$a */
    static class C1296a extends Exception {
        public C1296a() {
        }

        public C1296a(Throwable th) {
            super(th);
        }
    }

    protected C1295i(Context context, C1551m mVar, C1582n nVar) {
        super(context, mVar, nVar);
    }

    /* renamed from: a */
    static String m4846a(Context context, C1551m mVar) throws C1296a {
        if (f3905kK != null) {
            return f3905kK;
        }
        if (f3898kD == null) {
            throw new C1296a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f3898kD.invoke((Object) null, new Object[]{context});
            if (byteBuffer == null) {
                throw new C1296a();
            }
            f3905kK = mVar.mo8399a(byteBuffer.array(), true);
            return f3905kK;
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: a */
    static ArrayList<Long> m4847a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C1296a {
        if (f3899kE == null || motionEvent == null) {
            throw new C1296a();
        }
        try {
            return (ArrayList) f3899kE.invoke((Object) null, new Object[]{motionEvent, displayMetrics});
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: a */
    protected static synchronized void m4848a(String str, Context context, C1551m mVar) {
        synchronized (C1295i.class) {
            if (!f3908kN) {
                try {
                    f3907kM = new C1651o(mVar, (SecureRandom) null);
                    f3904kJ = str;
                    m4854g(context);
                    startTime = m4856w().longValue();
                    f3908kN = true;
                } catch (C1296a | UnsupportedOperationException e) {
                }
            }
        }
    }

    /* renamed from: b */
    static String m4849b(Context context, C1551m mVar) throws C1296a {
        if (f3906kL != null) {
            return f3906kL;
        }
        if (f3901kG == null) {
            throw new C1296a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f3901kG.invoke((Object) null, new Object[]{context});
            if (byteBuffer == null) {
                throw new C1296a();
            }
            f3906kL = mVar.mo8399a(byteBuffer.array(), true);
            return f3906kL;
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: b */
    private static String m4850b(byte[] bArr, String str) throws C1296a {
        try {
            return new String(f3907kM.mo9880c(bArr, str), "UTF-8");
        } catch (C1651o.C1652a e) {
            throw new C1296a(e);
        } catch (UnsupportedEncodingException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: d */
    static String m4851d(Context context) throws C1296a {
        if (f3900kF == null) {
            throw new C1296a();
        }
        try {
            String str = (String) f3900kF.invoke((Object) null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C1296a();
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: e */
    static ArrayList<Long> m4852e(Context context) throws C1296a {
        if (f3902kH == null) {
            throw new C1296a();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) f3902kH.invoke((Object) null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new C1296a();
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: f */
    static int[] m4853f(Context context) throws C1296a {
        if (f3903kI == null) {
            throw new C1296a();
        }
        try {
            return (int[]) f3903kI.invoke((Object) null, new Object[]{context});
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: g */
    private static void m4854g(Context context) throws C1296a {
        File file;
        File createTempFile;
        try {
            byte[] b = f3907kM.mo9879b(C1727q.getKey());
            byte[] c = f3907kM.mo9880c(b, C1727q.m6131B());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null && (cacheDir = context.getDir("dex", 0)) == null) {
                throw new C1296a();
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), (String) null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(m4850b(b, C1727q.m6134E()));
            Class loadClass2 = dexClassLoader.loadClass(m4850b(b, C1727q.m6146Q()));
            Class loadClass3 = dexClassLoader.loadClass(m4850b(b, C1727q.m6140K()));
            Class loadClass4 = dexClassLoader.loadClass(m4850b(b, C1727q.m6138I()));
            Class loadClass5 = dexClassLoader.loadClass(m4850b(b, C1727q.m6148S()));
            Class loadClass6 = dexClassLoader.loadClass(m4850b(b, C1727q.m6136G()));
            Class loadClass7 = dexClassLoader.loadClass(m4850b(b, C1727q.m6144O()));
            Class loadClass8 = dexClassLoader.loadClass(m4850b(b, C1727q.m6142M()));
            Class loadClass9 = dexClassLoader.loadClass(m4850b(b, C1727q.m6132C()));
            f3895kA = loadClass.getMethod(m4850b(b, C1727q.m6135F()), new Class[0]);
            f3896kB = loadClass2.getMethod(m4850b(b, C1727q.m6147R()), new Class[0]);
            f3897kC = loadClass3.getMethod(m4850b(b, C1727q.m6141L()), new Class[0]);
            f3898kD = loadClass4.getMethod(m4850b(b, C1727q.m6139J()), new Class[]{Context.class});
            f3899kE = loadClass5.getMethod(m4850b(b, C1727q.m6149T()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            f3900kF = loadClass6.getMethod(m4850b(b, C1727q.m6137H()), new Class[]{Context.class});
            f3901kG = loadClass7.getMethod(m4850b(b, C1727q.m6145P()), new Class[]{Context.class});
            f3902kH = loadClass8.getMethod(m4850b(b, C1727q.m6143N()), new Class[]{Context.class});
            f3903kI = loadClass9.getMethod(m4850b(b, C1727q.m6133D()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (FileNotFoundException e) {
            throw new C1296a(e);
        } catch (IOException e2) {
            throw new C1296a(e2);
        } catch (ClassNotFoundException e3) {
            throw new C1296a(e3);
        } catch (C1651o.C1652a e4) {
            throw new C1296a(e4);
        } catch (NoSuchMethodException e5) {
            throw new C1296a(e5);
        } catch (NullPointerException e6) {
            throw new C1296a(e6);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
            throw th;
        }
    }

    /* renamed from: v */
    static String m4855v() throws C1296a {
        if (f3904kJ != null) {
            return f3904kJ;
        }
        throw new C1296a();
    }

    /* renamed from: w */
    static Long m4856w() throws C1296a {
        if (f3895kA == null) {
            throw new C1296a();
        }
        try {
            return (Long) f3895kA.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: x */
    static String m4857x() throws C1296a {
        if (f3897kC == null) {
            throw new C1296a();
        }
        try {
            return (String) f3897kC.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* renamed from: y */
    static Long m4858y() throws C1296a {
        if (f3896kB == null) {
            throw new C1296a();
        }
        try {
            return (Long) f3896kB.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C1296a(e);
        } catch (InvocationTargetException e2) {
            throw new C1296a(e2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:6:0x0010] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8692b(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 1
            java.lang.String r1 = m4857x()     // Catch:{ a -> 0x00a1, IOException -> 0x0090 }
            r6.mo8690a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x00a1, IOException -> 0x0090 }
        L_0x0008:
            r0 = 2
            java.lang.String r1 = m4855v()     // Catch:{ a -> 0x009e, IOException -> 0x0090 }
            r6.mo8690a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x009e, IOException -> 0x0090 }
        L_0x0010:
            java.lang.Long r0 = m4856w()     // Catch:{ a -> 0x009c, IOException -> 0x0090 }
            long r0 = r0.longValue()     // Catch:{ a -> 0x009c, IOException -> 0x0090 }
            r2 = 25
            r6.mo8689a((int) r2, (long) r0)     // Catch:{ a -> 0x009c, IOException -> 0x0090 }
            long r2 = startTime     // Catch:{ a -> 0x009c, IOException -> 0x0090 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0034
            r2 = 17
            long r3 = startTime     // Catch:{ a -> 0x009c, IOException -> 0x0090 }
            long r0 = r0 - r3
            r6.mo8689a((int) r2, (long) r0)     // Catch:{ a -> 0x009c, IOException -> 0x0090 }
            r0 = 23
            long r1 = startTime     // Catch:{ a -> 0x009c, IOException -> 0x0090 }
            r6.mo8689a((int) r0, (long) r1)     // Catch:{ a -> 0x009c, IOException -> 0x0090 }
        L_0x0034:
            java.util.ArrayList r1 = m4852e(r7)     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
            r2 = 31
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
            long r3 = r0.longValue()     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
            r6.mo8689a((int) r2, (long) r3)     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
            r2 = 32
            r0 = 1
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
            long r0 = r0.longValue()     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
            r6.mo8689a((int) r2, (long) r0)     // Catch:{ a -> 0x009a, IOException -> 0x0090 }
        L_0x0058:
            r0 = 33
            java.lang.Long r1 = m4858y()     // Catch:{ a -> 0x0098, IOException -> 0x0090 }
            long r1 = r1.longValue()     // Catch:{ a -> 0x0098, IOException -> 0x0090 }
            r6.mo8689a((int) r0, (long) r1)     // Catch:{ a -> 0x0098, IOException -> 0x0090 }
        L_0x0065:
            r0 = 27
            com.google.android.gms.internal.m r1 = r6.f3822ky     // Catch:{ a -> 0x0096, IOException -> 0x0090 }
            java.lang.String r1 = m4846a((android.content.Context) r7, (com.google.android.gms.internal.C1551m) r1)     // Catch:{ a -> 0x0096, IOException -> 0x0090 }
            r6.mo8690a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0096, IOException -> 0x0090 }
        L_0x0070:
            r0 = 29
            com.google.android.gms.internal.m r1 = r6.f3822ky     // Catch:{ a -> 0x0094, IOException -> 0x0090 }
            java.lang.String r1 = m4849b((android.content.Context) r7, (com.google.android.gms.internal.C1551m) r1)     // Catch:{ a -> 0x0094, IOException -> 0x0090 }
            r6.mo8690a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0094, IOException -> 0x0090 }
        L_0x007b:
            int[] r0 = m4853f(r7)     // Catch:{ a -> 0x0092, IOException -> 0x0090 }
            r1 = 5
            r2 = 0
            r2 = r0[r2]     // Catch:{ a -> 0x0092, IOException -> 0x0090 }
            long r2 = (long) r2     // Catch:{ a -> 0x0092, IOException -> 0x0090 }
            r6.mo8689a((int) r1, (long) r2)     // Catch:{ a -> 0x0092, IOException -> 0x0090 }
            r1 = 6
            r2 = 1
            r0 = r0[r2]     // Catch:{ a -> 0x0092, IOException -> 0x0090 }
            long r2 = (long) r0     // Catch:{ a -> 0x0092, IOException -> 0x0090 }
            r6.mo8689a((int) r1, (long) r2)     // Catch:{ a -> 0x0092, IOException -> 0x0090 }
        L_0x008f:
            return
        L_0x0090:
            r0 = move-exception
            goto L_0x008f
        L_0x0092:
            r0 = move-exception
            goto L_0x008f
        L_0x0094:
            r0 = move-exception
            goto L_0x007b
        L_0x0096:
            r0 = move-exception
            goto L_0x0070
        L_0x0098:
            r0 = move-exception
            goto L_0x0065
        L_0x009a:
            r0 = move-exception
            goto L_0x0058
        L_0x009c:
            r0 = move-exception
            goto L_0x0034
        L_0x009e:
            r0 = move-exception
            goto L_0x0010
        L_0x00a1:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1295i.mo8692b(android.content.Context):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005d A[ExcHandler: IOException (e java.io.IOException), Splitter:B:1:0x0001] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8693c(android.content.Context r6) {
        /*
            r5 = this;
            r0 = 2
            java.lang.String r1 = m4855v()     // Catch:{ a -> 0x0065, IOException -> 0x005d }
            r5.mo8690a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0065, IOException -> 0x005d }
        L_0x0008:
            r0 = 1
            java.lang.String r1 = m4857x()     // Catch:{ a -> 0x0063, IOException -> 0x005d }
            r5.mo8690a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0063, IOException -> 0x005d }
        L_0x0010:
            r0 = 25
            java.lang.Long r1 = m4856w()     // Catch:{ a -> 0x0061, IOException -> 0x005d }
            long r1 = r1.longValue()     // Catch:{ a -> 0x0061, IOException -> 0x005d }
            r5.mo8689a((int) r0, (long) r1)     // Catch:{ a -> 0x0061, IOException -> 0x005d }
        L_0x001d:
            android.view.MotionEvent r0 = r5.f3820kw     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            android.util.DisplayMetrics r1 = r5.f3821kx     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            java.util.ArrayList r1 = m4847a((android.view.MotionEvent) r0, (android.util.DisplayMetrics) r1)     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            r2 = 14
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            long r3 = r0.longValue()     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            r5.mo8689a((int) r2, (long) r3)     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            r2 = 15
            r0 = 1
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            long r3 = r0.longValue()     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            r5.mo8689a((int) r2, (long) r3)     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            int r0 = r1.size()     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            r2 = 3
            if (r0 < r2) goto L_0x005c
            r2 = 16
            r0 = 2
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            long r0 = r0.longValue()     // Catch:{ a -> 0x005f, IOException -> 0x005d }
            r5.mo8689a((int) r2, (long) r0)     // Catch:{ a -> 0x005f, IOException -> 0x005d }
        L_0x005c:
            return
        L_0x005d:
            r0 = move-exception
            goto L_0x005c
        L_0x005f:
            r0 = move-exception
            goto L_0x005c
        L_0x0061:
            r0 = move-exception
            goto L_0x001d
        L_0x0063:
            r0 = move-exception
            goto L_0x0010
        L_0x0065:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1295i.mo8693c(android.content.Context):void");
    }
}
