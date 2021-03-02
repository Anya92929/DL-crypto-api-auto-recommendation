package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;
import java.util.LinkedList;

@zzin
/* renamed from: com.google.android.gms.internal.hg */
class C1604hg {

    /* renamed from: a */
    private final LinkedList f5071a = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AdRequestParcel f5072b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f5073c;

    /* renamed from: d */
    private final int f5074d;

    /* renamed from: e */
    private boolean f5075e;

    C1604hg(AdRequestParcel adRequestParcel, String str, int i) {
        zzab.zzy(adRequestParcel);
        zzab.zzy(str);
        this.f5072b = adRequestParcel;
        this.f5073c = str;
        this.f5074d = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdRequestParcel mo7294a() {
        return this.f5072b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1605hh mo7295a(AdRequestParcel adRequestParcel) {
        if (adRequestParcel != null) {
            this.f5072b = adRequestParcel;
        }
        return (C1605hh) this.f5071a.remove();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7296a(zzfh zzfh) {
        C1605hh hhVar = new C1605hh(this, zzfh);
        this.f5071a.add(hhVar);
        hhVar.mo7305a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7297a(zzfh zzfh, AdRequestParcel adRequestParcel) {
        this.f5071a.add(new C1605hh(this, zzfh, adRequestParcel));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo7298b() {
        return this.f5074d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo7299c() {
        return this.f5073c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo7300d() {
        return this.f5071a.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo7301e() {
        int i = 0;
        Iterator it = this.f5071a.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((C1605hh) it.next()).f5080e ? i2 + 1 : i2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo7302f() {
        Iterator it = this.f5071a.iterator();
        while (it.hasNext()) {
            ((C1605hh) it.next()).mo7305a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo7303g() {
        this.f5075e = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo7304h() {
        return this.f5075e;
    }
}
