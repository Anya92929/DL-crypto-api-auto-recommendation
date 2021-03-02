package mono.com.symbol.emdk;

import com.symbol.emdk.ProfileManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ProfileManager_DataListenerImplementor implements IGCUserPeer, ProfileManager.DataListener {
    public static final String __md_methods = "n_onData:(Lcom/symbol/emdk/ProfileManager$ResultData;)V:GetOnData_Lcom_symbol_emdk_ProfileManager_ResultData_Handler:Com.Symbol.Emdk.ProfileManager/IDataListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onData(ProfileManager.ResultData resultData);

    static {
        Runtime.register("Com.Symbol.Emdk.ProfileManager+IDataListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", ProfileManager_DataListenerImplementor.class, __md_methods);
    }

    public ProfileManager_DataListenerImplementor() throws Throwable {
        if (getClass() == ProfileManager_DataListenerImplementor.class) {
            TypeManager.Activate("Com.Symbol.Emdk.ProfileManager+IDataListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onData(ProfileManager.ResultData resultData) {
        n_onData(resultData);
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
