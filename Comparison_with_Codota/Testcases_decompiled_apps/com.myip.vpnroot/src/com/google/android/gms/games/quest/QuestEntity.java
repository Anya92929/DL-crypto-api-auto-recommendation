package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.C1386jv;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final QuestEntityCreator CREATOR = new QuestEntityCreator();

    /* renamed from: BR */
    private final int f2379BR;

    /* renamed from: FD */
    private final int f2380FD;

    /* renamed from: Tg */
    private final String f2381Tg;

    /* renamed from: VZ */
    private final long f2382VZ;
    private final GameEntity aan;
    private final String acG;
    private final long acH;
    private final Uri acI;
    private final String acJ;
    private final long acK;
    private final Uri acL;
    private final String acM;
    private final long acN;
    private final long acO;
    private final ArrayList<MilestoneEntity> acP;
    private final String mName;
    private final int mState;

    QuestEntity(int versionCode, GameEntity game, String questId, long acceptedTimestamp, Uri bannerImageUri, String bannerImageUrl, String description, long endTimestamp, long lastUpdatedTimestamp, Uri iconImageUri, String iconImageUrl, String name, long notifyTimestamp, long startTimestamp, int state, int type, ArrayList<MilestoneEntity> milestones) {
        this.f2379BR = versionCode;
        this.aan = game;
        this.acG = questId;
        this.acH = acceptedTimestamp;
        this.acI = bannerImageUri;
        this.acJ = bannerImageUrl;
        this.f2381Tg = description;
        this.acK = endTimestamp;
        this.f2382VZ = lastUpdatedTimestamp;
        this.acL = iconImageUri;
        this.acM = iconImageUrl;
        this.mName = name;
        this.acN = notifyTimestamp;
        this.acO = startTimestamp;
        this.mState = state;
        this.f2380FD = type;
        this.acP = milestones;
    }

    public QuestEntity(Quest quest) {
        this.f2379BR = 2;
        this.aan = new GameEntity(quest.getGame());
        this.acG = quest.getQuestId();
        this.acH = quest.getAcceptedTimestamp();
        this.f2381Tg = quest.getDescription();
        this.acI = quest.getBannerImageUri();
        this.acJ = quest.getBannerImageUrl();
        this.acK = quest.getEndTimestamp();
        this.acL = quest.getIconImageUri();
        this.acM = quest.getIconImageUrl();
        this.f2382VZ = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.acN = quest.mo7731lI();
        this.acO = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.f2380FD = quest.getType();
        List<Milestone> lH = quest.mo7730lH();
        int size = lH.size();
        this.acP = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.acP.add((MilestoneEntity) lH.get(i).freeze());
        }
    }

    /* renamed from: a */
    static int m3741a(Quest quest) {
        return C0345m.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.mo7730lH(), quest.getName(), Long.valueOf(quest.mo7731lI()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    /* renamed from: a */
    static boolean m3742a(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return C0345m.equal(quest2.getGame(), quest.getGame()) && C0345m.equal(quest2.getQuestId(), quest.getQuestId()) && C0345m.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && C0345m.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && C0345m.equal(quest2.getDescription(), quest.getDescription()) && C0345m.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && C0345m.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && C0345m.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && C0345m.equal(quest2.mo7730lH(), quest.mo7730lH()) && C0345m.equal(quest2.getName(), quest.getName()) && C0345m.equal(Long.valueOf(quest2.mo7731lI()), Long.valueOf(quest.mo7731lI())) && C0345m.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && C0345m.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    /* renamed from: b */
    static String m3743b(Quest quest) {
        return C0345m.m848h(quest).mo4549a("Game", quest.getGame()).mo4549a("QuestId", quest.getQuestId()).mo4549a("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).mo4549a("BannerImageUri", quest.getBannerImageUri()).mo4549a("BannerImageUrl", quest.getBannerImageUrl()).mo4549a("Description", quest.getDescription()).mo4549a("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).mo4549a("IconImageUri", quest.getIconImageUri()).mo4549a("IconImageUrl", quest.getIconImageUrl()).mo4549a("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).mo4549a("Milestones", quest.mo7730lH()).mo4549a("Name", quest.getName()).mo4549a("NotifyTimestamp", Long.valueOf(quest.mo7731lI())).mo4549a("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).mo4549a("State", Integer.valueOf(quest.getState())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3742a(this, obj);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.acH;
    }

    public Uri getBannerImageUri() {
        return this.acI;
    }

    public String getBannerImageUrl() {
        return this.acJ;
    }

    public Milestone getCurrentMilestone() {
        return mo7730lH().get(0);
    }

    public String getDescription() {
        return this.f2381Tg;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.f2381Tg, dataOut);
    }

    public long getEndTimestamp() {
        return this.acK;
    }

    public Game getGame() {
        return this.aan;
    }

    public Uri getIconImageUri() {
        return this.acL;
    }

    public String getIconImageUrl() {
        return this.acM;
    }

    public long getLastUpdatedTimestamp() {
        return this.f2382VZ;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        C1386jv.m5216b(this.mName, dataOut);
    }

    public String getQuestId() {
        return this.acG;
    }

    public long getStartTimestamp() {
        return this.acO;
    }

    public int getState() {
        return this.mState;
    }

    public int getType() {
        return this.f2380FD;
    }

    public int getVersionCode() {
        return this.f2379BR;
    }

    public int hashCode() {
        return m3741a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isEndingSoon() {
        return this.acN <= System.currentTimeMillis() + 1800000;
    }

    /* renamed from: lH */
    public List<Milestone> mo7730lH() {
        return new ArrayList(this.acP);
    }

    /* renamed from: lI */
    public long mo7731lI() {
        return this.acN;
    }

    public String toString() {
        return m3743b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        QuestEntityCreator.m3746a(this, out, flags);
    }
}
