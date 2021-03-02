package mono.android.content;

import android.content.DialogInterface;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class DialogInterface_OnShowListenerImplementor implements IGCUserPeer, DialogInterface.OnShowListener {
    public static final String __md_methods = "n_onShow:(Landroid/content/DialogInterface;)V:GetOnShow_Landroid_content_DialogInterface_Handler:Android.Content.IDialogInterfaceOnShowListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onShow(DialogInterface dialogInterface);

    static {
        Runtime.register("Android.Content.IDialogInterfaceOnShowListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", DialogInterface_OnShowListenerImplementor.class, __md_methods);
    }

    public DialogInterface_OnShowListenerImplementor() throws Throwable {
        if (getClass() == DialogInterface_OnShowListenerImplementor.class) {
            TypeManager.Activate("Android.Content.IDialogInterfaceOnShowListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onShow(DialogInterface dialogInterface) {
        n_onShow(dialogInterface);
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
