package com.appbrain.p040i;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

/* renamed from: com.appbrain.i.a */
public final class C1116a {

    /* renamed from: a */
    private ViewGroup f3138a;

    public C1116a(ViewGroup viewGroup) {
        this.f3138a = viewGroup;
    }

    /* renamed from: a */
    public final void mo4428a(View view) {
        if (view.getAnimation() == null || view.getAnimation().hasEnded()) {
            view.measure(0, 0);
            C1118c cVar = new C1118c(this, view, view.getMeasuredWidth());
            view.setVisibility(0);
            view.getLayoutParams().width = 1;
            view.requestLayout();
            cVar.setDuration(200);
            view.startAnimation(cVar);
        }
    }

    /* renamed from: a */
    public final void mo4429a(View view, Animation.AnimationListener animationListener) {
        if (view.getAnimation() == null || view.getAnimation().hasEnded()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            C1117b bVar = new C1117b(this, view, layoutParams.leftMargin, layoutParams.rightMargin, layoutParams.topMargin, layoutParams.bottomMargin);
            bVar.setDuration(200);
            bVar.setAnimationListener(animationListener);
            view.startAnimation(bVar);
        }
    }

    /* renamed from: b */
    public final void mo4430b(View view) {
        if (view.getAnimation() == null || view.getAnimation().hasEnded()) {
            view.measure(0, 0);
            C1119d dVar = new C1119d(this, view, view.getMeasuredWidth());
            view.setVisibility(0);
            dVar.setDuration(200);
            view.startAnimation(dVar);
        }
    }
}
