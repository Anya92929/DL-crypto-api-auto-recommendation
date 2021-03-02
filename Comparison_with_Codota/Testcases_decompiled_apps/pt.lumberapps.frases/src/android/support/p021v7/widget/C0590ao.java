package android.support.p021v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p012b.p013a.C0095a;
import android.support.p009v4.widget.C0404e;
import android.support.p021v7.p023b.C0515k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* renamed from: android.support.v7.widget.ao */
class C0590ao {

    /* renamed from: a */
    private final CompoundButton f1387a;

    /* renamed from: b */
    private final C0591ap f1388b;

    /* renamed from: c */
    private ColorStateList f1389c = null;

    /* renamed from: d */
    private PorterDuff.Mode f1390d = null;

    /* renamed from: e */
    private boolean f1391e = false;

    /* renamed from: f */
    private boolean f1392f = false;

    /* renamed from: g */
    private boolean f1393g;

    C0590ao(CompoundButton compoundButton, C0591ap apVar) {
        this.f1387a = compoundButton;
        this.f1388b = apVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = android.support.p009v4.widget.C0404e.m1704a(r2.f1387a);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo2973a(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f1387a
            android.graphics.drawable.Drawable r0 = android.support.p009v4.widget.C0404e.m1704a(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p021v7.widget.C0590ao.mo2973a(int):int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ColorStateList mo2974a() {
        return this.f1389c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2975a(ColorStateList colorStateList) {
        this.f1389c = colorStateList;
        this.f1391e = true;
        mo2980d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2976a(PorterDuff.Mode mode) {
        this.f1390d = mode;
        this.f1392f = true;
        mo2980d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2977a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f1387a.getContext().obtainStyledAttributes(attributeSet, C0515k.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0515k.CompoundButton_android_button) && (resourceId = obtainStyledAttributes.getResourceId(C0515k.CompoundButton_android_button, 0)) != 0) {
                this.f1387a.setButtonDrawable(this.f1388b.mo2982a(this.f1387a.getContext(), resourceId));
            }
            if (obtainStyledAttributes.hasValue(C0515k.CompoundButton_buttonTint)) {
                C0404e.m1705a(this.f1387a, obtainStyledAttributes.getColorStateList(C0515k.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0515k.CompoundButton_buttonTintMode)) {
                C0404e.m1706a(this.f1387a, C0624bv.m2853a(obtainStyledAttributes.getInt(C0515k.CompoundButton_buttonTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public PorterDuff.Mode mo2978b() {
        return this.f1390d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2979c() {
        if (this.f1393g) {
            this.f1393g = false;
            return;
        }
        this.f1393g = true;
        mo2980d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo2980d() {
        Drawable a = C0404e.m1704a(this.f1387a);
        if (a == null) {
            return;
        }
        if (this.f1391e || this.f1392f) {
            Drawable mutate = C0095a.m208f(a).mutate();
            if (this.f1391e) {
                C0095a.m198a(mutate, this.f1389c);
            }
            if (this.f1392f) {
                C0095a.m201a(mutate, this.f1390d);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1387a.getDrawableState());
            }
            this.f1387a.setButtonDrawable(mutate);
        }
    }
}
