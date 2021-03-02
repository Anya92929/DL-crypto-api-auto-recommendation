package mono.android.app;

import android.app.ActionBar;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionBar_OnNavigationListenerImplementor implements IGCUserPeer, ActionBar.OnNavigationListener {
    public static final String __md_methods = "n_onNavigationItemSelected:(IJ)Z:GetOnNavigationItemSelected_IJHandler:Android.App.ActionBar/IOnNavigationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onNavigationItemSelected(int i, long j);

    static {
        Runtime.register("Android.App.ActionBar+IOnNavigationListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ActionBar_OnNavigationListenerImplementor.class, __md_methods);
    }

    public ActionBar_OnNavigationListenerImplementor() throws Throwable {
        if (getClass() == ActionBar_OnNavigationListenerImplementor.class) {
            TypeManager.Activate("Android.App.ActionBar+IOnNavigationListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onNavigationItemSelected(int i, long j) {
        return n_onNavigationItemSelected(i, j);
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
