package mono.android.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TextView_OnEditorActionListenerImplementor implements IGCUserPeer, TextView.OnEditorActionListener {
    public static final String __md_methods = "n_onEditorAction:(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z:GetOnEditorAction_Landroid_widget_TextView_ILandroid_view_KeyEvent_Handler:Android.Widget.TextView/IOnEditorActionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native boolean n_onEditorAction(TextView textView, int i, KeyEvent keyEvent);

    static {
        Runtime.register("Android.Widget.TextView+IOnEditorActionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", TextView_OnEditorActionListenerImplementor.class, __md_methods);
    }

    public TextView_OnEditorActionListenerImplementor() throws Throwable {
        if (getClass() == TextView_OnEditorActionListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.TextView+IOnEditorActionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return n_onEditorAction(textView, i, keyEvent);
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
