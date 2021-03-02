package android.support.p021v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.p023b.C0511g;
import android.support.p021v7.p023b.C0512h;
import android.support.p021v7.p023b.C0515k;
import android.support.p021v7.widget.C0670dn;
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
public class ListMenuItemView extends LinearLayout implements C0541ah {

    /* renamed from: a */
    private C0566s f970a;

    /* renamed from: b */
    private ImageView f971b;

    /* renamed from: c */
    private RadioButton f972c;

    /* renamed from: d */
    private TextView f973d;

    /* renamed from: e */
    private CheckBox f974e;

    /* renamed from: f */
    private TextView f975f;

    /* renamed from: g */
    private ImageView f976g;

    /* renamed from: h */
    private Drawable f977h;

    /* renamed from: i */
    private int f978i;

    /* renamed from: j */
    private Context f979j;

    /* renamed from: k */
    private boolean f980k;

    /* renamed from: l */
    private Drawable f981l;

    /* renamed from: m */
    private int f982m;

    /* renamed from: n */
    private LayoutInflater f983n;

    /* renamed from: o */
    private boolean f984o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0506b.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C0670dn a = C0670dn.m3014a(getContext(), attributeSet, C0515k.MenuView, i, 0);
        this.f977h = a.mo3318a(C0515k.MenuView_android_itemBackground);
        this.f978i = a.mo3331g(C0515k.MenuView_android_itemTextAppearance, -1);
        this.f980k = a.mo3320a(C0515k.MenuView_preserveIconSpacing, false);
        this.f979j = context;
        this.f981l = a.mo3318a(C0515k.MenuView_subMenuArrow);
        a.mo3319a();
    }

    /* renamed from: b */
    private void m2276b() {
        this.f971b = (ImageView) getInflater().inflate(C0512h.abc_list_menu_item_icon, this, false);
        addView(this.f971b, 0);
    }

    /* renamed from: c */
    private void m2277c() {
        this.f972c = (RadioButton) getInflater().inflate(C0512h.abc_list_menu_item_radio, this, false);
        addView(this.f972c);
    }

    /* renamed from: d */
    private void m2278d() {
        this.f974e = (CheckBox) getInflater().inflate(C0512h.abc_list_menu_item_checkbox, this, false);
        addView(this.f974e);
    }

    private LayoutInflater getInflater() {
        if (this.f983n == null) {
            this.f983n = LayoutInflater.from(getContext());
        }
        return this.f983n;
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f976g != null) {
            this.f976g.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    public void mo2238a(C0566s sVar, int i) {
        this.f970a = sVar;
        this.f982m = i;
        setVisibility(sVar.isVisible() ? 0 : 8);
        setTitle(sVar.mo2509a((C0541ah) this));
        setCheckable(sVar.isCheckable());
        mo2262a(sVar.mo2522f(), sVar.mo2518d());
        setIcon(sVar.getIcon());
        setEnabled(sVar.isEnabled());
        setSubMenuArrowVisible(sVar.hasSubMenu());
    }

    /* renamed from: a */
    public void mo2262a(boolean z, char c) {
        int i = (!z || !this.f970a.mo2522f()) ? 8 : 0;
        if (i == 0) {
            this.f975f.setText(this.f970a.mo2520e());
        }
        if (this.f975f.getVisibility() != i) {
            this.f975f.setVisibility(i);
        }
    }

    /* renamed from: a */
    public boolean mo2239a() {
        return false;
    }

    public C0566s getItemData() {
        return this.f970a;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f977h);
        this.f973d = (TextView) findViewById(C0511g.title);
        if (this.f978i != -1) {
            this.f973d.setTextAppearance(this.f979j, this.f978i);
        }
        this.f975f = (TextView) findViewById(C0511g.shortcut);
        this.f976g = (ImageView) findViewById(C0511g.submenuarrow);
        if (this.f976g != null) {
            this.f976g.setImageDrawable(this.f981l);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f971b != null && this.f980k) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f971b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f972c != null || this.f974e != null) {
            if (this.f970a.mo2523g()) {
                if (this.f972c == null) {
                    m2277c();
                }
                compoundButton = this.f972c;
                compoundButton2 = this.f974e;
            } else {
                if (this.f974e == null) {
                    m2278d();
                }
                compoundButton = this.f974e;
                compoundButton2 = this.f972c;
            }
            if (z) {
                compoundButton.setChecked(this.f970a.isChecked());
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
            if (this.f974e != null) {
                this.f974e.setVisibility(8);
            }
            if (this.f972c != null) {
                this.f972c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f970a.mo2523g()) {
            if (this.f972c == null) {
                m2277c();
            }
            compoundButton = this.f972c;
        } else {
            if (this.f974e == null) {
                m2278d();
            }
            compoundButton = this.f974e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f984o = z;
        this.f980k = z;
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f970a.mo2538i() || this.f984o;
        if (!z && !this.f980k) {
            return;
        }
        if (this.f971b != null || drawable != null || this.f980k) {
            if (this.f971b == null) {
                m2276b();
            }
            if (drawable != null || this.f980k) {
                ImageView imageView = this.f971b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f971b.getVisibility() != 0) {
                    this.f971b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f971b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f973d.setText(charSequence);
            if (this.f973d.getVisibility() != 0) {
                this.f973d.setVisibility(0);
            }
        } else if (this.f973d.getVisibility() != 8) {
            this.f973d.setVisibility(8);
        }
    }
}
