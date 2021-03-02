package p000;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p001v4.view.ViewCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.graphics.drawable.DrawableUtils;
import android.support.p004v7.widget.TintManager;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: gp */
public class C1172gp {

    /* renamed from: a */
    private final View f4170a;

    /* renamed from: b */
    private final TintManager f4171b;

    /* renamed from: c */
    private C1191hc f4172c;

    /* renamed from: d */
    private C1191hc f4173d;

    public C1172gp(View view, TintManager tintManager) {
        this.f4170a = view;
        this.f4171b = tintManager;
    }

    /* renamed from: a */
    public void mo8186a(AttributeSet attributeSet, int i) {
        ColorStateList tintList;
        TypedArray obtainStyledAttributes = this.f4170a.getContext().obtainStyledAttributes(attributeSet, C0505R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0505R.styleable.ViewBackgroundHelper_android_background) && (tintList = this.f4171b.getTintList(obtainStyledAttributes.getResourceId(C0505R.styleable.ViewBackgroundHelper_android_background, -1))) != null) {
                mo8188b(tintList);
            }
            if (obtainStyledAttributes.hasValue(C0505R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.f4170a, obtainStyledAttributes.getColorStateList(C0505R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(C0505R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.f4170a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0505R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public void mo8182a(int i) {
        mo8188b(this.f4171b != null ? this.f4171b.getTintList(i) : null);
    }

    /* renamed from: a */
    public void mo8185a(Drawable drawable) {
        mo8188b((ColorStateList) null);
    }

    /* renamed from: a */
    public void mo8183a(ColorStateList colorStateList) {
        if (this.f4173d == null) {
            this.f4173d = new C1191hc();
        }
        this.f4173d.f4249a = colorStateList;
        this.f4173d.f4252d = true;
        mo8189c();
    }

    /* renamed from: a */
    public ColorStateList mo8181a() {
        if (this.f4173d != null) {
            return this.f4173d.f4249a;
        }
        return null;
    }

    /* renamed from: a */
    public void mo8184a(PorterDuff.Mode mode) {
        if (this.f4173d == null) {
            this.f4173d = new C1191hc();
        }
        this.f4173d.f4250b = mode;
        this.f4173d.f4251c = true;
        mo8189c();
    }

    /* renamed from: b */
    public PorterDuff.Mode mo8187b() {
        if (this.f4173d != null) {
            return this.f4173d.f4250b;
        }
        return null;
    }

    /* renamed from: c */
    public void mo8189c() {
        Drawable background = this.f4170a.getBackground();
        if (background == null) {
            return;
        }
        if (this.f4173d != null) {
            TintManager.tintDrawable(background, this.f4173d, this.f4170a.getDrawableState());
        } else if (this.f4172c != null) {
            TintManager.tintDrawable(background, this.f4172c, this.f4170a.getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8188b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f4172c == null) {
                this.f4172c = new C1191hc();
            }
            this.f4172c.f4249a = colorStateList;
            this.f4172c.f4252d = true;
        } else {
            this.f4172c = null;
        }
        mo8189c();
    }
}
