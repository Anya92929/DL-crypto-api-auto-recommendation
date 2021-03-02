package com.myip.vpnroot;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

public class ScrollPager implements View.OnTouchListener {
    private ViewGroup mContentView;
    /* access modifiers changed from: private */
    public ScrollView mScrollView;
    /* access modifiers changed from: private */
    public Scroller scroller = new Scroller(this.mScrollView.getContext(), new OvershootInterpolator());
    private Runnable task = new Runnable() {
        public void run() {
            ScrollPager.this.scroller.computeScrollOffset();
            ScrollPager.this.mScrollView.scrollTo(0, ScrollPager.this.scroller.getCurrY());
            if (!ScrollPager.this.scroller.isFinished()) {
                ScrollPager.this.mScrollView.post(this);
            }
        }
    };

    public ScrollPager(ScrollView aScrollView, ViewGroup aContentView) {
        this.mScrollView = aScrollView;
        this.mContentView = aContentView;
    }

    public boolean onTouch(View v, MotionEvent event) {
        this.scroller.forceFinished(true);
        this.mScrollView.removeCallbacks(this.task);
        if (event.getAction() != 1) {
            return false;
        }
        int displayHeight = this.mScrollView.getHeight();
        int contentTop = this.mContentView.getPaddingTop();
        int currScrollY = this.mScrollView.getScrollY();
        this.scroller.startScroll(0, currScrollY, 0, Math.max(Math.min((this.mContentView.getHeight() - this.mContentView.getPaddingBottom()) - displayHeight, contentTop + (((((displayHeight / 2) + currScrollY) - contentTop) / displayHeight) * displayHeight)), contentTop) - currScrollY, 500);
        this.mScrollView.post(this.task);
        return true;
    }
}
