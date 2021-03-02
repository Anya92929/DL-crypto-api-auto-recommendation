package android.support.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.percent.a */
public class C0079a {

    /* renamed from: a */
    private final ViewGroup f227a;

    public C0079a(ViewGroup viewGroup) {
        this.f227a = viewGroup;
    }

    /* renamed from: a */
    public static C0080b m367a(Context context, AttributeSet attributeSet) {
        C0080b bVar = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0084f.PercentLayout_Layout);
        float fraction = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_widthPercent, 1, 1, -1.0f);
        if (fraction != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent width: " + fraction);
            }
            if (0 == 0) {
                bVar = new C0080b();
            }
            bVar.f228a = fraction;
        }
        float fraction2 = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_heightPercent, 1, 1, -1.0f);
        if (fraction2 != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent height: " + fraction2);
            }
            if (bVar == null) {
                bVar = new C0080b();
            }
            bVar.f229b = fraction2;
        }
        float fraction3 = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_marginPercent, 1, 1, -1.0f);
        if (fraction3 != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent margin: " + fraction3);
            }
            if (bVar == null) {
                bVar = new C0080b();
            }
            bVar.f230c = fraction3;
            bVar.f231d = fraction3;
            bVar.f232e = fraction3;
            bVar.f233f = fraction3;
        }
        float fraction4 = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_marginLeftPercent, 1, 1, -1.0f);
        if (fraction4 != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent left margin: " + fraction4);
            }
            if (bVar == null) {
                bVar = new C0080b();
            }
            bVar.f230c = fraction4;
        }
        float fraction5 = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_marginTopPercent, 1, 1, -1.0f);
        if (fraction5 != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent top margin: " + fraction5);
            }
            if (bVar == null) {
                bVar = new C0080b();
            }
            bVar.f231d = fraction5;
        }
        float fraction6 = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_marginRightPercent, 1, 1, -1.0f);
        if (fraction6 != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent right margin: " + fraction6);
            }
            if (bVar == null) {
                bVar = new C0080b();
            }
            bVar.f232e = fraction6;
        }
        float fraction7 = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_marginBottomPercent, 1, 1, -1.0f);
        if (fraction7 != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent bottom margin: " + fraction7);
            }
            if (bVar == null) {
                bVar = new C0080b();
            }
            bVar.f233f = fraction7;
        }
        float fraction8 = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_marginStartPercent, 1, 1, -1.0f);
        if (fraction8 != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent start margin: " + fraction8);
            }
            if (bVar == null) {
                bVar = new C0080b();
            }
            bVar.f234g = fraction8;
        }
        float fraction9 = obtainStyledAttributes.getFraction(C0084f.PercentLayout_Layout_layout_marginEndPercent, 1, 1, -1.0f);
        if (fraction9 != -1.0f) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent end margin: " + fraction9);
            }
            if (bVar == null) {
                bVar = new C0080b();
            }
            bVar.f235h = fraction9;
        }
        obtainStyledAttributes.recycle();
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "constructed: " + bVar);
        }
        return bVar;
    }

    /* renamed from: a */
    public static void m368a(ViewGroup.LayoutParams layoutParams, TypedArray typedArray, int i, int i2) {
        layoutParams.width = typedArray.getLayoutDimension(i, 0);
        layoutParams.height = typedArray.getLayoutDimension(i2, 0);
    }

    /* renamed from: a */
    private static boolean m369a(View view, C0080b bVar) {
        return (ViewCompat.getMeasuredWidthAndState(view) & ViewCompat.MEASURED_STATE_MASK) == 16777216 && bVar.f228a >= BitmapDescriptorFactory.HUE_RED && bVar.f236i.width == -2;
    }

    /* renamed from: b */
    private static boolean m370b(View view, C0080b bVar) {
        return (ViewCompat.getMeasuredHeightAndState(view) & ViewCompat.MEASURED_STATE_MASK) == 16777216 && bVar.f229b >= BitmapDescriptorFactory.HUE_RED && bVar.f236i.height == -2;
    }

    /* renamed from: a */
    public void mo326a() {
        int childCount = this.f227a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f227a.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should restore " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof C0081c) {
                C0080b a = ((C0081c) layoutParams).mo334a();
                if (Log.isLoggable("PercentLayout", 3)) {
                    Log.d("PercentLayout", "using " + a);
                }
                if (a != null) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        a.mo331a((ViewGroup.MarginLayoutParams) layoutParams);
                    } else {
                        a.mo329a(layoutParams);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo327a(int i, int i2) {
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "adjustChildren: " + this.f227a + " widthMeasureSpec: " + View.MeasureSpec.toString(i) + " heightMeasureSpec: " + View.MeasureSpec.toString(i2));
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int childCount = this.f227a.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f227a.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should adjust " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof C0081c) {
                C0080b a = ((C0081c) layoutParams).mo334a();
                if (Log.isLoggable("PercentLayout", 3)) {
                    Log.d("PercentLayout", "using " + a);
                }
                if (a != null) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        a.mo332a((ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                    } else {
                        a.mo330a(layoutParams, size, size2);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public boolean mo328b() {
        C0080b a;
        boolean z;
        int childCount = this.f227a.getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f227a.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should handle measured state too small " + childAt + " " + layoutParams);
            }
            if ((layoutParams instanceof C0081c) && (a = ((C0081c) layoutParams).mo334a()) != null) {
                if (m369a(childAt, a)) {
                    layoutParams.width = -2;
                    z = true;
                } else {
                    z = z2;
                }
                if (m370b(childAt, a)) {
                    layoutParams.height = -2;
                    z2 = true;
                } else {
                    z2 = z;
                }
            }
        }
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "should trigger second measure pass: " + z2);
        }
        return z2;
    }
}
