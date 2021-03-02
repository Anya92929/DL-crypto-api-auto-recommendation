package com.antonyt.infiniteviewpager;

import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class InfinitePagerAdapter extends PagerAdapter {
    private PagerAdapter adapter;

    public InfinitePagerAdapter(PagerAdapter adapter2) {
        this.adapter = adapter2;
    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public int getRealCount() {
        return this.adapter.getCount();
    }

    public Object instantiateItem(ViewGroup container, int position) {
        return this.adapter.instantiateItem(container, position % getRealCount());
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        this.adapter.destroyItem(container, position % getRealCount(), object);
    }

    public void finishUpdate(ViewGroup container) {
        this.adapter.finishUpdate(container);
    }

    public boolean isViewFromObject(View view, Object object) {
        return this.adapter.isViewFromObject(view, object);
    }

    public void restoreState(Parcelable bundle, ClassLoader classLoader) {
        this.adapter.restoreState(bundle, classLoader);
    }

    public Parcelable saveState() {
        return this.adapter.saveState();
    }

    public void startUpdate(ViewGroup container) {
        this.adapter.startUpdate(container);
    }
}
