package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;

public final class ParticipantResult implements SafeParcelable {
    public static final ParticipantResultCreator CREATOR = new ParticipantResultCreator();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;

    /* renamed from: BR */
    private final int f2365BR;

    /* renamed from: Xg */
    private final String f2366Xg;
    private final int abY;
    private final int abZ;

    public ParticipantResult(int versionCode, String participantId, int result, int placing) {
        this.f2365BR = versionCode;
        this.f2366Xg = (String) C0348n.m861i(participantId);
        C0348n.m850I(MatchResult.isValid(result));
        this.abY = result;
        this.abZ = placing;
    }

    public ParticipantResult(String participantId, int result, int placing) {
        this(1, participantId, result, placing);
    }

    public int describeContents() {
        return 0;
    }

    public String getParticipantId() {
        return this.f2366Xg;
    }

    public int getPlacing() {
        return this.abZ;
    }

    public int getResult() {
        return this.abY;
    }

    public int getVersionCode() {
        return this.f2365BR;
    }

    public void writeToParcel(Parcel out, int flags) {
        ParticipantResultCreator.m3697a(this, out, flags);
    }
}
