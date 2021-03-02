package com.platoevolved.admobunity;

import android.os.Bundle;
import com.unity3d.player.UnityPlayerActivity;

public class AdMobUnityActivity extends UnityPlayerActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean start_hidden = false;
        try {
            start_hidden = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getBoolean("start_hidden");
        } catch (Exception e) {
        }
        if (start_hidden) {
            UnityAndroidInterface.StartAdsHidden();
        } else {
            UnityAndroidInterface.StartAds();
        }
    }

    public static void SetPosition(String x, String y) {
        UnityAndroidInterface.SetPosition(x, y);
    }

    public static void ShowAds() {
        UnityAndroidInterface.ShowAds();
    }

    public static void HideAds() {
        UnityAndroidInterface.HideAds();
    }

    public void onDestroy() {
        UnityAndroidInterface.StopAds();
        super.onDestroy();
    }
}
