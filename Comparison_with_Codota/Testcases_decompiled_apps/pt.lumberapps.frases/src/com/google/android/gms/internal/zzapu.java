package com.google.android.gms.internal;

import java.io.IOException;

public class zzapu extends IOException {
    public zzapu(String str) {
        super(str);
    }

    /* renamed from: a */
    static zzapu m6818a() {
        return new zzapu("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static zzapu m6819b() {
        return new zzapu("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static zzapu m6820c() {
        return new zzapu("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static zzapu m6821d() {
        return new zzapu("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static zzapu m6822e() {
        return new zzapu("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static zzapu m6823f() {
        return new zzapu("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static zzapu m6824g() {
        return new zzapu("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
