package android.support.p021v7.view;

import android.content.Context;
import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.support.p021v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.view.f */
public class C0525f extends C0521b implements C0563p {

    /* renamed from: a */
    private Context f899a;

    /* renamed from: b */
    private ActionBarContextView f900b;

    /* renamed from: c */
    private C0522c f901c;

    /* renamed from: d */
    private WeakReference f902d;

    /* renamed from: e */
    private boolean f903e;

    /* renamed from: f */
    private boolean f904f;

    /* renamed from: g */
    private C0562o f905g;

    public C0525f(Context context, ActionBarContextView actionBarContextView, C0522c cVar, boolean z) {
        this.f899a = context;
        this.f900b = actionBarContextView;
        this.f901c = cVar;
        this.f905g = new C0562o(actionBarContextView.getContext()).mo2442a(1);
        this.f905g.mo2370a((C0563p) this);
        this.f904f = z;
    }

    /* renamed from: a */
    public MenuInflater mo2089a() {
        return new MenuInflater(this.f900b.getContext());
    }

    /* renamed from: a */
    public void mo2090a(int i) {
        mo2095b((CharSequence) this.f899a.getString(i));
    }

    /* renamed from: a */
    public void mo2028a(C0562o oVar) {
        mo2097d();
        this.f900b.mo2641a();
    }

    /* renamed from: a */
    public void mo2091a(CharSequence charSequence) {
        this.f900b.setSubtitle(charSequence);
    }

    /* renamed from: a */
    public void mo2092a(boolean z) {
        super.mo2092a(z);
        this.f900b.setTitleOptional(z);
    }

    /* renamed from: a */
    public boolean mo2030a(C0562o oVar, MenuItem menuItem) {
        return this.f901c.mo2045a((C0521b) this, menuItem);
    }

    /* renamed from: b */
    public Menu mo2093b() {
        return this.f905g;
    }

    /* renamed from: b */
    public void mo2094b(int i) {
        mo2091a((CharSequence) this.f899a.getString(i));
    }

    /* renamed from: b */
    public void mo2095b(CharSequence charSequence) {
        this.f900b.setTitle(charSequence);
    }

    /* renamed from: c */
    public void mo2096c() {
        if (!this.f903e) {
            this.f903e = true;
            this.f900b.sendAccessibilityEvent(32);
            this.f901c.mo2043a(this);
        }
    }

    /* renamed from: d */
    public void mo2097d() {
        this.f901c.mo2046b(this, this.f905g);
    }

    /* renamed from: f */
    public CharSequence mo2099f() {
        return this.f900b.getTitle();
    }

    /* renamed from: g */
    public CharSequence mo2100g() {
        return this.f900b.getSubtitle();
    }

    /* renamed from: h */
    public boolean mo2101h() {
        return this.f900b.mo2644d();
    }

    /* renamed from: i */
    public View mo2102i() {
        if (this.f902d != null) {
            return (View) this.f902d.get();
        }
        return null;
    }

    public void setCustomView(View view) {
        this.f900b.setCustomView(view);
        this.f902d = view != null ? new WeakReference(view) : null;
    }
}
