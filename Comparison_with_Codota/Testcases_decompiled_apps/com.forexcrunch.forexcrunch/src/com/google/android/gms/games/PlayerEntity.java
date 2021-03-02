package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.C0423ao;
import com.google.android.gms.internal.C0473av;
import com.google.android.gms.internal.C0594h;
import com.google.android.gms.internal.C0618r;

public final class PlayerEntity extends C0473av implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new C0377a();

    /* renamed from: ab */
    private final int f898ab;

    /* renamed from: cl */
    private final String f899cl;

    /* renamed from: dk */
    private final Uri f900dk;

    /* renamed from: dl */
    private final Uri f901dl;

    /* renamed from: dx */
    private final String f902dx;

    /* renamed from: dy */
    private final long f903dy;

    /* renamed from: com.google.android.gms.games.PlayerEntity$a */
    static final class C0377a extends C0381c {
        C0377a() {
        }

        /* renamed from: o */
        public PlayerEntity createFromParcel(Parcel parcel) {
            Uri uri = null;
            if (PlayerEntity.m1060c(PlayerEntity.m1785v()) || PlayerEntity.m1783h(PlayerEntity.class.getCanonicalName())) {
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
        this.f898ab = versionCode;
        this.f902dx = playerId;
        this.f899cl = displayName;
        this.f900dk = iconImageUri;
        this.f901dl = hiResImageUri;
        this.f903dy = retrievedTimestamp;
    }

    public PlayerEntity(Player player) {
        boolean z = true;
        this.f898ab = 1;
        this.f902dx = player.getPlayerId();
        this.f899cl = player.getDisplayName();
        this.f900dk = player.getIconImageUri();
        this.f901dl = player.getHiResImageUri();
        this.f903dy = player.getRetrievedTimestamp();
        C0594h.m1779b(this.f902dx);
        C0594h.m1779b(this.f899cl);
        C0594h.m1777a(this.f903dy <= 0 ? false : z);
    }

    /* renamed from: a */
    static int m714a(Player player) {
        return C0618r.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()));
    }

    /* renamed from: a */
    static boolean m715a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return C0618r.m1881a(player2.getPlayerId(), player.getPlayerId()) && C0618r.m1881a(player2.getDisplayName(), player.getDisplayName()) && C0618r.m1881a(player2.getIconImageUri(), player.getIconImageUri()) && C0618r.m1881a(player2.getHiResImageUri(), player.getHiResImageUri()) && C0618r.m1881a(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp()));
    }

    /* renamed from: b */
    static String m717b(Player player) {
        return C0618r.m1882c(player).mo5486a("PlayerId", player.getPlayerId()).mo5486a("DisplayName", player.getDisplayName()).mo5486a("IconImageUri", player.getIconImageUri()).mo5486a("HiResImageUri", player.getHiResImageUri()).mo5486a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m715a(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.f899cl;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C0423ao.m905b(this.f899cl, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.f901dl;
    }

    public Uri getIconImageUri() {
        return this.f900dk;
    }

    public String getPlayerId() {
        return this.f902dx;
    }

    public long getRetrievedTimestamp() {
        return this.f903dy;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return m714a(this);
    }

    /* renamed from: i */
    public int mo4234i() {
        return this.f898ab;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m717b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (!mo5427w()) {
            C0381c.m725a(this, dest, flags);
            return;
        }
        dest.writeString(this.f902dx);
        dest.writeString(this.f899cl);
        dest.writeString(this.f900dk == null ? null : this.f900dk.toString());
        if (this.f901dl != null) {
            str = this.f901dl.toString();
        }
        dest.writeString(str);
        dest.writeLong(this.f903dy);
    }
}
