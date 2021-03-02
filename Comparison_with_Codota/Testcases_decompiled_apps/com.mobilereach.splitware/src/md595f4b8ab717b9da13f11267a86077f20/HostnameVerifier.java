package md595f4b8ab717b9da13f11267a86077f20;

import java.util.ArrayList;
import javax.net.ssl.SSLSession;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class HostnameVerifier implements IGCUserPeer, javax.net.ssl.HostnameVerifier {
    public static final String __md_methods = "n_verify:(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z:GetVerify_Ljava_lang_String_Ljavax_net_ssl_SSLSession_Handler:Javax.Net.Ssl.IHostnameVerifierInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_verify(String str, SSLSession sSLSession);

    static {
        Runtime.register("ModernHttpClient.HostnameVerifier, ModernHttpClient, Version=2.4.2.0, Culture=neutral, PublicKeyToken=null", HostnameVerifier.class, __md_methods);
    }

    public HostnameVerifier() throws Throwable {
        if (getClass() == HostnameVerifier.class) {
            TypeManager.Activate("ModernHttpClient.HostnameVerifier, ModernHttpClient, Version=2.4.2.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return n_verify(str, sSLSession);
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
