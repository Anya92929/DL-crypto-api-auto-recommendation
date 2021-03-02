package mono.android.widget;

import android.widget.TimePicker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TimePicker_OnTimeChangedListenerImplementor implements IGCUserPeer, TimePicker.OnTimeChangedListener {
    public static final String __md_methods = "n_onTimeChanged:(Landroid/widget/TimePicker;II)V:GetOnTimeChanged_Landroid_widget_TimePicker_IIHandler:Android.Widget.TimePicker/IOnTimeChangedListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTimeChanged(TimePicker timePicker, int i, int i2);

    static {
        Runtime.register("Android.Widget.TimePicker+IOnTimeChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", TimePicker_OnTimeChangedListenerImplementor.class, __md_methods);
    }

    public TimePicker_OnTimeChangedListenerImplementor() throws Throwable {
        if (getClass() == TimePicker_OnTimeChangedListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.TimePicker+IOnTimeChangedListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTimeChanged(TimePicker timePicker, int i, int i2) {
        n_onTimeChanged(timePicker, i, i2);
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
