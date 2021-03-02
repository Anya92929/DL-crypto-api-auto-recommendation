package org.commonwealthcu.mobile.p038a;

import android.os.AsyncTask;
import android.webkit.CookieManager;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.p004a.p005a.C0244af;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p007b.C0280e;
import org.p004a.p005a.p007b.C0286f;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p009b.C0252a;
import org.p004a.p005a.p007b.p010c.C0263j;
import org.p004a.p005a.p014d.C0323e;
import org.p004a.p005a.p022f.p023a.C0369e;
import org.p004a.p005a.p022f.p023a.C0374j;
import org.p004a.p005a.p022f.p023a.p024a.C0363a;
import org.p004a.p005a.p022f.p023a.p024a.C0364b;
import org.p004a.p005a.p025g.p027b.C0419d;
import org.p004a.p005a.p025g.p027b.C0426k;
import org.p004a.p005a.p025g.p029d.C0469c;
import org.p004a.p005a.p033i.C0532k;
import org.p004a.p005a.p034j.C0543a;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0549a;

/* renamed from: org.commonwealthcu.mobile.a.c */
public final class C0581c extends AsyncTask {

    /* renamed from: a */
    private C0583e f697a;

    /* renamed from: b */
    private String f698b;

    /* renamed from: c */
    private HashMap f699c = null;

    /* renamed from: d */
    private File f700d;

    /* renamed from: e */
    private File f701e;

    /* renamed from: f */
    private String f702f = null;

    /* renamed from: g */
    private boolean f703g = false;

    public C0581c(C0583e eVar, HashMap hashMap, File file, File file2) {
        this.f697a = eVar;
        this.f699c = hashMap;
        if (file != null) {
            this.f700d = file;
        }
        if (file2 != null) {
            this.f701e = file2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        URL url;
        String str;
        C0543a aVar = new C0543a();
        if (this.f700d == null) {
            C0250b.m104b((C0544b) aVar, 5000);
            C0250b.m93a((C0544b) aVar, 15000);
        } else {
            C0250b.m104b((C0544b) aVar, 5000);
            C0250b.m93a((C0544b) aVar, 30000);
        }
        C0426k kVar = new C0426k(aVar);
        C0263j jVar = new C0263j(strArr[0]);
        C0549a aVar2 = new C0549a();
        String cookie = CookieManager.getInstance().getCookie(strArr[0]);
        try {
            url = new URL(strArr[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        if (url != null) {
            C0419d a = m1281a(cookie, url.getHost());
            aVar2.mo5223a("http.cookie-store", a);
            kVar.mo5187a((C0286f) a);
        }
        if (strArr[1] != null) {
            kVar.mo5189c().mo5197a("http.useragent", (Object) strArr[1]);
        }
        if (this.f700d == null) {
            try {
                System.out.println("Sending Normal Action");
                ArrayList arrayList = new ArrayList();
                for (String str2 : this.f699c.keySet()) {
                    if (str2.equals("action")) {
                        this.f702f = (String) this.f699c.get(str2);
                    }
                    arrayList.add(new C0532k(str2, (String) this.f699c.get(str2)));
                }
                jVar.mo4894a(new C0252a(arrayList, "UTF-8"));
                C0570s a2 = kVar.mo5198a(jVar);
                C0244af a3 = a2.mo5345a();
                System.out.println("PM Status is: " + a3.mo4867b());
                if (this.f702f == null) {
                    this.f702f = "none";
                }
                if (a3.mo4867b() == 200) {
                    System.out.println("We've reached here PM");
                    str = new String(C0250b.m107b(a2.mo5347b()), "UTF-8");
                } else if (a3.mo4867b() == 408 || a3.mo4867b() == 504) {
                    this.f703g = true;
                    str = "";
                } else {
                    str = new String(C0250b.m107b(a2.mo5347b()), "UTF-8");
                }
            } catch (SocketTimeoutException e2) {
                System.out.println("Socket Timeout");
                this.f703g = true;
                str = "";
            } catch (C0323e e3) {
                this.f703g = true;
                str = "";
            } catch (Exception e4) {
                str = "";
            }
        } else {
            System.out.println("Sending DepositInit to Server");
            C0374j a4 = C0374j.m439a();
            a4.mo5112a(C0369e.f204b);
            a4.mo5114a("image", (C0363a) new C0364b(this.f700d));
            if (this.f701e != null) {
                System.out.println("Color Image detected");
                a4.mo5114a("imageColor", (C0363a) new C0364b(this.f701e));
            }
            for (String str3 : this.f699c.keySet()) {
                if (str3.equals("action")) {
                    this.f702f = (String) this.f699c.get(str3);
                    System.out.println("Action receieved is: " + this.f702f);
                }
                a4.mo5113a(str3, (String) this.f699c.get(str3));
            }
            jVar.mo4894a(a4.mo5115b());
            if (this.f702f == null) {
                this.f702f = "none";
            }
            try {
                C0570s a5 = kVar.mo5198a(jVar);
                C0244af a6 = a5.mo5345a();
                System.out.println("PM Status is: " + a6.mo4867b());
                if (a6.mo4867b() == 200) {
                    System.out.println("We've reached here PM");
                    str = new String(C0250b.m107b(a5.mo5347b()), "UTF-8");
                } else if (a6.mo4867b() == 408 || a6.mo4867b() == 504) {
                    this.f703g = true;
                    str = "";
                } else {
                    str = new String(C0250b.m107b(a5.mo5347b()), "UTF-8");
                }
            } catch (SocketTimeoutException e5) {
                System.out.println("Socket Timeout");
                this.f703g = true;
                str = "";
            } catch (C0323e e6) {
                this.f703g = true;
                str = "";
            } catch (C0280e e7) {
                e7.printStackTrace();
                str = "";
            } catch (IOException e8) {
                e8.printStackTrace();
                str = "";
            }
        }
        this.f698b = str;
        return str;
    }

    /* renamed from: a */
    private static C0419d m1281a(String str, String str2) {
        String[] split = str.split(";");
        C0419d dVar = new C0419d();
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            C0469c cVar = split3.length == 2 ? new C0469c(split3[0], split3[1]) : new C0469c(split3[0], (String) null);
            cVar.mo5076c(str2);
            dVar.mo4933a(cVar);
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        System.out.println("PM JSON Results are: " + ((String) obj));
        if (this.f698b != null && !this.f703g) {
            try {
                this.f697a.mo5451a(this.f698b, this.f702f);
                return;
            } catch (JSONException e) {
            }
        } else if (this.f703g) {
            System.out.println("Connection Timed Out Flag");
            this.f697a.mo5450a(this.f702f);
            return;
        }
        this.f697a.mo5454b(this.f702f);
    }
}
