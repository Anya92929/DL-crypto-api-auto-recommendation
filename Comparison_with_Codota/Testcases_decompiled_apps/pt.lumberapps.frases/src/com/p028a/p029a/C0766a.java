package com.p028a.p029a;

import com.p028a.p030b.C0768a;
import com.p028a.p030b.C0771d;
import java.net.HttpURLConnection;
import java.util.LinkedHashSet;
import org.apache.http.HttpRequest;

/* renamed from: com.a.a.a */
public abstract class C0766a {

    /* renamed from: a */
    private LinkedHashSet f1882a;

    /* renamed from: a */
    public String mo3450a(String str) {
        return str;
    }

    /* renamed from: a */
    public synchronized void mo3451a(C0768a aVar) {
        if (this.f1882a == null) {
            this.f1882a = new LinkedHashSet();
            this.f1882a.add(aVar);
            mo3457b();
        } else {
            this.f1882a.add(aVar);
        }
    }

    /* renamed from: a */
    public void mo3452a(C0768a aVar, HttpURLConnection httpURLConnection) {
    }

    /* renamed from: a */
    public void mo3453a(C0768a aVar, HttpRequest httpRequest) {
    }

    /* renamed from: a */
    public abstract boolean mo3454a();

    /* renamed from: a */
    public abstract boolean mo3455a(C0768a aVar, C0771d dVar);

    /* renamed from: b */
    public String mo3456b(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo3457b();

    /* renamed from: b */
    public abstract boolean mo3458b(C0768a aVar);
}
