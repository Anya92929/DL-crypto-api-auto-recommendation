package md5b3f04f2570191257e1093b7fd37a0d05;

import android.os.Bundle;
import java.util.ArrayList;
import md529e4c2c8a026201f3a493bfa20264e47.MrtActivity;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Launcher extends MrtActivity implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onStart:()V:GetOnStartHandler\nn_onDestroy:()V:GetOnDestroyHandler\n";
    private ArrayList refList;

    private native void n_onCreate(Bundle bundle);

    private native void n_onDestroy();

    private native void n_onStart();

    static {
        Runtime.register("Launcher.Launcher, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", Launcher.class, __md_methods);
    }

    public Launcher() throws Throwable {
        if (getClass() == Launcher.class) {
            TypeManager.Activate("Launcher.Launcher, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        n_onCreate(bundle);
    }

    public void onStart() {
        n_onStart();
    }

    public void onDestroy() {
        n_onDestroy();
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
