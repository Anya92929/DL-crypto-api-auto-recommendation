package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames {
    public final String aaH;
    public final String aaI;
    public final String aaJ;
    public final String aaK;
    public final String aaL;
    public final String aaM;
    public final String aaN;
    public final String aaO;
    public final String aaP;
    public final String aaQ;
    public final String aaR;
    public final String aaS;
    public final String aaT;
    public final String aaU;
    public final String aaV;
    public final String aaW;
    public final String aaX;
    public final String aaY;
    public final String aaZ;
    public final String aba;
    public final String abb;
    public final String abc;
    public final String abd;
    public final String abe;
    public final String abf;

    public PlayerColumnNames(String prefix) {
        if (TextUtils.isEmpty(prefix)) {
            this.aaH = "external_player_id";
            this.aaI = "profile_name";
            this.aaJ = "profile_icon_image_uri";
            this.aaK = "profile_icon_image_url";
            this.aaL = "profile_hi_res_image_uri";
            this.aaM = "profile_hi_res_image_url";
            this.aaN = "last_updated";
            this.aaO = "is_in_circles";
            this.aaP = "played_with_timestamp";
            this.aaQ = "current_xp_total";
            this.aaR = "current_level";
            this.aaS = "current_level_min_xp";
            this.aaT = "current_level_max_xp";
            this.aaU = "next_level";
            this.aaV = "next_level_max_xp";
            this.aaW = "last_level_up_timestamp";
            this.aaX = "player_title";
            this.aaY = "has_all_public_acls";
            this.aaZ = "is_profile_visible";
            this.aba = "most_recent_external_game_id";
            this.abb = "most_recent_game_name";
            this.abc = "most_recent_activity_timestamp";
            this.abd = "most_recent_game_icon_uri";
            this.abe = "most_recent_game_hi_res_uri";
            this.abf = "most_recent_game_featured_uri";
            return;
        }
        this.aaH = prefix + "external_player_id";
        this.aaI = prefix + "profile_name";
        this.aaJ = prefix + "profile_icon_image_uri";
        this.aaK = prefix + "profile_icon_image_url";
        this.aaL = prefix + "profile_hi_res_image_uri";
        this.aaM = prefix + "profile_hi_res_image_url";
        this.aaN = prefix + "last_updated";
        this.aaO = prefix + "is_in_circles";
        this.aaP = prefix + "played_with_timestamp";
        this.aaQ = prefix + "current_xp_total";
        this.aaR = prefix + "current_level";
        this.aaS = prefix + "current_level_min_xp";
        this.aaT = prefix + "current_level_max_xp";
        this.aaU = prefix + "next_level";
        this.aaV = prefix + "next_level_max_xp";
        this.aaW = prefix + "last_level_up_timestamp";
        this.aaX = prefix + "player_title";
        this.aaY = prefix + "has_all_public_acls";
        this.aaZ = prefix + "is_profile_visible";
        this.aba = prefix + "most_recent_external_game_id";
        this.abb = prefix + "most_recent_game_name";
        this.abc = prefix + "most_recent_activity_timestamp";
        this.abd = prefix + "most_recent_game_icon_uri";
        this.abe = prefix + "most_recent_game_hi_res_uri";
        this.abf = prefix + "most_recent_game_featured_uri";
    }
}
