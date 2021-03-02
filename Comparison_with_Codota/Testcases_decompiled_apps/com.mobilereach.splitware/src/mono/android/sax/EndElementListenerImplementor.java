package mono.android.sax;

import android.sax.EndElementListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class EndElementListenerImplementor implements IGCUserPeer, EndElementListener {
    public static final String __md_methods = "n_end:()V:GetEndHandler:Android.Sax.IEndElementListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_end();

    static {
        Runtime.register("Android.Sax.IEndElementListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", EndElementListenerImplementor.class, __md_methods);
    }

    public EndElementListenerImplementor() throws Throwable {
        if (getClass() == EndElementListenerImplementor.class) {
            TypeManager.Activate("Android.Sax.IEndElementListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void end() {
        n_end();
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
