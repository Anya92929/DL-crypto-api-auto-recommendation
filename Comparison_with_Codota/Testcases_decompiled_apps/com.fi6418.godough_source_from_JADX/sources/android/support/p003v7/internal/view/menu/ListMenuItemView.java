package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p003v7.appcompat.C0235R;
import android.support.p003v7.internal.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* renamed from: android.support.v7.internal.view.menu.ListMenuItemView */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {

    /* renamed from: a */
    private MenuItemImpl f2077a;

    /* renamed from: b */
    private ImageView f2078b;

    /* renamed from: c */
    private RadioButton f2079c;

    /* renamed from: d */
    private TextView f2080d;

    /* renamed from: e */
    private CheckBox f2081e;

    /* renamed from: f */
    private TextView f2082f;

    /* renamed from: g */
    private Drawable f2083g;

    /* renamed from: h */
    private int f2084h;

    /* renamed from: i */
    private Context f2085i;

    /* renamed from: j */
    private boolean f2086j;

    /* renamed from: k */
    private int f2087k;

    /* renamed from: l */
    private Context f2088l;

    /* renamed from: m */
    private LayoutInflater f2089m;

    /* renamed from: n */
    private boolean f2090n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f2088l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0235R.styleable.MenuView, i, 0);
        this.f2083g = obtainStyledAttributes.getDrawable(C0235R.styleable.MenuView_android_itemBackground);
        this.f2084h = obtainStyledAttributes.getResourceId(C0235R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f2086j = obtainStyledAttributes.getBoolean(C0235R.styleable.MenuView_preserveIconSpacing, false);
        this.f2085i = context;
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m1402a() {
        this.f2078b = (ImageView) getInflater().inflate(C0235R.layout.abc_list_menu_item_icon, this, false);
        addView(this.f2078b, 0);
    }

    /* renamed from: b */
    private void m1403b() {
        this.f2079c = (RadioButton) getInflater().inflate(C0235R.layout.abc_list_menu_item_radio, this, false);
        addView(this.f2079c);
    }

    /* renamed from: c */
    private void m1404c() {
        this.f2081e = (CheckBox) getInflater().inflate(C0235R.layout.abc_list_menu_item_checkbox, this, false);
        addView(this.f2081e);
    }

    private LayoutInflater getInflater() {
        if (this.f2089m == null) {
            this.f2089m = LayoutInflater.from(this.f2088l);
        }
        return this.f2089m;
    }

    public MenuItemImpl getItemData() {
        return this.f2077a;
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f2077a = menuItemImpl;
        this.f2087k = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.mo4160a((MenuView.ItemView) this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.mo4166c(), menuItemImpl.mo4159a());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f2083g);
        this.f2080d = (TextView) findViewById(C0235R.C0237id.title);
        if (this.f2084h != -1) {
            this.f2080d.setTextAppearance(this.f2085i, this.f2084h);
        }
        this.f2082f = (TextView) findViewById(C0235R.C0237id.shortcut);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f2078b != null && this.f2086j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2078b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f2079c != null || this.f2081e != null) {
            if (this.f2077a.isExclusiveCheckable()) {
                if (this.f2079c == null) {
                    m1403b();
                }
                compoundButton = this.f2079c;
                compoundButton2 = this.f2081e;
            } else {
                if (this.f2081e == null) {
                    m1404c();
                }
                compoundButton = this.f2081e;
                compoundButton2 = this.f2079c;
            }
            if (z) {
                compoundButton.setChecked(this.f2077a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f2081e != null) {
                this.f2081e.setVisibility(8);
            }
            if (this.f2079c != null) {
                this.f2079c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2077a.isExclusiveCheckable()) {
            if (this.f2079c == null) {
                m1403b();
            }
            compoundButton = this.f2079c;
        } else {
            if (this.f2081e == null) {
                m1404c();
            }
            compoundButton = this.f2081e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f2090n = z;
        this.f2086j = z;
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f2077a.shouldShowIcon() || this.f2090n;
        if (!z && !this.f2086j) {
            return;
        }
        if (this.f2078b != null || drawable != null || this.f2086j) {
            if (this.f2078b == null) {
                m1402a();
            }
            if (drawable != null || this.f2086j) {
                ImageView imageView = this.f2078b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f2078b.getVisibility() != 0) {
                    this.f2078b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f2078b.setVisibility(8);
        }
    }

    public void setShortcut(boolean z, char c) {
        int i = (!z || !this.f2077a.mo4166c()) ? 8 : 0;
        if (i == 0) {
            this.f2082f.setText(this.f2077a.mo4164b());
        }
        if (this.f2082f.getVisibility() != i) {
            this.f2082f.setVisibility(i);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2080d.setText(charSequence);
            if (this.f2080d.getVisibility() != 0) {
                this.f2080d.setVisibility(0);
            }
        } else if (this.f2080d.getVisibility() != 8) {
            this.f2080d.setVisibility(8);
        }
    }

    public boolean showsIcon() {
        return this.f2090n;
    }
}
