package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;

public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator<RealTimeMessage>() {
        /* renamed from: cn */
        public RealTimeMessage createFromParcel(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        /* renamed from: dU */
        public RealTimeMessage[] newArray(int i) {
            return new RealTimeMessage[i];
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String aca;
    private final byte[] acb;
    private final int acc;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.aca = (String) C0348n.m861i(senderParticipantId);
        this.acb = (byte[]) ((byte[]) C0348n.m861i(messageData)).clone();
        this.acc = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.acb;
    }

    public String getSenderParticipantId() {
        return this.aca;
    }

    public boolean isReliable() {
        return this.acc == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.aca);
        parcel.writeByteArray(this.acb);
        parcel.writeInt(this.acc);
    }
}
