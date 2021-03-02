package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: android.support.design.widget.an */
public final class C0022an {

    /* renamed from: a */
    private Drawable f139a;

    /* renamed from: b */
    private CharSequence f140b;

    /* renamed from: c */
    private CharSequence f141c;

    /* renamed from: d */
    private int f142d = -1;

    /* renamed from: e */
    private View f143e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final TabLayout f144f;

    C0022an(TabLayout tabLayout) {
        this.f144f = tabLayout;
    }

    /* renamed from: a */
    public C0022an mo204a(CharSequence charSequence) {
        this.f140b = charSequence;
        if (this.f142d >= 0) {
            this.f144f.m141b(this.f142d);
        }
        return this;
    }

    /* renamed from: a */
    public View mo205a() {
        return this.f143e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo206a(int i) {
        this.f142d = i;
    }

    /* renamed from: b */
    public Drawable mo207b() {
        return this.f139a;
    }

    /* renamed from: c */
    public int mo208c() {
        return this.f142d;
    }

    /* renamed from: d */
    public CharSequence mo209d() {
        return this.f140b;
    }

    /* renamed from: e */
    public void mo210e() {
        this.f144f.mo153b(this);
    }

    /* renamed from: f */
    public CharSequence mo211f() {
        return this.f141c;
    }
}
