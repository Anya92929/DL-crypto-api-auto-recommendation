package mono.android.preference;

import android.preference.PreferenceManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PreferenceManager_OnActivityDestroyListenerImplementor implements IGCUserPeer, PreferenceManager.OnActivityDestroyListener {
    public static final String __md_methods = "n_onActivityDestroy:()V:GetOnActivityDestroyHandler:Android.Preferences.PreferenceManager/IOnActivityDestroyListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onActivityDestroy();

    static {
        Runtime.register("Android.Preferences.PreferenceManager+IOnActivityDestroyListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", PreferenceManager_OnActivityDestroyListenerImplementor.class, __md_methods);
    }

    public PreferenceManager_OnActivityDestroyListenerImplementor() throws Throwable {
        if (getClass() == PreferenceManager_OnActivityDestroyListenerImplementor.class) {
            TypeManager.Activate("Android.Preferences.PreferenceManager+IOnActivityDestroyListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onActivityDestroy() {
        n_onActivityDestroy();
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
