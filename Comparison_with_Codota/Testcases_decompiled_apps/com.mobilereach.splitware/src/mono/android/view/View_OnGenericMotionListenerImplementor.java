package mono.android.view;

import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnGenericMotionListenerImplementor implements IGCUserPeer, View.OnGenericMotionListener {
    public static final String __md_methods = "n_onGenericMotion:(Landroid/view/View;Landroid/view/MotionEvent;)Z:GetOnGenericMotion_Landroid_view_View_Landroid_view_MotionEvent_Handler:Android.Views.View/IOnGenericMotionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onGenericMotion(View view, MotionEvent motionEvent);

    static {
        Runtime.register("Android.Views.View+IOnGenericMotionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnGenericMotionListenerImplementor.class, __md_methods);
    }

    public View_OnGenericMotionListenerImplementor() throws Throwable {
        if (getClass() == View_OnGenericMotionListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnGenericMotionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        return n_onGenericMotion(view, motionEvent);
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
