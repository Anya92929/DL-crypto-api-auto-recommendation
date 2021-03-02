package md59de3b07b04551f574ccd37e58f92027c;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Table_3_TableAdapter extends BaseAdapter implements IGCUserPeer {
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
        Runtime.register("Controls.Table`3+TableAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", Table_3_TableAdapter.class, __md_methods);
    }

    public Table_3_TableAdapter() throws Throwable {
        if (getClass() == Table_3_TableAdapter.class) {
            TypeManager.Activate("Controls.Table`3+TableAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public Table_3_TableAdapter(Table_3 table_3) throws Throwable {
        if (getClass() == Table_3_TableAdapter.class) {
            TypeManager.Activate("Controls.Table`3+TableAdapter, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Controls.Table`3<Cell,CellLayout,DataType>, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", this, new Object[]{table_3});
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
