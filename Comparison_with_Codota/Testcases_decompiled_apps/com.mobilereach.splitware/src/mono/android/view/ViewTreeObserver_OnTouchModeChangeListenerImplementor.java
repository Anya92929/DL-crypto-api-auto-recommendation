package mono.android.view;

import android.view.ViewTreeObserver;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewTreeObserver_OnTouchModeChangeListenerImplementor implements IGCUserPeer, ViewTreeObserver.OnTouchModeChangeListener {
    public static final String __md_methods = "n_onTouchModeChanged:(Z)V:GetOnTouchModeChanged_ZHandler:Android.Views.ViewTreeObserver/IOnTouchModeChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTouchModeChanged(boolean z);

    static {
        Runtime.register("Android.Views.ViewTreeObserver+IOnTouchModeChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ViewTreeObserver_OnTouchModeChangeListenerImplementor.class, __md_methods);
    }

    public ViewTreeObserver_OnTouchModeChangeListenerImplementor() throws Throwable {
        if (getClass() == ViewTreeObserver_OnTouchModeChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ViewTreeObserver+IOnTouchModeChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTouchModeChanged(boolean z) {
        n_onTouchModeChanged(z);
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
