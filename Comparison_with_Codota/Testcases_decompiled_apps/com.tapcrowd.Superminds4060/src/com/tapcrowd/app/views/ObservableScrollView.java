package com.tapcrowd.app.views;

import android.content.Context;
import android.util.AttributeSet;

public class ObservableScrollView extends TwoDScrollView {
    private ScrollViewListener scrollViewListener = null;

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener2) {
        this.scrollViewListener = scrollViewListener2;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (this.scrollViewListener != null) {
            this.scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }
}
