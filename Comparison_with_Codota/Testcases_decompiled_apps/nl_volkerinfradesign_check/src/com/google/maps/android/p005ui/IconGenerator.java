package com.google.maps.android.p005ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.maps.android.C0994R;

/* renamed from: com.google.maps.android.ui.IconGenerator */
public class IconGenerator {
    public static final int STYLE_BLUE = 4;
    public static final int STYLE_DEFAULT = 1;
    public static final int STYLE_GREEN = 5;
    public static final int STYLE_ORANGE = 7;
    public static final int STYLE_PURPLE = 6;
    public static final int STYLE_RED = 3;
    public static final int STYLE_WHITE = 2;

    /* renamed from: a */
    private final Context f4019a;

    /* renamed from: b */
    private ViewGroup f4020b;

    /* renamed from: c */
    private RotationLayout f4021c;

    /* renamed from: d */
    private TextView f4022d;

    /* renamed from: e */
    private View f4023e;

    /* renamed from: f */
    private int f4024f;

    /* renamed from: g */
    private float f4025g = 0.5f;

    /* renamed from: h */
    private float f4026h = 1.0f;

    /* renamed from: i */
    private C1223hw f4027i;

    public IconGenerator(Context context) {
        this.f4019a = context;
        this.f4027i = new C1223hw(this.f4019a.getResources());
        this.f4020b = (ViewGroup) LayoutInflater.from(this.f4019a).inflate(C0994R.layout.text_bubble, (ViewGroup) null);
        this.f4021c = (RotationLayout) this.f4020b.getChildAt(0);
        TextView textView = (TextView) this.f4021c.findViewById(C0994R.C0996id.text);
        this.f4022d = textView;
        this.f4023e = textView;
        setStyle(1);
    }

    public Bitmap makeIcon(CharSequence charSequence) {
        if (this.f4022d != null) {
            this.f4022d.setText(charSequence);
        }
        return makeIcon();
    }

    public Bitmap makeIcon() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f4020b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = this.f4020b.getMeasuredWidth();
        int measuredHeight = this.f4020b.getMeasuredHeight();
        this.f4020b.layout(0, 0, measuredWidth, measuredHeight);
        if (this.f4024f == 1 || this.f4024f == 3) {
            measuredHeight = this.f4020b.getMeasuredWidth();
            measuredWidth = this.f4020b.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        Canvas canvas = new Canvas(createBitmap);
        if (this.f4024f != 0) {
            if (this.f4024f == 1) {
                canvas.translate((float) measuredWidth, BitmapDescriptorFactory.HUE_RED);
                canvas.rotate(90.0f);
            } else if (this.f4024f == 2) {
                canvas.rotate(180.0f, (float) (measuredWidth / 2), (float) (measuredHeight / 2));
            } else {
                canvas.translate(BitmapDescriptorFactory.HUE_RED, (float) measuredHeight);
                canvas.rotate(270.0f);
            }
        }
        this.f4020b.draw(canvas);
        return createBitmap;
    }

    public void setContentView(View view) {
        this.f4021c.removeAllViews();
        this.f4021c.addView(view);
        this.f4023e = view;
        View findViewById = this.f4021c.findViewById(C0994R.C0996id.text);
        this.f4022d = findViewById instanceof TextView ? (TextView) findViewById : null;
    }

    public void setContentRotation(int i) {
        this.f4021c.mo8009a(i);
    }

    public void setRotation(int i) {
        this.f4024f = ((i + 360) % 360) / 90;
    }

    public float getAnchorU() {
        return m4561a(this.f4025g, this.f4026h);
    }

    public float getAnchorV() {
        return m4561a(this.f4026h, this.f4025g);
    }

    /* renamed from: a */
    private float m4561a(float f, float f2) {
        switch (this.f4024f) {
            case 0:
                return f;
            case 1:
                return 1.0f - f2;
            case 2:
                return 1.0f - f;
            case 3:
                return f2;
            default:
                throw new IllegalStateException();
        }
    }

    public void setTextAppearance(Context context, int i) {
        if (this.f4022d != null) {
            this.f4022d.setTextAppearance(context, i);
        }
    }

    public void setTextAppearance(int i) {
        setTextAppearance(this.f4019a, i);
    }

    public void setStyle(int i) {
        setColor(m4562a(i));
        setTextAppearance(this.f4019a, m4563b(i));
    }

    public void setColor(int i) {
        this.f4027i.mo8362a(i);
        setBackground(this.f4027i);
    }

    public void setBackground(Drawable drawable) {
        this.f4020b.setBackgroundDrawable(drawable);
        if (drawable != null) {
            Rect rect = new Rect();
            drawable.getPadding(rect);
            this.f4020b.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            return;
        }
        this.f4020b.setPadding(0, 0, 0, 0);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.f4023e.setPadding(i, i2, i3, i4);
    }

    /* renamed from: a */
    private static int m4562a(int i) {
        switch (i) {
            case 3:
                return -3407872;
            case 4:
                return -16737844;
            case 5:
                return -10053376;
            case 6:
                return -6736948;
            case 7:
                return -30720;
            default:
                return -1;
        }
    }

    /* renamed from: b */
    private static int m4563b(int i) {
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return C0994R.style.Bubble_TextAppearance_Light;
            default:
                return C0994R.style.Bubble_TextAppearance_Dark;
        }
    }
}
