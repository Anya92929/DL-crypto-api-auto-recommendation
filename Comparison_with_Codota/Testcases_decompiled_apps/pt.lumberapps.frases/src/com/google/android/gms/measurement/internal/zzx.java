package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.p009v4.p019f.C0136a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzapo;
import com.google.android.gms.internal.zzug;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.p051a.C1971a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzx {

    /* renamed from: a */
    private static volatile zzx f7364a;

    /* renamed from: A */
    private int f7365A;

    /* renamed from: B */
    private int f7366B;
    public final C1971a alh = new C1971a(this);

    /* renamed from: b */
    private final Context f7367b;

    /* renamed from: c */
    private final zzd f7368c;

    /* renamed from: d */
    private final zzt f7369d;

    /* renamed from: e */
    private final zzp f7370e;

    /* renamed from: f */
    private final zzw f7371f;

    /* renamed from: g */
    private final zzaf f7372g;

    /* renamed from: h */
    private final zzv f7373h;

    /* renamed from: i */
    private final AppMeasurement f7374i;

    /* renamed from: j */
    private final zzal f7375j;

    /* renamed from: k */
    private final zze f7376k;

    /* renamed from: l */
    private final zzq f7377l;

    /* renamed from: m */
    private final zze f7378m;

    /* renamed from: n */
    private final zzad f7379n;

    /* renamed from: o */
    private final zzg f7380o;

    /* renamed from: p */
    private final zzac f7381p;

    /* renamed from: q */
    private final zzn f7382q;

    /* renamed from: r */
    private final C1901as f7383r;

    /* renamed from: s */
    private final zzai f7384s;

    /* renamed from: t */
    private final C1889ag f7385t;

    /* renamed from: u */
    private final boolean f7386u;

    /* renamed from: v */
    private boolean f7387v;

    /* renamed from: w */
    private Boolean f7388w;

    /* renamed from: x */
    private FileLock f7389x;

    /* renamed from: y */
    private FileChannel f7390y;

    /* renamed from: z */
    private List f7391z;

    zzx(zzab zzab) {
        zzab.zzy(zzab);
        this.f7367b = zzab.f7242a;
        this.f7378m = zzab.mo9378l(this);
        this.f7368c = zzab.mo9367a(this);
        zzt b = zzab.mo9368b(this);
        b.initialize();
        this.f7369d = b;
        zzp c = zzab.mo9369c(this);
        c.initialize();
        this.f7370e = c;
        zzbsd().zzbta().zzj("App measurement is starting up, version", Long.valueOf(zzbsf().zzbpz()));
        zzbsd().zzbta().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzbsd().zzbtb().log("Debug logging enabled");
        zzbsd().zzbtb().zzj("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.f7375j = zzab.mo9375i(this);
        zzg n = zzab.mo9380n(this);
        n.initialize();
        this.f7380o = n;
        zzn o = zzab.mo9381o(this);
        o.initialize();
        this.f7382q = o;
        zze j = zzab.mo9376j(this);
        j.initialize();
        this.f7376k = j;
        C1889ag r = zzab.mo9384r(this);
        r.initialize();
        this.f7385t = r;
        zzq k = zzab.mo9377k(this);
        k.initialize();
        this.f7377l = k;
        zzad m = zzab.mo9379m(this);
        m.initialize();
        this.f7379n = m;
        zzac h = zzab.mo9374h(this);
        h.initialize();
        this.f7381p = h;
        zzai q = zzab.mo9383q(this);
        q.initialize();
        this.f7384s = q;
        this.f7383r = zzab.mo9382p(this);
        this.f7374i = zzab.mo9373g(this);
        zzaf e = zzab.mo9371e(this);
        e.initialize();
        this.f7372g = e;
        zzv f = zzab.mo9372f(this);
        f.initialize();
        this.f7373h = f;
        zzw d = zzab.mo9370d(this);
        d.initialize();
        this.f7371f = d;
        if (this.f7365A != this.f7366B) {
            zzbsd().zzbsv().zze("Not all components initialized", Integer.valueOf(this.f7365A), Integer.valueOf(this.f7366B));
        }
        this.f7386u = true;
        if (!this.f7368c.zzabc() && !mo9669h()) {
            if (!(this.f7367b.getApplicationContext() instanceof Application)) {
                zzbsd().zzbsx().log("Application context is not an Application");
            } else if (Build.VERSION.SDK_INT >= 14) {
                zzbru().zzbun();
            } else {
                zzbsd().zzbtb().log("Not tracking deep linking pre-ICS");
            }
        }
        this.f7371f.zzm(new C1910ba(this));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7967a(int i, Throwable th, byte[] bArr) {
        boolean z = false;
        zzwu();
        mo9646a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.f7391z;
        this.f7391z = null;
        if ((i == 200 || i == 204) && th == null) {
            zzbse().f7315c.set(zzyw().currentTimeMillis());
            zzbse().f7316d.set(0);
            m7977q();
            zzbsd().zzbtc().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            zzbry().mo9542e();
            try {
                for (Long longValue : list) {
                    zzbry().mo9518a(longValue.longValue());
                }
                zzbry().mo9545f();
                zzbry().mo9546g();
                if (!zzbts().zzadj() || !m7976p()) {
                    m7977q();
                } else {
                    zzbuc();
                }
            } catch (Throwable th2) {
                zzbry().mo9546g();
                throw th2;
            }
        } else {
            zzbsd().zzbtc().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzbse().f7316d.set(zzyw().currentTimeMillis());
            if (i == 503 || i == 429) {
                z = true;
            }
            if (z) {
                zzbse().f7317e.set(zzyw().currentTimeMillis());
            }
            m7977q();
        }
    }

    /* renamed from: a */
    private void m7968a(C1922bm bmVar) {
        if (bmVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* renamed from: a */
    private void m7970a(List list) {
        zzab.zzbo(!list.isEmpty());
        if (this.f7391z != null) {
            zzbsd().zzbsv().log("Set uploading progress before finishing the previous upload");
        } else {
            this.f7391z = new ArrayList(list);
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private boolean m7971a(String str, long j) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        zzbry().mo9542e();
        try {
            C1913bd bdVar = new C1913bd(this, (C1910ba) null);
            zzbry().mo9526a(str, j, (C1890ah) bdVar);
            if (!bdVar.mo9308a()) {
                zzuh.zze zze = bdVar.f7162a;
                zze.anv = new zzuh.zzb[bdVar.f7164c.size()];
                int i3 = 0;
                int i4 = 0;
                while (i4 < bdVar.f7164c.size()) {
                    if (zzbsa().mo9638b(bdVar.f7162a.zzck, ((zzuh.zzb) bdVar.f7164c.get(i4)).name)) {
                        zzbsd().zzbsx().zzj("Dropping blacklisted raw event", ((zzuh.zzb) bdVar.f7164c.get(i4)).name);
                        zzbrz().zze(11, "_ev", ((zzuh.zzb) bdVar.f7164c.get(i4)).name);
                        i = i3;
                    } else {
                        if (zzbsa().mo9640c(bdVar.f7162a.zzck, ((zzuh.zzb) bdVar.f7164c.get(i4)).name)) {
                            if (((zzuh.zzb) bdVar.f7164c.get(i4)).ann == null) {
                                ((zzuh.zzb) bdVar.f7164c.get(i4)).ann = new zzuh.zzc[0];
                            }
                            zzuh.zzc[] zzcArr = ((zzuh.zzb) bdVar.f7164c.get(i4)).ann;
                            int length = zzcArr.length;
                            int i5 = 0;
                            while (true) {
                                if (i5 >= length) {
                                    z = false;
                                    break;
                                }
                                zzuh.zzc zzc = zzcArr[i5];
                                if ("_c".equals(zzc.name)) {
                                    zzc.anr = 1L;
                                    z = true;
                                    break;
                                }
                                i5++;
                            }
                            if (!z) {
                                zzbsd().zzbtc().zzj("Marking event as conversion", ((zzuh.zzb) bdVar.f7164c.get(i4)).name);
                                zzuh.zzc[] zzcArr2 = (zzuh.zzc[]) Arrays.copyOf(((zzuh.zzb) bdVar.f7164c.get(i4)).ann, ((zzuh.zzb) bdVar.f7164c.get(i4)).ann.length + 1);
                                zzuh.zzc zzc2 = new zzuh.zzc();
                                zzc2.name = "_c";
                                zzc2.anr = 1L;
                                zzcArr2[zzcArr2.length - 1] = zzc2;
                                ((zzuh.zzb) bdVar.f7164c.get(i4)).ann = zzcArr2;
                            }
                            boolean a = zzal.m7804a(((zzuh.zzb) bdVar.f7164c.get(i4)).name);
                            if (a && zzbry().mo9515a(mo9670i(), bdVar.f7162a.zzck, false, a, false).f7275c - ((long) zzbsf().zzlf(bdVar.f7162a.zzck)) > 0) {
                                zzbsd().zzbsx().log("Too many conversions. Not logging as conversion.");
                                zzuh.zzb zzb = (zzuh.zzb) bdVar.f7164c.get(i4);
                                boolean z3 = false;
                                zzuh.zzc zzc3 = null;
                                zzuh.zzc[] zzcArr3 = ((zzuh.zzb) bdVar.f7164c.get(i4)).ann;
                                int length2 = zzcArr3.length;
                                int i6 = 0;
                                while (i6 < length2) {
                                    zzuh.zzc zzc4 = zzcArr3[i6];
                                    if ("_c".equals(zzc4.name)) {
                                        z2 = z3;
                                    } else if ("_err".equals(zzc4.name)) {
                                        zzuh.zzc zzc5 = zzc3;
                                        z2 = true;
                                        zzc4 = zzc5;
                                    } else {
                                        zzc4 = zzc3;
                                        z2 = z3;
                                    }
                                    i6++;
                                    z3 = z2;
                                    zzc3 = zzc4;
                                }
                                if (z3 && zzc3 != null) {
                                    zzuh.zzc[] zzcArr4 = new zzuh.zzc[(zzb.ann.length - 1)];
                                    int i7 = 0;
                                    zzuh.zzc[] zzcArr5 = zzb.ann;
                                    int length3 = zzcArr5.length;
                                    int i8 = 0;
                                    while (i8 < length3) {
                                        zzuh.zzc zzc6 = zzcArr5[i8];
                                        if (zzc6 != zzc3) {
                                            i2 = i7 + 1;
                                            zzcArr4[i7] = zzc6;
                                        } else {
                                            i2 = i7;
                                        }
                                        i8++;
                                        i7 = i2;
                                    }
                                    ((zzuh.zzb) bdVar.f7164c.get(i4)).ann = zzcArr4;
                                } else if (zzc3 != null) {
                                    zzc3.name = "_err";
                                    zzc3.anr = 10L;
                                } else {
                                    zzbsd().zzbsv().log("Did not find conversion parameter. Error not tracked");
                                }
                            }
                        }
                        zze.anv[i3] = (zzuh.zzb) bdVar.f7164c.get(i4);
                        i = i3 + 1;
                    }
                    i4++;
                    i3 = i;
                }
                if (i3 < bdVar.f7164c.size()) {
                    zze.anv = (zzuh.zzb[]) Arrays.copyOf(zze.anv, i3);
                }
                zze.anO = m7972a(bdVar.f7162a.zzck, bdVar.f7162a.anw, zze.anv);
                zze.any = zze.anv[0].ano;
                zze.anz = zze.anv[0].ano;
                for (int i9 = 1; i9 < zze.anv.length; i9++) {
                    zzuh.zzb zzb2 = zze.anv[i9];
                    if (zzb2.ano.longValue() < zze.any.longValue()) {
                        zze.any = zzb2.ano;
                    }
                    if (zzb2.ano.longValue() > zze.anz.longValue()) {
                        zze.anz = zzb2.ano;
                    }
                }
                String str2 = bdVar.f7162a.zzck;
                C1909b b = zzbry().mo9532b(str2);
                if (b == null) {
                    zzbsd().zzbsv().log("Bundling raw events w/o app info");
                } else {
                    long h = b.mo9285h();
                    zze.anB = h != 0 ? Long.valueOf(h) : null;
                    long g = b.mo9283g();
                    if (g != 0) {
                        h = g;
                    }
                    zze.anA = h != 0 ? Long.valueOf(h) : null;
                    b.mo9301r();
                    zze.anM = Integer.valueOf((int) b.mo9298o());
                    b.mo9265a(zze.any.longValue());
                    b.mo9269b(zze.anz.longValue());
                    zzbry().mo9522a(b);
                }
                zze.aig = zzbsd().zzbtd();
                zzbry().mo9520a(zze);
                zzbry().mo9529a(bdVar.f7163b);
                zzbry().mo9549h(str2);
                zzbry().mo9545f();
                zzbry().mo9546g();
                return true;
            }
            zzbry().mo9545f();
            zzbry().mo9546g();
            return false;
        } catch (Throwable th) {
            zzbry().mo9546g();
            throw th;
        }
    }

    /* renamed from: a */
    private zzuh.zza[] m7972a(String str, zzuh.zzg[] zzgArr, zzuh.zzb[] zzbArr) {
        zzab.zzhr(str);
        return zzbrt().mo9224a(str, zzbArr, zzgArr);
    }

    /* renamed from: b */
    private void m7973b(AppMetadata appMetadata) {
        boolean z = true;
        zzwu();
        mo9646a();
        zzab.zzy(appMetadata);
        zzab.zzhr(appMetadata.packageName);
        C1909b b = zzbry().mo9532b(appMetadata.packageName);
        String b2 = zzbse().mo9615b(appMetadata.packageName);
        boolean z2 = false;
        if (b == null) {
            C1909b bVar = new C1909b(this, appMetadata.packageName);
            bVar.mo9266a(zzbse().mo9619e());
            bVar.mo9273c(b2);
            b = bVar;
            z2 = true;
        } else if (!b2.equals(b.mo9277e())) {
            b.mo9273c(b2);
            b.mo9266a(zzbse().mo9619e());
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.aic) && !appMetadata.aic.equals(b.mo9274d())) {
            b.mo9270b(appMetadata.aic);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.aik) && !appMetadata.aik.equals(b.mo9280f())) {
            b.mo9276d(appMetadata.aik);
            z2 = true;
        }
        if (!(appMetadata.aie == 0 || appMetadata.aie == b.mo9293l())) {
            b.mo9275d(appMetadata.aie);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.aav) && !appMetadata.aav.equals(b.mo9287i())) {
            b.mo9279e(appMetadata.aav);
            z2 = true;
        }
        if (appMetadata.aij != b.mo9289j()) {
            b.mo9272c(appMetadata.aij);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.aid) && !appMetadata.aid.equals(b.mo9291k())) {
            b.mo9282f(appMetadata.aid);
            z2 = true;
        }
        if (appMetadata.aif != b.mo9295m()) {
            b.mo9278e(appMetadata.aif);
            z2 = true;
        }
        if (appMetadata.aih != b.mo9297n()) {
            b.mo9267a(appMetadata.aih);
        } else {
            z = z2;
        }
        if (z) {
            zzbry().mo9522a(b);
        }
    }

    /* renamed from: b */
    private void m7974b(C1923c cVar) {
        if (cVar == null) {
            throw new IllegalStateException("Component not created");
        } else if (!cVar.mo9337a()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    /* renamed from: o */
    private boolean m7975o() {
        zzwu();
        return this.f7391z != null;
    }

    /* renamed from: p */
    private boolean m7976p() {
        zzwu();
        mo9646a();
        return zzbry().mo9557o() || !TextUtils.isEmpty(zzbry().mo9552j());
    }

    /* renamed from: q */
    private void m7977q() {
        zzwu();
        mo9646a();
        if (mo9676n()) {
            if (!mo9660b() || !m7976p()) {
                zzbtt().mo9252b();
                zzbtu().cancel();
                return;
            }
            long r = m7978r();
            if (r == 0) {
                zzbtt().mo9252b();
                zzbtu().cancel();
            } else if (!zzbts().zzadj()) {
                zzbtt().mo9251a();
                zzbtu().cancel();
            } else {
                long j = zzbse().f7317e.get();
                long zzbrm = zzbsf().zzbrm();
                if (!zzbrz().zzg(j, zzbrm)) {
                    r = Math.max(r, j + zzbrm);
                }
                zzbtt().mo9252b();
                long currentTimeMillis = r - zzyw().currentTimeMillis();
                if (currentTimeMillis <= 0) {
                    zzbtu().zzv(1);
                    return;
                }
                zzbsd().zzbtc().zzj("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis));
                zzbtu().zzv(currentTimeMillis);
            }
        }
    }

    /* renamed from: r */
    private long m7978r() {
        long currentTimeMillis = zzyw().currentTimeMillis();
        long zzbrp = zzbsf().zzbrp();
        long zzbrn = zzbsf().zzbrn();
        long j = zzbse().f7315c.get();
        long j2 = zzbse().f7316d.get();
        long max = Math.max(zzbry().mo9555m(), zzbry().mo9556n());
        if (max == 0) {
            return 0;
        }
        long abs = currentTimeMillis - Math.abs(max - currentTimeMillis);
        long abs2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
        long max2 = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), abs2);
        long j3 = zzbrp + abs;
        if (!zzbrz().zzg(max2, zzbrn)) {
            j3 = max2 + zzbrn;
        }
        if (abs2 == 0 || abs2 < abs) {
            return j3;
        }
        for (int i = 0; i < zzbsf().zzbrr(); i++) {
            j3 += ((long) (1 << i)) * zzbsf().zzbrq();
            if (j3 > abs2) {
                return j3;
            }
        }
        return 0;
    }

    public static zzx zzdo(Context context) {
        zzab.zzy(context);
        zzab.zzy(context.getApplicationContext());
        if (f7364a == null) {
            synchronized (zzx.class) {
                if (f7364a == null) {
                    f7364a = new zzab(context).zzbum();
                }
            }
        }
        return f7364a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo9645a(FileChannel fileChannel) {
        zzwu();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbsd().zzbsv().log("Bad chanel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                zzbsd().zzbsx().zzj("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(read));
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            zzbsd().zzbsv().zzj("Failed to read from channel", e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9646a() {
        if (!this.f7386u) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9647a(AppMetadata appMetadata) {
        zzwu();
        mo9646a();
        zzab.zzhr(appMetadata.packageName);
        m7973b(appMetadata);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9648a(AppMetadata appMetadata, long j) {
        C1909b b = zzbry().mo9532b(appMetadata.packageName);
        if (!(b == null || b.mo9274d() == null || b.mo9274d().equals(appMetadata.aic))) {
            zzbsd().zzbsx().log("New GMP App Id passed in. Removing cached database data.");
            zzbry().mo9547g(b.mo9268b());
            b = null;
        }
        if (b != null && b.mo9287i() != null && !b.mo9287i().equals(appMetadata.aav)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", b.mo9287i());
            mo9649a(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x01d3=Splitter:B:49:0x01d3, B:78:0x02b4=Splitter:B:78:0x02b4} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9649a(com.google.android.gms.measurement.internal.EventParcel r19, com.google.android.gms.measurement.internal.AppMetadata r20) {
        /*
            r18 = this;
            long r16 = java.lang.System.nanoTime()
            r18.zzwu()
            r18.mo9646a()
            r0 = r20
            java.lang.String r4 = r0.packageName
            com.google.android.gms.common.internal.zzab.zzhr(r4)
            r0 = r20
            java.lang.String r2 = r0.aic
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x001c
        L_0x001b:
            return
        L_0x001c:
            r0 = r20
            boolean r2 = r0.aih
            if (r2 != 0) goto L_0x002a
            r0 = r18
            r1 = r20
            r0.m7973b((com.google.android.gms.measurement.internal.AppMetadata) r1)
            goto L_0x001b
        L_0x002a:
            com.google.android.gms.measurement.internal.zzv r2 = r18.zzbsa()
            r0 = r19
            java.lang.String r3 = r0.name
            boolean r2 = r2.mo9638b(r4, r3)
            if (r2 == 0) goto L_0x0059
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbsd()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsx()
            java.lang.String r3 = "Dropping blacklisted event"
            r0 = r19
            java.lang.String r4 = r0.name
            r2.zzj(r3, r4)
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbrz()
            r3 = 11
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name
            r2.zze(r3, r4, r5)
            goto L_0x001b
        L_0x0059:
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbsd()
            r3 = 2
            boolean r2 = r2.mo9592a((int) r3)
            if (r2 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbsd()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbtc()
            java.lang.String r3 = "Logging event"
            r0 = r19
            r2.zzj(r3, r0)
        L_0x0073:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()
            r2.mo9542e()
            r0 = r19
            com.google.android.gms.measurement.internal.EventParams r2 = r0.aiI     // Catch:{ all -> 0x0204 }
            android.os.Bundle r14 = r2.zzbss()     // Catch:{ all -> 0x0204 }
            r0 = r18
            r1 = r20
            r0.m7973b((com.google.android.gms.measurement.internal.AppMetadata) r1)     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "_iap"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x00a1
            java.lang.String r2 = "ecommerce_purchase"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x0163
        L_0x00a1:
            java.lang.String r2 = "currency"
            java.lang.String r5 = r14.getString(r2)     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "ecommerce_purchase"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x01f4
            java.lang.String r2 = "value"
            double r2 = r14.getDouble(r2)     // Catch:{ all -> 0x0204 }
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r2 = r2 * r6
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x00d2
            java.lang.String r2 = "value"
            long r2 = r14.getLong(r2)     // Catch:{ all -> 0x0204 }
            double r2 = (double) r2     // Catch:{ all -> 0x0204 }
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r2 = r2 * r6
        L_0x00d2:
            r6 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x01d3
            r6 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x01d3
            long r2 = java.lang.Math.round(r2)     // Catch:{ all -> 0x0204 }
            r8 = r2
        L_0x00e3:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x0163
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = r5.toUpperCase(r2)     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "[A-Z]{3}"
            boolean r3 = r2.matches(r3)     // Catch:{ all -> 0x0204 }
            if (r3 == 0) goto L_0x0163
            java.lang.String r3 = "_ltv_"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0204 }
            int r5 = r2.length()     // Catch:{ all -> 0x0204 }
            if (r5 == 0) goto L_0x01fd
            java.lang.String r5 = r3.concat(r2)     // Catch:{ all -> 0x0204 }
        L_0x010b:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.af r2 = r2.mo9538c(r4, r5)     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x011b
            java.lang.Object r3 = r2.f7084d     // Catch:{ all -> 0x0204 }
            boolean r3 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x0204 }
            if (r3 != 0) goto L_0x020d
        L_0x011b:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzbsf()     // Catch:{ all -> 0x0204 }
            int r3 = r3.mo9467b(r4)     // Catch:{ all -> 0x0204 }
            int r3 = r3 + -1
            r2.mo9524a((java.lang.String) r4, (int) r3)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.af r3 = new com.google.android.gms.measurement.internal.af     // Catch:{ all -> 0x0204 }
            com.google.android.gms.common.util.zze r2 = r18.zzyw()     // Catch:{ all -> 0x0204 }
            long r6 = r2.currentTimeMillis()     // Catch:{ all -> 0x0204 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0204 }
            r3.<init>(r4, r5, r6, r8)     // Catch:{ all -> 0x0204 }
        L_0x013d:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            boolean r2 = r2.mo9530a((com.google.android.gms.measurement.internal.C1888af) r3)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x0163
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x0204 }
            java.lang.String r5 = "Too many unique user properties are set. Ignoring user property."
            java.lang.String r6 = r3.f7082b     // Catch:{ all -> 0x0204 }
            java.lang.Object r3 = r3.f7084d     // Catch:{ all -> 0x0204 }
            r2.zze(r5, r6, r3)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbrz()     // Catch:{ all -> 0x0204 }
            r3 = 9
            r5 = 0
            r6 = 0
            r2.zze(r3, r5, r6)     // Catch:{ all -> 0x0204 }
        L_0x0163:
            r0 = r19
            java.lang.String r2 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r9 = com.google.android.gms.measurement.internal.zzal.m7804a((java.lang.String) r2)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzal.zzam(r14)     // Catch:{ all -> 0x0204 }
            java.lang.String r2 = "_err"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0204 }
            boolean r11 = r2.equals(r3)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r5 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            long r6 = r18.mo9670i()     // Catch:{ all -> 0x0204 }
            r10 = 0
            r8 = r4
            com.google.android.gms.measurement.internal.zze$zza r2 = r5.mo9515a(r6, r8, r9, r10, r11)     // Catch:{ all -> 0x0204 }
            long r6 = r2.f7274b     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzbsf()     // Catch:{ all -> 0x0204 }
            long r12 = r3.zzbqv()     // Catch:{ all -> 0x0204 }
            long r6 = r6 - r12
            r12 = 0
            int r3 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0229
            r4 = 1000(0x3e8, double:4.94E-321)
            long r4 = r6 % r4
            r6 = 1
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x01b4
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbsv()     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "Data loss. Too many events logged. count"
            long r6 = r2.f7274b     // Catch:{ all -> 0x0204 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0204 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0204 }
        L_0x01b4:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbrz()     // Catch:{ all -> 0x0204 }
            r3 = 16
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x0204 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            r2.mo9545f()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()
            r2.mo9546g()
            goto L_0x001b
        L_0x01d3:
            com.google.android.gms.measurement.internal.zzp r4 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbsx()     // Catch:{ all -> 0x0204 }
            java.lang.String r5 = "Data lost. Currency value is too big"
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x0204 }
            r4.zzj(r5, r2)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            r2.mo9545f()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()
            r2.mo9546g()
            goto L_0x001b
        L_0x01f4:
            java.lang.String r2 = "value"
            long r2 = r14.getLong(r2)     // Catch:{ all -> 0x0204 }
            r8 = r2
            goto L_0x00e3
        L_0x01fd:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0204 }
            r5.<init>(r3)     // Catch:{ all -> 0x0204 }
            goto L_0x010b
        L_0x0204:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zze r3 = r18.zzbry()
            r3.mo9546g()
            throw r2
        L_0x020d:
            java.lang.Object r2 = r2.f7084d     // Catch:{ all -> 0x0204 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0204 }
            long r10 = r2.longValue()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.af r3 = new com.google.android.gms.measurement.internal.af     // Catch:{ all -> 0x0204 }
            com.google.android.gms.common.util.zze r2 = r18.zzyw()     // Catch:{ all -> 0x0204 }
            long r6 = r2.currentTimeMillis()     // Catch:{ all -> 0x0204 }
            long r8 = r8 + r10
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0204 }
            r3.<init>(r4, r5, r6, r8)     // Catch:{ all -> 0x0204 }
            goto L_0x013d
        L_0x0229:
            if (r9 == 0) goto L_0x0278
            long r6 = r2.f7273a     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzbsf()     // Catch:{ all -> 0x0204 }
            long r8 = r3.zzbqw()     // Catch:{ all -> 0x0204 }
            long r6 = r6 - r8
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x0278
            r4 = 1000(0x3e8, double:4.94E-321)
            long r4 = r6 % r4
            r6 = 1
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0259
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbsv()     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "Data loss. Too many public events logged. count"
            long r6 = r2.f7273a     // Catch:{ all -> 0x0204 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0204 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0204 }
        L_0x0259:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbrz()     // Catch:{ all -> 0x0204 }
            r3 = 16
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x0204 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            r2.mo9545f()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()
            r2.mo9546g()
            goto L_0x001b
        L_0x0278:
            if (r11 == 0) goto L_0x02b4
            long r6 = r2.f7276d     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzbsf()     // Catch:{ all -> 0x0204 }
            long r8 = r3.zzbqx()     // Catch:{ all -> 0x0204 }
            long r6 = r6 - r8
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x02b4
            r4 = 1
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x02a4
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbsv()     // Catch:{ all -> 0x0204 }
            java.lang.String r4 = "Too many error events logged. count"
            long r6 = r2.f7276d     // Catch:{ all -> 0x0204 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0204 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0204 }
        L_0x02a4:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            r2.mo9545f()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()
            r2.mo9546g()
            goto L_0x001b
        L_0x02b4:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbrz()     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "_o"
            r0 = r19
            java.lang.String r5 = r0.aiJ     // Catch:{ all -> 0x0204 }
            r2.zza((android.os.Bundle) r14, (java.lang.String) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            long r2 = r2.mo9537c(r4)     // Catch:{ all -> 0x0204 }
            r6 = 0
            int r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x02e0
            com.google.android.gms.measurement.internal.zzp r5 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r5 = r5.zzbsx()     // Catch:{ all -> 0x0204 }
            java.lang.String r6 = "Data lost. Too many events stored on disk, deleted"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0204 }
            r5.zzj(r6, r2)     // Catch:{ all -> 0x0204 }
        L_0x02e0:
            com.google.android.gms.measurement.internal.zzh r5 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0204 }
            r0 = r19
            java.lang.String r7 = r0.aiJ     // Catch:{ all -> 0x0204 }
            r0 = r19
            java.lang.String r9 = r0.name     // Catch:{ all -> 0x0204 }
            r0 = r19
            long r10 = r0.aiK     // Catch:{ all -> 0x0204 }
            r12 = 0
            r6 = r18
            r8 = r4
            r5.<init>((com.google.android.gms.measurement.internal.zzx) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (long) r10, (long) r12, (android.os.Bundle) r14)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = r5.f7281b     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.al r2 = r2.mo9514a((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ all -> 0x0204 }
            if (r2 != 0) goto L_0x03ac
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            long r2 = r2.mo9550i(r4)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r6 = r18.zzbsf()     // Catch:{ all -> 0x0204 }
            int r6 = r6.mo9470e()     // Catch:{ all -> 0x0204 }
            long r6 = (long) r6     // Catch:{ all -> 0x0204 }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0346
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbsv()     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "Too many event names used, ignoring event. name, supported count"
            java.lang.String r4 = r5.f7281b     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzd r5 = r18.zzbsf()     // Catch:{ all -> 0x0204 }
            int r5 = r5.mo9470e()     // Catch:{ all -> 0x0204 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0204 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbrz()     // Catch:{ all -> 0x0204 }
            r3 = 8
            r4 = 0
            r5 = 0
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()
            r2.mo9546g()
            goto L_0x001b
        L_0x0346:
            com.google.android.gms.measurement.internal.al r7 = new com.google.android.gms.measurement.internal.al     // Catch:{ all -> 0x0204 }
            java.lang.String r9 = r5.f7281b     // Catch:{ all -> 0x0204 }
            r10 = 0
            r12 = 0
            long r14 = r5.f7283d     // Catch:{ all -> 0x0204 }
            r8 = r4
            r7.<init>(r8, r9, r10, r12, r14)     // Catch:{ all -> 0x0204 }
        L_0x0354:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            r2.mo9521a((com.google.android.gms.measurement.internal.C1894al) r7)     // Catch:{ all -> 0x0204 }
            r0 = r18
            r1 = r20
            r0.mo9653a((com.google.android.gms.measurement.internal.zzh) r5, (com.google.android.gms.measurement.internal.AppMetadata) r1)     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()     // Catch:{ all -> 0x0204 }
            r2.mo9545f()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            r3 = 2
            boolean r2 = r2.mo9592a((int) r3)     // Catch:{ all -> 0x0204 }
            if (r2 == 0) goto L_0x0381
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbsd()     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbtc()     // Catch:{ all -> 0x0204 }
            java.lang.String r3 = "Event recorded"
            r2.zzj(r3, r5)     // Catch:{ all -> 0x0204 }
        L_0x0381:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbry()
            r2.mo9546g()
            r18.m7977q()
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbsd()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbtc()
            java.lang.String r3 = "Background event processing time, ms"
            long r4 = java.lang.System.nanoTime()
            long r4 = r4 - r16
            r6 = 500000(0x7a120, double:2.47033E-318)
            long r4 = r4 + r6
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.zzj(r3, r4)
            goto L_0x001b
        L_0x03ac:
            long r6 = r2.f7096e     // Catch:{ all -> 0x0204 }
            r0 = r18
            com.google.android.gms.measurement.internal.zzh r5 = r5.mo9564a((com.google.android.gms.measurement.internal.zzx) r0, (long) r6)     // Catch:{ all -> 0x0204 }
            long r6 = r5.f7283d     // Catch:{ all -> 0x0204 }
            com.google.android.gms.measurement.internal.al r7 = r2.mo9238a(r6)     // Catch:{ all -> 0x0204 }
            goto L_0x0354
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.mo9649a(com.google.android.gms.measurement.internal.EventParcel, com.google.android.gms.measurement.internal.AppMetadata):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9650a(EventParcel eventParcel, String str) {
        C1909b b = zzbry().mo9532b(str);
        if (b == null || TextUtils.isEmpty(b.mo9287i())) {
            zzbsd().zzbtb().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = getContext().getPackageManager().getPackageInfo(str, 0).versionName;
            if (b.mo9287i() != null && !b.mo9287i().equals(str2)) {
                zzbsd().zzbsx().zzj("App version does not match; dropping event", str);
                return;
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.name)) {
                zzbsd().zzbsx().zzj("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        mo9649a(eventParcel2, new AppMetadata(str, b.mo9274d(), b.mo9287i(), b.mo9289j(), b.mo9291k(), b.mo9293l(), b.mo9295m(), (String) null, b.mo9297n(), false, b.mo9280f()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9651a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzwu();
        mo9646a();
        if (!TextUtils.isEmpty(appMetadata.aic)) {
            if (!appMetadata.aih) {
                m7973b(appMetadata);
                return;
            }
            int zzmn = zzbrz().zzmn(userAttributeParcel.name);
            if (zzmn != 0) {
                zzbrz().zze(zzmn, "_ev", zzbrz().zza(userAttributeParcel.name, zzbsf().zzbqo(), true));
                return;
            }
            int zzm = zzbrz().zzm(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzm != 0) {
                zzbrz().zze(zzm, "_ev", zzbrz().zza(userAttributeParcel.name, zzbsf().zzbqo(), true));
                return;
            }
            Object zzn = zzbrz().zzn(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzn != null) {
                C1888af afVar = new C1888af(appMetadata.packageName, userAttributeParcel.name, userAttributeParcel.amt, zzn);
                zzbsd().zzbtb().zze("Setting user property", afVar.f7082b, zzn);
                zzbry().mo9542e();
                try {
                    m7973b(appMetadata);
                    boolean a = zzbry().mo9530a(afVar);
                    zzbry().mo9545f();
                    if (a) {
                        zzbsd().zzbtb().zze("User property set", afVar.f7082b, afVar.f7084d);
                    } else {
                        zzbsd().zzbsv().zze("Too many unique user properties are set. Ignoring user property.", afVar.f7082b, afVar.f7084d);
                        zzbrz().zze(9, (String) null, (String) null);
                    }
                } finally {
                    zzbry().mo9546g();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9652a(C1923c cVar) {
        this.f7365A++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9653a(zzh zzh, AppMetadata appMetadata) {
        zzwu();
        mo9646a();
        zzab.zzy(zzh);
        zzab.zzy(appMetadata);
        zzab.zzhr(zzh.f7280a);
        zzab.zzbo(zzh.f7280a.equals(appMetadata.packageName));
        zzuh.zze zze = new zzuh.zze();
        zze.anu = 1;
        zze.anC = "android";
        zze.zzck = appMetadata.packageName;
        zze.aid = appMetadata.aid;
        zze.aav = appMetadata.aav;
        zze.anP = Integer.valueOf((int) appMetadata.aij);
        zze.anG = Long.valueOf(appMetadata.aie);
        zze.aic = appMetadata.aic;
        zze.anL = appMetadata.aif == 0 ? null : Long.valueOf(appMetadata.aif);
        Pair a = zzbse().mo9613a(appMetadata.packageName);
        if (a != null && !TextUtils.isEmpty((CharSequence) a.first)) {
            zze.anI = (String) a.first;
            zze.anJ = (Boolean) a.second;
        } else if (!zzbrw().zzdn(this.f7367b)) {
            String string = Settings.Secure.getString(this.f7367b.getContentResolver(), "android_id");
            if (string == null) {
                zzbsd().zzbsx().log("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                zzbsd().zzbsx().log("empty secure ID");
            }
            zze.anS = string;
        }
        zze.anD = zzbrw().zztg();
        zze.zzct = zzbrw().zzbso();
        zze.anF = Integer.valueOf((int) zzbrw().zzbsp());
        zze.anE = zzbrw().zzbsq();
        zze.anH = null;
        zze.anx = null;
        zze.any = null;
        zze.anz = null;
        C1909b b = zzbry().mo9532b(appMetadata.packageName);
        if (b == null) {
            b = new C1909b(this, appMetadata.packageName);
            b.mo9266a(zzbse().mo9619e());
            b.mo9276d(appMetadata.aik);
            b.mo9270b(appMetadata.aic);
            b.mo9273c(zzbse().mo9615b(appMetadata.packageName));
            b.mo9281f(0);
            b.mo9265a(0);
            b.mo9269b(0);
            b.mo9279e(appMetadata.aav);
            b.mo9272c(appMetadata.aij);
            b.mo9282f(appMetadata.aid);
            b.mo9275d(appMetadata.aie);
            b.mo9278e(appMetadata.aif);
            b.mo9267a(appMetadata.aih);
            zzbry().mo9522a(b);
        }
        zze.anK = b.mo9271c();
        zze.aik = b.mo9280f();
        List a2 = zzbry().mo9516a(appMetadata.packageName);
        zze.anw = new zzuh.zzg[a2.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < a2.size()) {
                zzuh.zzg zzg = new zzuh.zzg();
                zze.anw[i2] = zzg;
                zzg.name = ((C1888af) a2.get(i2)).f7082b;
                zzg.anW = Long.valueOf(((C1888af) a2.get(i2)).f7083c);
                zzbrz().zza(zzg, ((C1888af) a2.get(i2)).f7084d);
                i = i2 + 1;
            } else {
                try {
                    zzbry().mo9523a(zzh, zzbry().mo9531b(zze));
                    return;
                } catch (IOException e) {
                    zzbsd().zzbsv().zzj("Data loss. Failed to insert raw event metadata", e);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9654a(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z = false;
        zzwu();
        mo9646a();
        zzab.zzhr(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        zzbry().mo9542e();
        try {
            C1909b b = zzbry().mo9532b(str);
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (b == null) {
                zzbsd().zzbsx().zzj("App does not exist in onConfigFetched", str);
            } else if (z2 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (zzbsa().mo9634a(str) == null && !zzbsa().mo9636a(str, (byte[]) null, (String) null)) {
                        zzbry().mo9546g();
                        return;
                    }
                } else if (!zzbsa().mo9636a(str, bArr, str2)) {
                    zzbry().mo9546g();
                    return;
                }
                b.mo9284g(zzyw().currentTimeMillis());
                zzbry().mo9522a(b);
                if (i == 404) {
                    zzbsd().zzbsx().log("Config not found. Using empty config");
                } else {
                    zzbsd().zzbtc().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (!zzbts().zzadj() || !m7976p()) {
                    m7977q();
                } else {
                    zzbuc();
                }
            } else {
                b.mo9286h(zzyw().currentTimeMillis());
                zzbry().mo9522a(b);
                zzbsd().zzbtc().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzbsa().mo9639c(str);
                zzbse().f7316d.set(zzyw().currentTimeMillis());
                if (i == 503 || i == 429) {
                    z = true;
                }
                if (z) {
                    zzbse().f7317e.set(zzyw().currentTimeMillis());
                }
                m7977q();
            }
            zzbry().mo9545f();
        } finally {
            zzbry().mo9546g();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9655a(int i, int i2) {
        zzwu();
        if (i > i2) {
            zzbsd().zzbsv().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (mo9656a(i2, mo9665e())) {
                zzbsd().zzbtc().zze("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                zzbsd().zzbsv().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9656a(int i, FileChannel fileChannel) {
        zzwu();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbsd().zzbsv().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzbsd().zzbsv().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzbsd().zzbsv().zzj("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo9657a(long j) {
        return m7971a((String) null, j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9658b(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        mo9649a(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9659b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzwu();
        mo9646a();
        if (!TextUtils.isEmpty(appMetadata.aic)) {
            if (!appMetadata.aih) {
                m7973b(appMetadata);
                return;
            }
            zzbsd().zzbtb().zzj("Removing user property", userAttributeParcel.name);
            zzbry().mo9542e();
            try {
                m7973b(appMetadata);
                zzbry().mo9536b(appMetadata.packageName, userAttributeParcel.name);
                zzbry().mo9545f();
                zzbsd().zzbtb().zzj("User property removed", userAttributeParcel.name);
            } finally {
                zzbry().mo9546g();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo9660b() {
        mo9646a();
        zzwu();
        if (this.f7388w == null) {
            this.f7388w = Boolean.valueOf(zzbrz().zzeo("android.permission.INTERNET") && zzbrz().zzeo("android.permission.ACCESS_NETWORK_STATE") && zzu.zzav(getContext()) && zzae.zzaw(getContext()));
            if (this.f7388w.booleanValue() && !zzbsf().zzabc()) {
                this.f7388w = Boolean.valueOf(zzbrz().zzmq(zzbrv().mo9582f()));
            }
        }
        return this.f7388w.booleanValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo9661c() {
        zzwu();
        if (!mo9669h() || (this.f7371f.mo9337a() && !this.f7371f.mo9338b())) {
            zzbry().mo9553k();
            if (mo9660b()) {
                if (!zzbsf().zzabc() && !TextUtils.isEmpty(zzbrv().mo9582f())) {
                    String h = zzbse().mo9622h();
                    if (h == null) {
                        zzbse().mo9617c(zzbrv().mo9582f());
                    } else if (!h.equals(zzbrv().mo9582f())) {
                        zzbsd().zzbta().log("Rechecking which service to use due to a GMP App Id change");
                        zzbse().mo9624j();
                        this.f7379n.disconnect();
                        this.f7379n.mo9408g();
                        zzbse().mo9617c(zzbrv().mo9582f());
                    }
                }
                if (!zzbsf().zzabc() && !mo9669h() && !TextUtils.isEmpty(zzbrv().mo9582f())) {
                    zzbru().zzbuo();
                }
            } else if (isEnabled()) {
                if (!zzbrz().zzeo("android.permission.INTERNET")) {
                    zzbsd().zzbsv().log("App is missing INTERNET permission");
                }
                if (!zzbrz().zzeo("android.permission.ACCESS_NETWORK_STATE")) {
                    zzbsd().zzbsv().log("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!zzu.zzav(getContext())) {
                    zzbsd().zzbsv().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzae.zzaw(getContext())) {
                    zzbsd().zzbsv().log("AppMeasurementService not registered/enabled");
                }
                zzbsd().zzbsv().log("Uploading is not possible. App measurement disabled");
            }
            m7977q();
            return;
        }
        zzbsd().zzbsv().log("Scheduler shutting down before Scion.start() called");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9662c(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        mo9649a(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public zzw mo9663d() {
        return this.f7371f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo9664d(AppMetadata appMetadata, long j) {
        mo9649a(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public FileChannel mo9665e() {
        return this.f7390y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo9666f() {
        zzwu();
        mo9646a();
        if (mo9676n() && mo9667g()) {
            mo9655a(mo9645a(mo9665e()), zzbrv().mo9584h());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo9667g() {
        zzwu();
        try {
            this.f7390y = new RandomAccessFile(new File(getContext().getFilesDir(), this.f7376k.mo9551i()), "rw").getChannel();
            this.f7389x = this.f7390y.tryLock();
            if (this.f7389x != null) {
                zzbsd().zzbtc().log("Storage concurrent access okay");
                return true;
            }
            zzbsd().zzbsv().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzbsd().zzbsv().zzj("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Failed to access storage lock file", e2);
        }
    }

    public Context getContext() {
        return this.f7367b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo9669h() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public long mo9670i() {
        return ((((zzyw().currentTimeMillis() + zzbse().mo9621g()) / 1000) / 60) / 60) / 24;
    }

    public boolean isEnabled() {
        boolean z = false;
        zzwu();
        mo9646a();
        if (zzbsf().zzbrd()) {
            return false;
        }
        Boolean zzbre = zzbsf().zzbre();
        if (zzbre != null) {
            z = zzbre.booleanValue();
        } else if (!zzbsf().zzaqp()) {
            z = true;
        }
        return zzbse().mo9618c(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo9672j() {
        if (zzbsf().zzabc()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo9673k() {
        if (!zzbsf().zzabc()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo9674l() {
        this.f7366B++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo9675m() {
        zzwu();
        mo9646a();
        if (!this.f7387v) {
            zzbsd().zzbta().log("This instance being marked as an uploader");
            mo9666f();
        }
        this.f7387v = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo9676n() {
        zzwu();
        mo9646a();
        return this.f7387v || mo9669h();
    }

    public byte[] zza(EventParcel eventParcel, String str) {
        long j;
        mo9646a();
        zzwu();
        mo9673k();
        zzab.zzy(eventParcel);
        zzab.zzhr(str);
        zzuh.zzd zzd = new zzuh.zzd();
        zzbry().mo9542e();
        try {
            C1909b b = zzbry().mo9532b(str);
            if (b == null) {
                zzbsd().zzbtb().zzj("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!b.mo9297n()) {
                zzbsd().zzbtb().zzj("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzbry().mo9546g();
                return bArr;
            } else {
                zzuh.zze zze = new zzuh.zze();
                zzd.ans = new zzuh.zze[]{zze};
                zze.anu = 1;
                zze.anC = "android";
                zze.zzck = b.mo9268b();
                zze.aid = b.mo9291k();
                zze.aav = b.mo9287i();
                zze.anP = Integer.valueOf((int) b.mo9289j());
                zze.anG = Long.valueOf(b.mo9293l());
                zze.aic = b.mo9274d();
                zze.anL = Long.valueOf(b.mo9295m());
                Pair a = zzbse().mo9613a(b.mo9268b());
                if (a != null && !TextUtils.isEmpty((CharSequence) a.first)) {
                    zze.anI = (String) a.first;
                    zze.anJ = (Boolean) a.second;
                }
                zze.anD = zzbrw().zztg();
                zze.zzct = zzbrw().zzbso();
                zze.anF = Integer.valueOf((int) zzbrw().zzbsp());
                zze.anE = zzbrw().zzbsq();
                zze.anK = b.mo9271c();
                zze.aik = b.mo9280f();
                List a2 = zzbry().mo9516a(b.mo9268b());
                zze.anw = new zzuh.zzg[a2.size()];
                for (int i = 0; i < a2.size(); i++) {
                    zzuh.zzg zzg = new zzuh.zzg();
                    zze.anw[i] = zzg;
                    zzg.name = ((C1888af) a2.get(i)).f7082b;
                    zzg.anW = Long.valueOf(((C1888af) a2.get(i)).f7083c);
                    zzbrz().zza(zzg, ((C1888af) a2.get(i)).f7084d);
                }
                Bundle zzbss = eventParcel.aiI.zzbss();
                if ("_iap".equals(eventParcel.name)) {
                    zzbss.putLong("_c", 1);
                }
                zzbss.putString("_o", eventParcel.aiJ);
                C1894al a3 = zzbry().mo9514a(str, eventParcel.name);
                if (a3 == null) {
                    zzbry().mo9521a(new C1894al(str, eventParcel.name, 1, 0, eventParcel.aiK));
                    j = 0;
                } else {
                    j = a3.f7096e;
                    zzbry().mo9521a(a3.mo9238a(eventParcel.aiK).mo9237a());
                }
                zzh zzh = new zzh(this, eventParcel.aiJ, str, eventParcel.name, eventParcel.aiK, j, zzbss);
                zzuh.zzb zzb = new zzuh.zzb();
                zze.anv = new zzuh.zzb[]{zzb};
                zzb.ano = Long.valueOf(zzh.f7283d);
                zzb.name = zzh.f7281b;
                zzb.anp = Long.valueOf(zzh.f7284e);
                zzb.ann = new zzuh.zzc[zzh.f7285f.size()];
                Iterator it = zzh.f7285f.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    zzuh.zzc zzc = new zzuh.zzc();
                    zzb.ann[i2] = zzc;
                    zzc.name = str2;
                    zzbrz().zza(zzc, zzh.f7285f.mo9201a(str2));
                    i2++;
                }
                zze.anO = m7972a(b.mo9268b(), zze.anw, zze.anv);
                zze.any = zzb.ano;
                zze.anz = zzb.ano;
                long h = b.mo9285h();
                zze.anB = h != 0 ? Long.valueOf(h) : null;
                long g = b.mo9283g();
                if (g != 0) {
                    h = g;
                }
                zze.anA = h != 0 ? Long.valueOf(h) : null;
                b.mo9301r();
                zze.anM = Integer.valueOf((int) b.mo9298o());
                zze.anH = Long.valueOf(zzbsf().zzbpz());
                zze.anx = Long.valueOf(zzyw().currentTimeMillis());
                zze.anN = Boolean.TRUE;
                b.mo9265a(zze.any.longValue());
                b.mo9269b(zze.anz.longValue());
                zzbry().mo9522a(b);
                zzbry().mo9545f();
                zzbry().mo9546g();
                try {
                    byte[] bArr2 = new byte[zzd.mo8049aM()];
                    zzapo zzbe = zzapo.zzbe(bArr2);
                    zzd.zza(zzbe);
                    zzbe.mo7988az();
                    return zzbrz().zzj(bArr2);
                } catch (IOException e) {
                    zzbsd().zzbsv().zzj("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            }
        } finally {
            zzbry().mo9546g();
        }
    }

    public void zzas(boolean z) {
        m7977q();
    }

    public C1889ag zzbrt() {
        m7974b((C1923c) this.f7385t);
        return this.f7385t;
    }

    public zzac zzbru() {
        m7974b((C1923c) this.f7381p);
        return this.f7381p;
    }

    public zzn zzbrv() {
        m7974b((C1923c) this.f7382q);
        return this.f7382q;
    }

    public zzg zzbrw() {
        m7974b((C1923c) this.f7380o);
        return this.f7380o;
    }

    public zzad zzbrx() {
        m7974b((C1923c) this.f7379n);
        return this.f7379n;
    }

    public zze zzbry() {
        m7974b((C1923c) this.f7376k);
        return this.f7376k;
    }

    public zzal zzbrz() {
        m7968a((C1922bm) this.f7375j);
        return this.f7375j;
    }

    public zzv zzbsa() {
        m7974b((C1923c) this.f7373h);
        return this.f7373h;
    }

    public zzaf zzbsb() {
        m7974b((C1923c) this.f7372g);
        return this.f7372g;
    }

    public zzw zzbsc() {
        m7974b((C1923c) this.f7371f);
        return this.f7371f;
    }

    public zzp zzbsd() {
        m7974b((C1923c) this.f7370e);
        return this.f7370e;
    }

    public zzt zzbse() {
        m7968a((C1922bm) this.f7369d);
        return this.f7369d;
    }

    public zzd zzbsf() {
        return this.f7368c;
    }

    public zzp zzbtp() {
        if (this.f7370e == null || !this.f7370e.mo9337a()) {
            return null;
        }
        return this.f7370e;
    }

    public AppMeasurement zzbtr() {
        return this.f7374i;
    }

    public zzq zzbts() {
        m7974b((C1923c) this.f7377l);
        return this.f7377l;
    }

    public C1901as zzbtt() {
        if (this.f7383r != null) {
            return this.f7383r;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public zzai zzbtu() {
        m7974b((C1923c) this.f7384s);
        return this.f7384s;
    }

    public void zzbuc() {
        C1909b b;
        String str;
        List list;
        C0136a aVar = null;
        zzwu();
        mo9646a();
        if (!zzbsf().zzabc()) {
            Boolean i = zzbse().mo9623i();
            if (i == null) {
                zzbsd().zzbsx().log("Upload data called on the client side before use of service was decided");
                return;
            } else if (i.booleanValue()) {
                zzbsd().zzbsv().log("Upload called in the client side when service should be used");
                return;
            }
        }
        if (m7975o()) {
            zzbsd().zzbsx().log("Uploading requested multiple times");
        } else if (!zzbts().zzadj()) {
            zzbsd().zzbsx().log("Network not connected, ignoring upload request");
            m7977q();
        } else {
            long currentTimeMillis = zzyw().currentTimeMillis();
            mo9657a(currentTimeMillis - zzbsf().zzbrl());
            long j = zzbse().f7315c.get();
            if (j != 0) {
                zzbsd().zzbtb().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
            }
            String j2 = zzbry().mo9552j();
            if (!TextUtils.isEmpty(j2)) {
                List a = zzbry().mo9517a(j2, zzbsf().zzlj(j2), zzbsf().zzlk(j2));
                if (!a.isEmpty()) {
                    Iterator it = a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        zzuh.zze zze = (zzuh.zze) ((Pair) it.next()).first;
                        if (!TextUtils.isEmpty(zze.anI)) {
                            str = zze.anI;
                            break;
                        }
                    }
                    if (str != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= a.size()) {
                                break;
                            }
                            zzuh.zze zze2 = (zzuh.zze) ((Pair) a.get(i2)).first;
                            if (!TextUtils.isEmpty(zze2.anI) && !zze2.anI.equals(str)) {
                                list = a.subList(0, i2);
                                break;
                            }
                            i2++;
                        }
                    }
                    list = a;
                    zzuh.zzd zzd = new zzuh.zzd();
                    zzd.ans = new zzuh.zze[list.size()];
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int i3 = 0; i3 < zzd.ans.length; i3++) {
                        zzd.ans[i3] = (zzuh.zze) ((Pair) list.get(i3)).first;
                        arrayList.add((Long) ((Pair) list.get(i3)).second);
                        zzd.ans[i3].anH = Long.valueOf(zzbsf().zzbpz());
                        zzd.ans[i3].anx = Long.valueOf(currentTimeMillis);
                        zzd.ans[i3].anN = Boolean.valueOf(zzbsf().zzabc());
                    }
                    String zzb = zzbsd().mo9592a(2) ? zzal.zzb(zzd) : null;
                    byte[] zza = zzbrz().zza(zzd);
                    String zzbrk = zzbsf().zzbrk();
                    try {
                        URL url = new URL(zzbrk);
                        m7970a((List) arrayList);
                        zzbse().f7316d.set(currentTimeMillis);
                        String str2 = "?";
                        if (zzd.ans.length > 0) {
                            str2 = zzd.ans[0].zzck;
                        }
                        zzbsd().zzbtc().zzd("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zza.length), zzb);
                        zzbts().zza(j2, url, zza, (Map) null, new C1911bb(this));
                    } catch (MalformedURLException e) {
                        zzbsd().zzbsv().zzj("Failed to parse upload URL. Not uploading", zzbrk);
                    }
                }
            } else {
                String b2 = zzbry().mo9534b(currentTimeMillis - zzbsf().zzbrl());
                if (!TextUtils.isEmpty(b2) && (b = zzbry().mo9532b(b2)) != null) {
                    String zzap = zzbsf().zzap(b.mo9274d(), b.mo9271c());
                    try {
                        URL url2 = new URL(zzap);
                        zzbsd().zzbtc().zzj("Fetching remote configuration", b.mo9268b());
                        zzug.zzb a2 = zzbsa().mo9634a(b.mo9268b());
                        String b3 = zzbsa().mo9637b(b.mo9268b());
                        if (a2 != null && !TextUtils.isEmpty(b3)) {
                            aVar = new C0136a();
                            aVar.put("If-Modified-Since", b3);
                        }
                        zzbts().zza(b2, url2, aVar, new C1912bc(this));
                    } catch (MalformedURLException e2) {
                        zzbsd().zzbsv().zzj("Failed to parse config URL. Not fetching", zzap);
                    }
                }
            }
        }
    }

    public void zzd(AppMetadata appMetadata) {
        zzwu();
        mo9646a();
        zzab.zzy(appMetadata);
        zzab.zzhr(appMetadata.packageName);
        if (!TextUtils.isEmpty(appMetadata.aic)) {
            if (!appMetadata.aih) {
                m7973b(appMetadata);
                return;
            }
            long currentTimeMillis = zzyw().currentTimeMillis();
            zzbry().mo9542e();
            try {
                mo9648a(appMetadata, currentTimeMillis);
                m7973b(appMetadata);
                if (zzbry().mo9514a(appMetadata.packageName, "_f") == null) {
                    mo9651a(new UserAttributeParcel("_fot", currentTimeMillis, Long.valueOf((1 + (currentTimeMillis / 3600000)) * 3600000), "auto"), appMetadata);
                    mo9658b(appMetadata, currentTimeMillis);
                    mo9662c(appMetadata, currentTimeMillis);
                } else if (appMetadata.aii) {
                    mo9664d(appMetadata, currentTimeMillis);
                }
                zzbry().mo9545f();
            } finally {
                zzbry().mo9546g();
            }
        }
    }

    public void zzwu() {
        zzbsc().zzwu();
    }

    public zze zzyw() {
        return this.f7378m;
    }
}
