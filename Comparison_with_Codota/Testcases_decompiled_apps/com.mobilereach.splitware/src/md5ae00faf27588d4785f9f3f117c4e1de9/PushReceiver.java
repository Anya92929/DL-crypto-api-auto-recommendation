package md5ae00faf27588d4785f9f3f117c4e1de9;

import android.os.Bundle;
import java.util.ArrayList;
import md529e4c2c8a026201f3a493bfa20264e47.MrtActivity;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PushReceiver extends MrtActivity implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n";
    private ArrayList refList;

    private native void n_onCreate(Bundle bundle);

    static {
        Runtime.register("UI.PushSharp.Client.PushReceiver, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", PushReceiver.class, __md_methods);
    }

    public PushReceiver() throws Throwable {
        if (getClass() == PushReceiver.class) {
            TypeManager.Activate("UI.PushSharp.Client.PushReceiver, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
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
