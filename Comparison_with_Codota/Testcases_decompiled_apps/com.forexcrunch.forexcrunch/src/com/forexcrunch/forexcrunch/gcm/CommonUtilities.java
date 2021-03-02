package com.forexcrunch.forexcrunch.gcm;

import android.content.Context;
import android.content.Intent;

public final class CommonUtilities {
    public static final String DISPLAY_MESSAGE_ACTION = "com.forexcrunch.forexcrunch.DISPLAY_MESSAGE";
    public static final String EXTRA_MESSAGE = "message";
    public static final String SENDER_ID = "591045420173";
    static final String SERVER_URL = "http://forexcrunch.wpengine.com/pushNotification/android/register.php";
    public static final String TAG = "ForexCrunch GCM";
    static final String UNREGISTER = "http://forexcrunch.wpengine.com/pushNotification/android/unregister.php";

    static void displayMessage(Context context, String message) {
        Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
        intent.putExtra(EXTRA_MESSAGE, message);
        context.sendBroadcast(intent);
    }
}
