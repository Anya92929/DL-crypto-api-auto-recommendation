package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0992cf;
import java.lang.Thread;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@C1130ez
/* renamed from: com.google.android.gms.internal.gb */
public class C1201gb implements C0992cf.C0994b {

    /* renamed from: vJ */
    private static final C1201gb f3707vJ = new C1201gb();

    /* renamed from: vK */
    public static final String f3708vK = f3707vJ.f3716vL;
    private Context mContext;

    /* renamed from: mw */
    private final Object f3709mw = new Object();

    /* renamed from: nu */
    private C0908am f3710nu = null;

    /* renamed from: nv */
    private C0907al f3711nv = null;

    /* renamed from: nw */
    private C1129ey f3712nw = null;

    /* renamed from: qs */
    private C1230gt f3713qs;

    /* renamed from: uH */
    private boolean f3714uH = true;

    /* renamed from: uI */
    private boolean f3715uI = true;

    /* renamed from: vL */
    public final String f3716vL = C1213gj.m4636dp();

    /* renamed from: vM */
    private final C1202gc f3717vM = new C1202gc(this.f3716vL);

    /* renamed from: vN */
    private BigInteger f3718vN = BigInteger.ONE;

    /* renamed from: vO */
    private final HashSet<C1199ga> f3719vO = new HashSet<>();

    /* renamed from: vP */
    private final HashMap<String, C1204ge> f3720vP = new HashMap<>();

    /* renamed from: vQ */
    private boolean f3721vQ = false;

    /* renamed from: vR */
    private boolean f3722vR = false;

    /* renamed from: vS */
    private C0909an f3723vS = null;

    /* renamed from: vT */
    private LinkedList<Thread> f3724vT = new LinkedList<>();

    /* renamed from: vU */
    private boolean f3725vU = false;

    /* renamed from: vV */
    private Bundle f3726vV = C0952bn.m3999bs();

    /* renamed from: vW */
    private String f3727vW;

    private C1201gb() {
    }

    /* renamed from: a */
    public static Bundle m4558a(Context context, C1203gd gdVar, String str) {
        return f3707vJ.mo8560b(context, gdVar, str);
    }

    /* renamed from: a */
    public static void m4559a(Context context, C1230gt gtVar) {
        f3707vJ.mo8561b(context, gtVar);
    }

    /* renamed from: a */
    public static void m4560a(Context context, boolean z) {
        f3707vJ.mo8562b(context, z);
    }

    /* renamed from: b */
    public static void m4561b(HashSet<C1199ga> hashSet) {
        f3707vJ.mo8563c(hashSet);
    }

    /* renamed from: bD */
    public static Bundle m4562bD() {
        return f3707vJ.mo8571dh();
    }

    /* renamed from: c */
    public static String m4563c(int i, String str) {
        return f3707vJ.mo8566d(i, str);
    }

    /* renamed from: cV */
    public static C1201gb m4564cV() {
        return f3707vJ;
    }

    /* renamed from: cX */
    public static String m4565cX() {
        return f3707vJ.mo8565cY();
    }

    /* renamed from: cZ */
    public static C1202gc m4566cZ() {
        return f3707vJ.mo8567da();
    }

    /* renamed from: db */
    public static boolean m4567db() {
        return f3707vJ.mo8568dc();
    }

    /* renamed from: dd */
    public static boolean m4568dd() {
        return f3707vJ.mo8569de();
    }

    /* renamed from: df */
    public static String m4569df() {
        return f3707vJ.mo8570dg();
    }

    /* renamed from: e */
    public static void m4570e(Throwable th) {
        f3707vJ.mo8572f(th);
    }

    /* renamed from: a */
    public void mo8207a(Bundle bundle) {
        synchronized (this.f3709mw) {
            this.f3725vU = true;
            this.f3726vV = bundle;
            while (!this.f3724vT.isEmpty()) {
                C1129ey.m4380a(this.mContext, this.f3724vT.remove(0), this.f3713qs);
            }
        }
    }

    /* renamed from: a */
    public void mo8557a(C1199ga gaVar) {
        synchronized (this.f3709mw) {
            this.f3719vO.add(gaVar);
        }
    }

    /* renamed from: a */
    public void mo8558a(String str, C1204ge geVar) {
        synchronized (this.f3709mw) {
            this.f3720vP.put(str, geVar);
        }
    }

    /* renamed from: a */
    public void mo8559a(Thread thread) {
        synchronized (this.f3709mw) {
            if (this.f3725vU) {
                C1129ey.m4380a(this.mContext, thread, this.f3713qs);
            } else {
                this.f3724vT.add(thread);
            }
        }
    }

