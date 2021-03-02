package android.support.p000v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.p000v4.app.INotificationSideChannel;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.app.NotificationManagerCompat */
public class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int f661a = f667i.getSideChannelBindFlags();

    /* renamed from: b */
    private static final Object f662b = new Object();

    /* renamed from: c */
    private static String f663c;

    /* renamed from: d */
    private static Set<String> f664d = new HashSet();

    /* renamed from: g */
    private static final Object f665g = new Object();

    /* renamed from: h */
    private static SideChannelManager f666h;

    /* renamed from: i */
    private static final Impl f667i;

    /* renamed from: e */
    private final Context f668e;

    /* renamed from: f */
    private final NotificationManager f669f = ((NotificationManager) this.f668e.getSystemService("notification"));

    /* renamed from: android.support.v4.app.NotificationManagerCompat$CancelTask */
    class CancelTask implements Task {

        /* renamed from: a */
        final String f670a;

        /* renamed from: b */
        final int f671b;

        /* renamed from: c */
        final String f672c;

        /* renamed from: d */
        final boolean f673d;

        public CancelTask(String str) {
            this.f670a = str;
            this.f671b = 0;
            this.f672c = null;
            this.f673d = true;
        }

        public CancelTask(String str, int i, String str2) {
            this.f670a = str;
            this.f671b = i;
            this.f672c = str2;
            this.f673d = false;
        }

        public void send(INotificationSideChannel iNotificationSideChannel) {
            if (this.f673d) {
                iNotificationSideChannel.cancelAll(this.f670a);
            } else {
                iNotificationSideChannel.cancel(this.f670a, this.f671b, this.f672c);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CancelTask[");
            sb.append("packageName:").append(this.f670a);
            sb.append(", id:").append(this.f671b);
            sb.append(", tag:").append(this.f672c);
            sb.append(", all:").append(this.f673d);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$Impl */
    interface Impl {
        void cancelNotification(NotificationManager notificationManager, String str, int i);

        int getSideChannelBindFlags();

        void postNotification(NotificationManager notificationManager, String str, int i, Notification notification);
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$ImplBase */
    class ImplBase implements Impl {
        ImplBase() {
        }

        public void cancelNotification(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        public int getSideChannelBindFlags() {
            return 1;
        }

        public void postNotification(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$ImplEclair */
    class ImplEclair extends ImplBase {
        ImplEclair() {
        }

        public void cancelNotification(NotificationManager notificationManager, String str, int i) {
            NotificationManagerCompatEclair.m588a(notificationManager, str, i);
        }

        public void postNotification(NotificationManager notificationManager, String str, int i, Notification notification) {
            NotificationManagerCompatEclair.postNotification(notificationManager, str, i, notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$ImplIceCreamSandwich */
    class ImplIceCreamSandwich extends ImplEclair {
        ImplIceCreamSandwich() {
        }

        public int getSideChannelBindFlags() {
            return 33;
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$NotifyTask */
    class NotifyTask implements Task {

        /* renamed from: a */
        final String f674a;

        /* renamed from: b */
        final int f675b;

        /* renamed from: c */
        final String f676c;

        /* renamed from: d */
        final Notification f677d;

        public NotifyTask(String str, int i, String str2, Notification notification) {
            this.f674a = str;
            this.f675b = i;
            this.f676c = str2;
            this.f677d = notification;
        }

        public void send(INotificationSideChannel iNotificationSideChannel) {
            iNotificationSideChannel.notify(this.f674a, this.f675b, this.f676c, this.f677d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:").append(this.f674a);
            sb.append(", id:").append(this.f675b);
            sb.append(", tag:").append(this.f676c);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$ServiceConnectedEvent */
    class ServiceConnectedEvent {

        /* renamed from: a */
        final ComponentName f678a;

        /* renamed from: b */
        final IBinder f679b;

        public ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.f678a = componentName;
            this.f679b = iBinder;
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$SideChannelManager */
    class SideChannelManager implements ServiceConnection, Handler.Callback {

        /* renamed from: a */
        private final Context f680a;

        /* renamed from: b */
        private final HandlerThread f681b;

        /* renamed from: c */
        private final Handler f682c;

        /* renamed from: d */
        private final Map<ComponentName, ListenerRecord> f683d = new HashMap();

        /* renamed from: e */
        private Set<String> f684e = new HashSet();

        /* renamed from: android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord */
        class ListenerRecord {
            public boolean bound = false;
            public final ComponentName componentName;
            public int retryCount = 0;
            public INotificationSideChannel service;
            public LinkedList<Task> taskQueue = new LinkedList<>();

            public ListenerRecord(ComponentName componentName2) {
                this.componentName = componentName2;
            }
        }

        public SideChannelManager(Context context) {
            this.f680a = context;
            this.f681b = new HandlerThread("NotificationManagerCompat");
            this.f681b.start();
            this.f682c = new Handler(this.f681b.getLooper(), this);
        }

        /* renamed from: a */
        private void m579a() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.f680a);
            if (!enabledListenerPackages.equals(this.f684e)) {
                this.f684e = enabledListenerPackages;
                List<ResolveInfo> queryIntentServices = this.f680a.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 4);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (enabledListenerPackages.contains(next.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(next.serviceInfo.packageName, next.serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f683d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f683d.put(componentName2, new ListenerRecord(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, ListenerRecord>> it = this.f683d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next2 = it.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next2.getKey());
                        }
                        m585b((ListenerRecord) next2.getValue());
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: a */
        private void m580a(ComponentName componentName) {
            ListenerRecord listenerRecord = this.f683d.get(componentName);
            if (listenerRecord != null) {
                m585b(listenerRecord);
            }
        }

        /* renamed from: a */
        private void m581a(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = this.f683d.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.service = INotificationSideChannel.Stub.asInterface(iBinder);
                listenerRecord.retryCount = 0;
                m587d(listenerRecord);
            }
        }

        /* renamed from: a */
        private void m582a(Task task) {
            m579a();
            for (ListenerRecord next : this.f683d.values()) {
                next.taskQueue.add(task);
                m587d(next);
            }
        }

        /* renamed from: a */
        private boolean m583a(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                return true;
            }
            listenerRecord.bound = this.f680a.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.componentName), this, NotificationManagerCompat.f661a);
            if (listenerRecord.bound) {
                listenerRecord.retryCount = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.componentName);
                this.f680a.unbindService(this);
            }
            return listenerRecord.bound;
        }

        /* renamed from: b */
        private void m584b(ComponentName componentName) {
            ListenerRecord listenerRecord = this.f683d.get(componentName);
            if (listenerRecord != null) {
                m587d(listenerRecord);
            }
        }

        /* renamed from: b */
        private void m585b(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                this.f680a.unbindService(this);
                listenerRecord.bound = false;
            }
            listenerRecord.service = null;
        }

        /* renamed from: c */
        private void m586c(ListenerRecord listenerRecord) {
            if (!this.f682c.hasMessages(3, listenerRecord.componentName)) {
                listenerRecord.retryCount++;
                if (listenerRecord.retryCount > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.taskQueue.size() + " tasks to " + listenerRecord.componentName + " after " + listenerRecord.retryCount + " retries");
                    listenerRecord.taskQueue.clear();
                    return;
                }
                int i = (1 << (listenerRecord.retryCount - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f682c.sendMessageDelayed(this.f682c.obtainMessage(3, listenerRecord.componentName), (long) i);
            }
        }

        /* renamed from: d */
        private void m587d(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + listenerRecord.componentName + ", " + listenerRecord.taskQueue.size() + " queued tasks");
            }
            if (!listenerRecord.taskQueue.isEmpty()) {
                if (!m583a(listenerRecord) || listenerRecord.service == null) {
                    m586c(listenerRecord);
                    return;
                }
                while (true) {
                    Task peek = listenerRecord.taskQueue.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.send(listenerRecord.service);
                        listenerRecord.taskQueue.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.componentName);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.componentName, e2);
                    }
                }
                if (!listenerRecord.taskQueue.isEmpty()) {
                    m586c(listenerRecord);
                }
            }
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    m582a((Task) message.obj);
                    return true;
                case 1:
                    ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                    m581a(serviceConnectedEvent.f678a, serviceConnectedEvent.f679b);
                    return true;
                case 2:
                    m580a((ComponentName) message.obj);
                    return true;
                case 3:
                    m584b((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f682c.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f682c.obtainMessage(2, componentName).sendToTarget();
        }

        public void queueTask(Task task) {
            this.f682c.obtainMessage(0, task).sendToTarget();
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$Task */
    interface Task {
        void send(INotificationSideChannel iNotificationSideChannel);
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f667i = new ImplIceCreamSandwich();
        } else if (Build.VERSION.SDK_INT >= 5) {
            f667i = new ImplEclair();
        } else {
            f667i = new ImplBase();
        }
    }

    private NotificationManagerCompat(Context context) {
        this.f668e = context;
    }

    /* renamed from: a */
    private void m577a(Task task) {
        synchronized (f665g) {
            if (f666h == null) {
                f666h = new SideChannelManager(this.f668e.getApplicationContext());
            }
        }
        f666h.queueTask(task);
    }

    /* renamed from: a */
    private static boolean m578a(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }

    public static Set<String> getEnabledListenerPackages(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (string != null && !string.equals(f663c)) {
            String[] split = string.split(":");
            HashSet hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (f662b) {
                f664d = hashSet;
                f663c = string;
            }
        }
        return f664d;
    }

    public void cancel(int i) {
        cancel((String) null, i);
    }

    public void cancel(String str, int i) {
        f667i.cancelNotification(this.f669f, str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            m577a((Task) new CancelTask(this.f668e.getPackageName(), i, str));
        }
    }

    public void cancelAll() {
        this.f669f.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            m577a((Task) new CancelTask(this.f668e.getPackageName()));
        }
    }

    public void notify(int i, Notification notification) {
        notify((String) null, i, notification);
    }

    public void notify(String str, int i, Notification notification) {
        if (m578a(notification)) {
            m577a((Task) new NotifyTask(this.f668e.getPackageName(), i, str, notification));
            f667i.cancelNotification(this.f669f, str, i);
            return;
        }
        f667i.postNotification(this.f669f, str, i, notification);
    }
}
