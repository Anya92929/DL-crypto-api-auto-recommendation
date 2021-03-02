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
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zznf;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb {

    /* renamed from: a */
    private static final Object f3094a = new Object();

    /* renamed from: b */
    private static zzb f3095b;

    /* renamed from: h */
    private static Integer f3096h;

    /* renamed from: c */
    private final List<String> f3097c;

    /* renamed from: d */
    private final List<String> f3098d;

    /* renamed from: e */
    private final List<String> f3099e;

    /* renamed from: f */
    private final List<String> f3100f;

    /* renamed from: g */
    private zze f3101g;

    /* renamed from: i */
    private zze f3102i;

    private zzb() {
        if (m3998b() == zzd.LOG_LEVEL_OFF) {
            this.f3097c = Collections.EMPTY_LIST;
            this.f3098d = Collections.EMPTY_LIST;
            this.f3099e = Collections.EMPTY_LIST;
            this.f3100f = Collections.EMPTY_LIST;
            return;
        }
        String str = zzc.zza.zzanA.get();
        this.f3097c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        String str2 = zzc.zza.zzanB.get();
        this.f3098d = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(","));
        String str3 = zzc.zza.zzanC.get();
        this.f3099e = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(","));
        String str4 = zzc.zza.zzanD.get();
        this.f3100f = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(","));
        this.f3101g = new zze(1024, zzc.zza.zzanE.get().longValue());
        this.f3102i = new zze(1024, zzc.zza.zzanE.get().longValue());
    }

    /* renamed from: a */
    private String m3992a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    /* renamed from: a */
    private void m3993a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        ConnectionEvent connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((m3998b() & zzd.zzanJ) == 0 || i == 13)) {
            str6 = zznf.zzn(3, 5);
        }
        long j = 0;
        if ((m3998b() & zzd.zzanL) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, (String) null, (String) null, (String) null, (String) null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    /* renamed from: a */
    private void m3994a(Context context, String str, String str2, Intent intent, int i) {
        String str3;
        String str4;
        String str5 = null;
        if (m3995a() && this.f3101g != null) {
            if (i != 4 && i != 1) {
                ServiceInfo b = m3999b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str3 = b.name;
                str5 = zznf.zzaz(context);
                if (m3997a(str5, str2, str4, str3)) {
                    this.f3101g.zzcS(str);
                } else {
                    return;
                }
            } else if (this.f3101g.zzcT(str)) {
                str3 = null;
                str4 = null;
            } else {
                return;
            }
            m3993a(context, str, i, str5, str2, str4, str3);
        }
    }

    /* renamed from: a */
    private boolean m3995a() {
        return zzd.zzakE && m3998b() != zzd.LOG_LEVEL_OFF;
    }

    /* renamed from: a */
    private boolean m3996a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null || (zzd.zzakE && "com.google.android.gms".equals(component.getPackageName()))) {
            return false;
        }
        return zzmp.zzk(context, component.getPackageName());
    }

    /* renamed from: a */
    private boolean m3997a(String str, String str2, String str3, String str4) {
        return !this.f3097c.contains(str) && !this.f3098d.contains(str2) && !this.f3099e.contains(str3) && !this.f3100f.contains(str4) && (!str3.equals(str) || (m3998b() & zzd.zzanK) == 0);
    }

    /* renamed from: b */
    private static int m3998b() {
        if (f3096h == null) {
            try {
                f3096h = Integer.valueOf(zzmp.zzkr() ? zzc.zza.zzanz.get().intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                f3096h = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return f3096h.intValue();
    }

    /* renamed from: b */
    private static ServiceInfo m3999b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zznf.zzn(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zznf.zzn(3, 20)}));
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", it.next().serviceInfo.name);
                return null;
            }
        }
        return queryIntentServices.get(0).serviceInfo;
    }

    public static zzb zzrP() {
        synchronized (f3094a) {
            if (f3095b == null) {
                f3095b = new zzb();
            }
        }
        return f3095b;
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m3994a(context, m3992a(serviceConnection), (String) null, (Intent) null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m3994a(context, m3992a(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m3996a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m3994a(context, m3992a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        m3994a(context, m3992a(serviceConnection), (String) null, (Intent) null, 4);
    }
}
