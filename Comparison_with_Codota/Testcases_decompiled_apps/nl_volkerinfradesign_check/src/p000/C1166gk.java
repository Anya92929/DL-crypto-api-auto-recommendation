package p000;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.p001v4.internal.view.SupportMenuItem;
import android.support.p001v4.view.ActionProvider;
import android.support.p004v7.view.menu.MenuItemWrapperICS;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
/* renamed from: gk */
public class C1166gk extends MenuItemWrapperICS {
    public C1166gk(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public MenuItemWrapperICS.C0514a mo3793a(ActionProvider actionProvider) {
        return new C1167a(this.f4159a, actionProvider);
    }

    /* renamed from: gk$a */
    class C1167a extends MenuItemWrapperICS.C0514a implements ActionProvider.VisibilityListener {

        /* renamed from: c */
        ActionProvider.VisibilityListener f4167c;

        public C1167a(Context context, android.view.ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public View onCreateActionView(MenuItem menuItem) {
            return this.f1805a.onCreateActionView(menuItem);
        }

        public boolean overridesItemVisibility() {
            return this.f1805a.overridesItemVisibility();
        }

        public boolean isVisible() {
            return this.f1805a.isVisible();
        }

        public void refreshVisibility() {
            this.f1805a.refreshVisibility();
        }

        public void setVisibilityListener(ActionProvider.VisibilityListener visibilityListener) {
            this.f4167c = visibilityListener;
            android.view.ActionProvider actionProvider = this.f1805a;
            if (visibilityListener == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f4167c != null) {
                this.f4167c.onActionProviderVisibilityChanged(z);
            }
        }
    }
}
