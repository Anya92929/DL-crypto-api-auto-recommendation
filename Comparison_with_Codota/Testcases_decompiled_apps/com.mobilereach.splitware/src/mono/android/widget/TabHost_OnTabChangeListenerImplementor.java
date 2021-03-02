package mono.android.widget;

import android.widget.TabHost;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TabHost_OnTabChangeListenerImplementor implements IGCUserPeer, TabHost.OnTabChangeListener {
    public static final String __md_methods = "n_onTabChanged:(Ljava/lang/String;)V:GetOnTabChanged_Ljava_lang_String_Handler:Android.Widget.TabHost/IOnTabChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTabChanged(String str);

    static {
        Runtime.register("Android.Widget.TabHost+IOnTabChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", TabHost_OnTabChangeListenerImplementor.class, __md_methods);
    }

    public TabHost_OnTabChangeListenerImplementor() throws Throwable {
        if (getClass() == TabHost_OnTabChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.TabHost+IOnTabChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTabChanged(String str) {
        n_onTabChanged(str);
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
