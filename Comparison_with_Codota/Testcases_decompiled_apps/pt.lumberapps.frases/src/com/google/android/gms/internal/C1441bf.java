package com.google.android.gms.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.bf */
abstract class C1441bf implements Iterator {

    /* renamed from: b */
    C1442bg f4871b;

    /* renamed from: c */
    C1442bg f4872c;

    /* renamed from: d */
    int f4873d;

    /* renamed from: e */
    final /* synthetic */ zzant f4874e;

    private C1441bf(zzant zzant) {
        this.f4874e = zzant;
        this.f4871b = this.f4874e.f5809e.f4878d;
        this.f4872c = null;
        this.f4873d = this.f4874e.f5808d;
    }

    /* synthetic */ C1441bf(zzant zzant, C1436ba baVar) {
        this(zzant);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final C1442bg mo7092b() {
        C1442bg bgVar = this.f4871b;
        if (bgVar == this.f4874e.f5809e) {
            throw new NoSuchElementException();
        } else if (this.f4874e.f5808d != this.f4873d) {
            throw new ConcurrentModificationException();
        } else {
            this.f4871b = bgVar.f4878d;
            this.f4872c = bgVar;
            return bgVar;
        }
    }

    public final boolean hasNext() {
        return this.f4871b != this.f4874e.f5809e;
    }

    public final void remove() {
        if (this.f4872c == null) {
            throw new IllegalStateException();
        }
        this.f4874e.mo7888a(this.f4872c, true);
        this.f4872c = null;
        this.f4873d = this.f4874e.f5808d;
    }
}
