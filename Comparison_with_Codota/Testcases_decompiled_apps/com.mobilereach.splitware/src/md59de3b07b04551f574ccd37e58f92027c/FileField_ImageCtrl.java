package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class FileField_ImageCtrl extends View implements IGCUserPeer, ScaleGestureDetector.OnScaleGestureListener {
    public static final String __md_methods = "n_getSuggestedMinimumHeight:()I:GetGetSuggestedMinimumHeightHandler\nn_getMinimumHeight:()I:GetGetMinimumHeightHandler\nn_onMeasure:(II)V:GetOnMeasure_IIHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_draw:(Landroid/graphics/Canvas;)V:GetDraw_Landroid_graphics_Canvas_Handler\nn_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\nn_onScale:(Landroid/view/ScaleGestureDetector;)Z:GetOnScale_Landroid_view_ScaleGestureDetector_Handler:Android.Views.ScaleGestureDetector/IOnScaleGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onScaleBegin:(Landroid/view/ScaleGestureDetector;)Z:GetOnScaleBegin_Landroid_view_ScaleGestureDetector_Handler:Android.Views.ScaleGestureDetector/IOnScaleGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onScaleEnd:(Landroid/view/ScaleGestureDetector;)V:GetOnScaleEnd_Landroid_view_ScaleGestureDetector_Handler:Android.Views.ScaleGestureDetector/IOnScaleGestureListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_draw(Canvas canvas);

    private native int n_getMinimumHeight();

    private native int n_getSuggestedMinimumHeight();

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onMeasure(int i, int i2);

    private native boolean n_onScale(ScaleGestureDetector scaleGestureDetector);

    private native boolean n_onScaleBegin(ScaleGestureDetector scaleGestureDetector);

    private native void n_onScaleEnd(ScaleGestureDetector scaleGestureDetector);

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    static {
        Runtime.register("Controls.FileField+ImageCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", FileField_ImageCtrl.class, __md_methods);
    }

    public FileField_ImageCtrl(Context context) throws Throwable {
        super(context);
        if (getClass() == FileField_ImageCtrl.class) {
            TypeManager.Activate("Controls.FileField+ImageCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public FileField_ImageCtrl(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == FileField_ImageCtrl.class) {
            TypeManager.Activate("Controls.FileField+ImageCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public FileField_ImageCtrl(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == FileField_ImageCtrl.class) {
            TypeManager.Activate("Controls.FileField+ImageCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public int getSuggestedMinimumHeight() {
        return n_getSuggestedMinimumHeight();
    }

    public int getMinimumHeight() {
        return n_getMinimumHeight();
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

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return n_onScale(scaleGestureDetector);
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return n_onScaleBegin(scaleGestureDetector);
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        n_onScaleEnd(scaleGestureDetector);
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
