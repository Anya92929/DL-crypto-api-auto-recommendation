package mono.android.content;

import android.content.Loader;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Loader_OnLoadCanceledListenerImplementor implements IGCUserPeer, Loader.OnLoadCanceledListener {
    public static final String __md_methods = "n_onLoadCanceled:(Landroid/content/Loader;)V:GetOnLoadCanceled_Landroid_content_Loader_Handler:Android.Content.Loader/IOnLoadCanceledListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onLoadCanceled(Loader loader);

    static {
        Runtime.register("Android.Content.Loader+IOnLoadCanceledListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Loader_OnLoadCanceledListenerImplementor.class, __md_methods);
    }

    public Loader_OnLoadCanceledListenerImplementor() throws Throwable {
        if (getClass() == Loader_OnLoadCanceledListenerImplementor.class) {
            TypeManager.Activate("Android.Content.Loader+IOnLoadCanceledListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
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
