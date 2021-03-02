package com.google.ads.internal;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0264l;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0284b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.parse.entity.mime.MIME;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.google.ads.internal.f */
public final class C0249f implements Runnable {

    /* renamed from: a */
    private final C0264l f562a;

    /* renamed from: b */
    private final C0251a f563b;

    /* renamed from: c */
    private volatile boolean f564c;

    /* renamed from: d */
    private boolean f565d;

    /* renamed from: e */
    private String f566e;

    /* renamed from: f */
    private Thread f567f;

    /* renamed from: com.google.ads.internal.f$a */
    public interface C0251a {
        /* renamed from: a */
        HttpURLConnection mo3575a(URL url) throws IOException;
    }

    C0249f(C0264l lVar) {
        this(lVar, new C0251a() {
            /* renamed from: a */
            public HttpURLConnection mo3575a(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }
        });
    }

    C0249f(C0264l lVar, C0251a aVar) {
        this.f567f = null;
        this.f562a = lVar;
        this.f563b = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3571a() {
        this.f564c = true;
    }

    /* renamed from: a */
    private void m338a(HttpURLConnection httpURLConnection) {
        m341b(httpURLConnection);
        m345f(httpURLConnection);
        m346g(httpURLConnection);
        m347h(httpURLConnection);
        m348i(httpURLConnection);
        m344e(httpURLConnection);
        m349j(httpURLConnection);
        m350k(httpURLConnection);
        m351l(httpURLConnection);
        m343d(httpURLConnection);
        m342c(httpURLConnection);
        m352m(httpURLConnection);
        m353n(httpURLConnection);
    }

    /* renamed from: b */
    private void m341b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Debug-Dialog");
        if (!TextUtils.isEmpty(headerField)) {
            this.f562a.f612b.mo3726a().mo3509f(headerField);
        }
    }

