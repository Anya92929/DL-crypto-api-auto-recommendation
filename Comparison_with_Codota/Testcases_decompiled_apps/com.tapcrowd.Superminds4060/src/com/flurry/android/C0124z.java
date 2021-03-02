package com.flurry.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: com.flurry.android.z */
final class C0124z extends RelativeLayout {

    /* renamed from: a */
    private C0120v f273a;

    /* renamed from: b */
    private C0114p f274b;

    /* renamed from: c */
    private int f275c;

    public C0124z(Context context, C0120v vVar, C0114p pVar, C0103e eVar, int i, boolean z) {
        super(context);
        this.f273a = vVar;
        this.f274b = pVar;
        C0121w wVar = pVar.f218c;
        this.f275c = i;
        switch (this.f275c) {
            case 1:
                break;
            case 2:
                if (!z) {
                    m183a(context, eVar, wVar, true);
                    break;
                } else {
                    m183a(context, eVar, wVar, false);
                    break;
                }
        }
        if (z) {
            m183a(context, eVar, wVar, false);
        } else {
            m183a(context, eVar, wVar, true);
        }
        setFocusable(true);
    }

    /* renamed from: a */
    private void m183a(Context context, C0103e eVar, C0121w wVar, boolean z) {
        Drawable bitmapDrawable;
        Bitmap bitmap;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        C0101c cVar = eVar.f194d;
        ImageView imageView = new ImageView(context);
        imageView.setId(1);
        AdImage adImage = wVar.f266h;
        if (adImage != null) {
            byte[] bArr = adImage.f7e;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (decodeByteArray == null) {
                C0095ai.m96a("FlurryAgent", "Ad with bad image: " + wVar.f262d + ", data: " + bArr);
            }
            if (decodeByteArray != null) {
                Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray.getWidth(), decodeByteArray.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight());
                RectF rectF = new RectF(rect);
                float a = (float) C0116r.m121a(context, 8);
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-16777216);
                canvas.drawRoundRect(rectF, a, a, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(decodeByteArray, rect, rect, paint);
                if (Integer.parseInt(Build.VERSION.SDK) > 4) {
                    BlurMaskFilter blurMaskFilter = new BlurMaskFilter(3.0f, BlurMaskFilter.Blur.OUTER);
                    Paint paint2 = new Paint();
                    paint2.setMaskFilter(blurMaskFilter);
                    int[] iArr = new int[2];
                    bitmap = createBitmap.extractAlpha(paint2, iArr).copy(Bitmap.Config.ARGB_8888, true);
                    new Canvas(bitmap).drawBitmap(createBitmap, (float) (-iArr[0]), (float) (-iArr[1]), (Paint) null);
                } else {
                    bitmap = createBitmap;
                }
                imageView.setImageBitmap(bitmap);
                C0116r.m124a(context, imageView, C0116r.m121a(context, cVar.f174m), C0116r.m121a(context, cVar.f175n));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        }
        AdImage a2 = this.f273a.mo3334a(cVar.f164c);
        if (a2 != null) {
            byte[] bArr2 = a2.f7e;
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
            if (NinePatch.isNinePatchChunk(decodeByteArray2.getNinePatchChunk())) {
                bitmapDrawable = new NinePatchDrawable(decodeByteArray2, decodeByteArray2.getNinePatchChunk(), new Rect(0, 0, 0, 0), (String) null);
            } else {
                bitmapDrawable = new BitmapDrawable(decodeByteArray2);
            }
            setBackgroundDrawable(bitmapDrawable);
        }
        TextView textView = new TextView(context);
        textView.setId(5);
        textView.setPadding(0, 0, 0, 0);
        TextView textView2 = new TextView(context);
        textView2.setId(3);
        textView2.setPadding(0, 0, 0, 0);
        if (z) {
            textView.setTextColor(cVar.f167f);
            textView.setTextSize((float) cVar.f166e);
            textView.setText(new String("• " + cVar.f163b));
            textView.setTypeface(Typeface.create(cVar.f165d, 0));
            textView2.setTextColor(cVar.f170i);
            textView2.setTextSize((float) cVar.f169h);
            textView2.setTypeface(Typeface.create(cVar.f168g, 0));
            textView2.setText(wVar.f262d);
        } else {
            textView.setId(3);
            textView.setText(wVar.f262d);
            textView.setTextColor(cVar.f170i);
            textView.setTextSize((float) cVar.f169h);
            textView.setTypeface(Typeface.create(cVar.f168g, 0));
            textView2.setId(4);
            textView2.setText(wVar.f261c);
            textView2.setTextColor(cVar.f173l);
            textView2.setTextSize((float) cVar.f172k);
            textView2.setTypeface(Typeface.create(cVar.f171j, 0));
        }
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView(new ImageView(context), new RelativeLayout.LayoutParams(-1, -2));
        int i = (cVar.f178q - (cVar.f176o << 1)) - cVar.f174m;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.setMargins(cVar.f176o, cVar.f177p, i, 0);
        addView(imageView, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.addRule(1, imageView.getId());
        layoutParams2.setMargins(0, 0, 0, 0);
        addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, imageView.getId());
        layoutParams3.addRule(3, textView.getId());
        layoutParams3.setMargins(0, -2, 0, 0);
        addView(textView2, layoutParams3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0114p mo3374a() {
        return this.f274b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3375a(C0114p pVar) {
        this.f274b = pVar;
    }
}
