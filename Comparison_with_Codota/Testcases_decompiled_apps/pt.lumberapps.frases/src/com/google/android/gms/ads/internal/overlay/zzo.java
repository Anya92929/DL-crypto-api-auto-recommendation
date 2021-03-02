package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.zzin;

@zzin
public class zzo extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private final ImageButton f3807a;

    /* renamed from: b */
    private final zzu f3808b;

    public zzo(Context context, int i, zzu zzu) {
        super(context);
        this.f3808b = zzu;
        setOnClickListener(this);
        this.f3807a = new ImageButton(context);
        this.f3807a.setImageResource(17301527);
        this.f3807a.setBackgroundColor(0);
        this.f3807a.setOnClickListener(this);
        this.f3807a.setPadding(0, 0, 0, 0);
        this.f3807a.setContentDescription("Interstitial close button");
        int zza = zzm.zziw().zza(context, i);
        addView(this.f3807a, new FrameLayout.LayoutParams(zza, zza, 17));
    }

    public void onClick(View view) {
        if (this.f3808b != null) {
            this.f3808b.zznv();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.f3807a.setVisibility(0);
        } else if (z) {
            this.f3807a.setVisibility(4);
        } else {
            this.f3807a.setVisibility(8);
        }
    }
}
