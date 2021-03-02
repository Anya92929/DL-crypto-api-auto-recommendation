package org.commonwealthcu.mobile.p038a;

import android.app.Activity;
import android.os.AsyncTask;
import java.util.HashMap;
import org.commonwealthcu.mobile.MainActivity;
import org.p004a.p005a.p025g.p027b.C0419d;
import org.p004a.p005a.p025g.p029d.C0469c;

/* renamed from: org.commonwealthcu.mobile.a.d */
public final class C0582d extends AsyncTask {

    /* renamed from: a */
    private String f704a;

    /* renamed from: b */
    private HashMap f705b = null;

    /* renamed from: c */
    private Activity f706c;

    /* renamed from: d */
    private boolean f707d = false;

    public C0582d(Activity activity, HashMap hashMap) {
        this.f706c = activity;
        this.f705b = hashMap;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d7  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doInBackground(java.lang.String... r11) {
        /*
            r10 = this;
            r6 = 0
            r9 = 1
            java.lang.String r3 = ""
            org.a.a.j.a r1 = new org.a.a.j.a
            r1.<init>()
            r2 = 3000(0xbb8, float:4.204E-42)
            org.p004a.p005a.p007b.p008a.C0250b.m104b((org.p004a.p005a.p034j.C0544b) r1, (int) r2)
            r2 = 5000(0x1388, float:7.006E-42)
            org.p004a.p005a.p007b.p008a.C0250b.m104b((org.p004a.p005a.p034j.C0544b) r1, (int) r2)
            org.a.a.g.b.k r4 = new org.a.a.g.b.k
            r4.<init>(r1)
            r1 = r11[r9]
            if (r1 == 0) goto L_0x0027
            org.a.a.j.b r1 = r4.mo5189c()
            java.lang.String r2 = "http.useragent"
            r5 = r11[r9]
            r1.mo5197a((java.lang.String) r2, (java.lang.Object) r5)
        L_0x0027:
            org.a.a.b.c.j r5 = new org.a.a.b.c.j
            r1 = r11[r6]
            r5.<init>(r1)
            r2 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x013c }
            r6 = 0
            r6 = r11[r6]     // Catch:{ MalformedURLException -> 0x013c }
            r1.<init>(r6)     // Catch:{ MalformedURLException -> 0x013c }
        L_0x0037:
            if (r1 == 0) goto L_0x01bd
            android.webkit.CookieManager r2 = android.webkit.CookieManager.getInstance()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            android.webkit.CookieSyncManager r6 = android.webkit.CookieSyncManager.getInstance()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r6.sync()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r6 = r1.toString()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r2 = r2.getCookie(r6)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            if (r2 == 0) goto L_0x0062
            java.lang.String r6 = "PMPH"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r8 = "Cookies are: "
            r7.<init>(r8)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.StringBuilder r7 = r7.append(r2)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r7 = r7.toString()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            android.util.Log.d(r6, r7)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
        L_0x0062:
            if (r2 == 0) goto L_0x0079
            org.a.a.l.a r6 = new org.a.a.l.a     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r6.<init>()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r1 = r1.getHost()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            org.a.a.g.b.d r1 = m1283a(r2, r1)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r2 = "http.cookie-store"
            r6.mo5223a(r2, r1)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r4.mo5187a((org.p004a.p005a.p007b.C0286f) r1)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
        L_0x0079:
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r6 = "Sending Login Action to: "
            r2.<init>(r6)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r6 = 0
            r6 = r11[r6]     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r2 = r2.toString()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r1.println(r2)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r6.<init>()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.util.HashMap r1 = r10.f705b     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.util.Set r1 = r1.keySet()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.util.Iterator r7 = r1.iterator()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
        L_0x009f:
            boolean r1 = r7.hasNext()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            if (r1 == 0) goto L_0x0143
            java.lang.Object r1 = r7.next()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r0 = r1
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r2 = r0
            org.a.a.i.k r8 = new org.a.a.i.k     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.util.HashMap r1 = r10.f705b     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r8.<init>(r2, r1)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r6.add(r8)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            goto L_0x009f
        L_0x00be:
            r1 = move-exception
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.String r2 = "Socket Timeout"
            r1.println(r2)
            r10.f707d = r9
            r2 = r3
        L_0x00c9:
            org.a.a.b.f r1 = r4.mo5191d()
            java.util.List r1 = r1.mo4932a()
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L_0x01c0
            android.app.Activity r3 = r10.f706c
            android.content.Context r3 = r3.getBaseContext()
            android.webkit.CookieSyncManager.createInstance(r3)
            android.webkit.CookieManager r3 = android.webkit.CookieManager.getInstance()
            java.util.Iterator r4 = r1.iterator()
        L_0x00e8:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x01c0
            java.lang.Object r1 = r4.next()
            org.a.a.e.b r1 = (org.p004a.p005a.p021e.C0346b) r1
            java.lang.String r5 = r1.mo5045a()
            java.lang.String r6 = "PMMOBILEKEY"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00e8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r1.mo5045a()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = "="
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = r1.mo5047b()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = "; domain="
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = r1.mo5048c()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = r1.mo5048c()
            r3.setCookie(r1, r5)
            android.webkit.CookieSyncManager r1 = android.webkit.CookieSyncManager.getInstance()
            r1.sync()
            goto L_0x00e8
        L_0x013c:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r2
            goto L_0x0037
        L_0x0143:
            org.a.a.b.b.a r1 = new org.a.a.b.b.a     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r2 = "UTF-8"
            r1.<init>(r6, r2)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r5.mo4894a(r1)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            org.a.a.s r1 = r4.mo5198a(r5)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            org.a.a.af r2 = r1.mo5345a()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r7 = "PM Status is: "
            r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            int r7 = r2.mo4867b()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r6 = r6.toString()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r5.println(r6)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            int r5 = r2.mo4867b()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 != r6) goto L_0x018e
            java.io.PrintStream r2 = java.lang.System.out     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r5 = "We've reached here PM"
            r2.println(r5)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            org.a.a.k r1 = r1.mo5347b()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            byte[] r2 = org.p004a.p005a.p007b.p008a.C0250b.m107b((org.p004a.p005a.C0546k) r1)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r1 = new java.lang.String     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r5 = "UTF-8"
            r1.<init>(r2, r5)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r2 = r1
            goto L_0x00c9
        L_0x018e:
            int r5 = r2.mo4867b()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r6 = 408(0x198, float:5.72E-43)
            if (r5 == r6) goto L_0x019e
            int r2 = r2.mo4867b()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r5 = 504(0x1f8, float:7.06E-43)
            if (r2 != r5) goto L_0x01a4
        L_0x019e:
            r1 = 1
            r10.f707d = r1     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r2 = r3
            goto L_0x00c9
        L_0x01a4:
            org.a.a.k r1 = r1.mo5347b()     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            byte[] r2 = org.p004a.p005a.p007b.p008a.C0250b.m107b((org.p004a.p005a.C0546k) r1)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r1 = new java.lang.String     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            java.lang.String r5 = "UTF-8"
            r1.<init>(r2, r5)     // Catch:{ SocketTimeoutException -> 0x00be, e -> 0x01b6, Exception -> 0x01bc }
            r2 = r1
            goto L_0x00c9
        L_0x01b6:
            r1 = move-exception
            r10.f707d = r9
            r2 = r3
            goto L_0x00c9
        L_0x01bc:
            r1 = move-exception
        L_0x01bd:
            r2 = r3
            goto L_0x00c9
        L_0x01c0:
            r10.f704a = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonwealthcu.mobile.p038a.C0582d.doInBackground(java.lang.String[]):java.lang.String");
    }

    /* renamed from: a */
    private static C0419d m1283a(String str, String str2) {
        String[] split = str.split(";");
        C0419d dVar = new C0419d();
        for (String split2 : split) {
            String[] split3 = split2.split("=", 2);
            C0469c cVar = split3.length == 2 ? new C0469c(split3[0], split3[1]) : split3.length == 3 ? new C0469c(split3[0], split3[1] + '=' + split3[2]) : new C0469c(split3[0], (String) null);
            cVar.mo5076c(str2);
            dVar.mo4933a(cVar);
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        System.out.println("PMPOST JSON Results are: " + ((String) obj));
        MainActivity mainActivity = (MainActivity) this.f706c;
        if (this.f704a != null && !this.f707d) {
            mainActivity.mo5458b(this.f704a);
        } else if (this.f707d) {
            System.out.println("Connection Timed Out Flag");
        }
    }
}
