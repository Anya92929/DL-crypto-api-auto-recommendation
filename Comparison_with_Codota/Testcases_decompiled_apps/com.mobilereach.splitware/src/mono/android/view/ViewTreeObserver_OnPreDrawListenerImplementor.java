package mono.android.view;

import android.view.ViewTreeObserver;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewTreeObserver_OnPreDrawListenerImplementor implements IGCUserPeer, ViewTreeObserver.OnPreDrawListener {
    public static final String __md_methods = "n_onPreDraw:()Z:GetOnPreDrawHandler:Android.Views.ViewTreeObserver/IOnPreDrawListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onPreDraw();

    static {
        Runtime.register("Android.Views.ViewTreeObserver+IOnPreDrawListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ViewTreeObserver_OnPreDrawListenerImplementor.class, __md_methods);
    }

    public ViewTreeObserver_OnPreDrawListenerImplementor() throws Throwable {
        if (getClass() == ViewTreeObserver_OnPreDrawListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ViewTreeObserver+IOnPreDrawListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onPreDraw() {
        return n_onPreDraw();
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
