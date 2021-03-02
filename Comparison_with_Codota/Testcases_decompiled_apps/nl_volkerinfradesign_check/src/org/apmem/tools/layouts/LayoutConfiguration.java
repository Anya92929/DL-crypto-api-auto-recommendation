package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class LayoutConfiguration {

    /* renamed from: a */
    private int f7275a = 0;

    /* renamed from: b */
    private boolean f7276b = false;

    /* renamed from: c */
    private float f7277c = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: d */
    private int f7278d = 51;

    /* renamed from: e */
    private int f7279e = 0;

    public LayoutConfiguration(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1993R.styleable.FlowLayout);
        try {
            mo13688a(obtainStyledAttributes.getInteger(C1993R.styleable.FlowLayout_android_orientation, 0));
            mo13689a(obtainStyledAttributes.getBoolean(C1993R.styleable.FlowLayout_debugDraw, false));
            mo13687a(obtainStyledAttributes.getFloat(C1993R.styleable.FlowLayout_weightDefault, BitmapDescriptorFactory.HUE_RED));
            mo13690b(obtainStyledAttributes.getInteger(C1993R.styleable.FlowLayout_android_gravity, 0));
            mo13693c(obtainStyledAttributes.getInteger(C1993R.styleable.FlowLayout_layoutDirection, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public int mo13686a() {
        return this.f7275a;
    }

    /* renamed from: a */
    public void mo13688a(int i) {
        if (i == 1) {
            this.f7275a = i;
        } else {
            this.f7275a = 0;
        }
    }

    /* renamed from: b */
    public boolean mo13691b() {
        return this.f7276b;
    }

    /* renamed from: a */
    public void mo13689a(boolean z) {
        this.f7276b = z;
    }

    /* renamed from: c */
    public float mo13692c() {
        return this.f7277c;
    }

    /* renamed from: a */
    public void mo13687a(float f) {
        this.f7277c = Math.max(BitmapDescriptorFactory.HUE_RED, f);
    }

    /* renamed from: d */
    public int mo13694d() {
        return this.f7278d;
    }

    /* renamed from: b */
    public void mo13690b(int i) {
        this.f7278d = i;
    }

    /* renamed from: e */
    public int mo13695e() {
        return this.f7279e;
    }

    /* renamed from: c */
    public void mo13693c(int i) {
        if (i == 1) {
            this.f7279e = i;
        } else {
            this.f7279e = 0;
        }
    }
}
