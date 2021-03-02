package android.support.p003v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.support.p000v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.support.p003v7.internal.app.NotificationCompatImpl21;
import android.support.p003v7.internal.app.NotificationCompatImplBase;

/* renamed from: android.support.v7.app.NotificationCompat */
public class NotificationCompat extends android.support.p000v4.app.NotificationCompat {

    /* renamed from: android.support.v7.app.NotificationCompat$Builder */
    public class Builder extends NotificationCompat.Builder {
        public Builder(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public NotificationCompat.BuilderExtender mo914a() {
            return Build.VERSION.SDK_INT >= 21 ? new LollipopExtender() : Build.VERSION.SDK_INT >= 16 ? new JellybeanExtender() : Build.VERSION.SDK_INT >= 14 ? new IceCreamSandwichExtender() : super.mo914a();
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$IceCreamSandwichExtender */
    class IceCreamSandwichExtender extends NotificationCompat.BuilderExtender {
        private IceCreamSandwichExtender() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.m1325b(notificationBuilderWithBuilderAccessor, builder);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$JellybeanExtender */
    class JellybeanExtender extends NotificationCompat.BuilderExtender {
        private JellybeanExtender() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.m1325b(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            NotificationCompat.m1324b(build, builder);
            return build;
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$LollipopExtender */
    class LollipopExtender extends NotificationCompat.BuilderExtender {
        private LollipopExtender() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.m1327c(notificationBuilderWithBuilderAccessor, builder.mStyle);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$MediaStyle */
    public class MediaStyle extends NotificationCompat.Style {

        /* renamed from: a */
        int[] f1878a = null;

        /* renamed from: b */
        MediaSessionCompat.Token f1879b;

        /* renamed from: c */
        boolean f1880c;

        /* renamed from: h */
        PendingIntent f1881h;

        public MediaStyle() {
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.f1881h = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.f1879b = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.f1878a = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            this.f1880c = z;
            return this;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m1324b(Notification notification, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            NotificationCompatImplBase.overrideBigContentView(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, mediaStyle.f1880c, mediaStyle.f1881h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m1325b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            NotificationCompatImplBase.overrideContentView(notificationBuilderWithBuilderAccessor, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, mediaStyle.f1878a, mediaStyle.f1880c, mediaStyle.f1881h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m1327c(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Style style) {
        if (style instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) style;
            NotificationCompatImpl21.addMediaStyle(notificationBuilderWithBuilderAccessor, mediaStyle.f1878a, mediaStyle.f1879b != null ? mediaStyle.f1879b.getToken() : null);
        }
    }
}
