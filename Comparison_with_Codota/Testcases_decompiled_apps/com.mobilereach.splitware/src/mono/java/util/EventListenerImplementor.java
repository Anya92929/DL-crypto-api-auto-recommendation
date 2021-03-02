package mono.java.util;

import java.util.ArrayList;
import java.util.EventListener;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class EventListenerImplementor implements IGCUserPeer, EventListener {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Java.Util.IEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", EventListenerImplementor.class, __md_methods);
    }

    public EventListenerImplementor() throws Throwable {
        if (getClass() == EventListenerImplementor.class) {
            TypeManager.Activate("Java.Util.IEventListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
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
