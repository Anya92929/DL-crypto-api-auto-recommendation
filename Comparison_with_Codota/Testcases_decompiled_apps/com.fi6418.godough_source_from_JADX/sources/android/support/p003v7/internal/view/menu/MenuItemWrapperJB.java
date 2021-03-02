package android.support.p003v7.internal.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.view.ActionProvider;
import android.support.p003v7.internal.view.menu.MenuItemWrapperICS;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
/* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperJB */
class MenuItemWrapperJB extends MenuItemWrapperICS {

    /* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperJB$ActionProviderWrapperJB */
    class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper implements ActionProvider.VisibilityListener {

        /* renamed from: c */
        ActionProvider.VisibilityListener f2165c;

        public ActionProviderWrapperJB(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean isVisible() {
            return this.f2160a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f2165c != null) {
                this.f2165c.onActionProviderVisibilityChanged(z);
            }
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.f2160a.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.f2160a.overridesItemVisibility();
        }

        public void refreshVisibility() {
            this.f2160a.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.f2165c = visibilityListener;
            android.view.ActionProvider actionProvider = this.f2160a;
            if (visibilityListener == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }
    }

    MenuItemWrapperJB(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public MenuItemWrapperICS.ActionProviderWrapper mo4215a(android.view.ActionProvider actionProvider) {
        return new ActionProviderWrapperJB(this.f2070a, actionProvider);
    }
}
