package mono.android.hardware;

import android.hardware.Camera;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Camera_OnZoomChangeListenerImplementor implements IGCUserPeer, Camera.OnZoomChangeListener {
    public static final String __md_methods = "n_onZoomChange:(IZLandroid/hardware/Camera;)V:GetOnZoomChange_IZLandroid_hardware_Camera_Handler:Android.Hardware.Camera/IOnZoomChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onZoomChange(int i, boolean z, Camera camera);

    static {
        Runtime.register("Android.Hardware.Camera+IOnZoomChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Camera_OnZoomChangeListenerImplementor.class, __md_methods);
    }

    public Camera_OnZoomChangeListenerImplementor() throws Throwable {
        if (getClass() == Camera_OnZoomChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Hardware.Camera+IOnZoomChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onZoomChange(int i, boolean z, Camera camera) {
        n_onZoomChange(i, z, camera);
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
