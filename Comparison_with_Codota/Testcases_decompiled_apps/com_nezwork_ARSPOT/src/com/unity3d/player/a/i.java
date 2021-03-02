package com.unity3d.player.a;

import android.content.Context;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public final class i {
    private long a;
    private long b;
    private long c;
    private long d;
    private long e = 0;
    private int f;
    private j g;

    public i(Context context, h hVar) {
        this.g = new j(context.getSharedPreferences("com.android.vending.licensing.ServerManagedPolicy", 0), hVar);
        this.f = Integer.decode(this.g.b("lastResponse", Integer.toString(-1))).intValue();
        this.a = Long.parseLong(this.g.b("validityTimestamp", "0"));
        this.b = Long.parseLong(this.g.b("retryUntil", "0"));
        this.c = Long.parseLong(this.g.b("maxRetries", "0"));
        this.d = Long.parseLong(this.g.b("retryCount", "0"));
    }

    private void a(long j) {
        this.d = j;
        this.g.a("retryCount", Long.toString(j));
    }

    private void a(String str) {
        Long valueOf;
        try {
            valueOf = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e2) {
            valueOf = Long.valueOf(System.currentTimeMillis() + 60000);
            str = Long.toString(valueOf.longValue());
        }
        this.a = valueOf.longValue();
        this.g.a("validityTimestamp", str);
    }

    private void b(String str) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e2) {
            str = "0";
            l = 0L;
        }
        this.b = l.longValue();
        this.g.a("retryUntil", str);
    }

    private void c(String str) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e2) {
            str = "0";
            l = 0L;
        }
        this.c = l.longValue();
        this.g.a("maxRetries", str);
    }

    private static Map d(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI("?" + str), "UTF-8")) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
        } catch (URISyntaxException e2) {
        }
        return hashMap;
    }

    public final void a(int i, k kVar) {
        if (i != -1) {
            a(0);
        } else {
            a(this.d + 1);
        }
        if (i == 1) {
            Map d2 = d(kVar.g);
            this.f = i;
            a((String) d2.get("VT"));
            b((String) d2.get("GT"));
            c((String) d2.get("GR"));
        } else if (i == 0) {
            a("0");
            b("0");
            c("0");
        }
        this.e = System.currentTimeMillis();
        this.f = i;
        this.g.a("lastResponse", Integer.toString(i));
        this.g.a();
    }

    public final boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f == 1) {
            if (currentTimeMillis <= this.a) {
                return true;
            }
        } else if (this.f == -1 && currentTimeMillis < this.e + 60000) {
            return currentTimeMillis <= this.b || this.d <= this.c;
        }
        return false;
    }
}
