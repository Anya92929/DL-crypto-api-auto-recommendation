package com.platoevolved.admobunity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.unity3d.player.UnityPlayer;

public class UnityAndroidInterface {
    /* access modifiers changed from: private */
    public static Activity activity = null;
    /* access modifiers changed from: private */
    public static AdView adView = null;
    /* access modifiers changed from: private */
    public static String admob_pub_id = "";
    /* access modifiers changed from: private */
    public static AdSize adsize = AdSize.BANNER;
    /* access modifiers changed from: private */
    public static FrameLayout layout = null;
    /* access modifiers changed from: private */
    public static String testdeviceid = "";
    /* access modifiers changed from: private */
    public static boolean testmode = false;
    /* access modifiers changed from: private */
    public static String xposition = "middle";
    /* access modifiers changed from: private */
    public static String yposition = "top";

    public static void SetActivity(Activity act) {
        activity = act;
    }

    public static void SetTestMode(String test_device_id) {
        testmode = true;
        testdeviceid = test_device_id;
    }

    public static void SetBanner(String bannertype) {
        if (bannertype.equals("IAB_MRECT")) {
            adsize = AdSize.IAB_MRECT;
        }
        if (bannertype.equals("IAB_BANNER")) {
            adsize = AdSize.IAB_BANNER;
        }
        if (bannertype.equals("IAB_LEADERBOARD")) {
            adsize = AdSize.IAB_LEADERBOARD;
        }
        if (bannertype.equals("SMART_BANNER")) {
            adsize = AdSize.SMART_BANNER;
        }
        if (bannertype.equals("BANNER")) {
            adsize = AdSize.BANNER;
        }
        if (adView != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    UnityAndroidInterface.layout.removeView(UnityAndroidInterface.adView);
                    UnityAndroidInterface.adView.destroy();
                    UnityAndroidInterface.adView = new AdView(UnityAndroidInterface.activity, UnityAndroidInterface.adsize, UnityAndroidInterface.admob_pub_id);
                    UnityAndroidInterface.layout.addView(UnityAndroidInterface.adView, new FrameLayout.LayoutParams(-2, -2, 80));
                    UnityAndroidInterface.RefreshAd();
                    UnityAndroidInterface.SetPosition(UnityAndroidInterface.xposition, UnityAndroidInterface.yposition);
                }
            });
        }
    }

    public static void RefreshAd() {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                AdRequest request = new AdRequest();
                if (UnityAndroidInterface.testmode) {
                    request.addTestDevice(AdRequest.TEST_EMULATOR);
                    request.addTestDevice(UnityAndroidInterface.testdeviceid);
                }
                UnityAndroidInterface.adView.loadAd(request);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void startAds(boolean start_hidden) {
        if (activity == null) {
            activity = UnityPlayer.currentActivity;
        }
        try {
            Bundle bundle = activity.getApplicationContext().getPackageManager().getApplicationInfo(activity.getPackageName(), 128).metaData;
            admob_pub_id = bundle.getString("admob_pub_id");
            xposition = bundle.getString("adposition_x");
            yposition = bundle.getString("adposition_y");
        } catch (Exception e) {
        }
        if (!start_hidden) {
            if (layout == null) {
                layout = new FrameLayout(activity);
                activity.addContentView(layout, new ViewGroup.LayoutParams(-1, -1));
            }
            if (adView == null) {
                adView = new AdView(activity, adsize, admob_pub_id);
                layout.addView(adView, new FrameLayout.LayoutParams(-2, -2, 80));
            }
            AdRequest request = new AdRequest();
            if (testmode) {
                request.addTestDevice(AdRequest.TEST_EMULATOR);
                request.addTestDevice(testdeviceid);
            }
            adView.loadAd(request);
            SetPosition(xposition, yposition);
        }
    }

    public static void StartAds() {
        if (activity == null) {
            activity = UnityPlayer.currentActivity;
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                UnityAndroidInterface.startAds(false);
            }
        });
    }

    public static void StartAdsHidden() {
        if (activity == null) {
            activity = UnityPlayer.currentActivity;
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                UnityAndroidInterface.startAds(true);
            }
        });
    }

    public static void SetPosition(final String xpos, final String ypos) {
        if (layout == null) {
            StartAds();
        }
        xposition = xpos;
        yposition = ypos;
        activity.runOnUiThread(new Runnable() {
            public void run() {
                int gravity;
                int gravity2 = 17;
                if (xpos.equals("left")) {
                    gravity2 = 3;
                }
                if (xpos.equals("middle")) {
                    gravity2 = 17;
                }
                if (xpos.equals("right")) {
                    gravity2 = 5;
                }
                if (ypos.equals("top")) {
                    gravity = gravity2 | 48;
                } else {
                    gravity = gravity2 | 80;
                }
                UnityAndroidInterface.layout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, gravity));
            }
        });
    }

    public static void ShowAds() {
        if (layout == null) {
            StartAds();
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                UnityAndroidInterface.adView.setVisibility(0);
            }
        });
    }

    public static void HideAds() {
        if (layout == null) {
            StartAds();
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                UnityAndroidInterface.adView.setVisibility(8);
            }
        });
    }

    public static void StopAds() {
        if (adView != null) {
            layout.removeView(adView);
            adView.destroy();
            adView = null;
        }
    }
}
