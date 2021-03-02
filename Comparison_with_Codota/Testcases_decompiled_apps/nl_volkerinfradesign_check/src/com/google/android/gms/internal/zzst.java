package com.google.android.gms.internal;

import java.io.IOException;

public class zzst extends IOException {
    public zzst(String str) {
        super(str);
    }

    /* renamed from: a */
    static zzst m4101a() {
        return new zzst("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static zzst m4102b() {
        return new zzst("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static zzst m4103c() {
        return new zzst("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static zzst m4104d() {
        return new zzst("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static zzst m4105e() {
        return new zzst("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static zzst m4106f() {
        return new zzst("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static zzst m4107g() {
        return new zzst("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
