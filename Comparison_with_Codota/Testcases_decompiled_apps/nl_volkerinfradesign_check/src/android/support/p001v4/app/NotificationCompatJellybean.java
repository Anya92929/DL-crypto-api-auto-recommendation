package android.support.p001v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p001v4.app.NotificationCompatBase;
import android.support.p001v4.app.RemoteInputCompatBase;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompatJellybean */
class NotificationCompatJellybean {

    /* renamed from: a */
    private static final Object f345a = new Object();

    /* renamed from: b */
    private static Field f346b;

    /* renamed from: c */
    private static boolean f347c;

    /* renamed from: d */
    private static final Object f348d = new Object();

    /* renamed from: e */
    private static Class<?> f349e;

    /* renamed from: f */
    private static Field f350f;

    /* renamed from: g */
    private static Field f351g;

    /* renamed from: h */
    private static Field f352h;

    /* renamed from: i */
    private static Field f353i;

    /* renamed from: j */
    private static boolean f354j;

    /* renamed from: android.support.v4.app.NotificationCompatJellybean$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, C2018z {

        /* renamed from: a */
        private Notification.Builder f355a;

        /* renamed from: b */
        private final Bundle f356b;

        /* renamed from: c */
        private List<Bundle> f357c = new ArrayList();

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            Notification.Builder lights = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            Notification.Builder ongoing = lights.setOngoing(z5);
            if ((notification.flags & 8) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z6);
            if ((notification.flags & 16) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z7).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            this.f355a = deleteIntent.setFullScreenIntent(pendingIntent2, z8).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f356b = new Bundle();
            if (bundle != null) {
                this.f356b.putAll(bundle);
            }
            if (z3) {
                this.f356b.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str != null) {
                this.f356b.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                if (z4) {
                    this.f356b.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    this.f356b.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str2 != null) {
                this.f356b.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
            }
        }

        public void addAction(NotificationCompatBase.Action action) {
            this.f357c.add(NotificationCompatJellybean.m344a(this.f355a, action));
        }

        public Notification.Builder getBuilder() {
            return this.f355a;
        }

