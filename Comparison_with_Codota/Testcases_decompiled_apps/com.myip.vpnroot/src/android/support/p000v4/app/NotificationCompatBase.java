package android.support.p000v4.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.support.p000v4.app.RemoteInputCompatBase;

/* renamed from: android.support.v4.app.NotificationCompatBase */
class NotificationCompatBase {

    /* renamed from: android.support.v4.app.NotificationCompatBase$Action */
    public static abstract class Action {

        /* renamed from: android.support.v4.app.NotificationCompatBase$Action$Factory */
        public interface Factory {
            Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInputCompatBase.RemoteInput[] remoteInputArr);

            Action[] newArray(int i);
        }

        /* access modifiers changed from: protected */
        public abstract PendingIntent getActionIntent();

        /* access modifiers changed from: protected */
        public abstract Bundle getExtras();

        /* access modifiers changed from: protected */
        public abstract int getIcon();

        /* access modifiers changed from: protected */
        public abstract RemoteInputCompatBase.RemoteInput[] getRemoteInputs();

        /* access modifiers changed from: protected */
        public abstract CharSequence getTitle();
    }

    NotificationCompatBase() {
    }
}
