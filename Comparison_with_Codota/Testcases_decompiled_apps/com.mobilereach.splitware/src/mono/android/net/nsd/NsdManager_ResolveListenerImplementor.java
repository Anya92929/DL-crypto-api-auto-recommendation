package mono.android.net.nsd;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NsdManager_ResolveListenerImplementor implements IGCUserPeer, NsdManager.ResolveListener {
    public static final String __md_methods = "n_onResolveFailed:(Landroid/net/nsd/NsdServiceInfo;I)V:GetOnResolveFailed_Landroid_net_nsd_NsdServiceInfo_IHandler:Android.Net.Nsd.NsdManager/IResolveListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onServiceResolved:(Landroid/net/nsd/NsdServiceInfo;)V:GetOnServiceResolved_Landroid_net_nsd_NsdServiceInfo_Handler:Android.Net.Nsd.NsdManager/IResolveListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onResolveFailed(NsdServiceInfo nsdServiceInfo, int i);

    private native void n_onServiceResolved(NsdServiceInfo nsdServiceInfo);

    static {
        Runtime.register("Android.Net.Nsd.NsdManager+IResolveListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", NsdManager_ResolveListenerImplementor.class, __md_methods);
    }

    public NsdManager_ResolveListenerImplementor() throws Throwable {
        if (getClass() == NsdManager_ResolveListenerImplementor.class) {
            TypeManager.Activate("Android.Net.Nsd.NsdManager+IResolveListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i) {
        n_onResolveFailed(nsdServiceInfo, i);
    }

    public void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
        n_onServiceResolved(nsdServiceInfo);
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
