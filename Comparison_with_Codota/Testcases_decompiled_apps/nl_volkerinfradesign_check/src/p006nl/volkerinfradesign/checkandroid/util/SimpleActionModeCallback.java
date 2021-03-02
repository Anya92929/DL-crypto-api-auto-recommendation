package p006nl.volkerinfradesign.checkandroid.util;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: nl.volkerinfradesign.checkandroid.util.SimpleActionModeCallback */
public abstract class SimpleActionModeCallback implements ActionMode.Callback {
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }
}
