package md5f9df3643678d96b24d7c271c54ce6e2d;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import md529e4c2c8a026201f3a493bfa20264e47.PopupPane;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PopupButtonPane extends PopupPane implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Listview.PopupButtonPane, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", PopupButtonPane.class, __md_methods);
    }

    public PopupButtonPane(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == PopupButtonPane.class) {
            TypeManager.Activate("Listview.PopupButtonPane, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public PopupButtonPane(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == PopupButtonPane.class) {
            TypeManager.Activate("Listview.PopupButtonPane, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public PopupButtonPane(int i, int i2) throws Throwable {
        super(i, i2);
        if (getClass() == PopupButtonPane.class) {
            TypeManager.Activate("Listview.PopupButtonPane, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
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
