package com.appbrain.p032a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appbrain.p040i.C1116a;

/* renamed from: com.appbrain.a.d */
final class C0865d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TextView f2303a;

    /* renamed from: b */
    final /* synthetic */ TextView f2304b;

    /* renamed from: c */
    final /* synthetic */ RelativeLayout f2305c;

    /* renamed from: d */
    final /* synthetic */ C1116a f2306d;

    C0865d(TextView textView, TextView textView2, RelativeLayout relativeLayout, C1116a aVar) {
        this.f2303a = textView;
        this.f2304b = textView2;
        this.f2305c = relativeLayout;
        this.f2306d = aVar;
    }

    public final void onClick(View view) {
        if (this.f2303a.getParent() == null) {
            ViewGroup viewGroup = (ViewGroup) this.f2304b.getParent();
            int left = this.f2304b.getLeft();
            int top = this.f2304b.getTop();
            int width = viewGroup.getWidth() - this.f2304b.getRight();
            int height = viewGroup.getHeight() - this.f2304b.getBottom();
            while (true) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 != this.f2305c) {
                    viewGroup = (ViewGroup) viewGroup2.getParent();
                    left += viewGroup2.getLeft();
                    top += viewGroup2.getTop();
                    width += viewGroup.getWidth() - viewGroup2.getRight();
                    height += viewGroup.getHeight() - viewGroup2.getBottom();
                } else {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.leftMargin = left;
                    layoutParams.topMargin = top;
                    layoutParams.rightMargin = width;
                    layoutParams.bottomMargin = height;
                    this.f2303a.setLayoutParams(layoutParams);
                    this.f2305c.addView(this.f2303a);
                    this.f2303a.requestLayout();
                    String language = this.f2305c.getResources().getConfiguration().locale.getLanguage();
                    String charSequence = this.f2304b.getText().toString();
                    this.f2306d.mo4429a(this.f2303a, new C0892e(this, C0801aq.m3606a(10, language), charSequence));
                    return;
                }
            }
        }
    }
}
