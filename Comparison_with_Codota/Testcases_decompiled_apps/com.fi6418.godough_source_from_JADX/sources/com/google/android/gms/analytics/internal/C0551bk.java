package com.google.android.gms.analytics.internal;

/* renamed from: com.google.android.gms.analytics.internal.bk */
public final class C0551bk {

    /* renamed from: A */
    public static C0552bl<Integer> f3800A = C0552bl.m3210a("analytics.max_batch_post_length", 8192);

    /* renamed from: B */
    public static C0552bl<String> f3801B = C0552bl.m3214a("analytics.fallback_responses.k", "404,502");

    /* renamed from: C */
    public static C0552bl<Integer> f3802C = C0552bl.m3210a("analytics.batch_retry_interval.seconds.k", 3600);

    /* renamed from: D */
    public static C0552bl<Long> f3803D = C0552bl.m3212a("analytics.service_monitor_interval", 86400000);

    /* renamed from: E */
    public static C0552bl<Integer> f3804E = C0552bl.m3210a("analytics.http_connection.connect_timeout_millis", 60000);

    /* renamed from: F */
    public static C0552bl<Integer> f3805F = C0552bl.m3210a("analytics.http_connection.read_timeout_millis", 61000);

    /* renamed from: G */
    public static C0552bl<Long> f3806G = C0552bl.m3212a("analytics.campaigns.time_limit", 86400000);

    /* renamed from: H */
    public static C0552bl<String> f3807H = C0552bl.m3214a("analytics.first_party_experiment_id", "");

    /* renamed from: I */
    public static C0552bl<Integer> f3808I = C0552bl.m3210a("analytics.first_party_experiment_variant", 0);

    /* renamed from: J */
    public static C0552bl<Boolean> f3809J = C0552bl.m3216a("analytics.test.disable_receiver", false);

    /* renamed from: K */
    public static C0552bl<Long> f3810K = C0552bl.m3213a("analytics.service_client.idle_disconnect_millis", 10000, 10000);

    /* renamed from: L */
    public static C0552bl<Long> f3811L = C0552bl.m3212a("analytics.service_client.connect_timeout_millis", 5000);

    /* renamed from: M */
    public static C0552bl<Long> f3812M = C0552bl.m3212a("analytics.service_client.second_connect_delay_millis", 5000);

    /* renamed from: N */
    public static C0552bl<Long> f3813N = C0552bl.m3212a("analytics.service_client.unexpected_reconnect_millis", 60000);

    /* renamed from: O */
    public static C0552bl<Long> f3814O = C0552bl.m3212a("analytics.service_client.reconnect_throttle_millis", 1800000);

    /* renamed from: P */
    public static C0552bl<Long> f3815P = C0552bl.m3212a("analytics.monitoring.sample_period_millis", 86400000);

    /* renamed from: Q */
    public static C0552bl<Long> f3816Q = C0552bl.m3212a("analytics.initialization_warning_threshold", 5000);

    /* renamed from: a */
    public static C0552bl<Boolean> f3817a = C0552bl.m3216a("analytics.service_enabled", false);

    /* renamed from: b */
    public static C0552bl<Boolean> f3818b = C0552bl.m3216a("analytics.service_client_enabled", true);

    /* renamed from: c */
    public static C0552bl<String> f3819c = C0552bl.m3215a("analytics.log_tag", "GAv4", "GAv4-SVC");

    /* renamed from: d */
    public static C0552bl<Long> f3820d = C0552bl.m3212a("analytics.max_tokens", 60);

    /* renamed from: e */
    public static C0552bl<Float> f3821e = C0552bl.m3208a("analytics.tokens_per_sec", 0.5f);

    /* renamed from: f */
    public static C0552bl<Integer> f3822f = C0552bl.m3211a("analytics.max_stored_hits", 2000, 20000);

    /* renamed from: g */
    public static C0552bl<Integer> f3823g = C0552bl.m3210a("analytics.max_stored_hits_per_app", 2000);

    /* renamed from: h */
    public static C0552bl<Integer> f3824h = C0552bl.m3210a("analytics.max_stored_properties_per_app", 100);

    /* renamed from: i */
    public static C0552bl<Long> f3825i = C0552bl.m3213a("analytics.local_dispatch_millis", 1800000, 120000);

    /* renamed from: j */
    public static C0552bl<Long> f3826j = C0552bl.m3213a("analytics.initial_local_dispatch_millis", 5000, 5000);

    /* renamed from: k */
    public static C0552bl<Long> f3827k = C0552bl.m3212a("analytics.min_local_dispatch_millis", 120000);

    /* renamed from: l */
    public static C0552bl<Long> f3828l = C0552bl.m3212a("analytics.max_local_dispatch_millis", 7200000);

    /* renamed from: m */
    public static C0552bl<Long> f3829m = C0552bl.m3212a("analytics.dispatch_alarm_millis", 7200000);

    /* renamed from: n */
    public static C0552bl<Long> f3830n = C0552bl.m3212a("analytics.max_dispatch_alarm_millis", 32400000);

    /* renamed from: o */
    public static C0552bl<Integer> f3831o = C0552bl.m3210a("analytics.max_hits_per_dispatch", 20);

    /* renamed from: p */
    public static C0552bl<Integer> f3832p = C0552bl.m3210a("analytics.max_hits_per_batch", 20);

    /* renamed from: q */
    public static C0552bl<String> f3833q = C0552bl.m3214a("analytics.insecure_host", "http://www.google-analytics.com");

    /* renamed from: r */
    public static C0552bl<String> f3834r = C0552bl.m3214a("analytics.secure_host", "https://ssl.google-analytics.com");

    /* renamed from: s */
    public static C0552bl<String> f3835s = C0552bl.m3214a("analytics.simple_endpoint", "/collect");

    /* renamed from: t */
    public static C0552bl<String> f3836t = C0552bl.m3214a("analytics.batching_endpoint", "/batch");

    /* renamed from: u */
    public static C0552bl<Integer> f3837u = C0552bl.m3210a("analytics.max_get_length", 2036);

    /* renamed from: v */
    public static C0552bl<String> f3838v = C0552bl.m3215a("analytics.batching_strategy.k", C0534au.BATCH_BY_COUNT.name(), C0534au.BATCH_BY_COUNT.name());

    /* renamed from: w */
    public static C0552bl<String> f3839w = C0552bl.m3214a("analytics.compression_strategy.k", C0538ay.GZIP.name());

    /* renamed from: x */
    public static C0552bl<Integer> f3840x = C0552bl.m3210a("analytics.max_hits_per_request.k", 20);

    /* renamed from: y */
    public static C0552bl<Integer> f3841y = C0552bl.m3210a("analytics.max_hit_length.k", 8192);

    /* renamed from: z */
    public static C0552bl<Integer> f3842z = C0552bl.m3210a("analytics.max_post_length.k", 8192);
}
