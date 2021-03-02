package com.google.android.gms.internal;

import com.google.android.gms.common.data.C0294a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.C0494b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C0500b;
import com.google.android.gms.drive.metadata.internal.C0505g;
import com.google.android.gms.drive.metadata.internal.C0507i;
import com.google.android.gms.drive.metadata.internal.C0508j;
import com.google.android.gms.drive.metadata.internal.C0509k;
import com.google.android.gms.drive.metadata.internal.C0510l;
import com.google.android.gms.drive.metadata.internal.C0511m;
import com.google.android.gms.plus.PlusShare;
import java.util.Collections;

/* renamed from: com.google.android.gms.internal.kd */
public class C1395kd {

    /* renamed from: PE */
    public static final MetadataField<DriveId> f4144PE = C1412kg.f4182Qq;

    /* renamed from: PF */
    public static final MetadataField<String> f4145PF = new C0510l("alternateLink", 4300000);

    /* renamed from: PG */
    public static final C1397a f4146PG = new C1397a(5000000);

    /* renamed from: PH */
    public static final MetadataField<String> f4147PH = new C0510l(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);

    /* renamed from: PI */
    public static final MetadataField<String> f4148PI = new C0510l("embedLink", 4300000);

    /* renamed from: PJ */
    public static final MetadataField<String> f4149PJ = new C0510l("fileExtension", 4300000);

    /* renamed from: PK */
    public static final MetadataField<Long> f4150PK = new C0505g("fileSize", 4300000);

    /* renamed from: PL */
    public static final MetadataField<Boolean> f4151PL = new C0500b("hasThumbnail", 4300000);

    /* renamed from: PM */
    public static final MetadataField<String> f4152PM = new C0510l("indexableText", 4300000);

    /* renamed from: PN */
    public static final MetadataField<Boolean> f4153PN = new C0500b("isAppData", 4300000);

    /* renamed from: PO */
    public static final MetadataField<Boolean> f4154PO = new C0500b("isCopyable", 4300000);

    /* renamed from: PP */
    public static final MetadataField<Boolean> f4155PP = new C0500b("isEditable", 4100000);

    /* renamed from: PQ */
    public static final C1398b f4156PQ = new C1398b("isPinned", 4100000);

    /* renamed from: PR */
    public static final MetadataField<Boolean> f4157PR = new C0500b("isRestricted", 4300000);

    /* renamed from: PS */
    public static final MetadataField<Boolean> f4158PS = new C0500b("isShared", 4300000);

    /* renamed from: PT */
    public static final MetadataField<Boolean> f4159PT = new C0500b("isTrashable", 4400000);

    /* renamed from: PU */
    public static final MetadataField<Boolean> f4160PU = new C0500b("isViewed", 4300000);

    /* renamed from: PV */
    public static final C1399c f4161PV = new C1399c("mimeType", 4100000);

    /* renamed from: PW */
    public static final MetadataField<String> f4162PW = new C0510l("originalFilename", 4300000);

    /* renamed from: PX */
    public static final C0494b<String> f4163PX = new C0509k("ownerNames", 4300000);

    /* renamed from: PY */
    public static final C0511m f4164PY = new C0511m("lastModifyingUser", 6000000);

    /* renamed from: PZ */
    public static final C0511m f4165PZ = new C0511m("sharingUser", 6000000);

    /* renamed from: Qa */
    public static final C1400d f4166Qa = new C1400d("parents", 4100000);

    /* renamed from: Qb */
    public static final C1401e f4167Qb = new C1401e("quotaBytesUsed", 4300000);

    /* renamed from: Qc */
    public static final C1402f f4168Qc = new C1402f("starred", 4100000);

    /* renamed from: Qd */
    public static final MetadataField<C0294a> f4169Qd = new C0508j<C0294a>("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
        /* access modifiers changed from: protected */
        /* renamed from: k */
        public C0294a mo5120c(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    };

    /* renamed from: Qe */
    public static final C1403g f4170Qe = new C1403g(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);

    /* renamed from: Qf */
    public static final C1404h f4171Qf = new C1404h("trashed", 4100000);

    /* renamed from: Qg */
    public static final MetadataField<String> f4172Qg = new C0510l("webContentLink", 4300000);

    /* renamed from: Qh */
    public static final MetadataField<String> f4173Qh = new C0510l("webViewLink", 4300000);

    /* renamed from: Qi */
    public static final MetadataField<String> f4174Qi = new C0510l("uniqueIdentifier", 5000000);

    /* renamed from: Qj */
    public static final C0500b f4175Qj = new C0500b("writersCanShare", 6000000);

    /* renamed from: Qk */
    public static final MetadataField<String> f4176Qk = new C0510l("role", 6000000);

    /* renamed from: com.google.android.gms.internal.kd$a */
    public static class C1397a extends C1405ke implements SearchableMetadataField<AppVisibleCustomProperties> {
        public C1397a(int i) {
            super(i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kd$b */
    public static class C1398b extends C0500b implements SearchableMetadataField<Boolean> {
        public C1398b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kd$c */
    public static class C1399c extends C0510l implements SearchableMetadataField<String> {
        public C1399c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kd$d */
    public static class C1400d extends C0507i<DriveId> implements SearchableCollectionMetadataField<DriveId> {
        public C1400d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kd$e */
    public static class C1401e extends C0505g implements SortableMetadataField<Long> {
        public C1401e(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kd$f */
    public static class C1402f extends C0500b implements SearchableMetadataField<Boolean> {
        public C1402f(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kd$g */
    public static class C1403g extends C0510l implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public C1403g(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.kd$h */
    public static class C1404h extends C0500b implements SearchableMetadataField<Boolean> {
        public C1404h(String str, int i) {
            super(str, i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public Boolean mo5120c(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.mo4305b(getName(), i, i2) != 0);
        }
    }
}
