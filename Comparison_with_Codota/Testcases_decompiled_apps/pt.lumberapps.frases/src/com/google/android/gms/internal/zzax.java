package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.zzc;
import com.google.android.gms.gass.internal.zza;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzau;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzax {

    /* renamed from: c */
    protected static final Object f5932c = new Object();

    /* renamed from: f */
    private static final String f5933f = zzax.class.getSimpleName();

    /* renamed from: r */
    private static zzc f5934r = null;

    /* renamed from: a */
    protected Context f5935a;

    /* renamed from: b */
    protected boolean f5936b = false;

    /* renamed from: d */
    protected boolean f5937d = false;

    /* renamed from: e */
    protected boolean f5938e = false;

    /* renamed from: g */
    private ExecutorService f5939g;

    /* renamed from: h */
    private DexClassLoader f5940h;

    /* renamed from: i */
    private zzau f5941i;

    /* renamed from: j */
    private byte[] f5942j;

    /* renamed from: k */
    private volatile AdvertisingIdClient f5943k = null;

    /* renamed from: l */
    private volatile boolean f5944l = false;

    /* renamed from: m */
    private Future f5945m = null;

    /* renamed from: n */
    private volatile zzae.zza f5946n = null;

    /* renamed from: o */
    private Future f5947o = null;

    /* renamed from: p */
    private zzam f5948p;

    /* renamed from: q */
    private GoogleApiClient f5949q = null;

    /* renamed from: s */
    private Map f5950s;

    private zzax(Context context) {
        this.f5935a = context;
        this.f5950s = new HashMap();
    }

    /* renamed from: a */
    private File m6884a(String str, File file, String str2) {
        File file2 = new File(String.format("%s/%s.jar", new Object[]{file, str2}));
        if (!file2.exists()) {
            byte[] zzc = this.f5941i.zzc(this.f5942j, str);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
        }
        return file2;
    }

    /* renamed from: a */
    private void m6886a(File file) {
        if (!file.exists()) {
            Log.d(f5933f, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c A[SYNTHETIC, Splitter:B:25:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7 A[SYNTHETIC, Splitter:B:30:0x00a7] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6887a(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            r6 = 2
            r5 = 1
            r4 = 0
            java.io.File r2 = new java.io.File
            java.lang.String r0 = "%s/%s.tmp"
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r1[r4] = r10
            r1[r5] = r11
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r2.<init>(r0)
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x001b
        L_0x001a:
            return
        L_0x001b:
            java.io.File r3 = new java.io.File
            java.lang.String r0 = "%s/%s.dex"
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r1[r4] = r10
            r1[r5] = r11
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r3.<init>(r0)
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x001a
            r1 = 0
            long r4 = r3.length()
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x001a
            int r0 = (int) r4
            byte[] r4 = new byte[r0]
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00c2, NoSuchAlgorithmException -> 0x00bd, zza -> 0x0098, all -> 0x00a4 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x00c2, NoSuchAlgorithmException -> 0x00bd, zza -> 0x0098, all -> 0x00a4 }
            int r1 = r0.read(r4)     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            if (r1 > 0) goto L_0x0054
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ IOException -> 0x00ae }
        L_0x0050:
            r9.m6886a((java.io.File) r3)
            goto L_0x001a
        L_0x0054:
            com.google.android.gms.internal.zzae$zzd r1 = new com.google.android.gms.internal.zzae$zzd     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r1.<init>()     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            java.lang.String r5 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r1.zzev = r5     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            byte[] r5 = r11.getBytes()     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r1.zzeu = r5     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            com.google.android.gms.internal.zzau r5 = r9.f5941i     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            byte[] r6 = r9.f5942j     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            java.lang.String r4 = r5.zzd(r6, r4)     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            byte[] r4 = r4.getBytes()     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r1.data = r4     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            byte[] r4 = com.google.android.gms.internal.C1462c.m6298a((byte[]) r4)     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r1.zzet = r4     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r2.createNewFile()     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            byte[] r1 = com.google.android.gms.internal.zzapv.zzf(r1)     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r2 = 0
            int r5 = r1.length     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r4.write(r1, r2, r5)     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            r4.close()     // Catch:{ IOException -> 0x00c5, NoSuchAlgorithmException -> 0x00c0, zza -> 0x00bb, all -> 0x00b6 }
            if (r0 == 0) goto L_0x0094
            r0.close()     // Catch:{ IOException -> 0x00b0 }
        L_0x0094:
            r9.m6886a((java.io.File) r3)
            goto L_0x001a
        L_0x0098:
            r0 = move-exception
            r0 = r1
        L_0x009a:
            if (r0 == 0) goto L_0x009f
            r0.close()     // Catch:{ IOException -> 0x00b2 }
        L_0x009f:
            r9.m6886a((java.io.File) r3)
            goto L_0x001a
        L_0x00a4:
            r0 = move-exception
        L_0x00a5:
            if (r1 == 0) goto L_0x00aa
            r1.close()     // Catch:{ IOException -> 0x00b4 }
        L_0x00aa:
            r9.m6886a((java.io.File) r3)
            throw r0
        L_0x00ae:
            r0 = move-exception
            goto L_0x0050
        L_0x00b0:
            r0 = move-exception
            goto L_0x0094
        L_0x00b2:
            r0 = move-exception
            goto L_0x009f
        L_0x00b4:
            r1 = move-exception
            goto L_0x00aa
        L_0x00b6:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x00a5
        L_0x00bb:
            r1 = move-exception
            goto L_0x009a
        L_0x00bd:
            r0 = move-exception
            r0 = r1
            goto L_0x009a
        L_0x00c0:
            r1 = move-exception
            goto L_0x009a
        L_0x00c2:
            r0 = move-exception
            r0 = r1
            goto L_0x009a
        L_0x00c5:
            r1 = move-exception
            goto L_0x009a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzax.m6887a(java.io.File, java.lang.String):void");
    }

    /* renamed from: a */
    private void m6888a(boolean z) {
        this.f5944l = z;
        if (z) {
            this.f5945m = this.f5939g.submit(new C1502dm(this));
        }
    }

    /* renamed from: a */
    private boolean m6889a(String str) {
        File file;
        String zzax;
        File a;
        try {
            File cacheDir = this.f5935a.getCacheDir();
            if (cacheDir == null && (cacheDir = this.f5935a.getDir("dex", 0)) == null) {
                throw new zzaw();
            }
            file = cacheDir;
            zzax = zzav.zzax();
            a = m6884a(str, file, zzax);
            m6894b(file, zzax);
            this.f5940h = new DexClassLoader(a.getAbsolutePath(), file.getAbsolutePath(), (String) null, this.f5935a.getClassLoader());
            m6886a(a);
            m6887a(file, zzax);
            m6893b(String.format("%s/%s.dex", new Object[]{file, zzax}));
            return true;
        } catch (FileNotFoundException e) {
            throw new zzaw(e);
        } catch (IOException e2) {
            throw new zzaw(e2);
        } catch (zzau.zza e3) {
            throw new zzaw(e3);
        } catch (NullPointerException e4) {
            throw new zzaw(e4);
        } catch (Throwable th) {
            m6886a(a);
            m6887a(file, zzax);
            m6893b(String.format("%s/%s.dex", new Object[]{file, zzax}));
            throw th;
        }
    }

    /* renamed from: a */
    private boolean m6890a(String str, String str2, boolean z) {
        this.f5939g = Executors.newCachedThreadPool();
        m6888a(z);
        m6896d();
        mo8101a();
        this.f5941i = new zzau((SecureRandom) null);
        try {
            this.f5942j = this.f5941i.zzl(str);
            boolean a = m6889a(str2);
            this.f5948p = new zzam(this);
            return a;
        } catch (zzau.zza e) {
            throw new zzaw(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6891b() {
        try {
            if (this.f5943k == null) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f5935a);
                advertisingIdClient.start();
                this.f5943k = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            this.f5943k = null;
        }
    }

    /* renamed from: b */
    private void m6893b(String str) {
        m6886a(new File(str));
    }

    /* renamed from: b */
    private boolean m6894b(File file, String str) {
        File file2 = new File(String.format("%s/%s.tmp", new Object[]{file, str}));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", new Object[]{file, str}));
        if (file3.exists()) {
            return false;
        }
        try {
            long length = file2.length();
            if (length <= 0) {
                m6886a(file2);
                return false;
            }
            byte[] bArr = new byte[((int) length)];
            if (new FileInputStream(file2).read(bArr) <= 0) {
                Log.d(f5933f, "Cannot read the cache data.");
                m6886a(file2);
                return false;
            }
            zzae.zzd zzd = zzae.zzd.zzd(bArr);
            if (!str.equals(new String(zzd.zzeu)) || !Arrays.equals(zzd.zzet, C1462c.m6298a(zzd.data)) || !Arrays.equals(zzd.zzev, Build.VERSION.SDK.getBytes())) {
                m6886a(file2);
                return false;
            }
            byte[] zzc = this.f5941i.zzc(this.f5942j, new String(zzd.data));
            file3.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        } catch (NoSuchAlgorithmException e2) {
            return false;
        } catch (zzau.zza e3) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6895c() {
        if (this.f5937d) {
            try {
                this.f5946n = zza.zzg(this.f5935a, this.f5935a.getPackageName(), Integer.toString(this.f5935a.getPackageManager().getPackageInfo(this.f5935a.getPackageName(), 0).versionCode));
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
    }

    /* renamed from: d */
    private void m6896d() {
        boolean z = true;
        f5934r = zzc.zzang();
        this.f5936b = f5934r.zzbn(this.f5935a) > 0;
        if (f5934r.isGooglePlayServicesAvailable(this.f5935a) != 0) {
            z = false;
        }
        this.f5937d = z;
        if (this.f5935a.getApplicationContext() != null) {
            this.f5949q = new GoogleApiClient.Builder(this.f5935a).addApi(zzb.API).build();
        }
        zzdc.initialize(this.f5935a);
    }

    public static zzax zza(Context context, String str, String str2, boolean z) {
        zzax zzax = new zzax(context);
        try {
            if (zzax.m6890a(str, str2, z)) {
                return zzax;
            }
            return null;
        } catch (zzaw e) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8101a() {
        if (((Boolean) zzdc.zzbbu.get()).booleanValue()) {
            this.f5947o = this.f5939g.submit(new C1503dn(this));
        }
    }

    public Context getContext() {
        return this.f5935a;
    }

    public boolean zza(String str, String str2, List list) {
        if (this.f5950s.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.f5950s.put(new Pair(str, str2), new zzbo(this, str, str2, list));
        return true;
    }

    public int zzat() {
        zzam zzck = zzck();
        if (zzck != null) {
            return zzck.zzat();
        }
        return Integer.MIN_VALUE;
    }

    public Method zzc(String str, String str2) {
        zzbo zzbo = (zzbo) this.f5950s.get(new Pair(str, str2));
        if (zzbo == null) {
            return null;
        }
        return zzbo.zzcz();
    }

    public ExecutorService zzcd() {
        return this.f5939g;
    }

    public DexClassLoader zzce() {
        return this.f5940h;
    }

    public zzau zzcf() {
        return this.f5941i;
    }

    public byte[] zzcg() {
        return this.f5942j;
    }

    public GoogleApiClient zzch() {
        return this.f5949q;
    }

    public boolean zzci() {
        return this.f5936b;
    }

    public boolean zzcj() {
        return this.f5938e;
    }

    public zzam zzck() {
        return this.f5948p;
    }

    public zzae.zza zzcl() {
        return this.f5946n;
    }

    public Future zzcm() {
        return this.f5947o;
    }

    public AdvertisingIdClient zzcr() {
        if (!this.f5944l) {
            return null;
        }
        if (this.f5943k != null) {
            return this.f5943k;
        }
        if (this.f5945m != null) {
            try {
                this.f5945m.get(2000, TimeUnit.MILLISECONDS);
                this.f5945m = null;
            } catch (InterruptedException | ExecutionException e) {
            } catch (TimeoutException e2) {
                this.f5945m.cancel(true);
            }
        }
        return this.f5943k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzcs() {
        /*
            r2 = this;
            java.lang.Object r1 = f5932c
            monitor-enter(r1)
            boolean r0 = r2.f5938e     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
        L_0x0008:
            return
        L_0x0009:
            boolean r0 = r2.f5937d     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.common.api.GoogleApiClient r0 = r2.f5949q     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.common.api.GoogleApiClient r0 = r2.f5949q     // Catch:{ all -> 0x001b }
            r0.connect()     // Catch:{ all -> 0x001b }
            r0 = 1
            r2.f5938e = r0     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            goto L_0x0008
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        L_0x001e:
            r0 = 0
            r2.f5938e = r0     // Catch:{ all -> 0x001b }
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzax.zzcs():void");
    }

    public void zzct() {
        synchronized (f5932c) {
            if (this.f5938e && this.f5949q != null) {
                this.f5949q.disconnect();
                this.f5938e = false;
            }
        }
    }
}
