package mono.com.symbol.emdk.barcode;

import com.symbol.emdk.barcode.Scanner;
import com.symbol.emdk.barcode.StatusData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Scanner_StatusListenerImplementor implements IGCUserPeer, Scanner.StatusListener {
    public static final String __md_methods = "n_onStatus:(Lcom/symbol/emdk/barcode/StatusData;)V:GetOnStatus_Lcom_symbol_emdk_barcode_StatusData_Handler:Com.Symbol.Emdk.Barcode.Scanner/IStatusListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onStatus(StatusData statusData);

    static {
        Runtime.register("Com.Symbol.Emdk.Barcode.Scanner+IStatusListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", Scanner_StatusListenerImplementor.class, __md_methods);
    }

    public Scanner_StatusListenerImplementor() throws Throwable {
        if (getClass() == Scanner_StatusListenerImplementor.class) {
            TypeManager.Activate("Com.Symbol.Emdk.Barcode.Scanner+IStatusListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
