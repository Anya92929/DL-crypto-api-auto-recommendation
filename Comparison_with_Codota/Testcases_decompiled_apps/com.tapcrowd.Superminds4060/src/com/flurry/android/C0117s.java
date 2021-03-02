package com.flurry.android;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* renamed from: com.flurry.android.s */
final class C0117s extends LinearLayout {
    public C0117s(CatalogActivity catalogActivity, Context context) {
        super(context);
        setBackgroundColor(-1);
        AdImage l = catalogActivity.f15e.mo3364l();
        if (l != null) {
            ImageView imageView = new ImageView(context);
            imageView.setId(10000);
            byte[] bArr = l.f7e;
            if (bArr != null) {
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
            C0116r.m124a(context, imageView, C0116r.m121a(context, l.f4b), C0116r.m121a(context, l.f5c));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, -3);
            setGravity(3);
            addView(imageView, layoutParams);
        }
    }
}
