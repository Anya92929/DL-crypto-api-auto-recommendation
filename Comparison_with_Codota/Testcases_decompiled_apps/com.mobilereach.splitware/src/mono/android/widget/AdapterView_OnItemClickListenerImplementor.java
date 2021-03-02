package mono.android.widget;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AdapterView_OnItemClickListenerImplementor implements IGCUserPeer, AdapterView.OnItemClickListener {
    public static final String __md_methods = "n_onItemClick:(Landroid/widget/AdapterView;Landroid/view/View;IJ)V:GetOnItemClick_Landroid_widget_AdapterView_Landroid_view_View_IJHandler:Android.Widget.AdapterView/IOnItemClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onItemClick(AdapterView adapterView, View view, int i, long j);

    static {
        Runtime.register("Android.Widget.AdapterView+IOnItemClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AdapterView_OnItemClickListenerImplementor.class, __md_methods);
    }

    public AdapterView_OnItemClickListenerImplementor() throws Throwable {
        if (getClass() == AdapterView_OnItemClickListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.AdapterView+IOnItemClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        n_onItemClick(adapterView, view, i, j);
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
