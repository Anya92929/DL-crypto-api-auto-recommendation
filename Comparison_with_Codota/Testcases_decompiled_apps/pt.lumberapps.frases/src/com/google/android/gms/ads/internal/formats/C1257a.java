package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzin;
import java.util.List;

@zzin
/* renamed from: com.google.android.gms.ads.internal.formats.a */
class C1257a extends RelativeLayout {

    /* renamed from: a */
    private static final float[] f3620a = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};

    /* renamed from: b */
    private final RelativeLayout f3621b;

    /* renamed from: c */
    private AnimationDrawable f3622c;

    public C1257a(Context context, zza zza) {
        super(context);
        zzab.zzy(zza);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (zza.zzkr()) {
            case 0:
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                break;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 3:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            default:
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                break;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f3620a, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(zza.getBackgroundColor());
        this.f3621b = new RelativeLayout(context);
        this.f3621b.setLayoutParams(layoutParams);
        zzu.zzfs().zza((View) this.f3621b, (Drawable) shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zza.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zza.getText());
            textView.setTextColor(zza.getTextColor());
            textView.setTextSize((float) zza.getTextSize());
            textView.setPadding(zzm.zziw().zza(context, 4), 0, zzm.zziw().zza(context, 4), 0);
            this.f3621b.addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<Drawable> zzkp = zza.zzkp();
        if (zzkp.size() > 1) {
            this.f3622c = new AnimationDrawable();
            for (Drawable addFrame : zzkp) {
                this.f3622c.addFrame(addFrame, zza.zzkq());
            }
            zzu.zzfs().zza((View) imageView, (Drawable) this.f3622c);
        } else if (zzkp.size() == 1) {
            imageView.setImageDrawable((Drawable) zzkp.get(0));
        }
        this.f3621b.addView(imageView);
        addView(this.f3621b);
    }

    /* renamed from: a */
    public ViewGroup mo5309a() {
        return this.f3621b;
    }

    public void onAttachedToWindow() {
        if (this.f3622c != null) {
            this.f3622c.start();
        }
        super.onAttachedToWindow();
    }
}
