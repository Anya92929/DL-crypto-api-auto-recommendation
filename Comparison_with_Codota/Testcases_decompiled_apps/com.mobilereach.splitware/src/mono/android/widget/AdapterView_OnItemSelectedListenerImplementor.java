package mono.android.widget;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AdapterView_OnItemSelectedListenerImplementor implements IGCUserPeer, AdapterView.OnItemSelectedListener {
    public static final String __md_methods = "n_onItemSelected:(Landroid/widget/AdapterView;Landroid/view/View;IJ)V:GetOnItemSelected_Landroid_widget_AdapterView_Landroid_view_View_IJHandler:Android.Widget.AdapterView/IOnItemSelectedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onNothingSelected:(Landroid/widget/AdapterView;)V:GetOnNothingSelected_Landroid_widget_AdapterView_Handler:Android.Widget.AdapterView/IOnItemSelectedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onItemSelected(AdapterView adapterView, View view, int i, long j);

    private native void n_onNothingSelected(AdapterView adapterView);

    static {
        Runtime.register("Android.Widget.AdapterView+IOnItemSelectedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AdapterView_OnItemSelectedListenerImplementor.class, __md_methods);
    }

    public AdapterView_OnItemSelectedListenerImplementor() throws Throwable {
        if (getClass() == AdapterView_OnItemSelectedListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.AdapterView+IOnItemSelectedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        n_onItemSelected(adapterView, view, i, j);
    }

    public void onNothingSelected(AdapterView adapterView) {
        n_onNothingSelected(adapterView);
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
