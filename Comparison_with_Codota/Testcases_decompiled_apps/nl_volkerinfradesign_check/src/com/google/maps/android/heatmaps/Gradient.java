package com.google.maps.android.heatmaps;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;

public class Gradient {
    public final int mColorMapSize;
    public int[] mColors;
    public float[] mStartPoints;

    /* renamed from: com.google.maps.android.heatmaps.Gradient$a */
    class C1015a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final int f3972b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final int f3973c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final float f3974d;

        private C1015a(int i, int i2, float f) {
            this.f3972b = i;
            this.f3973c = i2;
            this.f3974d = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, LogTable.MAX_SIZE);
    }

    public Gradient(int[] iArr, float[] fArr, int i) {
        if (iArr.length != fArr.length) {
            throw new IllegalArgumentException("colors and startPoints should be same length");
        } else if (iArr.length == 0) {
            throw new IllegalArgumentException("No colors have been defined");
        } else {
            for (int i2 = 1; i2 < fArr.length; i2++) {
                if (fArr[i2] <= fArr[i2 - 1]) {
                    throw new IllegalArgumentException("startPoints should be in increasing order");
                }
            }
            this.mColorMapSize = i;
            this.mColors = new int[iArr.length];
            this.mStartPoints = new float[fArr.length];
            System.arraycopy(iArr, 0, this.mColors, 0, iArr.length);
            System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
        }
    }

    /* renamed from: a */
    private HashMap<Integer, C1015a> m4532a() {
        HashMap<Integer, C1015a> hashMap = new HashMap<>();
        if (this.mStartPoints[0] != BitmapDescriptorFactory.HUE_RED) {
            hashMap.put(0, new C1015a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mStartPoints[0] * ((float) this.mColorMapSize)));
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.mColors.length) {
                break;
            }
            hashMap.put(Integer.valueOf((int) (((float) this.mColorMapSize) * this.mStartPoints[i2 - 1])), new C1015a(this.mColors[i2 - 1], this.mColors[i2], (this.mStartPoints[i2] - this.mStartPoints[i2 - 1]) * ((float) this.mColorMapSize)));
            i = i2 + 1;
        }
        if (this.mStartPoints[this.mStartPoints.length - 1] != 1.0f) {
            int length = this.mStartPoints.length - 1;
            hashMap.put(Integer.valueOf((int) (((float) this.mColorMapSize) * this.mStartPoints[length])), new C1015a(this.mColors[length], this.mColors[length], ((float) this.mColorMapSize) * (1.0f - this.mStartPoints[length])));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo7928a(double d) {
        C1015a aVar;
        int i;
        HashMap<Integer, C1015a> a = m4532a();
        int[] iArr = new int[this.mColorMapSize];
        int i2 = 0;
        C1015a aVar2 = a.get(0);
        int i3 = 0;
        while (i2 < this.mColorMapSize) {
            if (a.containsKey(Integer.valueOf(i2))) {
                i = i2;
                aVar = a.get(Integer.valueOf(i2));
            } else {
                aVar = aVar2;
                i = i3;
            }
            iArr[i2] = m4531a(aVar.f3972b, aVar.f3973c, ((float) (i2 - i)) / aVar.f3974d);
            i2++;
            i3 = i;
            aVar2 = aVar;
        }
        if (d != 1.0d) {
            for (int i4 = 0; i4 < this.mColorMapSize; i4++) {
                int i5 = iArr[i4];
                iArr[i4] = Color.argb((int) (((double) Color.alpha(i5)) * d), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
        return iArr;
    }

    /* renamed from: a */
    static int m4531a(int i, int i2, float f) {
        int alpha = (int) ((((float) (Color.alpha(i2) - Color.alpha(i))) * f) + ((float) Color.alpha(i)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }
}
