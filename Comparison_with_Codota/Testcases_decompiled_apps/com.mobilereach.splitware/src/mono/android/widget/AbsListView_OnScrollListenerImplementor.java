package mono.android.widget;

import android.widget.AbsListView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AbsListView_OnScrollListenerImplementor implements IGCUserPeer, AbsListView.OnScrollListener {
    public static final String __md_methods = "n_onScroll:(Landroid/widget/AbsListView;III)V:GetOnScroll_Landroid_widget_AbsListView_IIIHandler:Android.Widget.AbsListView/IOnScrollListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onScrollStateChanged:(Landroid/widget/AbsListView;I)V:GetOnScrollStateChanged_Landroid_widget_AbsListView_IHandler:Android.Widget.AbsListView/IOnScrollListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onScroll(AbsListView absListView, int i, int i2, int i3);

    private native void n_onScrollStateChanged(AbsListView absListView, int i);

    static {
        Runtime.register("Android.Widget.AbsListView+IOnScrollListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AbsListView_OnScrollListenerImplementor.class, __md_methods);
    }

    public AbsListView_OnScrollListenerImplementor() throws Throwable {
        if (getClass() == AbsListView_OnScrollListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.AbsListView+IOnScrollListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        n_onScroll(absListView, i, i2, i3);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        n_onScrollStateChanged(absListView, i);
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
