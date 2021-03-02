package com.jackhenry.godough.core.model;

import java.util.List;

public class SelfEnrollmentData extends TermsAndConditions {
    private static final long serialVersionUID = 1;
    private List<Carrier> carriers;

    public List<Carrier> getCarriers() {
        return this.carriers;
    }

    public void setCarriers(List<Carrier> list) {
        this.carriers = list;
    }
}
