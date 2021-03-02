package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.support.p001v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {

    /* renamed from: a */
    private final FragmentManager f5a;

    /* renamed from: b */
    private FragmentTransaction f6b = null;

    /* renamed from: c */
    private Fragment f7c = null;

    public abstract Fragment getItem(int i);

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f5a = fragmentManager;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f6b == null) {
            this.f6b = this.f5a.beginTransaction();
        }
        long itemId = getItemId(i);
        Fragment findFragmentByTag = this.f5a.findFragmentByTag(m44a(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            this.f6b.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i);
            this.f6b.add(viewGroup.getId(), findFragmentByTag, m44a(viewGroup.getId(), itemId));
        }
        if (findFragmentByTag != this.f7c) {
            FragmentCompat.setMenuVisibility(findFragmentByTag, false);
            FragmentCompat.setUserVisibleHint(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f6b == null) {
            this.f6b = this.f5a.beginTransaction();
        }
        this.f6b.detach((Fragment) obj);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f7c) {
            if (this.f7c != null) {
                FragmentCompat.setMenuVisibility(this.f7c, false);
                FragmentCompat.setUserVisibleHint(this.f7c, false);
            }
            if (fragment != null) {
                FragmentCompat.setMenuVisibility(fragment, true);
                FragmentCompat.setUserVisibleHint(fragment, true);
            }
            this.f7c = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.f6b != null) {
            this.f6b.commitAllowingStateLoss();
            this.f6b = null;
            this.f5a.executePendingTransactions();
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
    private static String m44a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
