package com.appbrain.p032a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import cmn.C0756r;
import com.appbrain.AppBrainService;
import com.appbrain.p033b.C1015s;
import com.appbrain.p037f.C1040af;
import com.appbrain.p037f.C1063bb;
import com.appbrain.p037f.C1067bf;
import com.appbrain.p037f.C1069bh;
import java.text.ParseException;
import java.util.Map;

/* renamed from: com.appbrain.a.cv */
public class C0860cv {

    /* renamed from: a */
    private static final String f2281a = C0860cv.class.getSimpleName();

    /* renamed from: b */
    private static final C1040af[] f2282b = {C1040af.CLICK, C1040af.INSTALL, C1040af.UNINSTALL, C1040af.FINAL_CHECK, C1040af.INVALID_URL};

    /* renamed from: a */
    static C1067bf m3772a(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return C1067bf.m4826a(C0756r.m3310a((String) obj));
        } catch (C1015s | ParseException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m3773a(Context context) {
        m3775a(context, "com.appbrain.CHECK", 0);
    }

    /* renamed from: a */
    public static void m3774a(Context context, C1040af afVar, String str, C1067bf bfVar) {
        Intent intent = new Intent(context, AppBrainService.class);
        intent.putExtra("event", C0756r.m3308a(bfVar.mo3915b()));
        intent.putExtra("key", afVar + str);
        context.startService(intent);
    }

    /* renamed from: a */
    public static void m3775a(Context context, String str, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            Intent intent = new Intent(context, AppBrainService.class);
            intent.setAction(str);
            PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
            alarmManager.cancel(service);
            if (j >= 0) {
                alarmManager.setRepeating(3, SystemClock.elapsedRealtime() + j, j, service);
            }
        }
    }

    /* renamed from: a */
    public static void m3776a(String str, String str2) {
        SharedPreferences b = C0932fm.m3968a().mo3843b();
        if (b.getString(str, (String) null) == null) {
            b.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: b */
    public static boolean m3777b(Context context) {
        boolean z;
        boolean z2;
        SharedPreferences b = C0932fm.m3968a().mo3843b();
        SharedPreferences.Editor edit = b.edit();
        for (Map.Entry next : b.getAll().entrySet()) {
            String str = (String) next.getKey();
            C1040af[] afVarArr = f2282b;
            int length = afVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = false;
                    break;
                } else if (str.startsWith(afVarArr[i].toString())) {
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z2) {
                C1067bf a = m3772a(next.getValue());
                if (a == null) {
                    edit.remove(str);
                } else {
                    C1063bb h = a.mo4295h();
                    boolean z3 = ((double) System.currentTimeMillis()) > ((double) h.mo4271n()) + 1.296E8d;
                    if (!a.mo4297j()) {
                        try {
                            if (C0883dr.m3828a(context).mo3762a(h) != null) {
                                if (h.mo4269l() != C1040af.CLICK || z3) {
                                    edit.remove(str);
                                } else {
                                    C1069bh n = a.mo4027d();
                                    n.mo4305a(true);
                                    edit.putString(str, C0756r.m3308a(n.mo4028d().mo3915b()));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            z = true;
                        }
                    } else if (z3 && (!str.startsWith(C1040af.CLICK.toString()) || a.mo4299l() == 3)) {
                        edit.remove(str);
                    }
                }
            }
        }
        z = false;
        edit.apply();
        return !z;
    }
}
