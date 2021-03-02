package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public final class NativeContentAdView extends NativeAdView {
    public NativeContentAdView(Context context) {
        super(context);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NativeContentAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final View getAdvertiserView() {
        return super.mo4914a("1004");
    }

    public final View getBodyView() {
        return super.mo4914a("1002");
    }

    public final View getCallToActionView() {
        return super.mo4914a("1003");
    }

    public final View getHeadlineView() {
        return super.mo4914a("1001");
    }

    public final View getImageView() {
        return super.mo4914a("1005");
    }

    public final View getLogoView() {
        return super.mo4914a("1006");
    }

    public final void setAdvertiserView(View view) {
        super.mo4916a("1004", view);
    }

    public final void setBodyView(View view) {
        super.mo4916a("1002", view);
    }

    public final void setCallToActionView(View view) {
        super.mo4916a("1003", view);
    }

    public final void setHeadlineView(View view) {
        super.mo4916a("1001", view);
    }

    public final void setImageView(View view) {
        super.mo4916a("1005", view);
    }

    public final void setLogoView(View view) {
        super.mo4916a("1006", view);
    }
}
