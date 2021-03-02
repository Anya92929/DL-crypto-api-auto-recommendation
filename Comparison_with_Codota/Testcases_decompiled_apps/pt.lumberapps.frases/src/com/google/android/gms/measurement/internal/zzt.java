package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.zzab;
import com.google.firebase.iid.C1984f;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

class zzt extends C1923c {

    /* renamed from: a */
    static final Pair f7313a = new Pair("", 0L);

    /* renamed from: b */
    public final zzc f7314b = new zzc("health_monitor", zzbsf().zzaci());

    /* renamed from: c */
    public final zzb f7315c = new zzb("last_upload", 0);

    /* renamed from: d */
    public final zzb f7316d = new zzb("last_upload_attempt", 0);

    /* renamed from: e */
    public final zzb f7317e = new zzb("backoff", 0);

    /* renamed from: f */
    public final zzb f7318f = new zzb("last_delete_stale", 0);

    /* renamed from: g */
    public final zzb f7319g = new zzb("midnight_offset", 0);

    /* renamed from: h */
    public final zzb f7320h = new zzb("time_before_start", 10000);

    /* renamed from: i */
    public final zzb f7321i = new zzb("session_timeout", 1800000);

    /* renamed from: j */
    public final zza f7322j = new zza("start_new_session", true);

    /* renamed from: k */
    public final zzb f7323k = new zzb("last_pause_time", 0);

    /* renamed from: l */
    public final zzb f7324l = new zzb("time_active", 0);

    /* renamed from: m */
    public boolean f7325m;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public SharedPreferences f7326o;

    /* renamed from: p */
    private String f7327p;

    /* renamed from: q */
    private boolean f7328q;

    /* renamed from: r */
    private long f7329r;

    /* renamed from: s */
    private SecureRandom f7330s;

    public final class zza {

        /* renamed from: b */
        private final String f7332b;

        /* renamed from: c */
        private final boolean f7333c;

        /* renamed from: d */
        private boolean f7334d;

        /* renamed from: e */
        private boolean f7335e;

        public zza(String str, boolean z) {
            zzab.zzhr(str);
            this.f7332b = str;
            this.f7333c = z;
        }

        /* renamed from: a */
        private void m7939a() {
            if (!this.f7334d) {
                this.f7334d = true;
                this.f7335e = zzt.this.f7326o.getBoolean(this.f7332b, this.f7333c);
            }
        }

        public boolean get() {
            m7939a();
            return this.f7335e;
        }

        public void set(boolean z) {
            SharedPreferences.Editor edit = zzt.this.f7326o.edit();
            edit.putBoolean(this.f7332b, z);
            edit.apply();
            this.f7335e = z;
        }
    }

    public final class zzb {

        /* renamed from: b */
        private final String f7337b;

        /* renamed from: c */
        private final long f7338c;

        /* renamed from: d */
        private boolean f7339d;

        /* renamed from: e */
        private long f7340e;

        public zzb(String str, long j) {
            zzab.zzhr(str);
            this.f7337b = str;
            this.f7338c = j;
        }

        /* renamed from: a */
        private void m7940a() {
            if (!this.f7339d) {
                this.f7339d = true;
                this.f7340e = zzt.this.f7326o.getLong(this.f7337b, this.f7338c);
            }
        }

        public long get() {
            m7940a();
            return this.f7340e;
        }

        public void set(long j) {
            SharedPreferences.Editor edit = zzt.this.f7326o.edit();
            edit.putLong(this.f7337b, j);
            edit.apply();
            this.f7340e = j;
        }
    }

    public final class zzc {

        /* renamed from: a */
        final String f7341a;

        /* renamed from: c */
        private final String f7343c;

        /* renamed from: d */
        private final String f7344d;

        /* renamed from: e */
        private final long f7345e;

        private zzc(String str, long j) {
            zzab.zzhr(str);
            zzab.zzbo(j > 0);
            this.f7341a = String.valueOf(str).concat(":start");
            this.f7343c = String.valueOf(str).concat(":count");
            this.f7344d = String.valueOf(str).concat(":value");
            this.f7345e = j;
        }

        /* renamed from: a */
        private void m7941a() {
            zzt.this.zzwu();
            long currentTimeMillis = zzt.this.zzyw().currentTimeMillis();
            SharedPreferences.Editor edit = zzt.this.f7326o.edit();
            edit.remove(this.f7343c);
            edit.remove(this.f7344d);
            edit.putLong(this.f7341a, currentTimeMillis);
            edit.apply();
        }

