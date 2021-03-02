package mono.android.view;

import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnSystemUiVisibilityChangeListenerImplementor implements IGCUserPeer, View.OnSystemUiVisibilityChangeListener {
    public static final String __md_methods = "n_onSystemUiVisibilityChange:(I)V:GetOnSystemUiVisibilityChange_IHandler:Android.Views.View/IOnSystemUiVisibilityChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onSystemUiVisibilityChange(int i);

    static {
        Runtime.register("Android.Views.View+IOnSystemUiVisibilityChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnSystemUiVisibilityChangeListenerImplementor.class, __md_methods);
    }

    public View_OnSystemUiVisibilityChangeListenerImplementor() throws Throwable {
        if (getClass() == View_OnSystemUiVisibilityChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnSystemUiVisibilityChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onSystemUiVisibilityChange(int i) {
        n_onSystemUiVisibilityChange(i);
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
