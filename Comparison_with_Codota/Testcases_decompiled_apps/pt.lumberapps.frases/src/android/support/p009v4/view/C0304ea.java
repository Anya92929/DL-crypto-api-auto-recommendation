package android.support.p009v4.view;

import android.database.DataSetObserver;

/* renamed from: android.support.v4.view.ea */
class C0304ea extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ ViewPager f381a;

    private C0304ea(ViewPager viewPager) {
        this.f381a = viewPager;
    }

    /* synthetic */ C0304ea(ViewPager viewPager, C0292dp dpVar) {
        this(viewPager);
    }

    public void onChanged() {
        this.f381a.mo1197b();
    }

    public void onInvalidated() {
        this.f381a.mo1197b();
    }
}
