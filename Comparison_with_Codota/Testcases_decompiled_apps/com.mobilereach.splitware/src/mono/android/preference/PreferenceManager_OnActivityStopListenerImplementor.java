package mono.android.preference;

import android.preference.PreferenceManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class PreferenceManager_OnActivityStopListenerImplementor implements IGCUserPeer, PreferenceManager.OnActivityStopListener {
    public static final String __md_methods = "n_onActivityStop:()V:GetOnActivityStopHandler:Android.Preferences.PreferenceManager/IOnActivityStopListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onActivityStop();

    static {
        Runtime.register("Android.Preferences.PreferenceManager+IOnActivityStopListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", PreferenceManager_OnActivityStopListenerImplementor.class, __md_methods);
    }

    public PreferenceManager_OnActivityStopListenerImplementor() throws Throwable {
        if (getClass() == PreferenceManager_OnActivityStopListenerImplementor.class) {
            TypeManager.Activate("Android.Preferences.PreferenceManager+IOnActivityStopListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onActivityStop() {
        n_onActivityStop();
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
