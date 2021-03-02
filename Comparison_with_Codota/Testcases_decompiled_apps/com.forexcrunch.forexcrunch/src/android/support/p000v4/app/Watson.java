package android.support.p000v4.app;

import android.util.Log;
import android.view.View;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.Watson */
public abstract class Watson extends FragmentActivity implements ActionBarSherlock.OnCreatePanelMenuListener, ActionBarSherlock.OnPreparePanelListener, ActionBarSherlock.OnMenuItemSelectedListener {
    private static final String TAG = "Watson";
    private ArrayList<Fragment> mCreatedMenus;

    /* renamed from: android.support.v4.app.Watson$OnCreateOptionsMenuListener */
    public interface OnCreateOptionsMenuListener {
        void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);
    }

    /* renamed from: android.support.v4.app.Watson$OnOptionsItemSelectedListener */
    public interface OnOptionsItemSelectedListener {
        boolean onOptionsItemSelected(MenuItem menuItem);
    }

    /* renamed from: android.support.v4.app.Watson$OnPrepareOptionsMenuListener */
    public interface OnPrepareOptionsMenuListener {
        void onPrepareOptionsMenu(Menu menu);
    }

    public abstract MenuInflater getSupportMenuInflater();

    public abstract boolean onCreateOptionsMenu(Menu menu);

    public abstract boolean onOptionsItemSelected(MenuItem menuItem);

    public abstract boolean onPrepareOptionsMenu(Menu menu);

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        Log.d(TAG, "[onCreatePanelMenu] featureId: " + featureId + ", menu: " + menu);
        if (featureId != 0) {
            return false;
        }
        boolean result = onCreateOptionsMenu(menu);
        Log.d(TAG, "[onCreatePanelMenu] activity create result: " + result);
        MenuInflater inflater = getSupportMenuInflater();
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        if (this.mFragments.mAdded != null) {
            for (int i = 0; i < this.mFragments.mAdded.size(); i++) {
                Fragment f = this.mFragments.mAdded.get(i);
                if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible && (f instanceof OnCreateOptionsMenuListener)) {
                    show = true;
                    ((OnCreateOptionsMenuListener) f).onCreateOptionsMenu(menu, inflater);
                    if (newMenus == null) {
                        newMenus = new ArrayList<>();
                    }
                    newMenus.add(f);
                }
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i2 = 0; i2 < this.mCreatedMenus.size(); i2++) {
                Fragment f2 = this.mCreatedMenus.get(i2);
                if (newMenus == null || !newMenus.contains(f2)) {
                    f2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = newMenus;
        Log.d(TAG, "[onCreatePanelMenu] fragments create result: " + show);
        boolean result2 = result | show;
        Log.d(TAG, "[onCreatePanelMenu] returning " + result2);
        return result2;
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        Log.d(TAG, "[onPreparePanel] featureId: " + featureId + ", view: " + view + " menu: " + menu);
        if (featureId != 0) {
            return false;
        }
        boolean result = onPrepareOptionsMenu(menu);
        Log.d(TAG, "[onPreparePanel] activity prepare result: " + result);
        boolean show = false;
        if (this.mFragments.mAdded != null) {
            for (int i = 0; i < this.mFragments.mAdded.size(); i++) {
                Fragment f = this.mFragments.mAdded.get(i);
                if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible && (f instanceof OnPrepareOptionsMenuListener)) {
                    show = true;
                    ((OnPrepareOptionsMenuListener) f).onPrepareOptionsMenu(menu);
                }
            }
        }
        Log.d(TAG, "[onPreparePanel] fragments prepare result: " + show);
        boolean result2 = (result | show) & menu.hasVisibleItems();
        Log.d(TAG, "[onPreparePanel] returning " + result2);
        return result2;
    }

    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Log.d(TAG, "[onMenuItemSelected] featureId: " + featureId + ", item: " + item);
        if (featureId == 0) {
            if (onOptionsItemSelected(item)) {
                return true;
            }
            if (this.mFragments.mAdded != null) {
                for (int i = 0; i < this.mFragments.mAdded.size(); i++) {
                    Fragment f = this.mFragments.mAdded.get(i);
                    if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible && (f instanceof OnOptionsItemSelectedListener) && ((OnOptionsItemSelectedListener) f).onOptionsItemSelected(item)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
