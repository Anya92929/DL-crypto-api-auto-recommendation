package com.slidingmenu.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.slidingmenu.lib.SlidingMenu;

public class CustomViewBehind extends ViewGroup {
    private static final int MARGIN_THRESHOLD = 48;
    private static final String TAG = "CustomViewBehind";
    private boolean mChildrenEnabled;
    private View mContent;
    private float mFadeDegree;
    private boolean mFadeEnabled;
    private final Paint mFadePaint;
    private int mMarginThreshold;
    private int mMode;
    private float mScrollScale;
    private View mSecondaryContent;
    private Drawable mSecondaryShadowDrawable;
    private View mSelectedView;
    private Bitmap mSelectorDrawable;
    private boolean mSelectorEnabled;
    private Drawable mShadowDrawable;
    private int mShadowWidth;
    private int mTouchMode;
    private SlidingMenu.CanvasTransformer mTransformer;
    private CustomViewAbove mViewAbove;
    private int mWidthOffset;

    public CustomViewBehind(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomViewBehind(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTouchMode = 0;
        this.mFadePaint = new Paint();
        this.mSelectorEnabled = true;
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
    }

    public void setCustomViewAbove(CustomViewAbove customViewAbove) {
        this.mViewAbove = customViewAbove;
    }

    public void setCanvasTransformer(SlidingMenu.CanvasTransformer t) {
        this.mTransformer = t;
    }

    public void setWidthOffset(int i) {
        this.mWidthOffset = i;
        requestLayout();
    }

    public void setMarginThreshold(int marginThreshold) {
        this.mMarginThreshold = marginThreshold;
    }

    public int getMarginThreshold() {
        return this.mMarginThreshold;
    }

    public int getBehindWidth() {
        return this.mContent.getWidth();
    }

    public void setContent(View v) {
        if (this.mContent != null) {
            removeView(this.mContent);
        }
        this.mContent = v;
        addView(this.mContent);
    }

    public View getContent() {
        return this.mContent;
    }

    public void setSecondaryContent(View v) {
        if (this.mSecondaryContent != null) {
            removeView(this.mSecondaryContent);
        }
        this.mSecondaryContent = v;
        addView(this.mSecondaryContent);
    }

    public View getSecondaryContent() {
        return this.mSecondaryContent;
    }

    public void setChildrenEnabled(boolean enabled) {
        this.mChildrenEnabled = enabled;
    }

    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        if (this.mTransformer != null) {
            invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        return !this.mChildrenEnabled;
    }

    public boolean onTouchEvent(MotionEvent e) {
        return !this.mChildrenEnabled;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.mTransformer != null) {
            canvas.save();
            this.mTransformer.transformCanvas(canvas, this.mViewAbove.getPercentOpen());
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = r - l;
        int height = b - t;
        this.mContent.layout(0, 0, width - this.mWidthOffset, height);
        if (this.mSecondaryContent != null) {
            this.mSecondaryContent.layout(0, 0, width - this.mWidthOffset, height);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
        int contentWidth = getChildMeasureSpec(widthMeasureSpec, 0, width - this.mWidthOffset);
        int contentHeight = getChildMeasureSpec(heightMeasureSpec, 0, height);
        this.mContent.measure(contentWidth, contentHeight);
        if (this.mSecondaryContent != null) {
            this.mSecondaryContent.measure(contentWidth, contentHeight);
        }
    }

    public void setMode(int mode) {
        if (mode == 0 || mode == 1) {
            if (this.mContent != null) {
                this.mContent.setVisibility(0);
            }
            if (this.mSecondaryContent != null) {
                this.mSecondaryContent.setVisibility(4);
            }
        }
        this.mMode = mode;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setScrollScale(float scrollScale) {
        this.mScrollScale = scrollScale;
    }

    public float getScrollScale() {
        return this.mScrollScale;
    }

    public void setShadowDrawable(Drawable shadow) {
        this.mShadowDrawable = shadow;
        invalidate();
    }

    public void setSecondaryShadowDrawable(Drawable shadow) {
        this.mSecondaryShadowDrawable = shadow;
        invalidate();
    }

    public void setShadowWidth(int width) {
        this.mShadowWidth = width;
        invalidate();
    }

    public void setFadeEnabled(boolean b) {
        this.mFadeEnabled = b;
    }

    public void setFadeDegree(float degree) {
        if (degree > 1.0f || degree < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        }
        this.mFadeDegree = degree;
    }

    public int getMenuPage(int page) {
        if (page > 1) {
            page = 2;
        } else if (page < 1) {
            page = 0;
        }
        if (this.mMode == 0 && page > 1) {
            return 0;
        }
        if (this.mMode != 1 || page >= 1) {
            return page;
        }
        return 2;
    }

    public void scrollBehindTo(View content, int x, int y) {
        int i;
        int i2;
        int vis = 0;
        if (this.mMode == 0) {
            if (x >= content.getLeft()) {
                vis = 4;
            }
            scrollTo((int) (((float) (getBehindWidth() + x)) * this.mScrollScale), y);
        } else if (this.mMode == 1) {
            if (x <= content.getLeft()) {
                vis = 4;
            }
            scrollTo((int) (((float) (getBehindWidth() - getWidth())) + (((float) (x - getBehindWidth())) * this.mScrollScale)), y);
        } else if (this.mMode == 2) {
            View view = this.mContent;
            if (x >= content.getLeft()) {
                i = 4;
            } else {
                i = 0;
            }
            view.setVisibility(i);
            View view2 = this.mSecondaryContent;
            if (x <= content.getLeft()) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            view2.setVisibility(i2);
            if (x == 0) {
                vis = 4;
            } else {
                vis = 0;
            }
            if (x <= content.getLeft()) {
                scrollTo((int) (((float) (getBehindWidth() + x)) * this.mScrollScale), y);
            } else {
                scrollTo((int) (((float) (getBehindWidth() - getWidth())) + (((float) (x - getBehindWidth())) * this.mScrollScale)), y);
            }
        }
        if (vis == 4) {
            Log.v(TAG, "behind INVISIBLE");
        }
        setVisibility(vis);
    }

    public int getMenuLeft(View content, int page) {
        if (this.mMode == 0) {
            switch (page) {
                case 0:
                    return content.getLeft() - getBehindWidth();
                case 2:
                    return content.getLeft();
            }
        } else if (this.mMode == 1) {
            switch (page) {
                case 0:
                    return content.getLeft();
                case 2:
                    return content.getLeft() + getBehindWidth();
            }
        } else if (this.mMode == 2) {
            switch (page) {
                case 0:
                    return content.getLeft() - getBehindWidth();
                case 2:
                    return content.getLeft() + getBehindWidth();
            }
        }
        return content.getLeft();
    }

    public int getAbsLeftBound(View content) {
        if (this.mMode == 0 || this.mMode == 2) {
            return content.getLeft() - getBehindWidth();
        }
        if (this.mMode == 1) {
            return content.getLeft();
        }
        return 0;
    }

    public int getAbsRightBound(View content) {
        if (this.mMode == 0) {
            return content.getLeft();
        }
        if (this.mMode == 1 || this.mMode == 2) {
            return content.getLeft() + getBehindWidth();
        }
        return 0;
    }

    public boolean marginTouchAllowed(View content, int x) {
        int left = content.getLeft();
        int right = content.getRight();
        if (this.mMode == 0) {
            if (x < left || x > this.mMarginThreshold + left) {
                return false;
            }
            return true;
        } else if (this.mMode == 1) {
            if (x > right || x < right - this.mMarginThreshold) {
                return false;
            }
            return true;
        } else if (this.mMode != 2) {
            return false;
        } else {
            if (x >= left && x <= this.mMarginThreshold + left) {
                return true;
            }
            if (x > right || x < right - this.mMarginThreshold) {
                return false;
            }
            return true;
        }
    }

    public void setTouchMode(int i) {
        this.mTouchMode = i;
    }

    public boolean menuOpenTouchAllowed(View content, int currPage, float x) {
        switch (this.mTouchMode) {
            case 0:
                return menuTouchInQuickReturn(content, currPage, x);
            case 1:
                return true;
            default:
                return false;
        }
    }

    public boolean menuTouchInQuickReturn(View content, int currPage, float x) {
        if (this.mMode == 0 || (this.mMode == 2 && currPage == 0)) {
            if (x >= ((float) content.getLeft())) {
                return true;
            }
            return false;
        } else if ((this.mMode == 1 || (this.mMode == 2 && currPage == 2)) && x <= ((float) content.getRight())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean menuClosedSlideAllowed(float dx) {
        if (this.mMode == 0) {
            if (dx > BitmapDescriptorFactory.HUE_RED) {
                return true;
            }
            return false;
        } else if (this.mMode == 1) {
            if (dx >= BitmapDescriptorFactory.HUE_RED) {
                return false;
            }
            return true;
        } else if (this.mMode != 2) {
            return false;
        } else {
            return true;
        }
    }

    public boolean menuOpenSlideAllowed(float dx) {
        if (this.mMode == 0) {
            if (dx < BitmapDescriptorFactory.HUE_RED) {
                return true;
            }
            return false;
        } else if (this.mMode == 1) {
            if (dx <= BitmapDescriptorFactory.HUE_RED) {
                return false;
            }
            return true;
        } else if (this.mMode != 2) {
            return false;
        } else {
            return true;
        }
    }

    public void drawShadow(View content, Canvas canvas) {
        if (this.mShadowDrawable != null && this.mShadowWidth > 0) {
            int left = 0;
            if (this.mMode == 0) {
                left = content.getLeft() - this.mShadowWidth;
            } else if (this.mMode == 1) {
                left = content.getRight();
            } else if (this.mMode == 2) {
                if (this.mSecondaryShadowDrawable != null) {
                    int left2 = content.getRight();
                    this.mSecondaryShadowDrawable.setBounds(left2, 0, this.mShadowWidth + left2, getHeight());
                    this.mSecondaryShadowDrawable.draw(canvas);
                }
                left = content.getLeft() - this.mShadowWidth;
            }
            this.mShadowDrawable.setBounds(left, 0, this.mShadowWidth + left, getHeight());
            this.mShadowDrawable.draw(canvas);
        }
    }

    public void drawFade(View content, Canvas canvas, float openPercent) {
        if (this.mFadeEnabled) {
            this.mFadePaint.setColor(Color.argb((int) (this.mFadeDegree * 255.0f * Math.abs(1.0f - openPercent)), 0, 0, 0));
            int left = 0;
            int right = 0;
            if (this.mMode == 0) {
                left = content.getLeft() - getBehindWidth();
                right = content.getLeft();
            } else if (this.mMode == 1) {
                left = content.getRight();
                right = content.getRight() + getBehindWidth();
            } else if (this.mMode == 2) {
                canvas.drawRect((float) (content.getLeft() - getBehindWidth()), BitmapDescriptorFactory.HUE_RED, (float) content.getLeft(), (float) getHeight(), this.mFadePaint);
                left = content.getRight();
                right = content.getRight() + getBehindWidth();
            }
            canvas.drawRect((float) left, BitmapDescriptorFactory.HUE_RED, (float) right, (float) getHeight(), this.mFadePaint);
        }
    }

    public void drawSelector(View content, Canvas canvas, float openPercent) {
        if (this.mSelectorEnabled && this.mSelectorDrawable != null && this.mSelectedView != null && ((String) this.mSelectedView.getTag(C1038R.C1039id.selected_view)).equals("CustomViewBehindSelectedView")) {
            canvas.save();
            int offset = (int) (((float) this.mSelectorDrawable.getWidth()) * openPercent);
            if (this.mMode == 0) {
                int right = content.getLeft();
                int left = right - offset;
                canvas.clipRect(left, 0, right, getHeight());
                canvas.drawBitmap(this.mSelectorDrawable, (float) left, (float) getSelectorTop(), (Paint) null);
            } else if (this.mMode == 1) {
                int left2 = content.getRight();
                int right2 = left2 + offset;
                canvas.clipRect(left2, 0, right2, getHeight());
                canvas.drawBitmap(this.mSelectorDrawable, (float) (right2 - this.mSelectorDrawable.getWidth()), (float) getSelectorTop(), (Paint) null);
            }
            canvas.restore();
        }
    }

    public void setSelectorEnabled(boolean b) {
        this.mSelectorEnabled = b;
    }

    public void setSelectedView(View v) {
        if (this.mSelectedView != null) {
            this.mSelectedView.setTag(C1038R.C1039id.selected_view, (Object) null);
            this.mSelectedView = null;
        }
        if (v != null && v.getParent() != null) {
            this.mSelectedView = v;
            this.mSelectedView.setTag(C1038R.C1039id.selected_view, "CustomViewBehindSelectedView");
            invalidate();
        }
    }

    private int getSelectorTop() {
        return this.mSelectedView.getTop() + ((this.mSelectedView.getHeight() - this.mSelectorDrawable.getHeight()) / 2);
    }

    public void setSelectorBitmap(Bitmap b) {
        this.mSelectorDrawable = b;
        refreshDrawableState();
    }
}
