package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class zzz implements zzy {

    /* renamed from: a */
    private final zza f7055a;

    /* renamed from: b */
    private final SSLSocketFactory f7056b;

    public interface zza {
        String zzh(String str);
    }

    public zzz() {
        this((zza) null);
    }

    public zzz(zza zza2) {
        this(zza2, (SSLSocketFactory) null);
    }

    public zzz(zza zza2, SSLSocketFactory sSLSocketFactory) {
        this.f7055a = zza2;
        this.f7056b = sSLSocketFactory;
    }

    /* renamed from: a */
    private HttpURLConnection m7603a(URL url, zzk zzk) {
        HttpURLConnection a = mo9157a(url);
        int zzs = zzk.zzs();
        a.setConnectTimeout(zzs);
        a.setReadTimeout(zzs);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f7056b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f7056b);
        }
        return a;
    }

    /* renamed from: a */
    private static HttpEntity m7604a(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    /* renamed from: a */
    static void m7605a(HttpURLConnection httpURLConnection, zzk zzk) {
        switch (zzk.getMethod()) {
            case -1:
                byte[] zzl = zzk.zzl();
                if (zzl != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", zzk.zzk());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(zzl);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                m7606b(httpURLConnection, zzk);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                m7606b(httpURLConnection, zzk);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                m7606b(httpURLConnection, zzk);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* renamed from: b */
    private static void m7606b(HttpURLConnection httpURLConnection, zzk zzk) {
        byte[] zzp = zzk.zzp();
        if (zzp != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", zzk.zzo());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzp);
            dataOutputStream.close();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo9157a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse zza(zzk zzk, Map map) {
        String str;
        String url = zzk.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(zzk.getHeaders());
        hashMap.putAll(map);
        if (this.f7055a != null) {
            str = this.f7055a.zzh(url);
            if (str == null) {
                String valueOf = String.valueOf(url);
                throw new IOException(valueOf.length() != 0 ? "URL blocked by rewriter: ".concat(valueOf) : new String("URL blocked by rewriter: "));
            }
        } else {
            str = url;
        }
        HttpURLConnection a = m7603a(new URL(str), zzk);
        for (String str2 : hashMap.keySet()) {
            a.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        m7605a(a, zzk);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a.getResponseCode(), a.getResponseMessage()));
        basicHttpResponse.setEntity(m7604a(a));
        for (Map.Entry entry : a.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
