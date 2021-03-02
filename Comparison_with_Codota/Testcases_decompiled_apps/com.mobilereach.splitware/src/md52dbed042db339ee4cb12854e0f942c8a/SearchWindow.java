package md52dbed042db339ee4cb12854e0f942c8a;

import android.app.Dialog;
import android.content.Context;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SearchWindow extends Dialog implements IGCUserPeer {
    public static final String __md_methods = "n_dismiss:()V:GetDismissHandler\n";
    private ArrayList refList;

    private native void n_dismiss();

    static {
        Runtime.register("Recview.SearchWindow, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", SearchWindow.class, __md_methods);
    }

    public SearchWindow(Context context) throws Throwable {
        super(context);
        if (getClass() == SearchWindow.class) {
            TypeManager.Activate("Recview.SearchWindow, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
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
