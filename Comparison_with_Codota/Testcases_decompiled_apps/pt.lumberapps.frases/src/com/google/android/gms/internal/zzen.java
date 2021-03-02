package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzin
public final class zzen implements zzep {
    /* renamed from: a */
    private long m7006a(long j) {
        return (j - zzu.zzfu().currentTimeMillis()) + zzu.zzfu().elapsedRealtime();
    }

    /* renamed from: a */
    private void m7007a(zzlh zzlh, Map map) {
        String str = (String) map.get("label");
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            zzkd.zzcx("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            zzkd.zzcx("No timestamp given for CSI tick.");
        } else {
            try {
                long a = m7006a(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                zzlh.zzus().zza(str, str2, a);
            } catch (NumberFormatException e) {
                zzkd.zzd("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    /* renamed from: b */
    private void m7008b(zzlh zzlh, Map map) {
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            zzkd.zzcx("No value given for CSI experiment.");
            return;
        }
        zzdk zzkf = zzlh.zzus().zzkf();
        if (zzkf == null) {
            zzkd.zzcx("No ticker for WebView, dropping experiment ID.");
        } else {
            zzkf.zzh("e", str);
        }
    }

    /* renamed from: c */
    private void m7009c(zzlh zzlh, Map map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get("value");
        if (TextUtils.isEmpty(str2)) {
            zzkd.zzcx("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            zzkd.zzcx("No name given for CSI extra.");
        } else {
            zzdk zzkf = zzlh.zzus().zzkf();
            if (zzkf == null) {
                zzkd.zzcx("No ticker for WebView, dropping extra parameter.");
            } else {
                zzkf.zzh(str, str2);
            }
        }
    }

    public void zza(zzlh zzlh, Map map) {
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            m7007a(zzlh, map);
        } else if ("experiment".equals(str)) {
            m7008b(zzlh, map);
        } else if ("extra".equals(str)) {
            m7009c(zzlh, map);
        }
    }
}
