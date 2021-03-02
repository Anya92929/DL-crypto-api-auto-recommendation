package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.C0345m;

/* renamed from: com.google.android.gms.internal.iz */
public final class C1356iz extends C1360ja<C1357a, Drawable> {

    /* renamed from: com.google.android.gms.internal.iz$a */
    public static final class C1357a {

        /* renamed from: Li */
        public final int f4088Li;

        /* renamed from: Lj */
        public final int f4089Lj;

        public C1357a(int i, int i2) {
            this.f4088Li = i;
            this.f4089Lj = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1357a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1357a aVar = (C1357a) obj;
            return aVar.f4088Li == this.f4088Li && aVar.f4089Lj == this.f4089Lj;
        }

        public int hashCode() {
            return C0345m.hashCode(Integer.valueOf(this.f4088Li), Integer.valueOf(this.f4089Lj));
        }
    }

    public C1356iz() {
        super(10);
    }
}
