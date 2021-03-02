package md5ae00faf27588d4785f9f3f117c4e1de9;

import java.util.ArrayList;
import md5acfaf65b49ee240f42ab4565c0d37cbb.PushHandlerServiceBase;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PushHandlerService extends PushHandlerServiceBase implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("UI.PushSharp.Client.PushHandlerService, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", PushHandlerService.class, __md_methods);
    }

    public PushHandlerService(String str) throws Throwable {
        super(str);
        if (getClass() == PushHandlerService.class) {
            TypeManager.Activate("UI.PushSharp.Client.PushHandlerService, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "System.String, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{str});
        }
    }

    public PushHandlerService() throws Throwable {
        if (getClass() == PushHandlerService.class) {
            TypeManager.Activate("UI.PushSharp.Client.PushHandlerService, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
        }
    }

    public PushHandlerService(String[] strArr) throws Throwable {
        if (getClass() == PushHandlerService.class) {
            TypeManager.Activate("UI.PushSharp.Client.PushHandlerService, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "System.String[], mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{strArr});
        }
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
