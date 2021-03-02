package android.support.design.widget;

import android.support.p000v4.view.ViewPager;

/* renamed from: android.support.design.widget.aq */
public class C0025aq implements C0018aj {

    /* renamed from: a */
    private final ViewPager f155a;

    public C0025aq(ViewPager viewPager) {
        this.f155a = viewPager;
    }

    public void onTabReselected(C0022an anVar) {
    }

    public void onTabSelected(C0022an anVar) {
        this.f155a.setCurrentItem(anVar.mo208c());
    }

    public void onTabUnselected(C0022an anVar) {
    }
}
