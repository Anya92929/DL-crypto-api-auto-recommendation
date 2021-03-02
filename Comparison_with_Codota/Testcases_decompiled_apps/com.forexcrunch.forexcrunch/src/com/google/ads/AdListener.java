package com.google.ads;

import com.google.ads.AdRequest;

public interface AdListener {
    void onDismissScreen(C0165Ad ad);

    void onFailedToReceiveAd(C0165Ad ad, AdRequest.ErrorCode errorCode);

    void onLeaveApplication(C0165Ad ad);

    void onPresentScreen(C0165Ad ad);

    void onReceiveAd(C0165Ad ad);
}
