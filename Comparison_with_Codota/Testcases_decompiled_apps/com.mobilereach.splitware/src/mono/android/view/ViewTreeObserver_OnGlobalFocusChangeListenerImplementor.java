package mono.android.view;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewTreeObserver_OnGlobalFocusChangeListenerImplementor implements IGCUserPeer, ViewTreeObserver.OnGlobalFocusChangeListener {
    public static final String __md_methods = "n_onGlobalFocusChanged:(Landroid/view/View;Landroid/view/View;)V:GetOnGlobalFocusChanged_Landroid_view_View_Landroid_view_View_Handler:Android.Views.ViewTreeObserver/IOnGlobalFocusChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onGlobalFocusChanged(View view, View view2);

    static {
        Runtime.register("Android.Views.ViewTreeObserver+IOnGlobalFocusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ViewTreeObserver_OnGlobalFocusChangeListenerImplementor.class, __md_methods);
    }

    public ViewTreeObserver_OnGlobalFocusChangeListenerImplementor() throws Throwable {
        if (getClass() == ViewTreeObserver_OnGlobalFocusChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ViewTreeObserver+IOnGlobalFocusChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        n_onGlobalFocusChanged(view, view2);
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
