package com.google.android.gms.internal;

import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class zzw implements zzy {

    /* renamed from: a */
    protected final HttpClient f7054a;

    public final class zza extends HttpEntityEnclosingRequestBase {
        public zza() {
        }

        public zza(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public zzw(HttpClient httpClient) {
        this.f7054a = httpClient;
    }

    /* renamed from: a */
    static HttpUriRequest m7599a(zzk zzk, Map map) {
        switch (zzk.getMethod()) {
            case -1:
                byte[] zzl = zzk.zzl();
                if (zzl == null) {
                    return new HttpGet(zzk.getUrl());
                }
                HttpPost httpPost = new HttpPost(zzk.getUrl());
                httpPost.addHeader("Content-Type", zzk.zzk());
                httpPost.setEntity(new ByteArrayEntity(zzl));
                return httpPost;
            case 0:
                return new HttpGet(zzk.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(zzk.getUrl());
                httpPost2.addHeader("Content-Type", zzk.zzo());
                m7600a((HttpEntityEnclosingRequestBase) httpPost2, zzk);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(zzk.getUrl());
                httpPut.addHeader("Content-Type", zzk.zzo());
                m7600a((HttpEntityEnclosingRequestBase) httpPut, zzk);
                return httpPut;
            case 3:
                return new HttpDelete(zzk.getUrl());
            case 4:
                return new HttpHead(zzk.getUrl());
            case 5:
                return new HttpOptions(zzk.getUrl());
            case 6:
                return new HttpTrace(zzk.getUrl());
            case 7:
                zza zza2 = new zza(zzk.getUrl());
                zza2.addHeader("Content-Type", zzk.zzo());
                m7600a((HttpEntityEnclosingRequestBase) zza2, zzk);
                return zza2;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    /* renamed from: a */
    private static void m7600a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, zzk zzk) {
        byte[] zzp = zzk.zzp();
        if (zzp != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(zzp));
        }
    }

    /* renamed from: a */
    private static void m7601a(HttpUriRequest httpUriRequest, Map map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9154a(HttpUriRequest httpUriRequest) {
    }

    public HttpResponse zza(zzk zzk, Map map) {
        HttpUriRequest a = m7599a(zzk, map);
        m7601a(a, map);
        m7601a(a, zzk.getHeaders());
        mo9154a(a);
        HttpParams params = a.getParams();
        int zzs = zzk.zzs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, zzs);
        return this.f7054a.execute(a);
    }
}
