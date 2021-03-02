package android.support.p021v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/* renamed from: android.support.v7.view.b */
public abstract class C0521b {

    /* renamed from: a */
    private Object f894a;

    /* renamed from: b */
    private boolean f895b;

    /* renamed from: a */
    public abstract MenuInflater mo2089a();

    /* renamed from: a */
    public abstract void mo2090a(int i);

    /* renamed from: a */
    public abstract void mo2091a(CharSequence charSequence);

    /* renamed from: a */
    public void mo2194a(Object obj) {
        this.f894a = obj;
    }

    /* renamed from: a */
    public void mo2092a(boolean z) {
        this.f895b = z;
    }

    /* renamed from: b */
    public abstract Menu mo2093b();

    /* renamed from: b */
    public abstract void mo2094b(int i);

    /* renamed from: b */
    public abstract void mo2095b(CharSequence charSequence);

    /* renamed from: c */
    public abstract void mo2096c();

    /* renamed from: d */
    public abstract void mo2097d();

    /* renamed from: f */
    public abstract CharSequence mo2099f();

    /* renamed from: g */
    public abstract CharSequence mo2100g();

    /* renamed from: h */
    public boolean mo2101h() {
        return false;
    }

    /* renamed from: i */
    public abstract View mo2102i();

    /* renamed from: j */
    public Object mo2195j() {
        return this.f894a;
    }

    /* renamed from: k */
    public boolean mo2196k() {
        return this.f895b;
    }

    public abstract void setCustomView(View view);
}
