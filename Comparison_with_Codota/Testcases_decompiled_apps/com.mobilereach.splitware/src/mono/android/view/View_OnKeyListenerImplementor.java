package mono.android.view;

import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnKeyListenerImplementor implements IGCUserPeer, View.OnKeyListener {
    public static final String __md_methods = "n_onKey:(Landroid/view/View;ILandroid/view/KeyEvent;)Z:GetOnKey_Landroid_view_View_ILandroid_view_KeyEvent_Handler:Android.Views.View/IOnKeyListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onKey(View view, int i, KeyEvent keyEvent);

    static {
        Runtime.register("Android.Views.View+IOnKeyListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnKeyListenerImplementor.class, __md_methods);
    }

    public View_OnKeyListenerImplementor() throws Throwable {
        if (getClass() == View_OnKeyListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnKeyListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return n_onKey(view, i, keyEvent);
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
