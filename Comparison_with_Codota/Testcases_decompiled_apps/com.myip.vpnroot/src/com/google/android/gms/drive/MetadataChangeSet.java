package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.C1395kd;
import com.google.android.gms.internal.C1406kf;
import java.util.Date;

public final class MetadataChangeSet {

    /* renamed from: Nl */
    public static final MetadataChangeSet f832Nl = new MetadataChangeSet(MetadataBundle.m1386io());

    /* renamed from: Nm */
    private final MetadataBundle f833Nm;

    public static class Builder {

        /* renamed from: Nm */
        private final MetadataBundle f834Nm = MetadataBundle.m1386io();

        /* renamed from: Nn */
        private AppVisibleCustomProperties.C0498a f835Nn;

        public MetadataChangeSet build() {
            if (this.f835Nn != null) {
                this.f834Nm.mo5135b(C1395kd.f4146PG, this.f835Nn.mo5131im());
            }
            return new MetadataChangeSet(this.f834Nm);
        }

        public Builder setDescription(String description) {
            this.f834Nm.mo5135b(C1395kd.f4147PH, description);
            return this;
        }

        public Builder setIndexableText(String text) {
            this.f834Nm.mo5135b(C1395kd.f4152PM, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.f834Nm.mo5135b(C1406kf.f4178Qm, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.f834Nm.mo5135b(C1395kd.f4161PV, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.f834Nm.mo5135b(C1395kd.f4156PQ, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.f834Nm.mo5135b(C1395kd.f4168Qc, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.f834Nm.mo5135b(C1395kd.f4170Qe, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.f834Nm.mo5135b(C1395kd.f4160PU, Boolean.valueOf(viewed));
            return this;
        }
    }

    public MetadataChangeSet(MetadataBundle bag) {
        this.f833Nm = MetadataBundle.m1385a(bag);
    }

    public String getDescription() {
        return (String) this.f833Nm.mo5134a(C1395kd.f4147PH);
    }

    public String getIndexableText() {
        return (String) this.f833Nm.mo5134a(C1395kd.f4152PM);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.f833Nm.mo5134a(C1406kf.f4178Qm);
    }

    public String getMimeType() {
        return (String) this.f833Nm.mo5134a(C1395kd.f4161PV);
    }

    public String getTitle() {
        return (String) this.f833Nm.mo5134a(C1395kd.f4170Qe);
    }

    /* renamed from: hS */
    public MetadataBundle mo4681hS() {
        return this.f833Nm;
    }

    public Boolean isPinned() {
        return (Boolean) this.f833Nm.mo5134a(C1395kd.f4156PQ);
    }

    public Boolean isStarred() {
        return (Boolean) this.f833Nm.mo5134a(C1395kd.f4168Qc);
    }

    public Boolean isViewed() {
        return (Boolean) this.f833Nm.mo5134a(C1395kd.f4160PU);
    }
}
