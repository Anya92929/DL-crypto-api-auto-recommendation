package com.jackhenry.godough.core.rda.imagecapture;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1495aj;
import java.io.ByteArrayOutputStream;

/* renamed from: com.jackhenry.godough.core.rda.imagecapture.a */
public abstract class C1819a {

    /* renamed from: a */
    protected static int f6669a;

    /* renamed from: b */
    private AbstractActivity f6670b;

    /* renamed from: c */
    private C1823b f6671c;

    public C1819a(AbstractActivity abstractActivity, C1823b bVar) {
        this.f6670b = abstractActivity;
        this.f6671c = bVar;
        f6669a = mo11029a().getResources().getInteger(C1495aj.imageCompression);
    }

    /* renamed from: a */
    public AbstractActivity mo11029a() {
        return this.f6670b;
    }

    /* renamed from: a */
    public abstract void mo11030a(ViewGroup viewGroup);

    /* renamed from: a */
    public byte[] mo11031a(Bitmap bitmap) {
        if (bitmap.getWidth() > 1600) {
            double width = 1600.0d / ((double) bitmap.getWidth());
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (width * ((double) bitmap.getWidth())), (int) (((double) bitmap.getHeight()) * width), true);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, f6669a, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    public C1823b mo11032b() {
        return this.f6671c;
    }

    /* renamed from: c */
    public abstract void mo11033c();

    /* renamed from: d */
    public abstract void mo11034d();
}
