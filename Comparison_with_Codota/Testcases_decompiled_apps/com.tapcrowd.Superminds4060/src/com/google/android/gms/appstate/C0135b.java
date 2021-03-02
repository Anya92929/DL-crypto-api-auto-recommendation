package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0135b extends C0138b implements AppState {
    C0135b(C0140d dVar, int i) {
        super(dVar, i);
    }

    /* renamed from: aE */
    public AppState freeze() {
        return new C0134a(this);
    }

    public boolean equals(Object obj) {
        return C0134a.m207a(this, obj);
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !mo3592v("conflict_version");
    }

    public int hashCode() {
        return C0134a.m206a(this);
    }

    public String toString() {
        return C0134a.m208b(this);
    }
}
