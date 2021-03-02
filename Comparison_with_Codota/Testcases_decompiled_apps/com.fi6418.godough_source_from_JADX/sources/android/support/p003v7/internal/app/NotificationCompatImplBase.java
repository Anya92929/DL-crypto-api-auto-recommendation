package android.support.p003v7.internal.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.support.p000v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.p000v4.app.NotificationCompatBase;
import android.support.p003v7.appcompat.C0235R;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

/* renamed from: android.support.v7.internal.app.NotificationCompatImplBase */
public class NotificationCompatImplBase {
    /* renamed from: a */
    private static int m1333a(int i) {
        return i <= 3 ? C0235R.layout.notification_template_big_media_narrow : C0235R.layout.notification_template_big_media;
    }

    /* renamed from: a */
    private static RemoteViews m1334a(Context context, NotificationCompatBase.Action action) {
        boolean z = action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0235R.layout.notification_media_action);
        remoteViews.setImageViewResource(C0235R.C0237id.action0, action.getIcon());
        if (!z) {
            remoteViews.setOnClickPendingIntent(C0235R.C0237id.action0, action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(C0235R.C0237id.action0, action.getTitle());
        }
        return remoteViews;
    }

    /* renamed from: a */
    private static RemoteViews m1335a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, boolean z2) {
        boolean z3;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        boolean z4 = false;
        boolean z5 = false;
        if (bitmap == null || Build.VERSION.SDK_INT < 16) {
            remoteViews.setViewVisibility(C0235R.C0237id.icon, 8);
        } else {
            remoteViews.setImageViewBitmap(C0235R.C0237id.icon, bitmap);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(C0235R.C0237id.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(C0235R.C0237id.text, charSequence2);
            z4 = true;
        }
        if (charSequence3 != null) {
            remoteViews.setTextViewText(C0235R.C0237id.info, charSequence3);
            remoteViews.setViewVisibility(C0235R.C0237id.info, 0);
            z3 = true;
        } else if (i > 0) {
            if (i > context.getResources().getInteger(C0235R.integer.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(C0235R.C0237id.info, context.getResources().getString(C0235R.string.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(C0235R.C0237id.info, NumberFormat.getIntegerInstance().format((long) i));
            }
            remoteViews.setViewVisibility(C0235R.C0237id.info, 0);
            z3 = true;
        } else {
            remoteViews.setViewVisibility(C0235R.C0237id.info, 8);
            z3 = z4;
        }
        if (charSequence4 != null && Build.VERSION.SDK_INT >= 16) {
            remoteViews.setTextViewText(C0235R.C0237id.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0235R.C0237id.text2, charSequence2);
                remoteViews.setViewVisibility(C0235R.C0237id.text2, 0);
                z5 = true;
            } else {
                remoteViews.setViewVisibility(C0235R.C0237id.text2, 8);
            }
        }
        if (z5 && Build.VERSION.SDK_INT >= 16) {
            if (z2) {
                remoteViews.setTextViewTextSize(C0235R.C0237id.text, 0, (float) context.getResources().getDimensionPixelSize(C0235R.dimen.notification_subtext_size));
            }
            remoteViews.setViewPadding(C0235R.C0237id.line1, 0, 0, 0, 0);
        }
        if (j != 0) {
            if (z) {
                remoteViews.setViewVisibility(C0235R.C0237id.chronometer, 0);
                remoteViews.setLong(C0235R.C0237id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                remoteViews.setBoolean(C0235R.C0237id.chronometer, "setStarted", true);
            } else {
                remoteViews.setViewVisibility(C0235R.C0237id.time, 0);
                remoteViews.setLong(C0235R.C0237id.time, "setTime", j);
            }
        }
        remoteViews.setViewVisibility(C0235R.C0237id.line3, z3 ? 0 : 8);
        return remoteViews;
    }

    /* renamed from: a */
    private static <T extends NotificationCompatBase.Action> RemoteViews m1336a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        int min = Math.min(list.size(), 5);
        RemoteViews a = m1335a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, m1333a(min), false);
        a.removeAllViews(C0235R.C0237id.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                a.addView(C0235R.C0237id.media_actions, m1334a(context, (NotificationCompatBase.Action) list.get(i2)));
            }
        }
        if (z2) {
            a.setViewVisibility(C0235R.C0237id.cancel_action, 0);
            a.setInt(C0235R.C0237id.cancel_action, "setAlpha", context.getResources().getInteger(C0235R.integer.cancel_button_image_alpha));
            a.setOnClickPendingIntent(C0235R.C0237id.cancel_action, pendingIntent);
        } else {
            a.setViewVisibility(C0235R.C0237id.cancel_action, 8);
        }
        return a;
    }

    /* renamed from: a */
    private static <T extends NotificationCompatBase.Action> RemoteViews m1337a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        RemoteViews a = m1335a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, C0235R.layout.notification_template_media, true);
        int size = list.size();
        int min = iArr == null ? 0 : Math.min(iArr.length, 3);
        a.removeAllViews(C0235R.C0237id.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                if (i2 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - 1)}));
                }
                a.addView(C0235R.C0237id.media_actions, m1334a(context, (NotificationCompatBase.Action) list.get(iArr[i2])));
            }
        }
        if (z2) {
            a.setViewVisibility(C0235R.C0237id.end_padder, 8);
            a.setViewVisibility(C0235R.C0237id.cancel_action, 0);
            a.setOnClickPendingIntent(C0235R.C0237id.cancel_action, pendingIntent);
            a.setInt(C0235R.C0237id.cancel_action, "setAlpha", context.getResources().getInteger(C0235R.integer.cancel_button_image_alpha));
        } else {
            a.setViewVisibility(C0235R.C0237id.end_padder, 0);
            a.setViewVisibility(C0235R.C0237id.cancel_action, 8);
        }
        return a;
    }

    public static <T extends NotificationCompatBase.Action> void overrideBigContentView(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        notification.bigContentView = m1336a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, z2, pendingIntent);
        if (z2) {
            notification.flags |= 2;
        }
    }

    public static <T extends NotificationCompatBase.Action> void overrideContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(m1337a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, iArr, z2, pendingIntent));
        if (z2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
    }
}
