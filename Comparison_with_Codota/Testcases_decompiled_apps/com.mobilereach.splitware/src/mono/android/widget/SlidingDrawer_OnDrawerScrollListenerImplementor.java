package mono.android.widget;

import android.widget.SlidingDrawer;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SlidingDrawer_OnDrawerScrollListenerImplementor implements IGCUserPeer, SlidingDrawer.OnDrawerScrollListener {
    public static final String __md_methods = "n_onScrollEnded:()V:GetOnScrollEndedHandler:Android.Widget.SlidingDrawer/IOnDrawerScrollListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onScrollStarted:()V:GetOnScrollStartedHandler:Android.Widget.SlidingDrawer/IOnDrawerScrollListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onScrollEnded();

    private native void n_onScrollStarted();

    static {
        Runtime.register("Android.Widget.SlidingDrawer+IOnDrawerScrollListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SlidingDrawer_OnDrawerScrollListenerImplementor.class, __md_methods);
    }

    public SlidingDrawer_OnDrawerScrollListenerImplementor() throws Throwable {
        if (getClass() == SlidingDrawer_OnDrawerScrollListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.SlidingDrawer+IOnDrawerScrollListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onScrollEnded() {
        n_onScrollEnded();
    }

    public void onScrollStarted() {
        n_onScrollStarted();
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
