package android.support.p000v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* renamed from: android.support.v4.content.ContextCompatHoneycomb */
class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
    }

    static void startActivities(Context context, Intent[] intents) {
        context.startActivities(intents);
    }

    public static File getObbDir(Context context) {
        return context.getObbDir();
    }
}
