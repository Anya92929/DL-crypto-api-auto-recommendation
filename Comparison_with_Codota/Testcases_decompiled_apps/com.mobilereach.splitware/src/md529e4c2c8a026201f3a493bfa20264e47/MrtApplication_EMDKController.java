package md529e4c2c8a026201f3a493bfa20264e47;

import com.symbol.emdk.EMDKManager;
import com.symbol.emdk.barcode.ScanDataCollection;
import com.symbol.emdk.barcode.Scanner;
import com.symbol.emdk.barcode.StatusData;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class MrtApplication_EMDKController implements IGCUserPeer, EMDKManager.EMDKListener, Scanner.DataListener, Scanner.StatusListener {
    public static final String __md_methods = "n_onClosed:()V:GetOnClosedHandler:Com.Symbol.Emdk.EMDKManager/IEMDKListenerInvoker, EMDK\nn_onOpened:(Lcom/symbol/emdk/EMDKManager;)V:GetOnOpened_Lcom_symbol_emdk_EMDKManager_Handler:Com.Symbol.Emdk.EMDKManager/IEMDKListenerInvoker, EMDK\nn_onData:(Lcom/symbol/emdk/barcode/ScanDataCollection;)V:GetOnData_Lcom_symbol_emdk_barcode_ScanDataCollection_Handler:Com.Symbol.Emdk.Barcode.Scanner/IDataListenerInvoker, EMDK\nn_onStatus:(Lcom/symbol/emdk/barcode/StatusData;)V:GetOnStatus_Lcom_symbol_emdk_barcode_StatusData_Handler:Com.Symbol.Emdk.Barcode.Scanner/IStatusListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onClosed();

    private native void n_onData(ScanDataCollection scanDataCollection);

    private native void n_onOpened(EMDKManager eMDKManager);

    private native void n_onStatus(StatusData statusData);

    static {
        Runtime.register("UI.MrtApplication+EMDKController, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", MrtApplication_EMDKController.class, __md_methods);
    }

    public MrtApplication_EMDKController() throws Throwable {
        if (getClass() == MrtApplication_EMDKController.class) {
            TypeManager.Activate("UI.MrtApplication+EMDKController, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public MrtApplication_EMDKController(MrtApplication mrtApplication) throws Throwable {
        if (getClass() == MrtApplication_EMDKController.class) {
            TypeManager.Activate("UI.MrtApplication+EMDKController, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "UI.MrtApplication, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", this, new Object[]{mrtApplication});
        }
    }

    public void onClosed() {
        n_onClosed();
    }

    public void onOpened(EMDKManager eMDKManager) {
        n_onOpened(eMDKManager);
    }

    public void onData(ScanDataCollection scanDataCollection) {
        n_onData(scanDataCollection);
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
