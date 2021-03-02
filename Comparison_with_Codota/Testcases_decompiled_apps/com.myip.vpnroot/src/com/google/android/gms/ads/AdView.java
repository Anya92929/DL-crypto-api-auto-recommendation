package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.C0946bh;

public final class AdView extends ViewGroup {

    /* renamed from: li */
    private final C0946bh f36li;

    public AdView(Context context) {
        super(context);
        this.f36li = new C0946bh(this);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f36li = new C0946bh(this, attrs, false);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f36li = new C0946bh(this, attrs, false);
    }

    public void destroy() {
        this.f36li.destroy();
    }

    public AdListener getAdListener() {
        return this.f36li.getAdListener();
    }

    public AdSize getAdSize() {
        return this.f36li.getAdSize();
    }

    public String getAdUnitId() {
        return this.f36li.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f36li.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.f36li.getMediationAdapterClassName();
    }

    public void loadAd(AdRequest adRequest) {
        this.f36li.mo8090a(adRequest.mo3253V());
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
        this.f36li.pause();
    }

    public void resume() {
        this.f36li.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.f36li.setAdListener(adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.f36li.setAdSizes(adSize);
    }

    public void setAdUnitId(String adUnitId) {
        this.f36li.setAdUnitId(adUnitId);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f36li.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        this.f36li.setPlayStorePurchaseParams(playStorePurchaseListener, publicKey);
    }
}