        public Notification build() {
            Notification build = this.f355a.build();
            Bundle a = NotificationCompatJellybean.m345a(build);
            Bundle bundle = new Bundle(this.f356b);
            for (String str : this.f356b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray<Bundle> a2 = NotificationCompatJellybean.m350a(this.f357c);
            if (a2 != null) {
                NotificationCompatJellybean.m345a(build).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, a2);
            }
            return build;
        }
    }

    /* renamed from: a */
    public static void m353a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    /* renamed from: a */
    public static void m352a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    /* renamed from: a */
    public static void m354a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    /* renamed from: a */
    public static SparseArray<Bundle> m350a(List<Bundle> list) {
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

    /* renamed from: a */
    public static Bundle m345a(Notification notification) {
        synchronized (f345a) {
            if (f347c) {
                return null;
            }
            try {
                if (f346b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f347c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f346b = declaredField;
                }
                Bundle bundle = (Bundle) f346b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f346b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f347c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f347c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static NotificationCompatBase.Action m349a(NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2, int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        RemoteInputCompatBase.RemoteInput[] remoteInputArr = null;
        if (bundle != null) {
            remoteInputArr = C0005ae.m15a(C2000u.m7564a(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS), factory2);
        }
        return factory.build(i, charSequence, pendingIntent, bundle, remoteInputArr);
    }

    /* renamed from: a */
    public static Bundle m344a(Notification.Builder builder, NotificationCompatBase.Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, C0005ae.m14a(action.getRemoteInputs()));
        }
        return bundle;
    }

    /* renamed from: b */
    public static int m357b(Notification notification) {
        int length;
        synchronized (f348d) {
            Object[] g = m362g(notification);
            length = g != null ? g.length : 0;
        }
        return length;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p001v4.app.NotificationCompatBase.Action m347a(android.app.Notification r8, int r9, android.support.p001v4.app.NotificationCompatBase.Action.Factory r10, android.support.p001v4.app.RemoteInputCompatBase.RemoteInput.Factory r11) {
        /*
            r6 = 0
            java.lang.Object r7 = f348d
            monitor-enter(r7)
            java.lang.Object[] r0 = m362g(r8)     // Catch:{ IllegalAccessException -> 0x003d }
            r1 = r0[r9]     // Catch:{ IllegalAccessException -> 0x003d }
            android.os.Bundle r0 = m345a((android.app.Notification) r8)     // Catch:{ IllegalAccessException -> 0x003d }
            if (r0 == 0) goto L_0x004e
            java.lang.String r2 = "android.support.actionExtras"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r2)     // Catch:{ IllegalAccessException -> 0x003d }
            if (r0 == 0) goto L_0x004e
            java.lang.Object r0 = r0.get(r9)     // Catch:{ IllegalAccessException -> 0x003d }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ IllegalAccessException -> 0x003d }
            r5 = r0
        L_0x001f:
            java.lang.reflect.Field r0 = f351g     // Catch:{ IllegalAccessException -> 0x003d }
            int r2 = r0.getInt(r1)     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.reflect.Field r0 = f352h     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.Object r3 = r0.get(r1)     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.reflect.Field r0 = f353i     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.Object r4 = r0.get(r1)     // Catch:{ IllegalAccessException -> 0x003d }
            android.app.PendingIntent r4 = (android.app.PendingIntent) r4     // Catch:{ IllegalAccessException -> 0x003d }
            r0 = r10
            r1 = r11
            android.support.v4.app.NotificationCompatBase$Action r0 = m349a(r0, r1, r2, r3, r4, r5)     // Catch:{ IllegalAccessException -> 0x003d }
            monitor-exit(r7)     // Catch:{ all -> 0x004b }
        L_0x003c:
            return r0
        L_0x003d:
            r0 = move-exception
            java.lang.String r1 = "NotificationCompat"
            java.lang.String r2 = "Unable to access notification actions"
            android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x004b }
            r0 = 1
            f354j = r0     // Catch:{ all -> 0x004b }
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.app.NotificationCompatJellybean.m347a(android.app.Notification, int, android.support.v4.app.NotificationCompatBase$Action$Factory, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory):android.support.v4.app.NotificationCompatBase$Action");
    }

    /* renamed from: g */
    private static Object[] m362g(Notification notification) {
        synchronized (f348d) {
            if (!m355a()) {
                return null;
            }
            try {
                Object[] objArr = (Object[]) f350f.get(notification);
                return objArr;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification actions", e);
                f354j = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    private static boolean m355a() {
        boolean z = true;
        if (f354j) {
            return false;
        }
        try {
            if (f350f == null) {
                f349e = Class.forName("android.app.Notification$Action");
                f351g = f349e.getDeclaredField("icon");
                f352h = f349e.getDeclaredField("title");
                f353i = f349e.getDeclaredField("actionIntent");
                f350f = Notification.class.getDeclaredField("actions");
                f350f.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            Log.e("NotificationCompat", "Unable to access notification actions", e);
            f354j = true;
        } catch (NoSuchFieldException e2) {
            Log.e("NotificationCompat", "Unable to access notification actions", e2);
            f354j = true;
        }
        if (f354j) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public static NotificationCompatBase.Action[] m356a(ArrayList<Parcelable> arrayList, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
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
            newArray[i2] = m348a((Bundle) arrayList.get(i2), factory, factory2);
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private static NotificationCompatBase.Action m348a(Bundle bundle, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return factory.build(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), C0005ae.m15a(C2000u.m7564a(bundle, "remoteInputs"), factory2));
    }

    /* renamed from: a */
    public static ArrayList<Parcelable> m351a(NotificationCompatBase.Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList<>(actionArr.length);
        for (NotificationCompatBase.Action a : actionArr) {
            arrayList.add(m346a(a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static Bundle m346a(NotificationCompatBase.Action action) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", action.getIcon());
        bundle.putCharSequence("title", action.getTitle());
        bundle.putParcelable("actionIntent", action.getActionIntent());
        bundle.putBundle("extras", action.getExtras());
        bundle.putParcelableArray("remoteInputs", C0005ae.m14a(action.getRemoteInputs()));
        return bundle;
    }

    /* renamed from: c */
    public static boolean m358c(Notification notification) {
        return m345a(notification).getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    }

    /* renamed from: d */
    public static String m359d(Notification notification) {
        return m345a(notification).getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    }

    /* renamed from: e */
    public static boolean m360e(Notification notification) {
        return m345a(notification).getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    }

    /* renamed from: f */
    public static String m361f(Notification notification) {
        return m345a(notification).getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    }
}
