package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import com.google.android.gms.playlog.internal.zzd;
import com.google.android.gms.playlog.internal.zzf;
import java.util.Map;
import java.util.Set;

@Deprecated
public class zzqu {
    private final zzf zzbdy;
    private PlayLoggerContext zzbdz;

    public interface zza {
        void zzES();

        void zzET();

        void zzc(PendingIntent pendingIntent);
    }

    public zzqu(Context context, int i, String str, String str2, zza zza2, boolean z, String str3) {
        String packageName = context.getPackageName();
        int i2 = 0;
        try {
            i2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("PlayLogger", "This can't happen.", e);
        }
        this.zzbdz = new PlayLoggerContext(packageName, i2, i, str, str2, z);
        this.zzbdy = new zzf(context, context.getMainLooper(), new zzd(zza2), new com.google.android.gms.common.internal.zzf((Account) null, (Set<Scope>) null, (Map<Api<?>, zzf.zza>) null, 49, (View) null, packageName, str3, (zzro) null));
    }

    public void start() {
        this.zzbdy.start();
    }

    public void stop() {
        this.zzbdy.stop();
    }

    public void zza(long j, String str, byte[] bArr, String... strArr) {
        this.zzbdy.zzb(this.zzbdz, new LogEvent(j, 0, str, bArr, strArr));
    }

    public void zzb(String str, byte[] bArr, String... strArr) {
        zza(System.currentTimeMillis(), str, bArr, strArr);
    }
}
