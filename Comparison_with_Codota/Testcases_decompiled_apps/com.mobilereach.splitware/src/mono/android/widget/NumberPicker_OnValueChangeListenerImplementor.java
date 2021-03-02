package mono.android.widget;

import android.widget.NumberPicker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NumberPicker_OnValueChangeListenerImplementor implements IGCUserPeer, NumberPicker.OnValueChangeListener {
    public static final String __md_methods = "n_onValueChange:(Landroid/widget/NumberPicker;II)V:GetOnValueChange_Landroid_widget_NumberPicker_IIHandler:Android.Widget.NumberPicker/IOnValueChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onValueChange(NumberPicker numberPicker, int i, int i2);

    static {
        Runtime.register("Android.Widget.NumberPicker+IOnValueChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", NumberPicker_OnValueChangeListenerImplementor.class, __md_methods);
    }

    public NumberPicker_OnValueChangeListenerImplementor() throws Throwable {
        if (getClass() == NumberPicker_OnValueChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.NumberPicker+IOnValueChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onValueChange(NumberPicker numberPicker, int i, int i2) {
        n_onValueChange(numberPicker, i, i2);
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
