package com.google.ads.internal;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class f implements Runnable {
    private final c a;
    private final d b;
    private final a c;
    private volatile boolean d;
    private boolean e;
    private String f;
    private Thread g;

    public interface a {
        HttpURLConnection a(URL url) throws IOException;
    }

    f(c cVar, d dVar) {
        this(cVar, dVar, new a() {
            public HttpURLConnection a(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }
        });
    }

    f(c cVar, d dVar, a aVar) {
        this.g = null;
        this.a = cVar;
        this.b = dVar;
        this.c = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.d = true;
    }

    private void a(HttpURLConnection httpURLConnection) {
        b(httpURLConnection);
        f(httpURLConnection);
        g(httpURLConnection);
        h(httpURLConnection);
        e(httpURLConnection);
        i(httpURLConnection);
        j(httpURLConnection);
        k(httpURLConnection);
        d(httpURLConnection);
        c(httpURLConnection);
        l(httpURLConnection);
    }

    private void b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Debug-Dialog");
        if (!TextUtils.isEmpty(headerField)) {
            this.a.e(headerField);
        }
    }

    private void c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Type");
        if (!TextUtils.isEmpty(headerField)) {
            this.a.b(headerField);
        }
    }

    private void d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Mediation");
        if (!TextUtils.isEmpty(headerField)) {
            this.a.a(Boolean.valueOf(headerField).booleanValue());
        }
    }

    private void e(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Interstitial-Timeout");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                this.b.a((long) (Float.parseFloat(headerField) * 1000.0f));
            } catch (NumberFormatException e2) {
                b.d("Could not get timeout value: " + headerField, e2);
            }
        }
    }

    private void f(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String b2 : headerField.trim().split("\\s+")) {
                this.b.b(b2);
            }
        }
    }

    private void g(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Click-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String a2 : headerField.trim().split("\\s+")) {
                this.a.a(a2);
            }
        }
    }

    private void h(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Refresh-Rate");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                float parseFloat = Float.parseFloat(headerField);
                if (parseFloat > 0.0f) {
                    this.b.a(parseFloat);
                    if (!this.b.s()) {
                        this.b.f();
                    }
                } else if (this.b.s()) {
                    this.b.e();
                }
            } catch (NumberFormatException e2) {
                b.d("Could not get refresh value: " + headerField, e2);
            }
        }
    }

    private void i(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Orientation");
        if (TextUtils.isEmpty(headerField)) {
            return;
        }
        if (headerField.equals("portrait")) {
            this.a.a(AdUtil.b());
        } else if (headerField.equals("landscape")) {
            this.a.a(AdUtil.a());
        }
    }

    private void j(HttpURLConnection httpURLConnection) {
        if (!TextUtils.isEmpty(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"))) {
            try {
                this.b.b(Long.parseLong(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life")));
            } catch (NumberFormatException e2) {
                b.e("Got bad value of Doritos cookie cache life from header: " + httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life") + ". Using default value instead.");
            }
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    private void k(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Cache-Control");
        if (!TextUtils.isEmpty(headerField)) {
            this.a.c(headerField);
        }
    }

    private void l(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Ad-Size");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                String[] split = headerField.split("x", 2);
                if (split.length != 2) {
                    b.e("Could not parse size header: " + headerField);
                    return;
                }
                this.a.a(new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            } catch (NumberFormatException e2) {
                b.e("Could not parse size header: " + headerField);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(String str) {
        if (this.g == null) {
            this.f = str;
            this.d = false;
            this.g = new Thread(this);
            this.g.start();
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i) throws IOException {
        if (300 <= i && i < 400) {
            String headerField = httpURLConnection.getHeaderField("Location");
            if (headerField == null) {
                b.c("Could not get redirect location from a " + i + " redirect.");
                this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
                a();
                return;
            }
            a(httpURLConnection);
            this.f = headerField;
        } else if (i == 200) {
            a(httpURLConnection);
            String trim = AdUtil.a((Readable) new InputStreamReader(httpURLConnection.getInputStream())).trim();
            b.a("Response content is: " + trim);
            if (TextUtils.isEmpty(trim)) {
                b.a("Response message is null or zero length: " + trim);
                this.a.a(AdRequest.ErrorCode.NO_FILL);
                a();
                return;
            }
            this.a.a(trim, this.f);
            a();
        } else if (i == 400) {
            b.c("Bad request");
            this.a.a(AdRequest.ErrorCode.INVALID_REQUEST);
            a();
        } else {
            b.c("Invalid response code: " + i);
            this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
            a();
        }
    }

    public void run() {
        try {
            b();
        } catch (MalformedURLException e2) {
            b.b("Received malformed ad url from javascript.", e2);
            this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
        } catch (IOException e3) {
            b.d("IOException connecting to ad url.", e3);
            this.a.a(AdRequest.ErrorCode.NETWORK_ERROR);
        } catch (Throwable th) {
            b.b("An unknown error occurred in AdResponseLoader.", th);
            this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    private void b() throws MalformedURLException, IOException {
        while (!this.d) {
            HttpURLConnection a2 = this.c.a(new URL(this.f));
            try {
                a(this.b.h().d.a(), a2);
                AdUtil.a(a2, this.b.h().d.a());
                a2.setInstanceFollowRedirects(false);
                a2.connect();
                a(a2, a2.getResponseCode());
            } finally {
                a2.disconnect();
            }
        }
    }

    private void a(Context context, HttpURLConnection httpURLConnection) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("drt", "");
        if (this.e && !TextUtils.isEmpty(string)) {
            if (AdUtil.a == 8) {
                httpURLConnection.addRequestProperty("X-Afma-drt-Cookie", string);
            } else {
                httpURLConnection.addRequestProperty("Cookie", string);
            }
        }
    }
}
