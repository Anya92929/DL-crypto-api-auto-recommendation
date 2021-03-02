package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.C1634nt;
import com.google.android.gms.internal.C1636nv;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {

        /* renamed from: BL */
        private String f4517BL;
        private final Set<Integer> alR = new HashSet();
        private String amE;
        private C1634nt amM;
        private C1634nt amN;

        /* renamed from: uO */
        private String f4518uO;

        public Moment build() {
            return new C1636nv(this.alR, this.f4517BL, this.amM, this.amE, this.amN, this.f4518uO);
        }

        public Builder setId(String id) {
            this.f4517BL = id;
            this.alR.add(2);
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.amM = (C1634nt) result;
            this.alR.add(4);
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.amE = startDate;
            this.alR.add(5);
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.amN = (C1634nt) target;
            this.alR.add(6);
            return this;
        }

        public Builder setType(String type) {
            this.f4518uO = type;
            this.alR.add(7);
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
