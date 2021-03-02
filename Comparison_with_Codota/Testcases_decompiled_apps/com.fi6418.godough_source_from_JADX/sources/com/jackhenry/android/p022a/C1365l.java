package com.jackhenry.android.p022a;

import android.content.res.TypedArray;
import android.graphics.Paint;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.jackhenry.android.a.l */
public class C1365l {
    /* renamed from: a */
    public static Calendar m5594a(TypedArray typedArray, int i) {
        String string = typedArray.getString(i);
        if (C1364k.m5591b(string)) {
            if (string.equalsIgnoreCase("today")) {
                Calendar instance = Calendar.getInstance();
                C1348a.m5553a(instance);
                return instance;
            }
            try {
                Date parse = new SimpleDateFormat("MM/dd/yyyy", Locale.US).parse(string);
                if (parse != null) {
                    Calendar instance2 = Calendar.getInstance();
                    instance2.setTime(parse);
                    C1348a.m5553a(instance2);
                    return instance2;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m5595a(TypedArray typedArray, Paint paint, int i, int i2, int i3, int i4) {
        float f = 1.0f;
        float f2 = typedArray.getFloat(i, -1.0f);
        float f3 = typedArray.getFloat(i2, -1.0f);
        float f4 = typedArray.getFloat(i3, -1.0f);
        if (f2 != -1.0f || f3 != -1.0f || f4 != -1.0f) {
            if (f2 == -1.0f) {
                f2 = 1.0f;
            }
            if (f3 == -1.0f) {
                f3 = 1.0f;
            }
            if (f4 != -1.0f) {
                f = f4;
            }
            paint.setShadowLayer(f2, f3, f, typedArray.getColor(i4, -1));
        }
    }
}
