package android.support.p000v4.content;

import android.content.ComponentName;
import android.content.Intent;

/* renamed from: android.support.v4.content.IntentCompatHoneycomb */
class IntentCompatHoneycomb {
    IntentCompatHoneycomb() {
    }

    public static Intent makeMainActivity(ComponentName mainActivity) {
        return Intent.makeMainActivity(mainActivity);
    }

    public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        return Intent.makeRestartActivityTask(mainActivity);
    }
}
