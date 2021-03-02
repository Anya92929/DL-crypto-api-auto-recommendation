package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.pl */
public class C1717pl extends IOException {
    public C1717pl(String str) {
        super(str);
    }

    /* renamed from: qA */
    static C1717pl m6082qA() {
        return new C1717pl("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: qB */
    static C1717pl m6083qB() {
        return new C1717pl("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: qC */
    static C1717pl m6084qC() {
        return new C1717pl("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: qD */
    static C1717pl m6085qD() {
        return new C1717pl("Protocol message tag had invalid wire type.");
    }

    /* renamed from: qE */
    static C1717pl m6086qE() {
        return new C1717pl("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: qy */
    static C1717pl m6087qy() {
        return new C1717pl("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: qz */
    static C1717pl m6088qz() {
        return new C1717pl("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
