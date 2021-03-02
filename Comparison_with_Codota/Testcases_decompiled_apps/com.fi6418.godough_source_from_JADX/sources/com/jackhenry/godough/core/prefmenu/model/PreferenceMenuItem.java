package com.jackhenry.godough.core.prefmenu.model;

import com.jackhenry.godough.core.model.GodoughMenuItem;

public class PreferenceMenuItem extends GodoughMenuItem {
    private String description;
    private PreferenceMenuType preferenceMenuType;

    public enum PreferenceMenuType {
        LAUNCHPAGE,
        TOUCHID
    }

    public String getDescription() {
        return this.description;
    }

    public PreferenceMenuType getPreferenceMenuType() {
        return this.preferenceMenuType;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setPreferenceMenuType(PreferenceMenuType preferenceMenuType2) {
        this.preferenceMenuType = preferenceMenuType2;
    }
}
