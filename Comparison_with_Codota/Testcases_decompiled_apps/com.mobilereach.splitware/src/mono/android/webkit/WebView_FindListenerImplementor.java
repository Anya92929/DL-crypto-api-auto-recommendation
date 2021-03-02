package mono.android.webkit;

import android.webkit.WebView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class WebView_FindListenerImplementor implements IGCUserPeer, WebView.FindListener {
    public static final String __md_methods = "n_onFindResultReceived:(IIZ)V:GetOnFindResultReceived_IIZHandler:Android.Webkit.WebView/IFindListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onFindResultReceived(int i, int i2, boolean z);

    static {
        Runtime.register("Android.Webkit.WebView+IFindListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", WebView_FindListenerImplementor.class, __md_methods);
    }

    public WebView_FindListenerImplementor() throws Throwable {
        if (getClass() == WebView_FindListenerImplementor.class) {
            TypeManager.Activate("Android.Webkit.WebView+IFindListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onFindResultReceived(int i, int i2, boolean z) {
        n_onFindResultReceived(i, i2, z);
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
