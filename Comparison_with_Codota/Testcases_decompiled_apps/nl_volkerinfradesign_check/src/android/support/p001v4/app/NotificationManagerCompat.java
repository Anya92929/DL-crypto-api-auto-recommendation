package android.support.p001v4.app;

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
import android.support.p001v4.app.INotificationSideChannel;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;

/* renamed from: android.support.v4.app.NotificationManagerCompat */
public class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int f362a = f368i.mo676a();

    /* renamed from: b */
    private static final Object f363b = new Object();

    /* renamed from: c */
    private static String f364c;

    /* renamed from: d */
    private static Set<String> f365d = new HashSet();

    /* renamed from: g */
    private static final Object f366g = new Object();

    /* renamed from: h */
    private static C0090h f367h;

    /* renamed from: i */
    private static final C0084b f368i;

    /* renamed from: e */
    private final Context f369e;

    /* renamed from: f */
    private final NotificationManager f370f = ((NotificationManager) this.f369e.getSystemService("notification"));

    /* renamed from: android.support.v4.app.NotificationManagerCompat$b */
    interface C0084b {
        /* renamed from: a */
        int mo676a();

        /* renamed from: a */
        void mo677a(NotificationManager notificationManager, String str, int i);

        /* renamed from: a */
        void mo678a(NotificationManager notificationManager, String str, int i, Notification notification);
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$i */
    interface C0092i {
        /* renamed from: a */
        void mo674a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f368i = new C0087e();
        } else if (Build.VERSION.SDK_INT >= 5) {
            f368i = new C0086d();
        } else {
            f368i = new C0085c();
        }
    }

    public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }

    private NotificationManagerCompat(Context context) {
        this.f369e = context;
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$c */
    static class C0085c implements C0084b {
        C0085c() {
        }

        /* renamed from: a */
        public void mo677a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        /* renamed from: a */
        public void mo678a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }

        /* renamed from: a */
        public int mo676a() {
            return 1;
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$d */
    static class C0086d extends C0085c {
        C0086d() {
        }

        /* renamed from: a */
        public void mo677a(NotificationManager notificationManager, String str, int i) {
            C0003ac.m4a(notificationManager, str, i);
        }

        /* renamed from: a */
        public void mo678a(NotificationManager notificationManager, String str, int i, Notification notification) {
            C0003ac.m5a(notificationManager, str, i, notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$e */
    static class C0087e extends C0086d {
        C0087e() {
        }

        /* renamed from: a */
        public int mo676a() {
            return 33;
        }
    }

    public void cancel(int i) {
        cancel((String) null, i);
    }

    public void cancel(String str, int i) {
        f368i.mo677a(this.f370f, str, i);
        if (Build.VERSION.SDK_INT <= 19) {
            m373a((C0092i) new C0083a(this.f369e.getPackageName(), i, str));
        }
    }

    public void cancelAll() {
        this.f370f.cancelAll();
        if (Build.VERSION.SDK_INT <= 19) {
            m373a((C0092i) new C0083a(this.f369e.getPackageName()));
        }
    }

    public void notify(int i, Notification notification) {
        notify((String) null, i, notification);
    }

    public void notify(String str, int i, Notification notification) {
        if (m374a(notification)) {
            m373a((C0092i) new C0088f(this.f369e.getPackageName(), i, str, notification));
            f368i.mo677a(this.f370f, str, i);
            return;
        }
        f368i.mo678a(this.f370f, str, i, notification);
    }

    public static Set<String> getEnabledListenerPackages(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (string != null && !string.equals(f364c)) {
            String[] split = string.split(":");
            HashSet hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (f363b) {
                f365d = hashSet;
                f364c = string;
            }
        }
        return f365d;
    }

    /* renamed from: a */
    private static boolean m374a(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    /* renamed from: a */
    private void m373a(C0092i iVar) {
        synchronized (f366g) {
            if (f367h == null) {
                f367h = new C0090h(this.f369e.getApplicationContext());
            }
        }
        f367h.mo680a(iVar);
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$h */
    static class C0090h implements ServiceConnection, Handler.Callback {

        /* renamed from: a */
        private final Context f381a;

        /* renamed from: b */
        private final HandlerThread f382b;

        /* renamed from: c */
        private final Handler f383c;

        /* renamed from: d */
        private final Map<ComponentName, C0091a> f384d = new HashMap();

        /* renamed from: e */
        private Set<String> f385e = new HashSet();

        public C0090h(Context context) {
            this.f381a = context;
            this.f382b = new HandlerThread("NotificationManagerCompat");
            this.f382b.start();
            this.f383c = new Handler(this.f382b.getLooper(), this);
        }

        /* renamed from: a */
        public void mo680a(C0092i iVar) {
            this.f383c.obtainMessage(0, iVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    m392b((C0092i) message.obj);
                    return true;
                case 1:
                    C0089g gVar = (C0089g) message.obj;
                    m388a(gVar.f379a, gVar.f380b);
                    return true;
                case 2:
                    m387a((ComponentName) message.obj);
                    return true;
                case 3:
                    m390b((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        /* renamed from: b */
        private void m392b(C0092i iVar) {
            m386a();
            for (C0091a next : this.f384d.values()) {
                next.f389d.add(iVar);
                m394d(next);
            }
        }

        /* renamed from: a */
        private void m388a(ComponentName componentName, IBinder iBinder) {
            C0091a aVar = this.f384d.get(componentName);
            if (aVar != null) {
                aVar.f388c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f390e = 0;
                m394d(aVar);
            }
        }

        /* renamed from: a */
        private void m387a(ComponentName componentName) {
            C0091a aVar = this.f384d.get(componentName);
            if (aVar != null) {
                m391b(aVar);
            }
        }

        /* renamed from: b */
        private void m390b(ComponentName componentName) {
            C0091a aVar = this.f384d.get(componentName);
            if (aVar != null) {
                m394d(aVar);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f383c.obtainMessage(1, new C0089g(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f383c.obtainMessage(2, componentName).sendToTarget();
        }

        /* renamed from: a */
        private void m386a() {
            Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.f381a);
            if (!enabledListenerPackages.equals(this.f385e)) {
                this.f385e = enabledListenerPackages;
                List<ResolveInfo> queryIntentServices = this.f381a.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 4);
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
                    if (!this.f384d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f384d.put(componentName2, new C0091a(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, C0091a>> it = this.f384d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next2 = it.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next2.getKey());
                        }
                        m391b((C0091a) next2.getValue());
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: a */
        private boolean m389a(C0091a aVar) {
            if (aVar.f387b) {
                return true;
            }
            aVar.f387b = this.f381a.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(aVar.f386a), this, NotificationManagerCompat.f362a);
            if (aVar.f387b) {
                aVar.f390e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f386a);
                this.f381a.unbindService(this);
            }
            return aVar.f387b;
        }

        /* renamed from: b */
        private void m391b(C0091a aVar) {
            if (aVar.f387b) {
                this.f381a.unbindService(this);
                aVar.f387b = false;
            }
            aVar.f388c = null;
        }

        /* renamed from: c */
        private void m393c(C0091a aVar) {
            if (!this.f383c.hasMessages(3, aVar.f386a)) {
                aVar.f390e++;
                if (aVar.f390e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.f389d.size() + " tasks to " + aVar.f386a + " after " + aVar.f390e + " retries");
                    aVar.f389d.clear();
                    return;
                }
                int i = (1 << (aVar.f390e - 1)) * LogTable.MAX_SIZE;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f383c.sendMessageDelayed(this.f383c.obtainMessage(3, aVar.f386a), (long) i);
            }
        }

        /* renamed from: d */
        private void m394d(C0091a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f386a + ", " + aVar.f389d.size() + " queued tasks");
            }
            if (!aVar.f389d.isEmpty()) {
                if (!m389a(aVar) || aVar.f388c == null) {
                    m393c(aVar);
                    return;
                }
                while (true) {
                    C0092i peek = aVar.f389d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.mo674a(aVar.f388c);
                        aVar.f389d.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f386a);
                        }
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f386a, e2);
                    }
                }
                if (!aVar.f389d.isEmpty()) {
                    m393c(aVar);
                }
            }
        }

        /* renamed from: android.support.v4.app.NotificationManagerCompat$h$a */
        static class C0091a {

            /* renamed from: a */
            public final ComponentName f386a;

            /* renamed from: b */
            public boolean f387b = false;

            /* renamed from: c */
            public INotificationSideChannel f388c;

            /* renamed from: d */
            public LinkedList<C0092i> f389d = new LinkedList<>();

            /* renamed from: e */
            public int f390e = 0;

            public C0091a(ComponentName componentName) {
                this.f386a = componentName;
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$g */
    static class C0089g {

        /* renamed from: a */
        final ComponentName f379a;

        /* renamed from: b */
        final IBinder f380b;

        public C0089g(ComponentName componentName, IBinder iBinder) {
            this.f379a = componentName;
            this.f380b = iBinder;
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$f */
    static class C0088f implements C0092i {

        /* renamed from: a */
        final String f375a;

        /* renamed from: b */
        final int f376b;

        /* renamed from: c */
        final String f377c;

        /* renamed from: d */
        final Notification f378d;

        public C0088f(String str, int i, String str2, Notification notification) {
            this.f375a = str;
            this.f376b = i;
            this.f377c = str2;
            this.f378d = notification;
        }

        /* renamed from: a */
        public void mo674a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f375a, this.f376b, this.f377c, this.f378d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:").append(this.f375a);
            sb.append(", id:").append(this.f376b);
            sb.append(", tag:").append(this.f377c);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$a */
    static class C0083a implements C0092i {

        /* renamed from: a */
        final String f371a;

        /* renamed from: b */
        final int f372b;

        /* renamed from: c */
        final String f373c;

        /* renamed from: d */
        final boolean f374d;

        public C0083a(String str) {
            this.f371a = str;
            this.f372b = 0;
            this.f373c = null;
            this.f374d = true;
        }

        public C0083a(String str, int i, String str2) {
            this.f371a = str;
            this.f372b = i;
            this.f373c = str2;
            this.f374d = false;
        }

        /* renamed from: a */
        public void mo674a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.f374d) {
                iNotificationSideChannel.cancelAll(this.f371a);
            } else {
                iNotificationSideChannel.cancel(this.f371a, this.f372b, this.f373c);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CancelTask[");
            sb.append("packageName:").append(this.f371a);
            sb.append(", id:").append(this.f372b);
            sb.append(", tag:").append(this.f373c);
            sb.append(", all:").append(this.f374d);
            sb.append("]");
            return sb.toString();
        }
    }
}
