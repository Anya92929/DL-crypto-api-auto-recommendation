package com.google.android.gms.tagmanager;

import com.google.android.gms.p018c.C0661c;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.r */
abstract class C1327r {

    /* renamed from: a */
    private final Set<String> f5410a;

    /* renamed from: a */
    public abstract C0661c mo9180a(Map<String, C0661c> map);

    /* renamed from: a */
    public abstract boolean mo9181a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9182a(Set<String> set) {
        return set.containsAll(this.f5410a);
    }

    /* renamed from: b */
    public Set<String> mo9183b() {
        return this.f5410a;
    }
}
