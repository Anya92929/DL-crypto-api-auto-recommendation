package com.flurry.android;

import android.support.p000v4.view.MotionEventCompat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.flurry.android.i */
final class C0107i {

    /* renamed from: a */
    private int f199a = FlurryAgent.m50f();

    /* renamed from: b */
    private String f200b;

    /* renamed from: c */
    private Map f201c;

    /* renamed from: d */
    private long f202d;

    /* renamed from: e */
    private boolean f203e;

    /* renamed from: f */
    private long f204f;

    public C0107i(String str, Map map, long j, boolean z) {
        this.f200b = str;
        this.f201c = map;
        this.f202d = j;
        this.f203e = z;
    }

    /* renamed from: a */
    public final boolean mo3314a(String str) {
        return this.f203e && this.f204f == 0 && this.f200b.equals(str);
    }

    /* renamed from: a */
    public final void mo3313a(long j) {
        this.f204f = j - this.f202d;
        C0095ai.m96a("FlurryAgent", "Ended event '" + this.f200b + "' (" + this.f202d + ") after " + this.f204f + "ms");
    }

    /* renamed from: a */
    public final byte[] mo3315a() {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Throwable th;
        byte[] bArr;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeShort(this.f199a);
                dataOutputStream2.writeUTF(this.f200b);
                if (this.f201c == null) {
                    dataOutputStream2.writeShort(0);
                } else {
                    dataOutputStream2.writeShort(this.f201c.size());
                    for (Map.Entry entry : this.f201c.entrySet()) {
                        dataOutputStream2.writeUTF(C0116r.m123a((String) entry.getKey(), (int) MotionEventCompat.ACTION_MASK));
                        dataOutputStream2.writeUTF(C0116r.m123a((String) entry.getValue(), (int) MotionEventCompat.ACTION_MASK));
                    }
                }
                dataOutputStream2.writeLong(this.f202d);
                dataOutputStream2.writeLong(this.f204f);
                dataOutputStream2.flush();
                bArr = byteArrayOutputStream.toByteArray();
                C0116r.m125a((Closeable) dataOutputStream2);
            } catch (IOException e) {
                dataOutputStream = dataOutputStream2;
                try {
                    bArr = new byte[0];
                    C0116r.m125a((Closeable) dataOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream2 = dataOutputStream;
                    C0116r.m125a((Closeable) dataOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                C0116r.m125a((Closeable) dataOutputStream2);
                throw th;
            }
        } catch (IOException e2) {
            dataOutputStream = null;
            bArr = new byte[0];
            C0116r.m125a((Closeable) dataOutputStream);
            return bArr;
        } catch (Throwable th4) {
            dataOutputStream2 = null;
            th = th4;
            C0116r.m125a((Closeable) dataOutputStream2);
            throw th;
        }
        return bArr;
    }
}
