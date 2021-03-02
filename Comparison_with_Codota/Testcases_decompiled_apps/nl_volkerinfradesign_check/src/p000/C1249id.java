package p000;

import com.google.gson.JsonObject;
import java.io.File;

/* renamed from: id */
public final class C1249id {

    /* renamed from: a */
    public final boolean f4381a;

    /* renamed from: b */
    public final JsonObject f4382b;

    /* renamed from: c */
    public final File f4383c;

    /* renamed from: d */
    public final Exception f4384d;

    /* renamed from: e */
    public final boolean f4385e;

    public C1249id(boolean z, Exception exc) {
        this.f4382b = null;
        this.f4383c = null;
        this.f4384d = exc;
        this.f4381a = false;
        this.f4385e = z;
    }

    public C1249id(JsonObject jsonObject, File file) {
        this.f4382b = jsonObject;
        this.f4383c = file;
        this.f4384d = null;
        this.f4381a = true;
        this.f4385e = false;
    }

    public C1249id(Exception exc) {
        this.f4382b = null;
        this.f4383c = null;
        this.f4384d = exc;
        this.f4381a = false;
        this.f4385e = false;
    }
}
