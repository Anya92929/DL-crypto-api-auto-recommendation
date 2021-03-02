package p000;

import android.content.Intent;
import java.io.IOException;

/* renamed from: io */
public final class C1281io {

    /* renamed from: a */
    private final IOException f4489a;

    /* renamed from: b */
    private final Intent f4490b;

    public C1281io(IOException iOException, Intent intent) {
        this.f4489a = iOException;
        this.f4490b = intent;
    }

    /* renamed from: a */
    public IOException mo8628a() {
        return this.f4489a;
    }

    /* renamed from: b */
    public Intent mo8629b() {
        return this.f4490b;
    }

    /* renamed from: c */
    public boolean mo8630c() {
        return this.f4489a != null;
    }
}
