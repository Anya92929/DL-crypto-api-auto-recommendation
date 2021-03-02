package mono.android.drm;

import android.drm.DrmInfoEvent;
import android.drm.DrmManagerClient;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class DrmManagerClient_OnInfoListenerImplementor implements IGCUserPeer, DrmManagerClient.OnInfoListener {
    public static final String __md_methods = "n_onInfo:(Landroid/drm/DrmManagerClient;Landroid/drm/DrmInfoEvent;)V:GetOnInfo_Landroid_drm_DrmManagerClient_Landroid_drm_DrmInfoEvent_Handler:Android.Drm.DrmManagerClient/IOnInfoListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onInfo(DrmManagerClient drmManagerClient, DrmInfoEvent drmInfoEvent);

    static {
        Runtime.register("Android.Drm.DrmManagerClient+IOnInfoListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", DrmManagerClient_OnInfoListenerImplementor.class, __md_methods);
    }

    public DrmManagerClient_OnInfoListenerImplementor() throws Throwable {
        if (getClass() == DrmManagerClient_OnInfoListenerImplementor.class) {
            TypeManager.Activate("Android.Drm.DrmManagerClient+IOnInfoListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onInfo(DrmManagerClient drmManagerClient, DrmInfoEvent drmInfoEvent) {
        n_onInfo(drmManagerClient, drmInfoEvent);
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
