package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ComboBox_ComboView extends TextView implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Controls.ComboBox+ComboView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", ComboBox_ComboView.class, __md_methods);
    }

    public ComboBox_ComboView(Context context) throws Throwable {
        super(context);
        if (getClass() == ComboBox_ComboView.class) {
            TypeManager.Activate("Controls.ComboBox+ComboView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public ComboBox_ComboView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == ComboBox_ComboView.class) {
            TypeManager.Activate("Controls.ComboBox+ComboView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public ComboBox_ComboView(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == ComboBox_ComboView.class) {
            TypeManager.Activate("Controls.ComboBox+ComboView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
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