    /* renamed from: b */
    public Bundle mo8560b(Context context, C1203gd gdVar, String str) {
        Bundle bundle;
        synchronized (this.f3709mw) {
            bundle = new Bundle();
            bundle.putBundle("app", this.f3717vM.mo8575b(context, str));
            Bundle bundle2 = new Bundle();
            for (String next : this.f3720vP.keySet()) {
                bundle2.putBundle(next, this.f3720vP.get(next).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator<C1199ga> it = this.f3719vO.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            gdVar.mo8580a(this.f3719vO);
            this.f3719vO.clear();
        }
        return bundle;
    }

    /* renamed from: b */
    public void mo8561b(Context context, C1230gt gtVar) {
        synchronized (this.f3709mw) {
            if (!this.f3722vR) {
                this.mContext = context.getApplicationContext();
                this.f3713qs = gtVar;
                this.f3714uH = C1208gh.m4605o(context);
                C1342iv.m5082H(context);
                C0992cf.m4116a(context, this);
                mo8559a(Thread.currentThread());
                this.f3727vW = C1213gj.m4628c(context, gtVar.f3777wD);
                this.f3722vR = true;
            }
        }
    }

    /* renamed from: b */
    public void mo8562b(Context context, boolean z) {
        synchronized (this.f3709mw) {
            if (z != this.f3714uH) {
                this.f3714uH = z;
                C1208gh.m4603a(context, z);
            }
        }
    }

    /* renamed from: c */
    public void mo8563c(HashSet<C1199ga> hashSet) {
        synchronized (this.f3709mw) {
            this.f3719vO.addAll(hashSet);
        }
    }

    /* renamed from: cW */
    public boolean mo8564cW() {
        boolean z;
        synchronized (this.f3709mw) {
            z = this.f3715uI;
        }
        return z;
    }

    /* renamed from: cY */
    public String mo8565cY() {
        String bigInteger;
        synchronized (this.f3709mw) {
            bigInteger = this.f3718vN.toString();
            this.f3718vN = this.f3718vN.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    /* renamed from: d */
    public String mo8566d(int i, String str) {
        Resources resources = this.f3713qs.f3780wG ? this.mContext.getResources() : GooglePlayServicesUtil.getRemoteResource(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    /* renamed from: da */
    public C1202gc mo8567da() {
        C1202gc gcVar;
        synchronized (this.f3709mw) {
            gcVar = this.f3717vM;
        }
        return gcVar;
    }

    /* renamed from: dc */
    public boolean mo8568dc() {
        boolean z;
        synchronized (this.f3709mw) {
            z = this.f3721vQ;
            this.f3721vQ = true;
        }
        return z;
    }

    /* renamed from: de */
    public boolean mo8569de() {
        boolean z;
        synchronized (this.f3709mw) {
            z = this.f3714uH;
        }
        return z;
    }

    /* renamed from: dg */
    public String mo8570dg() {
        String str;
        synchronized (this.f3709mw) {
            str = this.f3727vW;
        }
        return str;
    }

    /* renamed from: dh */
    public Bundle mo8571dh() {
        Bundle bundle;
        synchronized (this.f3709mw) {
            bundle = this.f3726vV;
        }
        return bundle;
    }

    /* renamed from: f */
    public void mo8572f(Throwable th) {
        if (this.f3722vR) {
            new C1129ey(this.mContext, this.f3713qs, (Thread.UncaughtExceptionHandler) null, (Thread.UncaughtExceptionHandler) null).mo8462b(th);
        }
    }

    /* renamed from: l */
    public C0909an mo8573l(Context context) {
        C0909an anVar = null;
        if (m4562bD().getBoolean(C0952bn.f2912pd.getKey(), false) && C1394kc.m5241hE() && !mo8564cW()) {
            synchronized (this.f3709mw) {
                if (this.f3710nu == null) {
                    if (context instanceof Activity) {
                        this.f3710nu = new C0908am((Application) context.getApplicationContext(), (Activity) context);
                    }
                }
                if (this.f3711nv == null) {
                    this.f3711nv = new C0907al();
                }
                if (this.f3723vS == null) {
                    this.f3723vS = new C0909an(this.f3710nu, this.f3711nv, this.f3726vV, new C1129ey(this.mContext, this.f3713qs, (Thread.UncaughtExceptionHandler) null, (Thread.UncaughtExceptionHandler) null));
                }
                this.f3723vS.mo7988aV();
                anVar = this.f3723vS;
            }
        }
        return anVar;
    }

    /* renamed from: v */
    public void mo8574v(boolean z) {
        synchronized (this.f3709mw) {
            this.f3715uI = z;
        }
    }
}
