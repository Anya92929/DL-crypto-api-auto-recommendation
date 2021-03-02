package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GodoughMenuItem;
import com.jackhenry.godough.core.p038e.C1584m;

/* renamed from: com.jackhenry.godough.core.login.ax */
final class C1652ax implements C1653ay {
    C1652ax() {
    }

    /* renamed from: a */
    public void mo9961a() {
        GoDoughApp.setLandingPageType(GodoughMenuItem.Type.values()[Integer.valueOf(new C1584m(GoDoughApp.getApp()).mo9798a(GoDoughApp.getApp().getString(C1506am.preferences_custom_landing_page_key), String.valueOf(GodoughMenuItem.Type.ACCOUNTS.ordinal()))).intValue()]);
    }
}
