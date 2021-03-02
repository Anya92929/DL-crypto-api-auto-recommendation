package android.support.p001v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.support.p001v4.graphics.BitmapCompat;
import android.support.p001v4.view.GravityCompat;
import android.util.Log;
import java.io.InputStream;

/* renamed from: android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory */
public class RoundedBitmapDrawableFactory {

    /* renamed from: android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory$a */
    static class C0142a extends RoundedBitmapDrawable {
        C0142a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        public void setMipMap(boolean z) {
            if (this.f491a != null) {
                BitmapCompat.setHasMipMap(this.f491a, z);
                invalidateSelf();
            }
        }

        public boolean hasMipMap() {
            return this.f491a != null && BitmapCompat.hasMipMap(this.f491a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo884a(int i, int i2, int i3, Rect rect, Rect rect2) {
            GravityCompat.apply(i, i2, i3, rect, rect2, 0);
        }
    }

    public static RoundedBitmapDrawable create(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new C0620bl(resources, bitmap);
        }
        return new C0142a(resources, bitmap);
    }

    public static RoundedBitmapDrawable create(Resources resources, String str) {
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeFile(str));
        if (create.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + str);
        }
        return create;
    }

    public static RoundedBitmapDrawable create(Resources resources, InputStream inputStream) {
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeStream(inputStream));
        if (create.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return create;
    }
}
