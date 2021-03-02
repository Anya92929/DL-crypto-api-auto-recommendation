package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {

    /* renamed from: WD */
    private final String f2367WD;
    private final int abS;
    private final RoomUpdateListener acd;
    private final RoomStatusUpdateListener ace;
    private final RealTimeMessageReceivedListener acf;
    private final String[] acg;
    private final Bundle ach;
    private final boolean aci;

    public static final class Builder {
        int abS;
        final RoomUpdateListener acd;
        RoomStatusUpdateListener ace;
        RealTimeMessageReceivedListener acf;
        Bundle ach;
        boolean aci;
        String acj;
        ArrayList<String> ack;

        private Builder(RoomUpdateListener updateListener) {
            this.acj = null;
            this.abS = -1;
            this.ack = new ArrayList<>();
            this.aci = false;
            this.acd = (RoomUpdateListener) C0348n.m857b(updateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> playerIds) {
            C0348n.m861i(playerIds);
            this.ack.addAll(playerIds);
            return this;
        }

        public Builder addPlayersToInvite(String... playerIds) {
            C0348n.m861i(playerIds);
            this.ack.addAll(Arrays.asList(playerIds));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.ach = autoMatchCriteria;
            return this;
        }

        public Builder setInvitationIdToAccept(String invitationId) {
            C0348n.m861i(invitationId);
            this.acj = invitationId;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener listener) {
            this.acf = listener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener listener) {
            this.ace = listener;
            return this;
        }

        public Builder setSocketCommunicationEnabled(boolean enableSockets) {
            this.aci = enableSockets;
            return this;
        }

        public Builder setVariant(int variant) {
            C0348n.m859b(variant == -1 || variant > 0, (Object) "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.abS = variant;
            return this;
        }
    }

    private RoomConfig(Builder builder) {
        this.acd = builder.acd;
        this.ace = builder.ace;
        this.acf = builder.acf;
        this.f2367WD = builder.acj;
        this.abS = builder.abS;
        this.ach = builder.ach;
        this.aci = builder.aci;
        this.acg = (String[]) builder.ack.toArray(new String[builder.ack.size()]);
        if (this.acf == null) {
            C0348n.m852a(this.aci, "Must either enable sockets OR specify a message listener");
        }
    }

    public static Builder builder(RoomUpdateListener listener) {
        return new Builder(listener);
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

    public String getInvitationId() {
        return this.f2367WD;
    }

    public String[] getInvitedPlayerIds() {
        return this.acg;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.acf;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.ace;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.acd;
    }

    public int getVariant() {
        return this.abS;
    }

    public boolean isSocketEnabled() {
        return this.aci;
    }
}
