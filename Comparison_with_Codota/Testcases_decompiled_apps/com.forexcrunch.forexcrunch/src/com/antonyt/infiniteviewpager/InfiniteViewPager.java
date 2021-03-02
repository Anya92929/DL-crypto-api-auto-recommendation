package com.antonyt.infiniteviewpager;

import android.content.Context;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class InfiniteViewPager extends ViewPager {
    public static final int OFFSET = 1000;
    private ArrayList<DateTime> dateInMonthsList;
    private boolean enabled = true;
    private boolean fitAllMonths = true;
    private int rowHeight = 0;

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled2) {
        this.enabled = enabled2;
    }

    public boolean isFitAllMonths() {
        return this.fitAllMonths;
    }

    public void setFitAllMonths(boolean fitAllMonths2) {
        this.fitAllMonths = fitAllMonths2;
        this.rowHeight = 0;
    }

    public ArrayList<DateTime> getDateInMonthsList() {
        return this.dateInMonthsList;
    }

    public void setDateInMonthsList(ArrayList<DateTime> dateInMonthsList2) {
        this.dateInMonthsList = dateInMonthsList2;
    }

    public InfiniteViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InfiniteViewPager(Context context) {
        super(context);
    }

    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        setCurrentItem(1000);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean wrapHeight;
        int calHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int rows = this.dateInMonthsList.size() / 7;
        if (View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE) {
            wrapHeight = true;
        } else {
            wrapHeight = false;
        }
        int height = getMeasuredHeight();
        if (wrapHeight && this.rowHeight == 0) {
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            if (getChildCount() > 0) {
                View firstChild = getChildAt(0);
                firstChild.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
                height = firstChild.getMeasuredHeight();
                this.rowHeight = height / rows;
            }
        }
        if (this.fitAllMonths) {
            calHeight = this.rowHeight * 6;
        } else {
            calHeight = this.rowHeight * rows;
        }
        if (calHeight > height) {
            calHeight = height;
        }
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(calHeight, 1073741824));
    }
}
