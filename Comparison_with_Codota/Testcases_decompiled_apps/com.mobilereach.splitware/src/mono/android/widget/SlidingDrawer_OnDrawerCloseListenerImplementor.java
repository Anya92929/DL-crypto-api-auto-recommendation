package mono.android.widget;

import android.widget.SlidingDrawer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SlidingDrawer_OnDrawerCloseListenerImplementor implements IGCUserPeer, SlidingDrawer.OnDrawerCloseListener {
    public static final String __md_methods = "n_onDrawerClosed:()V:GetOnDrawerClosedHandler:Android.Widget.SlidingDrawer/IOnDrawerCloseListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDrawerClosed();

    static {
        Runtime.register("Android.Widget.SlidingDrawer+IOnDrawerCloseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SlidingDrawer_OnDrawerCloseListenerImplementor.class, __md_methods);
    }

    public SlidingDrawer_OnDrawerCloseListenerImplementor() throws Throwable {
        if (getClass() == SlidingDrawer_OnDrawerCloseListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.SlidingDrawer+IOnDrawerCloseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDrawerClosed() {
        n_onDrawerClosed();
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
