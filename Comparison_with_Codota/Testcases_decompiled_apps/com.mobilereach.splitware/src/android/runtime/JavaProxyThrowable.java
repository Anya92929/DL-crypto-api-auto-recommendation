package android.runtime;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class JavaProxyThrowable extends Throwable implements IGCUserPeer {
    public static final String __md_methods = "";
    private ArrayList refList;

    static {
        Runtime.register("Android.Runtime.JavaProxyThrowable, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", JavaProxyThrowable.class, __md_methods);
    }

    public JavaProxyThrowable() throws Throwable {
        if (getClass() == JavaProxyThrowable.class) {
            TypeManager.Activate("Android.Runtime.JavaProxyThrowable, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public JavaProxyThrowable(String str) throws Throwable {
        super(str);
        if (getClass() == JavaProxyThrowable.class) {
            TypeManager.Activate("Android.Runtime.JavaProxyThrowable, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "System.String, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{str});
        }
    }

    public JavaProxyThrowable(String str, Throwable th) throws Throwable {
        super(str, th);
        if (getClass() == JavaProxyThrowable.class) {
            TypeManager.Activate("Android.Runtime.JavaProxyThrowable, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "System.String, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e:Java.Lang.Throwable, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{str, th});
        }
    }

    public JavaProxyThrowable(Throwable th) throws Throwable {
        super(th);
        if (getClass() == JavaProxyThrowable.class) {
            TypeManager.Activate("Android.Runtime.JavaProxyThrowable, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "Java.Lang.Throwable, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{th});
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
