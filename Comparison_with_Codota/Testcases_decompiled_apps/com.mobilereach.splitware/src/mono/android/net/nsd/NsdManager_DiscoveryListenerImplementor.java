package mono.android.net.nsd;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NsdManager_DiscoveryListenerImplementor implements IGCUserPeer, NsdManager.DiscoveryListener {
    public static final String __md_methods = "n_onDiscoveryStarted:(Ljava/lang/String;)V:GetOnDiscoveryStarted_Ljava_lang_String_Handler:Android.Net.Nsd.NsdManager/IDiscoveryListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onDiscoveryStopped:(Ljava/lang/String;)V:GetOnDiscoveryStopped_Ljava_lang_String_Handler:Android.Net.Nsd.NsdManager/IDiscoveryListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onServiceFound:(Landroid/net/nsd/NsdServiceInfo;)V:GetOnServiceFound_Landroid_net_nsd_NsdServiceInfo_Handler:Android.Net.Nsd.NsdManager/IDiscoveryListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onServiceLost:(Landroid/net/nsd/NsdServiceInfo;)V:GetOnServiceLost_Landroid_net_nsd_NsdServiceInfo_Handler:Android.Net.Nsd.NsdManager/IDiscoveryListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onStartDiscoveryFailed:(Ljava/lang/String;I)V:GetOnStartDiscoveryFailed_Ljava_lang_String_IHandler:Android.Net.Nsd.NsdManager/IDiscoveryListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onStopDiscoveryFailed:(Ljava/lang/String;I)V:GetOnStopDiscoveryFailed_Ljava_lang_String_IHandler:Android.Net.Nsd.NsdManager/IDiscoveryListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDiscoveryStarted(String str);

    private native void n_onDiscoveryStopped(String str);

    private native void n_onServiceFound(NsdServiceInfo nsdServiceInfo);

    private native void n_onServiceLost(NsdServiceInfo nsdServiceInfo);

    private native void n_onStartDiscoveryFailed(String str, int i);

    private native void n_onStopDiscoveryFailed(String str, int i);

    static {
        Runtime.register("Android.Net.Nsd.NsdManager+IDiscoveryListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", NsdManager_DiscoveryListenerImplementor.class, __md_methods);
    }

    public NsdManager_DiscoveryListenerImplementor() throws Throwable {
        if (getClass() == NsdManager_DiscoveryListenerImplementor.class) {
            TypeManager.Activate("Android.Net.Nsd.NsdManager+IDiscoveryListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDiscoveryStarted(String str) {
        n_onDiscoveryStarted(str);
    }

    public void onDiscoveryStopped(String str) {
        n_onDiscoveryStopped(str);
    }

    public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
        n_onServiceFound(nsdServiceInfo);
    }

    public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
        n_onServiceLost(nsdServiceInfo);
    }

    public void onStartDiscoveryFailed(String str, int i) {
        n_onStartDiscoveryFailed(str, i);
    }

    public void onStopDiscoveryFailed(String str, int i) {
        n_onStopDiscoveryFailed(str, i);
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
