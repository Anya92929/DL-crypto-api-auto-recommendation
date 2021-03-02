package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;

public class ACHRequest implements GoDoughType {
    private String batchId;
    private Calendar effectiveDate;
    private String offsetAccountNumber;
    private String offsetAccountType;
    private String requestToken;
    private boolean resetAmountToZero;

    public ACHRequest() {
    }

    public ACHRequest(String str, boolean z, Calendar calendar, String str2, String str3, String str4) {
        this.batchId = str;
        this.resetAmountToZero = z;
        this.effectiveDate = calendar;
        this.offsetAccountType = str2;
        this.offsetAccountNumber = str3;
        this.requestToken = str4;
    }

    public String getBatchId() {
        return this.batchId;
    }

    public Calendar getEffectiveDate() {
        return this.effectiveDate;
    }

    public String getEffectiveDateFormatted() {
        return C1580i.m6154a(this.effectiveDate);
    }

    public String getOffsetAccountNumber() {
        return this.offsetAccountNumber;
    }

    public String getOffsetAccountType() {
        return this.offsetAccountType;
    }

    public String getRequestToken() {
        return this.requestToken;
    }

    public boolean isResetAmountToZero() {
        return this.resetAmountToZero;
    }

    public void setBatchId(String str) {
        this.batchId = str;
    }

    public void setEffectiveDate(Calendar calendar) {
        this.effectiveDate = calendar;
    }

    public void setOffsetAccountNumber(String str) {
        this.offsetAccountNumber = str;
    }

    public void setOffsetAccountType(String str) {
        this.offsetAccountType = str;
    }

    public void setRequestToken(String str) {
        this.requestToken = str;
    }

    public void setResetAmountToZero(boolean z) {
        this.resetAmountToZero = z;
    }
}
