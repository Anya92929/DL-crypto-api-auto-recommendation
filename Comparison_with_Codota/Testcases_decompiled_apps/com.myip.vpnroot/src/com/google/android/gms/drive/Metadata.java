package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.C1395kd;
import com.google.android.gms.internal.C1406kf;
import com.google.android.gms.internal.C1413kh;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract <T> T mo4645a(MetadataField<T> metadataField);

    public String getAlternateLink() {
        return (String) mo4645a(C1395kd.f4145PF);
    }

    public int getContentAvailability() {
        Integer num = (Integer) mo4645a(C1413kh.f4183Qr);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) mo4645a(C1406kf.f4177Ql);
    }

    public String getDescription() {
        return (String) mo4645a(C1395kd.f4147PH);
    }

    public DriveId getDriveId() {
        return (DriveId) mo4645a(C1395kd.f4144PE);
    }

    public String getEmbedLink() {
        return (String) mo4645a(C1395kd.f4148PI);
    }

    public String getFileExtension() {
        return (String) mo4645a(C1395kd.f4149PJ);
    }

    public long getFileSize() {
        return ((Long) mo4645a(C1395kd.f4150PK)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) mo4645a(C1406kf.f4178Qm);
    }

    public String getMimeType() {
        return (String) mo4645a(C1395kd.f4161PV);
    }

    public Date getModifiedByMeDate() {
        return (Date) mo4645a(C1406kf.f4180Qo);
    }

    public Date getModifiedDate() {
        return (Date) mo4645a(C1406kf.f4179Qn);
    }

    public String getOriginalFilename() {
        return (String) mo4645a(C1395kd.f4162PW);
    }

    public long getQuotaBytesUsed() {
        return ((Long) mo4645a(C1395kd.f4167Qb)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) mo4645a(C1406kf.f4181Qp);
    }

    public String getTitle() {
        return (String) mo4645a(C1395kd.f4170Qe);
    }

    public String getWebContentLink() {
        return (String) mo4645a(C1395kd.f4172Qg);
    }

    public String getWebViewLink() {
        return (String) mo4645a(C1395kd.f4173Qh);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) mo4645a(C1395kd.f4155PP);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) mo4645a(C1395kd.f4153PN);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) mo4645a(C1413kh.f4184Qs);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) mo4645a(C1395kd.f4156PQ);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) mo4645a(C1395kd.f4157PR);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) mo4645a(C1395kd.f4158PS);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) mo4645a(C1395kd.f4168Qc);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) mo4645a(C1395kd.f4171Qf);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) mo4645a(C1395kd.f4160PU);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
