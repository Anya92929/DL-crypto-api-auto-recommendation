package android.support.p003v7.internal.view.menu;

import android.support.p000v4.view.ActionProvider;
import android.support.p003v7.internal.view.menu.MenuItemWrapperICS;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperJB */
class MenuItemWrapperJB extends MenuItemWrapperICS {
    MenuItemWrapperJB(MenuItem object) {
        super(object, false);
    }

    /* access modifiers changed from: package-private */
    public MenuItemWrapperICS.ActionProviderWrapper createActionProviderWrapper(ActionProvider provider) {
        return new ActionProviderWrapperJB(provider);
    }

    /* renamed from: android.support.v7.internal.view.menu.MenuItemWrapperJB$ActionProviderWrapperJB */
    class ActionProviderWrapperJB extends MenuItemWrapperICS.ActionProviderWrapper implements ActionProvider.VisibilityListener {
        ActionProvider.VisibilityListener mListener;

        public ActionProviderWrapperJB(android.support.p000v4.view.ActionProvider inner) {
            super(inner);
        }

        public View onCreateActionView(MenuItem forItem) {
            return this.mInner.onCreateActionView(forItem);
        }

        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }

        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }

        /* Debug info: failed to restart local var, previous not found, register: 1 */
        public void setVisibilityListener(ActionProvider.VisibilityListener listener) {
            this.mListener = listener;
            android.support.p000v4.view.ActionProvider actionProvider = this.mInner;
            if (listener == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        public void onActionProviderVisibilityChanged(boolean isVisible) {
            if (this.mListener != null) {
                this.mListener.onActionProviderVisibilityChanged(isVisible);
            }
        }
    }
}
