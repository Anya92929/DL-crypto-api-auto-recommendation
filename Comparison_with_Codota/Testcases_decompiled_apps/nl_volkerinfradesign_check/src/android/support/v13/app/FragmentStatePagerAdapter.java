package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: a */
    private final FragmentManager f8a;

    /* renamed from: b */
    private FragmentTransaction f9b = null;

    /* renamed from: c */
    private ArrayList<Fragment.SavedState> f10c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<Fragment> f11d = new ArrayList<>();

    /* renamed from: e */
    private Fragment f12e = null;

    public abstract Fragment getItem(int i);

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f8a = fragmentManager;
    }

    public void startUpdate(ViewGroup viewGroup) {
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f11d.size() > i && (fragment = this.f11d.get(i)) != null) {
            return fragment;
        }
        if (this.f9b == null) {
            this.f9b = this.f8a.beginTransaction();
        }
        Fragment item = getItem(i);
        if (this.f10c.size() > i && (savedState = this.f10c.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f11d.size() <= i) {
            this.f11d.add((Object) null);
        }
        FragmentCompat.setMenuVisibility(item, false);
        FragmentCompat.setUserVisibleHint(item, false);
        this.f11d.set(i, item);
        this.f9b.add(viewGroup.getId(), item);
        return item;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f9b == null) {
            this.f9b = this.f8a.beginTransaction();
        }
        while (this.f10c.size() <= i) {
            this.f10c.add((Object) null);
        }
        this.f10c.set(i, this.f8a.saveFragmentInstanceState(fragment));
        this.f11d.set(i, (Object) null);
        this.f9b.remove(fragment);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f12e) {
            if (this.f12e != null) {
                FragmentCompat.setMenuVisibility(this.f12e, false);
                FragmentCompat.setUserVisibleHint(this.f12e, false);
            }
            if (fragment != null) {
                FragmentCompat.setMenuVisibility(fragment, true);
                FragmentCompat.setUserVisibleHint(fragment, true);
            }
            this.f12e = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.f9b != null) {
            this.f9b.commitAllowingStateLoss();
            this.f9b = null;
            this.f8a.executePendingTransactions();
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Parcelable saveState() {
        Bundle bundle = null;
        if (this.f10c.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f10c.size()];
            this.f10c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i = 0; i < this.f11d.size(); i++) {
            Fragment fragment = this.f11d.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                this.f8a.putFragment(bundle2, "f" + i, fragment);
            }
        }
        return bundle2;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f10c.clear();
            this.f11d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f10c.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f8a.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.f11d.size() <= parseInt) {
                            this.f11d.add((Object) null);
                        }
                        FragmentCompat.setMenuVisibility(fragment, false);
                        this.f11d.set(parseInt, fragment);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
