package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzae;

public final class PublisherAdView extends ViewGroup {

    /* renamed from: a */
    private final zzae f3404a;

    public PublisherAdView(Context context) {
        super(context);
        this.f3404a = new zzae(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3404a = new zzae(this, attributeSet, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3404a = new zzae(this, attributeSet, true);
    }

    public void destroy() {
        this.f3404a.destroy();
    }

    public AdListener getAdListener() {
        return this.f3404a.getAdListener();
    }

    public AdSize getAdSize() {
        return this.f3404a.getAdSize();
    }

    public AdSize[] getAdSizes() {
        return this.f3404a.getAdSizes();
    }

    public String getAdUnitId() {
        return this.f3404a.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.f3404a.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.f3404a.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f3404a.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoading() {
        return this.f3404a.isLoading();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f3404a.zza(publisherAdRequest.zzdc());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                i3 = adSize.getWidthInPixels(context);
                i4 = adSize.getHeightInPixels(context);
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i3 = childAt.getMeasuredWidth();
            i4 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.f3404a.pause();
    }

    public void recordManualImpression() {
        this.f3404a.recordManualImpression();
    }

    public void resume() {
        this.f3404a.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.f3404a.setAdListener(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f3404a.zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        this.f3404a.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f3404a.setAppEventListener(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.f3404a.setCorrelator(correlator);
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.f3404a.setManualImpressionsEnabled(z);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f3404a.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }
}
