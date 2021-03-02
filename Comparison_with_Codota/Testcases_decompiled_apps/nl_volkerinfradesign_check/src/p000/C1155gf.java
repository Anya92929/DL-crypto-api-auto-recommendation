package p000;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.support.p001v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.p001v4.app.NotificationCompatBase;
import android.support.p004v7.appcompat.C0505R;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

/* renamed from: gf */
public class C1155gf {
    /* renamed from: a */
    public static <T extends NotificationCompatBase.Action> void m5172a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(m5170a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, iArr, z2, pendingIntent));
        if (z2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
    }

    /* renamed from: a */
    private static <T extends NotificationCompatBase.Action> RemoteViews m5170a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        int min;
        RemoteViews a = m5168a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, C0505R.layout.notification_template_media, true);
        int size = list.size();
        if (iArr == null) {
            min = 0;
        } else {
            min = Math.min(iArr.length, 3);
        }
        a.removeAllViews(C0505R.C0507id.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                if (i2 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - 1)}));
                }
                a.addView(C0505R.C0507id.media_actions, m5167a(context, (NotificationCompatBase.Action) list.get(iArr[i2])));
            }
        }
        if (z2) {
            a.setViewVisibility(C0505R.C0507id.end_padder, 8);
            a.setViewVisibility(C0505R.C0507id.cancel_action, 0);
            a.setOnClickPendingIntent(C0505R.C0507id.cancel_action, pendingIntent);
            a.setInt(C0505R.C0507id.cancel_action, "setAlpha", context.getResources().getInteger(C0505R.integer.cancel_button_image_alpha));
        } else {
            a.setViewVisibility(C0505R.C0507id.end_padder, 0);
            a.setViewVisibility(C0505R.C0507id.cancel_action, 8);
        }
        return a;
    }

    /* renamed from: a */
    public static <T extends NotificationCompatBase.Action> void m5171a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        notification.bigContentView = m5169a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, z2, pendingIntent);
        if (z2) {
            notification.flags |= 2;
        }
    }

    /* renamed from: a */
    private static <T extends NotificationCompatBase.Action> RemoteViews m5169a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        int min = Math.min(list.size(), 5);
        RemoteViews a = m5168a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, m5166a(min), false);
        a.removeAllViews(C0505R.C0507id.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                a.addView(C0505R.C0507id.media_actions, m5167a(context, (NotificationCompatBase.Action) list.get(i2)));
            }
        }
        if (z2) {
            a.setViewVisibility(C0505R.C0507id.cancel_action, 0);
            a.setInt(C0505R.C0507id.cancel_action, "setAlpha", context.getResources().getInteger(C0505R.integer.cancel_button_image_alpha));
            a.setOnClickPendingIntent(C0505R.C0507id.cancel_action, pendingIntent);
        } else {
            a.setViewVisibility(C0505R.C0507id.cancel_action, 8);
        }
        return a;
    }

    /* renamed from: a */
    private static RemoteViews m5167a(Context context, NotificationCompatBase.Action action) {
        boolean z = action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0505R.layout.notification_media_action);
        remoteViews.setImageViewResource(C0505R.C0507id.action0, action.getIcon());
        if (!z) {
            remoteViews.setOnClickPendingIntent(C0505R.C0507id.action0, action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(C0505R.C0507id.action0, action.getTitle());
        }
        return remoteViews;
    }

    /* renamed from: a */
    private static int m5166a(int i) {
        if (i <= 3) {
            return C0505R.layout.notification_template_big_media_narrow;
        }
        return C0505R.layout.notification_template_big_media;
    }

    /* renamed from: a */
    private static RemoteViews m5168a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, boolean z2) {
        boolean z3;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        boolean z4 = false;
        boolean z5 = false;
        if (bitmap == null || Build.VERSION.SDK_INT < 16) {
            remoteViews.setViewVisibility(C0505R.C0507id.icon, 8);
        } else {
            remoteViews.setViewVisibility(C0505R.C0507id.icon, 0);
            remoteViews.setImageViewBitmap(C0505R.C0507id.icon, bitmap);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(C0505R.C0507id.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(C0505R.C0507id.text, charSequence2);
            z4 = true;
        }
        if (charSequence3 != null) {
            remoteViews.setTextViewText(C0505R.C0507id.info, charSequence3);
            remoteViews.setViewVisibility(C0505R.C0507id.info, 0);
            z3 = true;
        } else if (i > 0) {
            if (i > context.getResources().getInteger(C0505R.integer.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(C0505R.C0507id.info, context.getResources().getString(C0505R.string.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(C0505R.C0507id.info, NumberFormat.getIntegerInstance().format((long) i));
            }
            remoteViews.setViewVisibility(C0505R.C0507id.info, 0);
            z3 = true;
        } else {
            remoteViews.setViewVisibility(C0505R.C0507id.info, 8);
            z3 = z4;
        }
        if (charSequence4 != null && Build.VERSION.SDK_INT >= 16) {
            remoteViews.setTextViewText(C0505R.C0507id.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0505R.C0507id.text2, charSequence2);
                remoteViews.setViewVisibility(C0505R.C0507id.text2, 0);
                z5 = true;
            } else {
                remoteViews.setViewVisibility(C0505R.C0507id.text2, 8);
            }
        }
        if (z5 && Build.VERSION.SDK_INT >= 16) {
            if (z2) {
                remoteViews.setTextViewTextSize(C0505R.C0507id.text, 0, (float) context.getResources().getDimensionPixelSize(C0505R.dimen.notification_subtext_size));
            }
            remoteViews.setViewPadding(C0505R.C0507id.line1, 0, 0, 0, 0);
        }
        if (j != 0) {
            if (z) {
                remoteViews.setViewVisibility(C0505R.C0507id.chronometer, 0);
                remoteViews.setLong(C0505R.C0507id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                remoteViews.setBoolean(C0505R.C0507id.chronometer, "setStarted", true);
            } else {
                remoteViews.setViewVisibility(C0505R.C0507id.time, 0);
                remoteViews.setLong(C0505R.C0507id.time, "setTime", j);
            }
        }
        remoteViews.setViewVisibility(C0505R.C0507id.line3, z3 ? 0 : 8);
        return remoteViews;
    }
}
