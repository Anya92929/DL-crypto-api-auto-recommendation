package com.google.p019b.p020a;

import java.util.regex.Pattern;

/* renamed from: com.google.b.a.i */
public class C1344i {

    /* renamed from: a */
    private C1345j<String, Pattern> f5545a;

    public C1344i(int i) {
        this.f5545a = new C1345j<>(i);
    }

    /* renamed from: a */
    public Pattern mo9256a(String str) {
        Pattern a = this.f5545a.mo9257a(str);
        if (a != null) {
            return a;
        }
        Pattern compile = Pattern.compile(str);
        this.f5545a.mo9258a(str, compile);
        return compile;
    }
}
