package md529e4c2c8a026201f3a493bfa20264e47;

import android.app.Dialog;
import android.content.Context;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MultiSelect extends Dialog implements IGCUserPeer {
    public static final String __md_methods = "n_dismiss:()V:GetDismissHandler\n";
    private ArrayList refList;

    private native void n_dismiss();

    static {
        Runtime.register("UI.MultiSelect, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", MultiSelect.class, __md_methods);
    }

    public MultiSelect(Context context) throws Throwable {
        super(context);
        if (getClass() == MultiSelect.class) {
            TypeManager.Activate("UI.MultiSelect, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
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
