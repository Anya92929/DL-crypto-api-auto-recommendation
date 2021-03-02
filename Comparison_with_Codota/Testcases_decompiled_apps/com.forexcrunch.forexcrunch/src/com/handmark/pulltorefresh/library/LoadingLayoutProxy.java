package com.handmark.pulltorefresh.library;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

public class LoadingLayoutProxy implements ILoadingLayout {
    private final HashSet<LoadingLayout> mLoadingLayouts = new HashSet<>();

    LoadingLayoutProxy() {
    }

    public void addLayout(LoadingLayout layout) {
        if (layout != null) {
            this.mLoadingLayouts.add(layout);
        }
    }

    public void setLastUpdatedLabel(CharSequence label) {
        Iterator<LoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setLastUpdatedLabel(label);
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
        Iterator<LoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setLoadingDrawable(drawable);
        }
    }

    public void setRefreshingLabel(CharSequence refreshingLabel) {
        Iterator<LoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setRefreshingLabel(refreshingLabel);
        }
    }

    public void setPullLabel(CharSequence label) {
        Iterator<LoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setPullLabel(label);
        }
    }

    public void setReleaseLabel(CharSequence label) {
        Iterator<LoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setReleaseLabel(label);
        }
    }

    public void setTextTypeface(Typeface tf) {
        Iterator<LoadingLayout> it = this.mLoadingLayouts.iterator();
        while (it.hasNext()) {
            it.next().setTextTypeface(tf);
        }
    }
}
