package mono.android.widget;

import android.widget.ExpandableListView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ExpandableListView_OnGroupCollapseListenerImplementor implements IGCUserPeer, ExpandableListView.OnGroupCollapseListener {
    public static final String __md_methods = "n_onGroupCollapse:(I)V:GetOnGroupCollapse_IHandler:Android.Widget.ExpandableListView/IOnGroupCollapseListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onGroupCollapse(int i);

    static {
        Runtime.register("Android.Widget.ExpandableListView+IOnGroupCollapseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ExpandableListView_OnGroupCollapseListenerImplementor.class, __md_methods);
    }

    public ExpandableListView_OnGroupCollapseListenerImplementor() throws Throwable {
        if (getClass() == ExpandableListView_OnGroupCollapseListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.ExpandableListView+IOnGroupCollapseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onGroupCollapse(int i) {
        n_onGroupCollapse(i);
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
