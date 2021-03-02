package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.C0343c;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.C0556cc;
import com.google.android.gms.internal.C0577cn;

public final class PersonBuffer extends DataBuffer<Person> {

    /* renamed from: kp */
    private final C0343c<C0556cc> f1745kp;

    public PersonBuffer(C0344d dataHolder) {
        super(dataHolder);
        if (dataHolder.mo4065l() == null || !dataHolder.mo4065l().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.f1745kp = null;
        } else {
            this.f1745kp = new C0343c<>(dataHolder, C0556cc.CREATOR);
        }
    }

    public Person get(int position) {
        return this.f1745kp != null ? this.f1745kp.get(position) : new C0577cn(this.f792S, position);
    }
}
