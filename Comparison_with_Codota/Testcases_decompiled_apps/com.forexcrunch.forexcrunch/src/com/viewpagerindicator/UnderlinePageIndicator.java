package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewConfigurationCompat;
import android.support.p000v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class UnderlinePageIndicator extends View implements PageIndicator {
    private static final int FADE_FRAME_MS = 30;
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private int mCurrentPage;
    /* access modifiers changed from: private */
    public int mFadeBy;
    private int mFadeDelay;
    private int mFadeLength;
    /* access modifiers changed from: private */
    public final Runnable mFadeRunnable;
    /* access modifiers changed from: private */
    public boolean mFades;
    private boolean mIsDragging;
    private float mLastMotionX;
    private ViewPager.OnPageChangeListener mListener;
    /* access modifiers changed from: private */
    public final Paint mPaint;
    private float mPositionOffset;
    private int mScrollState;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public UnderlinePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, C1053R.attr.vpiUnderlinePageIndicatorStyle);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mPaint = new Paint(1);
        this.mLastMotionX = -1.0f;
        this.mActivePointerId = -1;
        this.mFadeRunnable = new Runnable() {
            public void run() {
                if (UnderlinePageIndicator.this.mFades) {
                    int alpha = Math.max(UnderlinePageIndicator.this.mPaint.getAlpha() - UnderlinePageIndicator.this.mFadeBy, 0);
                    UnderlinePageIndicator.this.mPaint.setAlpha(alpha);
                    UnderlinePageIndicator.this.invalidate();
                    if (alpha > 0) {
                        UnderlinePageIndicator.this.postDelayed(this, 30);
                    }
                }
            }
        };
        if (!isInEditMode()) {
            Resources res = getResources();
            boolean defaultFades = res.getBoolean(C1053R.bool.default_underline_indicator_fades);
            int defaultFadeDelay = res.getInteger(C1053R.integer.default_underline_indicator_fade_delay);
            int defaultFadeLength = res.getInteger(C1053R.integer.default_underline_indicator_fade_length);
            int defaultSelectedColor = res.getColor(C1053R.color.default_underline_indicator_selected_color);
            TypedArray a = context.obtainStyledAttributes(attrs, C1053R.styleable.UnderlinePageIndicator, defStyle, 0);
            setFades(a.getBoolean(2, defaultFades));
            setSelectedColor(a.getColor(1, defaultSelectedColor));
            setFadeDelay(a.getInteger(3, defaultFadeDelay));
            setFadeLength(a.getInteger(4, defaultFadeLength));
            Drawable background = a.getDrawable(0);
            if (background != null) {
                setBackgroundDrawable(background);
            }
            a.recycle();
            this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public boolean getFades() {
        return this.mFades;
    }

    public void setFades(boolean fades) {
        if (fades != this.mFades) {
            this.mFades = fades;
            if (fades) {
                post(this.mFadeRunnable);
                return;
            }
            removeCallbacks(this.mFadeRunnable);
            this.mPaint.setAlpha(MotionEventCompat.ACTION_MASK);
            invalidate();
        }
    }

    public int getFadeDelay() {
        return this.mFadeDelay;
    }

    public void setFadeDelay(int fadeDelay) {
        this.mFadeDelay = fadeDelay;
    }

    public int getFadeLength() {
        return this.mFadeLength;
    }

    public void setFadeLength(int fadeLength) {
        this.mFadeLength = fadeLength;
        this.mFadeBy = MotionEventCompat.ACTION_MASK / (this.mFadeLength / 30);
    }

    public int getSelectedColor() {
        return this.mPaint.getColor();
    }

    public void setSelectedColor(int selectedColor) {
        this.mPaint.setColor(selectedColor);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int count;
        super.onDraw(canvas);
        if (this.mViewPager != null && (count = this.mViewPager.getAdapter().getCount()) != 0) {
            if (this.mCurrentPage >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int paddingLeft = getPaddingLeft();
            float pageWidth = ((float) ((getWidth() - paddingLeft) - getPaddingRight())) / (1.0f * ((float) count));
            float left = ((float) paddingLeft) + ((((float) this.mCurrentPage) + this.mPositionOffset) * pageWidth);
            Canvas canvas2 = canvas;
            canvas2.drawRect(left, (float) getPaddingTop(), left + pageWidth, (float) (getHeight() - getPaddingBottom()), this.mPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (super.onTouchEvent(ev)) {
            return true;
        }
        if (this.mViewPager == null || this.mViewPager.getAdapter().getCount() == 0) {
            return false;
        }
        int action = ev.getAction() & MotionEventCompat.ACTION_MASK;
        switch (action) {
            case 0:
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                this.mLastMotionX = ev.getX();
                break;
            case 1:
            case 3:
                if (!this.mIsDragging) {
                    int count = this.mViewPager.getAdapter().getCount();
                    int width = getWidth();
                    float halfWidth = ((float) width) / 2.0f;
                    float sixthWidth = ((float) width) / 6.0f;
                    if (this.mCurrentPage > 0 && ev.getX() < halfWidth - sixthWidth) {
                        if (action != 3) {
                            this.mViewPager.setCurrentItem(this.mCurrentPage - 1);
                        }
                        return true;
                    } else if (this.mCurrentPage < count - 1 && ev.getX() > halfWidth + sixthWidth) {
                        if (action != 3) {
                            this.mViewPager.setCurrentItem(this.mCurrentPage + 1);
                        }
                        return true;
                    }
                }
                this.mIsDragging = false;
                this.mActivePointerId = -1;
                if (this.mViewPager.isFakeDragging()) {
                    this.mViewPager.endFakeDrag();
                    break;
                }
                break;
            case 2:
                float x = MotionEventCompat.getX(ev, MotionEventCompat.findPointerIndex(ev, this.mActivePointerId));
                float deltaX = x - this.mLastMotionX;
                if (!this.mIsDragging && Math.abs(deltaX) > ((float) this.mTouchSlop)) {
                    this.mIsDragging = true;
                }
                if (this.mIsDragging) {
                    this.mLastMotionX = x;
                    if (this.mViewPager.isFakeDragging() || this.mViewPager.beginFakeDrag()) {
                        this.mViewPager.fakeDragBy(deltaX);
                        break;
                    }
                }
                break;
            case 5:
                int index = MotionEventCompat.getActionIndex(ev);
                this.mLastMotionX = MotionEventCompat.getX(ev, index);
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                break;
            case 6:
                int pointerIndex = MotionEventCompat.getActionIndex(ev);
                if (MotionEventCompat.getPointerId(ev, pointerIndex) == this.mActivePointerId) {
                    this.mActivePointerId = MotionEventCompat.getPointerId(ev, pointerIndex == 0 ? 1 : 0);
                }
                this.mLastMotionX = MotionEventCompat.getX(ev, MotionEventCompat.findPointerIndex(ev, this.mActivePointerId));
                break;
        }
        return true;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.mViewPager != viewPager) {
            if (this.mViewPager != null) {
                this.mViewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.mViewPager = viewPager;
            this.mViewPager.setOnPageChangeListener(this);
            invalidate();
            post(new Runnable() {
                public void run() {
                    if (UnderlinePageIndicator.this.mFades) {
                        UnderlinePageIndicator.this.post(UnderlinePageIndicator.this.mFadeRunnable);
                    }
                }
            });
        }
    }

    public void setViewPager(ViewPager view, int initialPosition) {
        setViewPager(view);
        setCurrentItem(initialPosition);
    }

    public void setCurrentItem(int item) {
        if (this.mViewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.mViewPager.setCurrentItem(item);
        this.mCurrentPage = item;
        invalidate();
    }

    public void notifyDataSetChanged() {
        invalidate();
    }

    public void onPageScrollStateChanged(int state) {
        this.mScrollState = state;
        if (this.mListener != null) {
            this.mListener.onPageScrollStateChanged(state);
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.mCurrentPage = position;
        this.mPositionOffset = positionOffset;
        if (this.mFades) {
            if (positionOffsetPixels > 0) {
                removeCallbacks(this.mFadeRunnable);
                this.mPaint.setAlpha(MotionEventCompat.ACTION_MASK);
            } else if (this.mScrollState != 1) {
                postDelayed(this.mFadeRunnable, (long) this.mFadeDelay);
            }
        }
        invalidate();
        if (this.mListener != null) {
            this.mListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    public void onPageSelected(int position) {
        if (this.mScrollState == 0) {
            this.mCurrentPage = position;
            this.mPositionOffset = BitmapDescriptorFactory.HUE_RED;
            invalidate();
            this.mFadeRunnable.run();
        }
        if (this.mListener != null) {
            this.mListener.onPageSelected(position);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.mListener = listener;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentPage = savedState.currentPage;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPage = this.mCurrentPage;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, (SavedState) null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int currentPage;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
        }

        private SavedState(Parcel in) {
            super(in);
            this.currentPage = in.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPage);
        }
    }
}
