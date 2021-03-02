package com.flurry.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/* renamed from: com.flurry.android.v */
final class C0120v implements View.OnClickListener {

    /* renamed from: A */
    private static volatile long f232A = 0;

    /* renamed from: a */
    static String f233a = "FlurryAgent";

    /* renamed from: b */
    static String f234b = "";

    /* renamed from: c */
    private static volatile String f235c = "market://";

    /* renamed from: d */
    private static volatile String f236d = "market://details?id=";

    /* renamed from: e */
    private static volatile String f237e = "https://market.android.com/details?id=";

    /* renamed from: f */
    private static String f238f = "com.flurry.android.ACTION_CATALOG";

    /* renamed from: g */
    private static int f239g = 5000;

    /* renamed from: h */
    private String f240h;

    /* renamed from: i */
    private String f241i;

    /* renamed from: j */
    private String f242j;

    /* renamed from: k */
    private long f243k;

    /* renamed from: l */
    private long f244l;

    /* renamed from: m */
    private long f245m;

    /* renamed from: n */
    private long f246n;

    /* renamed from: o */
    private C0087aa f247o = new C0087aa();

    /* renamed from: p */
    private boolean f248p = true;

    /* renamed from: q */
    private volatile boolean f249q;

    /* renamed from: r */
    private String f250r;

    /* renamed from: s */
    private Map f251s = new HashMap();

    /* renamed from: t */
    private Handler f252t;

    /* renamed from: u */
    private boolean f253u;

    /* renamed from: v */
    private transient Map f254v = new HashMap();

    /* renamed from: w */
    private C0094ah f255w;

    /* renamed from: x */
    private List f256x = new ArrayList();

    /* renamed from: y */
    private Map f257y = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: z */
    public AppCircleCallback f258z;

