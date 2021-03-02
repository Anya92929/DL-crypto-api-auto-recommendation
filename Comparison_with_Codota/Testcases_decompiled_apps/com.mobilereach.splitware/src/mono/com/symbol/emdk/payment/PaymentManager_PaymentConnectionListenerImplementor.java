package mono.com.symbol.emdk.payment;

import com.symbol.emdk.payment.DeviceInfo;
import com.symbol.emdk.payment.PaymentManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PaymentManager_PaymentConnectionListenerImplementor implements IGCUserPeer, PaymentManager.PaymentConnectionListener {
    public static final String __md_methods = "n_onConnectionChange:(Lcom/symbol/emdk/payment/DeviceInfo;Lcom/symbol/emdk/payment/PaymentManager$ConnectionState;)V:GetOnConnectionChange_Lcom_symbol_emdk_payment_DeviceInfo_Lcom_symbol_emdk_payment_PaymentManager_ConnectionState_Handler:Com.Symbol.Emdk.Payment.PaymentManager/IPaymentConnectionListenerInvoker, EMDK\n";
    private ArrayList refList;

    private native void n_onConnectionChange(DeviceInfo deviceInfo, PaymentManager.ConnectionState connectionState);

    static {
        Runtime.register("Com.Symbol.Emdk.Payment.PaymentManager+IPaymentConnectionListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", PaymentManager_PaymentConnectionListenerImplementor.class, __md_methods);
    }

    public PaymentManager_PaymentConnectionListenerImplementor() throws Throwable {
        if (getClass() == PaymentManager_PaymentConnectionListenerImplementor.class) {
            TypeManager.Activate("Com.Symbol.Emdk.Payment.PaymentManager+IPaymentConnectionListenerImplementor, EMDK, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onConnectionChange(DeviceInfo deviceInfo, PaymentManager.ConnectionState connectionState) {
        n_onConnectionChange(deviceInfo, connectionState);
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
