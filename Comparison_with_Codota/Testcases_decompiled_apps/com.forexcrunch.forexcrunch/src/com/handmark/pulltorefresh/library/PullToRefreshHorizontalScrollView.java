package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

public class PullToRefreshHorizontalScrollView extends PullToRefreshBase<HorizontalScrollView> {
    public PullToRefreshHorizontalScrollView(Context context) {
        super(context);
    }

    public PullToRefreshHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshHorizontalScrollView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }

    public PullToRefreshHorizontalScrollView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle style) {
        super(context, mode, style);
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.HORIZONTAL;
    }

    /* access modifiers changed from: protected */
    public HorizontalScrollView createRefreshableView(Context context, AttributeSet attrs) {
        HorizontalScrollView scrollView;
        if (Build.VERSION.SDK_INT >= 9) {
            scrollView = new InternalHorizontalScrollViewSDK9(context, attrs);
        } else {
            scrollView = new HorizontalScrollView(context, attrs);
        }
        scrollView.setId(C0836R.C0837id.scrollview);
        return scrollView;
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullStart() {
        return ((HorizontalScrollView) this.mRefreshableView).getScrollX() == 0;
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullEnd() {
        View scrollViewChild = ((HorizontalScrollView) this.mRefreshableView).getChildAt(0);
        if (scrollViewChild == null) {
            return false;
        }
        if (((HorizontalScrollView) this.mRefreshableView).getScrollX() >= scrollViewChild.getWidth() - getWidth()) {
            return true;
        }
        return false;
    }

    @TargetApi(9)
    final class InternalHorizontalScrollViewSDK9 extends HorizontalScrollView {
        public InternalHorizontalScrollViewSDK9(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
            boolean returnValue = super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
            OverscrollHelper.overScrollBy(PullToRefreshHorizontalScrollView.this, deltaX, scrollX, deltaY, scrollY, getScrollRange(), isTouchEvent);
            return returnValue;
        }

        private int getScrollRange() {
            if (getChildCount() > 0) {
                return Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight()));
            }
            return 0;
        }
    }
}
