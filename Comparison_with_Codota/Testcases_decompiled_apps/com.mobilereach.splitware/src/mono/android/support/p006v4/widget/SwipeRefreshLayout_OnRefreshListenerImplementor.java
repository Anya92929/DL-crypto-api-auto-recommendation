package mono.android.support.p006v4.widget;

import android.support.p000v4.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.widget.SwipeRefreshLayout_OnRefreshListenerImplementor */
public class SwipeRefreshLayout_OnRefreshListenerImplementor implements IGCUserPeer, SwipeRefreshLayout.OnRefreshListener {
    public static final String __md_methods = "n_onRefresh:()V:GetOnRefreshHandler:Android.Support.V4.Widget.SwipeRefreshLayout/IOnRefreshListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onRefresh();

    static {
        Runtime.register("Android.Support.V4.Widget.SwipeRefreshLayout+IOnRefreshListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", SwipeRefreshLayout_OnRefreshListenerImplementor.class, __md_methods);
    }

    public SwipeRefreshLayout_OnRefreshListenerImplementor() throws Throwable {
        if (getClass() == SwipeRefreshLayout_OnRefreshListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.Widget.SwipeRefreshLayout+IOnRefreshListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onRefresh() {
        n_onRefresh();
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
