package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.C0558fq;
import com.google.android.gms.internal.C0560fs;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {

        /* renamed from: rI */
        private final Set<Integer> f1863rI = new HashSet();

        /* renamed from: sD */
        private String f1864sD;

        /* renamed from: sG */
        private C0558fq f1865sG;

        /* renamed from: sH */
        private C0558fq f1866sH;

        /* renamed from: sm */
        private String f1867sm;

        /* renamed from: sx */
        private String f1868sx;

        public Moment build() {
            return new C0560fs(this.f1863rI, this.f1867sm, this.f1865sG, this.f1868sx, this.f1866sH, this.f1864sD);
        }

        public Builder setId(String id) {
            this.f1867sm = id;
            this.f1863rI.add(2);
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.f1865sG = (C0558fq) result;
            this.f1863rI.add(4);
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.f1868sx = startDate;
            this.f1863rI.add(5);
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.f1866sH = (C0558fq) target;
            this.f1863rI.add(6);
            return this;
        }

        public Builder setType(String type) {
            this.f1864sD = type;
            this.f1863rI.add(7);
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
