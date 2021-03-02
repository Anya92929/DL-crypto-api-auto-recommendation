package mono.android.app;

import android.app.ActionBar;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ActionBar_OnMenuVisibilityListenerImplementor implements IGCUserPeer, ActionBar.OnMenuVisibilityListener {
    public static final String __md_methods = "n_onMenuVisibilityChanged:(Z)V:GetOnMenuVisibilityChanged_ZHandler:Android.App.ActionBar/IOnMenuVisibilityListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onMenuVisibilityChanged(boolean z);

    static {
        Runtime.register("Android.App.ActionBar+IOnMenuVisibilityListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ActionBar_OnMenuVisibilityListenerImplementor.class, __md_methods);
    }

    public ActionBar_OnMenuVisibilityListenerImplementor() throws Throwable {
        if (getClass() == ActionBar_OnMenuVisibilityListenerImplementor.class) {
            TypeManager.Activate("Android.App.ActionBar+IOnMenuVisibilityListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onMenuVisibilityChanged(boolean z) {
        n_onMenuVisibilityChanged(z);
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
