package android.support.p000v4.content;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: android.support.v4.content.IntentCompatHoneycomb */
class IntentCompatHoneycomb {
    IntentCompatHoneycomb() {
    }

    public static Intent makeMainActivity(ComponentName componentName) {
        return Intent.makeMainActivity(componentName);
    }

    public static Intent makeRestartActivityTask(ComponentName componentName) {
        return Intent.makeRestartActivityTask(componentName);
    }
}
