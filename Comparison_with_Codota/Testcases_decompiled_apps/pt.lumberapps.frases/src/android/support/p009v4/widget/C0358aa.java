package android.support.p009v4.widget;

import android.view.View;

/* renamed from: android.support.v4.widget.aa */
class C0358aa extends C0401bq {

    /* renamed from: a */
    final /* synthetic */ DrawerLayout f501a;

    /* renamed from: b */
    private final int f502b;

    /* renamed from: c */
    private C0398bn f503c;

    /* renamed from: d */
    private final Runnable f504d = new C0359ab(this);

    public C0358aa(DrawerLayout drawerLayout, int i) {
        this.f501a = drawerLayout;
        this.f502b = i;
    }

    /* renamed from: b */
    private void m1466b() {
        int i = 3;
        if (this.f502b == 3) {
            i = 5;
        }
        View c = this.f501a.mo1651c(i);
        if (c != null) {
            this.f501a.closeDrawer(c);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1467c() {
        View view;
        int i;
        int i2 = 0;
        int b = this.f503c.mo1844b();
        boolean z = this.f502b == 3;
        if (z) {
            View c = this.f501a.mo1651c(3);
            if (c != null) {
                i2 = -c.getWidth();
            }
            int i3 = i2 + b;
            view = c;
            i = i3;
        } else {
            View c2 = this.f501a.mo1651c(5);
            int width = this.f501a.getWidth() - b;
            view = c2;
            i = width;
        }
        if (view == null) {
            return;
        }
        if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.f501a.mo1635a(view) == 0) {
            this.f503c.mo1842a(view, i, view.getTop());
            boolean unused = ((C0424y) view.getLayoutParams()).f575c = true;
            this.f501a.invalidate();
            m1466b();
            this.f501a.mo1652c();
        }
    }

    /* renamed from: a */
    public int mo1765a(View view) {
        if (this.f501a.mo1664g(view)) {
            return view.getWidth();
        }
        return 0;
    }

    /* renamed from: a */
    public int mo1766a(View view, int i, int i2) {
        if (this.f501a.mo1643a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f501a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    /* renamed from: a */
    public void mo1767a() {
        this.f501a.removeCallbacks(this.f504d);
    }

    /* renamed from: a */
    public void mo1768a(int i) {
        this.f501a.mo1638a(this.f502b, i, this.f503c.mo1850c());
    }

    /* renamed from: a */
    public void mo1769a(int i, int i2) {
        this.f501a.postDelayed(this.f504d, 160);
    }

    /* renamed from: a */
    public void mo1770a(C0398bn bnVar) {
        this.f503c = bnVar;
    }

    /* renamed from: a */
    public void mo1771a(View view, float f, float f2) {
        int width;
        float d = this.f501a.mo1657d(view);
        int width2 = view.getWidth();
        if (this.f501a.mo1643a(view, 3)) {
            width = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width2;
        } else {
            width = this.f501a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                width -= width2;
            }
        }
        this.f503c.mo1840a(width, view.getTop());
        this.f501a.invalidate();
    }

    /* renamed from: a */
    public void mo1772a(View view, int i, int i2, int i3, int i4) {
        int width = view.getWidth();
        float width2 = this.f501a.mo1643a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (this.f501a.getWidth() - i)) / ((float) width);
        this.f501a.mo1650b(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        this.f501a.invalidate();
    }

    /* renamed from: a */
    public boolean mo1773a(View view, int i) {
        return this.f501a.mo1664g(view) && this.f501a.mo1643a(view, this.f502b) && this.f501a.mo1635a(view) == 0;
    }

    /* renamed from: b */
    public int mo1774b(View view, int i, int i2) {
        return view.getTop();
    }

    /* renamed from: b */
    public void mo1775b(int i, int i2) {
        View c = (i & 1) == 1 ? this.f501a.mo1651c(3) : this.f501a.mo1651c(5);
        if (c != null && this.f501a.mo1635a(c) == 0) {
            this.f503c.mo1839a(c, i2);
        }
    }

    /* renamed from: b */
    public void mo1776b(View view, int i) {
        boolean unused = ((C0424y) view.getLayoutParams()).f575c = false;
        m1466b();
    }

    /* renamed from: b */
    public boolean mo1777b(int i) {
        return false;
    }
}
