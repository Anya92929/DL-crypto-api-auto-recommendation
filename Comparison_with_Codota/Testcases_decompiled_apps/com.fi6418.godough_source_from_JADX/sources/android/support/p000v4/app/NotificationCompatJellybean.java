package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.NotificationCompatBase;
import android.support.p000v4.app.RemoteInputCompatBase;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.jackhenry.godough.core.rda.ImageViewActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompatJellybean */
class NotificationCompatJellybean {
    public static final String TAG = "NotificationCompat";

    /* renamed from: a */
    private static final Object f644a = new Object();

    /* renamed from: b */
    private static Field f645b;

    /* renamed from: c */
    private static boolean f646c;

    /* renamed from: d */
    private static final Object f647d = new Object();

    /* renamed from: e */
    private static Class<?> f648e;

    /* renamed from: f */
    private static Field f649f;

    /* renamed from: g */
    private static Field f650g;

    /* renamed from: h */
    private static Field f651h;

    /* renamed from: i */
    private static Field f652i;

    /* renamed from: j */
    private static boolean f653j;

    /* renamed from: android.support.v4.app.NotificationCompatJellybean$Builder */
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {

        /* renamed from: a */
        private Notification.Builder f654a;

        /* renamed from: b */
        private final Bundle f655b;

        /* renamed from: c */
        private List<Bundle> f656c = new ArrayList();

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            this.f654a = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f655b = new Bundle();
            if (bundle != null) {
                this.f655b.putAll(bundle);
            }
            if (z3) {
                this.f655b.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str != null) {
                this.f655b.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                if (z4) {
                    this.f655b.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    this.f655b.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str2 != null) {
                this.f655b.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
            }
        }

        public void addAction(NotificationCompatBase.Action action) {
            this.f656c.add(NotificationCompatJellybean.writeActionAndGetExtras(this.f654a, action));
        }

        public Notification build() {
            Notification build = this.f654a.build();
            Bundle extras = NotificationCompatJellybean.getExtras(build);
            Bundle bundle = new Bundle(this.f655b);
            for (String str : this.f655b.keySet()) {
                if (extras.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            extras.putAll(bundle);
            SparseArray<Bundle> buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.f656c);
            if (buildActionExtrasMap != null) {
                NotificationCompatJellybean.getExtras(build).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap);
            }
            return build;
        }

        public Notification.Builder getBuilder() {
            return this.f654a;
        }
    }

    NotificationCompatJellybean() {
    }

