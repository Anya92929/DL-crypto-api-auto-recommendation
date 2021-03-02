package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.C0562fu;

public final class MomentBuffer extends DataBuffer<Moment> {
    public MomentBuffer(C0140d dataHolder) {
        super(dataHolder);
    }

    public Moment get(int position) {
        return new C0562fu(this.f366jf, position);
    }
}
