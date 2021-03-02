package com.jackhenry.godough.core.prefmenu;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1508ao;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GodoughMenuItem;
import com.jackhenry.godough.core.p038e.C1584m;
import com.jackhenry.godough.core.prefmenu.model.PreferenceMenuItem;
import com.jackhenry.godough.core.prefmenu.widgets.CustomLandingPageListPreference;
import java.util.Iterator;

/* renamed from: com.jackhenry.godough.core.prefmenu.a */
public class C1798a extends PreferenceFragmentCompat {
    /* renamed from: n */
    private void m6648n() {
        CustomLandingPageListPreference customLandingPageListPreference;
        Iterator<PreferenceMenuItem> it = GoDoughApp.getUserSettings().getUserMenu().getPreferences().getPreferenceMenuItems().iterator();
        while (it.hasNext()) {
            switch (it.next().getPreferenceMenuType()) {
                case LAUNCHPAGE:
                    customLandingPageListPreference = new CustomLandingPageListPreference(getActivity());
                    customLandingPageListPreference.setIcon(C1493ah.pref_card_icon);
                    break;
                default:
                    customLandingPageListPreference = null;
                    break;
            }
            if (customLandingPageListPreference != null) {
                getPreferenceScreen().addPreference(customLandingPageListPreference);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1584m mVar = new C1584m(getActivity());
        if (mVar.mo9798a(getString(C1506am.preferences_custom_landing_page_key), (String) null) == null) {
            mVar.mo9801b(getString(C1506am.preferences_custom_landing_page_key), String.valueOf(GodoughMenuItem.Type.ACCOUNTS.ordinal()));
        }
        addPreferencesFromResource(C1508ao.preference_custom_landing);
        m6648n();
    }

    public void onCreatePreferences(Bundle bundle, String str) {
    }

    public void onResume() {
        super.onResume();
    }
}
