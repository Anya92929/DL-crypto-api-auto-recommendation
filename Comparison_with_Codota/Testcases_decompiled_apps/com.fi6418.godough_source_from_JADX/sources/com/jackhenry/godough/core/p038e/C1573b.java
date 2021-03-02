package com.jackhenry.godough.core.p038e;

/* renamed from: com.jackhenry.godough.core.e.b */
public class C1573b {
    /* renamed from: a */
    public static String m6140a(Throwable th) {
        return th.getCause() != null ? m6140a(th.getCause()) : th.getMessage();
    }
}
