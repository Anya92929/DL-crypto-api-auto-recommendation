package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;

/* renamed from: com.google.android.gms.common.images.g */
final class C1357g {

    /* renamed from: a */
    public final Uri f4434a;

    public C1357g(Uri uri) {
        this.f4434a = uri;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1357g)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return zzaa.equal(((C1357g) obj).f4434a, this.f4434a);
    }

    public int hashCode() {
        return zzaa.hashCode(this.f4434a);
    }
}
