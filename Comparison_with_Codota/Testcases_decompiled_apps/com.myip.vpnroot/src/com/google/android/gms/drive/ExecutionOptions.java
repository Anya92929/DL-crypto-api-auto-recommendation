package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0452q;

public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;

    /* renamed from: Nf */
    private final String f821Nf;

    /* renamed from: Ng */
    private final boolean f822Ng;

    /* renamed from: Nh */
    private final int f823Nh;

    public static final class Builder {

        /* renamed from: Nf */
        private String f824Nf;

        /* renamed from: Ng */
        private boolean f825Ng;

        /* renamed from: Nh */
        private int f826Nh = 0;

        public ExecutionOptions build() {
            if (this.f826Nh != 1 || this.f825Ng) {
                return new ExecutionOptions(this.f824Nf, this.f825Ng, this.f826Nh);
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public Builder setConflictStrategy(int strategy) {
            if (!ExecutionOptions.m962aW(strategy)) {
                throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + strategy);
            }
            this.f826Nh = strategy;
            return this;
        }

        public Builder setNotifyOnCompletion(boolean notify) {
            this.f825Ng = notify;
            return this;
        }

        public Builder setTrackingTag(String trackingTag) {
            if (!ExecutionOptions.m963bh(trackingTag)) {
                throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[]{65536}));
            }
            this.f824Nf = trackingTag;
            return this;
        }
    }

    private ExecutionOptions(String trackingTag, boolean notifyOnCompletion, int conflictStrategy) {
        this.f821Nf = trackingTag;
        this.f822Ng = notifyOnCompletion;
        this.f823Nh = conflictStrategy;
    }

    /* renamed from: a */
    public static void m960a(GoogleApiClient googleApiClient, ExecutionOptions executionOptions) {
        C0452q qVar = (C0452q) googleApiClient.mo4218a(Drive.f807CU);
        if (executionOptions.mo4639hP() && !qVar.mo5077ib()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    /* renamed from: aV */
    public static boolean m961aV(int i) {
        switch (i) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: aW */
    public static boolean m962aW(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: bh */
    public static boolean m963bh(String str) {
        return str != null && !str.isEmpty() && str.length() <= 65536;
    }

    /* renamed from: hO */
    public String mo4638hO() {
        return this.f821Nf;
    }

    /* renamed from: hP */
    public boolean mo4639hP() {
        return this.f822Ng;
    }

    /* renamed from: hQ */
    public int mo4640hQ() {
        return this.f823Nh;
    }
}
