package md529e4c2c8a026201f3a493bfa20264e47;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MrtFragment extends Fragment implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onStart:()V:GetOnStartHandler\nn_onResume:()V:GetOnResumeHandler\nn_onStop:()V:GetOnStopHandler\nn_onDestroy:()V:GetOnDestroyHandler\nn_onCreateOptionsMenu:(Landroid/view/Menu;Landroid/view/MenuInflater;)V:GetOnCreateOptionsMenu_Landroid_view_Menu_Landroid_view_MenuInflater_Handler\nn_onOptionsItemSelected:(Landroid/view/MenuItem;)Z:GetOnOptionsItemSelected_Landroid_view_MenuItem_Handler\n";
    private ArrayList refList;

    private native void n_onCreate(Bundle bundle);

    private native void n_onCreateOptionsMenu(Menu menu, MenuInflater menuInflater);

    private native void n_onDestroy();

    private native boolean n_onOptionsItemSelected(MenuItem menuItem);

    private native void n_onResume();

    private native void n_onStart();

    private native void n_onStop();

    static {
        Runtime.register("UI.MrtFragment, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", MrtFragment.class, __md_methods);
    }

    public MrtFragment() throws Throwable {
        if (getClass() == MrtFragment.class) {
            TypeManager.Activate("UI.MrtFragment, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
    }

    public void onStart() {
        n_onStart();
    }

    public void onResume() {
        n_onResume();
    }

    public void onStop() {
        n_onStop();
    }

    public void onDestroy() {
        n_onDestroy();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        n_onCreateOptionsMenu(menu, menuInflater);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return n_onOptionsItemSelected(menuItem);
    }

    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    public void monodroidClearReferences() {
        if (this.refList != null) {
            this.refList.clear();
        }
    }
}
