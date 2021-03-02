package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.C1015f;
import com.google.android.gms.p018c.C0614ac;
import com.google.android.gms.p018c.C0619ah;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.b */
public class C1093b {

    /* renamed from: a */
    private static final Object f4837a = new Object();

    /* renamed from: b */
    private static C1093b f4838b;

    /* renamed from: g */
    private static final ComponentName f4839g = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");

    /* renamed from: i */
    private static Integer f4840i;

    /* renamed from: c */
    private final List<String> f4841c;

    /* renamed from: d */
    private final List<String> f4842d;

    /* renamed from: e */
    private final List<String> f4843e;

    /* renamed from: f */
    private final List<String> f4844f;

    /* renamed from: h */
    private C1098g f4845h;

    private C1093b() {
        if (m4766b() == C1097f.f4855a) {
            this.f4841c = Collections.EMPTY_LIST;
            this.f4842d = Collections.EMPTY_LIST;
            this.f4843e = Collections.EMPTY_LIST;
            this.f4844f = Collections.EMPTY_LIST;
            return;
        }
        String c = C1095d.f4848b.mo7234c();
        this.f4841c = c == null ? Collections.EMPTY_LIST : Arrays.asList(c.split(","));
        String c2 = C1095d.f4849c.mo7234c();
        this.f4842d = c2 == null ? Collections.EMPTY_LIST : Arrays.asList(c2.split(","));
        String c3 = C1095d.f4850d.mo7234c();
        this.f4843e = c3 == null ? Collections.EMPTY_LIST : Arrays.asList(c3.split(","));
        String c4 = C1095d.f4851e.mo7234c();
        this.f4844f = c4 == null ? Collections.EMPTY_LIST : Arrays.asList(c4.split(","));
        this.f4845h = new C1098g(1024, C1095d.f4852f.mo7234c().longValue());
    }

    /* renamed from: a */
    public static C1093b m4761a() {
        synchronized (f4837a) {
            if (f4838b == null) {
                f4838b = new C1093b();
            }
        }
        return f4838b;
    }

    /* renamed from: a */
    private String m4762a(ServiceConnection serviceConnection) {
        return String.valueOf((Process.myPid() << 32) | System.identityHashCode(serviceConnection));
    }

    /* renamed from: a */
    private void m4763a(Context context, ServiceConnection serviceConnection, String str, Intent intent, int i) {
        ConnectionEvent connectionEvent;
        if (C1015f.f4727a) {
            String a = m4762a(serviceConnection);
            if (m4765a(context, str, intent, a, i)) {
                long currentTimeMillis = System.currentTimeMillis();
                String str2 = null;
                if ((m4766b() & C1097f.f4859e) != 0) {
                    str2 = C0619ah.m3570a(3, 5);
                }
                long j = 0;
                if ((m4766b() & C1097f.f4861g) != 0) {
                    j = Debug.getNativeHeapAllocatedSize();
                }
                if (i == 1 || i == 4) {
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, (String) null, (String) null, (String) null, (String) null, str2, a, SystemClock.elapsedRealtime(), j);
                } else {
                    ServiceInfo b = m4767b(context, intent);
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, C0619ah.m3571a(context), str, b.processName, b.name, str2, a, SystemClock.elapsedRealtime(), j);
                }
                context.startService(new Intent().setComponent(f4839g).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
            }
        }
    }

    /* renamed from: a */
    private boolean m4764a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null || (C1015f.f4727a && "com.google.android.gms".equals(component.getPackageName()))) {
            return false;
        }
        return C0614ac.m3554a(context, component.getPackageName());
    }

    /* renamed from: a */
    private boolean m4765a(Context context, String str, Intent intent, String str2, int i) {
        int b = m4766b();
        if (b == C1097f.f4855a || this.f4845h == null) {
            return false;
        }
        if (i == 4 || i == 1) {
            return this.f4845h.mo7707b(str2);
        }
        ServiceInfo b2 = m4767b(context, intent);
        if (b2 == null) {
            Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str, intent.toUri(0)}));
            return false;
        }
        String a = C0619ah.m3571a(context);
        String str3 = b2.processName;
        String str4 = b2.name;
        if (this.f4841c.contains(a) || this.f4842d.contains(str) || this.f4843e.contains(str3) || this.f4844f.contains(str4)) {
            return false;
        }
        if (str3.equals(a) && (b & C1097f.f4860f) != 0) {
            return false;
        }
        this.f4845h.mo7706a(str2);
        return true;
    }

    /* renamed from: b */
    private static int m4766b() {
        if (f4840i == null) {
            try {
                f4840i = Integer.valueOf(C0614ac.m3553a() ? C1095d.f4847a.mo7234c().intValue() : C1097f.f4855a);
            } catch (SecurityException e) {
                f4840i = Integer.valueOf(C1097f.f4855a);
            }
        }
        return f4840i.intValue();
    }

    /* renamed from: b */
    private static ServiceInfo m4767b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), C0619ah.m3570a(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), C0619ah.m3570a(3, 20)}));
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", it.next().serviceInfo.name);
                return null;
            }
        }
        return queryIntentServices.get(0).serviceInfo;
    }

    /* renamed from: a */
    public void mo7701a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m4763a(context, serviceConnection, (String) null, (Intent) null, 1);
    }

    /* renamed from: a */
    public void mo7702a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m4763a(context, serviceConnection, str, intent, 3);
    }

    /* renamed from: a */
    public boolean mo7703a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return mo7704a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    /* renamed from: a */
    public boolean mo7704a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m4764a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m4763a(context, serviceConnection, str, intent, 2);
        }
        return bindService;
    }

    /* renamed from: b */
    public void mo7705b(Context context, ServiceConnection serviceConnection) {
        m4763a(context, serviceConnection, (String) null, (Intent) null, 4);
    }
}
