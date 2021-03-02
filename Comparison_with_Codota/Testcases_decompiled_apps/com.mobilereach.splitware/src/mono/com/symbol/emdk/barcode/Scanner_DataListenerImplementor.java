package mono.com.symbol.emdk.barcode;

import com.symbol.emdk.barcode.ScanDataCollection;
import com.symbol.emdk.barcode.Scanner;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Scanner_DataListenerImplementor implements IGCUserPeer, Scanner.DataListener {
    public static final String __md_methods = "n_onData:(Lcom/symbol/emdk/barcode/ScanDataCollection;)V:GetOnData_Lcom_symbol_emdk_barcode_ScanDataCollection_Handler:Com.Symbol.Emdk.Barcode.Scanner/IDataListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onData(ScanDataCollection scanDataCollection);

    static {
        Runtime.register("Com.Symbol.Emdk.Barcode.Scanner+IDataListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", Scanner_DataListenerImplementor.class, __md_methods);
    }

    public Scanner_DataListenerImplementor() throws Throwable {
        if (getClass() == Scanner_DataListenerImplementor.class) {
            TypeManager.Activate("Com.Symbol.Emdk.Barcode.Scanner+IDataListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onData(ScanDataCollection scanDataCollection) {
        n_onData(scanDataCollection);
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
