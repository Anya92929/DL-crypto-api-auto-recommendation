package p006nl.volkerinfradesign.checkandroid.util;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;

/* renamed from: nl.volkerinfradesign.checkandroid.util.SimpleMultiChoiceModeListener */
public class SimpleMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
    }

    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }
}
