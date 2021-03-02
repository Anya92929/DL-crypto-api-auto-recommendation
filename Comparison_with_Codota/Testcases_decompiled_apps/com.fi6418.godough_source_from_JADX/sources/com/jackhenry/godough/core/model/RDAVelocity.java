package com.jackhenry.godough.core.model;

public class RDAVelocity implements GoDoughType {
    long dailyAmount;
    long dailyAmountLimit;
    long dailyCount;
    long dailyCountLimit;
    boolean enabled;
    long periodAmount;
    long periodAmountLimit;
    long periodCount;
    long periodCountLimit;

    private boolean isEnabled() {
        return this.enabled;
    }

    private void setEnabled(boolean z) {
        this.enabled = z;
    }

    public long getDailyAmount() {
        return this.dailyAmount;
    }

    public long getDailyAmountLimit() {
        return this.dailyAmountLimit;
    }

    public long getDailyCount() {
        return this.dailyCount;
    }

    public long getDailyCountLimit() {
        return this.dailyCountLimit;
    }

    public long getPeriodAmount() {
        return this.periodAmount;
    }

    public long getPeriodAmountLimit() {
        return this.periodAmountLimit;
    }

    public long getPeriodCount() {
        return this.periodCount;
    }

    public long getPeriodCountLimit() {
        return this.periodCountLimit;
    }

    public boolean isVelocityValid() {
        return (getDailyAmountLimit() == 0 || getDailyCountLimit() == 0 || getPeriodAmountLimit() == 0 || getPeriodCountLimit() == 0) ? false : true;
    }

    public void setDailyAmount(int i) {
        this.dailyAmount = (long) i;
    }

    public void setDailyAmountLimit(long j) {
        this.dailyAmountLimit = j;
    }

    public void setDailyCount(int i) {
        this.dailyCount = (long) i;
    }

    public void setDailyCountLimit(int i) {
        this.dailyCountLimit = (long) i;
    }

    public void setPeriodAmount(long j) {
        this.periodAmount = j;
    }

    public void setPeriodAmountLimit(long j) {
        this.periodAmountLimit = j;
    }

    public void setPeriodCount(int i) {
        this.periodCount = (long) i;
    }

    public void setPeriodCountLimit(int i) {
        this.periodCountLimit = (long) i;
    }
}
