package mono.android.view;

import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class View_OnLayoutChangeListenerImplementor implements IGCUserPeer, View.OnLayoutChangeListener {
    public static final String __md_methods = "n_onLayoutChange:(Landroid/view/View;IIIIIIII)V:GetOnLayoutChange_Landroid_view_View_IIIIIIIIHandler:Android.Views.View/IOnLayoutChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    static {
        Runtime.register("Android.Views.View+IOnLayoutChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", View_OnLayoutChangeListenerImplementor.class, __md_methods);
    }

    public View_OnLayoutChangeListenerImplementor() throws Throwable {
        if (getClass() == View_OnLayoutChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Views.View+IOnLayoutChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        n_onLayoutChange(view, i, i2, i3, i4, i5, i6, i7, i8);
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
