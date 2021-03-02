package android.support.p004v7.widget;

import android.content.Context;
import android.support.p004v7.appcompat.C0505R;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.AppCompatSeekBar */
public class AppCompatSeekBar extends SeekBar {

    /* renamed from: a */
    private C1176gt f2034a;

    /* renamed from: b */
    private TintManager f2035b;

    public AppCompatSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0505R.attr.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2035b = TintManager.get(context);
        this.f2034a = new C1176gt(this, this.f2035b);
        this.f2034a.mo8201a(attributeSet, i);
    }
}
