package mono.android.view;

import android.view.DragEvent;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnDragListenerImplementor implements IGCUserPeer, View.OnDragListener {
    public static final String __md_methods = "n_onDrag:(Landroid/view/View;Landroid/view/DragEvent;)Z:GetOnDrag_Landroid_view_View_Landroid_view_DragEvent_Handler:Android.Views.View/IOnDragListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onDrag(View view, DragEvent dragEvent);

    static {
        Runtime.register("Android.Views.View+IOnDragListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnDragListenerImplementor.class, __md_methods);
    }

    public View_OnDragListenerImplementor() throws Throwable {
        if (getClass() == View_OnDragListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnDragListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onDrag(View view, DragEvent dragEvent) {
        return n_onDrag(view, dragEvent);
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
