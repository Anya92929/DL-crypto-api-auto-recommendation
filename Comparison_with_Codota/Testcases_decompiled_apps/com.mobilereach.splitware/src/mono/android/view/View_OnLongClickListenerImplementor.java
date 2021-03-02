package mono.android.view;

import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnLongClickListenerImplementor implements IGCUserPeer, View.OnLongClickListener {
    public static final String __md_methods = "n_onLongClick:(Landroid/view/View;)Z:GetOnLongClick_Landroid_view_View_Handler:Android.Views.View/IOnLongClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onLongClick(View view);

    static {
        Runtime.register("Android.Views.View+IOnLongClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnLongClickListenerImplementor.class, __md_methods);
    }

    public View_OnLongClickListenerImplementor() throws Throwable {
        if (getClass() == View_OnLongClickListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnLongClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onLongClick(View view) {
        return n_onLongClick(view);
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
