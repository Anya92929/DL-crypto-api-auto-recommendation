package p000;

import com.google.gson.JsonArray;

/* renamed from: ig */
public final class C1252ig {

    /* renamed from: a */
    public final boolean f4392a;

    /* renamed from: b */
    public final boolean f4393b;

    /* renamed from: c */
    public final JsonArray f4394c;

    /* renamed from: d */
    public final Exception f4395d;

    public C1252ig(JsonArray jsonArray) {
        this.f4392a = true;
        this.f4393b = false;
        this.f4394c = jsonArray;
        this.f4395d = null;
    }

    public C1252ig(Exception exc) {
        this.f4392a = false;
        this.f4393b = false;
        this.f4394c = null;
        this.f4395d = exc;
    }

    public C1252ig(boolean z, Exception exc) {
        this.f4392a = false;
        this.f4393b = z;
        this.f4394c = null;
        this.f4395d = exc;
    }
}
