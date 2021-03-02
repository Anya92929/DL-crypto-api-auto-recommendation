package android.support.p009v4.view;

/* renamed from: android.support.v4.view.dr */
class C0294dr implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ViewPager f366a;

    C0294dr(ViewPager viewPager) {
        this.f366a = viewPager;
    }

    public void run() {
        this.f366a.setScrollState(0);
        this.f366a.mo1199c();
    }
}
