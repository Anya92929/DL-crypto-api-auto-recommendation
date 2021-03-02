package mono.android.support.p006v4.widget;

import android.support.p000v4.widget.SlidingPaneLayout;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.widget.SlidingPaneLayout_PanelSlideListenerImplementor */
public class SlidingPaneLayout_PanelSlideListenerImplementor implements IGCUserPeer, SlidingPaneLayout.PanelSlideListener {
    public static final String __md_methods = "n_onPanelClosed:(Landroid/view/View;)V:GetOnPanelClosed_Landroid_view_View_Handler:Android.Support.V4.Widget.SlidingPaneLayout/IPanelSlideListenerInvoker, Xamarin.Android.Support.v4\nn_onPanelOpened:(Landroid/view/View;)V:GetOnPanelOpened_Landroid_view_View_Handler:Android.Support.V4.Widget.SlidingPaneLayout/IPanelSlideListenerInvoker, Xamarin.Android.Support.v4\nn_onPanelSlide:(Landroid/view/View;F)V:GetOnPanelSlide_Landroid_view_View_FHandler:Android.Support.V4.Widget.SlidingPaneLayout/IPanelSlideListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onPanelClosed(View view);

    private native void n_onPanelOpened(View view);

    private native void n_onPanelSlide(View view, float f);

    static {
        Runtime.register("Android.Support.V4.Widget.SlidingPaneLayout+IPanelSlideListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", SlidingPaneLayout_PanelSlideListenerImplementor.class, __md_methods);
    }

    public SlidingPaneLayout_PanelSlideListenerImplementor() throws Throwable {
        if (getClass() == SlidingPaneLayout_PanelSlideListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.Widget.SlidingPaneLayout+IPanelSlideListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onPanelClosed(View view) {
        n_onPanelClosed(view);
    }

    public void onPanelOpened(View view) {
        n_onPanelOpened(view);
    }

    public void onPanelSlide(View view, float f) {
        n_onPanelSlide(view, f);
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
