package android.support.p007a.p008a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* renamed from: android.support.a.a.t */
class C0024t extends Drawable.ConstantState {

    /* renamed from: a */
    private final Drawable.ConstantState f144a;

    public C0024t(Drawable.ConstantState constantState) {
        this.f144a = constantState;
    }

    public boolean canApplyTheme() {
        return this.f144a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.f144a.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        C0016l lVar = new C0016l();
        lVar.f76a = (VectorDrawable) this.f144a.newDrawable();
        return lVar;
    }

    public Drawable newDrawable(Resources resources) {
        C0016l lVar = new C0016l();
        lVar.f76a = (VectorDrawable) this.f144a.newDrawable(resources);
        return lVar;
    }

    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        C0016l lVar = new C0016l();
        lVar.f76a = (VectorDrawable) this.f144a.newDrawable(resources, theme);
        return lVar;
    }
}
