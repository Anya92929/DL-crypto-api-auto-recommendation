package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C0976c;
import com.google.android.gms.tagmanager.C2026bg;
import com.google.android.gms.tagmanager.C2055ce;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.tagmanager.co */
class C2066co implements Runnable {
    private final String anR;
    private volatile String aon;
    private final C2034bn aqg;
    private final String aqh;
    private C2026bg<C0976c.C0986j> aqi;
    private volatile C2146r aqj;
    private volatile String aqk;
    private final Context mContext;

    C2066co(Context context, String str, C2034bn bnVar, C2146r rVar) {
        this.mContext = context;
        this.aqg = bnVar;
        this.anR = str;
        this.aqj = rVar;
        this.aqh = "/r?id=" + str;
        this.aon = this.aqh;
        this.aqk = null;
    }

    public C2066co(Context context, String str, C2146r rVar) {
        this(context, str, new C2034bn(), rVar);
    }

    /* renamed from: oK */
    private boolean m6929oK() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C2028bh.m6818V("...no network connectivity");
        return false;
    }

    /* renamed from: oL */
    private void m6930oL() {
        if (!m6929oK()) {
            this.aqi.mo11573a(C2026bg.C2027a.NOT_AVAILABLE);
            return;
        }
        C2028bh.m6818V("Start loading resource from network ...");
        String oM = mo11635oM();
        C2033bm ov = this.aqg.mo11588ov();
        try {
            InputStream cA = ov.mo11565cA(oM);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                C2075cr.m6961b(cA, byteArrayOutputStream);
                C0976c.C0986j b = C0976c.C0986j.m4102b(byteArrayOutputStream.toByteArray());
                C2028bh.m6818V("Successfully loaded supplemented resource: " + b);
                if (b.f3008gs == null && b.f3007gr.length == 0) {
                    C2028bh.m6818V("No change for container: " + this.anR);
                }
                this.aqi.mo11574l(b);
                ov.close();
                C2028bh.m6818V("Load resource from network finished.");
            } catch (IOException e) {
                C2028bh.m6821d("Error when parsing downloaded resources from url: " + oM + " " + e.getMessage(), e);
                this.aqi.mo11573a(C2026bg.C2027a.SERVER_ERROR);
            }
        } catch (FileNotFoundException e2) {
            C2028bh.m6819W("No data is retrieved from the given url: " + oM + ". Make sure container_id: " + this.anR + " is correct.");
            this.aqi.mo11573a(C2026bg.C2027a.SERVER_ERROR);
        } catch (IOException e3) {
            C2028bh.m6821d("Error when loading resources from url: " + oM + " " + e3.getMessage(), e3);
            this.aqi.mo11573a(C2026bg.C2027a.IO_ERROR);
        } finally {
            ov.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11632a(C2026bg<C0976c.C0986j> bgVar) {
        this.aqi = bgVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cG */
    public void mo11633cG(String str) {
        C2028bh.m6815S("Setting previous container version: " + str);
        this.aqk = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cr */
    public void mo11634cr(String str) {
        if (str == null) {
            this.aon = this.aqh;
            return;
        }
        C2028bh.m6815S("Setting CTFE URL path: " + str);
        this.aon = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: oM */
    public String mo11635oM() {
        String str = this.aqj.mo11774ob() + this.aon + "&v=a65833898";
        if (this.aqk != null && !this.aqk.trim().equals("")) {
            str = str + "&pv=" + this.aqk;
        }
        return C2055ce.m6906oH().mo11630oI().equals(C2055ce.C2056a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.aqi == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.aqi.mo11575nZ();
        m6930oL();
    }
}
