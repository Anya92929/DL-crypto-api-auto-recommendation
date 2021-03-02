package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.query.internal.e */
class C0520e {
    /* renamed from: b */
    static MetadataField<?> m1498b(MetadataBundle metadataBundle) {
        Set<MetadataField<?>> ip = metadataBundle.mo5139ip();
        if (ip.size() == 1) {
            return ip.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
