package android.support.p000v4.app;

import android.view.View;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

/* renamed from: android.support.v4.app._ActionBarSherlockTrojanHorse */
public abstract class _ActionBarSherlockTrojanHorse extends FragmentActivity implements ActionBarSherlock.OnCreatePanelMenuListener, ActionBarSherlock.OnPreparePanelListener, ActionBarSherlock.OnMenuItemSelectedListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "_ActionBarSherlockTrojanHorse";
    private ArrayList<Fragment> mCreatedMenus;

    /* renamed from: android.support.v4.app._ActionBarSherlockTrojanHorse$OnCreateOptionsMenuListener */
    public interface OnCreateOptionsMenuListener {
        void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);
    }

    /* renamed from: android.support.v4.app._ActionBarSherlockTrojanHorse$OnOptionsItemSelectedListener */
    public interface OnOptionsItemSelectedListener {
        boolean onOptionsItemSelected(MenuItem menuItem);
    }

    /* renamed from: android.support.v4.app._ActionBarSherlockTrojanHorse$OnPrepareOptionsMenuListener */
    public interface OnPrepareOptionsMenuListener {
        void onPrepareOptionsMenu(Menu menu);
    }

    public abstract MenuInflater getSupportMenuInflater();

    public abstract boolean onCreateOptionsMenu(Menu menu);

    public abstract boolean onOptionsItemSelected(MenuItem menuItem);

    public abstract boolean onPrepareOptionsMenu(Menu menu);

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId != 0) {
            return DEBUG;
        }
        boolean result = onCreateOptionsMenu(menu);
        MenuInflater inflater = getSupportMenuInflater();
        boolean show = DEBUG;
        ArrayList<Fragment> newMenus = null;
        if (this.mFragments.mActive != null) {
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
        return result | show;
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId != 0) {
            return DEBUG;
        }
        boolean result = onPrepareOptionsMenu(menu);
        boolean show = DEBUG;
        if (this.mFragments.mActive != null) {
            for (int i = 0; i < this.mFragments.mAdded.size(); i++) {
                Fragment f = this.mFragments.mAdded.get(i);
                if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible && (f instanceof OnPrepareOptionsMenuListener)) {
                    show = true;
                    ((OnPrepareOptionsMenuListener) f).onPrepareOptionsMenu(menu);
                }
            }
        }
        return (result | show) & menu.hasVisibleItems();
    }

    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (featureId == 0) {
            if (onOptionsItemSelected(item)) {
                return true;
            }
            if (this.mFragments.mActive != null) {
                for (int i = 0; i < this.mFragments.mAdded.size(); i++) {
                    Fragment f = this.mFragments.mAdded.get(i);
                    if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible && (f instanceof OnOptionsItemSelectedListener) && ((OnOptionsItemSelectedListener) f).onOptionsItemSelected(item)) {
                        return true;
                    }
                }
            }
        }
        return DEBUG;
    }
}
