package mono.android.widget;

import android.widget.CalendarView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class CalendarView_OnDateChangeListenerImplementor implements IGCUserPeer, CalendarView.OnDateChangeListener {
    public static final String __md_methods = "n_onSelectedDayChange:(Landroid/widget/CalendarView;III)V:GetOnSelectedDayChange_Landroid_widget_CalendarView_IIIHandler:Android.Widget.CalendarView/IOnDateChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3);

    static {
        Runtime.register("Android.Widget.CalendarView+IOnDateChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", CalendarView_OnDateChangeListenerImplementor.class, __md_methods);
    }

    public CalendarView_OnDateChangeListenerImplementor() throws Throwable {
        if (getClass() == CalendarView_OnDateChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.CalendarView+IOnDateChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
        n_onSelectedDayChange(calendarView, i, i2, i3);
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
