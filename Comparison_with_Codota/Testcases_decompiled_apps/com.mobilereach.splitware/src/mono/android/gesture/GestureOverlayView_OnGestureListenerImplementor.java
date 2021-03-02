package mono.android.gesture;

import android.gesture.GestureOverlayView;
import android.view.MotionEvent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class GestureOverlayView_OnGestureListenerImplementor implements IGCUserPeer, GestureOverlayView.OnGestureListener {
    public static final String __md_methods = "n_onGesture:(Landroid/gesture/GestureOverlayView;Landroid/view/MotionEvent;)V:GetOnGesture_Landroid_gesture_GestureOverlayView_Landroid_view_MotionEvent_Handler:Android.Gestures.GestureOverlayView/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onGestureCancelled:(Landroid/gesture/GestureOverlayView;Landroid/view/MotionEvent;)V:GetOnGestureCancelled_Landroid_gesture_GestureOverlayView_Landroid_view_MotionEvent_Handler:Android.Gestures.GestureOverlayView/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onGestureEnded:(Landroid/gesture/GestureOverlayView;Landroid/view/MotionEvent;)V:GetOnGestureEnded_Landroid_gesture_GestureOverlayView_Landroid_view_MotionEvent_Handler:Android.Gestures.GestureOverlayView/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onGestureStarted:(Landroid/gesture/GestureOverlayView;Landroid/view/MotionEvent;)V:GetOnGestureStarted_Landroid_gesture_GestureOverlayView_Landroid_view_MotionEvent_Handler:Android.Gestures.GestureOverlayView/IOnGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent);

    private native void n_onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent);

    private native void n_onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent);

    private native void n_onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent);

    static {
        Runtime.register("Android.Gestures.GestureOverlayView+IOnGestureListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", GestureOverlayView_OnGestureListenerImplementor.class, __md_methods);
    }

    public GestureOverlayView_OnGestureListenerImplementor() throws Throwable {
        if (getClass() == GestureOverlayView_OnGestureListenerImplementor.class) {
            TypeManager.Activate("Android.Gestures.GestureOverlayView+IOnGestureListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        n_onGesture(gestureOverlayView, motionEvent);
    }

    public void onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        n_onGestureCancelled(gestureOverlayView, motionEvent);
    }

    public void onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        n_onGestureEnded(gestureOverlayView, motionEvent);
    }

    public void onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
        n_onGestureStarted(gestureOverlayView, motionEvent);
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
