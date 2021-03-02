package com.google.android.gms.games.multiplayer;

import com.google.android.gms.games.Player;
import com.google.android.gms.internal.C0411dm;
import java.util.ArrayList;

public final class ParticipantUtils {
    private ParticipantUtils() {
    }

    /* renamed from: Q */
    public static boolean m434Q(String str) {
        C0411dm.m940a(str, (Object) "Participant ID must not be null");
        return str.startsWith("p_");
    }

    public static String getParticipantId(ArrayList<Participant> participants, String playerId) {
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(playerId)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }
}
