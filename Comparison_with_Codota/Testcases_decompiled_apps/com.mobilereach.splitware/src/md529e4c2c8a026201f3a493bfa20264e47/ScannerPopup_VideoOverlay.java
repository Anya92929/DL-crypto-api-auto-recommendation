package md529e4c2c8a026201f3a493bfa20264e47;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ScannerPopup_VideoOverlay extends Drawable implements IGCUserPeer {
    public static final String __md_methods = "n_getOpacity:()I:GetGetOpacityHandler\nn_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\nn_setAlpha:(I)V:GetSetAlpha_IHandler\nn_setColorFilter:(Landroid/graphics/ColorFilter;)V:GetSetColorFilter_Landroid_graphics_ColorFilter_Handler\n";
    private ArrayList refList;

    private native void n_draw(Canvas canvas);

    private native int n_getOpacity();

    private native void n_setAlpha(int i);

    private native void n_setColorFilter(ColorFilter colorFilter);

    static {
        Runtime.register("UI.ScannerPopup+VideoOverlay, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", ScannerPopup_VideoOverlay.class, __md_methods);
    }

    public ScannerPopup_VideoOverlay() throws Throwable {
        if (getClass() == ScannerPopup_VideoOverlay.class) {
            TypeManager.Activate("UI.ScannerPopup+VideoOverlay, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public ScannerPopup_VideoOverlay(ScannerPopup scannerPopup) throws Throwable {
        if (getClass() == ScannerPopup_VideoOverlay.class) {
            TypeManager.Activate("UI.ScannerPopup+VideoOverlay, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "UI.ScannerPopup, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", this, new Object[]{scannerPopup});
        }
    }

    public int getOpacity() {
        return n_getOpacity();
    }

    public void draw(Canvas canvas) {
        n_draw(canvas);
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
