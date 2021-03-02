package mono.android.app;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TimePickerDialog_OnTimeSetListenerImplementor implements IGCUserPeer, TimePickerDialog.OnTimeSetListener {
    public static final String __md_methods = "n_onTimeSet:(Landroid/widget/TimePicker;II)V:GetOnTimeSet_Landroid_widget_TimePicker_IIHandler:Android.App.TimePickerDialog/IOnTimeSetListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTimeSet(TimePicker timePicker, int i, int i2);

    static {
        Runtime.register("Android.App.TimePickerDialog+IOnTimeSetListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", TimePickerDialog_OnTimeSetListenerImplementor.class, __md_methods);
    }

    public TimePickerDialog_OnTimeSetListenerImplementor() throws Throwable {
        if (getClass() == TimePickerDialog_OnTimeSetListenerImplementor.class) {
            TypeManager.Activate("Android.App.TimePickerDialog+IOnTimeSetListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        n_onTimeSet(timePicker, i, i2);
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
