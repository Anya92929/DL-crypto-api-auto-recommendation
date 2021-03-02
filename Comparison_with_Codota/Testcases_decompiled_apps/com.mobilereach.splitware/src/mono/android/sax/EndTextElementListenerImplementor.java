package mono.android.sax;

import android.sax.EndTextElementListener;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class EndTextElementListenerImplementor implements IGCUserPeer, EndTextElementListener {
    public static final String __md_methods = "n_end:(Ljava/lang/String;)V:GetEnd_Ljava_lang_String_Handler:Android.Sax.IEndTextElementListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_end(String str);

    static {
        Runtime.register("Android.Sax.IEndTextElementListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", EndTextElementListenerImplementor.class, __md_methods);
    }

    public EndTextElementListenerImplementor() throws Throwable {
        if (getClass() == EndTextElementListenerImplementor.class) {
            TypeManager.Activate("Android.Sax.IEndTextElementListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void end(String str) {
        n_end(str);
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
