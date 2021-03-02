package android.support.p000v4.view;

import android.view.KeyEvent;

/* renamed from: android.support.v4.view.KeyEventCompatEclair */
class KeyEventCompatEclair {
    KeyEventCompatEclair() {
    }

    public static void startTracking(KeyEvent event) {
        event.startTracking();
    }

    public static boolean isTracking(KeyEvent event) {
        return event.isTracking();
    }
}
