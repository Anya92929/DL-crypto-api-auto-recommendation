package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzab;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class zzqo {

    /* renamed from: a */
    private final Set f6915a = Collections.newSetFromMap(new WeakHashMap());

    public void release() {
        for (zzqn clear : this.f6915a) {
            clear.clear();
        }
        this.f6915a.clear();
    }

    public zzqn zzb(Object obj, Looper looper) {
        zzab.zzb(obj, (Object) "Listener must not be null");
        zzab.zzb((Object) looper, (Object) "Looper must not be null");
        zzqn zzqn = new zzqn(looper, obj);
        this.f6915a.add(zzqn);
        return zzqn;
    }
}
