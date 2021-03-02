package com.unity3d.player.a;

public interface f {

    public enum a {
        INVALID_PACKAGE_NAME,
        NON_MATCHING_UID,
        NOT_MARKET_MANAGED,
        CHECK_IN_PROGRESS,
        INVALID_PUBLIC_KEY,
        MISSING_PERMISSION;

        static {
            INVALID_PACKAGE_NAME = new a("INVALID_PACKAGE_NAME", 0);
            NON_MATCHING_UID = new a("NON_MATCHING_UID", 1);
            NOT_MARKET_MANAGED = new a("NOT_MARKET_MANAGED", 2);
            CHECK_IN_PROGRESS = new a("CHECK_IN_PROGRESS", 3);
            INVALID_PUBLIC_KEY = new a("INVALID_PUBLIC_KEY", 4);
            MISSING_PERMISSION = new a("MISSING_PERMISSION", 5);
            a[] aVarArr = {INVALID_PACKAGE_NAME, NON_MATCHING_UID, NOT_MARKET_MANAGED, CHECK_IN_PROGRESS, INVALID_PUBLIC_KEY, MISSING_PERMISSION};
        }
    }

    void a();

    void b();
}
