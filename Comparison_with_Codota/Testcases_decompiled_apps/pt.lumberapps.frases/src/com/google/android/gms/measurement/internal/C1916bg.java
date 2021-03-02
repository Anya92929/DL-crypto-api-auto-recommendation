package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.bg */
class C1916bg implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7172a;

    /* renamed from: b */
    final /* synthetic */ EventParcel f7173b;

    /* renamed from: c */
    final /* synthetic */ String f7174c;

    /* renamed from: d */
    final /* synthetic */ zzy f7175d;

    C1916bg(zzy zzy, String str, EventParcel eventParcel, String str2) {
        this.f7175d = zzy;
        this.f7172a = str;
        this.f7173b = eventParcel;
        this.f7174c = str2;
    }

    public void run() {
        this.f7175d.f7392a.mo9675m();
        this.f7175d.mo9701a(this.f7172a);
        this.f7175d.f7392a.mo9650a(this.f7173b, this.f7174c);
    }
}
