package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView> {

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    private static /* synthetic */ int[] f1753x57a4d715;
    private LoadingLayout mFooterLoadingView;
    private LoadingLayout mHeaderLoadingView;
    private boolean mListViewExtrasEnabled;
    /* access modifiers changed from: private */
    public FrameLayout mLvFooterLoadingFrame;

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode */
    static /* synthetic */ int[] m2140x57a4d715() {
        int[] iArr = f1753x57a4d715;
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
            f1753x57a4d715 = iArr;
        }
        return iArr;
    }

    public PullToRefreshListView(Context context) {
        super(context);
    }

    public PullToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle style) {
        super(context, mode, style);
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    /* access modifiers changed from: protected */
    public void onRefreshing(boolean doScroll) {
        LoadingLayout origLoadingView;
        LoadingLayout listViewLoadingView;
        LoadingLayout oppositeListViewLoadingView;
        int selection;
        int scrollToY;
        ListAdapter adapter = ((ListView) this.mRefreshableView).getAdapter();
        if (!this.mListViewExtrasEnabled || !getShowViewWhileRefreshing() || adapter == null || adapter.isEmpty()) {
            super.onRefreshing(doScroll);
            return;
        }
        super.onRefreshing(false);
        switch (m2140x57a4d715()[getCurrentMode().ordinal()]) {
            case 3:
            case 5:
                origLoadingView = getFooterLayout();
                listViewLoadingView = this.mFooterLoadingView;
                oppositeListViewLoadingView = this.mHeaderLoadingView;
                selection = ((ListView) this.mRefreshableView).getCount() - 1;
                scrollToY = getScrollY() - getFooterSize();
                break;
            default:
                origLoadingView = getHeaderLayout();
                listViewLoadingView = this.mHeaderLoadingView;
                oppositeListViewLoadingView = this.mFooterLoadingView;
                selection = 0;
                scrollToY = getScrollY() + getHeaderSize();
                break;
        }
        origLoadingView.reset();
        origLoadingView.hideAllViews();
        oppositeListViewLoadingView.setVisibility(8);
        listViewLoadingView.setVisibility(0);
        listViewLoadingView.refreshing();
        if (doScroll) {
            disableLoadingLayoutVisibilityChanges();
            setHeaderScroll(scrollToY);
            ((ListView) this.mRefreshableView).setSelection(selection);
            smoothScrollTo(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        LoadingLayout originalLoadingLayout;
        LoadingLayout listViewLoadingLayout;
        int selection;
        int scrollToHeight;
        boolean scrollLvToEdge = true;
        if (!this.mListViewExtrasEnabled) {
            super.onReset();
            return;
        }
        switch (m2140x57a4d715()[getCurrentMode().ordinal()]) {
            case 3:
            case 5:
                originalLoadingLayout = getFooterLayout();
                listViewLoadingLayout = this.mFooterLoadingView;
                selection = ((ListView) this.mRefreshableView).getCount() - 1;
                scrollToHeight = getFooterSize();
                if (Math.abs(((ListView) this.mRefreshableView).getLastVisiblePosition() - selection) > 1) {
                    scrollLvToEdge = false;
                    break;
                }
                break;
            default:
                originalLoadingLayout = getHeaderLayout();
                listViewLoadingLayout = this.mHeaderLoadingView;
                scrollToHeight = -getHeaderSize();
                selection = 0;
                if (Math.abs(((ListView) this.mRefreshableView).getFirstVisiblePosition() - 0) > 1) {
                    scrollLvToEdge = false;
                    break;
                }
                break;
        }
        if (listViewLoadingLayout.getVisibility() == 0) {
            originalLoadingLayout.showInvisibleViews();
            listViewLoadingLayout.setVisibility(8);
            if (scrollLvToEdge && getState() != PullToRefreshBase.State.MANUAL_REFRESHING) {
                ((ListView) this.mRefreshableView).setSelection(selection);
                setHeaderScroll(scrollToHeight);
            }
        }
        super.onReset();
    }

    /* access modifiers changed from: protected */
    public LoadingLayoutProxy createLoadingLayoutProxy(boolean includeStart, boolean includeEnd) {
        LoadingLayoutProxy proxy = super.createLoadingLayoutProxy(includeStart, includeEnd);
        if (this.mListViewExtrasEnabled) {
            PullToRefreshBase.Mode mode = getMode();
            if (includeStart && mode.showHeaderLoadingLayout()) {
                proxy.addLayout(this.mHeaderLoadingView);
            }
            if (includeEnd && mode.showFooterLoadingLayout()) {
                proxy.addLayout(this.mFooterLoadingView);
            }
        }
        return proxy;
    }

    /* access modifiers changed from: protected */
    public ListView createListView(Context context, AttributeSet attrs) {
        if (Build.VERSION.SDK_INT >= 9) {
            return new InternalListViewSDK9(context, attrs);
        }
        return new InternalListView(context, attrs);
    }

    /* access modifiers changed from: protected */
    public ListView createRefreshableView(Context context, AttributeSet attrs) {
        ListView lv = createListView(context, attrs);
        lv.setId(16908298);
        return lv;
    }

    /* access modifiers changed from: protected */
    public void handleStyledAttributes(TypedArray a) {
        super.handleStyledAttributes(a);
        this.mListViewExtrasEnabled = a.getBoolean(14, true);
        if (this.mListViewExtrasEnabled) {
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -2, 1);
            FrameLayout frame = new FrameLayout(getContext());
            this.mHeaderLoadingView = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, a);
            this.mHeaderLoadingView.setVisibility(8);
            frame.addView(this.mHeaderLoadingView, lp);
            ((ListView) this.mRefreshableView).addHeaderView(frame, (Object) null, false);
            this.mLvFooterLoadingFrame = new FrameLayout(getContext());
            this.mFooterLoadingView = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, a);
            this.mFooterLoadingView.setVisibility(8);
            this.mLvFooterLoadingFrame.addView(this.mFooterLoadingView, lp);
            if (!a.hasValue(13)) {
                setScrollingWhileRefreshingEnabled(true);
            }
        }
    }

    @TargetApi(9)
    final class InternalListViewSDK9 extends InternalListView {
        public InternalListViewSDK9(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
            boolean returnValue = super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
            OverscrollHelper.overScrollBy(PullToRefreshListView.this, deltaX, scrollX, deltaY, scrollY, isTouchEvent);
            return returnValue;
        }
    }

    protected class InternalListView extends ListView implements EmptyViewMethodAccessor {
        private boolean mAddedLvFooter = false;

        public InternalListView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        public boolean dispatchTouchEvent(MotionEvent ev) {
            try {
                return super.dispatchTouchEvent(ev);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
        }

        public void setAdapter(ListAdapter adapter) {
            if (PullToRefreshListView.this.mLvFooterLoadingFrame != null && !this.mAddedLvFooter) {
                addFooterView(PullToRefreshListView.this.mLvFooterLoadingFrame, (Object) null, false);
                this.mAddedLvFooter = true;
            }
            super.setAdapter(adapter);
        }

        public void setEmptyView(View emptyView) {
            PullToRefreshListView.this.setEmptyView(emptyView);
        }

        public void setEmptyViewInternal(View emptyView) {
            super.setEmptyView(emptyView);
        }
    }
}
