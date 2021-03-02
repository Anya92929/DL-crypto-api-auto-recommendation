package md595f4b8ab717b9da13f11267a86077f20;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AwaitableOkHttp_OkTaskCallback implements IGCUserPeer, Callback {
    public static final String __md_methods = "n_onFailure:(Lcom/squareup/okhttp/Request;Ljava/io/IOException;)V:GetOnFailure_Lcom_squareup_okhttp_Request_Ljava_io_IOException_Handler:OkHttp.ICallbackInvoker, OkHttp\nn_onResponse:(Lcom/squareup/okhttp/Response;)V:GetOnResponse_Lcom_squareup_okhttp_Response_Handler:OkHttp.ICallbackInvoker, OkHttp\n";
    private ArrayList refList;

    private native void n_onFailure(Request request, IOException iOException);

    private native void n_onResponse(Response response);

    static {
        Runtime.register("ModernHttpClient.AwaitableOkHttp+OkTaskCallback, ModernHttpClient, Version=2.4.2.0, Culture=neutral, PublicKeyToken=null", AwaitableOkHttp_OkTaskCallback.class, __md_methods);
    }

    public AwaitableOkHttp_OkTaskCallback() throws Throwable {
        if (getClass() == AwaitableOkHttp_OkTaskCallback.class) {
            TypeManager.Activate("ModernHttpClient.AwaitableOkHttp+OkTaskCallback, ModernHttpClient, Version=2.4.2.0, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public void onFailure(Request request, IOException iOException) {
        n_onFailure(request, iOException);
    }

    public void onResponse(Response response) {
        n_onResponse(response);
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
