package android.support.p004v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.annotation.StyleRes;
import android.support.p004v7.appcompat.C0505R;
import android.view.LayoutInflater;

/* renamed from: android.support.v7.view.ContextThemeWrapper */
public class ContextThemeWrapper extends ContextWrapper {

    /* renamed from: a */
    private int f1632a;

    /* renamed from: b */
    private Resources.Theme f1633b;

    /* renamed from: c */
    private LayoutInflater f1634c;

    public ContextThemeWrapper(Context context, @StyleRes int i) {
        super(context);
        this.f1632a = i;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.f1633b = theme;
    }

    public void setTheme(int i) {
        if (this.f1632a != i) {
            this.f1632a = i;
            m2994a();
        }
    }

    public int getThemeResId() {
        return this.f1632a;
    }

    public Resources.Theme getTheme() {
        if (this.f1633b != null) {
            return this.f1633b;
        }
        if (this.f1632a == 0) {
            this.f1632a = C0505R.style.Theme_AppCompat_Light;
        }
        m2994a();
        return this.f1633b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1634c == null) {
            this.f1634c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1634c;
    }

    /* access modifiers changed from: protected */
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* renamed from: a */
    private void m2994a() {
        boolean z = this.f1633b == null;
        if (z) {
            this.f1633b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1633b.setTo(theme);
            }
        }
        onApplyThemeResource(this.f1633b, this.f1632a, z);
    }
}
