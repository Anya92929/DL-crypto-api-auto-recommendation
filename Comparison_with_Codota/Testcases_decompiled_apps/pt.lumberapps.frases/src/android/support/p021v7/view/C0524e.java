package android.support.p021v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.p021v7.p023b.C0514j;
import android.view.LayoutInflater;

/* renamed from: android.support.v7.view.e */
public class C0524e extends ContextWrapper {

    /* renamed from: a */
    private int f896a;

    /* renamed from: b */
    private Resources.Theme f897b;

    /* renamed from: c */
    private LayoutInflater f898c;

    public C0524e(Context context, int i) {
        super(context);
        this.f896a = i;
    }

    public C0524e(Context context, Resources.Theme theme) {
        super(context);
        this.f897b = theme;
    }

    /* renamed from: b */
    private void m2209b() {
        boolean z = this.f897b == null;
        if (z) {
            this.f897b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f897b.setTo(theme);
            }
        }
        mo2200a(this.f897b, this.f896a, z);
    }

    /* renamed from: a */
    public int mo2199a() {
        return this.f896a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2200a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f898c == null) {
            this.f898c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f898c;
    }

    public Resources.Theme getTheme() {
        if (this.f897b != null) {
            return this.f897b;
        }
        if (this.f896a == 0) {
            this.f896a = C0514j.Theme_AppCompat_Light;
        }
        m2209b();
        return this.f897b;
    }

    public void setTheme(int i) {
        if (this.f896a != i) {
            this.f896a = i;
            m2209b();
        }
    }
}
