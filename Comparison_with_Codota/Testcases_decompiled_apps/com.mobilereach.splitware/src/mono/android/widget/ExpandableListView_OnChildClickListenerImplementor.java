package mono.android.widget;

import android.view.View;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ExpandableListView_OnChildClickListenerImplementor implements IGCUserPeer, ExpandableListView.OnChildClickListener {
    public static final String __md_methods = "n_onChildClick:(Landroid/widget/ExpandableListView;Landroid/view/View;IIJ)Z:GetOnChildClick_Landroid_widget_ExpandableListView_Landroid_view_View_IIJHandler:Android.Widget.ExpandableListView/IOnChildClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j);

    static {
        Runtime.register("Android.Widget.ExpandableListView+IOnChildClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ExpandableListView_OnChildClickListenerImplementor.class, __md_methods);
    }

    public ExpandableListView_OnChildClickListenerImplementor() throws Throwable {
        if (getClass() == ExpandableListView_OnChildClickListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.ExpandableListView+IOnChildClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        return n_onChildClick(expandableListView, view, i, i2, j);
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
