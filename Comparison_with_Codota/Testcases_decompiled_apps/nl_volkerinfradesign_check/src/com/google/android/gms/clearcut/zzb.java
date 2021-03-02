package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlw;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;

public final class zzb {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ClearcutLogger.API", zzUJ, zzUI);
    public static final Api.zzc<zzlw> zzUI = new Api.zzc<>();
    public static final Api.zza<zzlw, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzlw, Api.ApiOptions.NoOptions>() {
        /* renamed from: a */
        public zzlw zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlw(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final zzc zzaeQ = new zzlv();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f2565a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f2566b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f2567c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f2568d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2569e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f2570f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f2571g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final boolean f2572h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f2573i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final zzc f2574j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final zzmq f2575k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final zza f2576l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public zzc f2577m;

    public class zza {

        /* renamed from: b */
        private int f2579b;

        /* renamed from: c */
        private String f2580c;

        /* renamed from: d */
        private String f2581d;

        /* renamed from: e */
        private String f2582e;

        /* renamed from: f */
        private int f2583f;

        /* renamed from: g */
        private final C2019zzb f2584g;

        /* renamed from: h */
        private C2019zzb f2585h;

        /* renamed from: i */
        private ArrayList<Integer> f2586i;

        /* renamed from: j */
        private final zzsz.zzd f2587j;

        /* renamed from: k */
        private boolean f2588k;

        private zza(zzb zzb, byte[] bArr) {
            this(bArr, (C2019zzb) null);
        }

        private zza(byte[] bArr, C2019zzb zzb) {
            this.f2579b = zzb.this.f2569e;
            this.f2580c = zzb.this.f2568d;
            this.f2581d = zzb.this.f2570f;
            this.f2582e = zzb.this.f2571g;
            this.f2583f = zzb.this.f2573i;
            this.f2586i = null;
            this.f2587j = new zzsz.zzd();
            this.f2588k = false;
            this.f2581d = zzb.this.f2570f;
            this.f2582e = zzb.this.f2571g;
            this.f2587j.zzbuR = zzb.this.f2575k.currentTimeMillis();
            this.f2587j.zzbuS = zzb.this.f2575k.elapsedRealtime();
            this.f2587j.zzbvi = (long) zzb.this.f2576l.zzah(zzb.this.f2565a);
            this.f2587j.zzbvd = zzb.this.f2577m.zzC(this.f2587j.zzbuR);
            if (bArr != null) {
                this.f2587j.zzbuY = bArr;
            }
            this.f2584g = zzb;
        }

        public zza zzbq(int i) {
            this.f2587j.zzbuU = i;
            return this;
        }

        public zza zzbr(int i) {
            this.f2587j.zzob = i;
            return this;
        }

        public PendingResult<Status> zzd(GoogleApiClient googleApiClient) {
            if (this.f2588k) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f2588k = true;
            return zzb.this.f2574j.zza(googleApiClient, zzoE());
        }

        public LogEventParcelable zzoE() {
            return new LogEventParcelable(new PlayLoggerContext(zzb.this.f2566b, zzb.this.f2567c, this.f2579b, this.f2580c, this.f2581d, this.f2582e, zzb.this.f2572h, this.f2583f), this.f2587j, this.f2584g, this.f2585h, zzb.m3669b(this.f2586i));
        }
    }

    /* renamed from: com.google.android.gms.clearcut.zzb$zzb  reason: collision with other inner class name */
    public interface C2019zzb {
        byte[] zzoF();
    }

    public static class zzc {
        public long zzC(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / LogTable.MAX_SIZE);
        }
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, zzc zzc2, zzmq zzmq, zzc zzc3, zza zza2) {
        this.f2569e = -1;
        this.f2573i = 0;
        Context applicationContext = context.getApplicationContext();
        this.f2565a = applicationContext == null ? context : applicationContext;
        this.f2566b = context.getPackageName();
        this.f2567c = m3665a(context);
        this.f2569e = i;
        this.f2568d = str;
        this.f2570f = str2;
        this.f2571g = str3;
        this.f2572h = z;
        this.f2574j = zzc2;
        this.f2575k = zzmq;
        this.f2577m = zzc3 == null ? new zzc() : zzc3;
        this.f2576l = zza2;
        this.f2573i = 0;
        if (this.f2572h) {
            zzx.zzb(this.f2570f == null, (Object) "can't be anonymous with an upload account");
        }
    }

    @Deprecated
    public zzb(Context context, String str, String str2, String str3) {
        this(context, -1, str, str2, str3, false, zzaeQ, zzmt.zzsc(), (zzc) null, zza.zzaeP);
    }

    /* renamed from: a */
    private int m3665a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int[] m3669b(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        Iterator<Integer> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            i = i2 + 1;
            iArr[i2] = it.next().intValue();
        }
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        return this.f2574j.zza(googleApiClient, j, timeUnit);
    }

    public zza zzi(byte[] bArr) {
        return new zza(bArr);
    }
}
