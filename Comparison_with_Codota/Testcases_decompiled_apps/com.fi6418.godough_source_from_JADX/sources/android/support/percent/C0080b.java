package android.support.percent;

import android.support.p000v4.view.MarginLayoutParamsCompat;
import android.util.Log;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.percent.b */
public class C0080b {

    /* renamed from: a */
    public float f228a = -1.0f;

    /* renamed from: b */
    public float f229b = -1.0f;

    /* renamed from: c */
    public float f230c = -1.0f;

    /* renamed from: d */
    public float f231d = -1.0f;

    /* renamed from: e */
    public float f232e = -1.0f;

    /* renamed from: f */
    public float f233f = -1.0f;

    /* renamed from: g */
    public float f234g = -1.0f;

    /* renamed from: h */
    public float f235h = -1.0f;

    /* renamed from: i */
    final ViewGroup.MarginLayoutParams f236i = new ViewGroup.MarginLayoutParams(0, 0);

    /* renamed from: a */
    public void mo329a(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = this.f236i.width;
        layoutParams.height = this.f236i.height;
    }

    /* renamed from: a */
    public void mo330a(ViewGroup.LayoutParams layoutParams, int i, int i2) {
        this.f236i.width = layoutParams.width;
        this.f236i.height = layoutParams.height;
        if (this.f228a >= BitmapDescriptorFactory.HUE_RED) {
            layoutParams.width = (int) (((float) i) * this.f228a);
        }
        if (this.f229b >= BitmapDescriptorFactory.HUE_RED) {
            layoutParams.height = (int) (((float) i2) * this.f229b);
        }
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "after fillLayoutParams: (" + layoutParams.width + ", " + layoutParams.height + ")");
        }
    }

    /* renamed from: a */
    public void mo331a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        mo329a((ViewGroup.LayoutParams) marginLayoutParams);
        marginLayoutParams.leftMargin = this.f236i.leftMargin;
        marginLayoutParams.topMargin = this.f236i.topMargin;
        marginLayoutParams.rightMargin = this.f236i.rightMargin;
        marginLayoutParams.bottomMargin = this.f236i.bottomMargin;
        MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, MarginLayoutParamsCompat.getMarginStart(this.f236i));
        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.f236i));
    }

    /* renamed from: a */
    public void mo332a(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        mo330a((ViewGroup.LayoutParams) marginLayoutParams, i, i2);
        this.f236i.leftMargin = marginLayoutParams.leftMargin;
        this.f236i.topMargin = marginLayoutParams.topMargin;
        this.f236i.rightMargin = marginLayoutParams.rightMargin;
        this.f236i.bottomMargin = marginLayoutParams.bottomMargin;
        MarginLayoutParamsCompat.setMarginStart(this.f236i, MarginLayoutParamsCompat.getMarginStart(marginLayoutParams));
        MarginLayoutParamsCompat.setMarginEnd(this.f236i, MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams));
        if (this.f230c >= BitmapDescriptorFactory.HUE_RED) {
            marginLayoutParams.leftMargin = (int) (((float) i) * this.f230c);
        }
        if (this.f231d >= BitmapDescriptorFactory.HUE_RED) {
            marginLayoutParams.topMargin = (int) (((float) i2) * this.f231d);
        }
        if (this.f232e >= BitmapDescriptorFactory.HUE_RED) {
            marginLayoutParams.rightMargin = (int) (((float) i) * this.f232e);
        }
        if (this.f233f >= BitmapDescriptorFactory.HUE_RED) {
            marginLayoutParams.bottomMargin = (int) (((float) i2) * this.f233f);
        }
        if (this.f234g >= BitmapDescriptorFactory.HUE_RED) {
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, (int) (((float) i) * this.f234g));
        }
        if (this.f235h >= BitmapDescriptorFactory.HUE_RED) {
            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, (int) (((float) i) * this.f235h));
        }
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "after fillMarginLayoutParams: (" + marginLayoutParams.width + ", " + marginLayoutParams.height + ")");
        }
    }

    public String toString() {
        return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f,  %f, %f, %f, %f)", new Object[]{Float.valueOf(this.f228a), Float.valueOf(this.f229b), Float.valueOf(this.f230c), Float.valueOf(this.f231d), Float.valueOf(this.f232e), Float.valueOf(this.f233f), Float.valueOf(this.f234g), Float.valueOf(this.f235h)});
    }
}
