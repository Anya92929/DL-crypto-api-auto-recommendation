package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataBuffer;

public final class MilestoneBuffer extends DataBuffer<Milestone> {
    public Milestone get(int position) {
        return new MilestoneRef(this.f667IC, position);
    }
}
