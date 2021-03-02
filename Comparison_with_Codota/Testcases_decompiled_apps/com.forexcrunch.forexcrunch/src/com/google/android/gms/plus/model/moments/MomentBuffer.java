package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.C0555cb;

public final class MomentBuffer extends DataBuffer<Moment> {
    public MomentBuffer(C0344d dataHolder) {
        super(dataHolder);
    }

    public Moment get(int position) {
        return new C0555cb(this.f792S, position);
    }
}
