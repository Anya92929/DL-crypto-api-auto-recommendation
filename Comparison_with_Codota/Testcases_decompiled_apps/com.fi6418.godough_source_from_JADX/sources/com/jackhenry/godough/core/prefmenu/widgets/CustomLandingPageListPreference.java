package com.jackhenry.godough.core.prefmenu.widgets;

import android.content.Context;
import android.support.p003v7.preference.ListPreference;
import android.util.AttributeSet;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GodoughMenuItem;
import java.util.ArrayList;
import java.util.List;

public class CustomLandingPageListPreference extends ListPreference {

    /* renamed from: a */
    private CharSequence[] f6605a;

    /* renamed from: b */
    private CharSequence[] f6606b;

    public CustomLandingPageListPreference(Context context) {
        super(context, (AttributeSet) null, 16842894);
        setKey(getContext().getString(C1506am.preferences_custom_landing_page_key));
        m6649j();
    }

    public CustomLandingPageListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6649j();
    }

    public CustomLandingPageListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6649j();
    }

    public CustomLandingPageListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m6649j();
    }

    /* renamed from: j */
    private void m6649j() {
        m6650k();
        setDialogTitle((CharSequence) getContext().getString(C1506am.preferences_custom_landing_page_dialog_title, new Object[]{GoDoughApp.getUserSettings().getUserMenu().getPreferences().getCustomLaunchPage().getText()}));
    }

    /* renamed from: k */
    private void m6650k() {
        List<GodoughMenuItem> menuItems = GoDoughApp.getUserSettings().getUserMenu().getMenuItems();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (GodoughMenuItem next : menuItems) {
            if (next.isEnabled()) {
                arrayList.add(next.getText());
                arrayList2.add(String.valueOf(next.getType().ordinal()));
            }
        }
        this.f6605a = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
        this.f6606b = (CharSequence[]) arrayList2.toArray(new CharSequence[arrayList2.size()]);
        setEntries(this.f6605a);
        setEntryValues(this.f6606b);
    }

    /* renamed from: l */
    private void m6651l() {
        if (getValue() != null) {
            String menuLabel = GodoughMenuItem.getMenuLabel(GodoughMenuItem.Type.values()[Integer.valueOf(getValue()).intValue()]);
            setSummary(getContext().getString(C1506am.preferences_current_page, new Object[]{menuLabel}) + GoDoughApp.getUserSettings().getUserMenu().getPreferences().getCustomLaunchPage().getDescription());
            return;
        }
        setSummary(GoDoughApp.getUserSettings().getUserMenu().getPreferences().getCustomLaunchPage().getDescription());
    }

    public CharSequence[] getEntries() {
        return super.getEntries();
    }

    public CharSequence[] getEntryValues() {
        return super.getEntryValues();
    }

    public CharSequence getTitle() {
        return GoDoughApp.getUserSettings().getUserMenu().getPreferences().getCustomLaunchPage().getText();
    }

    public void setValue(String str) {
        super.setValue(str);
        m6651l();
    }
}
