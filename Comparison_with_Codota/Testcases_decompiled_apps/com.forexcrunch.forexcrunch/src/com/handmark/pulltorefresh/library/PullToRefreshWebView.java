package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

public class PullToRefreshWebView extends PullToRefreshBase<WebView> {
    private static final PullToRefreshBase.OnRefreshListener<WebView> defaultOnRefreshListener = new PullToRefreshBase.OnRefreshListener<WebView>() {
        public void onRefresh(PullToRefreshBase<WebView> refreshView) {
            refreshView.getRefreshableView().reload();
        }
    };
    private final WebChromeClient defaultWebChromeClient = new WebChromeClient() {
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                PullToRefreshWebView.this.onRefreshComplete();
            }
        }
    };

    public PullToRefreshWebView(Context context) {
        super(context);
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
    }

    public PullToRefreshWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
    }

    public PullToRefreshWebView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
    }

    public PullToRefreshWebView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle style) {
        super(context, mode, style);
        setOnRefreshListener(defaultOnRefreshListener);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.defaultWebChromeClient);
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    /* access modifiers changed from: protected */
    public WebView createRefreshableView(Context context, AttributeSet attrs) {
        WebView webView;
        if (Build.VERSION.SDK_INT >= 9) {
            webView = new InternalWebViewSDK9(context, attrs);
        } else {
            webView = new WebView(context, attrs);
        }
        webView.setId(C0836R.C0837id.webview);
        return webView;
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullStart() {
        return ((WebView) this.mRefreshableView).getScrollY() == 0;
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullEnd() {
        return ((float) ((WebView) this.mRefreshableView).getScrollY()) >= FloatMath.floor(((WebView) this.mRefreshableView).getScale() * ((float) ((WebView) this.mRefreshableView).getContentHeight())) - ((float) ((WebView) this.mRefreshableView).getHeight());
    }

    /* access modifiers changed from: protected */
    public void onPtrRestoreInstanceState(Bundle savedInstanceState) {
        super.onPtrRestoreInstanceState(savedInstanceState);
        ((WebView) this.mRefreshableView).restoreState(savedInstanceState);
    }

    /* access modifiers changed from: protected */
    public void onPtrSaveInstanceState(Bundle saveState) {
        super.onPtrSaveInstanceState(saveState);
        ((WebView) this.mRefreshableView).saveState(saveState);
    }

    @TargetApi(9)
    final class InternalWebViewSDK9 extends WebView {
        static final int OVERSCROLL_FUZZY_THRESHOLD = 2;
        static final float OVERSCROLL_SCALE_FACTOR = 1.5f;

        public InternalWebViewSDK9(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* access modifiers changed from: protected */
        public boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
            boolean returnValue = super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
            OverscrollHelper.overScrollBy(PullToRefreshWebView.this, deltaX, scrollX, deltaY, scrollY, getScrollRange(), 2, OVERSCROLL_SCALE_FACTOR, isTouchEvent);
            return returnValue;
        }

        private int getScrollRange() {
            return (int) Math.max(BitmapDescriptorFactory.HUE_RED, FloatMath.floor(((WebView) PullToRefreshWebView.this.mRefreshableView).getScale() * ((float) ((WebView) PullToRefreshWebView.this.mRefreshableView).getContentHeight())) - ((float) ((getHeight() - getPaddingBottom()) - getPaddingTop())));
        }
    }
}
