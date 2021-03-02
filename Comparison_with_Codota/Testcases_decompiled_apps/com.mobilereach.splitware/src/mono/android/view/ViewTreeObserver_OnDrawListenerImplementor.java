package mono.android.view;

import android.view.ViewTreeObserver;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewTreeObserver_OnDrawListenerImplementor implements IGCUserPeer, ViewTreeObserver.OnDrawListener {
    public static final String __md_methods = "n_onDraw:()V:GetOnDrawHandler:Android.Views.ViewTreeObserver/IOnDrawListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDraw();

    static {
        Runtime.register("Android.Views.ViewTreeObserver+IOnDrawListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ViewTreeObserver_OnDrawListenerImplementor.class, __md_methods);
    }

    public ViewTreeObserver_OnDrawListenerImplementor() throws Throwable {
        if (getClass() == ViewTreeObserver_OnDrawListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ViewTreeObserver+IOnDrawListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDraw() {
        n_onDraw();
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
