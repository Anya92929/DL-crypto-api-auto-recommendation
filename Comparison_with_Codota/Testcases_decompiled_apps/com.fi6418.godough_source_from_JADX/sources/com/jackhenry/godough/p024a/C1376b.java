package com.jackhenry.godough.p024a;

import android.content.Context;
import android.text.TextUtils;
import com.jackhenry.godough.p024a.p025a.C1374a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.jackhenry.godough.a.b */
public abstract class C1376b<t> {

    /* renamed from: a */
    Context f5725a;

    /* renamed from: b */
    private HashMap<String, t> f5726b = new HashMap<>();

    /* renamed from: c */
    private String f5727c;

    /* renamed from: a */
    public static String m5633a(Throwable th) {
        String format = new SimpleDateFormat("MMddyyHH:mmZ").format(Calendar.getInstance().getTime());
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String[] split = stringWriter.toString().split("\\r?\\n");
        String str = "Andro@" + format + " ";
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("Exception:") || split[i].toLowerCase().contains("godough")) {
                str = str + split[i] + " ";
            }
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public t mo9422a(String str) {
        return this.f5726b.get(str);
    }

    /* renamed from: a */
    public String mo9423a() {
        return this.f5727c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9424a(C1374a aVar, t t, String str, String str2);

    /* renamed from: a */
    public final void mo9425a(C1374a aVar, String str) {
        for (Map.Entry next : this.f5726b.entrySet()) {
            mo9424a(aVar, next.getValue(), (String) next.getKey(), str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9426a(String str, t t) {
        this.f5726b.put(str, t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo9427b();

    /* renamed from: b */
    public void mo9428b(String str) {
        this.f5727c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo9429c(String str) {
        return TextUtils.isEmpty(str) ? this.f5725a.getString(C1385h.not_set) : str;
    }
}
