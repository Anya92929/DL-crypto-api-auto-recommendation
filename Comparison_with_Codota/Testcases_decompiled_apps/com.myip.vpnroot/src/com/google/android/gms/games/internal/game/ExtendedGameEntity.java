package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
    public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();

    /* renamed from: BR */
    private final int f2334BR;
    private final GameEntity aan;
    private final int aao;
    private final boolean aap;
    private final int aaq;
    private final long aar;
    private final long aas;
    private final String aat;
    private final long aau;
    private final String aav;
    private final ArrayList<GameBadgeEntity> aaw;
    private final SnapshotMetadataEntity aax;

    static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
        ExtendedGameEntityCreatorCompat() {
        }

        /* renamed from: cg */
        public ExtendedGameEntity createFromParcel(Parcel parcel) {
            if (ExtendedGameEntity.m2548c(ExtendedGameEntity.m686gP()) || ExtendedGameEntity.m684aV(ExtendedGameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity createFromParcel = GameEntity.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() == 1;
            int readInt2 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            long readLong3 = parcel.readLong();
            String readString2 = parcel.readString();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(GameBadgeEntity.CREATOR.createFromParcel(parcel));
            }
            return new ExtendedGameEntity(2, createFromParcel, readInt, z, readInt2, readLong, readLong2, readString, readLong3, readString2, arrayList, (SnapshotMetadataEntity) null);
        }
    }

    ExtendedGameEntity(int versionCode, GameEntity game, int availability, boolean owned, int achievementUnlockedCount, long lastPlayedServerTimestamp, long priceMicros, String formattedPrice, long fullPriceMicros, String formattedFullPrice, ArrayList<GameBadgeEntity> badges, SnapshotMetadataEntity snapshot) {
        this.f2334BR = versionCode;
        this.aan = game;
        this.aao = availability;
        this.aap = owned;
        this.aaq = achievementUnlockedCount;
        this.aar = lastPlayedServerTimestamp;
        this.aas = priceMicros;
        this.aat = formattedPrice;
        this.aau = fullPriceMicros;
        this.aav = formattedFullPrice;
        this.aaw = badges;
        this.aax = snapshot;
    }

    public ExtendedGameEntity(ExtendedGame extendedGame) {
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        this.f2334BR = 2;
        Game game = extendedGame.getGame();
        this.aan = game == null ? null : new GameEntity(game);
        this.aao = extendedGame.mo7324kP();
        this.aap = extendedGame.mo7325kQ();
        this.aaq = extendedGame.mo7326kR();
        this.aar = extendedGame.mo7327kS();
        this.aas = extendedGame.mo7328kT();
        this.aat = extendedGame.mo7329kU();
        this.aau = extendedGame.mo7330kV();
        this.aav = extendedGame.mo7331kW();
        SnapshotMetadata kX = extendedGame.mo7332kX();
        this.aax = kX != null ? new SnapshotMetadataEntity(kX) : snapshotMetadataEntity;
        ArrayList<GameBadge> kO = extendedGame.mo7323kO();
        int size = kO.size();
        this.aaw = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.aaw.add((GameBadgeEntity) kO.get(i).freeze());
        }
    }

    /* renamed from: a */
    static int m3542a(ExtendedGame extendedGame) {
        return C0345m.hashCode(extendedGame.getGame(), Integer.valueOf(extendedGame.mo7324kP()), Boolean.valueOf(extendedGame.mo7325kQ()), Integer.valueOf(extendedGame.mo7326kR()), Long.valueOf(extendedGame.mo7327kS()), Long.valueOf(extendedGame.mo7328kT()), extendedGame.mo7329kU(), Long.valueOf(extendedGame.mo7330kV()), extendedGame.mo7331kW());
    }

    /* renamed from: a */
    static boolean m3543a(ExtendedGame extendedGame, Object obj) {
        if (!(obj instanceof ExtendedGame)) {
            return false;
        }
        if (extendedGame == obj) {
            return true;
        }
        ExtendedGame extendedGame2 = (ExtendedGame) obj;
        return C0345m.equal(extendedGame2.getGame(), extendedGame.getGame()) && C0345m.equal(Integer.valueOf(extendedGame2.mo7324kP()), Integer.valueOf(extendedGame.mo7324kP())) && C0345m.equal(Boolean.valueOf(extendedGame2.mo7325kQ()), Boolean.valueOf(extendedGame.mo7325kQ())) && C0345m.equal(Integer.valueOf(extendedGame2.mo7326kR()), Integer.valueOf(extendedGame.mo7326kR())) && C0345m.equal(Long.valueOf(extendedGame2.mo7327kS()), Long.valueOf(extendedGame.mo7327kS())) && C0345m.equal(Long.valueOf(extendedGame2.mo7328kT()), Long.valueOf(extendedGame.mo7328kT())) && C0345m.equal(extendedGame2.mo7329kU(), extendedGame.mo7329kU()) && C0345m.equal(Long.valueOf(extendedGame2.mo7330kV()), Long.valueOf(extendedGame.mo7330kV())) && C0345m.equal(extendedGame2.mo7331kW(), extendedGame.mo7331kW());
    }

    /* renamed from: b */
    static String m3544b(ExtendedGame extendedGame) {
        return C0345m.m848h(extendedGame).mo4549a("Game", extendedGame.getGame()).mo4549a("Availability", Integer.valueOf(extendedGame.mo7324kP())).mo4549a("Owned", Boolean.valueOf(extendedGame.mo7325kQ())).mo4549a("AchievementUnlockedCount", Integer.valueOf(extendedGame.mo7326kR())).mo4549a("LastPlayedServerTimestamp", Long.valueOf(extendedGame.mo7327kS())).mo4549a("PriceMicros", Long.valueOf(extendedGame.mo7328kT())).mo4549a("FormattedPrice", extendedGame.mo7329kU()).mo4549a("FullPriceMicros", Long.valueOf(extendedGame.mo7330kV())).mo4549a("FormattedFullPrice", extendedGame.mo7331kW()).mo4549a("Snapshot", extendedGame.mo7332kX()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3543a(this, obj);
    }

    public int getVersionCode() {
        return this.f2334BR;
    }

    public int hashCode() {
        return m3542a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: kO */
    public ArrayList<GameBadge> mo7323kO() {
        return new ArrayList<>(this.aaw);
    }

    /* renamed from: kP */
    public int mo7324kP() {
        return this.aao;
    }

    /* renamed from: kQ */
    public boolean mo7325kQ() {
        return this.aap;
    }

    /* renamed from: kR */
    public int mo7326kR() {
        return this.aaq;
    }

    /* renamed from: kS */
    public long mo7327kS() {
        return this.aar;
    }

    /* renamed from: kT */
    public long mo7328kT() {
        return this.aas;
    }

    /* renamed from: kU */
    public String mo7329kU() {
        return this.aat;
    }

    /* renamed from: kV */
    public long mo7330kV() {
        return this.aau;
    }

    /* renamed from: kW */
    public String mo7331kW() {
        return this.aav;
    }

    /* renamed from: kX */
    public SnapshotMetadata mo7332kX() {
        return this.aax;
    }

    /* renamed from: kY */
    public GameEntity getGame() {
        return this.aan;
    }

    /* renamed from: kZ */
    public ExtendedGame freeze() {
        return this;
    }

    public String toString() {
        return m3544b((ExtendedGame) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo4427gQ()) {
            ExtendedGameEntityCreator.m3561a(this, dest, flags);
            return;
        }
        this.aan.writeToParcel(dest, flags);
        dest.writeInt(this.aao);
        dest.writeInt(this.aap ? 1 : 0);
        dest.writeInt(this.aaq);
        dest.writeLong(this.aar);
        dest.writeLong(this.aas);
        dest.writeString(this.aat);
        dest.writeLong(this.aau);
        dest.writeString(this.aav);
        int size = this.aaw.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.aaw.get(i).writeToParcel(dest, flags);
        }
    }
}
