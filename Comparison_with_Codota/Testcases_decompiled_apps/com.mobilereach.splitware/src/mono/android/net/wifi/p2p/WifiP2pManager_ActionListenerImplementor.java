package mono.android.net.wifi.p2p;

import android.net.wifi.p2p.WifiP2pManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class WifiP2pManager_ActionListenerImplementor implements IGCUserPeer, WifiP2pManager.ActionListener {
    public static final String __md_methods = "n_onFailure:(I)V:GetOnFailure_IHandler:Android.Net.Wifi.P2p.WifiP2pManager/IActionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onSuccess:()V:GetOnSuccessHandler:Android.Net.Wifi.P2p.WifiP2pManager/IActionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onFailure(int i);

    private native void n_onSuccess();

    static {
        Runtime.register("Android.Net.Wifi.P2p.WifiP2pManager+IActionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", WifiP2pManager_ActionListenerImplementor.class, __md_methods);
    }

    public WifiP2pManager_ActionListenerImplementor() throws Throwable {
        if (getClass() == WifiP2pManager_ActionListenerImplementor.class) {
            TypeManager.Activate("Android.Net.Wifi.P2p.WifiP2pManager+IActionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onFailure(int i) {
        n_onFailure(i);
    }

    public void onSuccess() {
        n_onSuccess();
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
