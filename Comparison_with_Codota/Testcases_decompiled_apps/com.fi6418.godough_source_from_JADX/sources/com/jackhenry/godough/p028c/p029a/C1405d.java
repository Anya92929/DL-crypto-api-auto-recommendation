package com.jackhenry.godough.p028c.p029a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.jackhenry.godough.core.GoDoughApp;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.jackhenry.godough.c.a.d */
public class C1405d implements C1404c {

    /* renamed from: a */
    HttpsURLConnection f5757a;

    /* renamed from: a */
    public C1404c mo9463a(URL url) {
        C1405d dVar = new C1405d();
        dVar.mo9480b(url);
        return dVar;
    }

    /* renamed from: a */
    public OutputStream mo9464a() {
        return this.f5757a.getOutputStream();
    }

    /* renamed from: a */
    public void mo9465a(int i) {
        this.f5757a.setReadTimeout(i);
    }

    /* renamed from: a */
    public void mo9466a(String str) {
        this.f5757a.setRequestMethod(str);
    }

    /* renamed from: a */
    public void mo9467a(String str, String str2) {
        this.f5757a.setRequestProperty(str, str2);
    }

    /* renamed from: a */
    public void mo9468a(boolean z) {
        this.f5757a.setDoOutput(z);
    }

    /* renamed from: b */
    public InputStream mo9469b() {
        return this.f5757a.getInputStream();
    }

    /* renamed from: b */
    public String mo9470b(String str) {
        return this.f5757a.getHeaderField(str);
    }

    /* renamed from: b */
    public void mo9471b(int i) {
        this.f5757a.setConnectTimeout(i);
    }

    /* renamed from: b */
    public void mo9480b(URL url) {
        this.f5757a = (HttpsURLConnection) url.openConnection();
    }

    /* renamed from: b */
    public void mo9472b(boolean z) {
        this.f5757a.setInstanceFollowRedirects(z);
    }

    /* renamed from: c */
    public InputStream mo9473c() {
        return this.f5757a.getErrorStream();
    }

    /* renamed from: c */
    public void mo9474c(int i) {
        this.f5757a.setChunkedStreamingMode(i);
    }

    /* renamed from: d */
    public int mo9475d() {
        return this.f5757a.getResponseCode();
    }

    /* renamed from: e */
    public String mo9476e() {
        return this.f5757a.getResponseMessage();
    }

    /* renamed from: f */
    public Map<String, List<String>> mo9477f() {
        return this.f5757a.getHeaderFields();
    }

    /* renamed from: g */
    public boolean mo9478g() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) GoDoughApp.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: h */
    public void mo9479h() {
        this.f5757a.disconnect();
    }
}
