package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.lang.reflect.Field;

public final class zzsb {

    /* renamed from: KI */
    public static final zzb f6978KI = new C1857qq();

    /* renamed from: KJ */
    public static final zzb f6979KJ = new C1858qr();

    /* renamed from: KK */
    public static final zzb f6980KK = new C1859qs();

    /* renamed from: KL */
    public static final zzb f6981KL = new C1860qt();

    /* renamed from: KM */
    public static final zzb f6982KM = new C1861qu();

    /* renamed from: a */
    private static zzsc f6983a;

    /* renamed from: b */
    private static final zzb.zza f6984b = new C1856qp();

    /* renamed from: c */
    private final Context f6985c;

    public class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        /* synthetic */ zza(String str, C1856qp qpVar) {
            this(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ zza(String str, Throwable th, C1856qp qpVar) {
            this(str, th);
        }
    }

    public interface zzb {

        public interface zza {
            int zzd(Context context, String str, boolean z);

            int zzt(Context context, String str);
        }

        /* renamed from: com.google.android.gms.internal.zzsb$zzb$zzb  reason: collision with other inner class name */
        public class C2113zzb {

            /* renamed from: KP */
            public int f6986KP = 0;

            /* renamed from: KQ */
            public int f6987KQ = 0;

            /* renamed from: KR */
            public int f6988KR = 0;
        }

        C2113zzb zza(Context context, String str, zza zza2);
    }

    private zzsb(Context context) {
        this.f6985c = (Context) zzab.zzy(context);
    }

    /* renamed from: a */
    private static zzsb m7553a(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new zzsb(context.getApplicationContext());
    }

    /* renamed from: a */
    private static zzsb m7554a(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzsc a = m7555a(context);
        if (a == null) {
            throw new zza("Failed to create IDynamiteLoader.", (C1856qp) null);
        }
        try {
            zzd zza2 = a.zza(zze.zzac(context), str, i);
            if (zze.zzad(zza2) != null) {
                return new zzsb((Context) zze.zzad(zza2));
            }
            throw new zza("Failed to load remote module.", (C1856qp) null);
        } catch (RemoteException e) {
            throw new zza("Failed to load remote module.", e, (C1856qp) null);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.zzsc m7555a(android.content.Context r6) {
        /*
            r1 = 0
            java.lang.Class<com.google.android.gms.internal.zzsb> r2 = com.google.android.gms.internal.zzsb.class
            monitor-enter(r2)
            com.google.android.gms.internal.zzsc r0 = f6983a     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x000c
            com.google.android.gms.internal.zzsc r0 = f6983a     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
        L_0x000b:
            return r0
        L_0x000c:
            com.google.android.gms.common.zzc r0 = com.google.android.gms.common.zzc.zzang()     // Catch:{ all -> 0x003a }
            int r0 = r0.isGooglePlayServicesAvailable(r6)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0019
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            r0 = r1
            goto L_0x000b
        L_0x0019:
            java.lang.String r0 = "com.google.android.gms"
            r3 = 3
            android.content.Context r0 = r6.createPackageContext(r0, r3)     // Catch:{ Exception -> 0x003d }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ Exception -> 0x003d }
            java.lang.String r3 = "com.google.android.gms.chimera.container.DynamiteLoaderImpl"
            java.lang.Class r0 = r0.loadClass(r3)     // Catch:{ Exception -> 0x003d }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x003d }
            android.os.IBinder r0 = (android.os.IBinder) r0     // Catch:{ Exception -> 0x003d }
            com.google.android.gms.internal.zzsc r0 = com.google.android.gms.internal.zzsc.zza.zzfd(r0)     // Catch:{ Exception -> 0x003d }
            if (r0 == 0) goto L_0x0057
            f6983a = r0     // Catch:{ Exception -> 0x003d }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            goto L_0x000b
        L_0x003a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r0
        L_0x003d:
            r0 = move-exception
            java.lang.String r3 = "DynamiteModule"
            java.lang.String r4 = "Failed to load IDynamiteLoader from GmsCore: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x003a }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x003a }
            int r5 = r0.length()     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x005a
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x003a }
        L_0x0054:
            android.util.Log.e(r3, r0)     // Catch:{ all -> 0x003a }
        L_0x0057:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            r0 = r1
            goto L_0x000b
        L_0x005a:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x003a }
            r0.<init>(r4)     // Catch:{ all -> 0x003a }
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsb.m7555a(android.content.Context):com.google.android.gms.internal.zzsc");
    }

    public static zzsb zza(Context context, zzb zzb2, String str) {
        zzb.C2113zzb zza2 = zzb2.zza(context, str, f6984b);
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza2.f6986KP).append(" and remote module ").append(str).append(":").append(zza2.f6987KQ).toString());
        if (zza2.f6988KR == 0 || ((zza2.f6988KR == -1 && zza2.f6986KP == 0) || (zza2.f6988KR == 1 && zza2.f6987KQ == 0))) {
            throw new zza(new StringBuilder(91).append("No acceptable module found. Local version is ").append(zza2.f6986KP).append(" and remote version is ").append(zza2.f6987KQ).append(".").toString(), (C1856qp) null);
        } else if (zza2.f6988KR == -1) {
            return m7553a(context, str);
        } else {
            if (zza2.f6988KR == 1) {
                try {
                    return m7554a(context, str, zza2.f6987KQ);
                } catch (zza e) {
                    zza zza3 = e;
                    String valueOf = String.valueOf(zza3.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    if (zza2.f6986KP != 0 && zzb2.zza(context, str, new C1862qv(zza2.f6986KP)).f6988KR == -1) {
                        return m7553a(context, str);
                    }
                    throw new zza("Remote load failed. No local fallback found.", zza3, (C1856qp) null);
                }
            } else {
                throw new zza(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(zza2.f6988KR).toString(), (C1856qp) null);
            }
        }
    }

    public static int zzd(Context context, String str, boolean z) {
        zzsc a = m7555a(context);
        if (a == null) {
            return 0;
        }
        try {
            return a.zza(zze.zzac(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    public static int zzt(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            String valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            String valueOf2 = String.valueOf("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length() + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf3 = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", new StringBuilder(String.valueOf(valueOf3).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf3).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            String valueOf4 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf4.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf4) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzu(Context context, String str) {
        return zzd(context, str, false);
    }

    public Context zzbby() {
        return this.f6985c;
    }

    public IBinder zziu(String str) {
        try {
            return (IBinder) this.f6985c.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zza(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, (C1856qp) null);
        }
    }
}
