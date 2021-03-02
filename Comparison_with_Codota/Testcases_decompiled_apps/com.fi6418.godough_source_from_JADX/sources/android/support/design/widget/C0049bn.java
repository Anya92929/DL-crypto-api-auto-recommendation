package android.support.design.widget;

import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.design.widget.bn */
class C0049bn {

    /* renamed from: a */
    private final View f188a;

    /* renamed from: b */
    private int f189b;

    /* renamed from: c */
    private int f190c;

    /* renamed from: d */
    private int f191d;

    /* renamed from: e */
    private int f192e;

    public C0049bn(View view) {
        this.f188a = view;
    }

    /* renamed from: a */
    private static void m292a(View view) {
        float translationX = ViewCompat.getTranslationX(view);
        ViewCompat.setTranslationX(view, 1.0f + translationX);
        ViewCompat.setTranslationX(view, translationX);
    }

    /* renamed from: c */
    private void m293c() {
        ViewCompat.offsetTopAndBottom(this.f188a, this.f191d - (this.f188a.getTop() - this.f189b));
        ViewCompat.offsetLeftAndRight(this.f188a, this.f192e - (this.f188a.getLeft() - this.f190c));
        if (Build.VERSION.SDK_INT < 23) {
            m292a(this.f188a);
            ViewParent parent = this.f188a.getParent();
            if (parent instanceof View) {
                m292a((View) parent);
            }
        }
    }

    /* renamed from: a */
    public void mo256a() {
        this.f189b = this.f188a.getTop();
        this.f190c = this.f188a.getLeft();
        m293c();
    }

    /* renamed from: a */
    public boolean mo257a(int i) {
        if (this.f191d == i) {
            return false;
        }
        this.f191d = i;
        m293c();
        return true;
    }

    /* renamed from: b */
    public int mo258b() {
        return this.f191d;
    }

    /* renamed from: b */
    public boolean mo259b(int i) {
        if (this.f192e == i) {
            return false;
        }
        this.f192e = i;
        m293c();
        return true;
    }
}
