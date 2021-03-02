package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.support.p009v4.app.NotificationCompat;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzt;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zzb {

    /* renamed from: a */
    private static final Object f4691a = new Object();

    /* renamed from: b */
    private static zzb f4692b;

    /* renamed from: h */
    private static Integer f4693h;

    /* renamed from: c */
    private final List f4694c;

    /* renamed from: d */
    private final List f4695d;

    /* renamed from: e */
    private final List f4696e;

    /* renamed from: f */
    private final List f4697f;

    /* renamed from: g */
    private zze f4698g;

    /* renamed from: i */
    private zze f4699i;

    private zzb() {
        if (m6191b() == zzd.LOG_LEVEL_OFF) {
            this.f4694c = Collections.EMPTY_LIST;
            this.f4695d = Collections.EMPTY_LIST;
            this.f4696e = Collections.EMPTY_LIST;
            this.f4697f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) zzc.zza.f4703Au.get();
        this.f4694c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        String str2 = (String) zzc.zza.f4704Av.get();
        this.f4695d = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(","));
        String str3 = (String) zzc.zza.f4705Aw.get();
        this.f4696e = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(","));
        String str4 = (String) zzc.zza.f4706Ax.get();
        this.f4697f = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(","));
        this.f4698g = new zze(1024, ((Long) zzc.zza.f4707Ay.get()).longValue());
        this.f4699i = new zze(1024, ((Long) zzc.zza.f4707Ay.get()).longValue());
    }

    /* renamed from: a */
    private static String m6183a(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(m6185a(stackTrace, i)).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m6184a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    /* renamed from: a */
    private static String m6185a(StackTraceElement[] stackTraceElementArr, int i) {
        if (i + 4 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i + 4];
        String valueOf = String.valueOf(stackTraceElement.getClassName());
        String valueOf2 = String.valueOf(stackTraceElement.getMethodName());
        return new StringBuilder(String.valueOf(valueOf).length() + 13 + String.valueOf(valueOf2).length()).append(valueOf).append(".").append(valueOf2).append(":").append(stackTraceElement.getLineNumber()).toString();
    }

    /* renamed from: a */
    private void m6186a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        ConnectionEvent connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((m6191b() & zzd.f4713AD) == 0 || i == 13)) {
            str6 = m6183a(3, 5);
        }
        long j = 0;
        if ((m6191b() & zzd.f4715AF) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, (String) null, (String) null, (String) null, (String) null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(zzd.f4717Az).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    /* renamed from: a */
    private void m6187a(Context context, String str, String str2, Intent intent, int i) {
        String str3;
        String str4;
        String str5 = null;
        if (m6188a() && this.f4698g != null) {
            if (i != 4 && i != 1) {
                ServiceInfo b = m6192b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str3 = b.name;
                str5 = zzt.zzavz();
                if (m6190a(str5, str2, str4, str3)) {
                    this.f4698g.zzhx(str);
                } else {
                    return;
                }
            } else if (this.f4698g.zzhy(str)) {
                str3 = null;
                str4 = null;
            } else {
                return;
            }
            m6186a(context, str, i, str5, str2, str4, str3);
        }
    }

    /* renamed from: a */
    private boolean m6188a() {
        return false;
    }

    /* renamed from: a */
    private boolean m6189a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        return zzd.zzq(context, component.getPackageName());
    }

    /* renamed from: a */
    private boolean m6190a(String str, String str2, String str3, String str4) {
        return !this.f4694c.contains(str) && !this.f4695d.contains(str2) && !this.f4696e.contains(str3) && !this.f4697f.contains(str4) && (!str3.equals(str) || (m6191b() & zzd.f4714AE) == 0);
    }

    /* renamed from: b */
    private static int m6191b() {
        if (f4693h == null) {
            try {
                f4693h = Integer.valueOf(zzd.zzabc() ? ((Integer) zzc.zza.f4702At.get()).intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                f4693h = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return f4693h.intValue();
    }

    /* renamed from: b */
    private static ServiceInfo m6192b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, NotificationCompat.FLAG_HIGH_PRIORITY);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), m6183a(3, 20)}));
            return null;
        } else if (queryIntentServices.size() <= 1) {
            return queryIntentServices.get(0).serviceInfo;
        } else {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), m6183a(3, 20)}));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                Log.w("ConnectionTracker", resolveInfo.serviceInfo.name);
            }
            return null;
        }
    }

    public static zzb zzaux() {
        synchronized (f4691a) {
            if (f4692b == null) {
                f4692b = new zzb();
            }
        }
        return f4692b;
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m6187a(context, m6184a(serviceConnection), (String) null, (Intent) null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m6187a(context, m6184a(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m6189a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m6187a(context, m6184a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        m6187a(context, m6184a(serviceConnection), (String) null, (Intent) null, 4);
    }
}
