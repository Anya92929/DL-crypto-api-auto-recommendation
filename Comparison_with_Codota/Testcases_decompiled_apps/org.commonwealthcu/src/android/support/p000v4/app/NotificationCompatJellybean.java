package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p000v4.app.NotificationCompatBase;
import android.support.p000v4.app.RemoteInputCompatBase;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompatJellybean */
class NotificationCompatJellybean {
    static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
    static final String EXTRA_GROUP_KEY = "android.support.groupKey";
    static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
    static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
    static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
    static final String EXTRA_SORT_KEY = "android.support.sortKey";
    static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Class sActionClass;
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock = new Object();
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = new Object();

    /* renamed from: android.support.v4.app.NotificationCompatJellybean$Builder */
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {

        /* renamed from: b */
        private Notification.Builder f3b;
        private List mActionExtrasList = new ArrayList();
        private final Bundle mExtras;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            this.f3b = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.mExtras = new Bundle();
            if (bundle != null) {
                this.mExtras.putAll(bundle);
            }
            if (z3) {
                this.mExtras.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.mExtras.putString("android.support.groupKey", str);
                if (z4) {
                    this.mExtras.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.mExtras.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.mExtras.putString("android.support.sortKey", str2);
            }
        }

        public void addAction(NotificationCompatBase.Action action) {
            this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.f3b, action));
        }

        public Notification build() {
            Notification build = this.f3b.build();
            Bundle extras = NotificationCompatJellybean.getExtras(build);
            Bundle bundle = new Bundle(this.mExtras);
            for (String str : this.mExtras.keySet()) {
                if (extras.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            extras.putAll(bundle);
            SparseArray buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (buildActionExtrasMap != null) {
                NotificationCompatJellybean.getExtras(build).putSparseParcelableArray("android.support.actionExtras", buildActionExtrasMap);
            }
            return build;
        }

        public Notification.Builder getBuilder() {
            return this.f3b;
        }
    }

    NotificationCompatJellybean() {
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

    public static void addInboxStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList arrayList) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray buildActionExtrasMap(List list) {
        SparseArray sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed) {
            return false;
        }
        try {
            if (sActionsField == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                sActionClass = cls;
                sActionIconField = cls.getDeclaredField(KEY_ICON);
                sActionTitleField = sActionClass.getDeclaredField(KEY_TITLE);
                sActionIntentField = sActionClass.getDeclaredField(KEY_ACTION_INTENT);
                Field declaredField = Notification.class.getDeclaredField("actions");
                sActionsField = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "Unable to access notification actions", e);
            sActionsAccessFailed = true;
        } catch (NoSuchFieldException e2) {
            Log.e(TAG, "Unable to access notification actions", e2);
            sActionsAccessFailed = true;
        }
        return !sActionsAccessFailed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r0 = r0.getSparseParcelableArray("android.support.actionExtras");
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.app.NotificationCompatBase.Action getAction(android.app.Notification r8, int r9, android.support.p000v4.app.NotificationCompatBase.Action.Factory r10, android.support.p000v4.app.RemoteInputCompatBase.RemoteInput.Factory r11) {
        /*
            r6 = 0
            java.lang.Object r7 = sActionsLock
            monitor-enter(r7)
            java.lang.Object[] r0 = getActionObjectsLocked(r8)     // Catch:{ IllegalAccessException -> 0x003d }
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
            java.lang.reflect.Field r0 = sActionIconField     // Catch:{ IllegalAccessException -> 0x003d }
            int r2 = r0.getInt(r1)     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.reflect.Field r0 = sActionTitleField     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.Object r3 = r0.get(r1)     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.reflect.Field r0 = sActionIntentField     // Catch:{ IllegalAccessException -> 0x003d }
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
            sActionsAccessFailed = r0     // Catch:{ all -> 0x004b }
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
        synchronized (sActionsLock) {
            Object[] actionObjectsLocked = getActionObjectsLocked(notification);
            length = actionObjectsLocked != null ? actionObjectsLocked.length : 0;
        }
        return length;
    }

    private static NotificationCompatBase.Action getActionFromBundle(Bundle bundle, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return factory.build(bundle.getInt(KEY_ICON), bundle.getCharSequence(KEY_TITLE), (PendingIntent) bundle.getParcelable(KEY_ACTION_INTENT), bundle.getBundle(KEY_EXTRAS), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, KEY_REMOTE_INPUTS), factory2));
    }

    private static Object[] getActionObjectsLocked(Notification notification) {
        synchronized (sActionsLock) {
            if (!ensureActionReflectionReadyLocked()) {
                return null;
            }
            try {
                Object[] objArr = (Object[]) sActionsField.get(notification);
                return objArr;
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to access notification actions", e);
                sActionsAccessFailed = true;
                return null;
            }
        }
    }

    public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList arrayList, NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
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
            newArray[i2] = getActionFromBundle((Bundle) arrayList.get(i2), factory, factory2);
            i = i2 + 1;
        }
    }

    private static Bundle getBundleForAction(NotificationCompatBase.Action action) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ICON, action.getIcon());
        bundle.putCharSequence(KEY_TITLE, action.getTitle());
        bundle.putParcelable(KEY_ACTION_INTENT, action.getActionIntent());
        bundle.putBundle(KEY_EXTRAS, action.getExtras());
        bundle.putParcelableArray(KEY_REMOTE_INPUTS, RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        return bundle;
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (sExtrasLock) {
            if (sExtrasFieldAccessFailed) {
                return null;
            }
            try {
                if (sExtrasField == null) {
                    Field declaredField = Notification.class.getDeclaredField(KEY_EXTRAS);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(TAG, "Notification.extras field is not of type Bundle");
                        sExtrasFieldAccessFailed = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    sExtrasField = declaredField;
                }
                Bundle bundle = (Bundle) sExtrasField.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    sExtrasField.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e(TAG, "Unable to access notification extras", e);
                sExtrasFieldAccessFailed = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e(TAG, "Unable to access notification extras", e2);
                sExtrasFieldAccessFailed = true;
                return null;
            }
        }
    }

    public static String getGroup(Notification notification) {
        return getExtras(notification).getString("android.support.groupKey");
    }

    public static boolean getLocalOnly(Notification notification) {
        return getExtras(notification).getBoolean("android.support.localOnly");
    }

    public static ArrayList getParcelableArrayListForActions(NotificationCompatBase.Action[] actionArr) {
        if (actionArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(actionArr.length);
        for (NotificationCompatBase.Action bundleForAction : actionArr) {
            arrayList.add(getBundleForAction(bundleForAction));
        }
        return arrayList;
    }

    public static String getSortKey(Notification notification) {
        return getExtras(notification).getString("android.support.sortKey");
    }

    public static boolean isGroupSummary(Notification notification) {
        return getExtras(notification).getBoolean("android.support.isGroupSummary");
    }

    public static NotificationCompatBase.Action readAction(NotificationCompatBase.Action.Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2, int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        RemoteInputCompatBase.RemoteInput[] remoteInputArr = null;
        if (bundle != null) {
            remoteInputArr = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle, "android.support.remoteInputs"), factory2);
        }
        return factory.build(i, charSequence, pendingIntent, bundle, remoteInputArr);
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompatBase.Action action) {
        builder.addAction(action.getIcon(), action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.toBundleArray(action.getRemoteInputs()));
        }
        return bundle;
    }
}
