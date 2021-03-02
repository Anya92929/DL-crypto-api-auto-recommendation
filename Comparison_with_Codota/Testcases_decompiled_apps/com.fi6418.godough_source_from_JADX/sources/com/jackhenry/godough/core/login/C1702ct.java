package com.jackhenry.godough.core.login;

import android.content.Context;
import com.jackhenry.godough.core.C1752m;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.Settings;
import com.jackhenry.godough.core.rda.C1808ad;

/* renamed from: com.jackhenry.godough.core.login.ct */
public class C1702ct extends C1752m<Settings> {
    public C1702ct(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public Settings mo9582j() {
        C1808ad.m6711a(GoDoughApp.getApp()).mo11013a(GoDoughApp.getApp().getFilesDir().getAbsolutePath(), GoDoughApp.getApp());
        C1689cg cgVar = new C1689cg();
        Settings i = cgVar.mo10011i();
        String actionItemColor = i.getActionItemColor();
        String mainColor = i.getMainColor();
        if (actionItemColor != null) {
            if (actionItemColor.indexOf("#") < 0) {
                actionItemColor = "#" + actionItemColor;
            }
            i.setActionItemColor(actionItemColor);
        }
        if (mainColor != null) {
            i.setMainColor(mainColor.indexOf("#") < 0 ? "#" + mainColor : mainColor);
        }
        i.setNotifications(cgVar.mo10012j());
        return i;
    }
}
