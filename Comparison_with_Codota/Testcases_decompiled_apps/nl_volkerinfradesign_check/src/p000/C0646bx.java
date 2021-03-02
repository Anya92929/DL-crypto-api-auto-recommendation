package p000;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;

/* renamed from: bx */
public class C0646bx {
    /* renamed from: a */
    public static void m3549a(Context context, ComponentName componentName) {
        ((AudioManager) context.getSystemService("audio")).registerMediaButtonEventReceiver(componentName);
    }

    /* renamed from: b */
    public static void m3550b(Context context, ComponentName componentName) {
        ((AudioManager) context.getSystemService("audio")).unregisterMediaButtonEventReceiver(componentName);
    }
}
