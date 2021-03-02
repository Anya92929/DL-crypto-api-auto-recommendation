package mono.android.content;

import android.content.DialogInterface;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class DialogInterface_OnMultiChoiceClickListenerImplementor implements IGCUserPeer, DialogInterface.OnMultiChoiceClickListener {
    public static final String __md_methods = "n_onClick:(Landroid/content/DialogInterface;IZ)V:GetOnClick_Landroid_content_DialogInterface_IZHandler:Android.Content.IDialogInterfaceOnMultiChoiceClickListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onClick(DialogInterface dialogInterface, int i, boolean z);

    static {
        Runtime.register("Android.Content.IDialogInterfaceOnMultiChoiceClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", DialogInterface_OnMultiChoiceClickListenerImplementor.class, __md_methods);
    }

    public DialogInterface_OnMultiChoiceClickListenerImplementor() throws Throwable {
        if (getClass() == DialogInterface_OnMultiChoiceClickListenerImplementor.class) {
            TypeManager.Activate("Android.Content.IDialogInterfaceOnMultiChoiceClickListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onClick(DialogInterface dialogInterface, int i, boolean z) {
        n_onClick(dialogInterface, i, z);
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
