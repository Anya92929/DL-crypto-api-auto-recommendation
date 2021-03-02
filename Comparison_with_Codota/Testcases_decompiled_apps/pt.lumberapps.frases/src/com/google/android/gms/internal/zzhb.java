package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzin
public class zzhb {

    /* renamed from: a */
    private final zzlh f6318a;

    /* renamed from: b */
    private final boolean f6319b;

    /* renamed from: c */
    private final String f6320c;

    public zzhb(zzlh zzlh, Map map) {
        this.f6318a = zzlh;
        this.f6320c = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f6319b = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.f6319b = true;
        }
    }

    public void execute() {
        if (this.f6318a == null) {
            zzkd.zzcx("AdWebView is null");
        } else {
            this.f6318a.setRequestedOrientation("portrait".equalsIgnoreCase(this.f6320c) ? zzu.zzfs().zztk() : "landscape".equalsIgnoreCase(this.f6320c) ? zzu.zzfs().zztj() : this.f6319b ? -1 : zzu.zzfs().zztl());
        }
    }
}
