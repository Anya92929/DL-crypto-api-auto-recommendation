package mono.android.view;

import android.view.ScaleGestureDetector;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ScaleGestureDetector_OnScaleGestureListenerImplementor implements IGCUserPeer, ScaleGestureDetector.OnScaleGestureListener {
    public static final String __md_methods = "n_onScale:(Landroid/view/ScaleGestureDetector;)Z:GetOnScale_Landroid_view_ScaleGestureDetector_Handler:Android.Views.ScaleGestureDetector/IOnScaleGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onScaleBegin:(Landroid/view/ScaleGestureDetector;)Z:GetOnScaleBegin_Landroid_view_ScaleGestureDetector_Handler:Android.Views.ScaleGestureDetector/IOnScaleGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onScaleEnd:(Landroid/view/ScaleGestureDetector;)V:GetOnScaleEnd_Landroid_view_ScaleGestureDetector_Handler:Android.Views.ScaleGestureDetector/IOnScaleGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onScale(ScaleGestureDetector scaleGestureDetector);

    private native boolean n_onScaleBegin(ScaleGestureDetector scaleGestureDetector);

    private native void n_onScaleEnd(ScaleGestureDetector scaleGestureDetector);

    static {
        Runtime.register("Android.Views.ScaleGestureDetector+IOnScaleGestureListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ScaleGestureDetector_OnScaleGestureListenerImplementor.class, __md_methods);
    }

    public ScaleGestureDetector_OnScaleGestureListenerImplementor() throws Throwable {
        if (getClass() == ScaleGestureDetector_OnScaleGestureListenerImplementor.class) {
            TypeManager.Activate("Android.Views.ScaleGestureDetector+IOnScaleGestureListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return n_onScale(scaleGestureDetector);
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return n_onScaleBegin(scaleGestureDetector);
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        n_onScaleEnd(scaleGestureDetector);
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
