package md5c511f3bb4023a9fba45cd7d7f01251f6;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class CommandContext implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("SocketMobileHelper.CommandContext, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", CommandContext.class, __md_methods);
    }

    public CommandContext() throws Throwable {
        if (getClass() == CommandContext.class) {
            TypeManager.Activate("SocketMobileHelper.CommandContext, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "", this, new Object[0]);
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
