package md5f41bed51fcdeb5fc08f864fdf7ea78e1;

import android.os.Bundle;
import java.util.ArrayList;
import md529e4c2c8a026201f3a493bfa20264e47.TabView_1;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Window extends TabView_1 implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\nn_onBackPressed:()V:GetOnBackPressedHandler\n";
    private ArrayList refList;

    private native void n_onBackPressed();

    private native void n_onCreate(Bundle bundle);

    static {
        Runtime.register("Preference.Window, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", Window.class, __md_methods);
    }

    public Window() throws Throwable {
        if (getClass() == Window.class) {
            TypeManager.Activate("Preference.Window, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
