package mono.android.view;

import android.view.ActionProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionProvider_VisibilityListenerImplementor implements IGCUserPeer, ActionProvider.VisibilityListener {
    public static final String __md_methods = "n_onActionProviderVisibilityChanged:(Z)V:GetOnActionProviderVisibilityChanged_ZHandler:Android.Views.ActionProvider/IVisibilityListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onActionProviderVisibilityChanged(boolean z);

    static {
        Runtime.register("Android.Views.ActionProvider+IVisibilityListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ActionProvider_VisibilityListenerImplementor.class, __md_methods);
    }

    public ActionProvider_VisibilityListenerImplementor() throws Throwable {
        if (getClass() == ActionProvider_VisibilityListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ActionProvider+IVisibilityListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        n_onActionProviderVisibilityChanged(z);
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
