package mono.android.net.wifi.p2p;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class WifiP2pManager_DnsSdServiceResponseListenerImplementor implements IGCUserPeer, WifiP2pManager.DnsSdServiceResponseListener {
    public static final String __md_methods = "n_onDnsSdServiceAvailable:(Ljava/lang/String;Ljava/lang/String;Landroid/net/wifi/p2p/WifiP2pDevice;)V:GetOnDnsSdServiceAvailable_Ljava_lang_String_Ljava_lang_String_Landroid_net_wifi_p2p_WifiP2pDevice_Handler:Android.Net.Wifi.P2p.WifiP2pManager/IDnsSdServiceResponseListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDnsSdServiceAvailable(String str, String str2, WifiP2pDevice wifiP2pDevice);

    static {
        Runtime.register("Android.Net.Wifi.P2p.WifiP2pManager+IDnsSdServiceResponseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", WifiP2pManager_DnsSdServiceResponseListenerImplementor.class, __md_methods);
    }

    public WifiP2pManager_DnsSdServiceResponseListenerImplementor() throws Throwable {
        if (getClass() == WifiP2pManager_DnsSdServiceResponseListenerImplementor.class) {
            TypeManager.Activate("Android.Net.Wifi.P2p.WifiP2pManager+IDnsSdServiceResponseListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onDnsSdServiceAvailable(String str, String str2, WifiP2pDevice wifiP2pDevice) {
        n_onDnsSdServiceAvailable(str, str2, wifiP2pDevice);
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
