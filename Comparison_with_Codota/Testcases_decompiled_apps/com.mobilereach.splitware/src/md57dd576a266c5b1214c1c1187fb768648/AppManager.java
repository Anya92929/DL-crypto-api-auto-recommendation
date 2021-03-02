package md57dd576a266c5b1214c1c1187fb768648;

import android.os.Bundle;
import java.util.ArrayList;
import md529e4c2c8a026201f3a493bfa20264e47.MrtActivity;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AppManager extends MrtActivity implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onBackPressed:()V:GetOnBackPressedHandler\n";
    private ArrayList refList;

    private native void n_onBackPressed();

    private native void n_onCreate(Bundle bundle);

    static {
        Runtime.register("AppManager.AppManager, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", AppManager.class, __md_methods);
    }

    public AppManager() throws Throwable {
        if (getClass() == AppManager.class) {
            TypeManager.Activate("AppManager.AppManager, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
    }

    public void onBackPressed() {
        n_onBackPressed();
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
