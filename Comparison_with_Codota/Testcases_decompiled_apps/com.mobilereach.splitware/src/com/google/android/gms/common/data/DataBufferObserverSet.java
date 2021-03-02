package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private HashSet<DataBufferObserver> zzajd = new HashSet<>();

    public void addObserver(DataBufferObserver observer) {
        this.zzajd.add(observer);
    }

    public void clear() {
        this.zzajd.clear();
    }

    public boolean hasObservers() {
        return !this.zzajd.isEmpty();
    }

    public void onDataChanged() {
        Iterator<DataBufferObserver> it = this.zzajd.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged();
        }
    }

    public void onDataRangeChanged(int position, int count) {
        Iterator<DataBufferObserver> it = this.zzajd.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeChanged(position, count);
        }
    }

    public void onDataRangeInserted(int position, int count) {
        Iterator<DataBufferObserver> it = this.zzajd.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeInserted(position, count);
        }
    }

    public void onDataRangeMoved(int fromPosition, int toPosition, int count) {
        Iterator<DataBufferObserver> it = this.zzajd.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeMoved(fromPosition, toPosition, count);
        }
    }

    public void onDataRangeRemoved(int position, int count) {
        Iterator<DataBufferObserver> it = this.zzajd.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeRemoved(position, count);
        }
    }

    public void removeObserver(DataBufferObserver observer) {
        this.zzajd.remove(observer);
    }
}
