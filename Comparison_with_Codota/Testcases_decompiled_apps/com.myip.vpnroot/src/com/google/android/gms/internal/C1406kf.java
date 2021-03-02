package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C0502d;
import java.util.Date;

/* renamed from: com.google.android.gms.internal.kf */
public class C1406kf {

    /* renamed from: Ql */
    public static final C1407a f4177Ql = new C1407a("created", 4100000);

    /* renamed from: Qm */
    public static final C1408b f4178Qm = new C1408b("lastOpenedTime", 4300000);

    /* renamed from: Qn */
    public static final C1410d f4179Qn = new C1410d("modified", 4100000);

    /* renamed from: Qo */
    public static final C1409c f4180Qo = new C1409c("modifiedByMe", 4100000);

    /* renamed from: Qp */
    public static final C1411e f4181Qp = new C1411e("sharedWithMe", 4100000);

    /* renamed from: com.google.android.gms.internal.kf$a */
    public static class C1407a extends C0502d implements SortableMetadataField<Date> {
        public C1407a(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kf$b */
    public static class C1408b extends C0502d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1408b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kf$c */
    public static class C1409c extends C0502d implements SortableMetadataField<Date> {
        public C1409c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kf$d */
    public static class C1410d extends C0502d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1410d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kf$e */
    public static class C1411e extends C0502d implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public C1411e(String str, int i) {
            super(str, i);
        }
    }
}
