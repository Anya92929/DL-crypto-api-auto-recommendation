package android.support.p000v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* renamed from: android.support.v4.app.TaskStackBuilderHoneycomb */
public class TaskStackBuilderHoneycomb {
    public static PendingIntent getActivitiesPendingIntent(Context context, int requestCode, Intent[] intents, int flags) {
        return PendingIntent.getActivities(context, requestCode, intents, flags);
    }
}
