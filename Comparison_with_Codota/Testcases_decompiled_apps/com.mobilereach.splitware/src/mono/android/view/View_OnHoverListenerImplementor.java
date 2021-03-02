package mono.android.view;

import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnHoverListenerImplementor implements IGCUserPeer, View.OnHoverListener {
    public static final String __md_methods = "n_onHover:(Landroid/view/View;Landroid/view/MotionEvent;)Z:GetOnHover_Landroid_view_View_Landroid_view_MotionEvent_Handler:Android.Views.View/IOnHoverListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onHover(View view, MotionEvent motionEvent);

    static {
        Runtime.register("Android.Views.View+IOnHoverListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnHoverListenerImplementor.class, __md_methods);
    }

    public View_OnHoverListenerImplementor() throws Throwable {
        if (getClass() == View_OnHoverListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnHoverListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        return n_onHover(view, motionEvent);
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
