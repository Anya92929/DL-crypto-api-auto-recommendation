package mono.android.widget;

import android.widget.RatingBar;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class RatingBar_OnRatingBarChangeListenerImplementor implements IGCUserPeer, RatingBar.OnRatingBarChangeListener {
    public static final String __md_methods = "n_onRatingChanged:(Landroid/widget/RatingBar;FZ)V:GetOnRatingChanged_Landroid_widget_RatingBar_FZHandler:Android.Widget.RatingBar/IOnRatingBarChangeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onRatingChanged(RatingBar ratingBar, float f, boolean z);

    static {
        Runtime.register("Android.Widget.RatingBar+IOnRatingBarChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", RatingBar_OnRatingBarChangeListenerImplementor.class, __md_methods);
    }

    public RatingBar_OnRatingBarChangeListenerImplementor() throws Throwable {
        if (getClass() == RatingBar_OnRatingBarChangeListenerImplementor.class) {
            TypeManager.Activate("Android.Widget.RatingBar+IOnRatingBarChangeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        n_onRatingChanged(ratingBar, f, z);
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
