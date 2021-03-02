package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.internal.C1249hb;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.s */
class C0194s extends Thread implements C0170f {

    /* renamed from: yX */
    private static C0194s f238yX;
    private volatile boolean mClosed = false;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: yT */
    private final LinkedBlockingQueue<Runnable> f239yT = new LinkedBlockingQueue<>();

    /* renamed from: yU */
    private volatile boolean f240yU = false;
    /* access modifiers changed from: private */

    /* renamed from: yV */
    public volatile List<C1249hb> f241yV;
    /* access modifiers changed from: private */

    /* renamed from: yW */
    public volatile String f242yW;
    /* access modifiers changed from: private */

    /* renamed from: yY */
    public volatile C0157af f243yY;

    private C0194s(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    /* renamed from: B */
    static C0194s m254B(Context context) {
        if (f238yX == null) {
            f238yX = new C0194s(context);
        }
        return f238yX;
    }

    /* renamed from: C */
    static String m255C(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                C0207z.m306T("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                C0207z.m309W("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            C0207z.m307U("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            C0207z.m307U("No campaign data found.");
            return null;
        } catch (IOException e2) {
            C0207z.m306T("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    /* renamed from: ah */
    static int m259ah(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = ((i << 6) & 65535) + charAt + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    /* renamed from: g */
    private String m266g(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public String m267v(Map<String, String> map) {
        return (!map.containsKey("useSecure") || C0162aj.m149e(map.get("useSecure"), true)) ? "https:" : "http:";
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public boolean m268w(Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = C0162aj.m142a(map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (m259ah(map.get("&cid")) % 10000)) < a * 100.0d) {
            return false;
        }
        C0207z.m308V(String.format("%s hit sampled out", new Object[]{map.get("&t") == null ? "unknown" : map.get("&t")}));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m269x(Map<String, String> map) {
        C0178l w = C0150a.m78w(this.mContext);
        C0162aj.m144a(map, "&adid", w);
        C0162aj.m144a(map, "&ate", w);
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m270y(Map<String, String> map) {
        C0171g dQ = C0171g.m175dQ();
        C0162aj.m144a(map, "&an", (C0178l) dQ);
        C0162aj.m144a(map, "&av", (C0178l) dQ);
        C0162aj.m144a(map, "&aid", (C0178l) dQ);
        C0162aj.m144a(map, "&aiid", (C0178l) dQ);
        map.put("&v", "1");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3723b(Runnable runnable) {
        this.f239yT.add(runnable);
    }

    /* renamed from: dI */
    public void mo3694dI() {
        mo3723b((Runnable) new Runnable() {
            public void run() {
                C0194s.this.f243yY.mo3622dI();
            }
        });
    }

    /* renamed from: dO */
    public void mo3695dO() {
        mo3723b((Runnable) new Runnable() {
            public void run() {
                C0194s.this.f243yY.mo3623dO();
            }
        });
    }

    /* renamed from: dP */
    public LinkedBlockingQueue<Runnable> mo3696dP() {
        return this.f239yT;
    }

    public void dispatch() {
        mo3723b((Runnable) new Runnable() {
            public void run() {
                C0194s.this.f243yY.dispatch();
            }
        });
    }

    public Thread getThread() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.f243yY.mo3625eh();
        this.f241yV = new ArrayList();
        this.f241yV.add(new C1249hb("appendVersion", "&_v".substring(1), "ma4.0.3"));
        this.f241yV.add(new C1249hb("appendQueueTime", "&qt".substring(1), (String) null));
        this.f241yV.add(new C1249hb("appendCacheBuster", "&z".substring(1), (String) null));
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            C0207z.m309W("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.f243yY == null) {
                this.f243yY = new C0186r(this.mContext, this);
            }
            init();
            this.f242yW = m255C(this.mContext);
            C0207z.m308V("Initialized GA Thread");
        } catch (Throwable th) {
            C0207z.m306T("Error initializing the GAThread: " + m266g(th));
            C0207z.m306T("Google Analytics will not start up.");
            this.f240yU = true;
        }
        while (!this.mClosed) {
            try {
                Runnable take = this.f239yT.take();
                if (!this.f240yU) {
                    take.run();
                }
            } catch (InterruptedException e2) {
                C0207z.m307U(e2.toString());
            } catch (Throwable th2) {
                C0207z.m306T("Error on GAThread: " + m266g(th2));
                C0207z.m306T("Google Analytics is shutting down.");
                this.f240yU = true;
            }
        }
    }

    /* renamed from: u */
    public void mo3699u(Map<String, String> map) {
        final HashMap hashMap = new HashMap(map);
        String str = map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        mo3723b((Runnable) new Runnable() {
            public void run() {
                C0194s.this.m269x(hashMap);
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&cid"))) {
                    hashMap.put("&cid", C0172h.m182dR().getValue("&cid"));
                }
                if (!GoogleAnalytics.getInstance(C0194s.this.mContext).getAppOptOut() && !C0194s.this.m268w(hashMap)) {
                    if (!TextUtils.isEmpty(C0194s.this.f242yW)) {
                        C0199t.m276eq().mo3730B(true);
                        hashMap.putAll(new HitBuilders.HitBuilder().setCampaignParamsFromUrl(C0194s.this.f242yW).build());
                        C0199t.m276eq().mo3730B(false);
                        String unused = C0194s.this.f242yW = null;
                    }
                    C0194s.this.m270y(hashMap);
                    C0194s.this.f243yY.mo3621b(C0205x.m304z(hashMap), Long.valueOf((String) hashMap.get("&ht")).longValue(), C0194s.this.m267v(hashMap), C0194s.this.f241yV);
                }
            }
        });
    }
}
