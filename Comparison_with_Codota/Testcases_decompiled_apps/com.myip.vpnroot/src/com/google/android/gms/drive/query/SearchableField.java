package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.C1395kd;
import com.google.android.gms.internal.C1406kf;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED = C1395kd.f4156PQ;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = C1406kf.f4178Qm;
    public static final SearchableMetadataField<String> MIME_TYPE = C1395kd.f4161PV;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = C1406kf.f4179Qn;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = C1395kd.f4166Qa;

    /* renamed from: Qy */
    public static final SearchableOrderedMetadataField<Date> f1115Qy = C1406kf.f4181Qp;

    /* renamed from: Qz */
    public static final SearchableMetadataField<AppVisibleCustomProperties> f1116Qz = C1395kd.f4146PG;
    public static final SearchableMetadataField<Boolean> STARRED = C1395kd.f4168Qc;
    public static final SearchableMetadataField<String> TITLE = C1395kd.f4170Qe;
    public static final SearchableMetadataField<Boolean> TRASHED = C1395kd.f4171Qf;
}
