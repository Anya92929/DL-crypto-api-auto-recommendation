package mono.android.support.p006v4.view;

import android.support.p000v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.view.ViewPropertyAnimatorListenerImplementor */
public class ViewPropertyAnimatorListenerImplementor implements IGCUserPeer, ViewPropertyAnimatorListener {
    public static final String __md_methods = "n_onAnimationCancel:(Landroid/view/View;)V:GetOnAnimationCancel_Landroid_view_View_Handler:Android.Support.V4.View.IViewPropertyAnimatorListenerInvoker, Xamarin.Android.Support.v4\nn_onAnimationEnd:(Landroid/view/View;)V:GetOnAnimationEnd_Landroid_view_View_Handler:Android.Support.V4.View.IViewPropertyAnimatorListenerInvoker, Xamarin.Android.Support.v4\nn_onAnimationStart:(Landroid/view/View;)V:GetOnAnimationStart_Landroid_view_View_Handler:Android.Support.V4.View.IViewPropertyAnimatorListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onAnimationCancel(View view);

    private native void n_onAnimationEnd(View view);

    private native void n_onAnimationStart(View view);

    static {
        Runtime.register("Android.Support.V4.View.IViewPropertyAnimatorListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ViewPropertyAnimatorListenerImplementor.class, __md_methods);
    }

    public ViewPropertyAnimatorListenerImplementor() throws Throwable {
        if (getClass() == ViewPropertyAnimatorListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.View.IViewPropertyAnimatorListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onAnimationCancel(View view) {
        n_onAnimationCancel(view);
    }

    public void onAnimationEnd(View view) {
        n_onAnimationEnd(view);
    }

    public void onAnimationStart(View view) {
        n_onAnimationStart(view);
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
