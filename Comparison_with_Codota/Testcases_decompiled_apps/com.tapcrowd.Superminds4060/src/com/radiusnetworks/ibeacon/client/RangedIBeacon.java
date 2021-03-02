package com.radiusnetworks.ibeacon.client;

import android.util.Log;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class RangedIBeacon extends IBeacon {
    public static long DEFAULT_SAMPLE_EXPIRATION_MILLISECONDS = 5000;
    private static String TAG = "RangedIBeacon";
    private ArrayList<Measurement> measurements = new ArrayList<>();
    private long sampleExpirationMilliseconds = DEFAULT_SAMPLE_EXPIRATION_MILLISECONDS;

    public RangedIBeacon(IBeacon ibeacon) {
        super(ibeacon);
        addMeasurement(Integer.valueOf(this.rssi));
    }

    public void setSampleExpirationMilliseconds(long milliseconds) {
        this.sampleExpirationMilliseconds = milliseconds;
    }

    public void addMeasurement(Integer rssi) {
        Measurement measurement = new Measurement();
        measurement.rssi = rssi;
        measurement.timestamp = new Date().getTime();
        this.measurements.add(measurement);
    }

    public boolean allMeasurementsExpired() {
        refreshMeasurements();
        return this.measurements.size() == 0;
    }

    private class Measurement implements Comparable<Measurement> {
        Integer rssi;
        long timestamp;

        private Measurement() {
        }

        public int compareTo(Measurement arg0) {
            return this.rssi.compareTo(arg0.rssi);
        }
    }

    private synchronized void refreshMeasurements() {
        Date now = new Date();
        ArrayList<Measurement> newMeasurements = new ArrayList<>();
        Iterator<Measurement> iterator = this.measurements.iterator();
        while (iterator.hasNext()) {
            Measurement measurement = iterator.next();
            if (now.getTime() - measurement.timestamp < this.sampleExpirationMilliseconds) {
                newMeasurements.add(measurement);
            }
        }
        this.measurements = newMeasurements;
        Collections.sort(this.measurements);
    }

    private double calculateRunningAverage() {
        refreshMeasurements();
        int size = this.measurements.size();
        int startIndex = 0;
        int endIndex = size - 1;
        if (size > 2) {
            startIndex = (size / 10) + 1;
            endIndex = (size - (size / 10)) - 2;
        }
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += this.measurements.get(i).rssi.intValue();
        }
        double runningAverage = (double) (sum / ((endIndex - startIndex) + 1));
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "Running average rssi based on " + size + " measurements: " + runningAverage);
        }
        return runningAverage;
    }

    /* access modifiers changed from: protected */
    public void addRangeMeasurement(Integer rssi) {
        this.rssi = rssi.intValue();
        addMeasurement(rssi);
        if (IBeaconManager.LOG_DEBUG) {
            Log.d(TAG, "calculating new range measurement with new rssi measurement:" + rssi);
        }
        this.runningAverageRssi = Double.valueOf(calculateRunningAverage());
        this.accuracy = null;
        this.proximity = null;
    }
}
