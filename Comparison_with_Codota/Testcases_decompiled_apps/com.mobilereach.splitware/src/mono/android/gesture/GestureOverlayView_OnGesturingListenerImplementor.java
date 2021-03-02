package mono.android.gesture;

import android.gesture.GestureOverlayView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GestureOverlayView_OnGesturingListenerImplementor implements IGCUserPeer, GestureOverlayView.OnGesturingListener {
    public static final String __md_methods = "n_onGesturingEnded:(Landroid/gesture/GestureOverlayView;)V:GetOnGesturingEnded_Landroid_gesture_GestureOverlayView_Handler:Android.Gestures.GestureOverlayView/IOnGesturingListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onGesturingStarted:(Landroid/gesture/GestureOverlayView;)V:GetOnGesturingStarted_Landroid_gesture_GestureOverlayView_Handler:Android.Gestures.GestureOverlayView/IOnGesturingListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onGesturingEnded(GestureOverlayView gestureOverlayView);

    private native void n_onGesturingStarted(GestureOverlayView gestureOverlayView);

    static {
        Runtime.register("Android.Gestures.GestureOverlayView+IOnGesturingListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", GestureOverlayView_OnGesturingListenerImplementor.class, __md_methods);
    }

    public GestureOverlayView_OnGesturingListenerImplementor() throws Throwable {
        if (getClass() == GestureOverlayView_OnGesturingListenerImplementor.class) {
            TypeManager.Activate("Android.Gestures.GestureOverlayView+IOnGesturingListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onGesturingEnded(GestureOverlayView gestureOverlayView) {
        n_onGesturingEnded(gestureOverlayView);
    }

    public void onGesturingStarted(GestureOverlayView gestureOverlayView) {
        n_onGesturingStarted(gestureOverlayView);
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
