package com.google.android.gms.tagmanager;

/* renamed from: com.google.android.gms.tagmanager.bh */
class C1302bh {

    /* renamed from: a */
    private C1267a f5377a;

    /* renamed from: b */
    private C1303bi f5378b;

    /* renamed from: c */
    private boolean f5379c;

    /* renamed from: a */
    public synchronized void mo9142a() {
        if (this.f5379c) {
            C1333x.m5440a("Refreshing a released ContainerHolder.");
        } else {
            this.f5378b.mo9147a();
        }
    }

    /* renamed from: a */
    public synchronized void mo9143a(String str) {
        if (!this.f5379c) {
            this.f5377a.mo9071a(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo9144b() {
        if (!this.f5379c) {
            return this.f5377a.mo9070a();
        }
        C1333x.m5440a("getContainerId called on a released ContainerHolder.");
        return "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9145b(String str) {
        if (this.f5379c) {
            C1333x.m5440a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.f5378b.mo9148a(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo9146c() {
        if (!this.f5379c) {
            return this.f5378b.mo9149b();
        }
        C1333x.m5440a("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }
}
