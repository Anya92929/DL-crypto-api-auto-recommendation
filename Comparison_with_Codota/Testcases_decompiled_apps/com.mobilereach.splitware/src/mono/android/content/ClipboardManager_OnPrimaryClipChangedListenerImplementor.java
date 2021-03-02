package mono.android.content;

import android.content.ClipboardManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ClipboardManager_OnPrimaryClipChangedListenerImplementor implements IGCUserPeer, ClipboardManager.OnPrimaryClipChangedListener {
    public static final String __md_methods = "n_onPrimaryClipChanged:()V:GetOnPrimaryClipChangedHandler:Android.Content.ClipboardManager/IOnPrimaryClipChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onPrimaryClipChanged();

    static {
        Runtime.register("Android.Content.ClipboardManager+IOnPrimaryClipChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ClipboardManager_OnPrimaryClipChangedListenerImplementor.class, __md_methods);
    }

    public ClipboardManager_OnPrimaryClipChangedListenerImplementor() throws Throwable {
        if (getClass() == ClipboardManager_OnPrimaryClipChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Content.ClipboardManager+IOnPrimaryClipChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onPrimaryClipChanged() {
        n_onPrimaryClipChanged();
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
