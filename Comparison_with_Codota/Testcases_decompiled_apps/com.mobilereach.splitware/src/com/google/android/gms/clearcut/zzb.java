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

public final class zzb {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ClearcutLogger.API", zzUJ, zzUI);
    public static final Api.zzc<zzlw> zzUI = new Api.zzc<>();
    public static final Api.zza<zzlw, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzlw, Api.ApiOptions.NoOptions>() {
        /* renamed from: zze */
        public zzlw zza(Context context, Looper looper, zzf zzf, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlw(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final zzc zzaeQ = new zzlv();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final String zzTJ;
    /* access modifiers changed from: private */
    public final int zzaeR;
    /* access modifiers changed from: private */
    public String zzaeS;
    /* access modifiers changed from: private */
    public int zzaeT;
    /* access modifiers changed from: private */
    public String zzaeU;
    /* access modifiers changed from: private */
    public String zzaeV;
    /* access modifiers changed from: private */
    public final boolean zzaeW;
    /* access modifiers changed from: private */
    public int zzaeX;
    /* access modifiers changed from: private */
    public final zzc zzaeY;
    /* access modifiers changed from: private */
    public final zza zzaeZ;
    /* access modifiers changed from: private */
    public zzc zzafa;
    /* access modifiers changed from: private */
    public final zzmq zzqW;

    public class zza {
        private String zzaeS;
        private int zzaeT;
        private String zzaeU;
        private String zzaeV;
        private int zzaeX;
        private final C0425zzb zzafb;
        private C0425zzb zzafc;
        private ArrayList<Integer> zzafd;
        private final zzsz.zzd zzafe;
        private boolean zzaff;

        private zza(zzb zzb, byte[] bArr) {
            this(bArr, (C0425zzb) null);
        }

        private zza(byte[] bArr, C0425zzb zzb) {
            this.zzaeT = zzb.this.zzaeT;
            this.zzaeS = zzb.this.zzaeS;
            this.zzaeU = zzb.this.zzaeU;
            this.zzaeV = zzb.this.zzaeV;
            this.zzaeX = zzb.this.zzaeX;
            this.zzafd = null;
            this.zzafe = new zzsz.zzd();
            this.zzaff = false;
            this.zzaeU = zzb.this.zzaeU;
            this.zzaeV = zzb.this.zzaeV;
            this.zzafe.zzbuR = zzb.this.zzqW.currentTimeMillis();
            this.zzafe.zzbuS = zzb.this.zzqW.elapsedRealtime();
            this.zzafe.zzbvi = (long) zzb.this.zzaeZ.zzah(zzb.this.mContext);
            this.zzafe.zzbvd = zzb.this.zzafa.zzC(this.zzafe.zzbuR);
            if (bArr != null) {
                this.zzafe.zzbuY = bArr;
            }
            this.zzafb = zzb;
        }

        public zza zzbq(int i) {
            this.zzafe.zzbuU = i;
            return this;
        }

        public zza zzbr(int i) {
            this.zzafe.zzob = i;
            return this;
        }

        public PendingResult<Status> zzd(GoogleApiClient googleApiClient) {
            if (this.zzaff) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzaff = true;
            return zzb.this.zzaeY.zza(googleApiClient, zzoE());
        }

        public LogEventParcelable zzoE() {
            return new LogEventParcelable(new PlayLoggerContext(zzb.this.zzTJ, zzb.this.zzaeR, this.zzaeT, this.zzaeS, this.zzaeU, this.zzaeV, zzb.this.zzaeW, this.zzaeX), this.zzafe, this.zzafb, this.zzafc, zzb.zzb(this.zzafd));
        }
    }

    /* renamed from: com.google.android.gms.clearcut.zzb$zzb  reason: collision with other inner class name */
    public interface C0425zzb {
        byte[] zzoF();
    }

    public static class zzc {
        public long zzC(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / 1000);
        }
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, zzc zzc2, zzmq zzmq, zzc zzc3, zza zza2) {
        this.zzaeT = -1;
        this.zzaeX = 0;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext == null ? context : applicationContext;
        this.zzTJ = context.getPackageName();
        this.zzaeR = zzai(context);
        this.zzaeT = i;
        this.zzaeS = str;
        this.zzaeU = str2;
        this.zzaeV = str3;
        this.zzaeW = z;
        this.zzaeY = zzc2;
        this.zzqW = zzmq;
        this.zzafa = zzc3 == null ? new zzc() : zzc3;
        this.zzaeZ = zza2;
        this.zzaeX = 0;
        if (this.zzaeW) {
            zzx.zzb(this.zzaeU == null, (Object) "can't be anonymous with an upload account");
        }
    }

    @Deprecated
    public zzb(Context context, String str, String str2, String str3) {
        this(context, -1, str, str2, str3, false, zzaeQ, zzmt.zzsc(), (zzc) null, zza.zzaeP);
    }

    private int zzai(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int[] zzb(ArrayList<Integer> arrayList) {
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
        return this.zzaeY.zza(googleApiClient, j, timeUnit);
    }

    public zza zzi(byte[] bArr) {
        return new zza(bArr);
    }
}
