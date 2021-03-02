package mono.android.content;

import android.content.SharedPreferences;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class SharedPreferences_OnSharedPreferenceChangeListenerImplementor implements IGCUserPeer, SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String __md_methods = "n_onSharedPreferenceChanged:(Landroid/content/SharedPreferences;Ljava/lang/String;)V:GetOnSharedPreferenceChanged_Landroid_content_SharedPreferences_Ljava_lang_String_Handler:Android.Content.ISharedPreferencesOnSharedPreferenceChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str);

    static {
        Runtime.register("Android.Content.ISharedPreferencesOnSharedPreferenceChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", SharedPreferences_OnSharedPreferenceChangeListenerImplementor.class, __md_methods);
    }

    public SharedPreferences_OnSharedPreferenceChangeListenerImplementor() throws Throwable {
        if (getClass() == SharedPreferences_OnSharedPreferenceChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Content.ISharedPreferencesOnSharedPreferenceChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        n_onSharedPreferenceChanged(sharedPreferences, str);
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
