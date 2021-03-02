package okhttp3;

import okhttp3.internal.Util;

public final class Challenge {

    /* renamed from: a */
    private final String f5747a;

    /* renamed from: b */
    private final String f5748b;

    public Challenge(String str, String str2) {
        this.f5747a = str;
        this.f5748b = str2;
    }

    public String scheme() {
        return this.f5747a;
    }

    public String realm() {
        return this.f5748b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Challenge) && Util.equal(this.f5747a, ((Challenge) obj).f5747a) && Util.equal(this.f5748b, ((Challenge) obj).f5748b);
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (this.f5748b != null) {
            i = this.f5748b.hashCode();
        } else {
            i = 0;
        }
        int i3 = (i + 899) * 31;
        if (this.f5747a != null) {
            i2 = this.f5747a.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        return this.f5747a + " realm=\"" + this.f5748b + "\"";
    }
}
