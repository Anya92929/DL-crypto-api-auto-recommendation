package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C1386jv;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();

    /* renamed from: BR */
    private final int f2393BR;

    /* renamed from: No */
    private final String f2394No;

    /* renamed from: Tg */
    private final String f2395Tg;

    /* renamed from: Wx */
    private final String f2396Wx;
    private final GameEntity aan;
    private final Uri acZ;
    private final PlayerEntity add;
    private final String ade;
    private final long adf;
    private final long adg;
    private final float adh;
    private final String adi;

    SnapshotMetadataEntity(int versionCode, GameEntity game, PlayerEntity owner, String snapshotId, Uri coverImageUri, String coverImageUrl, String title, String description, long lastModifiedTimestamp, long playedTime, float coverImageAspectRatio, String uniqueName) {
        this.f2393BR = versionCode;
        this.aan = game;
        this.add = owner;
        this.f2396Wx = snapshotId;
        this.acZ = coverImageUri;
        this.ade = coverImageUrl;
        this.adh = coverImageAspectRatio;
        this.f2394No = title;
        this.f2395Tg = description;
        this.adf = lastModifiedTimestamp;
        this.adg = playedTime;
        this.adi = uniqueName;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.f2393BR = 3;
        this.aan = new GameEntity(snapshotMetadata.getGame());
        this.add = new PlayerEntity(snapshotMetadata.getOwner());
        this.f2396Wx = snapshotMetadata.getSnapshotId();
        this.acZ = snapshotMetadata.getCoverImageUri();
        this.ade = snapshotMetadata.getCoverImageUrl();
        this.adh = snapshotMetadata.getCoverImageAspectRatio();
        this.f2394No = snapshotMetadata.getTitle();
        this.f2395Tg = snapshotMetadata.getDescription();
        this.adf = snapshotMetadata.getLastModifiedTimestamp();
        this.adg = snapshotMetadata.getPlayedTime();
        this.adi = snapshotMetadata.getUniqueName();
    }

    /* renamed from: a */
    static int m3767a(SnapshotMetadata snapshotMetadata) {
        return C0345m.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName());
    }

    /* renamed from: a */
    static boolean m3768a(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return C0345m.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && C0345m.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && C0345m.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && C0345m.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && C0345m.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && C0345m.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && C0345m.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && C0345m.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && C0345m.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && C0345m.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName());
    }

    /* renamed from: b */
    static String m3769b(SnapshotMetadata snapshotMetadata) {
        return C0345m.m848h(snapshotMetadata).mo4549a("Game", snapshotMetadata.getGame()).mo4549a("Owner", snapshotMetadata.getOwner()).mo4549a("SnapshotId", snapshotMetadata.getSnapshotId()).mo4549a("CoverImageUri", snapshotMetadata.getCoverImageUri()).mo4549a("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).mo4549a("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).mo4549a("Description", snapshotMetadata.getDescription()).mo4549a("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).mo4549a("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).mo4549a("UniqueName", snapshotMetadata.getUniqueName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3768a(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.adh;
    }

    public Uri getCoverImageUri() {
        return this.acZ;
    }

    public String getCoverImageUrl() {
        return this.ade;
    }

    public String getDescription() {
        return this.f2395Tg;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f2395Tg, dataOut);
    }

    public Game getGame() {
        return this.aan;
    }

    public long getLastModifiedTimestamp() {
        return this.adf;
    }

    public Player getOwner() {
        return this.add;
    }

    public long getPlayedTime() {
        return this.adg;
    }

    public String getSnapshotId() {
        return this.f2396Wx;
    }

    public String getTitle() {
        return this.f2394No;
    }

    public String getUniqueName() {
        return this.adi;
    }

    public int getVersionCode() {
        return this.f2393BR;
    }

    public int hashCode() {
        return m3767a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m3769b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataEntityCreator.m3770a(this, out, flags);
    }
}
