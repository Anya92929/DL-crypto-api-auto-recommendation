package android.support.p021v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

/* renamed from: android.support.v7.widget.ad */
public final class C0579ad {

    /* renamed from: a */
    public final ComponentName f1359a;

    /* renamed from: b */
    public final long f1360b;

    /* renamed from: c */
    public final float f1361c;

    public C0579ad(ComponentName componentName, long j, float f) {
        this.f1359a = componentName;
        this.f1360b = j;
        this.f1361c = f;
    }

    public C0579ad(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
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
        C0579ad adVar = (C0579ad) obj;
        if (this.f1359a == null) {
            if (adVar.f1359a != null) {
                return false;
            }
        } else if (!this.f1359a.equals(adVar.f1359a)) {
            return false;
        }
        if (this.f1360b != adVar.f1360b) {
            return false;
        }
        return Float.floatToIntBits(this.f1361c) == Float.floatToIntBits(adVar.f1361c);
    }

    public int hashCode() {
        return (((((this.f1359a == null ? 0 : this.f1359a.hashCode()) + 31) * 31) + ((int) (this.f1360b ^ (this.f1360b >>> 32)))) * 31) + Float.floatToIntBits(this.f1361c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("; activity:").append(this.f1359a);
        sb.append("; time:").append(this.f1360b);
        sb.append("; weight:").append(new BigDecimal((double) this.f1361c));
        sb.append("]");
        return sb.toString();
    }
}
