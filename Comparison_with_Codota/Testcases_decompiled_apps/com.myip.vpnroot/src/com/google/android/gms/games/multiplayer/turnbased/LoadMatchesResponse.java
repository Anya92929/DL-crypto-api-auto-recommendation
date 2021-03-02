package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer aco;
    private final TurnBasedMatchBuffer acp;
    private final TurnBasedMatchBuffer acq;
    private final TurnBasedMatchBuffer acr;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder a = m3718a(matchData, 0);
        if (a != null) {
            this.aco = new InvitationBuffer(a);
        } else {
            this.aco = null;
        }
        DataHolder a2 = m3718a(matchData, 1);
        if (a2 != null) {
            this.acp = new TurnBasedMatchBuffer(a2);
        } else {
            this.acp = null;
        }
        DataHolder a3 = m3718a(matchData, 2);
        if (a3 != null) {
            this.acq = new TurnBasedMatchBuffer(a3);
        } else {
            this.acq = null;
        }
        DataHolder a4 = m3718a(matchData, 3);
        if (a4 != null) {
            this.acr = new TurnBasedMatchBuffer(a4);
        } else {
            this.acr = null;
        }
    }

    /* renamed from: a */
    private static DataHolder m3718a(Bundle bundle, int i) {
        String dH = TurnBasedMatchTurnStatus.m3521dH(i);
        if (!bundle.containsKey(dH)) {
            return null;
        }
        return (DataHolder) bundle.getParcelable(dH);
    }

    public void close() {
        if (this.aco != null) {
            this.aco.close();
        }
        if (this.acp != null) {
            this.acp.close();
        }
        if (this.acq != null) {
            this.acq.close();
        }
        if (this.acr != null) {
            this.acr.close();
        }
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.acr;
    }

    public InvitationBuffer getInvitations() {
        return this.aco;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.acp;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.acq;
    }

    public boolean hasData() {
        if (this.aco != null && this.aco.getCount() > 0) {
            return true;
        }
        if (this.acp != null && this.acp.getCount() > 0) {
            return true;
        }
        if (this.acq == null || this.acq.getCount() <= 0) {
            return this.acr != null && this.acr.getCount() > 0;
        }
        return true;
    }
}
