package p000;

import java.util.List;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;

/* renamed from: is */
public final class C1287is {

    /* renamed from: a */
    private final Exception f4498a;

    /* renamed from: b */
    private final Form f4499b;

    public C1287is(Exception exc) {
        this.f4498a = exc;
        this.f4499b = null;
    }

    public C1287is(List<Form> list) {
        Form form = null;
        this.f4498a = null;
        this.f4499b = !list.isEmpty() ? list.get(0) : form;
    }

    /* renamed from: a */
    public Exception mo8644a() {
        return this.f4498a;
    }

    /* renamed from: b */
    public Form mo8645b() {
        return this.f4499b;
    }

    /* renamed from: c */
    public boolean mo8646c() {
        return this.f4498a != null;
    }

    /* renamed from: d */
    public boolean mo8647d() {
        return this.f4499b != null;
    }
}
