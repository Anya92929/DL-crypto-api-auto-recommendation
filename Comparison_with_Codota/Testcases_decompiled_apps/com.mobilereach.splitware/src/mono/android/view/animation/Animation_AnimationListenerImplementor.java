package mono.android.view.animation;

import android.view.animation.Animation;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class Animation_AnimationListenerImplementor implements IGCUserPeer, Animation.AnimationListener {
    public static final String __md_methods = "n_onAnimationEnd:(Landroid/view/animation/Animation;)V:GetOnAnimationEnd_Landroid_view_animation_Animation_Handler:Android.Views.Animations.Animation/IAnimationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onAnimationRepeat:(Landroid/view/animation/Animation;)V:GetOnAnimationRepeat_Landroid_view_animation_Animation_Handler:Android.Views.Animations.Animation/IAnimationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_onAnimationStart:(Landroid/view/animation/Animation;)V:GetOnAnimationStart_Landroid_view_animation_Animation_Handler:Android.Views.Animations.Animation/IAnimationListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_onAnimationEnd(Animation animation);

    private native void n_onAnimationRepeat(Animation animation);

    private native void n_onAnimationStart(Animation animation);

    static {
        Runtime.register("Android.Views.Animations.Animation+IAnimationListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", Animation_AnimationListenerImplementor.class, __md_methods);
    }

    public Animation_AnimationListenerImplementor() throws Throwable {
        if (getClass() == Animation_AnimationListenerImplementor.class) {
            TypeManager.Activate("Android.Views.Animations.Animation+IAnimationListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void onAnimationEnd(Animation animation) {
        n_onAnimationEnd(animation);
    }

    public void onAnimationRepeat(Animation animation) {
        n_onAnimationRepeat(animation);
    }

    public void onAnimationStart(Animation animation) {
        n_onAnimationStart(animation);
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
