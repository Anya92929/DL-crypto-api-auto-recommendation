package com.jackhenry.godough.p028c.p029a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.ErrorMessage;
import com.jackhenry.godough.core.model.GoDoughNameValuePair;
import com.jackhenry.godough.p024a.C1373a;
import com.jackhenry.godough.p027b.C1386a;
import com.jackhenry.godough.p027b.C1388c;
import com.jackhenry.godough.p027b.C1389d;
import com.jackhenry.godough.p027b.C1390e;
import com.jackhenry.godough.p027b.C1391f;
import com.jackhenry.godough.p027b.C1392g;
import com.jackhenry.godough.p028c.p029a.p030a.C1400b;
import com.jackhenry.godough.p028c.p029a.p030a.C1401c;
import com.jackhenry.godough.p028c.p029a.p030a.C1402d;
import com.jackhenry.godough.p043d.C1945a;
import com.jackhenry.p021a.C1347a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.jackhenry.godough.c.a.b */
public class C1403b {

    /* renamed from: d */
    private static String f5751d = "GODOUGH-ABSTRACT-URL-CONNECTION";

    /* renamed from: e */
    private static C1406e f5752e;

    /* renamed from: f */
    private static C1404c f5753f;

    /* renamed from: a */
    private URL f5754a;

    /* renamed from: b */
    private int f5755b = 120000;

    /* renamed from: c */
    private int f5756c = 120000;

    C1403b() {
        GoDoughApp app = GoDoughApp.getApp();
        try {
            this.f5754a = new URL(C1347a.m5549b(app).replaceAll("\\$\\{app\\.api\\.fi\\.id\\}", String.valueOf(C1347a.m5547a((Context) app))));
            this.f5755b = C1347a.m5552e(app);
            this.f5756c = C1347a.m5552e(app);
            f5752e = new C1406e(this.f5754a);
            if (f5753f == null) {
                f5753f = new C1405d();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Fatal Error: Unable to parse MobileAPI Url");
        }
    }

    /* renamed from: a */
    private C1404c m5677a(URL url, String str) {
        return m5678a(url, str, (String) null);
    }

    /* renamed from: a */
    private C1404c m5678a(URL url, String str, String str2) {
        mo9462d();
        try {
            C1404c a = f5753f.mo9463a(url);
            a.mo9471b(this.f5755b);
            a.mo9465a(this.f5756c);
            a.mo9472b(false);
            a.mo9466a(str);
            f5752e.mo9482b(a);
            Iterator<GoDoughNameValuePair> it = mo9461c().iterator();
            while (it.hasNext()) {
                GoDoughNameValuePair next = it.next();
                a.mo9467a(next.getName(), next.getValue());
            }
            if (str.equals("POST") || str.equals("PUT")) {
                m5681a(a, str, str2);
            }
            return a;
        } catch (IOException e) {
            e.printStackTrace();
            throw new C1389d(e.getMessage(), 1000);
        }
    }

    /* renamed from: a */
    private ErrorMessage m5679a(int i, InputStream inputStream) {
        byte[] a = m5684a(inputStream);
        if (a == null) {
            return null;
        }
        try {
            return (ErrorMessage) new C1400b(ErrorMessage.class).mo9445a(a);
        } catch (C1391f e) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage("No Error Message Provided");
            errorMessage.setBlocked(false);
            return errorMessage;
        }
    }

