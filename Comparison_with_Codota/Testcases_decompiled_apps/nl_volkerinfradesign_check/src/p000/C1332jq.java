package p000;

/* renamed from: jq */
public final class C1332jq {

    /* renamed from: a */
    private final Object f4598a;

    /* renamed from: b */
    private final int f4599b;

    public C1332jq(Object obj) {
        this.f4599b = System.identityHashCode(obj);
        this.f4598a = obj;
    }

    public int hashCode() {
        return this.f4599b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1332jq)) {
            return false;
        }
        C1332jq jqVar = (C1332jq) obj;
        if (this.f4599b == jqVar.f4599b && this.f4598a == jqVar.f4598a) {
            return true;
        }
        return false;
    }
}
