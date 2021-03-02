package com.google.android.gms.internal;

import android.net.Uri;
import java.util.Map;
import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.fq */
final class C1560fq implements zzep {
    C1560fq() {
    }

    public void zza(zzlh zzlh, Map map) {
        Uri uri;
        String str = (String) map.get("u");
        if (str == null) {
            zzkd.zzcx("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzas zzul = zzlh.zzul();
            if (zzul != null && zzul.zzc(parse)) {
                uri = zzul.zzb(parse, zzlh.getContext());
                Future future = (Future) new zzkq(zzlh.getContext(), zzlh.zzum().zzcs, uri.toString()).zzpy();
            }
        } catch (zzat e) {
            String valueOf = String.valueOf(str);
            zzkd.zzcx(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        uri = parse;
        Future future2 = (Future) new zzkq(zzlh.getContext(), zzlh.zzum().zzcs, uri.toString()).zzpy();
    }
}
