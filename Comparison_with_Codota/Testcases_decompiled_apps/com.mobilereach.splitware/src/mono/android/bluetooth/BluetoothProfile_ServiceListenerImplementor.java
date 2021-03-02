package mono.android.bluetooth;

import android.bluetooth.BluetoothProfile;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class BluetoothProfile_ServiceListenerImplementor implements IGCUserPeer, BluetoothProfile.ServiceListener {
    public static final String __md_methods = "n_onServiceConnected:(ILandroid/bluetooth/BluetoothProfile;)V:GetOnServiceConnected_ILandroid_bluetooth_BluetoothProfile_Handler:Android.Bluetooth.IBluetoothProfileServiceListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onServiceDisconnected:(I)V:GetOnServiceDisconnected_IHandler:Android.Bluetooth.IBluetoothProfileServiceListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onServiceConnected(int i, BluetoothProfile bluetoothProfile);

    private native void n_onServiceDisconnected(int i);

    static {
        Runtime.register("Android.Bluetooth.IBluetoothProfileServiceListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", BluetoothProfile_ServiceListenerImplementor.class, __md_methods);
    }

    public BluetoothProfile_ServiceListenerImplementor() throws Throwable {
        if (getClass() == BluetoothProfile_ServiceListenerImplementor.class) {
            TypeManager.Activate("Android.Bluetooth.IBluetoothProfileServiceListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        n_onServiceConnected(i, bluetoothProfile);
    }

    public void onServiceDisconnected(int i) {
        n_onServiceDisconnected(i);
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
