package com.google.p008a.p010b;

import com.google.p008a.C0356ae;
import com.google.p008a.C0493w;
import com.google.p008a.C0494x;
import com.google.p008a.C0495y;
import com.google.p008a.p010b.p011a.C0426z;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;
import com.google.p008a.p013d.C0474e;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.google.a.b.ag */
public final class C0433ag {
    /* renamed from: a */
    public static C0493w m2721a(C0470a aVar) {
        boolean z = true;
        try {
            aVar.mo6381f();
            z = false;
            return C0426z.f3462P.mo6310b(aVar);
        } catch (EOFException e) {
            if (z) {
                return C0495y.f3650a;
            }
            throw new C0356ae((Throwable) e);
        } catch (C0474e e2) {
            throw new C0356ae((Throwable) e2);
        } catch (IOException e3) {
            throw new C0494x((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new C0356ae((Throwable) e4);
        }
    }

    /* renamed from: a */
    public static Writer m2722a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C0435ai(appendable);
    }

    /* renamed from: a */
    public static void m2723a(C0493w wVar, C0473d dVar) {
        C0426z.f3462P.mo6309a(dVar, wVar);
    }
}
