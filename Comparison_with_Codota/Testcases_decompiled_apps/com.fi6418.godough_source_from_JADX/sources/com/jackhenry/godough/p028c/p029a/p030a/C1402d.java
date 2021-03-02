package com.jackhenry.godough.p028c.p029a.p030a;

import com.jackhenry.godough.p027b.C1391f;
import java.io.UnsupportedEncodingException;

/* renamed from: com.jackhenry.godough.c.a.a.d */
public class C1402d implements C1401c {
    /* renamed from: a */
    public Object mo9450a(Object obj) {
        return obj;
    }

    /* renamed from: a */
    public Object mo9445a(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new C1391f("Failed to read response", (Throwable) e);
        }
    }
}
