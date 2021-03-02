package com.google.android.gms.location;

import java.util.Comparator;

/* renamed from: com.google.android.gms.location.b */
final class C1110b implements Comparator<DetectedActivity> {
    C1110b() {
    }

    /* renamed from: a */
    public int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
        int compareTo = Integer.valueOf(detectedActivity2.mo7720b()).compareTo(Integer.valueOf(detectedActivity.mo7720b()));
        return compareTo == 0 ? Integer.valueOf(detectedActivity.mo7719a()).compareTo(Integer.valueOf(detectedActivity2.mo7719a())) : compareTo;
    }
}