    /* renamed from: a */
    private Object m5680a(C1404c cVar, C1401c cVar2) {
        boolean z = false;
        try {
            int d = cVar.mo9475d();
            if (d < 400) {
                String b = cVar.mo9470b("x-jha-utid");
                if (b != null) {
                    C1373a.m5616a(b);
                }
                f5752e.mo9481a(cVar);
            }
            C1945a.m6996a("Status Code " + d);
            switch (d) {
                case ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION:
                    Object a = cVar2.mo9445a(m5684a(cVar.mo9469b()));
                    cVar.mo9479h();
                    return a;
                case 302:
                    ErrorMessage a2 = m5679a(d, cVar.mo9473c());
                    String b2 = cVar.mo9470b("Location");
                    C1945a.m6996a("Destination " + b2);
                    String str = null;
                    if (!(a2 == null || a2.getMessage() == null)) {
                        str = a2.getMessage();
                    }
                    throw new C1392g(b2, d, str);
                case 401:
                    ErrorMessage a3 = m5679a(d, cVar.mo9473c());
                    String e = a3 == null ? cVar.mo9476e() : a3.getMessage();
                    if (a3 != null) {
                        z = a3.isBlocked();
                    }
                    throw new C1388c(e, d, z);
                case 403:
                    ErrorMessage a4 = m5679a(d, cVar.mo9473c());
                    String e2 = a4 == null ? cVar.mo9476e() : a4.getMessage();
                    if (a4 != null) {
                        z = a4.isBlocked();
                    }
                    throw new C1388c(e2, d, z);
                case 500:
                    throw new C1386a(m5679a(d, cVar.mo9473c()).getMessage(), d);
                case 503:
                    throw new C1386a(m5679a(d, cVar.mo9473c()).getMessage(), d);
                default:
                    ErrorMessage a5 = m5679a(d, cVar.mo9473c());
                    throw new C1389d(a5 == null ? cVar.mo9476e() : a5.getMessage(), d);
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            throw new C1390e(e3.getMessage());
        } catch (Throwable th) {
            cVar.mo9479h();
            throw th;
        }
        e3.printStackTrace();
        throw new C1390e(e3.getMessage());
    }

    /* renamed from: a */
    private void m5681a(C1404c cVar, String str, String str2) {
        try {
            cVar.mo9466a(str);
            cVar.mo9468a(true);
            cVar.mo9474c(0);
            m5682a(cVar.mo9464a(), str2);
        } catch (IOException e) {
            e.printStackTrace();
            throw new C1389d(e.getMessage(), 1000);
        }
    }

    /* renamed from: a */
    private void m5682a(OutputStream outputStream, String str) {
        if (outputStream != null) {
            try {
                outputStream.write(str.getBytes("UTF-8"));
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new C1389d(e.getMessage(), 1000);
            }
        }
    }

    /* renamed from: a */
    private void m5683a(ArrayList<GoDoughNameValuePair> arrayList, String str, String str2) {
        arrayList.add(new GoDoughNameValuePair(str, str2));
    }

    /* renamed from: a */
    private byte[] m5684a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: b */
    private URL m5685b(String str) {
        try {
            return new URL(this.f5754a.toString() + str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new C1389d(e.getMessage(), 1000);
        }
    }

    /* renamed from: a */
    public Object mo9451a(String str) {
        return mo9458b(str, new C1402d());
    }

    /* renamed from: a */
    public Object mo9452a(String str, C1401c cVar) {
        return mo9455a(str, cVar, (GoDoughNameValuePair[]) null);
    }

    /* renamed from: a */
    public Object mo9453a(String str, C1401c cVar, String str2) {
        return mo9454a(str, cVar, str2, (GoDoughNameValuePair[]) null);
    }

    /* renamed from: a */
    public Object mo9454a(String str, C1401c cVar, String str2, GoDoughNameValuePair[] goDoughNameValuePairArr) {
        return m5680a(m5678a(m5685b(str), "POST", str2), cVar);
    }

    /* renamed from: a */
    public Object mo9455a(String str, C1401c cVar, GoDoughNameValuePair[] goDoughNameValuePairArr) {
        return m5680a(m5677a(m5685b(str), "GET"), cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo9456a() {
        try {
            GoDoughApp app = GoDoughApp.getApp();
            PackageInfo packageInfo = app.getPackageManager().getPackageInfo(app.getPackageName(), 0);
            return C1347a.m5547a((Context) app) + "/" + app.getString(packageInfo.applicationInfo.labelRes) + "/" + packageInfo.versionName + "(Android " + Build.VERSION.RELEASE + ")";
        } catch (Exception e) {
            throw new RuntimeException("Failed to init the Mobile API", e);
        }
    }

    /* renamed from: b */
    public GoDoughNameValuePair mo9457b() {
        String str = C1373a.m5622c() != null ? "UTID=" + C1373a.m5622c() + "," : "";
        String str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            str2 = GoDoughApp.getApp().getPackageManager().getPackageInfo(GoDoughApp.getApp().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String format = String.format("OS=\"%1$s\",UI=\"%2$s\"", new Object[]{Build.VERSION.RELEASE, str2});
        DisplayMetrics displayMetrics = GoDoughApp.getApp().getResources().getDisplayMetrics();
        String str3 = displayMetrics.widthPixels + "X" + displayMetrics.heightPixels;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (long) statFs.getBlockSize();
        String format2 = String.format("AvailSpace=\"%1$s\",TotalSpace=\"%2$s\"", new Object[]{Formatter.formatFileSize(GoDoughApp.getApp(), blockSize * ((long) statFs.getAvailableBlocks())), Formatter.formatFileSize(GoDoughApp.getApp(), ((long) statFs.getBlockCount()) * blockSize)});
        String string = Settings.Secure.getString(GoDoughApp.getApp().getContentResolver(), "android_id");
        if (Build.VERSION.SDK_INT > 8) {
            string = Build.SERIAL;
        }
        String format3 = String.format("Model=\"%1$s\",%2$s,Resolution=\"%3$s\",Density=\"%4$s\",Unique=\"%5$s\",Make=\"%6$s\"", new Object[]{Build.MODEL, format2, str3, Float.valueOf(displayMetrics.density), string, Build.MANUFACTURER});
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) GoDoughApp.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        return new GoDoughNameValuePair("jha-software", str + format + "," + format3 + "," + (activeNetworkInfo != null ? String.format("NetworkType=\"%1$s\",SignalStrength=\"%2$s\"", new Object[]{activeNetworkInfo.getTypeName(), activeNetworkInfo.getDetailedState().name()}) : String.format("NetworkType=\"%1$s\",SignalStrength=\"%2$s\"", new Object[]{"none", "Not-Connected"})));
    }

    /* renamed from: b */
    public Object mo9458b(String str, C1401c cVar) {
        return m5680a(m5677a(m5685b(str), "DELETE"), cVar);
    }

    /* renamed from: b */
    public Object mo9459b(String str, C1401c cVar, String str2) {
        return mo9460b(str, cVar, str2, (GoDoughNameValuePair[]) null);
    }

    /* renamed from: b */
    public Object mo9460b(String str, C1401c cVar, String str2, GoDoughNameValuePair[] goDoughNameValuePairArr) {
        return m5680a(m5678a(m5685b(str), "PUT", str2), cVar);
    }

    /* renamed from: c */
    public ArrayList<GoDoughNameValuePair> mo9461c() {
        ArrayList<GoDoughNameValuePair> arrayList = new ArrayList<>();
        arrayList.add(mo9457b());
        m5683a(arrayList, "Content-Type", "text/json; charset=utf-8");
        m5683a(arrayList, "Accept", "application/x.jackhenry.mobile.v10+json");
        m5683a(arrayList, "User-Agent", mo9456a());
        return arrayList;
    }

    /* renamed from: d */
    public void mo9462d() {
        if (!f5753f.mo9478g()) {
            throw new C1390e(GoDoughApp.getApp().getString(C1506am.no_connectivity_available));
        }
    }
}
