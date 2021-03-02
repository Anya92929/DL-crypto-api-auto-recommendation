package com.jackhenry.godough.core.model;

import java.util.List;

public class ACHBatches implements GoDoughType {
    private List<ACH> batches;
    private boolean moreRecords;
    private int nextStartRecord;

    public List<ACH> getBatches() {
        return this.batches;
    }

    public int getNextStartRecord() {
        return this.nextStartRecord;
    }

    public boolean isMoreRecords() {
        return this.moreRecords;
    }

    public void setBatches(List<ACH> list) {
        this.batches = list;
    }

    public void setMoreRecords(boolean z) {
        this.moreRecords = z;
    }

    public void setNextStartRecord(int i) {
        this.nextStartRecord = i;
    }
}
