package mono.android.widget;

import android.widget.RadioGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class RadioGroup_OnCheckedChangeListenerImplementor implements IGCUserPeer, RadioGroup.OnCheckedChangeListener {
    public static final String __md_methods = "n_onCheckedChanged:(Landroid/widget/RadioGroup;I)V:GetOnCheckedChanged_Landroid_widget_RadioGroup_IHandler:Android.Widget.RadioGroup/IOnCheckedChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onCheckedChanged(RadioGroup radioGroup, int i);

    static {
        Runtime.register("Android.Widget.RadioGroup+IOnCheckedChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", RadioGroup_OnCheckedChangeListenerImplementor.class, __md_methods);
    }

    public RadioGroup_OnCheckedChangeListenerImplementor() throws Throwable {
        if (getClass() == RadioGroup_OnCheckedChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.RadioGroup+IOnCheckedChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        n_onCheckedChanged(radioGroup, i);
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
