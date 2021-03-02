package mono.android.view;

import android.view.View;
import android.view.ViewStub;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ViewStub_OnInflateListenerImplementor implements IGCUserPeer, ViewStub.OnInflateListener {
    public static final String __md_methods = "n_onInflate:(Landroid/view/ViewStub;Landroid/view/View;)V:GetOnInflate_Landroid_view_ViewStub_Landroid_view_View_Handler:Android.Views.ViewStub/IOnInflateListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onInflate(ViewStub viewStub, View view);

    static {
        Runtime.register("Android.Views.ViewStub+IOnInflateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ViewStub_OnInflateListenerImplementor.class, __md_methods);
    }

    public ViewStub_OnInflateListenerImplementor() throws Throwable {
        if (getClass() == ViewStub_OnInflateListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ViewStub+IOnInflateListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onInflate(ViewStub viewStub, View view) {
        n_onInflate(viewStub, view);
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
