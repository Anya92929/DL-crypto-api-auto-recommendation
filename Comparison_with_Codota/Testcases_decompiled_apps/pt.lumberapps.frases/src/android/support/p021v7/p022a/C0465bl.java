package android.support.p021v7.p022a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.p023b.C0514j;
import android.support.p021v7.view.menu.C0538ae;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0559l;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.support.p021v7.widget.C0623bu;
import android.support.p021v7.widget.C0676dt;
import android.support.p021v7.widget.C0678dv;
import android.support.p021v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.util.ArrayList;

/* renamed from: android.support.v7.a.bl */
class C0465bl extends C0426a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0623bu f681a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f682b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Window.Callback f683c;

    /* renamed from: d */
    private boolean f684d;

    /* renamed from: e */
    private boolean f685e;

    /* renamed from: f */
    private ArrayList f686f = new ArrayList();

    /* renamed from: g */
    private C0559l f687g;

    /* renamed from: h */
    private final Runnable f688h = new C0466bm(this);

    /* renamed from: i */
    private final C0676dt f689i = new C0467bn(this);

    public C0465bl(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f681a = new C0678dv(toolbar, false);
        this.f683c = new C0471br(this, callback);
        this.f681a.mo3088a(this.f683c);
        toolbar.setOnMenuItemClickListener(this.f689i);
        this.f681a.mo3089a(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m1971a(Menu menu) {
        m1974b(menu);
        if (menu == null || this.f687g == null || this.f687g.mo2422a().getCount() <= 0) {
            return null;
        }
        return (View) this.f687g.mo2421a(this.f681a.mo3082a());
    }

    /* renamed from: b */
    private void m1974b(Menu menu) {
        if (this.f687g == null && (menu instanceof C0562o)) {
            C0562o oVar = (C0562o) menu;
            Context b = this.f681a.mo3091b();
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = b.getResources().newTheme();
            newTheme.setTo(b.getTheme());
            newTheme.resolveAttribute(C0506b.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0506b.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0514j.Theme_AppCompat_CompactMenu, true);
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(b, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f687g = new C0559l((Context) contextThemeWrapper, C0512h.abc_list_menu_item_layout);
            this.f687g.mo2333a((C0539af) new C0470bq(this, (C0466bm) null));
            oVar.mo2449a((C0538ae) this.f687g);
        }
    }

    /* renamed from: k */
    private Menu m1977k() {
        if (!this.f684d) {
            this.f681a.mo3085a((C0539af) new C0468bo(this, (C0466bm) null), (C0563p) new C0469bp(this, (C0466bm) null));
            this.f684d = true;
        }
        return this.f681a.mo3112r();
    }

    /* renamed from: a */
    public int mo1907a() {
        return this.f681a.mo3109o();
    }

    /* renamed from: a */
    public void mo1909a(float f) {
        C0247by.m907c((View) this.f681a.mo3082a(), f);
    }

    /* renamed from: a */
    public void mo1910a(int i) {
        this.f681a.mo3098d(i);
    }

    /* renamed from: a */
    public void mo2066a(int i, int i2) {
        this.f681a.mo3095c((this.f681a.mo3109o() & (i2 ^ -1)) | (i & i2));
    }

    /* renamed from: a */
    public void mo1911a(Configuration configuration) {
        super.mo1911a(configuration);
    }

    /* renamed from: a */
    public void mo1912a(Drawable drawable) {
        this.f681a.mo3093b(drawable);
    }

    /* renamed from: a */
    public void mo2067a(View view, C0453b bVar) {
        if (view != null) {
            view.setLayoutParams(bVar);
        }
        this.f681a.setCustomView(view);
    }

    /* renamed from: a */
    public void mo1913a(CharSequence charSequence) {
        this.f681a.mo3089a(charSequence);
    }

    /* renamed from: a */
    public void mo1914a(boolean z) {
        mo2066a(z ? 4 : 0, 4);
    }

    /* renamed from: a */
    public boolean mo1915a(int i, KeyEvent keyEvent) {
        Menu k = m1977k();
        if (k != null) {
            k.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            k.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    /* renamed from: b */
    public void mo1916b(boolean z) {
        mo2066a(z ? 8 : 0, 8);
    }

    /* renamed from: b */
    public boolean mo1917b() {
        return this.f681a.mo3111q() == 0;
    }

    /* renamed from: c */
    public Context mo1918c() {
        return this.f681a.mo3091b();
    }

    /* renamed from: c */
    public void mo1919c(boolean z) {
    }

    /* renamed from: e */
    public void mo1922e(boolean z) {
    }

    /* renamed from: e */
    public boolean mo1923e() {
        this.f681a.mo3082a().removeCallbacks(this.f688h);
        C0247by.m897a((View) this.f681a.mo3082a(), this.f688h);
        return true;
    }

    /* renamed from: f */
    public void mo1924f(boolean z) {
    }

    /* renamed from: f */
    public boolean mo1925f() {
        if (!this.f681a.mo3096c()) {
            return false;
        }
        this.f681a.mo3097d();
        return true;
    }

    /* renamed from: g */
    public void mo1926g(boolean z) {
        if (z != this.f685e) {
            this.f685e = z;
            int size = this.f686f.size();
            for (int i = 0; i < size; i++) {
                ((C0480c) this.f686f.get(i)).mo2088a(z);
            }
        }
    }

    /* renamed from: g */
    public boolean mo1927g() {
        ViewGroup a = this.f681a.mo3082a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo1928h() {
        this.f681a.mo3082a().removeCallbacks(this.f688h);
    }

    /* renamed from: i */
    public Window.Callback mo2068i() {
        return this.f683c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo2069j() {
        Menu k = m1977k();
        C0562o oVar = k instanceof C0562o ? (C0562o) k : null;
        if (oVar != null) {
            oVar.mo2480g();
        }
        try {
            k.clear();
            if (!this.f683c.onCreatePanelMenu(0, k) || !this.f683c.onPreparePanel(0, (View) null, k)) {
                k.clear();
            }
        } finally {
            if (oVar != null) {
                oVar.mo2482h();
            }
        }
    }

    public void setCustomView(View view) {
        mo2067a(view, new C0453b(-2, -2));
    }
}
