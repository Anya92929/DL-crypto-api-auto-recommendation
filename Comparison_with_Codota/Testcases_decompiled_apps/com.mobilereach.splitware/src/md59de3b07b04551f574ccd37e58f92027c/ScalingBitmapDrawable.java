package md59de3b07b04551f574ccd37e58f92027c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ScalingBitmapDrawable extends Drawable implements IGCUserPeer {
    public static final String __md_methods = "n_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\nn_getOpacity:()I:GetGetOpacityHandler\nn_setAlpha:(I)V:GetSetAlpha_IHandler\nn_setColorFilter:(Landroid/graphics/ColorFilter;)V:GetSetColorFilter_Landroid_graphics_ColorFilter_Handler\n";
    private ArrayList refList;

    private native void n_draw(Canvas canvas);

    private native int n_getOpacity();

    private native void n_setAlpha(int i);

    private native void n_setColorFilter(ColorFilter colorFilter);

    static {
        Runtime.register("Controls.ScalingBitmapDrawable, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", ScalingBitmapDrawable.class, __md_methods);
    }

    public ScalingBitmapDrawable() throws Throwable {
        if (getClass() == ScalingBitmapDrawable.class) {
            TypeManager.Activate("Controls.ScalingBitmapDrawable, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void draw(Canvas canvas) {
        n_draw(canvas);
    }

    public int getOpacity() {
        return n_getOpacity();
    }

    public void setAlpha(int i) {
        n_setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        n_setColorFilter(colorFilter);
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
