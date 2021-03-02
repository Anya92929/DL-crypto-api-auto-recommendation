package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.C0411dm;

public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator<RealTimeMessage>() {
        /* renamed from: U */
        public RealTimeMessage[] newArray(int i) {
            return new RealTimeMessage[i];
        }

        /* renamed from: x */
        public RealTimeMessage createFromParcel(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;

    /* renamed from: oa */
    private final String f519oa;

    /* renamed from: ob */
    private final byte[] f520ob;

    /* renamed from: oc */
    private final int f521oc;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.f519oa = (String) C0411dm.m944e(senderParticipantId);
        this.f520ob = (byte[]) ((byte[]) C0411dm.m944e(messageData)).clone();
        this.f521oc = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.f520ob;
    }

    public String getSenderParticipantId() {
        return this.f519oa;
    }

    public boolean isReliable() {
        return this.f521oc == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.f519oa);
        parcel.writeByteArray(this.f520ob);
        parcel.writeInt(this.f521oc);
    }
}
