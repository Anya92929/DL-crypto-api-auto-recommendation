package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.C0384db;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.internal.C0437eg;
import com.google.android.gms.internal.C0487en;

public final class PlayerEntity extends C0487en implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new C0173a();

    /* renamed from: iM */
    private final int f472iM;

    /* renamed from: mD */
    private final String f473mD;

    /* renamed from: mE */
    private final long f474mE;

    /* renamed from: ml */
    private final String f475ml;

    /* renamed from: mq */
    private final Uri f476mq;

    /* renamed from: mr */
    private final Uri f477mr;

    /* renamed from: com.google.android.gms.games.PlayerEntity$a */
    static final class C0173a extends C0177c {
        C0173a() {
        }

        /* renamed from: u */
        public PlayerEntity createFromParcel(Parcel parcel) {
            Uri uri = null;
            if (PlayerEntity.m1237c(PlayerEntity.m836aW()) || PlayerEntity.m837y(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            if (readString4 != null) {
                uri = Uri.parse(readString4);
            }
            return new PlayerEntity(1, readString, readString2, parse, uri, parcel.readLong());
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp) {
        this.f472iM = versionCode;
        this.f473mD = playerId;
        this.f475ml = displayName;
        this.f476mq = iconImageUri;
        this.f477mr = hiResImageUri;
        this.f474mE = retrievedTimestamp;
    }

    public PlayerEntity(Player player) {
        boolean z = true;
        this.f472iM = 1;
        this.f473mD = player.getPlayerId();
        this.f475ml = player.getDisplayName();
        this.f476mq = player.getIconImageUri();
        this.f477mr = player.getHiResImageUri();
        this.f474mE = player.getRetrievedTimestamp();
        C0384db.m830c(this.f473mD);
        C0384db.m830c(this.f475ml);
        C0384db.m831k(this.f474mE <= 0 ? false : z);
    }

    /* renamed from: a */
    static int m391a(Player player) {
        return C0408dl.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()));
    }

    /* renamed from: a */
    static boolean m392a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return C0408dl.equal(player2.getPlayerId(), player.getPlayerId()) && C0408dl.equal(player2.getDisplayName(), player.getDisplayName()) && C0408dl.equal(player2.getIconImageUri(), player.getIconImageUri()) && C0408dl.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && C0408dl.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp()));
    }

    /* renamed from: b */
    static String m393b(Player player) {
        return C0408dl.m938d(player).mo4388a("PlayerId", player.getPlayerId()).mo4388a("DisplayName", player.getDisplayName()).mo4388a("IconImageUri", player.getIconImageUri()).mo4388a("HiResImageUri", player.getHiResImageUri()).mo4388a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m392a(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.f475ml;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C0437eg.m1081b(this.f475ml, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.f477mr;
    }

    public Uri getIconImageUri() {
        return this.f476mq;
    }

    public String getPlayerId() {
        return this.f473mD;
    }

    public long getRetrievedTimestamp() {
        return this.f474mE;
    }

    public int getVersionCode() {
        return this.f472iM;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return m391a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m393b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (!mo4323aX()) {
            C0177c.m400a(this, dest, flags);
            return;
        }
        dest.writeString(this.f473mD);
        dest.writeString(this.f475ml);
        dest.writeString(this.f476mq == null ? null : this.f476mq.toString());
        if (this.f477mr != null) {
            str = this.f477mr.toString();
        }
        dest.writeString(str);
        dest.writeLong(this.f474mE);
    }
}
