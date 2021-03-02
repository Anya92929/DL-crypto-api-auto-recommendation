package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.games.Player;
import java.util.ArrayList;

public final class ParticipantUtils {
    private ParticipantUtils() {
    }

    /* renamed from: bS */
    public static boolean m3698bS(String str) {
        C0348n.m857b(str, (Object) "Participant ID must not be null");
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
