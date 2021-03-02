package android.support.p007a.p008a;

import android.graphics.Path;
import android.support.p021v7.p023b.C0515k;
import android.util.Log;

/* renamed from: android.support.a.a.i */
public class C0013i {

    /* renamed from: a */
    char f74a;

    /* renamed from: b */
    float[] f75b;

    private C0013i(char c, float[] fArr) {
        this.f74a = c;
        this.f75b = fArr;
    }

    private C0013i(C0013i iVar) {
        this.f74a = iVar.f74a;
        this.f75b = C0010f.m62b(iVar.f75b, 0, iVar.f75b.length);
    }

    /* renamed from: a */
    private static void m63a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        int ceil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
        double cos = Math.cos(d7);
        double sin = Math.sin(d7);
        double cos2 = Math.cos(d8);
        double sin2 = Math.sin(d8);
        double d10 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
        double d11 = d9 / ((double) ceil);
        int i = 0;
        double d12 = (sin2 * (-d3) * sin) + (cos2 * d4 * cos);
        double d13 = d10;
        while (i < ceil) {
            double d14 = d8 + d11;
            double sin3 = Math.sin(d14);
            double cos3 = Math.cos(d14);
            double d15 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * sin3);
            double d16 = (d4 * cos * sin3) + (d3 * sin * cos3) + d2;
            double d17 = (((-d3) * cos) * sin3) - ((d4 * sin) * cos3);
            double d18 = (cos3 * d4 * cos) + (sin3 * (-d3) * sin);
            double tan = Math.tan((d14 - d8) / 2.0d);
            double sqrt = ((Math.sqrt((tan * (3.0d * tan)) + 4.0d) - 1.0d) * Math.sin(d14 - d8)) / 3.0d;
            path.cubicTo((float) ((d13 * sqrt) + d5), (float) (d6 + (d12 * sqrt)), (float) (d15 - (sqrt * d17)), (float) (d16 - (sqrt * d18)), (float) d15, (float) d16);
            i++;
            d13 = d17;
            d8 = d14;
            d6 = d16;
            d5 = d15;
            d12 = d18;
        }
    }

    /* renamed from: a */
    private static void m64a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians((double) f7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d3 = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
        double d4 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
        double d5 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
        double d6 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
        double d7 = d3 - d5;
        double d8 = d4 - d6;
        double d9 = (d3 + d5) / 2.0d;
        double d10 = (d4 + d6) / 2.0d;
        double d11 = (d7 * d7) + (d8 * d8);
        if (d11 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d12 = (1.0d / d11) - 0.25d;
        if (d12 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d11);
            float sqrt = (float) (Math.sqrt(d11) / 1.99999d);
            m64a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d12);
        double d13 = d7 * sqrt2;
        double d14 = d8 * sqrt2;
        if (z == z2) {
            d = d9 - d14;
            d2 = d13 + d10;
        } else {
            d = d14 + d9;
            d2 = d10 - d13;
        }
        double atan2 = Math.atan2(d4 - d2, d3 - d);
        double atan22 = Math.atan2(d6 - d2, d5 - d) - atan2;
        if (z2 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d15 = ((double) f5) * d;
        double d16 = d2 * ((double) f6);
        m63a(path, (d15 * cos) - (d16 * sin), (d15 * sin) + (d16 * cos), (double) f5, (double) f6, (double) f, (double) f2, radians, atan2, atan22);
    }

    /* renamed from: a */
    private static void m65a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
        int i;
        float f;
        float f2;
        int i2;
        float f3;
        int i3;
        int i4;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        int i5 = fArr[0];
        int i6 = fArr[1];
        int i7 = fArr[2];
        int i8 = fArr[3];
        int i9 = fArr[4];
        int i10 = fArr[5];
        switch (c2) {
            case C0515k.AppCompatTheme_imageButtonStyle /*65*/:
            case C0515k.AppCompatTheme_textColorAlertDialogListItem /*97*/:
                i = 7;
                break;
            case C0515k.AppCompatTheme_textAppearanceSearchResultSubtitle /*67*/:
            case C0515k.AppCompatTheme_buttonBarNegativeButtonStyle /*99*/:
                i = 6;
                break;
            case C0515k.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
            case C0515k.AppCompatTheme_colorControlNormal /*86*/:
            case C0515k.AppCompatTheme_checkboxStyle /*104*/:
            case 'v':
                i = 1;
                break;
            case C0515k.AppCompatTheme_listPopupWindowStyle /*76*/:
            case C0515k.AppCompatTheme_textAppearanceListItem /*77*/:
            case C0515k.AppCompatTheme_colorPrimaryDark /*84*/:
            case C0515k.AppCompatTheme_ratingBarStyle /*108*/:
            case C0515k.AppCompatTheme_ratingBarStyleIndicator /*109*/:
            case 't':
                i = 2;
                break;
            case C0515k.AppCompatTheme_panelMenuListTheme /*81*/:
            case C0515k.AppCompatTheme_colorPrimary /*83*/:
            case C0515k.AppCompatTheme_switchStyle /*113*/:
            case 's':
                i = 4;
                break;
            case 'Z':
            case 'z':
                path.close();
                path.moveTo(i9, i10);
                i8 = i10;
                i7 = i9;
                i6 = i10;
                i5 = i9;
                i = 2;
                break;
            default:
                i = 2;
                break;
        }
        int i11 = 0;
        int i12 = i10;
        int i13 = i9;
        int i14 = i6;
        int i15 = i5;
        while (i11 < fArr2.length) {
            switch (c2) {
                case C0515k.AppCompatTheme_imageButtonStyle /*65*/:
                    m64a(path, i15, i14, fArr2[i11 + 5], fArr2[i11 + 6], fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3] != 0.0f, fArr2[i11 + 4] != 0.0f);
                    int i16 = fArr2[i11 + 5];
                    int i17 = fArr2[i11 + 6];
                    f = i12;
                    f2 = i13;
                    i2 = i16;
                    f3 = i17;
                    i3 = i16;
                    i4 = i17;
                    break;
                case C0515k.AppCompatTheme_textAppearanceSearchResultSubtitle /*67*/:
                    path.cubicTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3], fArr2[i11 + 4], fArr2[i11 + 5]);
                    float f10 = fArr2[i11 + 4];
                    int i18 = fArr2[i11 + 5];
                    i2 = fArr2[i11 + 2];
                    f3 = i18;
                    i3 = f10;
                    f = i12;
                    f2 = i13;
                    i4 = fArr2[i11 + 3];
                    break;
                case C0515k.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                    path.lineTo(fArr2[i11 + 0], i14);
                    f = i12;
                    i2 = i7;
                    f3 = i14;
                    i3 = fArr2[i11 + 0];
                    i4 = i8;
                    f2 = i13;
                    break;
                case C0515k.AppCompatTheme_listPopupWindowStyle /*76*/:
                    path.lineTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                    float f11 = fArr2[i11 + 0];
                    i2 = i7;
                    f3 = fArr2[i11 + 1];
                    i3 = f11;
                    f = i12;
                    f2 = i13;
                    i4 = i8;
                    break;
                case C0515k.AppCompatTheme_textAppearanceListItem /*77*/:
                    f2 = fArr2[i11 + 0];
                    f = fArr2[i11 + 1];
                    if (i11 <= 0) {
                        path.moveTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                        i2 = i7;
                        f3 = f;
                        i3 = f2;
                        i4 = i8;
                        break;
                    } else {
                        path.lineTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                        i2 = i7;
                        f3 = f;
                        i3 = f2;
                        f = i12;
                        f2 = i13;
                        i4 = i8;
                        break;
                    }
                case C0515k.AppCompatTheme_panelMenuListTheme /*81*/:
                    path.quadTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3]);
                    float f12 = fArr2[i11 + 0];
                    int i19 = fArr2[i11 + 1];
                    float f13 = fArr2[i11 + 2];
                    i2 = f12;
                    f3 = fArr2[i11 + 3];
                    i3 = f13;
                    f = i12;
                    f2 = i13;
                    i4 = i19;
                    break;
                case C0515k.AppCompatTheme_colorPrimary /*83*/:
                    if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                        f7 = (2.0f * i15) - i7;
                        f6 = (2.0f * i14) - i8;
                    } else {
                        f6 = i14;
                        f7 = i15;
                    }
                    path.cubicTo(f7, f6, fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3]);
                    int i20 = fArr2[i11 + 0];
                    int i21 = fArr2[i11 + 1];
                    float f14 = fArr2[i11 + 2];
                    i2 = i20;
                    f3 = fArr2[i11 + 3];
                    i3 = f14;
                    f = i12;
                    f2 = i13;
                    i4 = i21;
                    break;
                case C0515k.AppCompatTheme_colorPrimaryDark /*84*/:
                    if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                        i15 = (2.0f * i15) - i7;
                        i14 = (2.0f * i14) - i8;
                    }
                    path.quadTo(i15, i14, fArr2[i11 + 0], fArr2[i11 + 1]);
                    float f15 = fArr2[i11 + 0];
                    i4 = i14;
                    i2 = i15;
                    f3 = fArr2[i11 + 1];
                    i3 = f15;
                    f = i12;
                    f2 = i13;
                    break;
                case C0515k.AppCompatTheme_colorControlNormal /*86*/:
                    path.lineTo(i15, fArr2[i11 + 0]);
                    f2 = i13;
                    i2 = i7;
                    f3 = fArr2[i11 + 0];
                    i3 = i15;
                    i4 = i8;
                    f = i12;
                    break;
                case C0515k.AppCompatTheme_textColorAlertDialogListItem /*97*/:
                    m64a(path, i15, i14, fArr2[i11 + 5] + i15, fArr2[i11 + 6] + i14, fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3] != 0.0f, fArr2[i11 + 4] != 0.0f);
                    float f16 = i15 + fArr2[i11 + 5];
                    float f17 = fArr2[i11 + 6] + i14;
                    f = i12;
                    f2 = i13;
                    i2 = f16;
                    f3 = f17;
                    i3 = f16;
                    i4 = f17;
                    break;
                case C0515k.AppCompatTheme_buttonBarNegativeButtonStyle /*99*/:
                    path.rCubicTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3], fArr2[i11 + 4], fArr2[i11 + 5]);
                    float f18 = i15 + fArr2[i11 + 2];
                    float f19 = i15 + fArr2[i11 + 4];
                    i2 = f18;
                    f3 = fArr2[i11 + 5] + i14;
                    i3 = f19;
                    f = i12;
                    f2 = i13;
                    i4 = fArr2[i11 + 3] + i14;
                    break;
                case C0515k.AppCompatTheme_checkboxStyle /*104*/:
                    path.rLineTo(fArr2[i11 + 0], 0.0f);
                    f = i12;
                    i2 = i7;
                    f3 = i14;
                    i3 = i15 + fArr2[i11 + 0];
                    i4 = i8;
                    f2 = i13;
                    break;
                case C0515k.AppCompatTheme_ratingBarStyle /*108*/:
                    path.rLineTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                    float f20 = i15 + fArr2[i11 + 0];
                    i2 = i7;
                    f3 = fArr2[i11 + 1] + i14;
                    i3 = f20;
                    f = i12;
                    f2 = i13;
                    i4 = i8;
                    break;
                case C0515k.AppCompatTheme_ratingBarStyleIndicator /*109*/:
                    f2 = i15 + fArr2[i11 + 0];
                    f = fArr2[i11 + 1] + i14;
                    if (i11 <= 0) {
                        path.rMoveTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                        i2 = i7;
                        f3 = f;
                        i3 = f2;
                        i4 = i8;
                        break;
                    } else {
                        path.rLineTo(fArr2[i11 + 0], fArr2[i11 + 1]);
                        i2 = i7;
                        f3 = f;
                        i3 = f2;
                        f = i12;
                        f2 = i13;
                        i4 = i8;
                        break;
                    }
                case C0515k.AppCompatTheme_switchStyle /*113*/:
                    path.rQuadTo(fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3]);
                    float f21 = i15 + fArr2[i11 + 0];
                    float f22 = i15 + fArr2[i11 + 2];
                    i2 = f21;
                    f3 = fArr2[i11 + 3] + i14;
                    i3 = f22;
                    f = i12;
                    f2 = i13;
                    i4 = fArr2[i11 + 1] + i14;
                    break;
                case 's':
                    if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                        f9 = i15 - i7;
                        f8 = i14 - i8;
                    } else {
                        f8 = 0.0f;
                        f9 = 0.0f;
                    }
                    path.rCubicTo(f9, f8, fArr2[i11 + 0], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3]);
                    float f23 = i15 + fArr2[i11 + 0];
                    float f24 = i15 + fArr2[i11 + 2];
                    i2 = f23;
                    f3 = fArr2[i11 + 3] + i14;
                    i3 = f24;
                    f = i12;
                    f2 = i13;
                    i4 = fArr2[i11 + 1] + i14;
                    break;
                case 't':
                    if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                        f4 = i15 - i7;
                        f5 = i14 - i8;
                    } else {
                        f5 = 0.0f;
                        f4 = 0.0f;
                    }
                    path.rQuadTo(f4, f5, fArr2[i11 + 0], fArr2[i11 + 1]);
                    float f25 = i15 + fArr2[i11 + 0];
                    i2 = i15 + f4;
                    f3 = fArr2[i11 + 1] + i14;
                    i3 = f25;
                    f = i12;
                    f2 = i13;
                    i4 = f5 + i14;
                    break;
                case 'v':
                    path.rLineTo(0.0f, fArr2[i11 + 0]);
                    f2 = i13;
                    i2 = i7;
                    f3 = fArr2[i11 + 0] + i14;
                    i3 = i15;
                    i4 = i8;
                    f = i12;
                    break;
                default:
                    f = i12;
                    f2 = i13;
                    i2 = i7;
                    f3 = i14;
                    i3 = i15;
                    i4 = i8;
                    break;
            }
            i11 += i;
            i12 = f;
            i13 = f2;
            i14 = f3;
            i15 = i3;
            c = c2;
            i8 = i4;
            i7 = i2;
        }
        fArr[0] = i15;
        fArr[1] = i14;
        fArr[2] = i7;
        fArr[3] = i8;
        fArr[4] = i13;
        fArr[5] = i12;
    }

    /* renamed from: a */
    public static void m66a(C0013i[] iVarArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (int i = 0; i < iVarArr.length; i++) {
            m65a(path, fArr, c, iVarArr[i].f74a, iVarArr[i].f75b);
            c = iVarArr[i].f74a;
        }
    }
}
