package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.ArrayList;
import java.util.List;

public class MultiDetector extends Detector<Object> {
    /* access modifiers changed from: private */
    public List<Detector<? extends Object>> zzbno;

    public static class Builder {
        private MultiDetector zzbnp = new MultiDetector();

        public Builder add(Detector<? extends Object> detector) {
            this.zzbnp.zzbno.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzbnp.zzbno.size() != 0) {
                return this.zzbnp;
            }
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        }
    }

    private MultiDetector() {
        this.zzbno = new ArrayList();
    }

    public SparseArray<Object> detect(Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        for (Detector<? extends Object> detect : this.zzbno) {
            SparseArray detect2 = detect.detect(frame);
            int i = 0;
            while (true) {
                if (i < detect2.size()) {
                    int keyAt = detect2.keyAt(i);
                    if (sparseArray.get(keyAt) != null) {
                        throw new IllegalStateException("Detection ID overlap for id = " + keyAt + ".  " + "This means that one of the detectors is not using global IDs.");
                    }
                    sparseArray.append(keyAt, detect2.valueAt(i));
                    i++;
                }
            }
        }
        return sparseArray;
    }

    public boolean isOperational() {
        for (Detector<? extends Object> isOperational : this.zzbno) {
            if (!isOperational.isOperational()) {
                return false;
            }
        }
        return true;
    }

    public void receiveFrame(Frame frame) {
        for (Detector<? extends Object> receiveFrame : this.zzbno) {
            receiveFrame.receiveFrame(frame);
        }
    }

    public void release() {
        for (Detector<? extends Object> release : this.zzbno) {
            release.release();
        }
        this.zzbno.clear();
    }

    public void setProcessor(Detector.Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
