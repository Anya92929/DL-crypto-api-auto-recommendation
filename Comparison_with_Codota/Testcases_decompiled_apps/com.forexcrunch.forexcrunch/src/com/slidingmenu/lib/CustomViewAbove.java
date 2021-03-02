package com.slidingmenu.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.p000v4.view.KeyEventCompat;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.VelocityTrackerCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.List;

public class CustomViewAbove extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final String TAG = "CustomViewAbove";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float t) {
            float t2 = t - 1.0f;
            return (t2 * t2 * t2 * t2 * t2) + 1.0f;
        }
    };
    protected int mActivePointerId;
    private SlidingMenu.OnClosedListener mClosedListener;
    private View mContent;
    private int mCurItem;
    private boolean mEnabled;
    private int mFlingDistance;
    private List<View> mIgnoredViews;
    private float mInitialMotionX;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private float mLastMotionX;
    private float mLastMotionY;
    protected int mMaximumVelocity;
    private int mMinimumVelocity;
    private OnPageChangeListener mOnPageChangeListener;
    private SlidingMenu.OnOpenedListener mOpenedListener;
    private boolean mQuickReturn;
    private float mScrollX;
    private Scroller mScroller;
    private boolean mScrolling;
    private boolean mScrollingCacheEnabled;
    protected int mTouchMode;
    private int mTouchSlop;
    protected VelocityTracker mVelocityTracker;
    /* access modifiers changed from: private */
    public CustomViewBehind mViewBehind;

    public interface OnPageChangeListener {
        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        public void onPageSelected(int position) {
        }

        public void onPageScrollStateChanged(int state) {
        }
    }

    public CustomViewAbove(Context context) {
        this(context, (AttributeSet) null);
    }

    public CustomViewAbove(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mActivePointerId = -1;
        this.mEnabled = true;
        this.mIgnoredViews = new ArrayList();
        this.mTouchMode = 0;
        this.mQuickReturn = DEBUG;
        this.mScrollX = BitmapDescriptorFactory.HUE_RED;
        initCustomViewAbove();
    }

    /* access modifiers changed from: package-private */
    public void initCustomViewAbove() {
        setWillNotDraw(DEBUG);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
        this.mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        setInternalPageChangeListener(new SimpleOnPageChangeListener() {
            public void onPageSelected(int position) {
                if (CustomViewAbove.this.mViewBehind != null) {
                    switch (position) {
                        case 0:
                        case 2:
                            CustomViewAbove.this.mViewBehind.setChildrenEnabled(true);
                            return;
                        case 1:
                            CustomViewAbove.this.mViewBehind.setChildrenEnabled(CustomViewAbove.DEBUG);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        this.mFlingDistance = (int) (25.0f * context.getResources().getDisplayMetrics().density);
    }

    public void setCurrentItem(int item) {
        setCurrentItemInternal(item, true, DEBUG);
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        setCurrentItemInternal(item, smoothScroll, DEBUG);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int item, boolean smoothScroll, boolean always) {
        setCurrentItemInternal(item, smoothScroll, always, 0);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
        boolean dispatchSelected;
        if (always || this.mCurItem != item) {
            int item2 = this.mViewBehind.getMenuPage(item);
            if (this.mCurItem != item2) {
                dispatchSelected = true;
            } else {
                dispatchSelected = false;
            }
            this.mCurItem = item2;
            int destX = getDestScrollX(this.mCurItem);
            if (dispatchSelected && this.mOnPageChangeListener != null) {
                this.mOnPageChangeListener.onPageSelected(item2);
            }
            if (dispatchSelected && this.mInternalPageChangeListener != null) {
                this.mInternalPageChangeListener.onPageSelected(item2);
            }
            if (smoothScroll) {
                smoothScrollTo(destX, 0, velocity);
                return;
            }
            completeScroll();
            scrollTo(destX, 0);
            return;
        }
        setScrollingCacheEnabled(DEBUG);
    }

    public void setOnPageChangeListener(OnPageChangeListener listener) {
        this.mOnPageChangeListener = listener;
    }

    public void setOnOpenedListener(SlidingMenu.OnOpenedListener l) {
        this.mOpenedListener = l;
    }

    public void setOnClosedListener(SlidingMenu.OnClosedListener l) {
        this.mClosedListener = l;
    }

    /* access modifiers changed from: package-private */
    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener listener) {
        OnPageChangeListener oldListener = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = listener;
        return oldListener;
    }

    public void addIgnoredView(View v) {
        if (!this.mIgnoredViews.contains(v)) {
            this.mIgnoredViews.add(v);
        }
    }

    public void removeIgnoredView(View v) {
        this.mIgnoredViews.remove(v);
    }

    public void clearIgnoredViews() {
        this.mIgnoredViews.clear();
    }

    /* access modifiers changed from: package-private */
    public float distanceInfluenceForSnapDuration(float f) {
        return FloatMath.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    public int getDestScrollX(int page) {
        switch (page) {
            case 0:
            case 2:
                return this.mViewBehind.getMenuLeft(this.mContent, page);
            case 1:
                return this.mContent.getLeft();
            default:
                return 0;
        }
    }

    private int getLeftBound() {
        return this.mViewBehind.getAbsLeftBound(this.mContent);
    }

    private int getRightBound() {
        return this.mViewBehind.getAbsRightBound(this.mContent);
    }

    public int getContentLeft() {
        return this.mContent.getLeft() + this.mContent.getPaddingLeft();
    }

    public boolean isMenuOpen() {
        if (this.mCurItem == 0 || this.mCurItem == 2) {
            return true;
        }
        return DEBUG;
    }

    private boolean isInIgnoredView(MotionEvent ev) {
        Rect rect = new Rect();
        for (View v : this.mIgnoredViews) {
            v.getHitRect(rect);
            if (rect.contains((int) ev.getX(), (int) ev.getY())) {
                return true;
            }
        }
        return DEBUG;
    }

    public int getBehindWidth() {
        if (this.mViewBehind == null) {
            return 0;
        }
        return this.mViewBehind.getBehindWidth();
    }

    public int getChildWidth(int i) {
        switch (i) {
            case 0:
                return getBehindWidth();
            case 1:
                return this.mContent.getWidth();
            default:
                return 0;
        }
    }

    public boolean isSlidingEnabled() {
        return this.mEnabled;
    }

    public void setSlidingEnabled(boolean b) {
        this.mEnabled = b;
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int x, int y) {
        smoothScrollTo(x, y, 0);
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int x, int y, int velocity) {
        int duration;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(DEBUG);
            return;
        }
        int sx = getScrollX();
        int sy = getScrollY();
        int dx = x - sx;
        int dy = y - sy;
        if (dx == 0 && dy == 0) {
            completeScroll();
            if (isMenuOpen()) {
                if (this.mOpenedListener != null) {
                    this.mOpenedListener.onOpened();
                }
            } else if (this.mClosedListener != null) {
                this.mClosedListener.onClosed();
            }
        } else {
            setScrollingCacheEnabled(true);
            this.mScrolling = true;
            int width = getBehindWidth();
            int halfWidth = width / 2;
            float distance = ((float) halfWidth) + (((float) halfWidth) * distanceInfluenceForSnapDuration(Math.min(1.0f, (1.0f * ((float) Math.abs(dx))) / ((float) width))));
            int velocity2 = Math.abs(velocity);
            if (velocity2 > 0) {
                duration = Math.round(1000.0f * Math.abs(distance / ((float) velocity2))) * 4;
            } else {
                int duration2 = (int) ((1.0f + (((float) Math.abs(dx)) / ((float) width))) * 100.0f);
                duration = MAX_SETTLE_DURATION;
            }
            this.mScroller.startScroll(sx, sy, dx, dy, Math.min(duration, MAX_SETTLE_DURATION));
            invalidate();
        }
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

    public void setCustomViewBehind(CustomViewBehind cvb) {
        this.mViewBehind = cvb;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
        this.mContent.measure(getChildMeasureSpec(widthMeasureSpec, 0, width), getChildMeasureSpec(heightMeasureSpec, 0, height));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw) {
            completeScroll();
            scrollTo(getDestScrollX(this.mCurItem), getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        this.mContent.layout(0, 0, r - l, b - t);
    }

    public void setAboveOffset(int i) {
        this.mContent.setPadding(i, this.mContent.getPaddingTop(), this.mContent.getPaddingRight(), this.mContent.getPaddingBottom());
    }

    public void computeScroll() {
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll();
            return;
        }
        int oldX = getScrollX();
        int oldY = getScrollY();
        int x = this.mScroller.getCurrX();
        int y = this.mScroller.getCurrY();
        if (!(oldX == x && oldY == y)) {
            scrollTo(x, y);
            pageScrolled(x);
        }
        invalidate();
    }

    private void pageScrolled(int xpos) {
        int widthWithMargin = getWidth();
        int offsetPixels = xpos % widthWithMargin;
        onPageScrolled(xpos / widthWithMargin, ((float) offsetPixels) / ((float) widthWithMargin), offsetPixels);
    }

    /* access modifiers changed from: protected */
    public void onPageScrolled(int position, float offset, int offsetPixels) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        }
    }

    private void completeScroll() {
        if (this.mScrolling) {
            setScrollingCacheEnabled(DEBUG);
            this.mScroller.abortAnimation();
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = this.mScroller.getCurrX();
            int y = this.mScroller.getCurrY();
            if (!(oldX == x && oldY == y)) {
                scrollTo(x, y);
            }
            if (isMenuOpen()) {
                if (this.mOpenedListener != null) {
                    this.mOpenedListener.onOpened();
                }
            } else if (this.mClosedListener != null) {
                this.mClosedListener.onClosed();
            }
        }
        this.mScrolling = DEBUG;
    }

    public void setTouchMode(int i) {
        this.mTouchMode = i;
    }

    public int getTouchMode() {
        return this.mTouchMode;
    }

    private boolean thisTouchAllowed(MotionEvent ev) {
        int x = (int) (ev.getX() + this.mScrollX);
        if (isMenuOpen()) {
            return this.mViewBehind.menuOpenTouchAllowed(this.mContent, this.mCurItem, (float) x);
        }
        switch (this.mTouchMode) {
            case 0:
                return this.mViewBehind.marginTouchAllowed(this.mContent, x);
            case 1:
                if (!isInIgnoredView(ev)) {
                    return true;
                }
                return DEBUG;
            default:
                return DEBUG;
        }
    }

    private boolean thisSlideAllowed(float dx) {
        if (isMenuOpen()) {
            return this.mViewBehind.menuOpenSlideAllowed(dx);
        }
        return this.mViewBehind.menuClosedSlideAllowed(dx);
    }

    private int getPointerIndex(MotionEvent ev, int id) {
        int activePointerIndex = MotionEventCompat.findPointerIndex(ev, id);
        if (activePointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return activePointerIndex;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (!this.mEnabled) {
            return DEBUG;
        }
        int action = ev.getAction() & MotionEventCompat.ACTION_MASK;
        if (action == 3 || action == 1 || (action != 0 && this.mIsUnableToDrag)) {
            endDrag();
            return DEBUG;
        }
        switch (action) {
            case 0:
                int index = MotionEventCompat.getActionIndex(ev);
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                if (this.mActivePointerId != -1) {
                    float x = MotionEventCompat.getX(ev, index);
                    this.mInitialMotionX = x;
                    this.mLastMotionX = x;
                    this.mLastMotionY = MotionEventCompat.getY(ev, index);
                    if (!thisTouchAllowed(ev)) {
                        this.mIsUnableToDrag = true;
                        break;
                    } else {
                        this.mIsBeingDragged = DEBUG;
                        this.mIsUnableToDrag = DEBUG;
                        if (isMenuOpen() && this.mViewBehind.menuTouchInQuickReturn(this.mContent, this.mCurItem, ev.getX() + this.mScrollX)) {
                            this.mQuickReturn = true;
                            break;
                        }
                    }
                }
                break;
            case 2:
                determineDrag(ev);
                break;
            case 6:
                onSecondaryPointerUp(ev);
                break;
        }
        if (!this.mIsBeingDragged) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(ev);
        }
        if (this.mIsBeingDragged || this.mQuickReturn) {
            return true;
        }
        return DEBUG;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (!this.mEnabled) {
            return DEBUG;
        }
        if (!this.mIsBeingDragged && !thisTouchAllowed(ev)) {
            return DEBUG;
        }
        int action = ev.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
        switch (action & MotionEventCompat.ACTION_MASK) {
            case 0:
                completeScroll();
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, MotionEventCompat.getActionIndex(ev));
                float x = ev.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                break;
            case 1:
                if (!this.mIsBeingDragged) {
                    if (this.mQuickReturn && this.mViewBehind.menuTouchInQuickReturn(this.mContent, this.mCurItem, ev.getX() + this.mScrollX)) {
                        setCurrentItem(1);
                        endDrag();
                        break;
                    }
                } else {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                    int initialVelocity = (int) VelocityTrackerCompat.getXVelocity(velocityTracker, this.mActivePointerId);
                    float pageOffset = ((float) (getScrollX() - getDestScrollX(this.mCurItem))) / ((float) getBehindWidth());
                    int activePointerIndex = getPointerIndex(ev, this.mActivePointerId);
                    if (this.mActivePointerId != -1) {
                        setCurrentItemInternal(determineTargetPage(pageOffset, initialVelocity, (int) (MotionEventCompat.getX(ev, activePointerIndex) - this.mInitialMotionX)), true, true, initialVelocity);
                    } else {
                        setCurrentItemInternal(this.mCurItem, true, true, initialVelocity);
                    }
                    this.mActivePointerId = -1;
                    endDrag();
                    break;
                }
            case 2:
                if (!this.mIsBeingDragged) {
                    determineDrag(ev);
                    if (this.mIsUnableToDrag) {
                        return DEBUG;
                    }
                }
                if (this.mIsBeingDragged) {
                    int activePointerIndex2 = getPointerIndex(ev, this.mActivePointerId);
                    if (this.mActivePointerId != -1) {
                        float x2 = MotionEventCompat.getX(ev, activePointerIndex2);
                        float deltaX = this.mLastMotionX - x2;
                        this.mLastMotionX = x2;
                        float scrollX = ((float) getScrollX()) + deltaX;
                        float leftBound = (float) getLeftBound();
                        float rightBound = (float) getRightBound();
                        if (scrollX < leftBound) {
                            scrollX = leftBound;
                        } else if (scrollX > rightBound) {
                            scrollX = rightBound;
                        }
                        this.mLastMotionX += scrollX - ((float) ((int) scrollX));
                        scrollTo((int) scrollX, getScrollY());
                        pageScrolled((int) scrollX);
                        break;
                    }
                }
                break;
            case 3:
                if (this.mIsBeingDragged) {
                    setCurrentItemInternal(this.mCurItem, true, true);
                    this.mActivePointerId = -1;
                    endDrag();
                    break;
                }
                break;
            case 5:
                int indexx = MotionEventCompat.getActionIndex(ev);
                this.mLastMotionX = MotionEventCompat.getX(ev, indexx);
                this.mActivePointerId = MotionEventCompat.getPointerId(ev, indexx);
                break;
            case 6:
                onSecondaryPointerUp(ev);
                int pointerIndex = getPointerIndex(ev, this.mActivePointerId);
                if (this.mActivePointerId != -1) {
                    this.mLastMotionX = MotionEventCompat.getX(ev, pointerIndex);
                    break;
                }
                break;
        }
        return true;
    }

    private void determineDrag(MotionEvent ev) {
        int activePointerId = this.mActivePointerId;
        int pointerIndex = getPointerIndex(ev, activePointerId);
        if (activePointerId != -1) {
            float x = MotionEventCompat.getX(ev, pointerIndex);
            float dx = x - this.mLastMotionX;
            float xDiff = Math.abs(dx);
            float y = MotionEventCompat.getY(ev, pointerIndex);
            float yDiff = Math.abs(y - this.mLastMotionY);
            if (xDiff > ((float) (isMenuOpen() ? this.mTouchSlop / 2 : this.mTouchSlop)) && xDiff > yDiff && thisSlideAllowed(dx)) {
                startDrag();
                this.mLastMotionX = x;
                this.mLastMotionY = y;
                setScrollingCacheEnabled(true);
            } else if (xDiff > ((float) this.mTouchSlop)) {
                this.mIsUnableToDrag = true;
            }
        }
    }

    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        this.mScrollX = (float) x;
        this.mViewBehind.scrollBehindTo(this.mContent, x, y);
        ((SlidingMenu) getParent()).manageLayers(getPercentOpen());
    }

    private int determineTargetPage(float pageOffset, int velocity, int deltaX) {
        int targetPage = this.mCurItem;
        if (Math.abs(deltaX) <= this.mFlingDistance || Math.abs(velocity) <= this.mMinimumVelocity) {
            return Math.round(((float) this.mCurItem) + pageOffset);
        }
        if (velocity > 0 && deltaX > 0) {
            return targetPage - 1;
        }
        if (velocity >= 0 || deltaX >= 0) {
            return targetPage;
        }
        return targetPage + 1;
    }

    /* access modifiers changed from: protected */
    public float getPercentOpen() {
        return Math.abs(this.mScrollX - ((float) this.mContent.getLeft())) / ((float) getBehindWidth());
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mViewBehind.drawShadow(this.mContent, canvas);
        this.mViewBehind.drawFade(this.mContent, canvas, getPercentOpen());
        this.mViewBehind.drawSelector(this.mContent, canvas, getPercentOpen());
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        int pointerIndex = MotionEventCompat.getActionIndex(ev);
        if (MotionEventCompat.getPointerId(ev, pointerIndex) == this.mActivePointerId) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.mLastMotionX = MotionEventCompat.getX(ev, newPointerIndex);
            this.mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void startDrag() {
        this.mIsBeingDragged = true;
        this.mQuickReturn = DEBUG;
    }

    private void endDrag() {
        this.mQuickReturn = DEBUG;
        this.mIsBeingDragged = DEBUG;
        this.mIsUnableToDrag = DEBUG;
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean enabled) {
        if (this.mScrollingCacheEnabled != enabled) {
            this.mScrollingCacheEnabled = enabled;
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) v;
            int scrollX = v.getScrollX();
            int scrollY = v.getScrollY();
            for (int i = group.getChildCount() - 1; i >= 0; i--) {
                View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() && y + scrollY >= child.getTop() && y + scrollY < child.getBottom()) {
                    if (canScroll(child, true, dx, (x + scrollX) - child.getLeft(), (y + scrollY) - child.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!checkV || !ViewCompat.canScrollHorizontally(v, -dx)) {
            return DEBUG;
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (super.dispatchKeyEvent(event) || executeKeyEvent(event)) {
            return true;
        }
        return DEBUG;
    }

    public boolean executeKeyEvent(KeyEvent event) {
        if (event.getAction() != 0) {
            return DEBUG;
        }
        switch (event.getKeyCode()) {
            case 21:
                return arrowScroll(17);
            case 22:
                return arrowScroll(66);
            case 61:
                if (Build.VERSION.SDK_INT < 11) {
                    return DEBUG;
                }
                if (KeyEventCompat.hasNoModifiers(event)) {
                    return arrowScroll(2);
                }
                if (KeyEventCompat.hasModifiers(event, 1)) {
                    return arrowScroll(1);
                }
                return DEBUG;
            default:
                return DEBUG;
        }
    }

    public boolean arrowScroll(int direction) {
        View currentFocused = findFocus();
        if (currentFocused == this) {
            currentFocused = null;
        }
        boolean handled = DEBUG;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        if (nextFocused == null || nextFocused == currentFocused) {
            if (direction == 17 || direction == 1) {
                handled = pageLeft();
            } else if (direction == 66 || direction == 2) {
                handled = pageRight();
            }
        } else if (direction == 17) {
            handled = nextFocused.requestFocus();
        } else if (direction == 66) {
            handled = (currentFocused == null || nextFocused.getLeft() > currentFocused.getLeft()) ? nextFocused.requestFocus() : pageRight();
        }
        if (handled) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
        }
        return handled;
    }

    /* access modifiers changed from: package-private */
    public boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pageRight() {
        if (this.mCurItem >= 1) {
            return DEBUG;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }
}
