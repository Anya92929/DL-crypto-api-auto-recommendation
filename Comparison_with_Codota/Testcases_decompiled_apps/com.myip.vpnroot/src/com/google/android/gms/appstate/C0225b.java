package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0225b extends C0297d implements AppState {
    C0225b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return C0224a.m339a(this, obj);
    }

    /* renamed from: fp */
    public AppState freeze() {
        return new C0224a(this);
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
        return !mo4339aS("conflict_version");
    }

    public int hashCode() {
        return C0224a.m338a(this);
    }

    public String toString() {
        return C0224a.m340b(this);
    }
}
