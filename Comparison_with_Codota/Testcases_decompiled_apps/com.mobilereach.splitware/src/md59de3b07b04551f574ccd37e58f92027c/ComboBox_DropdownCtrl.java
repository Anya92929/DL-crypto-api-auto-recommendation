package md59de3b07b04551f574ccd37e58f92027c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AutoCompleteTextView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class ComboBox_DropdownCtrl extends AutoCompleteTextView implements IGCUserPeer {
    public static final String __md_methods = "n_enoughToFilter:()Z:GetEnoughToFilterHandler\nn_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\nn_performFiltering:(Ljava/lang/CharSequence;I)V:GetPerformFiltering_Ljava_lang_CharSequence_IHandler\n";
    private ArrayList refList;

    private native boolean n_enoughToFilter();

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    private native void n_performFiltering(CharSequence charSequence, int i);

    static {
        Runtime.register("Controls.ComboBox+DropdownCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", ComboBox_DropdownCtrl.class, __md_methods);
    }

    public ComboBox_DropdownCtrl(Context context) throws Throwable {
        super(context);
        if (getClass() == ComboBox_DropdownCtrl.class) {
            TypeManager.Activate("Controls.ComboBox+DropdownCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context});
        }
    }

    public ComboBox_DropdownCtrl(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        if (getClass() == ComboBox_DropdownCtrl.class) {
            TypeManager.Activate("Controls.ComboBox+DropdownCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", this, new Object[]{context, attributeSet});
        }
    }

    public ComboBox_DropdownCtrl(Context context, AttributeSet attributeSet, int i) throws Throwable {
        super(context, attributeSet, i);
        if (getClass() == ComboBox_DropdownCtrl.class) {
            TypeManager.Activate("Controls.ComboBox+DropdownCtrl, Splitware, Version=1.0.6080.25359, Culture=neutral, PublicKeyToken=null", "Android.Content.Context, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:Android.Util.IAttributeSet, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065:System.Int32, mscorlib, Version=2.0.5.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    public boolean enoughToFilter() {
        return n_enoughToFilter();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
    }

    public void performFiltering(CharSequence charSequence, int i) {
        n_performFiltering(charSequence, i);
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
