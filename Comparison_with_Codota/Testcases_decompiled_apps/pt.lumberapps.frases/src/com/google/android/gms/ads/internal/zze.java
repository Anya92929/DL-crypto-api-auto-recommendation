package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;

@zzin
public class zze {

    /* renamed from: a */
    private final Context f4018a;

    /* renamed from: b */
    private final AutoClickProtectionConfigurationParcel f4019b;

    /* renamed from: c */
    private boolean f4020c;

    public zze(Context context) {
        this(context, false);
    }

    public zze(Context context, zzju.zza zza) {
        this.f4018a = context;
        if (zza == null || zza.zzciq.zzccr == null) {
            this.f4019b = new AutoClickProtectionConfigurationParcel();
        } else {
            this.f4019b = zza.zzciq.zzccr;
        }
    }

    public zze(Context context, boolean z) {
        this.f4018a = context;
        this.f4019b = new AutoClickProtectionConfigurationParcel(z);
    }

    public void recordClick() {
        this.f4020c = true;
    }

    public boolean zzel() {
        return !this.f4019b.zzccu || this.f4020c;
    }

    public void zzt(String str) {
        if (str == null) {
            str = "";
        }
        zzkd.zzcw("Action was blocked because no touch was detected.");
        if (this.f4019b.zzccu && this.f4019b.zzccv != null) {
            for (String str2 : this.f4019b.zzccv) {
                if (!TextUtils.isEmpty(str2)) {
                    zzu.zzfq().zzc(this.f4018a, "", str2.replace("{NAVIGATION_URL}", Uri.encode(str)));
                }
            }
        }
    }
}
