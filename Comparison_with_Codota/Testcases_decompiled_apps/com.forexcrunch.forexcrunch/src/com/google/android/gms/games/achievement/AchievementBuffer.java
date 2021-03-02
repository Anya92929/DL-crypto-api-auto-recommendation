package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.common.data.DataBuffer;

public final class AchievementBuffer extends DataBuffer<Achievement> {
    public AchievementBuffer(C0344d dataHolder) {
        super(dataHolder);
    }

    public Achievement get(int position) {
        return new C0379a(this.f792S, position);
    }
}
