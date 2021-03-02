package android.support.p003v7.internal.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.p003v7.appcompat.C0235R;
import android.view.LayoutInflater;

/* renamed from: android.support.v7.internal.view.ContextThemeWrapper */
public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: a */
    private int f1973a;

    /* renamed from: b */
    private Resources.Theme f1974b;

    /* renamed from: c */
    private LayoutInflater f1975c;

    public ContextThemeWrapper(Context context, int i) {
        super(context);
        this.f1973a = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f1974b = theme;
    }

    /* renamed from: a */
    private void m1371a() {
        boolean z = this.f1974b == null;
        if (z) {
            this.f1974b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1974b.setTo(theme);
            }
        }
        mo3927a(this.f1974b, this.f1973a, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3927a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1975c == null) {
            this.f1975c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1975c;
    }

    public Resources.Theme getTheme() {
        if (this.f1974b != null) {
            return this.f1974b;
        }
        if (this.f1973a == 0) {
            this.f1973a = C0235R.style.Theme_AppCompat_Light;
        }
        m1371a();
        return this.f1974b;
    }

    public int getThemeResId() {
        return this.f1973a;
    }

    public void setTheme(int i) {
        if (this.f1973a != i) {
            this.f1973a = i;
            m1371a();
        }
    }
}