    /* renamed from: c */
    private void m342c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(MIME.CONTENT_TYPE);
        if (!TextUtils.isEmpty(headerField)) {
            this.f562a.f612b.mo3726a().mo3500b(headerField);
        }
    }

    /* renamed from: d */
    private void m343d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Mediation");
        if (!TextUtils.isEmpty(headerField)) {
            this.f562a.f612b.mo3726a().mo3501b(Boolean.valueOf(headerField).booleanValue());
        }
    }

    /* renamed from: e */
    private void m344e(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Interstitial-Timeout");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                this.f562a.f611a.mo3725a().f655b.mo3725a().mo3526a((long) (Float.parseFloat(headerField) * 1000.0f));
            } catch (NumberFormatException e) {
                C0284b.m489d("Could not get timeout value: " + headerField, e);
            }
        }
    }

    /* renamed from: f */
    private void m345f(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String b : headerField.trim().split("\\s+")) {
                this.f562a.f611a.mo3725a().f655b.mo3725a().mo3541b(b);
            }
        }
    }

    /* renamed from: g */
    private void m346g(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Manual-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String c : headerField.trim().split("\\s+")) {
                this.f562a.f611a.mo3725a().f655b.mo3725a().mo3544c(c);
            }
        }
    }

    /* renamed from: h */
    private void m347h(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Click-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String a : headerField.trim().split("\\s+")) {
                this.f562a.f612b.mo3726a().mo3496a(a);
            }
        }
    }

    /* renamed from: i */
    private void m348i(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Refresh-Rate");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                float parseFloat = Float.parseFloat(headerField);
                C0247d a = this.f562a.f611a.mo3725a().f655b.mo3725a();
                if (parseFloat > BitmapDescriptorFactory.HUE_RED) {
                    a.mo3523a(parseFloat);
                    if (!a.mo3561t()) {
                        a.mo3548g();
                    }
                } else if (a.mo3561t()) {
                    a.mo3547f();
                }
            } catch (NumberFormatException e) {
                C0284b.m489d("Could not get refresh value: " + headerField, e);
            }
        }
    }

    /* renamed from: j */
    private void m349j(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Orientation");
        if (TextUtils.isEmpty(headerField)) {
            return;
        }
        if (headerField.equals("portrait")) {
            this.f562a.f612b.mo3726a().mo3490a(AdUtil.m454b());
        } else if (headerField.equals("landscape")) {
            this.f562a.f612b.mo3726a().mo3490a(AdUtil.m436a());
        }
    }

    /* renamed from: k */
    private void m350k(HttpURLConnection httpURLConnection) {
        if (!TextUtils.isEmpty(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"))) {
            try {
                this.f562a.f611a.mo3725a().f655b.mo3725a().mo3539b(Long.parseLong(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life")));
            } catch (NumberFormatException e) {
                C0284b.m490e("Got bad value of Doritos cookie cache life from header: " + httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life") + ". Using default value instead.");
            }
        }
    }

    /* renamed from: a */
    public void mo3573a(boolean z) {
        this.f565d = z;
    }

    /* renamed from: l */
    private void m351l(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Cache-Control");
        if (!TextUtils.isEmpty(headerField)) {
            this.f562a.f612b.mo3726a().mo3503c(headerField);
        }
    }

    /* renamed from: m */
    private void m352m(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Ad-Size");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                String[] split = headerField.split("x", 2);
                if (split.length != 2) {
                    C0284b.m490e("Could not parse size header: " + headerField);
                    return;
                }
                this.f562a.f612b.mo3726a().mo3494a(new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            } catch (NumberFormatException e) {
                C0284b.m490e("Could not parse size header: " + headerField);
            }
        }
    }

    /* renamed from: n */
    private void m353n(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Disable-Activation-And-Scroll");
        if (!TextUtils.isEmpty(headerField)) {
            this.f562a.f612b.mo3726a().mo3498a(headerField.equals("1"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3572a(String str) {
        if (this.f567f == null) {
            this.f566e = str;
            this.f564c = false;
            this.f567f = new Thread(this);
            this.f567f.start();
        }
    }

    /* renamed from: a */
    private void m339a(HttpURLConnection httpURLConnection, int i) throws IOException {
        if (300 <= i && i < 400) {
            String headerField = httpURLConnection.getHeaderField("Location");
            if (headerField == null) {
                C0284b.m486c("Could not get redirect location from a " + i + " redirect.");
                this.f562a.f612b.mo3726a().mo3491a(AdRequest.ErrorCode.INTERNAL_ERROR);
                mo3571a();
                return;
            }
            m338a(httpURLConnection);
            this.f566e = headerField;
        } else if (i == 200) {
            m338a(httpURLConnection);
            String trim = AdUtil.m442a((Readable) new InputStreamReader(httpURLConnection.getInputStream())).trim();
            C0284b.m480a("Response content is: " + trim);
            if (TextUtils.isEmpty(trim)) {
                C0284b.m480a("Response message is null or zero length: " + trim);
                this.f562a.f612b.mo3726a().mo3491a(AdRequest.ErrorCode.NO_FILL);
                mo3571a();
                return;
            }
            this.f562a.f612b.mo3726a().mo3497a(trim, this.f566e);
            mo3571a();
        } else if (i == 400) {
            C0284b.m486c("Bad request");
            this.f562a.f612b.mo3726a().mo3491a(AdRequest.ErrorCode.INVALID_REQUEST);
            mo3571a();
        } else {
            C0284b.m486c("Invalid response code: " + i);
            this.f562a.f612b.mo3726a().mo3491a(AdRequest.ErrorCode.INTERNAL_ERROR);
            mo3571a();
        }
    }

    public void run() {
        try {
            m340b();
        } catch (MalformedURLException e) {
            C0284b.m485b("Received malformed ad url from javascript.", e);
            this.f562a.f612b.mo3726a().mo3491a(AdRequest.ErrorCode.INTERNAL_ERROR);
        } catch (IOException e2) {
            C0284b.m485b("IOException connecting to ad url.", e2);
            this.f562a.f612b.mo3726a().mo3491a(AdRequest.ErrorCode.NETWORK_ERROR);
        } catch (Throwable th) {
            C0284b.m485b("An unknown error occurred in AdResponseLoader.", th);
            this.f562a.f612b.mo3726a().mo3491a(AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    /* renamed from: b */
    private void m340b() throws MalformedURLException, IOException {
        while (!this.f564c) {
            HttpURLConnection a = this.f563b.mo3575a(new URL(this.f566e));
            try {
                m337a(this.f562a.f611a.mo3725a().f659f.mo3725a(), a);
                AdUtil.m447a(a, this.f562a.f611a.mo3725a().f659f.mo3725a());
                a.setInstanceFollowRedirects(false);
                a.connect();
                m339a(a, a.getResponseCode());
            } finally {
                a.disconnect();
            }
        }
    }

    /* renamed from: a */
    private void m337a(Context context, HttpURLConnection httpURLConnection) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("drt", "");
        if (this.f565d && !TextUtils.isEmpty(string)) {
            if (AdUtil.f690a == 8) {
                httpURLConnection.addRequestProperty("X-Afma-drt-Cookie", string);
            } else {
                httpURLConnection.addRequestProperty("Cookie", string);
            }
        }
    }
}
