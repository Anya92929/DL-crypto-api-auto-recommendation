package android.support.p021v7.p022a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;

/* renamed from: android.support.v7.a.aq */
class C0443aq extends C0442ap {

    /* renamed from: r */
    private static C0473bt f606r;

    /* renamed from: s */
    private int f607s = -100;

    /* renamed from: t */
    private boolean f608t;

    /* renamed from: u */
    private boolean f609u = true;

    C0443aq(Context context, Window window, C0434ah ahVar) {
        super(context, window, ahVar);
    }

    /* renamed from: e */
    private boolean m1862e(int i) {
        Resources resources = this.f589a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        configuration.uiMode = i3 | (configuration.uiMode & -49);
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        return true;
    }

    /* renamed from: s */
    private C0473bt m1863s() {
        if (f606r == null) {
            f606r = new C0473bt(this.f589a.getApplicationContext());
        }
        return f606r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Window.Callback mo1996a(Window.Callback callback) {
        return new C0444ar(this, callback);
    }

    /* renamed from: a */
    public void mo1977a(Bundle bundle) {
        super.mo1977a(bundle);
        if (bundle != null && this.f607s == -100) {
            this.f607s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    /* renamed from: c */
    public void mo1986c(Bundle bundle) {
        super.mo1986c(bundle);
        if (this.f607s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f607s);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo2023d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                return m1863s().mo2074a() ? 2 : 1;
            default:
                return i;
        }
    }

    /* renamed from: i */
    public boolean mo1993i() {
        this.f608t = true;
        int d = mo2023d(this.f607s == -100 ? m1813j() : this.f607s);
        if (d != -1) {
            return m1862e(d);
        }
        return false;
    }

    /* renamed from: n */
    public boolean mo2005n() {
        return this.f609u;
    }
}
