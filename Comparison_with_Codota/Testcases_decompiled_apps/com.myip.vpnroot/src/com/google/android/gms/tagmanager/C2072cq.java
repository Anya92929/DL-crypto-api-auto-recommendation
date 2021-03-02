package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.C0976c;
import com.google.android.gms.internal.C1663ok;
import com.google.android.gms.internal.C1717pl;
import com.google.android.gms.internal.C1718pm;
import com.google.android.gms.tagmanager.C2026bg;
import com.google.android.gms.tagmanager.C2055ce;
import com.google.android.gms.tagmanager.C2075cr;
import com.google.android.gms.tagmanager.C2135o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* renamed from: com.google.android.gms.tagmanager.cq */
class C2072cq implements C2135o.C2143f {
    private final String anR;
    private C2026bg<C1663ok.C1664a> aqi;
    private final ExecutorService aqp = Executors.newSingleThreadExecutor();
    private final Context mContext;

    C2072cq(Context context, String str) {
        this.mContext = context;
        this.anR = str;
    }

    /* renamed from: a */
    private C2075cr.C2079c m6946a(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return C2019ba.m6803cD(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C2028bh.m6815S("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException e2) {
            C2028bh.m6819W("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    /* renamed from: d */
    private void m6947d(C1663ok.C1664a aVar) throws IllegalArgumentException {
        if (aVar.f4343gs == null && aVar.ash == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    /* renamed from: k */
    private C2075cr.C2079c m6948k(byte[] bArr) {
        try {
            C2075cr.C2079c b = C2075cr.m6960b(C0976c.C0982f.m4079a(bArr));
            if (b == null) {
                return b;
            }
            C2028bh.m6818V("The container was successfully loaded from the resource (using binary file)");
            return b;
        } catch (C1717pl e) {
            C2028bh.m6816T("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (C2075cr.C2083g e2) {
            C2028bh.m6819W("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    /* renamed from: a */
    public void mo11642a(C2026bg<C1663ok.C1664a> bgVar) {
        this.aqi = bgVar;
    }

    /* renamed from: b */
    public void mo11643b(final C1663ok.C1664a aVar) {
        this.aqp.execute(new Runnable() {
            public void run() {
                C2072cq.this.mo11644c(aVar);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo11644c(C1663ok.C1664a aVar) {
        boolean z = false;
        File oQ = mo11647oQ();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(oQ);
            try {
                fileOutputStream.write(C1718pm.m6092f(aVar));
                z = true;
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    C2028bh.m6819W("error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                C2028bh.m6819W("Error writing resource to disk. Removing resource from disk.");
                oQ.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    C2028bh.m6819W("error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    C2028bh.m6819W("error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            C2028bh.m6816T("Error opening resource file for writing");
        }
        return z;
    }

    /* renamed from: fe */
    public C2075cr.C2079c mo11645fe(int i) {
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            C2028bh.m6818V("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                C2075cr.m6961b(openRawResource, byteArrayOutputStream);
                C2075cr.C2079c a = m6946a(byteArrayOutputStream);
                if (a == null) {
                    return m6948k(byteArrayOutputStream.toByteArray());
                }
                C2028bh.m6818V("The container was successfully loaded from the resource (using JSON file format)");
                return a;
            } catch (IOException e) {
                C2028bh.m6819W("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (Resources.NotFoundException e2) {
            C2028bh.m6819W("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: oP */
    public void mo11646oP() {
        if (this.aqi == null) {
            throw new IllegalStateException("Callback must be set before execute");
        }
        this.aqi.mo11575nZ();
        C2028bh.m6818V("Attempting to load resource from disk");
        if ((C2055ce.m6906oH().mo11630oI() == C2055ce.C2056a.CONTAINER || C2055ce.m6906oH().mo11630oI() == C2055ce.C2056a.CONTAINER_DEBUG) && this.anR.equals(C2055ce.m6906oH().getContainerId())) {
            this.aqi.mo11573a(C2026bg.C2027a.NOT_AVAILABLE);
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(mo11647oQ());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                C2075cr.m6961b(fileInputStream, byteArrayOutputStream);
                C1663ok.C1664a l = C1663ok.C1664a.m5840l(byteArrayOutputStream.toByteArray());
                m6947d(l);
                this.aqi.mo11574l(l);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    C2028bh.m6819W("Error closing stream for reading resource from disk");
                }
            } catch (IOException e2) {
                this.aqi.mo11573a(C2026bg.C2027a.IO_ERROR);
                C2028bh.m6819W("Failed to read the resource from disk");
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    C2028bh.m6819W("Error closing stream for reading resource from disk");
                }
            } catch (IllegalArgumentException e4) {
                this.aqi.mo11573a(C2026bg.C2027a.IO_ERROR);
                C2028bh.m6819W("Failed to read the resource from disk. The resource is inconsistent");
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    C2028bh.m6819W("Error closing stream for reading resource from disk");
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    C2028bh.m6819W("Error closing stream for reading resource from disk");
                }
                throw th;
            }
            C2028bh.m6818V("The Disk resource was successfully read.");
        } catch (FileNotFoundException e7) {
            C2028bh.m6815S("Failed to find the resource in the disk");
            this.aqi.mo11573a(C2026bg.C2027a.NOT_AVAILABLE);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: oQ */
    public File mo11647oQ() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.anR);
    }

    /* renamed from: oa */
    public void mo11648oa() {
        this.aqp.execute(new Runnable() {
            public void run() {
                C2072cq.this.mo11646oP();
            }
        });
    }

    public synchronized void release() {
        this.aqp.shutdown();
    }
}
