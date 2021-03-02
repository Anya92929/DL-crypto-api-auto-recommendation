package android.support.p004v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.support.p001v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.p001v4.app.NotificationCompat;
import android.support.p001v4.media.session.MediaSessionCompat;

/* renamed from: android.support.v7.app.NotificationCompat */
public class NotificationCompat extends android.support.p001v4.app.NotificationCompat {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m2968c(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Style style) {
        if (style instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) style;
            C1154ge.m5165a(notificationBuilderWithBuilderAccessor, mediaStyle.f1556a, mediaStyle.f1557b != null ? mediaStyle.f1557b.getToken() : null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m2966b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            C1155gf.m5172a(notificationBuilderWithBuilderAccessor, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, mediaStyle.f1556a, mediaStyle.f1558c, mediaStyle.f1559h);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m2965b(Notification notification, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            C1155gf.m5171a(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, mediaStyle.f1558c, mediaStyle.f1559h);
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$Builder */
    public static class Builder extends NotificationCompat.Builder {
        public Builder(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public NotificationCompat.BuilderExtender getExtender() {
            if (Build.VERSION.SDK_INT >= 21) {
                return new C0501c();
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return new C0500b();
            }
            if (Build.VERSION.SDK_INT >= 14) {
                return new C0499a();
            }
            return super.getExtender();
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$a */
    static class C0499a extends NotificationCompat.BuilderExtender {
        private C0499a() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.m2966b(notificationBuilderWithBuilderAccessor, builder);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$b */
    static class C0500b extends NotificationCompat.BuilderExtender {
        private C0500b() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.m2966b(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            NotificationCompat.m2965b(build, builder);
            return build;
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$c */
    static class C0501c extends NotificationCompat.BuilderExtender {
        private C0501c() {
        }

        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.m2968c(notificationBuilderWithBuilderAccessor, builder.mStyle);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v7.app.NotificationCompat$MediaStyle */
    public static class MediaStyle extends NotificationCompat.Style {

        /* renamed from: a */
        int[] f1556a = null;

        /* renamed from: b */
        MediaSessionCompat.Token f1557b;

        /* renamed from: c */
        boolean f1558c;

        /* renamed from: h */
        PendingIntent f1559h;

        public MediaStyle() {
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.f1556a = iArr;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.f1557b = token;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            this.f1558c = z;
            return this;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.f1559h = pendingIntent;
            return this;
        }
    }
}
