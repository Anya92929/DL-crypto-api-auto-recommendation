package com.jackhenry.godough.core.p038e;

import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.p000v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.jackhenry.godough.core.C1490ae;
import com.jackhenry.godough.core.C1491af;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.GoDoughApp;
import java.io.File;

/* renamed from: com.jackhenry.godough.core.e.o */
public class C1586o {
    /* renamed from: a */
    public static int m6196a() {
        switch (C1587p.f6162a[new C1585n(GoDoughApp.getApp()).mo9813e().ordinal()]) {
            case 1:
                return C1493ah.transparent;
            case 2:
                return C1493ah.texture_grid_dark;
            case 3:
                return C1493ah.texture_metal;
            case 4:
                return C1493ah.texture_smooth;
            default:
                return C1493ah.transparent;
        }
    }

    /* renamed from: a */
    private static int m6197a(int i, DisplayMetrics displayMetrics) {
        return Math.round(TypedValue.applyDimension(1, (float) i, displayMetrics));
    }

    /* renamed from: a */
    public static void m6198a(LayerDrawable layerDrawable) {
        ((GradientDrawable) layerDrawable.findDrawableByLayerId(C1494ai.color_layer)).setColor(m6203b());
    }

    /* renamed from: a */
    private static void m6199a(LayerDrawable layerDrawable, int i, int i2) {
        layerDrawable.setDrawableByLayerId(C1494ai.color_layer, new ColorDrawable(i));
        BitmapDrawable bitmapDrawable = (BitmapDrawable) GoDoughApp.getApp().getResources().getDrawable(i2);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        layerDrawable.setDrawableByLayerId(C1494ai.tile_layer, bitmapDrawable);
    }

    /* renamed from: a */
    public static void m6200a(View view) {
        ((GradientDrawable) ((LayerDrawable) view.getBackground()).findDrawableByLayerId(C1494ai.color_layer)).setColor(m6214i());
    }

    /* renamed from: a */
    public static void m6201a(View view, int i, int i2, int i3, int i4) {
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        view.setPadding(m6197a(i, displayMetrics), m6197a(i2, displayMetrics), m6197a(i3, displayMetrics), m6197a(i4, displayMetrics));
    }

    /* renamed from: a */
    private static void m6202a(String str) {
        new File(GoDoughApp.getApp().getFilesDir(), str).delete();
    }

    /* renamed from: b */
    public static int m6203b() {
        return new C1585n(GoDoughApp.getApp()).mo9803a();
    }

    /* renamed from: b */
    private static void m6204b(LayerDrawable layerDrawable) {
        m6199a(layerDrawable, m6203b(), m6196a());
    }

    /* renamed from: b */
    public static void m6205b(View view) {
        Drawable background = view.getBackground();
        if (background instanceof LayerDrawable) {
            m6204b((LayerDrawable) background);
        }
    }

    /* renamed from: c */
    public static void m6206c(View view) {
        Drawable background = view.getBackground();
        int b = m6203b();
        int a = m6196a();
        if (background instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) background;
            if (m6207c() && m6209d()) {
                b = m6213h();
                a = C1493ah.transparent;
            }
            m6199a(layerDrawable, b, a);
        }
    }

    /* renamed from: c */
    public static boolean m6207c() {
        return GoDoughApp.getApp().getResources().getBoolean(C1490ae.theme_center_splashscreen_image);
    }

    /* renamed from: d */
    public static void m6208d(View view) {
        Drawable background = view.getBackground();
        m6203b();
        m6196a();
        if (background instanceof LayerDrawable) {
            ((LayerDrawable) background).setDrawableByLayerId(C1494ai.color_layer, new ColorDrawable(m6203b()));
        }
    }

    /* renamed from: d */
    public static boolean m6209d() {
        return GoDoughApp.getApp().getResources().getBoolean(C1490ae.theme_use_background_color);
    }

    /* renamed from: e */
    public static void m6210e() {
        m6202a("logo_large.png");
    }

    /* renamed from: f */
    public static Drawable m6211f() {
        return ContextCompat.getDrawable(GoDoughApp.getApp(), C1493ah.list_item_last);
    }

    /* renamed from: g */
    public static Drawable m6212g() {
        return ContextCompat.getDrawable(GoDoughApp.getApp(), C1493ah.list_item);
    }

    /* renamed from: h */
    private static int m6213h() {
        return Color.parseColor(GoDoughApp.getApp().getString(C1491af.fiColorBackground));
    }

    /* renamed from: i */
    private static int m6214i() {
        return new C1585n(GoDoughApp.getApp()).mo9811d();
    }
}
