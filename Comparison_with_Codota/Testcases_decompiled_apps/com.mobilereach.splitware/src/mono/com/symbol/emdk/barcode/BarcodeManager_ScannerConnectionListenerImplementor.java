package mono.com.symbol.emdk.barcode;

import com.symbol.emdk.barcode.BarcodeManager;
import com.symbol.emdk.barcode.ScannerInfo;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class BarcodeManager_ScannerConnectionListenerImplementor implements IGCUserPeer, BarcodeManager.ScannerConnectionListener {
    public static final String __md_methods = "n_onConnectionChange:(Lcom/symbol/emdk/barcode/ScannerInfo;Lcom/symbol/emdk/barcode/BarcodeManager$ConnectionState;)V:GetOnConnectionChange_Lcom_symbol_emdk_barcode_ScannerInfo_Lcom_symbol_emdk_barcode_BarcodeManager_ConnectionState_Handler:Com.Symbol.Emdk.Barcode.BarcodeManager/IScannerConnectionListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onConnectionChange(ScannerInfo scannerInfo, BarcodeManager.ConnectionState connectionState);

    static {
        Runtime.register("Com.Symbol.Emdk.Barcode.BarcodeManager+IScannerConnectionListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", BarcodeManager_ScannerConnectionListenerImplementor.class, __md_methods);
    }

    public BarcodeManager_ScannerConnectionListenerImplementor() throws Throwable {
        if (getClass() == BarcodeManager_ScannerConnectionListenerImplementor.class) {
            TypeManager.Activate("Com.Symbol.Emdk.Barcode.BarcodeManager+IScannerConnectionListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onConnectionChange(ScannerInfo scannerInfo, BarcodeManager.ConnectionState connectionState) {
        n_onConnectionChange(scannerInfo, connectionState);
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
