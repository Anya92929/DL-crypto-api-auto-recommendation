package android.support.p021v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

/* renamed from: android.support.v7.widget.ab */
public final class C0577ab implements Comparable {

    /* renamed from: a */
    public final ResolveInfo f1356a;

    /* renamed from: b */
    public float f1357b;

    /* renamed from: c */
    final /* synthetic */ C0704z f1358c;

    public C0577ab(C0704z zVar, ResolveInfo resolveInfo) {
        this.f1358c = zVar;
        this.f1356a = resolveInfo;
    }

    /* renamed from: a */
    public int compareTo(C0577ab abVar) {
        return Float.floatToIntBits(abVar.f1357b) - Float.floatToIntBits(this.f1357b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return Float.floatToIntBits(this.f1357b) == Float.floatToIntBits(((C0577ab) obj).f1357b);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1357b) + 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("resolveInfo:").append(this.f1356a.toString());
        sb.append("; weight:").append(new BigDecimal((double) this.f1357b));
        sb.append("]");
        return sb.toString();
    }
}
