package android.support.p001v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.FragmentStatePagerAdapter */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: a */
    private final FragmentManager f220a;

    /* renamed from: b */
    private FragmentTransaction f221b = null;

    /* renamed from: c */
    private ArrayList<Fragment.SavedState> f222c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<Fragment> f223d = new ArrayList<>();

    /* renamed from: e */
    private Fragment f224e = null;

    public abstract Fragment getItem(int i);

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f220a = fragmentManager;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f223d.size() > i && (fragment = this.f223d.get(i)) != null) {
            return fragment;
        }
        if (this.f221b == null) {
            this.f221b = this.f220a.beginTransaction();
        }
        Fragment item = getItem(i);
        if (this.f222c.size() > i && (savedState = this.f222c.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f223d.size() <= i) {
            this.f223d.add((Object) null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.f223d.set(i, item);
        this.f221b.add(viewGroup.getId(), item);
        return item;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f221b == null) {
            this.f221b = this.f220a.beginTransaction();
        }
        while (this.f222c.size() <= i) {
            this.f222c.add((Object) null);
        }
        this.f222c.set(i, this.f220a.saveFragmentInstanceState(fragment));
        this.f223d.set(i, (Object) null);
        this.f221b.remove(fragment);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f224e) {
            if (this.f224e != null) {
                this.f224e.setMenuVisibility(false);
                this.f224e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f224e = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.f221b != null) {
            this.f221b.commitAllowingStateLoss();
            this.f221b = null;
            this.f220a.executePendingTransactions();
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Parcelable saveState() {
        Bundle bundle = null;
        if (this.f222c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f222c.size()];
            this.f222c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i = 0; i < this.f223d.size(); i++) {
            Fragment fragment = this.f223d.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                this.f220a.putFragment(bundle2, "f" + i, fragment);
            }
        }
        return bundle2;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f222c.clear();
            this.f223d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f222c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f220a.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.f223d.size() <= parseInt) {
                            this.f223d.add((Object) null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f223d.set(parseInt, fragment);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
