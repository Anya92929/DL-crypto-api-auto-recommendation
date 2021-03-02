package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class zzaq extends zzao {

    /* renamed from: k */
    static boolean f5908k = false;

    /* renamed from: n */
    protected static volatile zzax f5909n = null;

    /* renamed from: o */
    protected static final Object f5910o = new Object();

    /* renamed from: p */
    private static final String f5911p = zzaq.class.getSimpleName();

    /* renamed from: q */
    private static Method f5912q;

    /* renamed from: r */
    private static long f5913r = 0;

    /* renamed from: i */
    protected boolean f5914i = false;

    /* renamed from: j */
    protected String f5915j;

    /* renamed from: l */
    protected boolean f5916l = false;

    /* renamed from: m */
    protected boolean f5917m = false;

    protected zzaq(Context context, String str) {
        super(context);
        this.f5915j = str;
        this.f5914i = false;
    }

    protected zzaq(Context context, String str, boolean z) {
        super(context);
        this.f5915j = str;
        this.f5914i = z;
    }

    /* renamed from: a */
    static List m6866a(zzax zzax, MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        f5912q = zzax.zzc(zzav.zzcb(), zzav.zzcc());
        if (f5912q == null || motionEvent == null) {
            throw new zzaw();
        }
        try {
            return (ArrayList) f5912q.invoke((Object) null, new Object[]{motionEvent, displayMetrics});
        } catch (IllegalAccessException e) {
            throw new zzaw(e);
        } catch (InvocationTargetException e2) {
            throw new zzaw(e2);
        }
    }

    /* renamed from: a */
    protected static synchronized void m6867a(Context context, boolean z) {
        synchronized (zzaq.class) {
            if (!f5908k) {
                f5913r = Calendar.getInstance().getTime().getTime() / 1000;
                f5909n = m6869b(context, z);
                f5908k = true;
            }
        }
    }

    /* renamed from: a */
    private static void m6868a(zzax zzax) {
        List<Context> singletonList = Collections.singletonList(Context.class);
        zzax.zza(zzav.zzbn(), zzav.zzbo(), singletonList);
        zzax.zza(zzav.zzbl(), zzav.zzbm(), singletonList);
        zzax.zza(zzav.zzbx(), zzav.zzby(), singletonList);
        zzax.zza(zzav.zzbv(), zzav.zzbw(), singletonList);
        zzax.zza(zzav.zzbf(), zzav.zzbg(), singletonList);
        zzax.zza(zzav.zzbd(), zzav.zzbe(), singletonList);
        zzax.zza(zzav.zzbb(), zzav.zzbc(), singletonList);
        zzax.zza(zzav.zzbr(), zzav.zzbs(), singletonList);
        zzax.zza(zzav.zzaz(), zzav.zzba(), singletonList);
        zzax.zza(zzav.zzcb(), zzav.zzcc(), Arrays.asList(new Class[]{MotionEvent.class, DisplayMetrics.class}));
        zzax.zza(zzav.zzbj(), zzav.zzbk(), Collections.emptyList());
        zzax.zza(zzav.zzbz(), zzav.zzca(), Collections.emptyList());
        zzax.zza(zzav.zzbt(), zzav.zzbu(), Collections.emptyList());
        zzax.zza(zzav.zzbh(), zzav.zzbi(), Collections.emptyList());
        zzax.zza(zzav.zzbp(), zzav.zzbq(), Collections.emptyList());
    }

    /* renamed from: b */
    protected static zzax m6869b(Context context, boolean z) {
        if (f5909n == null) {
            synchronized (f5910o) {
                if (f5909n == null) {
                    zzax zza = zzax.zza(context, zzav.getKey(), zzav.zzay(), z);
                    m6868a(zza);
                    f5909n = zza;
                }
            }
        }
        return f5909n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzae.zza mo7898a(Context context) {
        zzae.zza zza = new zzae.zza();
        if (!TextUtils.isEmpty(this.f5915j)) {
            zza.zzcs = this.f5915j;
        }
        zzax b = m6869b(context, this.f5914i);
        b.zzcs();
        mo7953a(b, zza);
        b.zzct();
        return zza;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7953a(zzax zzax, zzae.zza zza) {
        if (zzax.zzcd() != null) {
            mo8081a(mo7954b(zzax, zza));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8081a(List list) {
        ExecutorService zzcd;
        if (f5909n != null && (zzcd = f5909n.zzcd()) != null && !list.isEmpty()) {
            try {
                zzcd.invokeAll(list, ((Long) zzdc.zzbbj.get()).longValue(), TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Log.d(f5911p, String.format("class methods got exception: %s", new Object[]{zzay.zza(e)}));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public zzae.zza mo7899b(Context context) {
        zzae.zza zza = new zzae.zza();
        if (!TextUtils.isEmpty(this.f5915j)) {
            zza.zzcs = this.f5915j;
        }
        zzax b = m6869b(context, this.f5914i);
        b.zzcs();
        mo8083d(b, zza);
        b.zzct();
        return zza;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List mo7954b(zzax zzax, zzae.zza zza) {
        int zzat = zzax.zzat();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new zzbb(zzax, zzav.zzbn(), zzav.zzbo(), zza, zzat, 27));
        ArrayList arrayList3 = arrayList;
        arrayList3.add(new zzbg(zzax, zzav.zzbj(), zzav.zzbk(), zza, f5913r, zzat, 25));
        ArrayList arrayList4 = arrayList;
        arrayList4.add(new zzbl(zzax, zzav.zzbt(), zzav.zzbu(), zza, zzat, 1));
        ArrayList arrayList5 = arrayList;
        arrayList5.add(new zzbm(zzax, zzav.zzbv(), zzav.zzbw(), zza, zzat, 31));
        ArrayList arrayList6 = arrayList;
        arrayList6.add(new zzbn(zzax, zzav.zzbz(), zzav.zzca(), zza, zzat, 33));
        ArrayList arrayList7 = arrayList;
        arrayList7.add(new zzba(zzax, zzav.zzbx(), zzav.zzby(), zza, zzat, 29));
        ArrayList arrayList8 = arrayList;
        arrayList8.add(new zzbe(zzax, zzav.zzbf(), zzav.zzbg(), zza, zzat, 5));
        ArrayList arrayList9 = arrayList;
        arrayList9.add(new zzbk(zzax, zzav.zzbr(), zzav.zzbs(), zza, zzat, 12));
        ArrayList arrayList10 = arrayList;
        arrayList10.add(new zzaz(zzax, zzav.zzaz(), zzav.zzba(), zza, zzat, 3));
        ArrayList arrayList11 = arrayList;
        arrayList11.add(new zzbd(zzax, zzav.zzbd(), zzav.zzbe(), zza, zzat, 34));
        ArrayList arrayList12 = arrayList;
        arrayList12.add(new zzbc(zzax, zzav.zzbb(), zzav.zzbc(), zza, zzat, 35));
        if (((Boolean) zzdc.zzbbn.get()).booleanValue()) {
            ArrayList arrayList13 = arrayList;
            arrayList13.add(new zzbf(zzax, zzav.zzbh(), zzav.zzbi(), zza, zzat, 44));
        }
        if (((Boolean) zzdc.zzbbq.get()).booleanValue()) {
            ArrayList arrayList14 = arrayList;
            arrayList14.add(new zzbj(zzax, zzav.zzbp(), zzav.zzbq(), zza, zzat, 22));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public List mo8082c(zzax zzax, zzae.zza zza) {
        ArrayList arrayList = new ArrayList();
        if (zzax.zzcd() == null) {
            return arrayList;
        }
        int zzat = zzax.zzat();
        arrayList.add(new zzbi(zzax, zza));
        ArrayList arrayList2 = arrayList;
        arrayList2.add(new zzbl(zzax, zzav.zzbt(), zzav.zzbu(), zza, zzat, 1));
        ArrayList arrayList3 = arrayList;
        arrayList3.add(new zzbg(zzax, zzav.zzbj(), zzav.zzbk(), zza, f5913r, zzat, 25));
        if (((Boolean) zzdc.zzbbo.get()).booleanValue()) {
            ArrayList arrayList4 = arrayList;
            arrayList4.add(new zzbf(zzax, zzav.zzbh(), zzav.zzbi(), zza, zzat, 44));
        }
        ArrayList arrayList5 = arrayList;
        arrayList5.add(new zzaz(zzax, zzav.zzaz(), zzav.zzba(), zza, zzat, 3));
        if (((Boolean) zzdc.zzbbr.get()).booleanValue()) {
            ArrayList arrayList6 = arrayList;
            arrayList6.add(new zzbj(zzax, zzav.zzbp(), zzav.zzbq(), zza, zzat, 22));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo8083d(zzax zzax, zzae.zza zza) {
        try {
            List a = m6866a(zzax, this.f5817a, this.f5824h);
            zza.zzdf = (Long) a.get(0);
            zza.zzdg = (Long) a.get(1);
            if (((Long) a.get(2)).longValue() >= 0) {
                zza.zzdh = (Long) a.get(2);
            }
            zza.zzdv = (Long) a.get(3);
            zza.zzdw = (Long) a.get(4);
        } catch (zzaw e) {
        }
        if (this.f5819c > 0) {
            zza.zzea = Long.valueOf(this.f5819c);
        }
        if (this.f5820d > 0) {
            zza.zzdz = Long.valueOf(this.f5820d);
        }
        if (this.f5821e > 0) {
            zza.zzdy = Long.valueOf(this.f5821e);
        }
        if (this.f5822f > 0) {
            zza.zzeb = Long.valueOf(this.f5822f);
        }
        if (this.f5823g > 0) {
            zza.zzed = Long.valueOf(this.f5823g);
        }
        try {
            int size = this.f5818b.size() - 1;
            if (size > 0) {
                zza.zzee = new zzae.zza.C2112zza[size];
                for (int i = 0; i < size; i++) {
                    List a2 = m6866a(zzax, (MotionEvent) this.f5818b.get(i), this.f5824h);
                    zzae.zza.C2112zza zza2 = new zzae.zza.C2112zza();
                    zza2.zzdf = (Long) a2.get(0);
                    zza2.zzdg = (Long) a2.get(1);
                    zza.zzee[i] = zza2;
                }
            }
        } catch (zzaw e2) {
            zza.zzee = null;
        }
        mo8081a(mo8082c(zzax, zza));
    }
}
