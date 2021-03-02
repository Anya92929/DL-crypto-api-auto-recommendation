package mono.android.preference;

import android.preference.Preference;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Preference_OnPreferenceChangeListenerImplementor implements IGCUserPeer, Preference.OnPreferenceChangeListener {
    public static final String __md_methods = "n_onPreferenceChange:(Landroid/preference/Preference;Ljava/lang/Object;)Z:GetOnPreferenceChange_Landroid_preference_Preference_Ljava_lang_Object_Handler:Android.Preferences.Preference/IOnPreferenceChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onPreferenceChange(Preference preference, Object obj);

    static {
        Runtime.register("Android.Preferences.Preference+IOnPreferenceChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Preference_OnPreferenceChangeListenerImplementor.class, __md_methods);
    }

    public Preference_OnPreferenceChangeListenerImplementor() throws Throwable {
        if (getClass() == Preference_OnPreferenceChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Preferences.Preference+IOnPreferenceChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        return n_onPreferenceChange(preference, obj);
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
