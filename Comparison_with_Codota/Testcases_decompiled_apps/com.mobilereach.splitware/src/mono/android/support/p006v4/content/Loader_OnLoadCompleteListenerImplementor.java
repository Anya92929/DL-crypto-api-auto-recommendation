package mono.android.support.p006v4.content;

import android.support.p000v4.content.Loader;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.support.v4.content.Loader_OnLoadCompleteListenerImplementor */
public class Loader_OnLoadCompleteListenerImplementor implements IGCUserPeer, Loader.OnLoadCompleteListener {
    public static final String __md_methods = "n_onLoadComplete:(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V:GetOnLoadComplete_Landroid_support_v4_content_Loader_Ljava_lang_Object_Handler:Android.Support.V4.Content.Loader/IOnLoadCompleteListenerInvoker, Xamarin.Android.Support.v4\n";
    private ArrayList refList;

    private native void n_onLoadComplete(Loader loader, Object obj);

    static {
        Runtime.register("Android.Support.V4.Content.Loader+IOnLoadCompleteListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", Loader_OnLoadCompleteListenerImplementor.class, __md_methods);
    }

    public Loader_OnLoadCompleteListenerImplementor() throws Throwable {
        if (getClass() == Loader_OnLoadCompleteListenerImplementor.class) {
            TypeManager.Activate("Android.Support.V4.Content.Loader+IOnLoadCompleteListenerImplementor, Xamarin.Android.Support.v4, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onLoadComplete(Loader loader, Object obj) {
        n_onLoadComplete(loader, obj);
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
