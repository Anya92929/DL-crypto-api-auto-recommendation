package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

@TargetApi(9)
public final class OverscrollHelper {

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation */
    private static /* synthetic */ int[] f1747x9c6cb41e = null;
    static final float DEFAULT_OVERSCROLL_SCALE = 1.0f;
    static final String LOG_TAG = "OverscrollHelper";

    /* renamed from: $SWITCH_TABLE$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation */
    static /* synthetic */ int[] m2134x9c6cb41e() {
        int[] iArr = f1747x9c6cb41e;
        if (iArr == null) {
            iArr = new int[PullToRefreshBase.Orientation.values().length];
            try {
                iArr[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            f1747x9c6cb41e = iArr;
        }
        return iArr;
    }

    public static void overScrollBy(PullToRefreshBase<?> view, int deltaX, int scrollX, int deltaY, int scrollY, boolean isTouchEvent) {
        overScrollBy(view, deltaX, scrollX, deltaY, scrollY, 0, isTouchEvent);
    }

    public static void overScrollBy(PullToRefreshBase<?> view, int deltaX, int scrollX, int deltaY, int scrollY, int scrollRange, boolean isTouchEvent) {
        overScrollBy(view, deltaX, scrollX, deltaY, scrollY, scrollRange, 0, DEFAULT_OVERSCROLL_SCALE, isTouchEvent);
    }

    public static void overScrollBy(PullToRefreshBase<?> view, int deltaX, int scrollX, int deltaY, int scrollY, int scrollRange, int fuzzyThreshold, float scaleFactor, boolean isTouchEvent) {
        int deltaValue;
        int scrollValue;
        int currentScrollValue;
        switch (m2134x9c6cb41e()[view.getPullToRefreshScrollDirection().ordinal()]) {
            case 2:
                deltaValue = deltaX;
                scrollValue = scrollX;
                currentScrollValue = view.getScrollX();
                break;
            default:
                deltaValue = deltaY;
                scrollValue = scrollY;
                currentScrollValue = view.getScrollY();
                break;
        }
        if (view.isPullToRefreshOverScrollEnabled() && !view.isRefreshing()) {
            PullToRefreshBase.Mode mode = view.getMode();
            if (mode.permitsPullToRefresh() && !isTouchEvent && deltaValue != 0) {
                int newScrollValue = deltaValue + scrollValue;
                Log.d(LOG_TAG, "OverScroll. DeltaX: " + deltaX + ", ScrollX: " + scrollX + ", DeltaY: " + deltaY + ", ScrollY: " + scrollY + ", NewY: " + newScrollValue + ", ScrollRange: " + scrollRange + ", CurrentScroll: " + currentScrollValue);
                if (newScrollValue < 0 - fuzzyThreshold) {
                    if (mode.showHeaderLoadingLayout()) {
                        if (currentScrollValue == 0) {
                            view.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        view.setHeaderScroll((int) (((float) (currentScrollValue + newScrollValue)) * scaleFactor));
                    }
                } else if (newScrollValue > scrollRange + fuzzyThreshold) {
                    if (mode.showFooterLoadingLayout()) {
                        if (currentScrollValue == 0) {
                            view.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        view.setHeaderScroll((int) (((float) ((currentScrollValue + newScrollValue) - scrollRange)) * scaleFactor));
                    }
                } else if (Math.abs(newScrollValue) <= fuzzyThreshold || Math.abs(newScrollValue - scrollRange) <= fuzzyThreshold) {
                    view.setState(PullToRefreshBase.State.RESET, new boolean[0]);
                }
            } else if (isTouchEvent && PullToRefreshBase.State.OVERSCROLLING == view.getState()) {
                view.setState(PullToRefreshBase.State.RESET, new boolean[0]);
            }
        }
    }

    static boolean isAndroidOverScrollEnabled(View view) {
        return view.getOverScrollMode() != 2;
    }
}
