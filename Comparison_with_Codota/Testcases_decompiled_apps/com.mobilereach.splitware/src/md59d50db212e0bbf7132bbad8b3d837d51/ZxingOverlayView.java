package md59d50db212e0bbf7132bbad8b3d837d51;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ZxingOverlayView extends View implements IGCUserPeer {
    public static final String __md_methods = "n_onDraw:(Landroid/graphics/Canvas;)V:GetOnDraw_Landroid_graphics_Canvas_Handler\n";
    private ArrayList refList;

    private native void n_onDraw(Canvas canvas);

    static {
        Runtime.register("ZXing.Mobile.ZxingOverlayView, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", ZxingOverlayView.class, __md_methods);
    }

    public ZxingOverlayView(Context context) throws Throwable {
        super(context);
        if (getClass() == ZxingOverlayView.class) {
            TypeManager.Activate("ZXing.Mobile.ZxingOverlayView, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public ZxingOverlayView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == ZxingOverlayView.class) {
            TypeManager.Activate("ZXing.Mobile.ZxingOverlayView, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public ZxingOverlayView(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == ZxingOverlayView.class) {
            TypeManager.Activate("ZXing.Mobile.ZxingOverlayView, ZXingNetMobile, Version=2.0.4.46, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public void onDraw(Canvas canvas) {
        n_onDraw(canvas);
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
