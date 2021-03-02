package md57dd576a266c5b1214c1c1187fb768648;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AppManager_Table_Info extends ArrayAdapter implements IGCUserPeer {
    public static final String __md_methods = "n_getViewTypeCount:()I:GetGetViewTypeCountHandler\nn_areAllItemsEnabled:()Z:GetAreAllItemsEnabledHandler\nn_isEnabled:(I)Z:GetIsEnabled_IHandler\nn_getItemViewType:(I)I:GetGetItemViewType_IHandler\nn_getView:(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;:GetGetView_ILandroid_view_View_Landroid_view_ViewGroup_Handler\n";
    private ArrayList refList;

    private native boolean n_areAllItemsEnabled();

    private native int n_getItemViewType(int i);

    private native View n_getView(int i, View view, ViewGroup viewGroup);

    private native int n_getViewTypeCount();

    private native boolean n_isEnabled(int i);

    static {
        Runtime.register("AppManager.AppManager+Table+Info, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", AppManager_Table_Info.class, __md_methods);
    }

    public AppManager_Table_Info(Context context, int i) throws Throwable {
        super(context, i);
        if (getClass() == AppManager_Table_Info.class) {
            TypeManager.Activate("AppManager.AppManager+Table+Info, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, Integer.valueOf(i)});
        }
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
