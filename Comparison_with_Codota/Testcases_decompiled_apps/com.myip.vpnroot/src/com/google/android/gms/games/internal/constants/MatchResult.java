package com.google.android.gms.games.internal.constants;

public final class MatchResult {
    public static boolean isValid(int result) {
        switch (result) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }
}
