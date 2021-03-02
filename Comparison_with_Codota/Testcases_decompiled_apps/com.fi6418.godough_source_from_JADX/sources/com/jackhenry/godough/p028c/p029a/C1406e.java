package com.jackhenry.godough.p028c.p029a;

import android.text.TextUtils;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.p027b.C1389d;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/* renamed from: com.jackhenry.godough.c.a.e */
public class C1406e {

    /* renamed from: a */
    private CookieStore f5758a = GoDoughApp.getCookieManager().getCookieStore();

    /* renamed from: b */
    private URL f5759b;

    public C1406e(URL url) {
        this.f5759b = url;
    }

    /* renamed from: a */
    public synchronized void mo9481a(C1404c cVar) {
        try {
            URI uri = new URI(this.f5759b.toURI().getHost());
            List<String> list = cVar.mo9477f().get("Set-Cookie");
            if (list != null) {
                for (String parse : list) {
                    List<HttpCookie> parse2 = HttpCookie.parse(parse);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < parse2.size()) {
                            this.f5758a.add(uri, parse2.get(i2));
                            i = i2 + 1;
                        }
                    }
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new C1389d("Unable to parse URL", 1001);
        }
    }

    /* renamed from: b */
    public synchronized void mo9482b(C1404c cVar) {
        try {
            URI uri = new URI(this.f5759b.toURI().getHost());
            if (this.f5758a.getCookies().size() > 0) {
                cVar.mo9467a("Cookie", TextUtils.join(";", this.f5758a.get(uri)));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new C1389d("Unable to parse URL", 1001);
        }
    }
}
