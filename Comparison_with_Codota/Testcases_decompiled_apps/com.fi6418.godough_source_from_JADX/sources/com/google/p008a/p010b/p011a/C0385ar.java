package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.util.Locale;
import java.util.StringTokenizer;

/* renamed from: com.google.a.b.a.ar */
final class C0385ar extends C0363al<Locale> {
    C0385ar() {
    }

    /* renamed from: a */
    public Locale mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(aVar.mo6383h(), "_");
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Locale locale) {
        dVar.mo6400b(locale == null ? null : locale.toString());
    }
}
