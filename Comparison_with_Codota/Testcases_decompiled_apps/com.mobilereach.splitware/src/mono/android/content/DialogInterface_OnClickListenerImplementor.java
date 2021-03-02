package mono.android.content;

import android.content.DialogInterface;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class DialogInterface_OnClickListenerImplementor implements IGCUserPeer, DialogInterface.OnClickListener {
    public static final String __md_methods = "n_onClick:(Landroid/content/DialogInterface;I)V:GetOnClick_Landroid_content_DialogInterface_IHandler:Android.Content.IDialogInterfaceOnClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onClick(DialogInterface dialogInterface, int i);

    static {
        Runtime.register("Android.Content.IDialogInterfaceOnClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", DialogInterface_OnClickListenerImplementor.class, __md_methods);
    }

    public DialogInterface_OnClickListenerImplementor() throws Throwable {
        if (getClass() == DialogInterface_OnClickListenerImplementor.class) {
            TypeManager.Activate("Android.Content.IDialogInterfaceOnClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        n_onClick(dialogInterface, i);
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
