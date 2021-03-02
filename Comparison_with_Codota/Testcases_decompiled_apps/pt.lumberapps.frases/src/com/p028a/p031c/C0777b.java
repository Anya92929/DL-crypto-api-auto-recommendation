package com.p028a.p031c;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.a.c.b */
public class C0777b extends LinkedHashMap {

    /* renamed from: a */
    private int f2014a;

    /* renamed from: b */
    private int f2015b;

    /* renamed from: c */
    private int f2016c;

    /* renamed from: d */
    private int f2017d;

    public C0777b(int i, int i2, int i3) {
        super(8, 0.75f, true);
        this.f2014a = i;
        this.f2015b = i2;
        this.f2016c = i3;
    }

    /* renamed from: a */
    private int m3542a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth() * bitmap.getHeight();
    }

    /* renamed from: a */
    private void m3543a() {
        if (this.f2017d > this.f2016c) {
            Iterator it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
                if (this.f2017d <= this.f2016c) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public Bitmap remove(Object obj) {
        Bitmap bitmap = (Bitmap) super.remove(obj);
        if (bitmap != null) {
            this.f2017d -= m3542a(bitmap);
        }
        return bitmap;
    }

    /* renamed from: a */
    public Bitmap put(String str, Bitmap bitmap) {
        Bitmap bitmap2 = null;
        int a = m3542a(bitmap);
        if (a <= this.f2015b) {
            this.f2017d += a;
            bitmap2 = (Bitmap) super.put(str, bitmap);
            if (bitmap2 != null) {
                this.f2017d -= m3542a(bitmap2);
            }
        }
        return bitmap2;
    }

    public void clear() {
        super.clear();
        this.f2017d = 0;
    }

    public boolean removeEldestEntry(Map.Entry entry) {
        if (this.f2017d > this.f2016c || size() > this.f2014a) {
            remove(entry.getKey());
        }
        m3543a();
        return false;
    }
}
