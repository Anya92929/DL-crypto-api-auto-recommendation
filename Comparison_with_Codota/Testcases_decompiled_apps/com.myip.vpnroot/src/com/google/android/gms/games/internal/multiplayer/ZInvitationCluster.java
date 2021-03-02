package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();

    /* renamed from: BR */
    private final int f2340BR;
    private final ArrayList<InvitationEntity> aaA;

    ZInvitationCluster(int versionCode, ArrayList<InvitationEntity> invitationList) {
        this.f2340BR = versionCode;
        this.aaA = invitationList;
        m3597lg();
    }

    /* renamed from: lg */
    private void m3597lg() {
        C0313a.m678I(!this.aaA.isEmpty());
        Invitation invitation = this.aaA.get(0);
        int size = this.aaA.size();
        for (int i = 1; i < size; i++) {
            C0313a.m679a(invitation.getInviter().equals(this.aaA.get(i).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.aaA.size() != this.aaA.size()) {
            return false;
        }
        int size = this.aaA.size();
        for (int i = 0; i < size; i++) {
            if (!this.aaA.get(i).equals(zInvitationCluster.aaA.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getInvitationId() {
        return this.aaA.get(0).getInvitationId();
    }

    public int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter() {
        return this.aaA.get(0).getInviter();
    }

    public ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode() {
        return this.f2340BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.aaA.toArray());
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: lh */
    public ArrayList<Invitation> mo7396lh() {
        return new ArrayList<>(this.aaA);
    }

    public void writeToParcel(Parcel dest, int flags) {
        InvitationClusterCreator.m3594a(this, dest, flags);
    }
}
