package mono.android.animation;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;

public class LayoutTransition_TransitionListenerImplementor implements IGCUserPeer, LayoutTransition.TransitionListener {
    public static final String __md_methods = "n_endTransition:(Landroid/animation/LayoutTransition;Landroid/view/ViewGroup;Landroid/view/View;I)V:GetEndTransition_Landroid_animation_LayoutTransition_Landroid_view_ViewGroup_Landroid_view_View_IHandler:Android.Animation.LayoutTransition/ITransitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\nn_startTransition:(Landroid/animation/LayoutTransition;Landroid/view/ViewGroup;Landroid/view/View;I)V:GetStartTransition_Landroid_animation_LayoutTransition_Landroid_view_ViewGroup_Landroid_view_View_IHandler:Android.Animation.LayoutTransition/ITransitionListenerInvoker, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=null\n";
    private ArrayList refList;

    private native void n_endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i);

    private native void n_startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i);

    static {
        Runtime.register("Android.Animation.LayoutTransition+ITransitionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", LayoutTransition_TransitionListenerImplementor.class, __md_methods);
    }

    public LayoutTransition_TransitionListenerImplementor() throws Throwable {
        if (getClass() == LayoutTransition_TransitionListenerImplementor.class) {
            TypeManager.Activate("Android.Animation.LayoutTransition+ITransitionListenerImplementor, Mono.Android, Version=0.0.0.0, Culture=neutral, PublicKeyToken=84e04ff9cfb79065", "", this, new Object[0]);
        }
    }

    public void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
        n_endTransition(layoutTransition, viewGroup, view, i);
    }

    public void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
        n_startTransition(layoutTransition, viewGroup, view, i);
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
