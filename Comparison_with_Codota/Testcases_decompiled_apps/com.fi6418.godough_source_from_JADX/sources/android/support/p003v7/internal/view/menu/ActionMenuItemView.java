package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuView;
import android.support.p003v7.widget.ActionMenuView;
import android.support.p003v7.widget.AppCompatTextView;
import android.support.p003v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/* renamed from: android.support.v7.internal.view.menu.ActionMenuItemView */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, ActionMenuView.ActionMenuChildView, View.OnClickListener, View.OnLongClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MenuItemImpl f2048a;

    /* renamed from: b */
    private CharSequence f2049b;

    /* renamed from: c */
    private Drawable f2050c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MenuBuilder.ItemInvoker f2051d;

    /* renamed from: e */
    private ListPopupWindow.ForwardingListener f2052e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PopupCallback f2053f;

    /* renamed from: g */
    private boolean f2054g;

    /* renamed from: h */
    private boolean f2055h;

    /* renamed from: i */
    private int f2056i;

    /* renamed from: j */
    private int f2057j;

    /* renamed from: k */
    private int f2058k;

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuItemView$ActionMenuItemForwardingListener */
    class ActionMenuItemForwardingListener extends ListPopupWindow.ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        public ListPopupWindow getPopup() {
            if (ActionMenuItemView.this.f2053f != null) {
                return ActionMenuItemView.this.f2053f.getPopup();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
            r1 = getPopup();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onForwardingStarted() {
            /*
                r3 = this;
                r0 = 0
                android.support.v7.internal.view.menu.ActionMenuItemView r1 = android.support.p003v7.internal.view.menu.ActionMenuItemView.this
                android.support.v7.internal.view.menu.MenuBuilder$ItemInvoker r1 = r1.f2051d
                if (r1 == 0) goto L_0x0028
                android.support.v7.internal.view.menu.ActionMenuItemView r1 = android.support.p003v7.internal.view.menu.ActionMenuItemView.this
                android.support.v7.internal.view.menu.MenuBuilder$ItemInvoker r1 = r1.f2051d
                android.support.v7.internal.view.menu.ActionMenuItemView r2 = android.support.p003v7.internal.view.menu.ActionMenuItemView.this
                android.support.v7.internal.view.menu.MenuItemImpl r2 = r2.f2048a
                boolean r1 = r1.invokeItem(r2)
                if (r1 == 0) goto L_0x0028
                android.support.v7.widget.ListPopupWindow r1 = r3.getPopup()
                if (r1 == 0) goto L_0x0028
                boolean r1 = r1.isShowing()
                if (r1 == 0) goto L_0x0028
                r0 = 1
            L_0x0028:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p003v7.internal.view.menu.ActionMenuItemView.ActionMenuItemForwardingListener.onForwardingStarted():boolean");
        }
    }

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuItemView$PopupCallback */
    public abstract class PopupCallback {
        public abstract ListPopupWindow getPopup();
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f2054g = resources.getBoolean(C0235R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0235R.styleable.ActionMenuItemView, i, 0);
        this.f2056i = obtainStyledAttributes.getDimensionPixelSize(C0235R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f2058k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f2057j = -1;
    }

    /* renamed from: a */
    private void m1393a() {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(this.f2049b);
        if (this.f2050c == null || (this.f2048a.showsTextAsAction() && (this.f2054g || this.f2055h))) {
            z = true;
        }
        setText(z2 & z ? this.f2049b : null);
    }

    public MenuItemImpl getItemData() {
        return this.f2048a;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f2048a = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.mo4160a((MenuView.ItemView) this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f2052e == null) {
            this.f2052e = new ActionMenuItemForwardingListener();
        }
    }

    public boolean needsDividerAfter() {
        return hasText();
    }

    public boolean needsDividerBefore() {
        return hasText() && this.f2048a.getIcon() == null;
    }

    public void onClick(View view) {
        if (this.f2051d != null) {
            this.f2051d.invokeItem(this.f2048a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f2054g = getContext().getResources().getBoolean(C0235R.bool.abc_config_allowActionMenuItemTextWithIcon);
        m1393a();
    }

    public boolean onLongClick(View view) {
        if (hasText()) {
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
        if (ViewCompat.getLayoutDirection(view) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        Toast makeText = Toast.makeText(context, this.f2048a.getTitle(), 0);
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
        boolean hasText = hasText();
        if (hasText && this.f2057j >= 0) {
            super.setPadding(this.f2057j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f2056i) : this.f2056i;
        if (mode != 1073741824 && this.f2056i > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!hasText && this.f2050c != null) {
            super.setPadding((getMeasuredWidth() - this.f2050c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f2048a.hasSubMenu() || this.f2052e == null || !this.f2052e.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f2055h != z) {
            this.f2055h = z;
            if (this.f2048a != null) {
                this.f2048a.actionFormatChanged();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2050c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f2058k) {
                float f = ((float) this.f2058k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f2058k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f2058k) {
                float f2 = ((float) this.f2058k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f2058k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        m1393a();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f2051d = itemInvoker;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f2057j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f2053f = popupCallback;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f2049b = charSequence;
        setContentDescription(this.f2049b);
        m1393a();
    }

    public boolean showsIcon() {
        return true;
    }
}
