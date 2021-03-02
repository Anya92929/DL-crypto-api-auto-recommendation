package mono.android.support.p006v4.widget;

import android.support.p000v4.widget.DrawerLayout;
import android.view.View;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.widget.DrawerLayout_DrawerListenerImplementor */
public class DrawerLayout_DrawerListenerImplementor implements IGCUserPeer, DrawerLayout.DrawerListener {
    public static final String __md_methods = "n_onDrawerClosed:(Landroid/view/View;)V:GetOnDrawerClosed_Landroid_view_View_Handler:Android.Support.V4.Widget.DrawerLayout/IDrawerListenerInvoker, Xamarin.Android.Support.v4\nn_onDrawerOpened:(Landroid/view/View;)V:GetOnDrawerOpened_Landroid_view_View_Handler:Android.Support.V4.Widget.DrawerLayout/IDrawerListenerInvoker, Xamarin.Android.Support.v4\nn_onDrawerSlide:(Landroid/view/View;F)V:GetOnDrawerSlide_Landroid_view_View_FHandler:Android.Support.V4.Widget.DrawerLayout/IDrawerListenerInvoker, Xamarin.Android.Support.v4\nn_onDrawerStateChanged:(I)V:GetOnDrawerStateChanged_IHandler:Android.Support.V4.Widget.DrawerLayout/IDrawerListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onDrawerClosed(View view);

    private native void n_onDrawerOpened(View view);

    private native void n_onDrawerSlide(View view, float f);

    private native void n_onDrawerStateChanged(int i);

    static {
        Runtime.register("Android.Support.V4.Widget.DrawerLayout+IDrawerListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", DrawerLayout_DrawerListenerImplementor.class, __md_methods);
    }

    public DrawerLayout_DrawerListenerImplementor() throws Throwable {
        if (getClass() == DrawerLayout_DrawerListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.Widget.DrawerLayout+IDrawerListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onDrawerClosed(View view) {
        n_onDrawerClosed(view);
    }

    public void onDrawerOpened(View view) {
        n_onDrawerOpened(view);
    }

    public void onDrawerSlide(View view, float f) {
        n_onDrawerSlide(view, f);
    }

    public void onDrawerStateChanged(int i) {
        n_onDrawerStateChanged(i);
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
