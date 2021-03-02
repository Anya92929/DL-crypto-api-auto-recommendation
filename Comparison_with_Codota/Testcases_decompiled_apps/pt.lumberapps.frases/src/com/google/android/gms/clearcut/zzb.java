package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzapz;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class zzb {
    public static final Api API = new Api("ClearcutLogger.API", f4239bK, f4238bJ);

    /* renamed from: bJ */
    public static final Api.zzf f4238bJ = new Api.zzf();

    /* renamed from: bK */
    public static final Api.zza f4239bK = new C1337a();

    /* renamed from: pZ */
    public static final zzc f4240pZ = new zzpb();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f4241a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f4242b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f4243c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f4244d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f4245e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f4246f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f4247g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final boolean f4248h;

    /* renamed from: i */
    private int f4249i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final zzc f4250j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final zze f4251k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final zza f4252l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public zzd f4253m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final C2109zzb f4254n;

    public class zza {

        /* renamed from: b */
        private int f4256b;

        /* renamed from: c */
        private String f4257c;

        /* renamed from: d */
        private String f4258d;

        /* renamed from: e */
        private String f4259e;

        /* renamed from: f */
        private int f4260f;

        /* renamed from: g */
        private final zzc f4261g;

        /* renamed from: h */
        private ArrayList f4262h;

        /* renamed from: i */
        private ArrayList f4263i;

        /* renamed from: j */
        private ArrayList f4264j;

        /* renamed from: k */
        private ArrayList f4265k;

        /* renamed from: l */
        private boolean f4266l;

        /* renamed from: m */
        private final zzapz.zzd f4267m;

        /* renamed from: n */
        private boolean f4268n;

        private zza(zzb zzb, byte[] bArr) {
            this(bArr, (zzc) null);
        }

        /* synthetic */ zza(zzb zzb, byte[] bArr, C1337a aVar) {
            this(zzb, bArr);
        }

        private zza(byte[] bArr, zzc zzc) {
            this.f4256b = zzb.this.f4245e;
            this.f4257c = zzb.this.f4244d;
            this.f4258d = zzb.this.f4246f;
            this.f4259e = zzb.this.f4247g;
            this.f4260f = zzb.m5930e(zzb.this);
            this.f4262h = null;
            this.f4263i = null;
            this.f4264j = null;
            this.f4265k = null;
            this.f4266l = true;
            this.f4267m = new zzapz.zzd();
            this.f4268n = false;
            this.f4258d = zzb.this.f4246f;
            this.f4259e = zzb.this.f4247g;
            this.f4267m.bka = zzb.this.f4251k.currentTimeMillis();
            this.f4267m.bkb = zzb.this.f4251k.elapsedRealtime();
            this.f4267m.bks = (long) zzb.this.f4252l.zzbk(zzb.this.f4241a);
            this.f4267m.bkm = zzb.this.f4253m.zzae(this.f4267m.bka);
            if (bArr != null) {
                this.f4267m.bkh = bArr;
            }
            this.f4261g = zzc;
        }

        public LogEventParcelable zzana() {
            return new LogEventParcelable(new PlayLoggerContext(zzb.this.f4242b, zzb.this.f4243c, this.f4256b, this.f4257c, this.f4258d, this.f4259e, zzb.this.f4248h, this.f4260f), this.f4267m, this.f4261g, (zzc) null, zzb.m5929d((ArrayList) null), zzb.m5931e((ArrayList) null), zzb.m5929d((ArrayList) null), zzb.m5933f((ArrayList) null), this.f4266l);
        }

        public PendingResult zze(GoogleApiClient googleApiClient) {
            if (this.f4268n) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f4268n = true;
            PlayLoggerContext playLoggerContext = zzana().f4230qu;
            return zzb.this.f4254n.zzg(playLoggerContext.arv, playLoggerContext.arr) ? zzb.this.f4250j.zza(googleApiClient, zzana()) : PendingResults.immediatePendingResult(Status.f4328sq);
        }

        public zza zzey(int i) {
            this.f4267m.bkd = i;
            return this;
        }

        public zza zzez(int i) {
            this.f4267m.zzahl = i;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.clearcut.zzb$zzb  reason: collision with other inner class name */
    public interface C2109zzb {
        boolean zzg(String str, int i);
    }

    public interface zzc {
        byte[] zzanb();
    }

    public class zzd {
        public long zzae(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, zzc zzc2, zze zze, zzd zzd2, zza zza2, C2109zzb zzb) {
        this.f4245e = -1;
        this.f4249i = 0;
        Context applicationContext = context.getApplicationContext();
        this.f4241a = applicationContext == null ? context : applicationContext;
        this.f4242b = context.getPackageName();
        this.f4243c = m5921a(context);
        this.f4245e = i;
        this.f4244d = str;
        this.f4246f = str2;
        this.f4247g = str3;
        this.f4248h = z;
        this.f4250j = zzc2;
        this.f4251k = zze;
        this.f4253m = zzd2 == null ? new zzd() : zzd2;
        this.f4252l = zza2;
        this.f4249i = 0;
        this.f4254n = zzb;
        if (this.f4248h) {
            zzab.zzb(this.f4246f == null, (Object) "can't be anonymous with an upload account");
        }
    }

    public zzb(Context context, String str, String str2) {
        this(context, -1, str, str2, (String) null, false, f4240pZ, zzh.zzavm(), (zzd) null, zza.f4237pY, new zzpg(context));
    }

    /* renamed from: a */
    private int m5921a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static int[] m5929d(ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        Iterator it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            i = i2 + 1;
            iArr[i2] = ((Integer) it.next()).intValue();
        }
    }

    /* renamed from: e */
    static /* synthetic */ int m5930e(zzb zzb) {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static String[] m5931e(ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static byte[][] m5933f(ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public zza zzl(byte[] bArr) {
        return new zza(this, bArr, (C1337a) null);
    }
}
