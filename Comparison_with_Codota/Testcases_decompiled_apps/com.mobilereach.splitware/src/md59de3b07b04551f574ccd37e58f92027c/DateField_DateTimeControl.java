package md59de3b07b04551f574ccd37e58f92027c;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class DateField_DateTimeControl extends TextView implements IGCUserPeer, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    public static final String __md_methods = "n_onDateSet:(Landroid/widget/DatePicker;III)V:GetOnDateSet_Landroid_widget_DatePicker_IIIHandler:Android.App.DatePickerDialog/IOnDateSetListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onTimeSet:(Landroid/widget/TimePicker;II)V:GetOnTimeSet_Landroid_widget_TimePicker_IIHandler:Android.App.TimePickerDialog/IOnTimeSetListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onDateSet(DatePicker datePicker, int i, int i2, int i3);

    private native void n_onTimeSet(TimePicker timePicker, int i, int i2);

    static {
        Runtime.register("Controls.DateField+DateTimeControl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", DateField_DateTimeControl.class, __md_methods);
    }

    public DateField_DateTimeControl(Context context) throws Throwable {
        super(context);
        if (getClass() == DateField_DateTimeControl.class) {
            TypeManager.Activate("Controls.DateField+DateTimeControl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public DateField_DateTimeControl(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == DateField_DateTimeControl.class) {
            TypeManager.Activate("Controls.DateField+DateTimeControl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public DateField_DateTimeControl(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == DateField_DateTimeControl.class) {
            TypeManager.Activate("Controls.DateField+DateTimeControl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        n_onDateSet(datePicker, i, i2, i3);
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
