package com.flurry.android;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* renamed from: com.flurry.android.ag */
final class C0093ag {

    /* renamed from: a */
    private LinkedHashMap f109a = new C0106h(this, ((int) Math.ceil((double) (((float) 100) / 0.75f))) + 1, 0.75f);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f110b = 100;

    C0093ag(int i) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized Object mo3297a(Object obj) {
        return this.f109a.get(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3298a(Object obj, Object obj2) {
        this.f109a.put(obj, obj2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized int mo3296a() {
        return this.f109a.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized List mo3299b() {
        return new ArrayList(this.f109a.entrySet());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized Set mo3300c() {
        return this.f109a.keySet();
    }
}
