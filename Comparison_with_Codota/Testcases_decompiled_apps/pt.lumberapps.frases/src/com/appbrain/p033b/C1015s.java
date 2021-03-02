package com.appbrain.p033b;

import java.io.IOException;

/* renamed from: com.appbrain.b.s */
public final class C1015s extends IOException {

    /* renamed from: a */
    private C1020x f2664a = null;

    public C1015s(String str) {
        super(str);
    }

    /* renamed from: a */
    static C1015s m4249a() {
        return new C1015s("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static C1015s m4250b() {
        return new C1015s("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static C1015s m4251c() {
        return new C1015s("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static C1015s m4252d() {
        return new C1015s("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static C1015s m4253e() {
        return new C1015s("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static C1015s m4254f() {
        return new C1015s("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static C1015s m4255g() {
        return new C1015s("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* renamed from: h */
    static C1015s m4256h() {
        return new C1015s("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* renamed from: a */
    public final C1015s mo4010a(C1020x xVar) {
        this.f2664a = xVar;
        return this;
    }
}
