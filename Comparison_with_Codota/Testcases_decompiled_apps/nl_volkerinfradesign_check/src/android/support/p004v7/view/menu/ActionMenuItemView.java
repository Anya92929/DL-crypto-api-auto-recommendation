package android.support.p004v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p001v4.view.ViewCompat;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.menu.MenuBuilder;
import android.support.p004v7.view.menu.MenuView;
import android.support.p004v7.widget.ActionMenuView;
import android.support.p004v7.widget.AppCompatTextView;
import android.support.p004v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/* renamed from: android.support.v7.view.menu.ActionMenuItemView */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, ActionMenuView.ActionMenuChildView, View.OnClickListener, View.OnLongClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MenuItemImpl f1707a;

    /* renamed from: b */
    private CharSequence f1708b;

    /* renamed from: c */
    private Drawable f1709c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MenuBuilder.ItemInvoker f1710d;

    /* renamed from: e */
    private ListPopupWindow.ForwardingListener f1711e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PopupCallback f1712f;

    /* renamed from: g */
    private boolean f1713g;

    /* renamed from: h */
    private boolean f1714h;

    /* renamed from: i */
    private int f1715i;

    /* renamed from: j */
    private int f1716j;

    /* renamed from: k */
    private int f1717k;

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$PopupCallback */
    public static abstract class PopupCallback {
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
        this.f1713g = resources.getBoolean(C0505R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.ActionMenuItemView, i, 0);
        this.f1715i = obtainStyledAttributes.getDimensionPixelSize(C0505R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1717k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f1716j = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f1713g = getContext().getResources().getBoolean(C0505R.bool.abc_config_allowActionMenuItemTextWithIcon);
        m3021a();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1716j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public MenuItemImpl getItemData() {
        return this.f1707a;
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f1707a = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.mo3738a((MenuView.ItemView) this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f1711e == null) {
            this.f1711e = new C0511a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f1707a.hasSubMenu() || this.f1711e == null || !this.f1711e.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onClick(View view) {
        if (this.f1710d != null) {
            this.f1710d.invokeItem(this.f1707a);
        }
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f1710d = itemInvoker;
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f1712f = popupCallback;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1714h != z) {
            this.f1714h = z;
            if (this.f1707a != null) {
                this.f1707a.actionFormatChanged();
            }
        }
    }

    /* renamed from: a */
    private void m3021a() {
        boolean z = false;
        boolean z2 = !TextUtils.isEmpty(this.f1708b);
        if (this.f1709c == null || (this.f1707a.showsTextAsAction() && (this.f1713g || this.f1714h))) {
            z = true;
        }
        setText(z2 & z ? this.f1708b : null);
    }

    public void setIcon(Drawable drawable) {
        this.f1709c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1717k) {
                float f = ((float) this.f1717k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1717k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1717k) {
                float f2 = ((float) this.f1717k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1717k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        m3021a();
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f1708b = charSequence;
        setContentDescription(this.f1708b);
        m3021a();
    }

    public boolean showsIcon() {
        return true;
    }

    public boolean needsDividerBefore() {
        return hasText() && this.f1707a.getIcon() == null;
    }

    public boolean needsDividerAfter() {
        return hasText();
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
        Toast makeText = Toast.makeText(context, this.f1707a.getTitle(), 0);
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
        if (hasText && this.f1716j >= 0) {
            super.setPadding(this.f1716j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f1715i) : this.f1715i;
        if (mode != 1073741824 && this.f1715i > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!hasText && this.f1709c != null) {
            super.setPadding((getMeasuredWidth() - this.f1709c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView$a */
    class C0511a extends ListPopupWindow.ForwardingListener {
        public C0511a() {
            super(ActionMenuItemView.this);
        }

        public ListPopupWindow getPopup() {
            if (ActionMenuItemView.this.f1712f != null) {
                return ActionMenuItemView.this.f1712f.getPopup();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean onForwardingStarted() {
            ListPopupWindow popup;
            if (ActionMenuItemView.this.f1710d == null || !ActionMenuItemView.this.f1710d.invokeItem(ActionMenuItemView.this.f1707a) || (popup = getPopup()) == null || !popup.isShowing()) {
                return false;
            }
            return true;
        }
    }
}
