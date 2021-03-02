package com.actionbarsherlock.app;

import android.app.Activity;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Watson;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;

public class SherlockDialogFragment extends DialogFragment implements Watson.OnCreateOptionsMenuListener, Watson.OnPrepareOptionsMenuListener, Watson.OnOptionsItemSelectedListener {
    private SherlockFragmentActivity mActivity;

    public SherlockFragmentActivity getSherlockActivity() {
        return this.mActivity;
    }

    public void onAttach(Activity activity) {
        if (!(activity instanceof SherlockFragmentActivity)) {
            throw new IllegalStateException(String.valueOf(getClass().getSimpleName()) + " must be attached to a SherlockFragmentActivity.");
        }
        this.mActivity = (SherlockFragmentActivity) activity;
        super.onAttach(activity);
    }

    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    public final void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        onCreateOptionsMenu((com.actionbarsherlock.view.Menu) new MenuWrapper(menu), this.mActivity.getSupportMenuInflater());
    }

    public void onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu, com.actionbarsherlock.view.MenuInflater inflater) {
    }

    public final void onPrepareOptionsMenu(Menu menu) {
        onPrepareOptionsMenu((com.actionbarsherlock.view.Menu) new MenuWrapper(menu));
    }

    public void onPrepareOptionsMenu(com.actionbarsherlock.view.Menu menu) {
    }

    public final boolean onOptionsItemSelected(MenuItem item) {
        return onOptionsItemSelected((com.actionbarsherlock.view.MenuItem) new MenuItemWrapper(item));
    }

    public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
        return false;
    }
}
