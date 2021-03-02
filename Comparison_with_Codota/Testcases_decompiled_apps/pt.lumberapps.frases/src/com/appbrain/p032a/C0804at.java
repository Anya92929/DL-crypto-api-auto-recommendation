package com.appbrain.p032a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cmn.C0705a;
import cmn.C0709ad;
import cmn.C0720ao;
import com.appbrain.C1023c;

/* renamed from: com.appbrain.a.at */
public final class C0804at {

    /* renamed from: a */
    private C1023c f2113a;

    /* renamed from: b */
    private int f2114b;

    /* renamed from: c */
    private int f2115c;

    /* renamed from: d */
    private int f2116d;

    /* renamed from: e */
    private Runnable f2117e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Runnable f2118f;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m3617a(Context context, C0962i iVar, View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            onClickListener = iVar.f2552d;
        }
        if (this.f2113a == null) {
            String str = iVar.f2549a;
            String str2 = iVar.f2550b;
            String str3 = iVar.f2551c;
            int b = C0709ad.m3188b(8.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(C0709ad.m3188b(40.0f), C0709ad.m3188b(40.0f));
            layoutParams.rightMargin = b;
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(layoutParams);
            C0720ao.m3213a().mo3405a(imageView, str3);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTypeface(textView.getTypeface(), 1);
            textView.setTextSize(14.0f);
            TextView textView2 = new TextView(context);
            textView2.setText(str2);
            textView2.setTextSize(12.0f);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.addView(textView);
            linearLayout.addView(textView2);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(textView.getTextColors().withAlpha(64).getDefaultColor()));
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout2.setPadding(b, b, b, b);
            linearLayout2.addView(imageView);
            linearLayout2.addView(linearLayout);
            linearLayout2.setOnClickListener(onClickListener);
            C0705a.m3174a().mo3378a(linearLayout2, stateListDrawable);
            return linearLayout2;
        }
        String str4 = iVar.f2549a;
        String str5 = iVar.f2550b;
        String str6 = iVar.f2551c;
        View a = this.f2113a.mo4030a();
        a.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) a.findViewById(this.f2114b);
        if (imageView2 == null) {
            throw new IllegalStateException("The icon view (ID: " + this.f2114b + ") is not present in the view.");
        }
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        if (layoutParams2.width == -2) {
            layoutParams2.width = C0709ad.m3188b(40.0f);
        }
        if (layoutParams2.height == -2) {
            layoutParams2.height = C0709ad.m3188b(40.0f);
        }
        if (!TextUtils.isEmpty(str6)) {
            imageView2.setVisibility(0);
            C0720ao.m3213a().mo3405a(imageView2, str6);
        } else {
            imageView2.setVisibility(4);
        }
        TextView textView3 = (TextView) a.findViewById(this.f2115c);
        if (textView3 == null) {
            throw new IllegalStateException("The title view (ID: " + this.f2115c + ") is not present in the view.");
        }
        textView3.setVisibility(0);
        if (this.f2115c == this.f2116d) {
            textView3.setText(str4 + "\n\n" + str5);
        } else {
            textView3.setText(str4);
            if (this.f2116d != 0) {
                TextView textView4 = (TextView) a.findViewById(this.f2116d);
                if (textView4 == null) {
                    throw new IllegalStateException("The promo text view (ID: " + this.f2116d + ") is not present in the view.");
                }
                textView4.setVisibility(0);
                textView4.setText(str5);
            }
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final View mo3652a(Context context, C0962i iVar) {
        return m3617a(context, iVar, (View.OnClickListener) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3653a() {
        if (this.f2117e != null) {
            this.f2117e.run();
        }
    }
}
