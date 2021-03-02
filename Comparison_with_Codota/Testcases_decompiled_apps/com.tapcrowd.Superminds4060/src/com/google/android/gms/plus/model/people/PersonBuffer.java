package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.C0139c;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.C0563fv;
import com.google.android.gms.internal.C0586gg;

public final class PersonBuffer extends DataBuffer<Person> {

    /* renamed from: tt */
    private final C0139c<C0563fv> f1869tt;

    public PersonBuffer(C0140d dataHolder) {
        super(dataHolder);
        if (dataHolder.mo3599aM() == null || !dataHolder.mo3599aM().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.f1869tt = null;
        } else {
            this.f1869tt = new C0139c<>(dataHolder, C0563fv.CREATOR);
        }
    }

    public Person get(int position) {
        return this.f1869tt != null ? this.f1869tt.get(position) : new C0586gg(this.f366jf, position);
    }
}
