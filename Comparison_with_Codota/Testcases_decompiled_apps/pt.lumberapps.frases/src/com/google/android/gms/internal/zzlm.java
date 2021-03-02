package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzac;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzf;
import java.util.HashMap;
import java.util.Map;

@zzin
public class zzlm extends zzab.zza {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzlh f6741a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f6742b = new Object();

    /* renamed from: c */
    private final float f6743c;

    /* renamed from: d */
    private int f6744d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public zzac f6745e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f6746f;

    /* renamed from: g */
    private boolean f6747g;

    /* renamed from: h */
    private float f6748h;

    /* renamed from: i */
    private boolean f6749i = true;

    public zzlm(zzlh zzlh, float f) {
        this.f6741a = zzlh;
        this.f6743c = f;
    }

    /* renamed from: a */
    private void m7367a(int i, int i2) {
        zzu.zzfq().runOnUiThread(new C1767nh(this, i, i2));
    }

    /* renamed from: a */
    private void m7368a(String str) {
        m7369a(str, (Map) null);
    }

    /* renamed from: a */
    private void m7369a(String str, Map map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzu.zzfq().runOnUiThread(new C1766ng(this, hashMap));
    }

    public int getPlaybackState() {
        int i;
        synchronized (this.f6742b) {
            i = this.f6744d;
        }
        return i;
    }

    public boolean isMuted() {
        boolean z;
        synchronized (this.f6742b) {
            z = this.f6747g;
        }
        return z;
    }

    public void pause() {
        m7368a("pause");
    }

    public void play() {
        m7368a("play");
    }

    public void zza(float f, int i, boolean z) {
        int i2;
        synchronized (this.f6742b) {
            this.f6748h = f;
            this.f6747g = z;
            i2 = this.f6744d;
            this.f6744d = i;
        }
        m7367a(i2, i);
    }

    public void zza(zzac zzac) {
        synchronized (this.f6742b) {
            this.f6745e = zzac;
        }
    }

    public void zzam(boolean z) {
        synchronized (this.f6742b) {
            this.f6749i = z;
        }
        m7369a("initialState", zzf.zze("muteStart", z ? "1" : "0"));
    }

    public float zziz() {
        return this.f6743c;
    }

    public float zzja() {
        float f;
        synchronized (this.f6742b) {
            f = this.f6748h;
        }
        return f;
    }

    public void zzm(boolean z) {
        m7368a(z ? "mute" : "unmute");
    }
}
