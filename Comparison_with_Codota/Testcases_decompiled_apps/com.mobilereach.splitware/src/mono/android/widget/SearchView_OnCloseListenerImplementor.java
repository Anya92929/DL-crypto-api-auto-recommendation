package mono.android.widget;

import android.widget.SearchView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SearchView_OnCloseListenerImplementor implements IGCUserPeer, SearchView.OnCloseListener {
    public static final String __md_methods = "n_onClose:()Z:GetOnCloseHandler:Android.Widget.SearchView/IOnCloseListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onClose();

    static {
        Runtime.register("Android.Widget.SearchView+IOnCloseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SearchView_OnCloseListenerImplementor.class, __md_methods);
    }

    public SearchView_OnCloseListenerImplementor() throws Throwable {
        if (getClass() == SearchView_OnCloseListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.SearchView+IOnCloseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onClose() {
        return n_onClose();
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
