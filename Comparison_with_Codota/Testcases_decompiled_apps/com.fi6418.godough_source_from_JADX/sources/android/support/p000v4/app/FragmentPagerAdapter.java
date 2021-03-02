package android.support.p000v4.app;

import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.app.FragmentPagerAdapter */
public abstract class FragmentPagerAdapter extends PagerAdapter {

    /* renamed from: a */
    private final FragmentManager f482a;

    /* renamed from: b */
    private FragmentTransaction f483b = null;

    /* renamed from: c */
    private Fragment f484c = null;

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f482a = fragmentManager;
    }

    /* renamed from: a */
    private static String m507a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f483b == null) {
            this.f483b = this.f482a.beginTransaction();
        }
        this.f483b.detach((Fragment) obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.f483b != null) {
            this.f483b.commitAllowingStateLoss();
            this.f483b = null;
            this.f482a.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f483b == null) {
            this.f483b = this.f482a.beginTransaction();
        }
        long itemId = getItemId(i);
        Fragment findFragmentByTag = this.f482a.findFragmentByTag(m507a(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            this.f483b.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.f483b.add(viewGroup.getId(), findFragmentByTag, m507a(viewGroup.getId(), itemId));
        }
        if (findFragmentByTag != this.f484c) {
            findFragmentByTag.setMenuVisibility(false);
            findFragmentByTag.setUserVisibleHint(false);
        }
        return findFragmentByTag;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f484c) {
            if (this.f484c != null) {
                this.f484c.setMenuVisibility(false);
                this.f484c.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f484c = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
    }
}
