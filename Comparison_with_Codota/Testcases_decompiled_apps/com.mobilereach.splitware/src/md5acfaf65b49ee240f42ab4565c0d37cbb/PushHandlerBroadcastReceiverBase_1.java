package md5acfaf65b49ee240f42ab4565c0d37cbb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PushHandlerBroadcastReceiverBase_1 extends BroadcastReceiver implements IGCUserPeer {
    public static final String __md_methods = "n_onReceive:(Landroid/content/Context;Landroid/content/Intent;)V:GetOnReceive_Landroid_content_Context_Landroid_content_Intent_Handler\n";
    private ArrayList refList;

    private native void n_onReceive(Context context, Intent intent);

    static {
        Runtime.register("PushSharp.Client.PushHandlerBroadcastReceiverBase`1, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", PushHandlerBroadcastReceiverBase_1.class, __md_methods);
    }

    public PushHandlerBroadcastReceiverBase_1() throws Throwable {
        if (getClass() == PushHandlerBroadcastReceiverBase_1.class) {
            TypeManager.Activate("PushSharp.Client.PushHandlerBroadcastReceiverBase`1, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onReceive(Context context, Intent intent) {
        n_onReceive(context, intent);
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
