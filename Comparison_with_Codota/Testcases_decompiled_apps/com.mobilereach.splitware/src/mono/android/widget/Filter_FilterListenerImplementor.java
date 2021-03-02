package mono.android.widget;

import android.widget.Filter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Filter_FilterListenerImplementor implements IGCUserPeer, Filter.FilterListener {
    public static final String __md_methods = "n_onFilterComplete:(I)V:GetOnFilterComplete_IHandler:Android.Widget.Filter/IFilterListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onFilterComplete(int i);

    static {
        Runtime.register("Android.Widget.Filter+IFilterListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Filter_FilterListenerImplementor.class, __md_methods);
    }

    public Filter_FilterListenerImplementor() throws Throwable {
        if (getClass() == Filter_FilterListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.Filter+IFilterListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onFilterComplete(int i) {
        n_onFilterComplete(i);
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
