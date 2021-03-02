package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.C0946bh;

public final class PublisherAdView extends ViewGroup {

    /* renamed from: li */
    private final C0946bh f40li;

    public PublisherAdView(Context context) {
        super(context);
        this.f40li = new C0946bh(this);
    }

    public PublisherAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f40li = new C0946bh(this, attrs, true);
    }

    public PublisherAdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f40li = new C0946bh(this, attrs, true);
    }

    public void destroy() {
        this.f40li.destroy();
    }

    public AdListener getAdListener() {
        return this.f40li.getAdListener();
    }

    public AdSize getAdSize() {
        return this.f40li.getAdSize();
    }

    public AdSize[] getAdSizes() {
        return this.f40li.getAdSizes();
    }

    public String getAdUnitId() {
        return this.f40li.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.f40li.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.f40li.getMediationAdapterClassName();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f40li.mo8090a(publisherAdRequest.mo3311V());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2 = 0;
        View childAt = getChildAt(0);
        AdSize adSize = getAdSize();
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            i = childAt.getMeasuredWidth();
            i2 = childAt.getMeasuredHeight();
        } else if (adSize != null) {
            Context context = getContext();
            i = adSize.getWidthInPixels(context);
            i2 = adSize.getHeightInPixels(context);
        } else {
            i = 0;
        }
        setMeasuredDimension(View.resolveSize(Math.max(i, getSuggestedMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max(i2, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        this.f40li.pause();
    }

    public void recordManualImpression() {
        this.f40li.recordManualImpression();
    }

    public void resume() {
        this.f40li.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.f40li.setAdListener(adListener);
    }

    public void setAdSizes(AdSize... adSizes) {
        if (adSizes == null || adSizes.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f40li.mo8091a(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        this.f40li.setAdUnitId(adUnitId);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f40li.setAppEventListener(appEventListener);
    }
}
