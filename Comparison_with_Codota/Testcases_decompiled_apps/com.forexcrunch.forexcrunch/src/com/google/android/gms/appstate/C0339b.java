package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0339b extends C0342b implements AppState {
    C0339b(C0344d dVar, int i) {
        super(dVar, i);
    }

    /* renamed from: a */
    public AppState freeze() {
        return new C0338a(this);
    }

    public boolean equals(Object obj) {
        return C0338a.m531a(this, obj);
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
        return !mo4039e("conflict_version");
    }

    public int hashCode() {
        return C0338a.m530a(this);
    }

    public String toString() {
        return C0338a.m532b(this);
    }
}
