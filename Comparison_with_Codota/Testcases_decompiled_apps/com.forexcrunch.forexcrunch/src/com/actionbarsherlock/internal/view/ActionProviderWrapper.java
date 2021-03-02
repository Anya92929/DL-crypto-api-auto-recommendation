package com.actionbarsherlock.internal.view;

import android.content.Context;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;
import com.actionbarsherlock.internal.view.menu.SubMenuWrapper;

public class ActionProviderWrapper extends ActionProvider {
    private final com.actionbarsherlock.view.ActionProvider mProvider;

    public ActionProviderWrapper(com.actionbarsherlock.view.ActionProvider provider) {
        super((Context) null);
        this.mProvider = provider;
    }

    public com.actionbarsherlock.view.ActionProvider unwrap() {
        return this.mProvider;
    }

    public View onCreateActionView() {
        return this.mProvider.onCreateActionView();
    }

    public boolean hasSubMenu() {
        return this.mProvider.hasSubMenu();
    }

    public boolean onPerformDefaultAction() {
        return this.mProvider.onPerformDefaultAction();
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        this.mProvider.onPrepareSubMenu(new SubMenuWrapper(subMenu));
    }
}
