package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();

    /* renamed from: BR */
    private final int f2376BR;

    /* renamed from: Wb */
    private final String f2377Wb;

    /* renamed from: Xj */
    private final String f2378Xj;
    private final long acD;
    private final long acE;
    private final byte[] acF;
    private final int mState;

    MilestoneEntity(int versionCode, String milestoneId, long currentProgress, long targetProgress, byte[] completionBlob, int state, String eventId) {
        this.f2376BR = versionCode;
        this.f2378Xj = milestoneId;
        this.acD = currentProgress;
        this.acE = targetProgress;
        this.acF = completionBlob;
        this.mState = state;
        this.f2377Wb = eventId;
    }

    public MilestoneEntity(Milestone milestone) {
        this.f2376BR = 4;
        this.f2378Xj = milestone.getMilestoneId();
        this.acD = milestone.getCurrentProgress();
        this.acE = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.f2377Wb = milestone.getEventId();
        byte[] completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.acF = null;
            return;
        }
        this.acF = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.acF, 0, completionRewardData.length);
    }

    /* renamed from: a */
    static int m3731a(Milestone milestone) {
        return C0345m.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    /* renamed from: a */
    static boolean m3732a(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return C0345m.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && C0345m.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && C0345m.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && C0345m.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && C0345m.equal(milestone2.getEventId(), milestone.getEventId());
    }

    /* renamed from: b */
    static String m3733b(Milestone milestone) {
        return C0345m.m848h(milestone).mo4549a("MilestoneId", milestone.getMilestoneId()).mo4549a("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).mo4549a("TargetProgress", Long.valueOf(milestone.getTargetProgress())).mo4549a("State", Integer.valueOf(milestone.getState())).mo4549a("CompletionRewardData", milestone.getCompletionRewardData()).mo4549a("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3732a(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.acF;
    }

    public long getCurrentProgress() {
        return this.acD;
    }

    public String getEventId() {
        return this.f2377Wb;
    }

    public String getMilestoneId() {
        return this.f2378Xj;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.acE;
    }

    public int getVersionCode() {
        return this.f2376BR;
    }

    public int hashCode() {
        return m3731a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m3733b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MilestoneEntityCreator.m3734a(this, out, flags);
    }
}
