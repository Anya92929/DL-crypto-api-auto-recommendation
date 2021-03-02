package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;

public final class TurnBasedMatchConfig {
    private final int abS;
    private final String[] acg;
    private final Bundle ach;
    private final int acs;

    public static final class Builder {
        int abS;
        Bundle ach;
        ArrayList<String> ack;
        int acs;

        private Builder() {
            this.abS = -1;
            this.ack = new ArrayList<>();
            this.ach = null;
            this.acs = 2;
        }

        public Builder addInvitedPlayer(String playerId) {
            C0348n.m861i(playerId);
            this.ack.add(playerId);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> playerIds) {
            C0348n.m861i(playerIds);
            this.ack.addAll(playerIds);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.ach = autoMatchCriteria;
            return this;
        }

        public Builder setVariant(int variant) {
            C0348n.m859b(variant == -1 || variant > 0, (Object) "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.abS = variant;
            return this;
        }
    }

    private TurnBasedMatchConfig(Builder builder) {
        this.abS = builder.abS;
        this.acs = builder.acs;
        this.ach = builder.ach;
        this.acg = (String[]) builder.ack.toArray(new String[builder.ack.size()]);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public Bundle getAutoMatchCriteria() {
        return this.ach;
    }

    public String[] getInvitedPlayerIds() {
        return this.acg;
    }

    public int getVariant() {
        return this.abS;
    }

    /* renamed from: lF */
    public int mo7678lF() {
        return this.acs;
    }
}
