package mono.android.view;

import android.view.MenuItem;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MenuItem_OnActionExpandListenerImplementor implements IGCUserPeer, MenuItem.OnActionExpandListener {
    public static final String __md_methods = "n_onMenuItemActionCollapse:(Landroid/view/MenuItem;)Z:GetOnMenuItemActionCollapse_Landroid_view_MenuItem_Handler:Android.Views.IMenuItemOnActionExpandListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onMenuItemActionExpand:(Landroid/view/MenuItem;)Z:GetOnMenuItemActionExpand_Landroid_view_MenuItem_Handler:Android.Views.IMenuItemOnActionExpandListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onMenuItemActionCollapse(MenuItem menuItem);

    private native boolean n_onMenuItemActionExpand(MenuItem menuItem);

    static {
        Runtime.register("Android.Views.IMenuItemOnActionExpandListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", MenuItem_OnActionExpandListenerImplementor.class, __md_methods);
    }

    public MenuItem_OnActionExpandListenerImplementor() throws Throwable {
        if (getClass() == MenuItem_OnActionExpandListenerImplementor.class) {
            TypeManager.Activate("Android.Views.IMenuItemOnActionExpandListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return n_onMenuItemActionCollapse(menuItem);
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return n_onMenuItemActionExpand(menuItem);
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
