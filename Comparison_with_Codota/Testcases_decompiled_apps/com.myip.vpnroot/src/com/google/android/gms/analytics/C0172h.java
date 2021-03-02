package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.h */
class C0172h implements C0178l {

    /* renamed from: xQ */
    private static C0172h f178xQ;

    /* renamed from: xz */
    private static final Object f179xz = new Object();
    private final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: xR */
    public String f180xR;
    /* access modifiers changed from: private */

    /* renamed from: xS */
    public boolean f181xS = false;
    /* access modifiers changed from: private */

    /* renamed from: xT */
    public final Object f182xT = new Object();

    protected C0172h(Context context) {
        this.mContext = context;
        m184dV();
    }

    /* renamed from: ad */
    private boolean m181ad(String str) {
        try {
            C0207z.m308V("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            C0207z.m306T("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            C0207z.m306T("Error writing to clientId file.");
            return false;
        }
    }

    /* renamed from: dR */
    public static C0172h m182dR() {
        C0172h hVar;
        synchronized (f179xz) {
            hVar = f178xQ;
        }
        return hVar;
    }

    /* renamed from: dT */
    private String m183dT() {
        if (!this.f181xS) {
            synchronized (this.f182xT) {
                if (!this.f181xS) {
                    C0207z.m308V("Waiting for clientId to load");
                    do {
                        try {
                            this.f182xT.wait();
                        } catch (InterruptedException e) {
                            C0207z.m306T("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.f181xS);
                }
            }
        }
        C0207z.m308V("Loaded clientId");
        return this.f180xR;
    }

    /* renamed from: dV */
    private void m184dV() {
        new Thread("client_id_fetcher") {
            public void run() {
                synchronized (C0172h.this.f182xT) {
                    String unused = C0172h.this.f180xR = C0172h.this.mo3704dW();
                    boolean unused2 = C0172h.this.f181xS = true;
                    C0172h.this.f182xT.notifyAll();
                }
            }
        }.start();
    }

    /* renamed from: y */
    public static void m185y(Context context) {
        synchronized (f179xz) {
            if (f178xQ == null) {
                f178xQ = new C0172h(context);
            }
        }
    }

    /* renamed from: ac */
    public boolean mo3701ac(String str) {
        return "&cid".equals(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dS */
    public String mo3702dS() {
        String str;
        synchronized (this.f182xT) {
            this.f180xR = mo3703dU();
            str = this.f180xR;
        }
        return str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: dU */
    public String mo3703dU() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !m181ad(lowerCase) ? "0" : lowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dW */
    public String mo3704dW() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                C0207z.m306T("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                C0207z.m306T("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    C0207z.m308V("Loaded client id from disk.");
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    C0207z.m306T("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            C0207z.m306T("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? mo3703dU() : str;
    }

    public String getValue(String field) {
        if ("&cid".equals(field)) {
            return m183dT();
        }
        return null;
    }
}
