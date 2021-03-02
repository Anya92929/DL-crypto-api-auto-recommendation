package mono.android.drm;

import android.drm.DrmErrorEvent;
import android.drm.DrmManagerClient;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class DrmManagerClient_OnErrorListenerImplementor implements IGCUserPeer, DrmManagerClient.OnErrorListener {
    public static final String __md_methods = "n_onError:(Landroid/drm/DrmManagerClient;Landroid/drm/DrmErrorEvent;)V:GetOnError_Landroid_drm_DrmManagerClient_Landroid_drm_DrmErrorEvent_Handler:Android.Drm.DrmManagerClient/IOnErrorListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onError(DrmManagerClient drmManagerClient, DrmErrorEvent drmErrorEvent);

    static {
        Runtime.register("Android.Drm.DrmManagerClient+IOnErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", DrmManagerClient_OnErrorListenerImplementor.class, __md_methods);
    }

    public DrmManagerClient_OnErrorListenerImplementor() throws Throwable {
        if (getClass() == DrmManagerClient_OnErrorListenerImplementor.class) {
            TypeManager.Activate("Android.Drm.DrmManagerClient+IOnErrorListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onError(DrmManagerClient drmManagerClient, DrmErrorEvent drmErrorEvent) {
        n_onError(drmManagerClient, drmErrorEvent);
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
