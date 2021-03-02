package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.C0411dm;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {

    /* renamed from: nM */
    private final String f522nM;

    /* renamed from: nR */
    private final int f523nR;

    /* renamed from: od */
    private final RoomUpdateListener f524od;

    /* renamed from: oe */
    private final RoomStatusUpdateListener f525oe;

    /* renamed from: of */
    private final RealTimeMessageReceivedListener f526of;

    /* renamed from: og */
    private final String[] f527og;

    /* renamed from: oh */
    private final Bundle f528oh;

    /* renamed from: oi */
    private final boolean f529oi;

    public static final class Builder {

        /* renamed from: nR */
        int f530nR;

        /* renamed from: od */
        final RoomUpdateListener f531od;

        /* renamed from: oe */
        RoomStatusUpdateListener f532oe;

        /* renamed from: of */
        RealTimeMessageReceivedListener f533of;

        /* renamed from: oh */
        Bundle f534oh;

        /* renamed from: oi */
        boolean f535oi;

        /* renamed from: oj */
        String f536oj;

        /* renamed from: ok */
        ArrayList<String> f537ok;

        private Builder(RoomUpdateListener updateListener) {
            this.f536oj = null;
            this.f530nR = -1;
            this.f537ok = new ArrayList<>();
            this.f535oi = false;
            this.f531od = (RoomUpdateListener) C0411dm.m940a(updateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> playerIds) {
            C0411dm.m944e(playerIds);
            this.f537ok.addAll(playerIds);
            return this;
        }

        public Builder addPlayersToInvite(String... playerIds) {
            C0411dm.m944e(playerIds);
            this.f537ok.addAll(Arrays.asList(playerIds));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.f534oh = autoMatchCriteria;
            return this;
        }

        public Builder setInvitationIdToAccept(String invitationId) {
            C0411dm.m944e(invitationId);
            this.f536oj = invitationId;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener listener) {
            this.f533of = listener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener listener) {
            this.f532oe = listener;
            return this;
        }

        public Builder setSocketCommunicationEnabled(boolean enableSockets) {
            this.f535oi = enableSockets;
            return this;
        }

        public Builder setVariant(int variant) {
            this.f530nR = variant;
            return this;
        }
    }

    private RoomConfig(Builder builder) {
        this.f524od = builder.f531od;
        this.f525oe = builder.f532oe;
        this.f526of = builder.f533of;
        this.f522nM = builder.f536oj;
        this.f523nR = builder.f530nR;
        this.f528oh = builder.f534oh;
        this.f529oi = builder.f535oi;
        this.f527og = (String[]) builder.f537ok.toArray(new String[builder.f537ok.size()]);
        if (this.f526of == null) {
            C0411dm.m941a(this.f529oi, (Object) "Must either enable sockets OR specify a message listener");
        }
    }

    public static Builder builder(RoomUpdateListener listener) {
        return new Builder(listener);
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(GamesClient.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(GamesClient.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(GamesClient.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public Bundle getAutoMatchCriteria() {
        return this.f528oh;
    }

    public String getInvitationId() {
        return this.f522nM;
    }

    public String[] getInvitedPlayerIds() {
        return this.f527og;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.f526of;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.f525oe;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.f524od;
    }

    public int getVariant() {
        return this.f523nR;
    }

    public boolean isSocketEnabled() {
        return this.f529oi;
    }
}
