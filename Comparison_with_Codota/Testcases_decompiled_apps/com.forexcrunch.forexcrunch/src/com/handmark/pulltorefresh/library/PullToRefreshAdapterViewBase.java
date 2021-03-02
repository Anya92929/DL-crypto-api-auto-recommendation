package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.IndicatorLayout;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements AbsListView.OnScrollListener {

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    private static /* synthetic */ int[] f1748x57a4d715;
    private View mEmptyView;
    private IndicatorLayout mIndicatorIvBottom;
    private IndicatorLayout mIndicatorIvTop;
    private boolean mLastItemVisible;
    private PullToRefreshBase.OnLastItemVisibleListener mOnLastItemVisibleListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private boolean mScrollEmptyView = true;
    private boolean mShowIndicator;

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    static /* synthetic */ int[] m2135x57a4d715() {
        int[] iArr = f1748x57a4d715;
        if (iArr == null) {
            iArr = new int[PullToRefreshBase.Mode.values().length];
            try {
                iArr[PullToRefreshBase.Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PullToRefreshBase.Mode.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PullToRefreshBase.Mode.MANUAL_REFRESH_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            f1748x57a4d715 = iArr;
        }
        return iArr;
    }

    private static FrameLayout.LayoutParams convertEmptyViewLayoutParams(ViewGroup.LayoutParams lp) {
        FrameLayout.LayoutParams newLp = null;
        if (lp != null) {
            newLp = new FrameLayout.LayoutParams(lp);
            if (lp instanceof LinearLayout.LayoutParams) {
                newLp.gravity = ((LinearLayout.LayoutParams) lp).gravity;
            } else {
                newLp.gravity = 17;
            }
        }
        return newLp;
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animStyle) {
        super(context, mode, animStyle);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public boolean getShowIndicator() {
        return this.mShowIndicator;
    }

    public final void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Log.d("PullToRefresh", "First Visible: " + firstVisibleItem + ". Visible Count: " + visibleItemCount + ". Total Items:" + totalItemCount);
        if (this.mOnLastItemVisibleListener != null) {
            this.mLastItemVisible = totalItemCount > 0 && firstVisibleItem + visibleItemCount >= totalItemCount + -1;
        }
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

    public final void onScrollStateChanged(AbsListView view, int state) {
        if (state == 0 && this.mOnLastItemVisibleListener != null && this.mLastItemVisible) {
            this.mOnLastItemVisibleListener.onLastItemVisible();
        }
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScrollStateChanged(view, state);
        }
    }

    public void setAdapter(ListAdapter adapter) {
        ((AdapterView) this.mRefreshableView).setAdapter(adapter);
    }

    public final void setEmptyView(View newEmptyView) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (newEmptyView != null) {
            newEmptyView.setClickable(true);
            ViewParent newEmptyViewParent = newEmptyView.getParent();
            if (newEmptyViewParent != null && (newEmptyViewParent instanceof ViewGroup)) {
                ((ViewGroup) newEmptyViewParent).removeView(newEmptyView);
            }
            FrameLayout.LayoutParams lp = convertEmptyViewLayoutParams(newEmptyView.getLayoutParams());
            if (lp != null) {
                refreshableViewWrapper.addView(newEmptyView, lp);
            } else {
                refreshableViewWrapper.addView(newEmptyView);
            }
        }
        if (this.mRefreshableView instanceof EmptyViewMethodAccessor) {
            ((EmptyViewMethodAccessor) this.mRefreshableView).setEmptyViewInternal(newEmptyView);
        } else {
            ((AbsListView) this.mRefreshableView).setEmptyView(newEmptyView);
        }
        this.mEmptyView = newEmptyView;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        ((AbsListView) this.mRefreshableView).setOnItemClickListener(listener);
    }

    public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener listener) {
        this.mOnLastItemVisibleListener = listener;
    }

    public final void setOnScrollListener(AbsListView.OnScrollListener listener) {
        this.mOnScrollListener = listener;
    }

    public final void setScrollEmptyView(boolean doScroll) {
        this.mScrollEmptyView = doScroll;
    }

    public void setShowIndicator(boolean showIndicator) {
        this.mShowIndicator = showIndicator;
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    /* access modifiers changed from: protected */
    public void onPullToRefresh() {
        super.onPullToRefresh();
        if (getShowIndicatorInternal()) {
            switch (m2135x57a4d715()[getCurrentMode().ordinal()]) {
                case 2:
                    this.mIndicatorIvTop.pullToRefresh();
                    return;
                case 3:
                    this.mIndicatorIvBottom.pullToRefresh();
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRefreshing(boolean doScroll) {
        super.onRefreshing(doScroll);
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    /* access modifiers changed from: protected */
    public void onReleaseToRefresh() {
        super.onReleaseToRefresh();
        if (getShowIndicatorInternal()) {
            switch (m2135x57a4d715()[getCurrentMode().ordinal()]) {
                case 2:
                    this.mIndicatorIvTop.releaseToRefresh();
                    return;
                case 3:
                    this.mIndicatorIvBottom.releaseToRefresh();
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        super.onReset();
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    /* access modifiers changed from: protected */
    public void handleStyledAttributes(TypedArray a) {
        this.mShowIndicator = a.getBoolean(5, !isPullToRefreshOverScrollEnabled());
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullStart() {
        return isFirstItemVisible();
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullEnd() {
        return isLastItemVisible();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (this.mEmptyView != null && !this.mScrollEmptyView) {
            this.mEmptyView.scrollTo(-l, -t);
        }
    }

    /* access modifiers changed from: protected */
    public void updateUIForMode() {
        super.updateUIForMode();
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    private void addIndicatorViews() {
        PullToRefreshBase.Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.showHeaderLoadingLayout() && this.mIndicatorIvTop == null) {
            this.mIndicatorIvTop = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
            params.rightMargin = getResources().getDimensionPixelSize(C0836R.dimen.indicator_right_padding);
            params.gravity = 53;
            refreshableViewWrapper.addView(this.mIndicatorIvTop, params);
        } else if (!mode.showHeaderLoadingLayout() && this.mIndicatorIvTop != null) {
            refreshableViewWrapper.removeView(this.mIndicatorIvTop);
            this.mIndicatorIvTop = null;
        }
        if (mode.showFooterLoadingLayout() && this.mIndicatorIvBottom == null) {
            this.mIndicatorIvBottom = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
            FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams(-2, -2);
            params2.rightMargin = getResources().getDimensionPixelSize(C0836R.dimen.indicator_right_padding);
            params2.gravity = 85;
            refreshableViewWrapper.addView(this.mIndicatorIvBottom, params2);
        } else if (!mode.showFooterLoadingLayout() && this.mIndicatorIvBottom != null) {
            refreshableViewWrapper.removeView(this.mIndicatorIvBottom);
            this.mIndicatorIvBottom = null;
        }
    }

    private boolean getShowIndicatorInternal() {
        return this.mShowIndicator && isPullToRefreshEnabled();
    }

    private boolean isFirstItemVisible() {
        View firstVisibleChild;
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            Log.d("PullToRefresh", "isFirstItemVisible. Empty View.");
            return true;
        } else if (((AbsListView) this.mRefreshableView).getFirstVisiblePosition() > 1 || (firstVisibleChild = ((AbsListView) this.mRefreshableView).getChildAt(0)) == null) {
            return false;
        } else {
            return firstVisibleChild.getTop() >= ((AbsListView) this.mRefreshableView).getTop();
        }
    }

    private boolean isLastItemVisible() {
        View lastVisibleChild;
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            Log.d("PullToRefresh", "isLastItemVisible. Empty View.");
            return true;
        }
        int lastItemPosition = ((AbsListView) this.mRefreshableView).getCount() - 1;
        int lastVisiblePosition = ((AbsListView) this.mRefreshableView).getLastVisiblePosition();
        Log.d("PullToRefresh", "isLastItemVisible. Last Item Position: " + lastItemPosition + " Last Visible Pos: " + lastVisiblePosition);
        if (lastVisiblePosition < lastItemPosition - 1 || (lastVisibleChild = ((AbsListView) this.mRefreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.mRefreshableView).getFirstVisiblePosition())) == null) {
            return false;
        }
        return lastVisibleChild.getBottom() <= ((AbsListView) this.mRefreshableView).getBottom();
    }

    private void removeIndicatorViews() {
        if (this.mIndicatorIvTop != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvTop);
            this.mIndicatorIvTop = null;
        }
        if (this.mIndicatorIvBottom != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvBottom);
            this.mIndicatorIvBottom = null;
        }
    }

    private void updateIndicatorViewsVisibility() {
        if (this.mIndicatorIvTop != null) {
            if (isRefreshing() || !isReadyForPullStart()) {
                if (this.mIndicatorIvTop.isVisible()) {
                    this.mIndicatorIvTop.hide();
                }
            } else if (!this.mIndicatorIvTop.isVisible()) {
                this.mIndicatorIvTop.show();
            }
        }
        if (this.mIndicatorIvBottom == null) {
            return;
        }
        if (isRefreshing() || !isReadyForPullEnd()) {
            if (this.mIndicatorIvBottom.isVisible()) {
                this.mIndicatorIvBottom.hide();
            }
        } else if (!this.mIndicatorIvBottom.isVisible()) {
            this.mIndicatorIvBottom.show();
        }
    }
}
