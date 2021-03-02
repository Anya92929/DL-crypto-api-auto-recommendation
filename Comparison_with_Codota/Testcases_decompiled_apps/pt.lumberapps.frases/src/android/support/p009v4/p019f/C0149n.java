package android.support.p009v4.p019f;

/* renamed from: android.support.v4.f.n */
public class C0149n {

    /* renamed from: a */
    public final Object f221a;

    /* renamed from: b */
    public final Object f222b;

    /* renamed from: a */
    private static boolean m376a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0149n)) {
            return false;
        }
        C0149n nVar = (C0149n) obj;
        return m376a(nVar.f221a, this.f221a) && m376a(nVar.f222b, this.f222b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f221a == null ? 0 : this.f221a.hashCode();
        if (this.f222b != null) {
            i = this.f222b.hashCode();
        }
        return hashCode ^ i;
    }
}
