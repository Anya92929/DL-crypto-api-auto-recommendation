package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.C0621s;

public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator<RealTimeMessage>() {
        /* renamed from: J */
        public RealTimeMessage[] newArray(int i) {
            return new RealTimeMessage[i];
        }

        /* renamed from: r */
        public RealTimeMessage createFromParcel(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;

    /* renamed from: eT */
    private final String f944eT;

    /* renamed from: eU */
    private final byte[] f945eU;

    /* renamed from: eV */
    private final int f946eV;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.f944eT = (String) C0621s.m1890d(senderParticipantId);
        this.f945eU = (byte[]) ((byte[]) C0621s.m1890d(messageData)).clone();
        this.f946eV = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.f945eU;
    }

    public String getSenderParticipantId() {
        return this.f944eT;
    }

    public boolean isReliable() {
        return this.f946eV == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.f944eT);
        parcel.writeByteArray(this.f945eU);
        parcel.writeInt(this.f946eV);
    }
}
