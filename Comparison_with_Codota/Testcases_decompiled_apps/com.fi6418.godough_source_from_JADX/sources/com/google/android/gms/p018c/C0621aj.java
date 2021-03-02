package com.google.android.gms.p018c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.c.aj */
public class C0621aj {

    /* renamed from: a */
    private static final Method f4220a = m3579a();

    /* renamed from: b */
    private static final Method f4221b = m3582b();

    /* renamed from: c */
    private static final Method f4222c = m3584c();

    /* renamed from: d */
    private static final Method f4223d = m3585d();

    /* renamed from: e */
    private static final Method f4224e = m3586e();

    /* renamed from: a */
    public static int m3575a(WorkSource workSource) {
        if (f4222c != null) {
            try {
                return ((Integer) f4222c.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static WorkSource m3576a(int i, String str) {
        WorkSource workSource = new WorkSource();
        m3580a(workSource, i, str);
        return workSource;
    }

    /* renamed from: a */
    public static WorkSource m3577a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return m3576a(applicationInfo.uid, str);
            }
            Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + str);
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("WorkSourceUtil", "Could not find package: " + str);
            return null;
        }
    }

    /* renamed from: a */
    public static String m3578a(WorkSource workSource, int i) {
        if (f4224e != null) {
            try {
                return (String) f4224e.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Method m3579a() {
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m3580a(WorkSource workSource, int i, String str) {
        if (f4221b != null) {
            if (str == null) {
                str = "";
            }
            try {
                f4221b.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        } else if (f4220a != null) {
            try {
                f4220a.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
    }

    /* renamed from: a */
    public static boolean m3581a(Context context) {
        return context.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    /* renamed from: b */
    private static Method m3582b() {
        if (!C0618ag.m3566d()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public static List<String> m3583b(WorkSource workSource) {
        int a = workSource == null ? 0 : m3575a(workSource);
        if (a == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < a; i++) {
            String a2 = m3578a(workSource, i);
            if (!C0620ai.m3574a(a2)) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    private static Method m3584c() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    private static Method m3585d() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: e */
    private static Method m3586e() {
        if (!C0618ag.m3566d()) {
            return null;
        }
        try {
            return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return null;
        }
    }
}
