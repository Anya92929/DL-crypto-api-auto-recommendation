package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Flipper_FlipAnimation extends Animation implements IGCUserPeer {
    public static final String __md_methods = "n_initialize:(IIII)V:GetInitialize_IIIIHandler\nn_applyTransformation:(FLandroid/view/animation/Transformation;)V:GetApplyTransformation_FLandroid_view_animation_Transformation_Handler\n";
    private ArrayList refList;

    private native void n_applyTransformation(float f, Transformation transformation);

    private native void n_initialize(int i, int i2, int i3, int i4);

    static {
        Runtime.register("Controls.Flipper+FlipAnimation, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", Flipper_FlipAnimation.class, __md_methods);
    }

    public Flipper_FlipAnimation() throws Throwable {
        if (getClass() == Flipper_FlipAnimation.class) {
            TypeManager.Activate("Controls.Flipper+FlipAnimation, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public Flipper_FlipAnimation(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == Flipper_FlipAnimation.class) {
            TypeManager.Activate("Controls.Flipper+FlipAnimation, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public Flipper_FlipAnimation(ControlBase controlBase, ControlBase controlBase2) throws Throwable {
        if (getClass() == Flipper_FlipAnimation.class) {
            TypeManager.Activate("Controls.Flipper+FlipAnimation, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Controls.ControlBase, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null:Controls.ControlBase, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", this, new Object[]{controlBase, controlBase2});
        }
    }

    public void initialize(int i, int i2, int i3, int i4) {
        n_initialize(i, i2, i3, i4);
    }

    public void applyTransformation(float f, Transformation transformation) {
        n_applyTransformation(f, transformation);
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
