package md5acfaf65b49ee240f42ab4565c0d37cbb;

import android.content.Intent;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;
import mono.android.app.IntentService;

public abstract class PushHandlerServiceBase extends IntentService implements IGCUserPeer {
    public static final String __md_methods = "n_onHandleIntent:(Landroid/content/Intent;)V:GetOnHandleIntent_Landroid_content_Intent_Handler\n";
    private ArrayList refList;

    private native void n_onHandleIntent(Intent intent);

    static {
        Runtime.register("PushSharp.Client.PushHandlerServiceBase, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", PushHandlerServiceBase.class, __md_methods);
    }

    public PushHandlerServiceBase(String str) throws Throwable {
        super(str);
        if (getClass() == PushHandlerServiceBase.class) {
            TypeManager.Activate("PushSharp.Client.PushHandlerServiceBase, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "System.String, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{str});
        }
    }

    public PushHandlerServiceBase() throws Throwable {
        if (getClass() == PushHandlerServiceBase.class) {
            TypeManager.Activate("PushSharp.Client.PushHandlerServiceBase, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public PushHandlerServiceBase(String[] strArr) throws Throwable {
        if (getClass() == PushHandlerServiceBase.class) {
            TypeManager.Activate("PushSharp.Client.PushHandlerServiceBase, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "System.String[], mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{strArr});
        }
    }

    public void onHandleIntent(Intent intent) {
        n_onHandleIntent(intent);
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
