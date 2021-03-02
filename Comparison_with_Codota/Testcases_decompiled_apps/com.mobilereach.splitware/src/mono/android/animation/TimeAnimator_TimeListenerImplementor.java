package mono.android.animation;

import android.animation.TimeAnimator;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class TimeAnimator_TimeListenerImplementor implements IGCUserPeer, TimeAnimator.TimeListener {
    public static final String __md_methods = "n_onTimeUpdate:(Landroid/animation/TimeAnimator;JJ)V:GetOnTimeUpdate_Landroid_animation_TimeAnimator_JJHandler:Android.Animation.TimeAnimator/ITimeListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onTimeUpdate(TimeAnimator timeAnimator, long j, long j2);

    static {
        Runtime.register("Android.Animation.TimeAnimator+ITimeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", TimeAnimator_TimeListenerImplementor.class, __md_methods);
    }

    public TimeAnimator_TimeListenerImplementor() throws Throwable {
        if (getClass() == TimeAnimator_TimeListenerImplementor.class) {
            TypeManager.Activate("Android.Animation.TimeAnimator+ITimeListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
        n_onTimeUpdate(timeAnimator, j, j2);
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
