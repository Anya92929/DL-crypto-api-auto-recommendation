package android.support.p004v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p004v7.appcompat.C0505R;
import android.support.p004v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* renamed from: android.support.v7.view.menu.ListMenuItemView */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {

    /* renamed from: a */
    private MenuItemImpl f1726a;

    /* renamed from: b */
    private ImageView f1727b;

    /* renamed from: c */
    private RadioButton f1728c;

    /* renamed from: d */
    private TextView f1729d;

    /* renamed from: e */
    private CheckBox f1730e;

    /* renamed from: f */
    private TextView f1731f;

    /* renamed from: g */
    private Drawable f1732g;

    /* renamed from: h */
    private int f1733h;

    /* renamed from: i */
    private Context f1734i;

    /* renamed from: j */
    private boolean f1735j;

    /* renamed from: k */
    private int f1736k;

    /* renamed from: l */
    private Context f1737l;

    /* renamed from: m */
    private LayoutInflater f1738m;

    /* renamed from: n */
    private boolean f1739n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1737l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0505R.styleable.MenuView, i, 0);
        this.f1732g = obtainStyledAttributes.getDrawable(C0505R.styleable.MenuView_android_itemBackground);
        this.f1733h = obtainStyledAttributes.getResourceId(C0505R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f1735j = obtainStyledAttributes.getBoolean(C0505R.styleable.MenuView_preserveIconSpacing, false);
        this.f1734i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f1732g);
        this.f1729d = (TextView) findViewById(C0505R.C0507id.title);
        if (this.f1733h != -1) {
            this.f1729d.setTextAppearance(this.f1734i, this.f1733h);
        }
        this.f1731f = (TextView) findViewById(C0505R.C0507id.shortcut);
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.f1726a = menuItemImpl;
        this.f1736k = i;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setTitle(menuItemImpl.mo3738a((MenuView.ItemView) this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.mo3744c(), menuItemImpl.mo3737a());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.f1739n = z;
        this.f1735j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1729d.setText(charSequence);
            if (this.f1729d.getVisibility() != 0) {
                this.f1729d.setVisibility(0);
            }
        } else if (this.f1729d.getVisibility() != 8) {
            this.f1729d.setVisibility(8);
        }
    }

    public MenuItemImpl getItemData() {
        return this.f1726a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        int i;
        if (z || this.f1728c != null || this.f1730e != null) {
            if (this.f1726a.isExclusiveCheckable()) {
                if (this.f1728c == null) {
                    m3025b();
                }
                compoundButton = this.f1728c;
                compoundButton2 = this.f1730e;
            } else {
                if (this.f1730e == null) {
                    m3026c();
                }
                compoundButton = this.f1730e;
                compoundButton2 = this.f1728c;
            }
            if (z) {
                compoundButton.setChecked(this.f1726a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1730e != null) {
                this.f1730e.setVisibility(8);
            }
            if (this.f1728c != null) {
                this.f1728c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1726a.isExclusiveCheckable()) {
            if (this.f1728c == null) {
                m3025b();
            }
            compoundButton = this.f1728c;
        } else {
            if (this.f1730e == null) {
                m3026c();
            }
            compoundButton = this.f1730e;
        }
        compoundButton.setChecked(z);
    }

    public void setShortcut(boolean z, char c) {
        int i = (!z || !this.f1726a.mo3744c()) ? 8 : 0;
        if (i == 0) {
            this.f1731f.setText(this.f1726a.mo3742b());
        }
        if (this.f1731f.getVisibility() != i) {
            this.f1731f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f1726a.shouldShowIcon() || this.f1739n;
        if (!z && !this.f1735j) {
            return;
        }
        if (this.f1727b != null || drawable != null || this.f1735j) {
            if (this.f1727b == null) {
                m3024a();
            }
            if (drawable != null || this.f1735j) {
                ImageView imageView = this.f1727b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1727b.getVisibility() != 0) {
                    this.f1727b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1727b.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f1727b != null && this.f1735j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1727b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    private void m3024a() {
        this.f1727b = (ImageView) getInflater().inflate(C0505R.layout.abc_list_menu_item_icon, this, false);
        addView(this.f1727b, 0);
    }

    /* renamed from: b */
    private void m3025b() {
        this.f1728c = (RadioButton) getInflater().inflate(C0505R.layout.abc_list_menu_item_radio, this, false);
        addView(this.f1728c);
    }

    /* renamed from: c */
    private void m3026c() {
        this.f1730e = (CheckBox) getInflater().inflate(C0505R.layout.abc_list_menu_item_checkbox, this, false);
        addView(this.f1730e);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public boolean showsIcon() {
        return this.f1739n;
    }

    private LayoutInflater getInflater() {
        if (this.f1738m == null) {
            this.f1738m = LayoutInflater.from(this.f1737l);
        }
        return this.f1738m;
    }
}
