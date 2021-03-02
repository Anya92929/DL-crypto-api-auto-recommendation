package mono.android.widget;

import android.widget.SlidingDrawer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SlidingDrawer_OnDrawerOpenListenerImplementor implements IGCUserPeer, SlidingDrawer.OnDrawerOpenListener {
    public static final String __md_methods = "n_onDrawerOpened:()V:GetOnDrawerOpenedHandler:Android.Widget.SlidingDrawer/IOnDrawerOpenListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDrawerOpened();

    static {
        Runtime.register("Android.Widget.SlidingDrawer+IOnDrawerOpenListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SlidingDrawer_OnDrawerOpenListenerImplementor.class, __md_methods);
    }

    public SlidingDrawer_OnDrawerOpenListenerImplementor() throws Throwable {
        if (getClass() == SlidingDrawer_OnDrawerOpenListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.SlidingDrawer+IOnDrawerOpenListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDrawerOpened() {
        n_onDrawerOpened();
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
