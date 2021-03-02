package com.google.android.gms.internal;

import java.util.Map;

public class zzi {
    public final byte[] data;
    public final int statusCode;
    public final boolean zzaa;
    public final long zzab;
    public final Map zzz;

    public zzi(int i, byte[] bArr, Map map, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzz = map;
        this.zzaa = z;
        this.zzab = j;
    }

    public zzi(byte[] bArr, Map map) {
        this(200, bArr, map, false, 0);
    }
}
