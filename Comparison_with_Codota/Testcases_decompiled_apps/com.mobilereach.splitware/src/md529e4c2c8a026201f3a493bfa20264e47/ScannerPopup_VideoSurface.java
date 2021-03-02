package md529e4c2c8a026201f3a493bfa20264e47;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.TextureView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ScannerPopup_VideoSurface extends TextureView implements IGCUserPeer, Camera.AutoFocusCallback {
    public static final String __md_methods = "n_onAutoFocus:(ZLandroid/hardware/Camera;)V:GetOnAutoFocus_ZLandroid_hardware_Camera_Handler:Android.Hardware.Camera/IAutoFocusCallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAutoFocus(boolean z, Camera camera);

    static {
        Runtime.register("UI.ScannerPopup+VideoSurface, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", ScannerPopup_VideoSurface.class, __md_methods);
    }

    public ScannerPopup_VideoSurface(Context context) throws Throwable {
        super(context);
        if (getClass() == ScannerPopup_VideoSurface.class) {
            TypeManager.Activate("UI.ScannerPopup+VideoSurface, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public ScannerPopup_VideoSurface(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == ScannerPopup_VideoSurface.class) {
            TypeManager.Activate("UI.ScannerPopup+VideoSurface, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public ScannerPopup_VideoSurface(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == ScannerPopup_VideoSurface.class) {
            TypeManager.Activate("UI.ScannerPopup+VideoSurface, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public void onAutoFocus(boolean z, Camera camera) {
        n_onAutoFocus(z, camera);
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
