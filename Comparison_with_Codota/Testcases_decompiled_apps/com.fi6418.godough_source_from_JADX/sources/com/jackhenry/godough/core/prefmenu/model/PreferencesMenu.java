package com.jackhenry.godough.core.prefmenu.model;

import com.jackhenry.godough.core.model.GodoughMenuItem;
import com.jackhenry.godough.core.prefmenu.model.PreferenceMenuItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PreferencesMenu extends GodoughMenuItem {
    PreferenceMenuItem launchPage;
    PreferenceMenuItem touchId;

    private static void addItem(PreferenceMenuItem preferenceMenuItem, List<PreferenceMenuItem> list, PreferenceMenuItem.PreferenceMenuType preferenceMenuType) {
        if (preferenceMenuItem != null && preferenceMenuItem.isEnabled()) {
            preferenceMenuItem.setPreferenceMenuType(preferenceMenuType);
            list.add(preferenceMenuItem);
        }
    }

    public PreferenceMenuItem getCustomLaunchPage() {
        return this.launchPage;
    }

    public List<PreferenceMenuItem> getPreferenceMenuItems() {
        ArrayList arrayList = new ArrayList();
        addItem(this.launchPage, arrayList, PreferenceMenuItem.PreferenceMenuType.LAUNCHPAGE);
        Collections.sort(arrayList, new Comparator<GodoughMenuItem>() {
            public int compare(GodoughMenuItem godoughMenuItem, GodoughMenuItem godoughMenuItem2) {
                return Integer.valueOf(godoughMenuItem.getIndex()).compareTo(Integer.valueOf(godoughMenuItem2.getIndex()));
            }
        });
        return arrayList;
    }

    public void setCustomLaunchPage(PreferenceMenuItem preferenceMenuItem) {
        this.launchPage = preferenceMenuItem;
    }
}