    /* renamed from: a */
    private static Bundle m570a(NotificationCompatBase.Action action) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", action.getIcon());
        bundle.putCharSequence(ImageViewActivity.PARAM_TITLE, action.getTitle());
        bundle.putParcelable("actionIntent", action.getActionIntent());
        bundle.putBundle("extras", action.getExtras());
        bundle.putParcelableArray("remoteInputs", RemoteInputCompatJellybean.m597a(action.getRemoteInputs()));
        return bundle;
    }

    /* renamed from: a */
    private static NotificationCompatBase.Action m571a(Bundle bundle, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return factory.build(bundle.getInt("icon"), bundle.getCharSequence(ImageViewActivity.PARAM_TITLE), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), RemoteInputCompatJellybean.m598a(BundleUtil.getBundleArrayFromBundle(bundle, "remoteInputs"), factory2));
    }

    /* renamed from: a */
    private static boolean m572a() {
        boolean z = true;
        if (f653j) {
            return false;
        }
        try {
            if (f649f == null) {
                f648e = Class.forName("android.app.Notification$Action");
                f650g = f648e.getDeclaredField("icon");
                f651h = f648e.getDeclaredField(ImageViewActivity.PARAM_TITLE);
                f652i = f648e.getDeclaredField("actionIntent");
                f649f = Notification.class.getDeclaredField("actions");
                f649f.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Unable to access notification actions", e);
            f653j = true;
        } catch (NoSuchFieldException e2) {
            Log.e(TAG, "Unable to access notification actions", e2);
            f653j = true;
        }
        if (f653j) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private static Object[] m573a(Notification notification) {
        synchronized (f647d) {
            if (!m572a()) {
                return null;
            }
            try {
                Object[] objArr = (Object[]) f649f.get(notification);
                return objArr;
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to access notification actions", e);
                f653j = true;
                return null;
            }
        }
    }

    public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void addInboxStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r0 = r0.getSparseParcelableArray(android.support.p000v4.app.NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.app.NotificationCompatBase.Action getAction(android.app.Notification r8, int r9, android.support.p000v4.app.NotificationCompatBase.Action.Factory r10, android.support.p000v4.app.RemoteInputCompatBase.RemoteInput.Factory r11) {
        /*
            r6 = 0
            java.lang.Object r7 = f647d
            monitor-enter(r7)
            java.lang.Object[] r0 = m573a((android.app.Notification) r8)     // Catch:{ IllegalAccessException -> 0x003d }
            r1 = r0[r9]     // Catch:{ IllegalAccessException -> 0x003d }
            android.os.Bundle r0 = getExtras(r8)     // Catch:{ IllegalAccessException -> 0x003d }
            if (r0 == 0) goto L_0x004e
            java.lang.String r2 = "android.support.actionExtras"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r2)     // Catch:{ IllegalAccessException -> 0x003d }
            if (r0 == 0) goto L_0x004e
            java.lang.Object r0 = r0.get(r9)     // Catch:{ IllegalAccessException -> 0x003d }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ IllegalAccessException -> 0x003d }
            r5 = r0
        L_0x001f:
            java.lang.reflect.Field r0 = f650g     // Catch:{ IllegalAccessException -> 0x003d }
            int r2 = r0.getInt(r1)     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.reflect.Field r0 = f651h     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.Object r3 = r0.get(r1)     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.reflect.Field r0 = f652i     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.Object r4 = r0.get(r1)     // Catch:{ IllegalAccessException -> 0x003d }
            android.app.PendingIntent r4 = (android.app.PendingIntent) r4     // Catch:{ IllegalAccessException -> 0x003d }
            r0 = r10
            r1 = r11
            android.support.v4.app.NotificationCompatBase$Action r0 = readAction(r0, r1, r2, r3, r4, r5)     // Catch:{ IllegalAccessException -> 0x003d }
            monitor-exit(r7)     // Catch:{ all -> 0x004b }
        L_0x003c:
            return r0
        L_0x003d:
            r0 = move-exception
            java.lang.String r1 = "NotificationCompat"
            java.lang.String r2 = "Unable to access notification actions"
            android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x004b }
            r0 = 1
            f653j = r0     // Catch:{ all -> 0x004b }
            monitor-exit(r7)     // Catch:{ all -> 0x004b }
            r0 = r6
            goto L_0x003c
        L_0x004b:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x004b }
            throw r0
        L_0x004e:
            r5 = r6
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.NotificationCompatJellybean.getAction(android.app.Notification, int, android.support.v4.app.NotificationCompatBase$Action$Factory, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory):android.support.v4.app.NotificationCompatBase$Action");
    }

    public static int getActionCount(Notification notification) {
        int length;
        synchronized (f647d) {
            Object[] a = m573a(notification);
            length = a != null ? a.length : 0;
        }
        return length;
    }

    public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        if (arrayList == null) {
            return null;
        }
        NotificationCompatBase.Action[] newArray = factory.newArray(arrayList.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= newArray.length) {
                return newArray;
            }
            newArray[i2] = m571a((Bundle) arrayList.get(i2), factory, factory2);
            i = i2 + 1;
        }
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (f644a) {
            if (f646c) {
                return null;
            }
            try {
                if (f645b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(TAG, "Notification.extras field is not of type Bundle");
                        f646c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f645b = declaredField;
                }
                Bundle bundle = (Bundle) f645b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f645b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to access notification extras", e);
                f646c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e(TAG, "Unable to access notification extras", e2);
                f646c = true;
                return null;
            }
        }
    }

    public static String getGroup(Notification notification) {
        return getExtras(notification).getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    }

    public static boolean getLocalOnly(Notification notification) {
        return getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    }

    public static ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompatBase.Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList<>(actionArr.length);
        for (NotificationCompatBase.Action a : actionArr) {
            arrayList.add(m570a(a));
        }
        return arrayList;
    }

    public static String getSortKey(Notification notification) {
        return getExtras(notification).getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    }

    public static boolean isGroupSummary(Notification notification) {
        return getExtras(notification).getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    }

    public static NotificationCompatBase.Action readAction(NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2, int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        RemoteInputCompatBase.RemoteInput[] remoteInputArr = null;
        if (bundle != null) {
            remoteInputArr = RemoteInputCompatJellybean.m598a(BundleUtil.getBundleArrayFromBundle(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS), factory2);
        }
        return factory.build(i, charSequence, pendingIntent, bundle, remoteInputArr);
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompatBase.Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, RemoteInputCompatJellybean.m597a(action.getRemoteInputs()));
        }
        return bundle;
    }
}
