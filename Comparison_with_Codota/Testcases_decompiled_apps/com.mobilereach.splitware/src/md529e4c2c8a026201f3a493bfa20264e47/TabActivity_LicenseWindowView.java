package md529e4c2c8a026201f3a493bfa20264e47;

import android.os.Bundle;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TabActivity_LicenseWindowView extends TabFrag_1 implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n";
    private ArrayList refList;

    private native void n_onCreate(Bundle bundle);

    static {
        Runtime.register("UI.TabActivity+LicenseWindowView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", TabActivity_LicenseWindowView.class, __md_methods);
    }

    public TabActivity_LicenseWindowView() throws Throwable {
        if (getClass() == TabActivity_LicenseWindowView.class) {
            TypeManager.Activate("UI.TabActivity+LicenseWindowView, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
