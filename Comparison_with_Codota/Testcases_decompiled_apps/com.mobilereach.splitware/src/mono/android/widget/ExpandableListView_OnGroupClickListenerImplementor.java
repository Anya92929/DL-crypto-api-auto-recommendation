package mono.android.widget;

import android.view.View;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ExpandableListView_OnGroupClickListenerImplementor implements IGCUserPeer, ExpandableListView.OnGroupClickListener {
    public static final String __md_methods = "n_onGroupClick:(Landroid/widget/ExpandableListView;Landroid/view/View;IJ)Z:GetOnGroupClick_Landroid_widget_ExpandableListView_Landroid_view_View_IJHandler:Android.Widget.ExpandableListView/IOnGroupClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onGroupClick(ExpandableListView expandableListView, View view, int i, long j);

    static {
        Runtime.register("Android.Widget.ExpandableListView+IOnGroupClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ExpandableListView_OnGroupClickListenerImplementor.class, __md_methods);
    }

    public ExpandableListView_OnGroupClickListenerImplementor() throws Throwable {
        if (getClass() == ExpandableListView_OnGroupClickListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.ExpandableListView+IOnGroupClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return n_onGroupClick(expandableListView, view, i, j);
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
