package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzhf {

    /* renamed from: a */
    private final zzlh f6346a;

    /* renamed from: b */
    private final String f6347b;

    public zzhf(zzlh zzlh) {
        this(zzlh, "");
    }

    public zzhf(zzlh zzlh, String str) {
        this.f6346a = zzlh;
        this.f6347b = str;
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f6346a.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzkd.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) {
        try {
            this.f6346a.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzkd.zzb("Error occured while dispatching size change.", e);
        }
    }

    public void zzbt(String str) {
        try {
            this.f6346a.zzb("onError", new JSONObject().put("message", str).put("action", this.f6347b));
        } catch (JSONException e) {
            zzkd.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public void zzbu(String str) {
        try {
            this.f6346a.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzkd.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzbv(String str) {
        try {
            this.f6346a.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzkd.zzb("Error occured while dispatching state change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) {
        try {
            this.f6346a.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzkd.zzb("Error occured while dispatching default position.", e);
        }
    }
}
