package md529e4c2c8a026201f3a493bfa20264e47;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.PopupWindow;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TabFrag_1_Sidebar extends PopupWindow implements IGCUserPeer {
    public static final String __md_methods = "n_dismiss:()V:GetDismissHandler\n";
    private ArrayList refList;

    private native void n_dismiss();

    static {
        Runtime.register("UI.TabFrag`1+Sidebar, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", TabFrag_1_Sidebar.class, __md_methods);
    }

    public TabFrag_1_Sidebar(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == TabFrag_1_Sidebar.class) {
            TypeManager.Activate("UI.TabFrag`1+Sidebar, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public TabFrag_1_Sidebar(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == TabFrag_1_Sidebar.class) {
            TypeManager.Activate("UI.TabFrag`1+Sidebar, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public TabFrag_1_Sidebar(int i, int i2) throws Throwable {
        super(i, i2);
        if (getClass() == TabFrag_1_Sidebar.class) {
            TypeManager.Activate("UI.TabFrag`1+Sidebar, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public void dismiss() {
        n_dismiss();
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
