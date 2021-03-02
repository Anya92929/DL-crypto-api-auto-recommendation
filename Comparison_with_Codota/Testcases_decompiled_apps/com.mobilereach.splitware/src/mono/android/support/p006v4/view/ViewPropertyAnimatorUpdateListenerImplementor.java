package mono.android.support.p006v4.view;

import android.support.p000v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.view.ViewPropertyAnimatorUpdateListenerImplementor */
public class ViewPropertyAnimatorUpdateListenerImplementor implements IGCUserPeer, ViewPropertyAnimatorUpdateListener {
    public static final String __md_methods = "n_onAnimationUpdate:(Landroid/view/View;)V:GetOnAnimationUpdate_Landroid_view_View_Handler:Android.Support.V4.View.IViewPropertyAnimatorUpdateListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onAnimationUpdate(View view);

    static {
        Runtime.register("Android.Support.V4.View.IViewPropertyAnimatorUpdateListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ViewPropertyAnimatorUpdateListenerImplementor.class, __md_methods);
    }

    public ViewPropertyAnimatorUpdateListenerImplementor() throws Throwable {
        if (getClass() == ViewPropertyAnimatorUpdateListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.View.IViewPropertyAnimatorUpdateListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onAnimationUpdate(View view) {
        n_onAnimationUpdate(view);
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
