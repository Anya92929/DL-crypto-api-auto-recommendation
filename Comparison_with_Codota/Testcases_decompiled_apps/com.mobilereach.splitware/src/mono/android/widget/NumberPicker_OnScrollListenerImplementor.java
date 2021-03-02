package mono.android.widget;

import android.widget.NumberPicker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class NumberPicker_OnScrollListenerImplementor implements IGCUserPeer, NumberPicker.OnScrollListener {
    public static final String __md_methods = "n_onScrollStateChange:(Landroid/widget/NumberPicker;I)V:GetOnScrollStateChange_Landroid_widget_NumberPicker_IHandler:Android.Widget.NumberPicker/IOnScrollListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onScrollStateChange(NumberPicker numberPicker, int i);

    static {
        Runtime.register("Android.Widget.NumberPicker+IOnScrollListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", NumberPicker_OnScrollListenerImplementor.class, __md_methods);
    }

    public NumberPicker_OnScrollListenerImplementor() throws Throwable {
        if (getClass() == NumberPicker_OnScrollListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.NumberPicker+IOnScrollListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onScrollStateChange(NumberPicker numberPicker, int i) {
        n_onScrollStateChange(numberPicker, i);
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
