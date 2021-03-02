package com.jackhenry.godough.core.model;

import java.util.Calendar;
import java.util.List;

public class ACHEffectiveDatesResponse implements GoDoughType {
    private static final long serialVersionUID = 1;
    private List<Calendar> effectiveDates;

    public List<Calendar> getEffectiveDates() {
        return this.effectiveDates;
    }

    public void setEffectiveDates(List<Calendar> list) {
        this.effectiveDates = list;
    }
}
