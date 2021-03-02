package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.C0298e;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.C1639ny;
import com.google.android.gms.internal.C1662oj;

public final class PersonBuffer extends DataBuffer<Person> {
    private final C0298e<C1639ny> any;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.mo4321gz() == null || !dataHolder.mo4321gz().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.any = null;
        } else {
            this.any = new C0298e<>(dataHolder, C1639ny.CREATOR);
        }
    }

    public Person get(int position) {
        return this.any != null ? this.any.get(position) : new C1662oj(this.f667IC, position);
    }
}
