package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0294a;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChange();

    /* renamed from: BR */
    private final int f2390BR;

    /* renamed from: Tg */
    private final String f2391Tg;
    private final Long acY;
    private final Uri acZ;
    private C0294a ada;

    public static final class Builder {

        /* renamed from: Tg */
        private String f2392Tg;
        private Uri acZ;
        private Long adb;
        private C0294a adc;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChange(this.f2392Tg, this.adb, this.adc, this.acZ);
        }

        public Builder fromMetadata(SnapshotMetadata metadata) {
            this.f2392Tg = metadata.getDescription();
            this.adb = Long.valueOf(metadata.getPlayedTime());
            if (this.adb.longValue() == -1) {
                this.adb = null;
            }
            this.acZ = metadata.getCoverImageUri();
            if (this.acZ != null) {
                this.adc = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap coverImage) {
            this.adc = new C0294a(coverImage);
            this.acZ = null;
            return this;
        }

        public Builder setDescription(String description) {
            this.f2392Tg = description;
            return this;
        }

        public Builder setPlayedTimeMillis(long playedTimeMillis) {
            this.adb = Long.valueOf(playedTimeMillis);
            return this;
        }
    }

    SnapshotMetadataChange() {
        this(4, (String) null, (Long) null, (C0294a) null, (Uri) null);
    }

    SnapshotMetadataChange(int versionCode, String description, Long playedTimeMillis, C0294a coverImage, Uri coverImageUri) {
        boolean z = true;
        this.f2390BR = versionCode;
        this.f2391Tg = description;
        this.acY = playedTimeMillis;
        this.ada = coverImage;
        this.acZ = coverImageUri;
        if (this.ada != null) {
            C0348n.m852a(this.acZ != null ? false : z, "Cannot set both a URI and an image");
        } else if (this.acZ != null) {
            C0348n.m852a(this.ada != null ? false : z, "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChange(String description, Long playedTimeMillis, C0294a coverImage, Uri coverImageUri) {
        this(4, description, playedTimeMillis, coverImage, coverImageUri);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        if (this.ada == null) {
            return null;
        }
        return this.ada.mo4327gx();
    }

    public Uri getCoverImageUri() {
        return this.acZ;
    }

    public String getDescription() {
        return this.f2391Tg;
    }

    public Long getPlayedTimeMillis() {
        return this.acY;
    }

    public int getVersionCode() {
        return this.f2390BR;
    }

    /* renamed from: lK */
    public C0294a mo7805lK() {
        return this.ada;
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.m3766a(this, out, flags);
    }
}
