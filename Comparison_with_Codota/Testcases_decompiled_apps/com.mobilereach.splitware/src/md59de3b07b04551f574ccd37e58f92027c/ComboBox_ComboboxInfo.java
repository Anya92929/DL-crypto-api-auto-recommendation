package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ComboBox_ComboboxInfo extends ArrayAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\nn_getDropDownView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetDropDownView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\n";
    private ArrayList refList;

    private native View n_getDropDownView(int i, View view, ViewGroup viewGroup);

    private native View n_getView(int i, View view, ViewGroup viewGroup);

    static {
        Runtime.register("Controls.ComboBox+ComboboxInfo, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", ComboBox_ComboboxInfo.class, __md_methods);
    }

    public ComboBox_ComboboxInfo(Context context, int i) throws Throwable {
        super(context, i);
        if (getClass() == ComboBox_ComboboxInfo.class) {
            TypeManager.Activate("Controls.ComboBox+ComboboxInfo, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, Integer.valueOf(i)});
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
