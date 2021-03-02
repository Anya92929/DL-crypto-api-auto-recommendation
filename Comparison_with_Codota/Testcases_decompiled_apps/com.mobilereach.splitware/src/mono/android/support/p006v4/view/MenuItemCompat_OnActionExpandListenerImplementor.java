package mono.android.support.p006v4.view;

import android.support.p000v4.view.MenuItemCompat;
import android.view.MenuItem;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.view.MenuItemCompat_OnActionExpandListenerImplementor */
public class MenuItemCompat_OnActionExpandListenerImplementor implements IGCUserPeer, MenuItemCompat.OnActionExpandListener {
    public static final String __md_methods = "n_onMenuItemActionCollapse:(Landroid/view/MenuItem;)Z:GetOnMenuItemActionCollapse_Landroid_view_MenuItem_Handler:Android.Support.V4.View.MenuItemCompat/IOnActionExpandListenerInvoker, Xamarin.Android.Support.v4\nn_onMenuItemActionExpand:(Landroid/view/MenuItem;)Z:GetOnMenuItemActionExpand_Landroid_view_MenuItem_Handler:Android.Support.V4.View.MenuItemCompat/IOnActionExpandListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native boolean n_onMenuItemActionCollapse(MenuItem menuItem);

    private native boolean n_onMenuItemActionExpand(MenuItem menuItem);

    static {
        Runtime.register("Android.Support.V4.View.MenuItemCompat+IOnActionExpandListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", MenuItemCompat_OnActionExpandListenerImplementor.class, __md_methods);
    }

    public MenuItemCompat_OnActionExpandListenerImplementor() throws Throwable {
        if (getClass() == MenuItemCompat_OnActionExpandListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.View.MenuItemCompat+IOnActionExpandListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
