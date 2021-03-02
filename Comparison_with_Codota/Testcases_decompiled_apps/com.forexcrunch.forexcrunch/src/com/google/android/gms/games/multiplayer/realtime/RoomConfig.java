package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.C0621s;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {

    /* renamed from: eF */
    private final String f947eF;

    /* renamed from: eK */
    private final int f948eK;

    /* renamed from: eW */
    private final RoomUpdateListener f949eW;

    /* renamed from: eX */
    private final RoomStatusUpdateListener f950eX;

    /* renamed from: eY */
    private final RealTimeMessageReceivedListener f951eY;

    /* renamed from: eZ */
    private final String[] f952eZ;

    /* renamed from: fa */
    private final Bundle f953fa;

    /* renamed from: fb */
    private final boolean f954fb;

    public static final class Builder {

        /* renamed from: eK */
        int f955eK;

        /* renamed from: eW */
        final RoomUpdateListener f956eW;

        /* renamed from: eX */
        RoomStatusUpdateListener f957eX;

        /* renamed from: eY */
        RealTimeMessageReceivedListener f958eY;

        /* renamed from: fa */
        Bundle f959fa;

        /* renamed from: fb */
        boolean f960fb;

        /* renamed from: fc */
        String f961fc;

        /* renamed from: fd */
        ArrayList<String> f962fd;

        private Builder(RoomUpdateListener updateListener) {
            this.f961fc = null;
            this.f955eK = -1;
            this.f962fd = new ArrayList<>();
            this.f960fb = false;
            this.f956eW = (RoomUpdateListener) C0621s.m1887b(updateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> playerIds) {
            C0621s.m1890d(playerIds);
            this.f962fd.addAll(playerIds);
            return this;
        }

        public Builder addPlayersToInvite(String... playerIds) {
            C0621s.m1890d(playerIds);
            this.f962fd.addAll(Arrays.asList(playerIds));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.f959fa = autoMatchCriteria;
            return this;
        }

        public Builder setInvitationIdToAccept(String invitationId) {
            C0621s.m1890d(invitationId);
            this.f961fc = invitationId;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener listener) {
            this.f958eY = listener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener listener) {
            this.f957eX = listener;
            return this;
        }

        public Builder setSocketCommunicationEnabled(boolean enableSockets) {
            this.f960fb = enableSockets;
            return this;
        }

        public Builder setVariant(int variant) {
            this.f955eK = variant;
            return this;
        }
    }

    private RoomConfig(Builder builder) {
        this.f949eW = builder.f956eW;
        this.f950eX = builder.f957eX;
        this.f951eY = builder.f958eY;
        this.f947eF = builder.f961fc;
        this.f948eK = builder.f955eK;
        this.f953fa = builder.f959fa;
        this.f954fb = builder.f960fb;
        this.f952eZ = (String[]) builder.f962fd.toArray(new String[builder.f962fd.size()]);
        if (this.f951eY == null) {
            C0621s.m1885a(this.f954fb, "Must either enable sockets OR specify a message listener");
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
        return this.f953fa;
    }

    public String getInvitationId() {
        return this.f947eF;
    }

    public String[] getInvitedPlayerIds() {
        return this.f952eZ;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.f951eY;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.f950eX;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.f949eW;
    }

    public int getVariant() {
        return this.f948eK;
    }

    public boolean isSocketEnabled() {
        return this.f954fb;
    }
}
