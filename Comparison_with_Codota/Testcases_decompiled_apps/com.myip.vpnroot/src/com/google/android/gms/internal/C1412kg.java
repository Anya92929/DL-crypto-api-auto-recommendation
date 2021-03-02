package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.C0508j;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.kg */
public class C1412kg extends C0508j<DriveId> {

    /* renamed from: Qq */
    public static final C1412kg f4182Qq = new C1412kg();

    private C1412kg() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public DriveId mo5120c(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.mo4321gz().getLong("dbInstanceId");
        String c = dataHolder.mo4306c("resourceId", i, i2);
        if (c != null && c.startsWith("generated-android-")) {
            c = null;
        }
        return new DriveId(c, Long.valueOf(dataHolder.mo4301a("sqlId", i, i2)).longValue(), j);
    }
}
