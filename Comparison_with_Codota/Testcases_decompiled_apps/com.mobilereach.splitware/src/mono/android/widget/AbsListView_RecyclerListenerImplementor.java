package mono.android.widget;

import android.view.View;
import android.widget.AbsListView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AbsListView_RecyclerListenerImplementor implements IGCUserPeer, AbsListView.RecyclerListener {
    public static final String __md_methods = "n_onMovedToScrapHeap:(Landroid/view/View;)V:GetOnMovedToScrapHeap_Landroid_view_View_Handler:Android.Widget.AbsListView/IRecyclerListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onMovedToScrapHeap(View view);

    static {
        Runtime.register("Android.Widget.AbsListView+IRecyclerListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AbsListView_RecyclerListenerImplementor.class, __md_methods);
    }

    public AbsListView_RecyclerListenerImplementor() throws Throwable {
        if (getClass() == AbsListView_RecyclerListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.AbsListView+IRecyclerListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onMovedToScrapHeap(View view) {
        n_onMovedToScrapHeap(view);
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
