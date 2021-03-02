package android.support.p001v4.app;

import android.os.Parcelable;
import android.support.p001v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.app.FragmentPagerAdapter */
public abstract class FragmentPagerAdapter extends PagerAdapter {

    /* renamed from: a */
    private final FragmentManager f206a;

    /* renamed from: b */
    private FragmentTransaction f207b = null;

    /* renamed from: c */
    private Fragment f208c = null;

    public abstract Fragment getItem(int i);

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f206a = fragmentManager;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f207b == null) {
            this.f207b = this.f206a.beginTransaction();
        }
        long itemId = getItemId(i);
        Fragment findFragmentByTag = this.f206a.findFragmentByTag(m203a(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            this.f207b.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.f207b.add(viewGroup.getId(), findFragmentByTag, m203a(viewGroup.getId(), itemId));
        }
        if (findFragmentByTag != this.f208c) {
            findFragmentByTag.setMenuVisibility(false);
            findFragmentByTag.setUserVisibleHint(false);
        }
        return findFragmentByTag;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f207b == null) {
            this.f207b = this.f206a.beginTransaction();
        }
        this.f207b.detach((Fragment) obj);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f208c) {
            if (this.f208c != null) {
                this.f208c.setMenuVisibility(false);
                this.f208c.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f208c = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.f207b != null) {
            this.f207b.commitAllowingStateLoss();
            this.f207b = null;
            this.f206a.executePendingTransactions();
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Parcelable saveState() {
        return null;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: a */
    private static String m203a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