    /* renamed from: a */
    static /* synthetic */ void m132a(C0120v vVar, Context context, String str) {
        if (str.startsWith(f236d)) {
            String substring = str.substring(f236d.length());
            if (vVar.f248p) {
                try {
                    C0095ai.m96a(f233a, "Launching Android Market for app " + substring);
                    context.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)));
                } catch (Exception e) {
                    C0095ai.m105c(f233a, "Cannot launch Marketplace url " + str, e);
                }
            } else {
                C0095ai.m96a(f233a, "Launching Android Market website for app " + substring);
                context.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(f237e + substring)));
            }
        } else {
            C0095ai.m106d(f233a, "Unexpected android market url scheme: " + str);
        }
    }

    static {
        new Random(System.currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3340a(Context context, C0086a aVar) {
        boolean z = true;
        synchronized (this) {
            if (!this.f249q) {
                this.f240h = aVar.f82c;
                this.f241i = aVar.f83d;
                this.f242j = aVar.f80a;
                this.f243k = aVar.f81b;
                this.f252t = aVar.f84e;
                this.f255w = new C0094ah(this.f252t, f239g);
                context.getResources().getDisplayMetrics();
                this.f257y.clear();
                this.f254v.clear();
                this.f247o.mo3283a(context, this, aVar);
                this.f251s.clear();
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(f236d + context.getPackageName()));
                if (packageManager.queryIntentActivities(intent, 65536).size() <= 0) {
                    z = false;
                }
                this.f248p = z;
                this.f249q = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3338a(long j, long j2) {
        this.f244l = j;
        this.f245m = j2;
        this.f246n = 0;
        this.f256x.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo3349a() {
        return this.f249q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3344a(String str) {
        this.f250r = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void mo3353b() {
        if (m141p()) {
            this.f247o.mo3290d();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized void mo3355c() {
        if (m141p()) {
            this.f247o.mo3291e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3347a(Map map, Map map2, Map map3, Map map4, Map map5, Map map6) {
        if (m141p()) {
            this.f247o.mo3284a(map, map2, map3, map4, map5, map6);
            Log.i("FlurryAgent", this.f247o.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final synchronized long mo3356d() {
        long c;
        if (!m141p()) {
            c = 0;
        } else {
            c = this.f247o.mo3289c();
        }
        return c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final synchronized Set mo3357e() {
        Set a;
        if (!m141p()) {
            a = Collections.emptySet();
        } else {
            a = this.f247o.mo3282a();
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized AdImage mo3334a(long j) {
        AdImage b;
        if (!m141p()) {
            b = null;
        } else {
            b = this.f247o.mo3286b(j);
        }
        return b;
    }

    /* renamed from: n */
    private synchronized AdImage m139n() {
        AdImage a;
        if (!m141p()) {
            a = null;
        } else {
            a = this.f247o.mo3280a(1);
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final synchronized List mo3358f() {
        return this.f256x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized C0114p mo3351b(long j) {
        return (C0114p) this.f254v.get(Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final synchronized void mo3359g() {
        this.f254v.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3342a(Context context, String str) {
        if (m141p()) {
            try {
                List a = m131a(Arrays.asList(new String[]{str}), (Long) null);
                if (a == null || a.isEmpty()) {
                    Intent intent = new Intent(m140o());
                    intent.addCategory("android.intent.category.DEFAULT");
                    context.startActivity(intent);
                } else {
                    C0114p pVar = new C0114p(str, (byte) 2, mo3362j());
                    pVar.f218c = (C0121w) a.get(0);
                    m136c(pVar);
                    m134b(context, pVar, this.f240h + mo3335a(pVar));
                }
            } catch (Exception e) {
                C0095ai.m107d(f233a, "Failed to launch promotional canvas for hook: " + str, e);
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3343a(AppCircleCallback appCircleCallback) {
        this.f258z = appCircleCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3348a(boolean z) {
        this.f253u = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final boolean mo3360h() {
        return this.f253u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final String mo3361i() {
        return this.f240h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3341a(Context context, C0114p pVar, String str) {
        if (m141p()) {
            this.f252t.post(new C0098al(this, str, context, pVar));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m137d(String str) {
        try {
            if (str.startsWith(f235c)) {
                return str;
            }
            HttpResponse execute = new DefaultHttpClient().execute(new HttpGet(str));
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String entityUtils = EntityUtils.toString(execute.getEntity());
                if (!entityUtils.startsWith(f235c)) {
                    return m137d(entityUtils);
                }
                return entityUtils;
            }
            C0095ai.m104c(f233a, "Cannot process with responseCode " + statusCode);
            m138e("Error when fetching application's android market ID, responseCode " + statusCode);
            return str;
        } catch (UnknownHostException e) {
            C0095ai.m104c(f233a, "Unknown host: " + e.getMessage());
            if (this.f258z != null) {
                m138e("Unknown host: " + e.getMessage());
            }
            return null;
        } catch (Exception e2) {
            C0095ai.m105c(f233a, "Failed on url: " + str, e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m138e(String str) {
        m133a((Runnable) new C0092af(this, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized Offer mo3350b(String str) {
        Offer offer = null;
        synchronized (this) {
            if (m141p()) {
                List a = m131a(Arrays.asList(new String[]{str}), (Long) null);
                if (a != null && !a.isEmpty()) {
                    offer = m128a(str, (C0121w) a.get(0));
                    C0095ai.m96a(f233a, "Impression for offer with ID " + offer.getId());
                }
            }
        }
        return offer;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3339a(Context context, long j) {
        if (m141p()) {
            C0119u uVar = (C0119u) this.f257y.get(Long.valueOf(j));
            if (uVar == null) {
                C0095ai.m101b(f233a, "Cannot find offer " + j);
            } else {
                C0114p b = mo3352b(uVar.f227b);
                uVar.f227b = b;
                C0095ai.m96a(f233a, "Offer " + uVar.f226a + " accepted. Sent with cookies: " + this.f251s);
                mo3341a(context, b, FlurryAgent.m37c() + mo3335a(b));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized List mo3354c(String str) {
        List arrayList;
        if (!m141p()) {
            arrayList = Collections.emptyList();
        } else if (!this.f247o.mo3288b()) {
            arrayList = Collections.emptyList();
        } else {
            C0121w[] a = this.f247o.mo3285a(str);
            arrayList = new ArrayList();
            if (a != null && a.length > 0) {
                for (C0121w a2 : a) {
                    arrayList.add(m128a(str, a2));
                }
            }
            C0095ai.m96a(f233a, "Impressions for " + arrayList.size() + " offers.");
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3346a(List list) {
        if (m141p()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f257y.remove((Long) it.next());
            }
        }
    }

    /* renamed from: a */
    private Offer m128a(String str, C0121w wVar) {
        C0114p pVar = new C0114p(str, (byte) 3, mo3362j());
        m136c(pVar);
        pVar.mo3325a(new C0104f((byte) 2, mo3362j()));
        pVar.f218c = wVar;
        C0099am a = this.f247o.mo3281a(wVar.f259a);
        String str2 = a == null ? "" : a.f123a;
        int i = a == null ? 0 : a.f125c;
        long j = f232A + 1;
        f232A = j;
        C0119u uVar = new C0119u(j, pVar, wVar.f266h, wVar.f262d, str2, i);
        this.f257y.put(Long.valueOf(uVar.f226a), uVar);
        return new Offer(uVar.f226a, uVar.f231f, uVar.f228c, uVar.f229d, uVar.f230e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized List mo3336a(Context context, List list, Long l, int i, boolean z) {
        List emptyList;
        if (!m141p()) {
            emptyList = Collections.emptyList();
        } else if (!this.f247o.mo3288b() || list == null) {
            emptyList = Collections.emptyList();
        } else {
            List a = m131a(list, l);
            int min = Math.min(list.size(), a.size());
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < min; i2++) {
                String str = (String) list.get(i2);
                C0103e b = this.f247o.mo3287b(str);
                if (b != null) {
                    C0114p pVar = new C0114p((String) list.get(i2), (byte) 1, mo3362j());
                    m136c(pVar);
                    if (i2 < a.size()) {
                        pVar.f218c = (C0121w) a.get(i2);
                        pVar.mo3325a(new C0104f((byte) 2, mo3362j()));
                        arrayList.add(new C0124z(context, this, pVar, b, i, z));
                    }
                } else {
                    C0095ai.m106d(f233a, "Cannot find hook: " + str);
                }
            }
            emptyList = arrayList;
        }
        return emptyList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized View mo3333a(Context context, String str, int i) {
        C0113o oVar;
        if (!m141p()) {
            oVar = null;
        } else {
            oVar = new C0113o(this, context, str, i);
            this.f255w.mo3301a(oVar);
        }
        return oVar;
    }

    /* renamed from: c */
    private void m136c(C0114p pVar) {
        if (this.f256x.size() < 32767) {
            this.f256x.add(pVar);
            this.f254v.put(Long.valueOf(pVar.mo3324a()), pVar);
        }
    }

    /* renamed from: a */
    private List m131a(List list, Long l) {
        if (list == null || list.isEmpty() || !this.f247o.mo3288b()) {
            return Collections.emptyList();
        }
        C0121w[] a = this.f247o.mo3285a((String) list.get(0));
        if (a == null || a.length <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(a));
        Collections.shuffle(arrayList);
        if (l != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((C0121w) it.next()).f259a == l.longValue()) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return arrayList.subList(0, Math.min(arrayList.size(), list.size()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final synchronized long mo3362j() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f245m;
        if (elapsedRealtime <= this.f246n) {
            elapsedRealtime = this.f246n + 1;
            this.f246n = elapsedRealtime;
        }
        this.f246n = elapsedRealtime;
        return this.f246n;
    }

    public final synchronized void onClick(View view) {
        C0124z zVar = (C0124z) view;
        C0114p b = mo3352b(zVar.mo3374a());
        zVar.mo3375a(b);
        String a = mo3335a(b);
        if (this.f253u) {
            m134b(view.getContext(), b, this.f240h + a);
        } else {
            mo3341a(view.getContext(), b, this.f241i + a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3345a(String str, String str2) {
        this.f251s.put(str, str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final synchronized void mo3363k() {
        this.f251s.clear();
    }

    /* renamed from: b */
    private void m134b(Context context, C0114p pVar, String str) {
        Intent intent = new Intent(m140o());
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("u", str);
        if (pVar != null) {
            intent.putExtra("o", pVar.mo3324a());
        }
        context.startActivity(intent);
    }

    /* renamed from: o */
    private static String m140o() {
        return FlurryAgent.f18a != null ? FlurryAgent.f18a : f238f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized String mo3335a(C0114p pVar) {
        StringBuilder append;
        C0121w wVar = pVar.f218c;
        append = new StringBuilder().append("?apik=").append(this.f242j).append("&cid=").append(wVar.f263e).append("&adid=").append(wVar.f259a).append("&pid=").append(this.f250r).append("&iid=").append(this.f243k).append("&sid=").append(this.f244l).append("&lid=").append(pVar.f217b).append("&aso=").append(((C0104f) pVar.f220e.get(pVar.f220e.size() - 1)).f196b).append("&hid=").append(C0116r.m122a(pVar.f216a)).append("&ac=").append(m130a(wVar.f265g));
        if (this.f251s != null && !this.f251s.isEmpty()) {
            for (Map.Entry entry : this.f251s.entrySet()) {
                append.append("&").append("c_" + C0116r.m122a((String) entry.getKey())).append("=").append(C0116r.m122a((String) entry.getValue()));
            }
        }
        append.append("&ats=").append(System.currentTimeMillis());
        return append.toString();
    }

    /* renamed from: a */
    private static String m130a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] >> 4) & 15;
            if (i2 < 10) {
                sb.append((char) (i2 + 48));
            } else {
                sb.append((char) ((i2 + 65) - 10));
            }
            byte b = bArr[i] & 15;
            if (b < 10) {
                sb.append((char) (b + 48));
            } else {
                sb.append((char) ((b + 65) - 10));
            }
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[adLogs=").append(this.f256x).append("]");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final synchronized AdImage mo3364l() {
        AdImage n;
        if (!m141p()) {
            n = null;
        } else {
            n = m139n();
        }
        return n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized C0114p mo3352b(C0114p pVar) {
        if (!this.f256x.contains(pVar)) {
            C0114p pVar2 = new C0114p(pVar, mo3362j());
            this.f256x.add(pVar2);
            pVar = pVar2;
        }
        pVar.mo3325a(new C0104f((byte) 4, mo3362j()));
        return pVar;
    }

    /* renamed from: a */
    private static void m133a(Runnable runnable) {
        new Handler().post(runnable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3337a(int i) {
        if (this.f258z != null) {
            m133a((Runnable) new C0091ae(this, i));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final synchronized boolean mo3365m() {
        boolean b;
        if (!m141p()) {
            b = false;
        } else {
            b = this.f247o.mo3288b();
        }
        return b;
    }

    /* renamed from: p */
    private boolean m141p() {
        if (!this.f249q) {
            C0095ai.m106d(f233a, "AppCircle is not initialized");
        }
        if (this.f250r == null) {
            C0095ai.m106d(f233a, "Cannot identify UDID.");
        }
        return this.f249q;
    }
}
