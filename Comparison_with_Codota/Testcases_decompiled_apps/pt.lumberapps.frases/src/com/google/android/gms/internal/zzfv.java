package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzin
public class zzfv implements zzfu {

    /* renamed from: a */
    private final zzft f6209a;

    /* renamed from: b */
    private final HashSet f6210b = new HashSet();

    public zzfv(zzft zzft) {
        this.f6209a = zzft;
    }

    public void zza(String str, zzep zzep) {
        this.f6209a.zza(str, zzep);
        this.f6210b.add(new AbstractMap.SimpleEntry(str, zzep));
    }

    public void zza(String str, JSONObject jSONObject) {
        this.f6209a.zza(str, jSONObject);
    }

    public void zzb(String str, zzep zzep) {
        this.f6209a.zzb(str, zzep);
        this.f6210b.remove(new AbstractMap.SimpleEntry(str, zzep));
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.f6209a.zzb(str, jSONObject);
    }

    public void zzj(String str, String str2) {
        this.f6209a.zzj(str, str2);
    }

    public void zzmf() {
        Iterator it = this.f6210b.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            String valueOf = String.valueOf(((zzep) simpleEntry.getValue()).toString());
            zzkd.m7303v(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.f6209a.zzb((String) simpleEntry.getKey(), (zzep) simpleEntry.getValue());
        }
        this.f6210b.clear();
    }
}
