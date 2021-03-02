package mono.android.hardware;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SensorEventListenerImplementor implements IGCUserPeer, SensorEventListener {
    public static final String __md_methods = "n_onAccuracyChanged:(Landroid/hardware/Sensor;I)V:GetOnAccuracyChanged_Landroid_hardware_Sensor_IHandler:Android.Hardware.ISensorEventListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSensorChanged:(Landroid/hardware/SensorEvent;)V:GetOnSensorChanged_Landroid_hardware_SensorEvent_Handler:Android.Hardware.ISensorEventListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAccuracyChanged(Sensor sensor, int i);

    private native void n_onSensorChanged(SensorEvent sensorEvent);

    static {
        Runtime.register("Android.Hardware.ISensorEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SensorEventListenerImplementor.class, __md_methods);
    }

    public SensorEventListenerImplementor() throws Throwable {
        if (getClass() == SensorEventListenerImplementor.class) {
            TypeManager.Activate("Android.Hardware.ISensorEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        n_onAccuracyChanged(sensor, i);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        n_onSensorChanged(sensorEvent);
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
