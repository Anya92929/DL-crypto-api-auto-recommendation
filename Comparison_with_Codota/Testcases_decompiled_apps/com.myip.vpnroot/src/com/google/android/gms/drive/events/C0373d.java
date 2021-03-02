package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.d */
public class C0373d {
    /* renamed from: a */
    public static boolean m1000a(int i, DriveId driveId) {
        return driveId != null || m1001bd(i);
    }

    /* renamed from: bd */
    public static boolean m1001bd(int i) {
        return (2 & ((long) (1 << i))) != 0;
    }
}
