package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzeu implements zzep {

    /* renamed from: a */
    final HashMap f6155a = new HashMap();

    public void zza(zzlh zzlh, Map map) {
        zzi((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public Future zzaw(String str) {
        zzkv zzkv = new zzkv();
        this.f6155a.put(str, zzkv);
        return zzkv;
    }

    public void zzax(String str) {
        zzkv zzkv = (zzkv) this.f6155a.get(str);
        if (zzkv == null) {
            zzkd.m5769e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzkv.isDone()) {
            zzkv.cancel(true);
        }
        this.f6155a.remove(str);
    }

    public void zzi(String str, String str2) {
        zzkd.zzcv("Received ad from the cache.");
        zzkv zzkv = (zzkv) this.f6155a.get(str);
        if (zzkv == null) {
            zzkd.m5769e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzkv.zzh(new JSONObject(str2));
        } catch (JSONException e) {
            zzkd.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzkv.zzh((Object) null);
        } finally {
            this.f6155a.remove(str);
        }
    }
}
