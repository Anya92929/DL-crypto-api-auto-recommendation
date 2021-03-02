package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Grid_2_GridSection extends ViewGroup implements IGCUserPeer {
    public static final String __md_methods = "n_onMeasure:(II)V:GetOnMeasure_IIHandler\nn_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\n";
    private ArrayList refList;

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native void n_onMeasure(int i, int i2);

    static {
        Runtime.register("Controls.Grid`2+GridSection, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", Grid_2_GridSection.class, __md_methods);
    }

    public Grid_2_GridSection(Context context) throws Throwable {
        super(context);
        if (getClass() == Grid_2_GridSection.class) {
            TypeManager.Activate("Controls.Grid`2+GridSection, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public Grid_2_GridSection(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == Grid_2_GridSection.class) {
            TypeManager.Activate("Controls.Grid`2+GridSection, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public Grid_2_GridSection(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == Grid_2_GridSection.class) {
            TypeManager.Activate("Controls.Grid`2+GridSection, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public void onMeasure(int i, int i2) {
        n_onMeasure(i, i2);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
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