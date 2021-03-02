package p000;

import android.graphics.drawable.Drawable;
import android.support.p004v7.widget.TintManager;
import android.support.p004v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: gt */
public class C1176gt extends C1175gs {

    /* renamed from: b */
    private static final int[] f4188b = {16843074};

    /* renamed from: c */
    private final SeekBar f4189c;

    public C1176gt(SeekBar seekBar, TintManager tintManager) {
        super(seekBar, tintManager);
        this.f4189c = seekBar;
    }

    /* renamed from: a */
    public void mo8201a(AttributeSet attributeSet, int i) {
        super.mo8201a(attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f4189c.getContext(), attributeSet, f4188b, i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            this.f4189c.setThumb(drawableIfKnown);
        }
        obtainStyledAttributes.recycle();
    }
}
