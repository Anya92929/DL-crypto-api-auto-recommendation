package mono.android.net.sip;

import android.net.sip.SipRegistrationListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SipRegistrationListenerImplementor implements IGCUserPeer, SipRegistrationListener {
    public static final String __md_methods = "n_onRegistering:(Ljava/lang/String;)V:GetOnRegistering_Ljava_lang_String_Handler:Android.Net.Sip.ISipRegistrationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onRegistrationDone:(Ljava/lang/String;J)V:GetOnRegistrationDone_Ljava_lang_String_JHandler:Android.Net.Sip.ISipRegistrationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onRegistrationFailed:(Ljava/lang/String;ILjava/lang/String;)V:GetOnRegistrationFailed_Ljava_lang_String_ILjava_lang_String_Handler:Android.Net.Sip.ISipRegistrationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onRegistering(String str);

    private native void n_onRegistrationDone(String str, long j);

    private native void n_onRegistrationFailed(String str, int i, String str2);

    static {
        Runtime.register("Android.Net.Sip.ISipRegistrationListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SipRegistrationListenerImplementor.class, __md_methods);
    }

    public SipRegistrationListenerImplementor() throws Throwable {
        if (getClass() == SipRegistrationListenerImplementor.class) {
            TypeManager.Activate("Android.Net.Sip.ISipRegistrationListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onRegistering(String str) {
        n_onRegistering(str);
    }

    public void onRegistrationDone(String str, long j) {
        n_onRegistrationDone(str, j);
    }

    public void onRegistrationFailed(String str, int i, String str2) {
        n_onRegistrationFailed(str, i, str2);
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
