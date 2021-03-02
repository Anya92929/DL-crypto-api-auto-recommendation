package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.C0542bx;
import com.google.android.gms.internal.C0544bz;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {

        /* renamed from: iD */
        private final Set<Integer> f1739iD = new HashSet();

        /* renamed from: jB */
        private C0542bx f1740jB;

        /* renamed from: jC */
        private C0542bx f1741jC;

        /* renamed from: jh */
        private String f1742jh;

        /* renamed from: js */
        private String f1743js;

        /* renamed from: jy */
        private String f1744jy;

        public Moment build() {
            return new C0544bz(this.f1739iD, this.f1742jh, this.f1740jB, this.f1743js, this.f1741jC, this.f1744jy);
        }

        public Builder setId(String id) {
            this.f1742jh = id;
            this.f1739iD.add(2);
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.f1740jB = (C0542bx) result;
            this.f1739iD.add(4);
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.f1743js = startDate;
            this.f1739iD.add(5);
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.f1741jC = (C0542bx) target;
            this.f1739iD.add(6);
            return this;
        }

        public Builder setType(String type) {
            this.f1744jy = type;
            this.f1739iD.add(7);
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
