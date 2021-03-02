package android.support.p021v7.view;

import android.support.p009v4.view.C0314ek;
import android.support.p009v4.view.C0332fb;
import android.support.p009v4.view.C0333fc;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.view.l */
public class C0531l {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ArrayList f947a = new ArrayList();

    /* renamed from: b */
    private long f948b = -1;

    /* renamed from: c */
    private Interpolator f949c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0332fb f950d;

    /* renamed from: e */
    private boolean f951e;

    /* renamed from: f */
    private final C0333fc f952f = new C0532m(this);

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2255c() {
        this.f951e = false;
    }

    /* renamed from: a */
    public C0531l mo2230a(long j) {
        if (!this.f951e) {
            this.f948b = j;
        }
        return this;
    }

    /* renamed from: a */
    public C0531l mo2231a(C0314ek ekVar) {
        if (!this.f951e) {
            this.f947a.add(ekVar);
        }
        return this;
    }

    /* renamed from: a */
    public C0531l mo2232a(C0314ek ekVar, C0314ek ekVar2) {
        this.f947a.add(ekVar);
        ekVar2.mo1558b(ekVar.mo1551a());
        this.f947a.add(ekVar2);
        return this;
    }

    /* renamed from: a */
    public C0531l mo2233a(C0332fb fbVar) {
        if (!this.f951e) {
            this.f950d = fbVar;
        }
        return this;
    }

    /* renamed from: a */
    public C0531l mo2234a(Interpolator interpolator) {
        if (!this.f951e) {
            this.f949c = interpolator;
        }
        return this;
    }

    /* renamed from: a */
    public void mo2235a() {
        if (!this.f951e) {
            Iterator it = this.f947a.iterator();
            while (it.hasNext()) {
                C0314ek ekVar = (C0314ek) it.next();
                if (this.f948b >= 0) {
                    ekVar.mo1553a(this.f948b);
                }
                if (this.f949c != null) {
                    ekVar.mo1556a(this.f949c);
                }
                if (this.f950d != null) {
                    ekVar.mo1554a((C0332fb) this.f952f);
                }
                ekVar.mo1560c();
            }
            this.f951e = true;
        }
    }

    /* renamed from: b */
    public void mo2236b() {
        if (this.f951e) {
            Iterator it = this.f947a.iterator();
            while (it.hasNext()) {
                ((C0314ek) it.next()).mo1559b();
            }
            this.f951e = false;
        }
    }
}
