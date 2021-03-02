package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public interface ExtendedGame extends Parcelable, Freezable<ExtendedGame> {
    Game getGame();

    /* renamed from: kO */
    ArrayList<GameBadge> mo7323kO();

    /* renamed from: kP */
    int mo7324kP();

    /* renamed from: kQ */
    boolean mo7325kQ();

    /* renamed from: kR */
    int mo7326kR();

    /* renamed from: kS */
    long mo7327kS();

    /* renamed from: kT */
    long mo7328kT();

    /* renamed from: kU */
    String mo7329kU();

    /* renamed from: kV */
    long mo7330kV();

    /* renamed from: kW */
    String mo7331kW();

    /* renamed from: kX */
    SnapshotMetadata mo7332kX();
}
