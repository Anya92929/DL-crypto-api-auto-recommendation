package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class RequestType {
    private RequestType() {
    }

    /* renamed from: dH */
    public static String m3519dH(int i) {
        switch (i) {
            case 1:
                return "GIFT";
            case 2:
                return "WISH";
            default:
                GamesLog.m2554q("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
