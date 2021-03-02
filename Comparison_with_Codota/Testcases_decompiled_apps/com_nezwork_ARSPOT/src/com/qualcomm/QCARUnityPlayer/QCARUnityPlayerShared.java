package com.qualcomm.QCARUnityPlayer;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

public class QCARUnityPlayerShared {
    static final int SCREEN_ORIENTATION_LANDSCAPELEFT = 3;
    static final int SCREEN_ORIENTATION_LANDSCAPERIGHT = 4;
    static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    static final int SCREEN_ORIENTATION_PORTRAITUPSIDEDOWN = 2;
    static final int SCREEN_ORIENTATION_UNKNOWN = 0;

    public static int getSurfaceOrientation(Activity activity) {
        int displayRotation;
        if (activity == null) {
            return -1;
        }
        Configuration config = activity.getResources().getConfiguration();
        Display display = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 8) {
            displayRotation = display.getRotation();
        } else {
            displayRotation = display.getOrientation();
        }
        switch (config.orientation) {
            case 1:
            case 3:
                return (displayRotation == 0 || displayRotation == 3) ? 1 : 2;
            case 2:
                return (displayRotation == 0 || displayRotation == 1) ? 3 : 4;
            default:
                return 0;
        }
    }
}
