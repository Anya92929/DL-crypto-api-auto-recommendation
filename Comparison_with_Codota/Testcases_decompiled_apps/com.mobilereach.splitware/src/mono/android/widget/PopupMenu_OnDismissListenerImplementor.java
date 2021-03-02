package mono.android.widget;

import android.widget.PopupMenu;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PopupMenu_OnDismissListenerImplementor implements IGCUserPeer, PopupMenu.OnDismissListener {
    public static final String __md_methods = "n_onDismiss:(Landroid/widget/PopupMenu;)V:GetOnDismiss_Landroid_widget_PopupMenu_Handler:Android.Widget.PopupMenu/IOnDismissListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDismiss(PopupMenu popupMenu);

    static {
        Runtime.register("Android.Widget.PopupMenu+IOnDismissListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", PopupMenu_OnDismissListenerImplementor.class, __md_methods);
    }

    public PopupMenu_OnDismissListenerImplementor() throws Throwable {
        if (getClass() == PopupMenu_OnDismissListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.PopupMenu+IOnDismissListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDismiss(PopupMenu popupMenu) {
        n_onDismiss(popupMenu);
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
