package android.support.p000v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.view.ActionProvider */
public abstract class ActionProvider {

    /* renamed from: a */
    private final Context f1153a;

    /* renamed from: b */
    private SubUiVisibilityListener f1154b;

    /* renamed from: c */
    private VisibilityListener f1155c;

    /* renamed from: android.support.v4.view.ActionProvider$SubUiVisibilityListener */
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    /* renamed from: android.support.v4.view.ActionProvider$VisibilityListener */
    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ActionProvider(Context context) {
        this.f1153a = context;
    }

    public Context getContext() {
        return this.f1153a;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.f1155c != null && overridesItemVisibility()) {
            this.f1155c.onActionProviderVisibilityChanged(isVisible());
        }
    }

    public void reset() {
        this.f1155c = null;
        this.f1154b = null;
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener subUiVisibilityListener) {
        this.f1154b = subUiVisibilityListener;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (!(this.f1155c == null || visibilityListener == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1155c = visibilityListener;
    }

    public void subUiVisibilityChanged(boolean z) {
        if (this.f1154b != null) {
            this.f1154b.onSubUiVisibilityChanged(z);
        }
    }
}
