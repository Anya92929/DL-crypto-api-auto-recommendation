package android.support.p000v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.FragmentStatePagerAdapter */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: a */
    private final FragmentManager f496a;

    /* renamed from: b */
    private FragmentTransaction f497b = null;

    /* renamed from: c */
    private ArrayList<Fragment.SavedState> f498c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<Fragment> f499d = new ArrayList<>();

    /* renamed from: e */
    private Fragment f500e = null;

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f496a = fragmentManager;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f497b == null) {
            this.f497b = this.f496a.beginTransaction();
        }
        while (this.f498c.size() <= i) {
            this.f498c.add((Object) null);
        }
        this.f498c.set(i, this.f496a.saveFragmentInstanceState(fragment));
        this.f499d.set(i, (Object) null);
        this.f497b.remove(fragment);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.f497b != null) {
            this.f497b.commitAllowingStateLoss();
            this.f497b = null;
            this.f496a.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i);

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f499d.size() > i && (fragment = this.f499d.get(i)) != null) {
            return fragment;
        }
        if (this.f497b == null) {
            this.f497b = this.f496a.beginTransaction();
        }
        Fragment item = getItem(i);
        if (this.f498c.size() > i && (savedState = this.f498c.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f499d.size() <= i) {
            this.f499d.add((Object) null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.f499d.set(i, item);
        this.f497b.add(viewGroup.getId(), item);
        return item;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f498c.clear();
            this.f499d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f498c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f496a.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.f499d.size() <= parseInt) {
                            this.f499d.add((Object) null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f499d.set(parseInt, fragment);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle = null;
        if (this.f498c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f498c.size()];
            this.f498c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i = 0; i < this.f499d.size(); i++) {
            Fragment fragment = this.f499d.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                this.f496a.putFragment(bundle2, "f" + i, fragment);
            }
        }
        return bundle2;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f500e) {
            if (this.f500e != null) {
                this.f500e.setMenuVisibility(false);
                this.f500e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f500e = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
    }
}
