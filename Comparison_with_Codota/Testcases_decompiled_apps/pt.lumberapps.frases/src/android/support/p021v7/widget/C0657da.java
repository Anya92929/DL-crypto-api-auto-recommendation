package android.support.p021v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p021v7.p022a.C0482d;
import android.support.p021v7.p023b.C0506b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* renamed from: android.support.v7.widget.da */
class C0657da extends C0634ce implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ C0652cw f1603a;

    /* renamed from: b */
    private final int[] f1604b = {16842964};

    /* renamed from: c */
    private C0482d f1605c;

    /* renamed from: d */
    private TextView f1606d;

    /* renamed from: e */
    private ImageView f1607e;

    /* renamed from: f */
    private View f1608f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0657da(C0652cw cwVar, Context context, C0482d dVar, boolean z) {
        super(context, (AttributeSet) null, C0506b.actionBarTabStyle);
        this.f1603a = cwVar;
        this.f1605c = dVar;
        C0670dn a = C0670dn.m3014a(context, (AttributeSet) null, this.f1604b, C0506b.actionBarTabStyle, 0);
        if (a.mo3332g(0)) {
            setBackgroundDrawable(a.mo3318a(0));
        }
        a.mo3319a();
        if (z) {
            setGravity(8388627);
        }
        mo3292a();
    }

    /* renamed from: a */
    public void mo3292a() {
        C0482d dVar = this.f1605c;
        View c = dVar.mo2106c();
        if (c != null) {
            ViewParent parent = c.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(c);
                }
                addView(c);
            }
            this.f1608f = c;
            if (this.f1606d != null) {
                this.f1606d.setVisibility(8);
            }
            if (this.f1607e != null) {
                this.f1607e.setVisibility(8);
                this.f1607e.setImageDrawable((Drawable) null);
                return;
            }
            return;
        }
        if (this.f1608f != null) {
            removeView(this.f1608f);
            this.f1608f = null;
        }
        Drawable a = dVar.mo2104a();
        CharSequence b = dVar.mo2105b();
        if (a != null) {
            if (this.f1607e == null) {
                ImageView imageView = new ImageView(getContext());
                C0635cf cfVar = new C0635cf(-2, -2);
                cfVar.f1521h = 16;
                imageView.setLayoutParams(cfVar);
                addView(imageView, 0);
                this.f1607e = imageView;
            }
            this.f1607e.setImageDrawable(a);
            this.f1607e.setVisibility(0);
        } else if (this.f1607e != null) {
            this.f1607e.setVisibility(8);
            this.f1607e.setImageDrawable((Drawable) null);
        }
        boolean z = !TextUtils.isEmpty(b);
        if (z) {
            if (this.f1606d == null) {
                C0619bq bqVar = new C0619bq(getContext(), (AttributeSet) null, C0506b.actionBarTabTextStyle);
                bqVar.setEllipsize(TextUtils.TruncateAt.END);
                C0635cf cfVar2 = new C0635cf(-2, -2);
                cfVar2.f1521h = 16;
                bqVar.setLayoutParams(cfVar2);
                addView(bqVar);
                this.f1606d = bqVar;
            }
            this.f1606d.setText(b);
            this.f1606d.setVisibility(0);
        } else if (this.f1606d != null) {
            this.f1606d.setVisibility(8);
            this.f1606d.setText((CharSequence) null);
        }
        if (this.f1607e != null) {
            this.f1607e.setContentDescription(dVar.mo2108e());
        }
        if (z || TextUtils.isEmpty(dVar.mo2108e())) {
            setOnLongClickListener((View.OnLongClickListener) null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    /* renamed from: a */
    public void mo3293a(C0482d dVar) {
        this.f1605c = dVar;
        mo3292a();
    }

    /* renamed from: b */
    public C0482d mo3294b() {
        return this.f1605c;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(C0482d.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(C0482d.class.getName());
        }
    }

    public boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.f1605c.mo2108e(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1603a.f1591b > 0 && getMeasuredWidth() > this.f1603a.f1591b) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f1603a.f1591b, 1073741824), i2);
        }
    }

    public void setSelected(boolean z) {
        boolean z2 = isSelected() != z;
        super.setSelected(z);
        if (z2 && z) {
            sendAccessibilityEvent(4);
        }
    }
}
