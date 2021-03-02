package md59d50db212e0bbf7132bbad8b3d837d51;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ZXingSurfaceView extends SurfaceView implements IGCUserPeer, SurfaceHolder.Callback, Camera.PreviewCallback, Camera.AutoFocusCallback {
    public static final String __md_methods = "n_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\nn_surfaceChanged:(Landroid/view/SurfaceHolder;III)V:GetSurfaceChanged_Landroid_view_SurfaceHolder_IIIHandler:Android.Views.ISurfaceHolderCallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_surfaceCreated:(Landroid/view/SurfaceHolder;)V:GetSurfaceCreated_Landroid_view_SurfaceHolder_Handler:Android.Views.ISurfaceHolderCallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_surfaceDestroyed:(Landroid/view/SurfaceHolder;)V:GetSurfaceDestroyed_Landroid_view_SurfaceHolder_Handler:Android.Views.ISurfaceHolderCallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onPreviewFrame:([BLandroid/hardware/Camera;)V:GetOnPreviewFrame_arrayBLandroid_hardware_Camera_Handler:Android.Hardware.Camera/IPreviewCallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onAutoFocus:(ZLandroid/hardware/Camera;)V:GetOnAutoFocus_ZLandroid_hardware_Camera_Handler:Android.Hardware.Camera/IAutoFocusCallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAutoFocus(boolean z, Camera camera);

    private native void n_onPreviewFrame(byte[] bArr, Camera camera);

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    private native void n_surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    private native void n_surfaceCreated(SurfaceHolder surfaceHolder);

    private native void n_surfaceDestroyed(SurfaceHolder surfaceHolder);

    static {
        Runtime.register("ZXing.Mobile.ZXingSurfaceView, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", ZXingSurfaceView.class, __md_methods);
    }

    public ZXingSurfaceView(Context context) throws Throwable {
        super(context);
        if (getClass() == ZXingSurfaceView.class) {
            TypeManager.Activate("ZXing.Mobile.ZXingSurfaceView, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public ZXingSurfaceView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == ZXingSurfaceView.class) {
            TypeManager.Activate("ZXing.Mobile.ZXingSurfaceView, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public ZXingSurfaceView(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == ZXingSurfaceView.class) {
            TypeManager.Activate("ZXing.Mobile.ZXingSurfaceView, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        n_surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        n_surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        n_surfaceDestroyed(surfaceHolder);
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        n_onPreviewFrame(bArr, camera);
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
