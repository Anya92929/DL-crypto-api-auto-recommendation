package android.support.p007a.p008a;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p019f.C0136a;
import java.util.ArrayList;

/* renamed from: android.support.a.a.d */
class C0008d extends Drawable.ConstantState {

    /* renamed from: a */
    int f67a;

    /* renamed from: b */
    C0016l f68b;

    /* renamed from: c */
    ArrayList f69c;

    /* renamed from: d */
    C0136a f70d;

    public C0008d(Context context, C0008d dVar, Drawable.Callback callback, Resources resources) {
        if (dVar != null) {
            this.f67a = dVar.f67a;
            if (dVar.f68b != null) {
                Drawable.ConstantState constantState = dVar.f68b.getConstantState();
                if (resources != null) {
                    this.f68b = (C0016l) constantState.newDrawable(resources);
                } else {
                    this.f68b = (C0016l) constantState.newDrawable();
                }
                this.f68b = (C0016l) this.f68b.mutate();
                this.f68b.setCallback(callback);
                this.f68b.setBounds(dVar.f68b.getBounds());
                this.f68b.mo74a(false);
            }
            if (dVar.f69c != null) {
                int size = dVar.f69c.size();
                this.f69c = new ArrayList(size);
                this.f70d = new C0136a(size);
                for (int i = 0; i < size; i++) {
                    Animator animator = (Animator) dVar.f69c.get(i);
                    Animator clone = animator.clone();
                    String str = (String) dVar.f70d.get(animator);
                    clone.setTarget(this.f68b.mo73a(str));
                    this.f69c.add(clone);
                    this.f70d.put(clone, str);
                }
            }
        }
    }

    public int getChangingConfigurations() {
        return this.f67a;
    }

    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 23.");
    }

    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 23.");
    }
}
