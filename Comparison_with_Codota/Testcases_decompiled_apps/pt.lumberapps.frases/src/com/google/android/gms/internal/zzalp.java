package com.google.android.gms.internal;

import android.content.Context;
import com.google.firebase.C1975b;
import com.google.firebase.C1978e;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzalp {

    /* renamed from: a */
    private static final AtomicReference f5763a = new AtomicReference();

    zzalp(Context context) {
    }

    public static zzalp zzcxc() {
        return (zzalp) f5763a.get();
    }

    public static zzalp zzeq(Context context) {
        f5763a.compareAndSet((Object) null, new zzalp(context));
        return (zzalp) f5763a.get();
    }

    public Set zzcxd() {
        return Collections.emptySet();
    }

    public void zzf(C1975b bVar) {
    }

    public C1978e zzta(String str) {
        return null;
    }
}
