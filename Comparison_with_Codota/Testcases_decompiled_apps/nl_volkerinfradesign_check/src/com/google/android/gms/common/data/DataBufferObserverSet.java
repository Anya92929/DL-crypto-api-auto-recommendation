package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {

    /* renamed from: a */
    private HashSet<DataBufferObserver> f2834a = new HashSet<>();

    public void addObserver(DataBufferObserver dataBufferObserver) {
        this.f2834a.add(dataBufferObserver);
    }

    public void clear() {
        this.f2834a.clear();
    }

    public boolean hasObservers() {
        return !this.f2834a.isEmpty();
    }

    public void onDataChanged() {
        Iterator<DataBufferObserver> it = this.f2834a.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged();
        }
    }

    public void onDataRangeChanged(int i, int i2) {
        Iterator<DataBufferObserver> it = this.f2834a.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeChanged(i, i2);
        }
    }

    public void onDataRangeInserted(int i, int i2) {
        Iterator<DataBufferObserver> it = this.f2834a.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeInserted(i, i2);
        }
    }

    public void onDataRangeMoved(int i, int i2, int i3) {
        Iterator<DataBufferObserver> it = this.f2834a.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeMoved(i, i2, i3);
        }
    }

    public void onDataRangeRemoved(int i, int i2) {
        Iterator<DataBufferObserver> it = this.f2834a.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeRemoved(i, i2);
        }
    }

    public void removeObserver(DataBufferObserver dataBufferObserver) {
        this.f2834a.remove(dataBufferObserver);
    }
}
