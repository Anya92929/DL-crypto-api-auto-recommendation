package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.google.android.gms.analytics.a */
class C0150a implements C0178l {

    /* renamed from: xA */
    private static C0150a f126xA;

    /* renamed from: xz */
    private static Object f127xz = new Object();
    private Context mContext;

    /* renamed from: xB */
    private AdvertisingIdClient.Info f128xB;

    /* renamed from: xC */
    private long f129xC;

    /* renamed from: xD */
    private String f130xD;

    /* renamed from: xE */
    private boolean f131xE = false;

    /* renamed from: xF */
    private Object f132xF = new Object();

    C0150a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* renamed from: a */
    private boolean m75a(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String str;
        String str2 = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        C0172h.m185y(this.mContext);
        C0172h dR = C0172h.m182dR();
        String value = dR.getValue("&cid");
        synchronized (this.f132xF) {
            if (!this.f131xE) {
                this.f130xD = m79x(this.mContext);
                this.f131xE = true;
            } else if (TextUtils.isEmpty(this.f130xD)) {
                if (info != null) {
                    str2 = info.getId();
                }
                if (str2 == null) {
                    boolean ab = m77ab(id + value);
                    return ab;
                }
                this.f130xD = m76aa(str2 + value);
            }
            String aa = m76aa(id + value);
            if (TextUtils.isEmpty(aa)) {
                return false;
            }
            if (aa.equals(this.f130xD)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.f130xD)) {
                C0207z.m308V("Resetting the client id because Advertising Id changed.");
                str = dR.mo3702dS();
                C0207z.m308V("New client Id: " + str);
            } else {
                str = value;
            }
            boolean ab2 = m77ab(id + str);
            return ab2;
        }
    }

    /* renamed from: aa */
    static String m76aa(String str) {
        MessageDigest ap = C0162aj.m148ap("MD5");
        if (ap == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, ap.digest(str.getBytes()))});
    }

    /* renamed from: ab */
    private boolean m77ab(String str) {
        try {
            String aa = m76aa(str);
            C0207z.m308V("Storing hashed adid.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientIdData", 0);
            openFileOutput.write(aa.getBytes());
            openFileOutput.close();
            this.f130xD = aa;
            return true;
        } catch (FileNotFoundException e) {
            C0207z.m306T("Error creating hash file.");
            return false;
        } catch (IOException e2) {
            C0207z.m306T("Error writing to hash file.");
            return false;
        }
    }

    /* renamed from: w */
    public static C0178l m78w(Context context) {
        if (f126xA == null) {
            synchronized (f127xz) {
                if (f126xA == null) {
                    f126xA = new C0150a(context);
                }
            }
        }
        return f126xA;
    }

    /* renamed from: x */
    static String m79x(Context context) {
        String str = null;
        try {
            FileInputStream openFileInput = context.openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                C0207z.m309W("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                context.deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                C0207z.m307U("Hash file is empty.");
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
                    str = str2;
                    C0207z.m309W("Error reading Hash file, deleting it.");
                    context.deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            C0207z.m309W("Error reading Hash file, deleting it.");
            context.deleteFile("gaClientIdData");
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dH */
    public AdvertisingIdClient.Info mo3596dH() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (IllegalStateException e) {
            C0207z.m309W("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (GooglePlayServicesRepairableException e2) {
            C0207z.m309W("GooglePlayServicesRepairableException getting Ad Id Info");
            return null;
        } catch (IOException e3) {
            C0207z.m309W("IOException getting Ad Id Info");
            return null;
        } catch (GooglePlayServicesNotAvailableException e4) {
            C0207z.m309W("GooglePlayServicesNotAvailableException getting Ad Id Info");
            return null;
        } catch (Throwable th) {
            C0207z.m309W("Unknown exception. Could not get the ad Id.");
            return null;
        }
    }

    public String getValue(String field) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f129xC > 1000) {
            AdvertisingIdClient.Info dH = mo3596dH();
            if (m75a(this.f128xB, dH)) {
                this.f128xB = dH;
            } else {
                this.f128xB = new AdvertisingIdClient.Info("", false);
            }
            this.f129xC = currentTimeMillis;
        }
        if (this.f128xB != null) {
            if ("&adid".equals(field)) {
                return this.f128xB.getId();
            }
            if ("&ate".equals(field)) {
                return this.f128xB.isLimitAdTrackingEnabled() ? "0" : "1";
            }
        }
        return null;
    }
}
