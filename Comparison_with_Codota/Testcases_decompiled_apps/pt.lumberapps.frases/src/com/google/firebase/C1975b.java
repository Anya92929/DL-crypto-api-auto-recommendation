package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.support.p009v4.p019f.C0136a;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzalo;
import com.google.android.gms.internal.zzalp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.firebase.b */
public class C1975b {

    /* renamed from: a */
    static final Map f7481a = new C0136a();

    /* renamed from: b */
    private static final List f7482b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});

    /* renamed from: c */
    private static final List f7483c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");

    /* renamed from: d */
    private static final List f7484d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});

    /* renamed from: e */
    private static final Set f7485e = Collections.emptySet();

    /* renamed from: f */
    private static final Object f7486f = new Object();

    /* renamed from: g */
    private final Context f7487g;

    /* renamed from: h */
    private final String f7488h;

    /* renamed from: i */
    private final C1978e f7489i;

    /* renamed from: j */
    private final AtomicBoolean f7490j = new AtomicBoolean(true);

    /* renamed from: k */
    private final AtomicBoolean f7491k = new AtomicBoolean();

    /* renamed from: l */
    private final List f7492l = new CopyOnWriteArrayList();

    /* renamed from: m */
    private final List f7493m = new CopyOnWriteArrayList();

    /* renamed from: n */
    private final List f7494n = new CopyOnWriteArrayList();

    protected C1975b(Context context, String str, C1978e eVar) {
        this.f7487g = (Context) zzab.zzy(context);
        this.f7488h = zzab.zzhr(str);
        this.f7489i = (C1978e) zzab.zzy(eVar);
    }

    /* renamed from: a */
    public static C1975b m8078a(Context context) {
        C1978e a = C1978e.m8095a(context);
        if (a == null) {
            return null;
        }
        return m8079a(context, a);
    }

    /* renamed from: a */
    public static C1975b m8079a(Context context, C1978e eVar) {
        return m8080a(context, eVar, "[DEFAULT]");
    }

    /* renamed from: a */
    public static C1975b m8080a(Context context, C1978e eVar, String str) {
        C1975b bVar;
        zzalp zzeq = zzalp.zzeq(context);
        m8085b(context);
        String b = m8084b(str);
        Context applicationContext = context.getApplicationContext();
        synchronized (f7486f) {
            zzab.zza(!f7481a.containsKey(b), (Object) new StringBuilder(String.valueOf(b).length() + 33).append("FirebaseApp name ").append(b).append(" already exists!").toString());
            zzab.zzb((Object) applicationContext, (Object) "Application context cannot be null.");
            bVar = new C1975b(applicationContext, b, eVar);
            f7481a.put(b, bVar);
        }
        zzeq.zzf(bVar);
        m8082a(C1975b.class, (Object) bVar, (Iterable) f7482b);
        if (bVar.mo9844e()) {
            m8082a(C1975b.class, (Object) bVar, (Iterable) f7483c);
            m8082a(Context.class, (Object) bVar.mo9841a(), (Iterable) f7484d);
        }
        return bVar;
    }

    /* renamed from: a */
    public static C1975b m8081a(String str) {
        C1975b bVar;
        String concat;
        synchronized (f7486f) {
            bVar = (C1975b) f7481a.get(m8084b(str));
            if (bVar == null) {
                List g = m8089g();
                if (g.isEmpty()) {
                    concat = "";
                } else {
                    String valueOf = String.valueOf(zzy.zzhq(", ").zza(g));
                    concat = valueOf.length() != 0 ? "Available app names: ".concat(valueOf) : new String("Available app names: ");
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, concat}));
            }
        }
        return bVar;
    }

    /* renamed from: a */
    private static void m8082a(Class cls, Object obj, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                Method method = Class.forName(str).getMethod("getInstance", new Class[]{cls});
                int modifiers = method.getModifiers();
                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                    method.invoke((Object) null, new Object[]{obj});
                }
            } catch (ClassNotFoundException e) {
                if (f7485e.contains(str)) {
                    throw new IllegalStateException(String.valueOf(str).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d("FirebaseApp", String.valueOf(str).concat(" is not linked. Skipping initialization."));
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(String.valueOf(str).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (InvocationTargetException e3) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
            } catch (IllegalAccessException e4) {
                String valueOf = String.valueOf(str);
                Log.wtf("FirebaseApp", valueOf.length() != 0 ? "Failed to initialize ".concat(valueOf) : new String("Failed to initialize "), e4);
            }
        }
    }

    /* renamed from: a */
    public static void m8083a(boolean z) {
        synchronized (f7486f) {
            Iterator it = new ArrayList(f7481a.values()).iterator();
            while (it.hasNext()) {
                C1975b bVar = (C1975b) it.next();
                if (bVar.f7490j.get()) {
                    bVar.m8086b(z);
                }
            }
        }
    }

    /* renamed from: b */
    private static String m8084b(String str) {
        return str.trim();
    }

    @TargetApi(14)
    /* renamed from: b */
    private static void m8085b(Context context) {
        if (zzs.zzavq() && (context.getApplicationContext() instanceof Application)) {
            zzalo.zza((Application) context.getApplicationContext());
        }
    }

    /* renamed from: b */
    private void m8086b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (C1976c a : this.f7493m) {
            a.mo9848a(z);
        }
    }

    /* renamed from: d */
    public static C1975b m8087d() {
        return m8081a("[DEFAULT]");
    }

    /* renamed from: f */
    private void m8088f() {
        zzab.zza(!this.f7491k.get(), (Object) "FirebaseApp was deleted");
    }

    /* renamed from: g */
    private static List m8089g() {
        zza zza = new zza();
        synchronized (f7486f) {
            for (C1975b b : f7481a.values()) {
                zza.add(b.mo9842b());
            }
            zzalp zzcxc = zzalp.zzcxc();
            if (zzcxc != null) {
                zza.addAll(zzcxc.zzcxd());
            }
        }
        ArrayList arrayList = new ArrayList(zza);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public Context mo9841a() {
        m8088f();
        return this.f7487g;
    }

    /* renamed from: b */
    public String mo9842b() {
        m8088f();
        return this.f7488h;
    }

    /* renamed from: c */
    public C1978e mo9843c() {
        m8088f();
        return this.f7489i;
    }

    /* renamed from: e */
    public boolean mo9844e() {
        return "[DEFAULT]".equals(mo9842b());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1975b)) {
            return false;
        }
        return this.f7488h.equals(((C1975b) obj).mo9842b());
    }

    public int hashCode() {
        return this.f7488h.hashCode();
    }

    public String toString() {
        return zzaa.zzx(this).zzg("name", this.f7488h).zzg("options", this.f7489i).toString();
    }
}
