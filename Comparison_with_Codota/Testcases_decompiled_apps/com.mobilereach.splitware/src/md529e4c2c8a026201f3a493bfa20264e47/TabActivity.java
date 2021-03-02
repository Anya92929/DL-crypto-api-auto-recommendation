package md529e4c2c8a026201f3a493bfa20264e47;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TabActivity extends MrtActivity implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("UI.TabActivity, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", TabActivity.class, __md_methods);
    }

    public TabActivity() throws Throwable {
        if (getClass() == TabActivity.class) {
            TypeManager.Activate("UI.TabActivity, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
