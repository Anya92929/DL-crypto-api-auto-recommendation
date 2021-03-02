package android.support.p009v4.p019f;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.f.a */
public class C0136a extends C0150o implements Map {

    /* renamed from: a */
    C0143h f186a;

    public C0136a() {
    }

    public C0136a(int i) {
        super(i);
    }

    /* renamed from: b */
    private C0143h m324b() {
        if (this.f186a == null) {
            this.f186a = new C0137b(this);
        }
        return this.f186a;
    }

    /* renamed from: a */
    public boolean mo1036a(Collection collection) {
        return C0143h.m359c(this, collection);
    }

    public Set entrySet() {
        return m324b().mo1083d();
    }

    public Set keySet() {
        return m324b().mo1084e();
    }

    public void putAll(Map map) {
        mo1149a(this.f229h + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection values() {
        return m324b().mo1085f();
    }
}
