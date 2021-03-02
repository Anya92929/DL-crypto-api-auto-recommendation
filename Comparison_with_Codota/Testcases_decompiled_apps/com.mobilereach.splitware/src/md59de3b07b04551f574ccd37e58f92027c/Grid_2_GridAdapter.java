package md59de3b07b04551f574ccd37e58f92027c;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Grid_2_GridAdapter extends BaseAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getCount:()I:GetGetCountHandler\nn_getViewTypeCount:()I:GetGetViewTypeCountHandler\nn_areAllItemsEnabled:()Z:GetAreAllItemsEnabledHandler\nn_isEnabled:(I)Z:GetIsEnabled_IHandler\nn_getItemViewType:(I)I:GetGetItemViewType_IHandler\nn_getView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\nn_getItem:(I)Ljava/lang/Object;:GetGetItem_IHandler\nn_getItemId:(I)J:GetGetItemId_IHandler\nn_registerDataSetObserver:(Landroid/database/DataSetObserver;)V:GetRegisterDataSetObserver_Landroid_database_DataSetObserver_Handler\n";
    private ArrayList refList;

    private native boolean n_areAllItemsEnabled();

    private native int n_getCount();

    private native Object n_getItem(int i);

    private native long n_getItemId(int i);

    private native int n_getItemViewType(int i);

    private native View n_getView(int i, View view, ViewGroup viewGroup);

    private native int n_getViewTypeCount();

    private native boolean n_isEnabled(int i);

    private native void n_registerDataSetObserver(DataSetObserver dataSetObserver);

    static {
        Runtime.register("Controls.Grid`2+GridAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", Grid_2_GridAdapter.class, __md_methods);
    }

    public Grid_2_GridAdapter() throws Throwable {
        if (getClass() == Grid_2_GridAdapter.class) {
            TypeManager.Activate("Controls.Grid`2+GridAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public Grid_2_GridAdapter(Grid_2 grid_2) throws Throwable {
        if (getClass() == Grid_2_GridAdapter.class) {
            TypeManager.Activate("Controls.Grid`2+GridAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Controls.Grid`2<Cell,DataType>, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", this, new Object[]{grid_2});
        }
    }

    public int getCount() {
        return n_getCount();
    }

    public int getViewTypeCount() {
        return n_getViewTypeCount();
    }

    public boolean areAllItemsEnabled() {
        return n_areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return n_isEnabled(i);
    }

    public int getItemViewType(int i) {
        return n_getItemViewType(i);
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

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        n_registerDataSetObserver(dataSetObserver);
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
