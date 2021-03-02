package mono.android.support.p006v4.widget;

import android.support.p000v4.widget.NestedScrollView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.widget.NestedScrollView_OnScrollChangeListenerImplementor */
public class NestedScrollView_OnScrollChangeListenerImplementor implements IGCUserPeer, NestedScrollView.OnScrollChangeListener {
    public static final String __md_methods = "n_onScrollChange:(Landroid/support/v4/widget/NestedScrollView;IIII)V:GetOnScrollChange_Landroid_support_v4_widget_NestedScrollView_IIIIHandler:Android.Support.V4.Widget.NestedScrollView/IOnScrollChangeListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);

    static {
        Runtime.register("Android.Support.V4.Widget.NestedScrollView+IOnScrollChangeListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", NestedScrollView_OnScrollChangeListenerImplementor.class, __md_methods);
    }

    public NestedScrollView_OnScrollChangeListenerImplementor() throws Throwable {
        if (getClass() == NestedScrollView_OnScrollChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.Widget.NestedScrollView+IOnScrollChangeListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        n_onScrollChange(nestedScrollView, i, i2, i3, i4);
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
