package android.support.p000v4.media.session;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;

/* renamed from: android.support.v4.media.session.MediaSessionCompatApi8 */
public class MediaSessionCompatApi8 {
    public static void registerMediaButtonEventReceiver(Context context, ComponentName componentName) {
        ((AudioManager) context.getSystemService("audio")).registerMediaButtonEventReceiver(componentName);
    }

    public static void unregisterMediaButtonEventReceiver(Context context, ComponentName componentName) {
        ((AudioManager) context.getSystemService("audio")).unregisterMediaButtonEventReceiver(componentName);
    }
}
