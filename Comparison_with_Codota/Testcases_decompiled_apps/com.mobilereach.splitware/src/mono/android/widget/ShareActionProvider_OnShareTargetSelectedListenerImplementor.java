package mono.android.widget;

import android.content.Intent;
import android.widget.ShareActionProvider;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ShareActionProvider_OnShareTargetSelectedListenerImplementor implements IGCUserPeer, ShareActionProvider.OnShareTargetSelectedListener {
    public static final String __md_methods = "n_onShareTargetSelected:(Landroid/widget/ShareActionProvider;Landroid/content/Intent;)Z:GetOnShareTargetSelected_Landroid_widget_ShareActionProvider_Landroid_content_Intent_Handler:Android.Widget.ShareActionProvider/IOnShareTargetSelectedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);

    static {
        Runtime.register("Android.Widget.ShareActionProvider+IOnShareTargetSelectedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ShareActionProvider_OnShareTargetSelectedListenerImplementor.class, __md_methods);
    }

    public ShareActionProvider_OnShareTargetSelectedListenerImplementor() throws Throwable {
        if (getClass() == ShareActionProvider_OnShareTargetSelectedListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.ShareActionProvider+IOnShareTargetSelectedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent) {
        return n_onShareTargetSelected(shareActionProvider, intent);
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
