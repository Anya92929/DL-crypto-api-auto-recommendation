package com.unity3d.player;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public final class m {
    private final Bundle a;

    public m(Activity activity) {
        Bundle bundle = Bundle.EMPTY;
        PackageManager packageManager = activity.getPackageManager();
        ComponentName componentName = activity.getComponentName();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            if (!(activityInfo == null || activityInfo.metaData == null)) {
                bundle = activityInfo.metaData;
            }
        } catch (PackageManager.NameNotFoundException e) {
            l.Log(6, "Unable to retreive meta data for activity '" + componentName + "'");
        }
        this.a = new Bundle(bundle);
    }

    public final boolean a() {
        return this.a.getBoolean(String.format("%s.%s", new Object[]{"unityplayer", "ForwardNativeEventsToDalvik"}));
    }
}
