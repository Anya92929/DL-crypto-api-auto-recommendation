package mono.android.widget;

import android.widget.PopupWindow;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PopupWindow_OnDismissListenerImplementor implements IGCUserPeer, PopupWindow.OnDismissListener {
    public static final String __md_methods = "n_onDismiss:()V:GetOnDismissHandler:Android.Widget.PopupWindow/IOnDismissListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDismiss();

    static {
        Runtime.register("Android.Widget.PopupWindow+IOnDismissListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", PopupWindow_OnDismissListenerImplementor.class, __md_methods);
    }

    public PopupWindow_OnDismissListenerImplementor() throws Throwable {
        if (getClass() == PopupWindow_OnDismissListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.PopupWindow+IOnDismissListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDismiss() {
        n_onDismiss();
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
