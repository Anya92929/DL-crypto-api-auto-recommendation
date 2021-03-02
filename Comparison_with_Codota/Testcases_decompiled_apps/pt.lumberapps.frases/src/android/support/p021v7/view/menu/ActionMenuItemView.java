package android.support.p021v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p009v4.p010a.p011a.C0026a;
import android.support.p009v4.view.C0247by;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.widget.C0619bq;
import android.support.p021v7.widget.C0628bz;
import android.support.p021v7.widget.C0699u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/* renamed from: android.support.v7.view.menu.ActionMenuItemView */
public class ActionMenuItemView extends C0619bq implements C0541ah, C0699u, View.OnClickListener, View.OnLongClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C0566s f956a;

    /* renamed from: b */
    private CharSequence f957b;

    /* renamed from: c */
    private Drawable f958c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0564q f959d;

    /* renamed from: e */
    private C0628bz f960e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0550c f961f;

    /* renamed from: g */
    private boolean f962g;

    /* renamed from: h */
    private boolean f963h;

    /* renamed from: i */
    private int f964i;

    /* renamed from: j */
    private int f965j;

    /* renamed from: k */
    private int f966k;

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f962g = m2267e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0515k.ActionMenuItemView, i, 0);
        this.f964i = obtainStyledAttributes.getDimensionPixelSize(C0515k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f966k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f965j = -1;
    }

    /* renamed from: e */
    private boolean m2267e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int b = C0026a.m124b(getResources());
        return b >= 480 || (b >= 640 && C0026a.m123a(getResources()) >= 480) || configuration.orientation == 2;
    }

    /* renamed from: f */
    private void m2268f() {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(this.f957b);
        if (this.f958c == null || (this.f956a.mo2546m() && (this.f962g || this.f963h))) {
            z = true;
        }
        setText(z2 & z ? this.f957b : null);
    }

    /* renamed from: a */
    public void mo2238a(C0566s sVar, int i) {
        this.f956a = sVar;
        setIcon(sVar.getIcon());
        setTitle(sVar.mo2509a((C0541ah) this));
        setId(sVar.getItemId());
        setVisibility(sVar.isVisible() ? 0 : 8);
        setEnabled(sVar.isEnabled());
        if (sVar.hasSubMenu() && this.f960e == null) {
            this.f960e = new C0549b(this);
        }
    }

    /* renamed from: a */
    public boolean mo2239a() {
        return true;
    }

    /* renamed from: b */
    public boolean mo2240b() {
        return !TextUtils.isEmpty(getText());
    }

    /* renamed from: c */
    public boolean mo2241c() {
        return mo2240b() && this.f956a.getIcon() == null;
    }

    /* renamed from: d */
    public boolean mo2242d() {
        return mo2240b();
    }

    public C0566s getItemData() {
        return this.f956a;
    }

    public void onClick(View view) {
        if (this.f959d != null) {
            this.f959d.mo2258a(this.f956a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f962g = m2267e();
        m2268f();
    }

    public boolean onLongClick(View view) {
        if (mo2240b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = (width / 2) + iArr[0];
        if (C0247by.m909d(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast makeText = Toast.makeText(context, this.f956a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, i2, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean b = mo2240b();
        if (b && this.f965j >= 0) {
            super.setPadding(this.f965j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f964i) : this.f964i;
        if (mode != 1073741824 && this.f964i > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!b && this.f958c != null) {
            super.setPadding((getMeasuredWidth() - this.f958c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f956a.hasSubMenu() || this.f960e == null || !this.f960e.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f963h != z) {
            this.f963h = z;
            if (this.f956a != null) {
                this.f956a.mo2536h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f958c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f966k) {
                float f = ((float) this.f966k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f966k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f966k) {
                float f2 = ((float) this.f966k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f966k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        m2268f();
    }

    public void setItemInvoker(C0564q qVar) {
        this.f959d = qVar;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f965j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0550c cVar) {
        this.f961f = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f957b = charSequence;
        setContentDescription(this.f957b);
        m2268f();
    }
}
