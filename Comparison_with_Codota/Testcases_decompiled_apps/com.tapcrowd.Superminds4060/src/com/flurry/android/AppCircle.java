package com.flurry.android;

import android.content.Context;
import android.view.View;
import java.util.List;

public class AppCircle {
    public void setDefaultNoAdsMessage(String str) {
        FlurryAgent.setDefaultNoAdsMessage(str);
    }

    public void setAppCircleCallback(AppCircleCallback appCircleCallback) {
        FlurryAgent.m15a(appCircleCallback);
    }

    public void launchCatalogOnBannerClicked(boolean z) {
        FlurryAgent.m23a(z);
    }

    public void launchCanvasOnBannerClicked(boolean z) {
        FlurryAgent.m23a(z);
    }

    public boolean isLaunchCanvasOnBannerClicked() {
        return FlurryAgent.m24a();
    }

    public boolean isLaunchCatalogOnBannerClicked() {
        return FlurryAgent.m24a();
    }

    public View getHook(Context context, String str, int i) {
        return FlurryAgent.m8a(context, str, i);
    }

    public void openCatalog(Context context) {
        openCatalog(context, "");
    }

    public void openCatalog(Context context, String str) {
        FlurryAgent.m13a(context, str);
    }

    public boolean hasAds() {
        return FlurryAgent.m46d();
    }

    public Offer getOffer(String str) {
        return FlurryAgent.m9a(str);
    }

    public List getAllOffers(String str) {
        return FlurryAgent.m31b(str);
    }

    public void acceptOffer(Context context, long j) {
        FlurryAgent.m12a(context, j);
    }

    public void removeOffers(List list) {
        FlurryAgent.m22a(list);
    }

    public Offer getOffer() {
        return getOffer("");
    }

    public List getAllOffers() {
        return FlurryAgent.m31b("");
    }

    public void addUserCookie(String str, String str2) {
        FlurryAgent.addUserCookie(str, str2);
    }

    public void clearUserCookies() {
        FlurryAgent.clearUserCookies();
    }
}
