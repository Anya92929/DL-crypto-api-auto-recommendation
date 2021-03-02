package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Table_3_TableListView extends ListView implements IGCUserPeer {
    public static final String __md_methods = "n_getSuggestedMinimumHeight:()I:GetGetSuggestedMinimumHeightHandler\nn_getMinimumHeight:()I:GetGetMinimumHeightHandler\nn_layoutChildren:()V:GetLayoutChildrenHandler\n";
    private ArrayList refList;

    private native int n_getMinimumHeight();

    private native int n_getSuggestedMinimumHeight();

    private native void n_layoutChildren();

    static {
        Runtime.register("Controls.Table`3+TableListView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", Table_3_TableListView.class, __md_methods);
    }

    public Table_3_TableListView(Context context) throws Throwable {
        super(context);
        if (getClass() == Table_3_TableListView.class) {
            TypeManager.Activate("Controls.Table`3+TableListView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public Table_3_TableListView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == Table_3_TableListView.class) {
            TypeManager.Activate("Controls.Table`3+TableListView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public Table_3_TableListView(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == Table_3_TableListView.class) {
            TypeManager.Activate("Controls.Table`3+TableListView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public int getSuggestedMinimumHeight() {
        return n_getSuggestedMinimumHeight();
    }

    public int getMinimumHeight() {
        return n_getMinimumHeight();
    }

    public void layoutChildren() {
        n_layoutChildren();
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
