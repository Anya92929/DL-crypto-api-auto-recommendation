package org.commonwealthcu.mobile;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.p000v4.view.PagerAdapter;
import android.support.p000v4.view.ViewPager;
import android.support.p003v7.appcompat.C0137R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* renamed from: org.commonwealthcu.mobile.c */
final class C0624c extends PagerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0578a f839a;

    private C0624c(C0578a aVar) {
        this.f839a = aVar;
    }

    /* synthetic */ C0624c(C0578a aVar, byte b) {
        this(aVar);
    }

    public final void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    public final void finishUpdate(View view) {
    }

    public final int getCount() {
        return this.f839a.f693g;
    }

    public final Object instantiateItem(View view, int i) {
        int i2 = i + 1;
        View inflate = ((LayoutInflater) view.getContext().getSystemService("layout_inflater")).inflate(C0137R.layout.adimage, (ViewGroup) null);
        String a = this.f839a.f689c.mo5460a("IMG" + i2 + "_Link");
        String a2 = this.f839a.f689c.mo5460a("IMG" + i2);
        String a3 = this.f839a.f689c.mo5460a("AdPopupTitle");
        String a4 = this.f839a.f689c.mo5460a("AdPopupMessage");
        if (a2 != null) {
            if (a2.indexOf(32) >= 0) {
                a2 = a2.replace(" ", "%20");
            }
            ((ImageView) inflate).setImageDrawable(Drawable.createFromPath(this.f839a.f690d.getFileStreamPath(a2).toString()));
            if (a != null) {
                inflate.setOnClickListener(new C0625d(this, a3, a4, a));
            }
        }
        ((ViewPager) view).addView(inflate, 0);
        return inflate;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }

    public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public final Parcelable saveState() {
        return null;
    }

    public final void startUpdate(View view) {
    }
}
