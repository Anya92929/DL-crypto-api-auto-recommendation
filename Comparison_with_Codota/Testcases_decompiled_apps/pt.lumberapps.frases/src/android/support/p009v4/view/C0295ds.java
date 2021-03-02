package android.support.p009v4.view;

import android.graphics.Rect;
import android.view.View;

/* renamed from: android.support.v4.view.ds */
class C0295ds implements C0238bp {

    /* renamed from: a */
    final /* synthetic */ ViewPager f367a;

    /* renamed from: b */
    private final Rect f368b = new Rect();

    C0295ds(ViewPager viewPager) {
        this.f367a = viewPager;
    }

    /* renamed from: a */
    public C0335fe mo1441a(View view, C0335fe feVar) {
        C0335fe a = C0247by.m889a(view, feVar);
        if (a.mo1597e()) {
            return a;
        }
        Rect rect = this.f368b;
        rect.left = a.mo1592a();
        rect.top = a.mo1594b();
        rect.right = a.mo1595c();
        rect.bottom = a.mo1596d();
        int childCount = this.f367a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0335fe b = C0247by.m902b(this.f367a.getChildAt(i), a);
            rect.left = Math.min(b.mo1592a(), rect.left);
            rect.top = Math.min(b.mo1594b(), rect.top);
            rect.right = Math.min(b.mo1595c(), rect.right);
            rect.bottom = Math.min(b.mo1596d(), rect.bottom);
        }
        return a.mo1593a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
