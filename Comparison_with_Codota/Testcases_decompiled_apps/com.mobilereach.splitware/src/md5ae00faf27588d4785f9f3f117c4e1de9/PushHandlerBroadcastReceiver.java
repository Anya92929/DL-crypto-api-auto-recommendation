package md5ae00faf27588d4785f9f3f117c4e1de9;

import java.util.ArrayList;
import md5acfaf65b49ee240f42ab4565c0d37cbb.PushHandlerBroadcastReceiverBase_1;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PushHandlerBroadcastReceiver extends PushHandlerBroadcastReceiverBase_1 implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("UI.PushSharp.Client.PushHandlerBroadcastReceiver, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", PushHandlerBroadcastReceiver.class, __md_methods);
    }

    public PushHandlerBroadcastReceiver() throws Throwable {
        if (getClass() == PushHandlerBroadcastReceiver.class) {
            TypeManager.Activate("UI.PushSharp.Client.PushHandlerBroadcastReceiver, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
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
