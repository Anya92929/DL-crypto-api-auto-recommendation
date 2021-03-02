package android.support.design.widget;

import android.support.p000v4.view.ViewPager;
import java.lang.ref.WeakReference;

/* renamed from: android.support.design.widget.ao */
public class C0023ao implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    private final WeakReference<TabLayout> f145a;

    /* renamed from: b */
    private int f146b;

    /* renamed from: c */
    private int f147c;

    public C0023ao(TabLayout tabLayout) {
        this.f145a = new WeakReference<>(tabLayout);
    }

    public void onPageScrollStateChanged(int i) {
        this.f146b = this.f147c;
        this.f147c = i;
    }

    public void onPageScrolled(int i, float f, int i2) {
        boolean z = true;
        TabLayout tabLayout = (TabLayout) this.f145a.get();
        if (tabLayout != null) {
            if (!(this.f147c == 1 || (this.f147c == 2 && this.f146b == 1))) {
                z = false;
            }
            tabLayout.mo149a(i, f, z);
        }
    }

    public void onPageSelected(int i) {
        TabLayout tabLayout = (TabLayout) this.f145a.get();
        if (tabLayout != null) {
            tabLayout.mo154b(tabLayout.mo148a(i), this.f147c == 0);
        }
    }
}
