package mono.android.runtime;

import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class JavaObject implements IGCUserPeer {
    public static final String __md_methods = "n_clone:()Ljava/lang/Object;:GetCloneHandler\nn_equals:(Ljava/lang/Object;)Z:GetEquals_Ljava_lang_Object_Handler\nn_hashCode:()I:GetGetHashCodeHandler\nn_toString:()Ljava/lang/String;:GetToStringHandler\n";
    private ArrayList refList;

    private native Object n_clone();

    private native boolean n_equals(Object obj);

    private native int n_hashCode();

    private native String n_toString();

    static {
        Runtime.register("Android.Runtime.JavaObject, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", JavaObject.class, __md_methods);
    }

    public JavaObject() throws Throwable {
        if (getClass() == JavaObject.class) {
            TypeManager.Activate("Android.Runtime.JavaObject, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public Object clone() {
        return n_clone();
    }

    public boolean equals(Object obj) {
        return n_equals(obj);
    }

    public int hashCode() {
        return n_hashCode();
    }

    public String toString() {
        return n_toString();
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
