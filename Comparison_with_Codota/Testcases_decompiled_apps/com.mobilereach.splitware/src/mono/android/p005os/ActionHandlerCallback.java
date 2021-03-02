package mono.android.p005os;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

/* renamed from: mono.android.os.ActionHandlerCallback */
public class ActionHandlerCallback implements IGCUserPeer, Handler.Callback {
    public static final String __md_methods = "n_handleMessage:(Landroid/os/Message;)Z:GetHandleMessage_Landroid_os_Message_Handler:Android.OS.Handler/ICallbackInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_handleMessage(Message message);

    static {
        Runtime.register("Android.OS.ActionHandlerCallback, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", ActionHandlerCallback.class, __md_methods);
    }

    public ActionHandlerCallback() throws Throwable {
        if (getClass() == ActionHandlerCallback.class) {
            TypeManager.Activate("Android.OS.ActionHandlerCallback, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean handleMessage(Message message) {
        return n_handleMessage(message);
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
