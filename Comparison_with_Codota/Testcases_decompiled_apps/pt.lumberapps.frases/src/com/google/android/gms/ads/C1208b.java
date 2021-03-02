package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzae;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

/* renamed from: com.google.android.gms.ads.b */
class C1208b extends ViewGroup {

    /* renamed from: a */
    protected final zzae f3401a;

    public C1208b(Context context, int i) {
        super(context);
        this.f3401a = new zzae(this, m5502a(i));
    }

    public C1208b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f3401a = new zzae(this, attributeSet, false, m5502a(i));
    }

    public C1208b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f3401a = new zzae(this, attributeSet, false, m5502a(i2));
    }

    /* renamed from: a */
    private static boolean m5502a(int i) {
        return i == 2;
    }

    public void destroy() {
        this.f3401a.destroy();
    }

    public AdListener getAdListener() {
        return this.f3401a.getAdListener();
    }

    public AdSize getAdSize() {
        return this.f3401a.getAdSize();
    }

    public String getAdUnitId() {
        return this.f3401a.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f3401a.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.f3401a.getMediationAdapterClassName();
    }

    public boolean isLoading() {
        return this.f3401a.isLoading();
    }

    public void loadAd(AdRequest adRequest) {
        this.f3401a.zza(adRequest.zzdc());
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
        this.f3401a.pause();
    }

    public void resume() {
        this.f3401a.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.f3401a.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zza)) {
            this.f3401a.zza((zza) adListener);
        } else if (adListener == null) {
            this.f3401a.zza((zza) null);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.f3401a.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.f3401a.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.f3401a.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.f3401a.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }
}
