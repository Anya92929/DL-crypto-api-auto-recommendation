package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();

    /* renamed from: BR */
    private final int f2335BR;

    /* renamed from: FD */
    private int f2336FD;

    /* renamed from: No */
    private String f2337No;

    /* renamed from: Tg */
    private String f2338Tg;

    /* renamed from: UW */
    private Uri f2339UW;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        /* renamed from: ch */
        public GameBadgeEntity createFromParcel(Parcel parcel) {
            if (GameBadgeEntity.m2548c(GameBadgeEntity.m686gP()) || GameBadgeEntity.m684aV(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    GameBadgeEntity(int versionCode, int type, String title, String description, Uri iconImageUri) {
        this.f2335BR = versionCode;
        this.f2336FD = type;
        this.f2337No = title;
        this.f2338Tg = description;
        this.f2339UW = iconImageUri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.f2335BR = 1;
        this.f2336FD = gameBadge.getType();
        this.f2337No = gameBadge.getTitle();
        this.f2338Tg = gameBadge.getDescription();
        this.f2339UW = gameBadge.getIconImageUri();
    }

    /* renamed from: a */
    static int m3576a(GameBadge gameBadge) {
        return C0345m.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    /* renamed from: a */
    static boolean m3577a(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return C0345m.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && C0345m.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    /* renamed from: b */
    static String m3578b(GameBadge gameBadge) {
        return C0345m.m848h(gameBadge).mo4549a("Type", Integer.valueOf(gameBadge.getType())).mo4549a("Title", gameBadge.getTitle()).mo4549a("Description", gameBadge.getDescription()).mo4549a("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3577a(this, obj);
    }

    public String getDescription() {
        return this.f2338Tg;
    }

    public Uri getIconImageUri() {
        return this.f2339UW;
    }

    public String getTitle() {
        return this.f2337No;
    }

    public int getType() {
        return this.f2336FD;
    }

    public int getVersionCode() {
        return this.f2335BR;
    }

    public int hashCode() {
        return m3576a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: la */
    public GameBadge freeze() {
        return this;
    }

    public String toString() {
        return m3578b((GameBadge) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo4427gQ()) {
            GameBadgeEntityCreator.m3584a(this, dest, flags);
            return;
        }
        dest.writeInt(this.f2336FD);
        dest.writeString(this.f2337No);
        dest.writeString(this.f2338Tg);
        dest.writeString(this.f2339UW == null ? null : this.f2339UW.toString());
    }
}
