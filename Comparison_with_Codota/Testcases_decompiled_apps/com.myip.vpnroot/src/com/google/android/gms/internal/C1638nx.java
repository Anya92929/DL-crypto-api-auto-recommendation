package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

/* renamed from: com.google.android.gms.internal.nx */
public final class C1638nx extends C0297d implements Moment {
    private C1636nv amO;

    public C1638nx(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* renamed from: nr */
    private C1636nv m5758nr() {
        synchronized (this) {
            if (this.amO == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.amO = C1636nv.CREATOR.createFromParcel(obtain);
                obtain.recycle();
            }
        }
        return this.amO;
    }

    public String getId() {
        return m5758nr().getId();
    }

    public ItemScope getResult() {
        return m5758nr().getResult();
    }

    public String getStartDate() {
        return m5758nr().getStartDate();
    }

    public ItemScope getTarget() {
        return m5758nr().getTarget();
    }

    public String getType() {
        return m5758nr().getType();
    }

    public boolean hasId() {
        return m5758nr().hasId();
    }

    public boolean hasResult() {
        return m5758nr().hasResult();
    }

    public boolean hasStartDate() {
        return m5758nr().hasStartDate();
    }

    public boolean hasTarget() {
        return m5758nr().hasTarget();
    }

    public boolean hasType() {
        return m5758nr().hasType();
    }

    /* renamed from: nq */
    public C1636nv freeze() {
        return m5758nr();
    }
}
