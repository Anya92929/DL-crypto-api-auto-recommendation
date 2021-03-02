package android.support.p003v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.view.ActionMode */
public abstract class ActionMode {

    /* renamed from: a */
    private Object f2590a;

    /* renamed from: b */
    private boolean f2591b;

    /* renamed from: android.support.v7.view.ActionMode$Callback */
    public interface Callback {
        boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem);

        boolean onCreateActionMode(ActionMode actionMode, Menu menu);

        void onDestroyActionMode(ActionMode actionMode);

        boolean onPrepareActionMode(ActionMode actionMode, Menu menu);
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public Object getTag() {
        return this.f2590a;
    }

    public abstract CharSequence getTitle();

    public boolean getTitleOptionalHint() {
        return this.f2591b;
    }

    public abstract void invalidate();

    public boolean isTitleOptional() {
        return false;
    }

    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charSequence);

    public void setTag(Object obj) {
        this.f2590a = obj;
    }

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charSequence);

    public void setTitleOptionalHint(boolean z) {
        this.f2591b = z;
    }
}
