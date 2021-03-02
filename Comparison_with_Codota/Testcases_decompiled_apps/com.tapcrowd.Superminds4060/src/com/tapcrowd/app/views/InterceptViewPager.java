package com.tapcrowd.app.views;

import android.content.Context;
import android.graphics.Rect;
import android.support.p000v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class InterceptViewPager extends ViewPager {
    private int childId;
    private int page;

    public InterceptViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        View scroll;
        int currentitem = getCurrentItem();
        if (this.childId > 0 && this.page == currentitem && (scroll = findViewById(this.childId)) != null) {
            int deltaX = 0;
            if (currentitem == getAdapter().getCount() - 1) {
                deltaX = (getMeasuredWidth() / 10) * 2;
            }
            Rect rect = new Rect();
            scroll.getHitRect(rect);
            if (rect.contains(((int) event.getX()) - deltaX, (int) event.getY())) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(event);
    }

    public void setChildId(int id, int page2) {
        this.childId = id;
        this.page = page2;
    }
}
