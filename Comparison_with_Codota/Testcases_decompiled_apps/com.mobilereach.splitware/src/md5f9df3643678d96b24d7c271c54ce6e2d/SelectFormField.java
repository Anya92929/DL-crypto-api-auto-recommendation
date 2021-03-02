package md5f9df3643678d96b24d7c271c54ce6e2d;

import android.app.Dialog;
import android.content.Context;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SelectFormField extends Dialog implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Listview.SelectFormField, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", SelectFormField.class, __md_methods);
    }

    public SelectFormField(Context context) throws Throwable {
        super(context);
        if (getClass() == SelectFormField.class) {
            TypeManager.Activate("Listview.SelectFormField, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
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
