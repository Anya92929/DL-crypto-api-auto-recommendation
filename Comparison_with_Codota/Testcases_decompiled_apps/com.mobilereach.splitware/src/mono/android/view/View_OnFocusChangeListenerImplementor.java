package mono.android.view;

import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnFocusChangeListenerImplementor implements IGCUserPeer, View.OnFocusChangeListener {
    public static final String __md_methods = "n_onFocusChange:(Landroid/view/View;Z)V:GetOnFocusChange_Landroid_view_View_ZHandler:Android.Views.View/IOnFocusChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onFocusChange(View view, boolean z);

    static {
        Runtime.register("Android.Views.View+IOnFocusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnFocusChangeListenerImplementor.class, __md_methods);
    }

    public View_OnFocusChangeListenerImplementor() throws Throwable {
        if (getClass() == View_OnFocusChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnFocusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onFocusChange(View view, boolean z) {
        n_onFocusChange(view, z);
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
