package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.C0005f;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.app.ActionBar;
import android.support.p003v7.internal.widget.TintManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/* renamed from: android.support.design.widget.ap */
class C0024ap extends LinearLayout implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ TabLayout f148a;

    /* renamed from: b */
    private final C0022an f149b;

    /* renamed from: c */
    private TextView f150c;

    /* renamed from: d */
    private ImageView f151d;

    /* renamed from: e */
    private View f152e;

    /* renamed from: f */
    private TextView f153f;

    /* renamed from: g */
    private ImageView f154g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0024ap(TabLayout tabLayout, Context context, C0022an anVar) {
        super(context);
        this.f148a = tabLayout;
        this.f149b = anVar;
        if (tabLayout.f96j != 0) {
            setBackgroundDrawable(TintManager.getDrawable(context, tabLayout.f96j));
        }
        ViewCompat.setPaddingRelative(this, tabLayout.f90d, tabLayout.f91e, tabLayout.f92f, tabLayout.f93g);
        setGravity(17);
        mo215a();
    }

    /* renamed from: a */
    private void m216a(C0022an anVar, TextView textView, ImageView imageView) {
        Drawable b = anVar.mo207b();
        CharSequence d = anVar.mo209d();
        if (imageView != null) {
            if (b != null) {
                imageView.setImageDrawable(b);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable((Drawable) null);
            }
            imageView.setContentDescription(anVar.mo211f());
        }
        boolean z = !TextUtils.isEmpty(d);
        if (textView != null) {
            if (z) {
                textView.setText(d);
                textView.setContentDescription(anVar.mo211f());
                textView.setVisibility(0);
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText((CharSequence) null);
            }
        }
        if (z || TextUtils.isEmpty(anVar.mo211f())) {
            setOnLongClickListener((View.OnLongClickListener) null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo215a() {
        C0022an anVar = this.f149b;
        View a = anVar.mo205a();
        if (a != null) {
            ViewParent parent = a.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(a);
                }
                addView(a);
            }
            this.f152e = a;
            if (this.f150c != null) {
                this.f150c.setVisibility(8);
            }
            if (this.f151d != null) {
                this.f151d.setVisibility(8);
                this.f151d.setImageDrawable((Drawable) null);
            }
            this.f153f = (TextView) a.findViewById(16908308);
            this.f154g = (ImageView) a.findViewById(16908294);
        } else {
            if (this.f152e != null) {
                removeView(this.f152e);
                this.f152e = null;
            }
            this.f153f = null;
            this.f154g = null;
        }
        if (this.f152e == null) {
            if (this.f151d == null) {
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(C0005f.design_layout_tab_icon, this, false);
                addView(imageView, 0);
                this.f151d = imageView;
            }
            if (this.f150c == null) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0005f.design_layout_tab_text, this, false);
                addView(textView);
                this.f150c = textView;
            }
            this.f150c.setTextAppearance(getContext(), this.f148a.f94h);
            if (this.f148a.f95i != null) {
                this.f150c.setTextColor(this.f148a.f95i);
            }
            m216a(anVar, this.f150c, this.f151d);
        } else if (this.f153f != null || this.f154g != null) {
            m216a(anVar, this.f153f, this.f154g);
        }
    }

    /* renamed from: b */
    public C0022an mo216b() {
        return this.f149b;
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }

    public boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.f149b.mo211f(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth < this.f148a.f97k || measuredWidth > this.f148a.f98l) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(C0068p.m357a(measuredWidth, this.f148a.f97k, this.f148a.f98l), 1073741824), i2);
        }
    }

    public void setSelected(boolean z) {
        boolean z2 = isSelected() != z;
        super.setSelected(z);
        if (z2 && z) {
            sendAccessibilityEvent(4);
            if (this.f150c != null) {
                this.f150c.setSelected(z);
            }
            if (this.f151d != null) {
                this.f151d.setSelected(z);
            }
        }
    }
}
