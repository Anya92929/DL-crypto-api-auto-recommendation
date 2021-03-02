package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public interface Participant extends Parcelable, Freezable<Participant> {
    public static final int STATUS_DECLINED = 3;
    public static final int STATUS_INVITED = 1;
    public static final int STATUS_JOINED = 2;
    public static final int STATUS_LEFT = 4;

    /* renamed from: ci */
    String mo3892ci();

    int getCapabilities();

    String getDisplayName();

    void getDisplayName(CharArrayBuffer charArrayBuffer);

    Uri getHiResImageUri();

    Uri getIconImageUri();

    String getParticipantId();

    Player getPlayer();

    int getStatus();

    boolean isConnectedToRoom();
}