        /* renamed from: b */
        private long m7942b() {
            zzt.this.zzwu();
            long c = m7943c();
            if (c != 0) {
                return Math.abs(c - zzt.this.zzyw().currentTimeMillis());
            }
            m7941a();
            return 0;
        }

        /* renamed from: c */
        private long m7943c() {
            return zzt.this.m7924m().getLong(this.f7341a, 0);
        }

        public Pair zzadv() {
            zzt.this.zzwu();
            long b = m7942b();
            if (b < this.f7345e) {
                return null;
            }
            if (b > this.f7345e * 2) {
                m7941a();
                return null;
            }
            String string = zzt.this.m7924m().getString(this.f7344d, (String) null);
            long j = zzt.this.m7924m().getLong(this.f7343c, 0);
            m7941a();
            return (string == null || j <= 0) ? zzt.f7313a : new Pair(string, Long.valueOf(j));
        }

        public void zzev(String str) {
            zzh(str, 1);
        }

        public void zzh(String str, long j) {
            zzt.this.zzwu();
            if (m7943c() == 0) {
                m7941a();
            }
            if (str == null) {
                str = "";
            }
            long j2 = zzt.this.f7326o.getLong(this.f7343c, 0);
            if (j2 <= 0) {
                SharedPreferences.Editor edit = zzt.this.f7326o.edit();
                edit.putString(this.f7344d, str);
                edit.putLong(this.f7343c, j);
                edit.apply();
                return;
            }
            boolean z = (zzt.this.m7923l().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j;
            SharedPreferences.Editor edit2 = zzt.this.f7326o.edit();
            if (z) {
                edit2.putString(this.f7344d, str);
            }
            edit2.putLong(this.f7343c, j2 + j);
            edit2.apply();
        }
    }

    zzt(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public SecureRandom m7923l() {
        zzwu();
        if (this.f7330s == null) {
            this.f7330s = new SecureRandom();
        }
        return this.f7330s;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public SharedPreferences m7924m() {
        zzwu();
        mo9339c();
        return this.f7326o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Pair mo9613a(String str) {
        zzwu();
        long elapsedRealtime = zzyw().elapsedRealtime();
        if (this.f7327p != null && elapsedRealtime < this.f7329r) {
            return new Pair(this.f7327p, Boolean.valueOf(this.f7328q));
        }
        this.f7329r = elapsedRealtime + zzbsf().mo9464a(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            this.f7327p = advertisingIdInfo.getId();
            if (this.f7327p == null) {
                this.f7327p = "";
            }
            this.f7328q = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            zzbsd().zzbtb().zzj("Unable to get advertising id", th);
            this.f7327p = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.f7327p, Boolean.valueOf(this.f7328q));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9614a(boolean z) {
        zzwu();
        zzbsd().zzbtc().zzj("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = m7924m().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo9615b(String str) {
        String str2 = (String) mo9613a(str).first;
        MessageDigest c = zzal.m7805c("MD5");
        if (c == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, c.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9616b(boolean z) {
        zzwu();
        zzbsd().zzbtc().zzj("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = m7924m().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo9617c(String str) {
        zzwu();
        SharedPreferences.Editor edit = m7924m().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo9618c(boolean z) {
        zzwu();
        return m7924m().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo9226d() {
        this.f7326o = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f7325m = this.f7326o.getBoolean("has_been_opened", false);
        if (!this.f7325m) {
            SharedPreferences.Editor edit = this.f7326o.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo9619e() {
        byte[] bArr = new byte[16];
        m7923l().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo9620f() {
        zzwu();
        return C1984f.m8143a().mo9877b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public long mo9621g() {
        mo9339c();
        zzwu();
        long j = this.f7319g.get();
        if (j != 0) {
            return j;
        }
        long nextInt = (long) (m7923l().nextInt(86400000) + 1);
        this.f7319g.set(nextInt);
        return nextInt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo9622h() {
        zzwu();
        return m7924m().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public Boolean mo9623i() {
        zzwu();
        if (!m7924m().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(m7924m().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo9624j() {
        boolean z = true;
        zzwu();
        zzbsd().zzbtc().log("Clearing collection preferences.");
        boolean contains = m7924m().contains("measurement_enabled");
        if (contains) {
            z = mo9618c(true);
        }
        SharedPreferences.Editor edit = m7924m().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            mo9616b(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String mo9625k() {
        zzwu();
        String string = m7924m().getString("previous_os_version", (String) null);
        String zzbso = zzbrw().zzbso();
        if (!TextUtils.isEmpty(zzbso) && !zzbso.equals(string)) {
            SharedPreferences.Editor edit = m7924m().edit();
            edit.putString("previous_os_version", zzbso);
            edit.apply();
        }
        return string;
    }
}
