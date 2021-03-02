package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqz;

public final class zzl {
    public static zza aiL = zza.m7893a("measurement.service_enabled", true);
    public static zza aiM = zza.m7893a("measurement.service_client_enabled", true);
    public static zza aiN = zza.m7892a("measurement.log_tag", "FA", "FA-SVC");
    public static zza aiO = zza.m7889a("measurement.ad_id_cache_time", 10000);
    public static zza aiP = zza.m7889a("measurement.monitoring.sample_period_millis", 86400000);
    public static zza aiQ = zza.m7890a("measurement.config.cache_time", 86400000, 3600000);
    public static zza aiR = zza.m7891a("measurement.config.url_scheme", "https");
    public static zza aiS = zza.m7891a("measurement.config.url_authority", "app-measurement.com");
    public static zza aiT = zza.m7887a("measurement.upload.max_bundles", 100);
    public static zza aiU = zza.m7887a("measurement.upload.max_batch_size", 65536);
    public static zza aiV = zza.m7887a("measurement.upload.max_bundle_size", 65536);
    public static zza aiW = zza.m7887a("measurement.upload.max_events_per_bundle", 1000);
    public static zza aiX = zza.m7887a("measurement.upload.max_events_per_day", 100000);
    public static zza aiY = zza.m7887a("measurement.upload.max_public_events_per_day", 50000);
    public static zza aiZ = zza.m7887a("measurement.upload.max_conversions_per_day", 500);
    public static zza aja = zza.m7887a("measurement.store.max_stored_events_per_app", 100000);
    public static zza ajb = zza.m7891a("measurement.upload.url", "https://app-measurement.com/a");
    public static zza ajc = zza.m7889a("measurement.upload.backoff_period", 43200000);
    public static zza ajd = zza.m7889a("measurement.upload.window_interval", 3600000);
    public static zza aje = zza.m7889a("measurement.upload.interval", 3600000);
    public static zza ajf = zza.m7889a("measurement.upload.stale_data_deletion_interval", 86400000);
    public static zza ajg = zza.m7889a("measurement.upload.initial_upload_delay_time", 15000);
    public static zza ajh = zza.m7889a("measurement.upload.retry_time", 1800000);
    public static zza aji = zza.m7887a("measurement.upload.retry_count", 6);
    public static zza ajj = zza.m7889a("measurement.upload.max_queue_time", 2419200000L);
    public static zza ajk = zza.m7887a("measurement.lifetimevalue.max_currency_tracked", 4);
    public static zza ajl = zza.m7889a("measurement.service_client.idle_disconnect_millis", 5000);

    public final class zza {

        /* renamed from: a */
        private final Object f7286a;

        /* renamed from: b */
        private final zzqz f7287b;

        /* renamed from: c */
        private final String f7288c;

        private zza(String str, zzqz zzqz, Object obj) {
            zzab.zzy(zzqz);
            this.f7287b = zzqz;
            this.f7286a = obj;
            this.f7288c = str;
        }

        /* renamed from: a */
        static zza m7887a(String str, int i) {
            return m7888a(str, i, i);
        }

        /* renamed from: a */
        static zza m7888a(String str, int i, int i2) {
            return new zza(str, zzqz.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        /* renamed from: a */
        static zza m7889a(String str, long j) {
            return m7890a(str, j, j);
        }

        /* renamed from: a */
        static zza m7890a(String str, long j, long j2) {
            return new zza(str, zzqz.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        /* renamed from: a */
        static zza m7891a(String str, String str2) {
            return m7892a(str, str2, str2);
        }

        /* renamed from: a */
        static zza m7892a(String str, String str2, String str3) {
            return new zza(str, zzqz.zzab(str, str3), str2);
        }

        /* renamed from: a */
        static zza m7893a(String str, boolean z) {
            return m7894a(str, z, z);
        }

        /* renamed from: a */
        static zza m7894a(String str, boolean z, boolean z2) {
            return new zza(str, zzqz.zzm(str, z2), Boolean.valueOf(z));
        }

        public Object get() {
            return this.f7286a;
        }

        public Object get(Object obj) {
            return obj != null ? obj : this.f7286a;
        }

        public String getKey() {
            return this.f7288c;
        }
    }
}
