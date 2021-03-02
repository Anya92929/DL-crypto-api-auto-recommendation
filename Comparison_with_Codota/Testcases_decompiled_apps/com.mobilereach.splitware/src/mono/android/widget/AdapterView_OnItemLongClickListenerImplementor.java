package mono.android.widget;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AdapterView_OnItemLongClickListenerImplementor implements IGCUserPeer, AdapterView.OnItemLongClickListener {
    public static final String __md_methods = "n_onItemLongClick:(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z:GetOnItemLongClick_Landroid_widget_AdapterView_Landroid_view_View_IJHandler:Android.Widget.AdapterView/IOnItemLongClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onItemLongClick(AdapterView adapterView, View view, int i, long j);

    static {
        Runtime.register("Android.Widget.AdapterView+IOnItemLongClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AdapterView_OnItemLongClickListenerImplementor.class, __md_methods);
    }

    public AdapterView_OnItemLongClickListenerImplementor() throws Throwable {
        if (getClass() == AdapterView_OnItemLongClickListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.AdapterView+IOnItemLongClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        return n_onItemLongClick(adapterView, view, i, j);
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
