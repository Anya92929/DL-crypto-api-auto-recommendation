package md5f9df3643678d96b24d7c271c54ce6e2d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class BarcodeSearch_ScopeAdapter extends ArrayAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\nn_getDropDownView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetDropDownView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\n";
    private ArrayList refList;

    private native View n_getDropDownView(int i, View view, ViewGroup viewGroup);

    private native View n_getView(int i, View view, ViewGroup viewGroup);

    static {
        Runtime.register("Listview.BarcodeSearch+ScopeAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", BarcodeSearch_ScopeAdapter.class, __md_methods);
    }

    public BarcodeSearch_ScopeAdapter(Context context, int i) throws Throwable {
        super(context, i);
        if (getClass() == BarcodeSearch_ScopeAdapter.class) {
            TypeManager.Activate("Listview.BarcodeSearch+ScopeAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, Integer.valueOf(i)});
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return n_getView(i, view, viewGroup);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return n_getDropDownView(i, view, viewGroup);
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
