package com.forexcrunch.forexcrunch.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchableWrapper extends FrameLayout {
    OnWrapperReleasedListener mListener;

    public TouchableWrapper(Context context) {
        super(context);
    }

    public TouchableWrapper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchableWrapper(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                this.mListener.OnWrapperReleased();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setOnWrapperReleasedListener(OnWrapperReleasedListener eventListener) {
        this.mListener = eventListener;
    }
}
