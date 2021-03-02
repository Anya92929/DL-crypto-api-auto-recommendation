package mono.android.net.wifi.p2p;

import android.net.wifi.p2p.WifiP2pManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class WifiP2pManager_ChannelListenerImplementor implements IGCUserPeer, WifiP2pManager.ChannelListener {
    public static final String __md_methods = "n_onChannelDisconnected:()V:GetOnChannelDisconnectedHandler:Android.Net.Wifi.P2p.WifiP2pManager/IChannelListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onChannelDisconnected();

    static {
        Runtime.register("Android.Net.Wifi.P2p.WifiP2pManager+IChannelListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", WifiP2pManager_ChannelListenerImplementor.class, __md_methods);
    }

    public WifiP2pManager_ChannelListenerImplementor() throws Throwable {
        if (getClass() == WifiP2pManager_ChannelListenerImplementor.class) {
            TypeManager.Activate("Android.Net.Wifi.P2p.WifiP2pManager+IChannelListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onChannelDisconnected() {
        n_onChannelDisconnected();
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
