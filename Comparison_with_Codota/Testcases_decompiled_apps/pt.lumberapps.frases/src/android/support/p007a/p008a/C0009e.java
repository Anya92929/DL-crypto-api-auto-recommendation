package android.support.p007a.p008a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.a.a.e */
class C0009e extends Drawable.ConstantState {

    /* renamed from: a */
    private final Drawable.ConstantState f71a;

    public C0009e(Drawable.ConstantState constantState) {
        this.f71a = constantState;
    }

    public boolean canApplyTheme() {
        return this.f71a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.f71a.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        C0006b bVar = new C0006b((C0007c) null);
        bVar.f76a = this.f71a.newDrawable();
        bVar.f76a.setCallback(bVar.f65e);
        return bVar;
    }

    public Drawable newDrawable(Resources resources) {
        C0006b bVar = new C0006b((C0007c) null);
        bVar.f76a = this.f71a.newDrawable(resources);
        bVar.f76a.setCallback(bVar.f65e);
        return bVar;
    }

    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        C0006b bVar = new C0006b((C0007c) null);
        bVar.f76a = this.f71a.newDrawable(resources, theme);
        bVar.f76a.setCallback(bVar.f65e);
        return bVar;
    }
}
