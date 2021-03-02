package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

/* renamed from: com.google.android.gms.internal.cb */
public final class C0555cb extends C0342b implements Moment {

    /* renamed from: jD */
    private C0544bz f1258jD;

    public C0555cb(C0344d dVar, int i) {
        super(dVar, i);
    }

    /* renamed from: cb */
    private C0544bz m1599cb() {
        synchronized (this) {
            if (this.f1258jD == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f1258jD = C0544bz.CREATOR.createFromParcel(obtain);
                obtain.recycle();
            }
        }
        return this.f1258jD;
    }

    /* renamed from: ca */
    public C0544bz freeze() {
        return m1599cb();
    }

    public String getId() {
        return m1599cb().getId();
    }

    public ItemScope getResult() {
        return m1599cb().getResult();
    }

    public String getStartDate() {
        return m1599cb().getStartDate();
    }

    public ItemScope getTarget() {
        return m1599cb().getTarget();
    }

    public String getType() {
        return m1599cb().getType();
    }

    public boolean hasId() {
        return m1599cb().hasId();
    }

    public boolean hasResult() {
        return m1599cb().hasId();
    }

    public boolean hasStartDate() {
        return m1599cb().hasStartDate();
    }

    public boolean hasTarget() {
        return m1599cb().hasTarget();
    }

    public boolean hasType() {
        return m1599cb().hasType();
    }
}
