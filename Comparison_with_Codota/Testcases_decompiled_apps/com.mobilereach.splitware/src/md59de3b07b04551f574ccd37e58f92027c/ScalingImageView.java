package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ScalingImageView extends View implements IGCUserPeer {
    public static final String __md_methods = "n_getSuggestedMinimumHeight:()I:GetGetSuggestedMinimumHeightHandler\nn_onMeasure:(II)V:GetOnMeasure_IIHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\n";
    private ArrayList refList;

    private native void n_draw(Canvas canvas);

    private native int n_getSuggestedMinimumHeight();

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onMeasure(int i, int i2);

    static {
        Runtime.register("Controls.ScalingImageView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", ScalingImageView.class, __md_methods);
    }

    public ScalingImageView(Context context) throws Throwable {
        super(context);
        if (getClass() == ScalingImageView.class) {
            TypeManager.Activate("Controls.ScalingImageView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public ScalingImageView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == ScalingImageView.class) {
            TypeManager.Activate("Controls.ScalingImageView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public ScalingImageView(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == ScalingImageView.class) {
            TypeManager.Activate("Controls.ScalingImageView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public int getSuggestedMinimumHeight() {
        return n_getSuggestedMinimumHeight();
    }

    public void onMeasure(int i, int i2) {
        n_onMeasure(i, i2);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    public void draw(Canvas canvas) {
        n_draw(canvas);
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