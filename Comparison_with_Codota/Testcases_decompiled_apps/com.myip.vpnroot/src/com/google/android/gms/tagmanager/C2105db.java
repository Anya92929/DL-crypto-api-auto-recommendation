package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

/* renamed from: com.google.android.gms.tagmanager.db */
class C2105db implements C1990ab {
    private final Context arf;
    private final String arw = mo11729a("GoogleTagManager", "4.00", Build.VERSION.RELEASE, m7073c(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient arx;
    private C2106a ary;

    /* renamed from: com.google.android.gms.tagmanager.db$a */
    public interface C2106a {
        /* renamed from: a */
        void mo11620a(C2004ap apVar);

        /* renamed from: b */
        void mo11621b(C2004ap apVar);

        /* renamed from: c */
        void mo11622c(C2004ap apVar);
    }

    C2105db(HttpClient httpClient, Context context, C2106a aVar) {
        this.arf = context.getApplicationContext();
        this.arx = httpClient;
        this.ary = aVar;
    }

    /* renamed from: a */
    private HttpEntityEnclosingRequest m7071a(URL url) {
        URISyntaxException e;
        BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.arw);
            } catch (URISyntaxException e2) {
                e = e2;
                C2028bh.m6819W("Exception sending hit: " + e.getClass().getSimpleName());
                C2028bh.m6819W(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            C2028bh.m6819W("Exception sending hit: " + e.getClass().getSimpleName());
            C2028bh.m6819W(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    /* renamed from: a */
    private void m7072a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        int available;
        StringBuffer stringBuffer = new StringBuffer();
        for (Header obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null && (available = content.available()) > 0) {
                    byte[] bArr = new byte[available];
                    content.read(bArr);
                    stringBuffer.append("POST:\n");
                    stringBuffer.append(new String(bArr)).append("\n");
                }
            } catch (IOException e) {
                C2028bh.m6818V("Error Writing hit to log...");
            }
        }
        C2028bh.m6818V(stringBuffer.toString());
    }

    /* renamed from: c */
    static String m7073c(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            sb.append("-").append(locale.getCountry().toLowerCase());
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo11729a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public URL mo11730d(C2004ap apVar) {
        try {
            return new URL(apVar.mo11555os());
        } catch (MalformedURLException e) {
            C2028bh.m6816T("Error trying to parse the GTM url.");
            return null;
        }
    }

    /* renamed from: dY */
    public boolean mo11539dY() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.arf.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C2028bh.m6818V("...no network connectivity");
        return false;
    }

    /* renamed from: j */
    public void mo11540j(List<C2004ap> list) {
        boolean z;
        int min = Math.min(list.size(), 40);
        boolean z2 = true;
        int i = 0;
        while (i < min) {
            C2004ap apVar = list.get(i);
            URL d = mo11730d(apVar);
            if (d == null) {
                C2028bh.m6819W("No destination: discarding hit.");
                this.ary.mo11621b(apVar);
                z = z2;
            } else {
                HttpEntityEnclosingRequest a = m7071a(d);
                if (a == null) {
                    this.ary.mo11621b(apVar);
                    z = z2;
                } else {
                    HttpHost httpHost = new HttpHost(d.getHost(), d.getPort(), d.getProtocol());
                    a.addHeader("Host", httpHost.toHostString());
                    m7072a(a);
                    if (z2) {
                        try {
                            C2035bo.m6839A(this.arf);
                            z2 = false;
                        } catch (ClientProtocolException e) {
                            C2028bh.m6819W("ClientProtocolException sending hit; discarding hit...");
                            this.ary.mo11621b(apVar);
                            z = z2;
                        } catch (IOException e2) {
                            C2028bh.m6819W("Exception sending hit: " + e2.getClass().getSimpleName());
                            C2028bh.m6819W(e2.getMessage());
                            this.ary.mo11622c(apVar);
                            z = z2;
                        }
                    }
                    HttpResponse execute = this.arx.execute(httpHost, a);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        C2028bh.m6819W("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.ary.mo11622c(apVar);
                    } else {
                        this.ary.mo11620a(apVar);
                    }
                    z = z2;
                }
            }
            i++;
            z2 = z;
        }
    }
}
