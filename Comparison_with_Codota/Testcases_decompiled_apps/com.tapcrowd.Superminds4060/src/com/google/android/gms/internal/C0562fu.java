package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

/* renamed from: com.google.android.gms.internal.fu */
public final class C0562fu extends C0138b implements Moment {

    /* renamed from: sI */
    private C0560fs f1434sI;

    public C0562fu(C0140d dVar, int i) {
        super(dVar, i);
    }

    /* renamed from: dC */
    private C0560fs m1713dC() {
        synchronized (this) {
            if (this.f1434sI == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f1434sI = C0560fs.CREATOR.createFromParcel(obtain);
                obtain.recycle();
            }
        }
        return this.f1434sI;
    }

    /* renamed from: dB */
    public C0560fs freeze() {
        return m1713dC();
    }

    public String getId() {
        return m1713dC().getId();
    }

    public ItemScope getResult() {
        return m1713dC().getResult();
    }

    public String getStartDate() {
        return m1713dC().getStartDate();
    }

    public ItemScope getTarget() {
        return m1713dC().getTarget();
    }

    public String getType() {
        return m1713dC().getType();
    }

    public boolean hasId() {
        return m1713dC().hasId();
    }

    public boolean hasResult() {
        return m1713dC().hasId();
    }

    public boolean hasStartDate() {
        return m1713dC().hasStartDate();
    }

    public boolean hasTarget() {
        return m1713dC().hasTarget();
    }

    public boolean hasType() {
        return m1713dC().hasType();
    }
}
