package mono.android.gesture;

import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GestureOverlayView_OnGesturePerformedListenerImplementor implements IGCUserPeer, GestureOverlayView.OnGesturePerformedListener {
    public static final String __md_methods = "n_onGesturePerformed:(Landroid/gesture/GestureOverlayView;Landroid/gesture/Gesture;)V:GetOnGesturePerformed_Landroid_gesture_GestureOverlayView_Landroid_gesture_Gesture_Handler:Android.Gestures.GestureOverlayView/IOnGesturePerformedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture);

    static {
        Runtime.register("Android.Gestures.GestureOverlayView+IOnGesturePerformedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", GestureOverlayView_OnGesturePerformedListenerImplementor.class, __md_methods);
    }

    public GestureOverlayView_OnGesturePerformedListenerImplementor() throws Throwable {
        if (getClass() == GestureOverlayView_OnGesturePerformedListenerImplementor.class) {
            TypeManager.Activate("Android.Gestures.GestureOverlayView+IOnGesturePerformedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        n_onGesturePerformed(gestureOverlayView, gesture);
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
