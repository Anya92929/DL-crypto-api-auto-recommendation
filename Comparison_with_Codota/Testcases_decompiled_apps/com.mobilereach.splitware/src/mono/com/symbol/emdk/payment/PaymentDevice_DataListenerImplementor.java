package mono.com.symbol.emdk.payment;

import com.symbol.emdk.payment.PaymentData;
import com.symbol.emdk.payment.PaymentDevice;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PaymentDevice_DataListenerImplementor implements IGCUserPeer, PaymentDevice.DataListener {
    public static final String __md_methods = "n_onData:(Lcom/symbol/emdk/payment/PaymentData;)V:GetOnData_Lcom_symbol_emdk_payment_PaymentData_Handler:Com.Symbol.Emdk.Payment.PaymentDevice/IDataListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onData(PaymentData paymentData);

    static {
        Runtime.register("Com.Symbol.Emdk.Payment.PaymentDevice+IDataListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", PaymentDevice_DataListenerImplementor.class, __md_methods);
    }

    public PaymentDevice_DataListenerImplementor() throws Throwable {
        if (getClass() == PaymentDevice_DataListenerImplementor.class) {
            TypeManager.Activate("Com.Symbol.Emdk.Payment.PaymentDevice+IDataListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onData(PaymentData paymentData) {
        n_onData(paymentData);
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
