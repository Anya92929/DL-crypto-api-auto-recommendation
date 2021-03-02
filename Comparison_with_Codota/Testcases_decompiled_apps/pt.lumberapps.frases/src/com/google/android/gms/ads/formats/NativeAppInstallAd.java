package com.google.android.gms.ads.formats;

import android.os.Bundle;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

public abstract class NativeAppInstallAd extends NativeAd {

    public interface OnAppInstallAdLoadedListener {
        void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd);
    }

    public abstract void destroy();

    public abstract CharSequence getBody();

    public abstract CharSequence getCallToAction();

    public abstract Bundle getExtras();

    public abstract CharSequence getHeadline();

    public abstract NativeAd.Image getIcon();

    public abstract List getImages();

    public abstract CharSequence getPrice();

    public abstract Double getStarRating();

    public abstract CharSequence getStore();
}
