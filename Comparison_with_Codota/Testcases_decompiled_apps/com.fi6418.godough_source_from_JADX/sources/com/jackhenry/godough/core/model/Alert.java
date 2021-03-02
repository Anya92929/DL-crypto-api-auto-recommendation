package com.jackhenry.godough.core.model;

import com.jackhenry.godough.core.p038e.C1580i;
import java.util.Calendar;

public class Alert implements GoDoughType {
    private String accountDesignator;
    private Calendar alertDate;
    private long alertId;
    private String alertItem;
    private String alertText;
    private String alertWatchGroup;
    private long amount;
    private String description;
    private String headerText;

    public Alert() {
    }

    public Alert(String str, Calendar calendar, String str2, String str3, long j, String str4, String str5, String str6, int i) {
        this.accountDesignator = str;
        this.alertDate = calendar;
        this.alertItem = str2;
        this.alertText = str3;
        this.amount = j;
        this.description = str4;
        this.headerText = str5;
        this.alertWatchGroup = str6;
        this.alertId = (long) i;
    }

    public String getAccountDesignator() {
        return this.accountDesignator;
    }

    public Calendar getAlertDate() {
        return this.alertDate;
    }

    public long getAlertId() {
        return this.alertId;
    }

    public String getAlertItem() {
        return this.alertItem;
    }

    public String getAlertText() {
        return this.alertText;
    }

    public String getAlertWatchGroup() {
        return this.alertWatchGroup;
    }

    public long getAmount() {
        return this.amount;
    }

    public String getAmountFormatted() {
        return C1580i.m6152a(this.amount);
    }

    public String getDateFormatted() {
        return C1580i.m6154a(this.alertDate);
    }

    public String getDescription() {
        return this.description;
    }

    public String getHeaderText() {
        return this.headerText;
    }

    public void setAccountDesignator(String str) {
        this.accountDesignator = str;
    }

    public void setAlertDate(Calendar calendar) {
        this.alertDate = calendar;
    }

    public void setAlertId(long j) {
        this.alertId = j;
    }

    public void setAlertItem(String str) {
        this.alertItem = str;
    }

    public void setAlertText(String str) {
        this.alertText = str;
    }

    public void setAlertWatchGroup(String str) {
        this.alertWatchGroup = str;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setHeaderText(String str) {
        this.headerText = str;
    }
}
