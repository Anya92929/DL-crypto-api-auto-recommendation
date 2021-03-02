package com.google.android.gms.p018c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.google.android.gms.c.ak */
public final class C0622ak implements C0635ax {

    /* renamed from: a */
    private static final Uri f4225a;

    /* renamed from: b */
    private final LogPrinter f4226b = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("local");
        f4225a = builder.build();
    }

    /* renamed from: a */
    public Uri mo6940a() {
        return f4225a;
    }

    /* renamed from: a */
    public void mo6941a(C0624am amVar) {
        ArrayList<C0626ao> arrayList = new ArrayList<>(amVar.mo6999b());
        Collections.sort(arrayList, new C0623al(this));
        StringBuilder sb = new StringBuilder();
        for (C0626ao obj : arrayList) {
            String obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj2);
            }
        }
        this.f4226b.println(sb.toString());
    }
}
