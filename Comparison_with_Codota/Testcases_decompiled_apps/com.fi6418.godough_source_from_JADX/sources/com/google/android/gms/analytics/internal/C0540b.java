package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.p014a.p015a.C0498a;
import com.google.android.gms.p014a.p015a.C0499b;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.google.android.gms.analytics.internal.b */
public class C0540b extends C0514aa {

    /* renamed from: a */
    public static boolean f3778a;

    /* renamed from: b */
    private C0499b f3779b;

    /* renamed from: c */
    private final C0569q f3780c;

    /* renamed from: d */
    private String f3781d;

    /* renamed from: e */
    private boolean f3782e = false;

    /* renamed from: f */
    private Object f3783f = new Object();

    C0540b(C0516ac acVar) {
        super(acVar);
        this.f3780c = new C0569q(acVar.mo6602d());
    }

    /* renamed from: a */
    private static String m3131a(String str) {
        MessageDigest b = C0570r.m3336b("MD5");
        if (b == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, b.digest(str.getBytes()))});
    }

    /* renamed from: a */
    private boolean m3132a(C0499b bVar, C0499b bVar2) {
        String str;
        String str2 = null;
        String a = bVar2 == null ? null : bVar2.mo6554a();
        if (TextUtils.isEmpty(a)) {
            return true;
        }
        String b = mo6895x().mo6706b();
        synchronized (this.f3783f) {
            if (!this.f3782e) {
                this.f3781d = mo6717e();
                this.f3782e = true;
            } else if (TextUtils.isEmpty(this.f3781d)) {
                if (bVar != null) {
                    str2 = bVar.mo6554a();
                }
                if (str2 == null) {
                    boolean g = m3134g(a + b);
                    return g;
                }
                this.f3781d = m3131a(str2 + b);
            }
            String a2 = m3131a(a + b);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            if (a2.equals(this.f3781d)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.f3781d)) {
                mo6869b("Resetting the client id because Advertising Id changed.");
                str = mo6895x().mo6707c();
                mo6866a("New client Id", str);
            } else {
                str = b;
            }
            boolean g2 = m3134g(a + str);
            return g2;
        }
    }

    /* renamed from: f */
    private synchronized C0499b m3133f() {
        if (this.f3780c.mo6834a(1000)) {
            this.f3780c.mo6833a();
            C0499b d = mo6716d();
            if (m3132a(this.f3779b, d)) {
                this.f3779b = d;
            } else {
                mo6881f("Failed to reset client id on adid change. Not using adid");
                this.f3779b = new C0499b("", false);
            }
        }
        return this.f3779b;
    }

    /* renamed from: g */
    private boolean m3134g(String str) {
        try {
            String a = m3131a(str);
            mo6869b("Storing hashed adid.");
            FileOutputStream openFileOutput = mo6886o().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(a.getBytes());
            openFileOutput.close();
            this.f3781d = a;
            return true;
        } catch (IOException e) {
            mo6880e("Error creating hash file", e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
    }

    /* renamed from: b */
    public boolean mo6714b() {
        mo6596D();
        C0499b f = m3133f();
        return f != null && !f.mo6555b();
    }

    /* renamed from: c */
    public String mo6715c() {
        mo6596D();
        C0499b f = m3133f();
        String a = f != null ? f.mo6554a() : null;
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0499b mo6716d() {
        try {
            return C0498a.m2942b(mo6886o());
        } catch (IllegalStateException e) {
            mo6879e("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Throwable th) {
            if (f3778a) {
                return null;
            }
            f3778a = true;
            mo6877d("Error getting advertiser id", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo6717e() {
        String str = null;
        try {
            FileInputStream openFileInput = mo6886o().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                mo6879e("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                mo6886o().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                mo6869b("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    str = str2;
                    e = iOException;
                    mo6877d("Error reading Hash file, deleting it", e);
                    mo6886o().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            e = e4;
            mo6877d("Error reading Hash file, deleting it", e);
            mo6886o().deleteFile("gaClientIdData");
            return str;
        }
    }
}
