package mono.android.support.p006v4.content;

import android.support.p000v4.content.Loader;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.content.Loader_OnLoadCanceledListenerImplementor */
public class Loader_OnLoadCanceledListenerImplementor implements IGCUserPeer, Loader.OnLoadCanceledListener {
    public static final String __md_methods = "n_onLoadCanceled:(Landroid/support/v4/content/Loader;)V:GetOnLoadCanceled_Landroid_support_v4_content_Loader_Handler:Android.Support.V4.Content.Loader/IOnLoadCanceledListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onLoadCanceled(Loader loader);

    static {
        Runtime.register("Android.Support.V4.Content.Loader+IOnLoadCanceledListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", Loader_OnLoadCanceledListenerImplementor.class, __md_methods);
    }

    public Loader_OnLoadCanceledListenerImplementor() throws Throwable {
        if (getClass() == Loader_OnLoadCanceledListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.Content.Loader+IOnLoadCanceledListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onLoadCanceled(Loader loader) {
        n_onLoadCanceled(loader);
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
