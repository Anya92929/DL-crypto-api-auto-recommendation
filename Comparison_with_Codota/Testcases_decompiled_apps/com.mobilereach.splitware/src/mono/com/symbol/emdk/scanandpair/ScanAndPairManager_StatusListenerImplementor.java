package mono.com.symbol.emdk.scanandpair;

import com.symbol.emdk.scanandpair.ScanAndPairManager;
import com.symbol.emdk.scanandpair.StatusData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ScanAndPairManager_StatusListenerImplementor implements IGCUserPeer, ScanAndPairManager.StatusListener {
    public static final String __md_methods = "n_onStatus:(Lcom/symbol/emdk/scanandpair/StatusData;)V:GetOnStatus_Lcom_symbol_emdk_scanandpair_StatusData_Handler:Com.Symbol.Emdk.Scanandpair.ScanAndPairManager/IStatusListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onStatus(StatusData statusData);

    static {
        Runtime.register("Com.Symbol.Emdk.Scanandpair.ScanAndPairManager+IStatusListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ScanAndPairManager_StatusListenerImplementor.class, __md_methods);
    }

    public ScanAndPairManager_StatusListenerImplementor() throws Throwable {
        if (getClass() == ScanAndPairManager_StatusListenerImplementor.class) {
            TypeManager.Activate("Com.Symbol.Emdk.Scanandpair.ScanAndPairManager+IStatusListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onStatus(StatusData statusData) {
        n_onStatus(statusData);
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
