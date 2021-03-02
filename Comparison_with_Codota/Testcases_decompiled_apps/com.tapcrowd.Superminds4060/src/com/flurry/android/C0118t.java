package com.flurry.android;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

/* renamed from: com.flurry.android.t */
final class C0118t implements Runnable {

    /* renamed from: a */
    private /* synthetic */ Map f224a;

    /* renamed from: b */
    private /* synthetic */ InstallReceiver f225b;

    C0118t(InstallReceiver installReceiver, Map map) {
        this.f225b = installReceiver;
        this.f224a = map;
    }

    public final void run() {
        DataOutputStream dataOutputStream = null;
        try {
            File parentFile = this.f225b.f74b.getParentFile();
            if (parentFile.mkdirs() || parentFile.exists()) {
                DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(this.f225b.f74b));
                try {
                    boolean z = true;
                    for (Map.Entry entry : this.f224a.entrySet()) {
                        if (z) {
                            z = false;
                        } else {
                            dataOutputStream2.writeUTF("&");
                        }
                        dataOutputStream2.writeUTF((String) entry.getKey());
                        dataOutputStream2.writeUTF("=");
                        dataOutputStream2.writeUTF((String) entry.getValue());
                    }
                    dataOutputStream2.writeShort(0);
                    C0116r.m125a((Closeable) dataOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    C0116r.m125a((Closeable) dataOutputStream);
                    throw th;
                }
            } else {
                C0095ai.m101b("InstallReceiver", "Unable to create persistent dir: " + parentFile);
                C0116r.m125a((Closeable) null);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                C0095ai.m102b("InstallReceiver", "", th);
                C0116r.m125a((Closeable) dataOutputStream);
            } catch (Throwable th3) {
                th = th3;
                C0116r.m125a((Closeable) dataOutputStream);
                throw th;
            }
        }
    }
}
