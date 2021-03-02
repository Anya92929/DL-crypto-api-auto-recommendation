package android.support.p000v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.support.p000v4.graphics.BitmapCompat;
import android.support.p000v4.view.GravityCompat;
import android.util.Log;
import java.io.InputStream;

/* renamed from: android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory */
public class RoundedBitmapDrawableFactory {

    /* renamed from: android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable */
    class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1287a(int i, int i2, int i3, Rect rect, Rect rect2) {
            GravityCompat.apply(i, i2, i3, rect, rect2, 0);
        }

        public boolean hasMipMap() {
            return this.f795a != null && BitmapCompat.hasMipMap(this.f795a);
        }

        public void setMipMap(boolean z) {
            if (this.f795a != null) {
                BitmapCompat.setHasMipMap(this.f795a, z);
                invalidateSelf();
            }
        }
    }

    public static RoundedBitmapDrawable create(Resources resources, Bitmap bitmap) {
        return Build.VERSION.SDK_INT >= 21 ? new RoundedBitmapDrawable21(resources, bitmap) : new DefaultRoundedBitmapDrawable(resources, bitmap);
    }

    public static RoundedBitmapDrawable create(Resources resources, InputStream inputStream) {
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeStream(inputStream));
        if (create.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return create;
    }

    public static RoundedBitmapDrawable create(Resources resources, String str) {
        RoundedBitmapDrawable create = create(resources, BitmapFactory.decodeFile(str));
        if (create.getBitmap() == null) {
            Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + str);
        }
        return create;
    }
}
