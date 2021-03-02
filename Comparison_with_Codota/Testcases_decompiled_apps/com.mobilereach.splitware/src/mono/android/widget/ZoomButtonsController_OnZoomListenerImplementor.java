package mono.android.widget;

import android.widget.ZoomButtonsController;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ZoomButtonsController_OnZoomListenerImplementor implements IGCUserPeer, ZoomButtonsController.OnZoomListener {
    public static final String __md_methods = "n_onVisibilityChanged:(Z)V:GetOnVisibilityChanged_ZHandler:Android.Widget.ZoomButtonsController/IOnZoomListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onZoom:(Z)V:GetOnZoom_ZHandler:Android.Widget.ZoomButtonsController/IOnZoomListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onVisibilityChanged(boolean z);

    private native void n_onZoom(boolean z);

    static {
        Runtime.register("Android.Widget.ZoomButtonsController+IOnZoomListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ZoomButtonsController_OnZoomListenerImplementor.class, __md_methods);
    }

    public ZoomButtonsController_OnZoomListenerImplementor() throws Throwable {
        if (getClass() == ZoomButtonsController_OnZoomListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.ZoomButtonsController+IOnZoomListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onVisibilityChanged(boolean z) {
        n_onVisibilityChanged(z);
    }

    public void onZoom(boolean z) {
        n_onZoom(z);
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
