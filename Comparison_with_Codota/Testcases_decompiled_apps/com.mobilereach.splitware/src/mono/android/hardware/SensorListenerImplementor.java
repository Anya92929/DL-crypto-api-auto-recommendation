package mono.android.hardware;

import android.hardware.SensorListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SensorListenerImplementor implements IGCUserPeer, SensorListener {
    public static final String __md_methods = "n_onAccuracyChanged:(II)V:GetOnAccuracyChanged_IIHandler:Android.Hardware.ISensorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSensorChanged:(I[F)V:GetOnSensorChanged_IarrayFHandler:Android.Hardware.ISensorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAccuracyChanged(int i, int i2);

    private native void n_onSensorChanged(int i, float[] fArr);

    static {
        Runtime.register("Android.Hardware.ISensorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SensorListenerImplementor.class, __md_methods);
    }

    public SensorListenerImplementor() throws Throwable {
        if (getClass() == SensorListenerImplementor.class) {
            TypeManager.Activate("Android.Hardware.ISensorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onAccuracyChanged(int i, int i2) {
        n_onAccuracyChanged(i, i2);
    }

    public void onSensorChanged(int i, float[] fArr) {
        n_onSensorChanged(i, fArr);
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
