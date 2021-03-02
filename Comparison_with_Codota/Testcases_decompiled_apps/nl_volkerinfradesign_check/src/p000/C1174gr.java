package p000;

import android.graphics.drawable.Drawable;
import android.support.p001v4.content.ContextCompat;
import android.support.p004v7.widget.TintManager;
import android.support.p004v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: gr */
public class C1174gr {

    /* renamed from: a */
    private static final int[] f4181a = {16843033};

    /* renamed from: b */
    private final ImageView f4182b;

    /* renamed from: c */
    private final TintManager f4183c;

    public C1174gr(ImageView imageView, TintManager tintManager) {
        this.f4182b = imageView;
        this.f4183c = tintManager;
    }

    /* renamed from: a */
    public void mo8199a(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f4182b.getContext(), attributeSet, f4181a, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                this.f4182b.setImageDrawable(obtainStyledAttributes.getDrawable(0));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    public void mo8198a(int i) {
        if (i != 0) {
            this.f4182b.setImageDrawable(this.f4183c != null ? this.f4183c.getDrawable(i) : ContextCompat.getDrawable(this.f4182b.getContext(), i));
        } else {
            this.f4182b.setImageDrawable((Drawable) null);
        }
    }
}
