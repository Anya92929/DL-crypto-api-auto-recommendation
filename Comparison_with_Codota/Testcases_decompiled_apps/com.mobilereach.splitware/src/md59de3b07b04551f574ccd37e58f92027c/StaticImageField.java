package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class StaticImageField extends ControlBase implements IGCUserPeer {
    public static final String __md_methods = "n_getSuggestedMinimumHeight:()I:GetGetSuggestedMinimumHeightHandler\n";
    private ArrayList refList;

    private native int n_getSuggestedMinimumHeight();

    static {
        Runtime.register("Controls.StaticImageField, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", StaticImageField.class, __md_methods);
    }

    public StaticImageField(Context context) throws Throwable {
        super(context);
        if (getClass() == StaticImageField.class) {
            TypeManager.Activate("Controls.StaticImageField, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public StaticImageField(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == StaticImageField.class) {
            TypeManager.Activate("Controls.StaticImageField, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public StaticImageField(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == StaticImageField.class) {
            TypeManager.Activate("Controls.StaticImageField, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public int getSuggestedMinimumHeight() {
        return n_getSuggestedMinimumHeight();
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
