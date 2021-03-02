package android.support.p009v4.p019f;

import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v4.f.l */
final class C0147l implements Iterator, Map.Entry {

    /* renamed from: a */
    int f216a;

    /* renamed from: b */
    int f217b;

    /* renamed from: c */
    boolean f218c = false;

    /* renamed from: d */
    final /* synthetic */ C0143h f219d;

    C0147l(C0143h hVar) {
        this.f219d = hVar;
        this.f216a = hVar.mo1041a() - 1;
        this.f217b = -1;
    }

    /* renamed from: a */
    public Map.Entry next() {
        this.f217b++;
        this.f218c = true;
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f218c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Map.Entry)) {
            return false;
        } else {
            Map.Entry entry = (Map.Entry) obj;
            if (!C0138c.m338a(entry.getKey(), this.f219d.mo1043a(this.f217b, 0)) || !C0138c.m338a(entry.getValue(), this.f219d.mo1043a(this.f217b, 1))) {
                z = false;
            }
            return z;
        }
    }

    public Object getKey() {
        if (this.f218c) {
            return this.f219d.mo1043a(this.f217b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public Object getValue() {
        if (this.f218c) {
            return this.f219d.mo1043a(this.f217b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.f217b < this.f216a;
    }

    public final int hashCode() {
        int i = 0;
        if (!this.f218c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object a = this.f219d.mo1043a(this.f217b, 0);
        Object a2 = this.f219d.mo1043a(this.f217b, 1);
        int hashCode = a == null ? 0 : a.hashCode();
        if (a2 != null) {
            i = a2.hashCode();
        }
        return i ^ hashCode;
    }

    public void remove() {
        if (!this.f218c) {
            throw new IllegalStateException();
        }
        this.f219d.mo1045a(this.f217b);
        this.f217b--;
        this.f216a--;
        this.f218c = false;
    }

    public Object setValue(Object obj) {
        if (this.f218c) {
            return this.f219d.mo1044a(this.f217b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
