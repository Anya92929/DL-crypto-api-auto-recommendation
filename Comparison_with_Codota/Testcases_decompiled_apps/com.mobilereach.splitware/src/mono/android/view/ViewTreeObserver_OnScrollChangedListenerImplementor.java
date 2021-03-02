package mono.android.view;

import android.view.ViewTreeObserver;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewTreeObserver_OnScrollChangedListenerImplementor implements IGCUserPeer, ViewTreeObserver.OnScrollChangedListener {
    public static final String __md_methods = "n_onScrollChanged:()V:GetOnScrollChangedHandler:Android.Views.ViewTreeObserver/IOnScrollChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onScrollChanged();

    static {
        Runtime.register("Android.Views.ViewTreeObserver+IOnScrollChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ViewTreeObserver_OnScrollChangedListenerImplementor.class, __md_methods);
    }

    public ViewTreeObserver_OnScrollChangedListenerImplementor() throws Throwable {
        if (getClass() == ViewTreeObserver_OnScrollChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ViewTreeObserver+IOnScrollChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onScrollChanged() {
        n_onScrollChanged();
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
