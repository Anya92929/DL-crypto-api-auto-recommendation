package md529e4c2c8a026201f3a493bfa20264e47;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PopupFieldSelector_FieldAdapter extends BaseAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getCount:()I:GetGetCountHandler\nn_getView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\nn_getItem:(I)Ljava/lang/Object;:GetGetItem_IHandler\nn_getItemId:(I)J:GetGetItemId_IHandler\n";
    private ArrayList refList;

    private native int n_getCount();

    private native Object n_getItem(int i);

    private native long n_getItemId(int i);

    private native View n_getView(int i, View view, ViewGroup viewGroup);

    static {
        Runtime.register("UI.PopupFieldSelector+FieldAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", PopupFieldSelector_FieldAdapter.class, __md_methods);
    }

    public PopupFieldSelector_FieldAdapter() throws Throwable {
        if (getClass() == PopupFieldSelector_FieldAdapter.class) {
            TypeManager.Activate("UI.PopupFieldSelector+FieldAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public PopupFieldSelector_FieldAdapter(PopupFieldSelector popupFieldSelector) throws Throwable {
        if (getClass() == PopupFieldSelector_FieldAdapter.class) {
            TypeManager.Activate("UI.PopupFieldSelector+FieldAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "UI.PopupFieldSelector, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", this, new Object[]{popupFieldSelector});
        }
    }

    public int getCount() {
        return n_getCount();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return n_getView(i, view, viewGroup);
    }

    public Object getItem(int i) {
        return n_getItem(i);
    }

    public long getItemId(int i) {
        return n_getItemId(i);
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
