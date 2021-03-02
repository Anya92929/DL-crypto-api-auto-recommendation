package md529e4c2c8a026201f3a493bfa20264e47;

import android.app.Application;
import java.util.ArrayList;
import mono.MonoPackageManager;
import mono.android.IGCUserPeer;

public class MrtApplication extends Application implements IGCUserPeer {
    public static final String __md_methods = "n_onCreate:()V:GetOnCreateHandler\n";
    private ArrayList refList;

    private native void n_onCreate();

    public MrtApplication() {
        MonoPackageManager.setContext(this);
    }

    public void onCreate() {
        n_onCreate();
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
