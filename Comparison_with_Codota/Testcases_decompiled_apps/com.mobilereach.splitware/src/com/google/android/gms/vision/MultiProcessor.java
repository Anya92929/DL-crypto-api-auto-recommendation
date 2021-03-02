package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.HashSet;

public class MultiProcessor<T> implements Detector.Processor<T> {
    /* access modifiers changed from: private */
    public int zzbne;
    /* access modifiers changed from: private */
    public Factory<T> zzbnq;
    private SparseArray<MultiProcessor<T>.zza> zzbnr;

    public static class Builder<T> {
        private MultiProcessor<T> zzbns = new MultiProcessor<>();

        public Builder(Factory<T> factory) {
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            Factory unused = this.zzbns.zzbnq = factory;
        }

        public MultiProcessor<T> build() {
            return this.zzbns;
        }

        public Builder<T> setMaxGapFrames(int maxGapFrames) {
            if (maxGapFrames < 0) {
                throw new IllegalArgumentException("Invalid max gap: " + maxGapFrames);
            }
            int unused = this.zzbns.zzbne = maxGapFrames;
            return this;
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    private class zza {
        /* access modifiers changed from: private */
        public Tracker<T> zzbnd;
        /* access modifiers changed from: private */
        public int zzbnh;

        private zza() {
            this.zzbnh = 0;
        }

        static /* synthetic */ int zzb(zza zza) {
            int i = zza.zzbnh;
            zza.zzbnh = i + 1;
            return i;
        }
    }

    private MultiProcessor() {
        this.zzbnr = new SparseArray<>();
        this.zzbne = 3;
    }

    private void zza(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            T valueAt = detectedItems.valueAt(i);
            if (this.zzbnr.get(keyAt) == null) {
                zza zza2 = new zza();
                Tracker unused = zza2.zzbnd = this.zzbnq.create(valueAt);
                zza2.zzbnd.onNewItem(keyAt, valueAt);
                this.zzbnr.append(keyAt, zza2);
            }
        }
    }

    private void zzb(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        HashSet<Integer> hashSet = new HashSet<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbnr.size()) {
                break;
            }
            int keyAt = this.zzbnr.keyAt(i2);
            if (detectedItems.get(keyAt) == null) {
                zza valueAt = this.zzbnr.valueAt(i2);
                zza.zzb(valueAt);
                if (valueAt.zzbnh >= this.zzbne) {
                    valueAt.zzbnd.onDone();
                    hashSet.add(Integer.valueOf(keyAt));
                } else {
                    valueAt.zzbnd.onMissing(detections);
                }
            }
            i = i2 + 1;
        }
        for (Integer intValue : hashSet) {
            this.zzbnr.delete(intValue.intValue());
        }
    }

    private void zzc(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            T valueAt = detectedItems.valueAt(i);
            zza zza2 = this.zzbnr.get(keyAt);
            int unused = zza2.zzbnh = 0;
            zza2.zzbnd.onUpdate(detections, valueAt);
        }
    }

    public void receiveDetections(Detector.Detections<T> detections) {
        zza(detections);
        zzb(detections);
        zzc(detections);
    }

    public void release() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zzbnr.size()) {
                this.zzbnr.valueAt(i2).zzbnd.onDone();
                i = i2 + 1;
            } else {
                this.zzbnr.clear();
                return;
            }
        }
    }
}
