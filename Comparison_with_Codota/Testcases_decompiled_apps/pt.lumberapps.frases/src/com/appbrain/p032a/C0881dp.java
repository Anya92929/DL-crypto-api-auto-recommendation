package com.appbrain.p032a;

import android.content.pm.PackageInfo;
import android.support.p009v4.app.NotificationCompat;
import cmn.C0752n;
import cmn.C0756r;
import com.appbrain.p033b.C1008l;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.a.dp */
final class C0881dp {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f2343a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f2344b;

    /* renamed from: c */
    private List f2345c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    private final long f2346d = (System.currentTimeMillis() - 2592000000L);

    private C0881dp() {
    }

    /* renamed from: a */
    public static C0881dp m3822a() {
        return new C0881dp();
    }

    /* renamed from: a */
    private static int[] m3823a(List list) {
        int[] iArr = new int[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return iArr;
            }
            int d = (int) C0752n.m3281d(((PackageInfo) list.get(i2)).packageName);
            String unused = C0879dn.f2338a;
            new StringBuilder("Score: ").append(((PackageInfo) list.get(i2)).packageName).append(": ").append(d);
            iArr[i2] = d;
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public final void mo3757a(long j) {
        this.f2345c.clear();
        this.f2343a = j;
    }

    /* renamed from: a */
    public final void mo3758a(PackageInfo packageInfo, String str) {
        if (C0879dn.f2339b == null || (str != null && C0879dn.f2339b.contains(str))) {
            this.f2344b++;
            long j = packageInfo.firstInstallTime;
            if (j > this.f2346d) {
                this.f2345c.add(packageInfo);
            }
            if (j > 0 && j < this.f2343a) {
                if (!(packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) != 0)) {
                    this.f2343a = j;
                }
            }
        }
    }

    /* renamed from: b */
    public final String mo3759b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationCompat.FLAG_HIGH_PRIORITY);
            C1008l a = C1008l.m4211a((OutputStream) byteArrayOutputStream);
            a.mo4005e(5);
            Collections.sort(this.f2345c, new C0882dq(this));
            if (this.f2345c.size() > 16) {
                this.f2345c = this.f2345c.subList(0, 16);
                String unused = C0879dn.f2338a;
                for (int i = 0; i < this.f2345c.size(); i++) {
                    String unused2 = C0879dn.f2338a;
                    String str = ((PackageInfo) this.f2345c.get(i)).packageName;
                }
            }
            int[] a2 = m3823a(this.f2345c);
            a.mo4005e(a2.length);
            for (int f : a2) {
                String unused3 = C0879dn.f2338a;
                a.mo4006f(f);
            }
            a.mo3992a();
            return C0756r.m3312b(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
