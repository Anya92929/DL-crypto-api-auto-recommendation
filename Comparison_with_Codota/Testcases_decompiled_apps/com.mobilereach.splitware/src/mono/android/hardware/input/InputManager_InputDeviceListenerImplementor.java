package mono.android.hardware.input;

import android.hardware.input.InputManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class InputManager_InputDeviceListenerImplementor implements IGCUserPeer, InputManager.InputDeviceListener {
    public static final String __md_methods = "n_onInputDeviceAdded:(I)V:GetOnInputDeviceAdded_IHandler:Android.Hardware.Input.InputManager/IInputDeviceListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onInputDeviceChanged:(I)V:GetOnInputDeviceChanged_IHandler:Android.Hardware.Input.InputManager/IInputDeviceListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onInputDeviceRemoved:(I)V:GetOnInputDeviceRemoved_IHandler:Android.Hardware.Input.InputManager/IInputDeviceListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onInputDeviceAdded(int i);

    private native void n_onInputDeviceChanged(int i);

    private native void n_onInputDeviceRemoved(int i);

    static {
        Runtime.register("Android.Hardware.Input.InputManager+IInputDeviceListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", InputManager_InputDeviceListenerImplementor.class, __md_methods);
    }

    public InputManager_InputDeviceListenerImplementor() throws Throwable {
        if (getClass() == InputManager_InputDeviceListenerImplementor.class) {
            TypeManager.Activate("Android.Hardware.Input.InputManager+IInputDeviceListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onInputDeviceAdded(int i) {
        n_onInputDeviceAdded(i);
    }

    public void onInputDeviceChanged(int i) {
        n_onInputDeviceChanged(i);
    }

    public void onInputDeviceRemoved(int i) {
        n_onInputDeviceRemoved(i);
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
