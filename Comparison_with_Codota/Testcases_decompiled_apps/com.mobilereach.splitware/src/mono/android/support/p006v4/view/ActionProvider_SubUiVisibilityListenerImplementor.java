package mono.android.support.p006v4.view;

import android.support.p000v4.view.ActionProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.view.ActionProvider_SubUiVisibilityListenerImplementor */
public class ActionProvider_SubUiVisibilityListenerImplementor implements IGCUserPeer, ActionProvider.SubUiVisibilityListener {
    public static final String __md_methods = "n_onSubUiVisibilityChanged:(Z)V:GetOnSubUiVisibilityChanged_ZHandler:Android.Support.V4.View.ActionProvider/ISubUiVisibilityListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onSubUiVisibilityChanged(boolean z);

    static {
        Runtime.register("Android.Support.V4.View.ActionProvider+ISubUiVisibilityListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ActionProvider_SubUiVisibilityListenerImplementor.class, __md_methods);
    }

    public ActionProvider_SubUiVisibilityListenerImplementor() throws Throwable {
        if (getClass() == ActionProvider_SubUiVisibilityListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.View.ActionProvider+ISubUiVisibilityListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onSubUiVisibilityChanged(boolean z) {
        n_onSubUiVisibilityChanged(z);
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
