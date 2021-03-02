package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhd;
import java.util.Map;

@zzin
public class zzhe extends zzhf implements zzep {

    /* renamed from: a */
    DisplayMetrics f6333a;

    /* renamed from: b */
    int f6334b = -1;

    /* renamed from: c */
    int f6335c = -1;

    /* renamed from: d */
    int f6336d = -1;

    /* renamed from: e */
    int f6337e = -1;

    /* renamed from: f */
    int f6338f = -1;

    /* renamed from: g */
    int f6339g = -1;

    /* renamed from: h */
    private final zzlh f6340h;

    /* renamed from: i */
    private final Context f6341i;

    /* renamed from: j */
    private final WindowManager f6342j;

    /* renamed from: k */
    private final zzcu f6343k;

    /* renamed from: l */
    private float f6344l;

    /* renamed from: m */
    private int f6345m;

    public zzhe(zzlh zzlh, Context context, zzcu zzcu) {
        super(zzlh);
        this.f6340h = zzlh;
        this.f6341i = context;
        this.f6343k = zzcu;
        this.f6342j = (WindowManager) context.getSystemService("window");
    }

    /* renamed from: f */
    private void m7132f() {
        this.f6333a = new DisplayMetrics();
        Display defaultDisplay = this.f6342j.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f6333a);
        this.f6344l = this.f6333a.density;
        this.f6345m = defaultDisplay.getRotation();
    }

    /* renamed from: g */
    private void m7133g() {
        int[] iArr = new int[2];
        this.f6340h.getLocationOnScreen(iArr);
        zze(zzm.zziw().zzb(this.f6341i, iArr[0]), zzm.zziw().zzb(this.f6341i, iArr[1]));
    }

    /* renamed from: h */
    private zzhd m7134h() {
        return new zzhd.zza().zzu(this.f6343k.zzjp()).zzt(this.f6343k.zzjq()).zzv(this.f6343k.zzju()).zzw(this.f6343k.zzjr()).zzx(this.f6343k.zzjs()).zzmy();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8452a() {
        this.f6334b = zzm.zziw().zzb(this.f6333a, this.f6333a.widthPixels);
        this.f6335c = zzm.zziw().zzb(this.f6333a, this.f6333a.heightPixels);
        Activity zzue = this.f6340h.zzue();
        if (zzue == null || zzue.getWindow() == null) {
            this.f6336d = this.f6334b;
            this.f6337e = this.f6335c;
            return;
        }
        int[] zzh = zzu.zzfq().zzh(zzue);
        this.f6336d = zzm.zziw().zzb(this.f6333a, zzh[0]);
        this.f6337e = zzm.zziw().zzb(this.f6333a, zzh[1]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8453b() {
        if (this.f6340h.zzdn().zzaus) {
            this.f6338f = this.f6334b;
            this.f6339g = this.f6335c;
            return;
        }
        this.f6340h.measure(0, 0);
        this.f6338f = zzm.zziw().zzb(this.f6341i, this.f6340h.getMeasuredWidth());
        this.f6339g = zzm.zziw().zzb(this.f6341i, this.f6340h.getMeasuredHeight());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8454c() {
        if (zzkd.zzaz(2)) {
            zzkd.zzcw("Dispatching Ready Event.");
        }
        zzbu(this.f6340h.zzum().zzcs);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8455d() {
        zza(this.f6334b, this.f6335c, this.f6336d, this.f6337e, this.f6344l, this.f6345m);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo8456e() {
        this.f6340h.zzb("onDeviceFeaturesReceived", m7134h().toJson());
    }

    public void zza(zzlh zzlh, Map map) {
        zznc();
    }

    public void zze(int i, int i2) {
        zzc(i, i2 - (this.f6341i instanceof Activity ? zzu.zzfq().zzk((Activity) this.f6341i)[0] : 0), this.f6338f, this.f6339g);
        this.f6340h.zzuj().zzd(i, i2);
    }

    public void zznc() {
        m7132f();
        mo8452a();
        mo8453b();
        mo8455d();
        mo8456e();
        m7133g();
        mo8454c();
    }
}
