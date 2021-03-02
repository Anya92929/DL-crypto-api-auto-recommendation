package mono.com.symbol.emdk;

import com.symbol.emdk.EMDKManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class EMDKManager_EMDKListenerImplementor implements IGCUserPeer, EMDKManager.EMDKListener {
    public static final String __md_methods = "n_onClosed:()V:GetOnClosedHandler:Com.Symbol.Emdk.EMDKManager/IEMDKListenerInvoker, EMDK\nn_onOpened:(Lcom/symbol/emdk/EMDKManager;)V:GetOnOpened_Lcom_symbol_emdk_EMDKManager_Handler:Com.Symbol.Emdk.EMDKManager/IEMDKListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onClosed();

    private native void n_onOpened(EMDKManager eMDKManager);

    static {
        Runtime.register("Com.Symbol.Emdk.EMDKManager+IEMDKListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", EMDKManager_EMDKListenerImplementor.class, __md_methods);
    }

    public EMDKManager_EMDKListenerImplementor() throws Throwable {
        if (getClass() == EMDKManager_EMDKListenerImplementor.class) {
            TypeManager.Activate("Com.Symbol.Emdk.EMDKManager+IEMDKListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onClosed() {
        n_onClosed();
    }

    public void onOpened(EMDKManager eMDKManager) {
        n_onOpened(eMDKManager);
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
