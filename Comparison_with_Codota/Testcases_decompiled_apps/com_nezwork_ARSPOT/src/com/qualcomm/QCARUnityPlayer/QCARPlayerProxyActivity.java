package com.qualcomm.QCARUnityPlayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class QCARPlayerProxyActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        Class<?> activity;
        super.onCreate(savedInstanceState);
        boolean isNativeActivityAvailable = false;
        try {
            Class.forName("com.unity3d.player.UnityPlayer").getMethod("configurationChanged", new Class[]{Class.forName("android.content.res.Configuration")});
            isNativeActivityAvailable = true;
        } catch (Exception e) {
        }
        try {
            if (Build.VERSION.SDK_INT < 9 || !isNativeActivityAvailable) {
                activity = Class.forName("com.qualcomm.QCARUnityPlayer.QCARPlayerActivity");
            } else {
                activity = Class.forName("com.qualcomm.QCARUnityPlayer.QCARPlayerNativeActivity");
            }
            Intent intent = new Intent(this, activity);
            intent.addFlags(65536);
            intent.putExtra("orientation", getRequestedOrientation());
            startActivity(intent);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } finally {
            finish();
        }
    }
}
