package mono.android.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class AccessibilityManager_AccessibilityStateChangeListenerImplementor implements IGCUserPeer, AccessibilityManager.AccessibilityStateChangeListener {
    public static final String __md_methods = "n_onAccessibilityStateChanged:(Z)V:GetOnAccessibilityStateChanged_ZHandler:Android.Views.Accessibility.AccessibilityManager/IAccessibilityStateChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAccessibilityStateChanged(boolean z);

    static {
        Runtime.register("Android.Views.Accessibility.AccessibilityManager+IAccessibilityStateChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", AccessibilityManager_AccessibilityStateChangeListenerImplementor.class, __md_methods);
    }

    public AccessibilityManager_AccessibilityStateChangeListenerImplementor() throws Throwable {
        if (getClass() == AccessibilityManager_AccessibilityStateChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Views.Accessibility.AccessibilityManager+IAccessibilityStateChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onAccessibilityStateChanged(boolean z) {
        n_onAccessibilityStateChanged(z);
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
