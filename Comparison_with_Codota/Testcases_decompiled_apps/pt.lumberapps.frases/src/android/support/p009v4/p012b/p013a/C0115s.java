package android.support.p009v4.p012b.p013a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.b.a.s */
public abstract class C0115s extends Drawable.ConstantState {

    /* renamed from: a */
    int f179a;

    /* renamed from: b */
    Drawable.ConstantState f180b;

    /* renamed from: c */
    ColorStateList f181c = null;

    /* renamed from: d */
    PorterDuff.Mode f182d = C0114r.f172a;

    C0115s(C0115s sVar, Resources resources) {
        if (sVar != null) {
            this.f179a = sVar.f179a;
            this.f180b = sVar.f180b;
            this.f181c = sVar.f181c;
            this.f182d = sVar.f182d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1010a() {
        return this.f180b != null;
    }

    public int getChangingConfigurations() {
        return (this.f180b != null ? this.f180b.getChangingConfigurations() : 0) | this.f179a;
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public abstract Drawable newDrawable(Resources resources);
}
