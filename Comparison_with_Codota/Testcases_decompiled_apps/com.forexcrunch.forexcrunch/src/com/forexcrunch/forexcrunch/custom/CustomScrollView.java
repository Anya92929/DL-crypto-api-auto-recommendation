package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            this.gestureDetector = new GestureDetector(new YScrollDetector());
            setFadingEdgeLength(0);
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = super.onInterceptTouchEvent(ev);
        if (this.gestureDetector.onTouchEvent(ev)) {
            return result;
        }
        return false;
    }

    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        YScrollDetector() {
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            try {
                if (Math.abs(distanceY) > Math.abs(distanceX)) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
