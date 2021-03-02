package com.flurry.android;

import android.content.Context;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.flurry.android.aa */
final class C0087aa {

    /* renamed from: a */
    private Context f85a;

    /* renamed from: b */
    private C0120v f86b;

    /* renamed from: c */
    private C0086a f87c;

    /* renamed from: d */
    private volatile long f88d;

    /* renamed from: e */
    private C0093ag f89e = new C0093ag(100);

    /* renamed from: f */
    private C0093ag f90f = new C0093ag(100);

    /* renamed from: g */
    private Map f91g = new HashMap();

    /* renamed from: h */
    private Map f92h = new HashMap();

    /* renamed from: i */
    private Map f93i = new HashMap();

    /* renamed from: j */
    private Map f94j = new HashMap();

    /* renamed from: k */
    private volatile boolean f95k;

    C0087aa() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3283a(Context context, C0120v vVar, C0086a aVar) {
        this.f85a = context;
        this.f86b = vVar;
        this.f87c = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized C0121w[] mo3285a(String str) {
        C0121w[] wVarArr;
        wVarArr = (C0121w[]) this.f91g.get(str);
        if (wVarArr == null) {
            wVarArr = (C0121w[]) this.f91g.get("");
        }
        return wVarArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized C0099am mo3281a(long j) {
        return (C0099am) this.f90f.mo3297a((Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized Set mo3282a() {
        return this.f89e.mo3300c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized AdImage mo3286b(long j) {
        return (AdImage) this.f89e.mo3297a((Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized AdImage mo3280a(short s) {
        Long l;
        l = (Long) this.f94j.get((short) 1);
        return l == null ? null : mo3286b(l.longValue());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized C0103e mo3287b(String str) {
        C0103e eVar;
        eVar = (C0103e) this.f92h.get(str);
        if (eVar == null) {
            eVar = (C0103e) this.f92h.get("");
        }
        return eVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo3288b() {
        return this.f95k;
    }

    /* renamed from: a */
    private synchronized C0101c m65a(byte b) {
        return (C0101c) this.f93i.get(Byte.valueOf(b));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3284a(Map map, Map map2, Map map3, Map map4, Map map5, Map map6) {
        this.f88d = System.currentTimeMillis();
        for (Map.Entry entry : map4.entrySet()) {
            if (entry.getValue() != null) {
                this.f89e.mo3298a(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : map5.entrySet()) {
            if (entry2.getValue() != null) {
                this.f90f.mo3298a(entry2.getKey(), entry2.getValue());
            }
        }
        if (map2 != null && !map2.isEmpty()) {
            this.f92h = map2;
        }
        if (map3 != null && !map3.isEmpty()) {
            this.f93i = map3;
        }
        if (map6 != null && !map6.isEmpty()) {
            this.f94j = map6;
        }
        this.f91g = new HashMap();
        for (Map.Entry entry3 : map2.entrySet()) {
            C0103e eVar = (C0103e) entry3.getValue();
            C0121w[] wVarArr = (C0121w[]) map.get(Byte.valueOf(eVar.f192b));
            if (wVarArr != null) {
                this.f91g.put(entry3.getKey(), wVarArr);
            }
            C0101c cVar = (C0101c) map3.get(Byte.valueOf(eVar.f193c));
            if (cVar != null) {
                eVar.f194d = cVar;
            }
        }
        m70f();
        m66a((int) CallbackEvent.ADS_UPDATED);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final long mo3289c() {
        return this.f88d;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x004a=Splitter:B:28:0x004a, B:11:0x002d=Splitter:B:11:0x002d} */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo3290d() {
        /*
            r5 = this;
            monitor-enter(r5)
            android.content.Context r0 = r5.f85a     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = r5.m71g()     // Catch:{ all -> 0x0045 }
            java.io.File r3 = r0.getFileStreamPath(r1)     // Catch:{ all -> 0x0045 }
            boolean r0 = r3.exists()     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x004e
            r2 = 0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x006d, all -> 0x0048 }
            r0.<init>(r3)     // Catch:{ Throwable -> 0x006d, all -> 0x0048 }
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ Throwable -> 0x006d, all -> 0x0048 }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x006d, all -> 0x0048 }
            int r0 = r1.readUnsignedShort()     // Catch:{ Throwable -> 0x0036 }
            r2 = 46587(0xb5fb, float:6.5282E-41)
            if (r0 != r2) goto L_0x0032
            r5.m67a((java.io.DataInputStream) r1)     // Catch:{ Throwable -> 0x0036 }
            r0 = 201(0xc9, float:2.82E-43)
            r5.m66a((int) r0)     // Catch:{ Throwable -> 0x0036 }
        L_0x002d:
            com.flurry.android.C0116r.m125a((java.io.Closeable) r1)     // Catch:{ all -> 0x0045 }
        L_0x0030:
            monitor-exit(r5)
            return
        L_0x0032:
            m69a((java.io.File) r3)     // Catch:{ Throwable -> 0x0036 }
            goto L_0x002d
        L_0x0036:
            r0 = move-exception
        L_0x0037:
            java.lang.String r2 = "FlurryAgent"
            java.lang.String r4 = "Discarding cache"
            com.flurry.android.C0095ai.m97a(r2, r4, r0)     // Catch:{ all -> 0x006b }
            m69a((java.io.File) r3)     // Catch:{ all -> 0x006b }
            com.flurry.android.C0116r.m125a((java.io.Closeable) r1)     // Catch:{ all -> 0x0045 }
            goto L_0x0030
        L_0x0045:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0048:
            r0 = move-exception
            r1 = r2
        L_0x004a:
            com.flurry.android.C0116r.m125a((java.io.Closeable) r1)     // Catch:{ all -> 0x0045 }
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x004e:
            java.lang.String r0 = "FlurryAgent"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r1.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "cache file does not exist, path="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = r3.getAbsolutePath()     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0045 }
            com.flurry.android.C0095ai.m104c(r0, r1)     // Catch:{ all -> 0x0045 }
            goto L_0x0030
        L_0x006b:
            r0 = move-exception
            goto L_0x004a
        L_0x006d:
            r0 = move-exception
            r1 = r2
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.android.C0087aa.mo3290d():void");
    }

    /* renamed from: a */
    private static void m69a(File file) {
        if (!file.delete()) {
            C0095ai.m101b("FlurryAgent", "Cannot delete cached ads");
        }
    }

    /* renamed from: f */
    private void m70f() {
        Iterator it = this.f93i.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
        for (C0121w[] wVarArr : this.f91g.values()) {
            if (wVarArr != null) {
                for (C0121w wVar : wVarArr) {
                    wVar.f266h = mo3286b(wVar.f264f.longValue());
                    if (wVar.f266h == null) {
                        C0095ai.m101b("FlurryAgent", "Ad " + wVar.f262d + " has no image");
                    }
                    if (mo3281a(wVar.f259a) == null) {
                        C0095ai.m101b("FlurryAgent", "Ad " + wVar.f262d + " has no pricing");
                    }
                }
            }
        }
        for (C0103e eVar : this.f92h.values()) {
            eVar.f194d = m65a(eVar.f193c);
            if (eVar.f194d == null) {
                C0095ai.m106d("FlurryAgent", "No ad theme found for " + eVar.f193c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final synchronized void mo3291e() {
        DataOutputStream dataOutputStream = null;
        synchronized (this) {
            try {
                File fileStreamPath = this.f85a.getFileStreamPath(m71g());
                File parentFile = fileStreamPath.getParentFile();
                if (parentFile.mkdirs() || parentFile.exists()) {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(fileStreamPath));
                    try {
                        dataOutputStream2.writeShort(46587);
                        m68a(dataOutputStream2);
                        C0116r.m125a((Closeable) dataOutputStream2);
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = dataOutputStream2;
                        C0116r.m125a((Closeable) dataOutputStream);
                        throw th;
                    }
                } else {
                    C0095ai.m101b("FlurryAgent", "Unable to create persistent dir: " + parentFile);
                    C0116r.m125a((Closeable) null);
                }
            } catch (Throwable th2) {
                th = th2;
                C0095ai.m102b("FlurryAgent", "", th);
                C0116r.m125a((Closeable) dataOutputStream);
            }
        }
    }

    /* renamed from: a */
    private void m67a(DataInputStream dataInputStream) {
        C0095ai.m96a("FlurryAgent", "Reading cache");
        if (dataInputStream.readUnsignedShort() == 2) {
            this.f88d = dataInputStream.readLong();
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            this.f89e = new C0093ag(100);
            for (int i = 0; i < readUnsignedShort; i++) {
                long readLong = dataInputStream.readLong();
                AdImage adImage = new AdImage();
                adImage.mo3225a(dataInputStream);
                this.f89e.mo3298a(Long.valueOf(readLong), adImage);
            }
            int readUnsignedShort2 = dataInputStream.readUnsignedShort();
            this.f90f = new C0093ag(100);
            for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
                long readLong2 = dataInputStream.readLong();
                C0099am amVar = new C0099am();
                if (dataInputStream.readBoolean()) {
                    amVar.f123a = dataInputStream.readUTF();
                }
                if (dataInputStream.readBoolean()) {
                    amVar.f124b = dataInputStream.readUTF();
                }
                amVar.f125c = dataInputStream.readInt();
                this.f90f.mo3298a(Long.valueOf(readLong2), amVar);
            }
            int readUnsignedShort3 = dataInputStream.readUnsignedShort();
            this.f92h = new HashMap(readUnsignedShort3);
            for (int i3 = 0; i3 < readUnsignedShort3; i3++) {
                this.f92h.put(dataInputStream.readUTF(), new C0103e(dataInputStream));
            }
            int readUnsignedShort4 = dataInputStream.readUnsignedShort();
            this.f91g = new HashMap(readUnsignedShort4);
            for (int i4 = 0; i4 < readUnsignedShort4; i4++) {
                String readUTF = dataInputStream.readUTF();
                int readUnsignedShort5 = dataInputStream.readUnsignedShort();
                C0121w[] wVarArr = new C0121w[readUnsignedShort5];
                for (int i5 = 0; i5 < readUnsignedShort5; i5++) {
                    C0121w wVar = new C0121w();
                    wVar.mo3368a((DataInput) dataInputStream);
                    wVarArr[i5] = wVar;
                }
                this.f91g.put(readUTF, wVarArr);
            }
            int readUnsignedShort6 = dataInputStream.readUnsignedShort();
            this.f93i = new HashMap();
            for (int i6 = 0; i6 < readUnsignedShort6; i6++) {
                byte readByte = dataInputStream.readByte();
                C0101c cVar = new C0101c();
                cVar.mo3308b(dataInputStream);
                this.f93i.put(Byte.valueOf(readByte), cVar);
            }
            int readUnsignedShort7 = dataInputStream.readUnsignedShort();
            this.f94j = new HashMap(readUnsignedShort7);
            for (int i7 = 0; i7 < readUnsignedShort7; i7++) {
                this.f94j.put(Short.valueOf(dataInputStream.readShort()), Long.valueOf(dataInputStream.readLong()));
            }
            m70f();
            C0095ai.m96a("FlurryAgent", "Cache read, num images: " + this.f89e.mo3296a());
        }
    }

    /* renamed from: a */
    private void m68a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(2);
        dataOutputStream.writeLong(this.f88d);
        List<Map.Entry> b = this.f89e.mo3299b();
        dataOutputStream.writeShort(b.size());
        for (Map.Entry entry : b) {
            dataOutputStream.writeLong(((Long) entry.getKey()).longValue());
            AdImage adImage = (AdImage) entry.getValue();
            dataOutputStream.writeLong(adImage.f3a);
            dataOutputStream.writeInt(adImage.f4b);
            dataOutputStream.writeInt(adImage.f5c);
            dataOutputStream.writeUTF(adImage.f6d);
            dataOutputStream.writeInt(adImage.f7e.length);
            dataOutputStream.write(adImage.f7e);
        }
        List<Map.Entry> b2 = this.f90f.mo3299b();
        dataOutputStream.writeShort(b2.size());
        for (Map.Entry entry2 : b2) {
            dataOutputStream.writeLong(((Long) entry2.getKey()).longValue());
            C0099am amVar = (C0099am) entry2.getValue();
            boolean z = amVar.f123a != null;
            dataOutputStream.writeBoolean(z);
            if (z) {
                dataOutputStream.writeUTF(amVar.f123a);
            }
            boolean z2 = amVar.f124b != null;
            dataOutputStream.writeBoolean(z2);
            if (z2) {
                dataOutputStream.writeUTF(amVar.f124b);
            }
            dataOutputStream.writeInt(amVar.f125c);
        }
        dataOutputStream.writeShort(this.f92h.size());
        for (Map.Entry entry3 : this.f92h.entrySet()) {
            dataOutputStream.writeUTF((String) entry3.getKey());
            C0103e eVar = (C0103e) entry3.getValue();
            dataOutputStream.writeUTF(eVar.f191a);
            dataOutputStream.writeByte(eVar.f192b);
            dataOutputStream.writeByte(eVar.f193c);
        }
        dataOutputStream.writeShort(this.f91g.size());
        for (Map.Entry entry4 : this.f91g.entrySet()) {
            dataOutputStream.writeUTF((String) entry4.getKey());
            C0121w[] wVarArr = (C0121w[]) entry4.getValue();
            int length = wVarArr == null ? 0 : wVarArr.length;
            dataOutputStream.writeShort(length);
            for (int i = 0; i < length; i++) {
                C0121w wVar = wVarArr[i];
                dataOutputStream.writeLong(wVar.f259a);
                dataOutputStream.writeLong(wVar.f260b);
                dataOutputStream.writeUTF(wVar.f262d);
                dataOutputStream.writeUTF(wVar.f261c);
                dataOutputStream.writeLong(wVar.f263e);
                dataOutputStream.writeLong(wVar.f264f.longValue());
                dataOutputStream.writeByte(wVar.f265g.length);
                dataOutputStream.write(wVar.f265g);
            }
        }
        dataOutputStream.writeShort(this.f93i.size());
        for (Map.Entry entry5 : this.f93i.entrySet()) {
            dataOutputStream.writeByte(((Byte) entry5.getKey()).byteValue());
            ((C0101c) entry5.getValue()).mo3307a((DataOutput) dataOutputStream);
        }
        dataOutputStream.writeShort(this.f94j.size());
        for (Map.Entry entry6 : this.f94j.entrySet()) {
            dataOutputStream.writeShort(((Short) entry6.getKey()).shortValue());
            dataOutputStream.writeLong(((Long) entry6.getValue()).longValue());
        }
    }

    /* renamed from: g */
    private String m71g() {
        return ".flurryappcircle." + Integer.toString(this.f87c.f80a.hashCode(), 16);
    }

    /* renamed from: a */
    private void m66a(int i) {
        this.f95k = !this.f91g.isEmpty();
        if (this.f95k) {
            this.f86b.mo3337a(i);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("adImages (" + this.f89e.mo3299b().size() + "),\n");
        sb.append("adBlock (" + this.f91g.size() + "):").append(",\n");
        for (Map.Entry entry : this.f91g.entrySet()) {
            sb.append("\t" + ((String) entry.getKey()) + ": " + Arrays.toString((Object[]) entry.getValue()));
        }
        sb.append("adHooks (" + this.f92h.size() + "):" + this.f92h).append(",\n");
        sb.append("adThemes (" + this.f93i.size() + "):" + this.f93i).append(",\n");
        sb.append("auxMap (" + this.f94j.size() + "):" + this.f94j).append(",\n");
        sb.append("}");
        return sb.toString();
    }
}
