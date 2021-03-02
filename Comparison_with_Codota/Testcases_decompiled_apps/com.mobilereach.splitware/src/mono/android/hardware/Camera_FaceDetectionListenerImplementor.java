package mono.android.hardware;

import android.hardware.Camera;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Camera_FaceDetectionListenerImplementor implements IGCUserPeer, Camera.FaceDetectionListener {
    public static final String __md_methods = "n_onFaceDetection:([Landroid/hardware/Camera$Face;Landroid/hardware/Camera;)V:GetOnFaceDetection_arrayLandroid_hardware_Camera_Face_Landroid_hardware_Camera_Handler:Android.Hardware.Camera/IFaceDetectionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onFaceDetection(Camera.Face[] faceArr, Camera camera);

    static {
        Runtime.register("Android.Hardware.Camera+IFaceDetectionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Camera_FaceDetectionListenerImplementor.class, __md_methods);
    }

    public Camera_FaceDetectionListenerImplementor() throws Throwable {
        if (getClass() == Camera_FaceDetectionListenerImplementor.class) {
            TypeManager.Activate("Android.Hardware.Camera+IFaceDetectionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
        n_onFaceDetection(faceArr, camera);
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
