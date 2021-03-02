package com.jackhenry.android.widget.quickactionmenu;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.jackhenry.android.p022a.C1358e;
import com.jackhenry.android.p022a.C1359f;
import com.jackhenry.android.p022a.C1360g;
import java.util.ArrayList;
import java.util.List;

public class QuickAction extends PopupWindows implements PopupWindow.OnDismissListener {

    /* renamed from: f */
    private View f5691f;

    /* renamed from: g */
    private ImageView f5692g;

    /* renamed from: h */
    private ImageView f5693h;

    /* renamed from: i */
    private LayoutInflater f5694i;

    /* renamed from: j */
    private ViewGroup f5695j;

    /* renamed from: k */
    private ScrollView f5696k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OnActionItemClickListener f5697l;

    /* renamed from: m */
    private int f5698m;

    /* renamed from: n */
    private int f5699n;

    /* renamed from: o */
    private int f5700o;

    /* renamed from: p */
    private boolean f5701p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f5702q;

    /* renamed from: r */
    private boolean f5703r;

    /* renamed from: s */
    private int f5704s;

    /* renamed from: t */
    private List<ActionItem> f5705t;

    public interface OnActionItemClickListener {
        void onQuickActionClick(QuickAction quickAction, int i, int i2);
    }

    public QuickAction(Context context) {
        this(context, false);
    }

    public QuickAction(Context context, boolean z) {
        super(context);
        this.f5705t = new ArrayList();
        this.f5701p = z;
        this.f5694i = (LayoutInflater) context.getSystemService("layout_inflater");
        if (z) {
            setRootViewId(C1359f.quickaction_popuphoriz);
        } else {
            setRootViewId(C1359f.quickaction_popup);
        }
        this.f5700o = 5;
        this.f5698m = 0;
    }

    /* renamed from: a */
    private void m5610a(int i, int i2) {
        ImageView imageView = i == C1358e.arrow_up ? this.f5692g : this.f5693h;
        ImageView imageView2 = i == C1358e.arrow_up ? this.f5693h : this.f5692g;
        int measuredWidth = this.f5692g.getMeasuredWidth();
        imageView.setVisibility(0);
        ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).leftMargin = i2 - (measuredWidth / 2);
        imageView2.setVisibility(4);
    }

    /* renamed from: a */
    private void m5611a(int i, int i2, boolean z) {
        int measuredWidth = i2 - (this.f5692g.getMeasuredWidth() / 2);
        switch (this.f5700o) {
            case 1:
                this.f5687b.setAnimationStyle(z ? C1360g.Animations_PopUpMenu_Left : C1360g.Animations_PopDownMenu_Left);
                return;
            case 2:
                this.f5687b.setAnimationStyle(z ? C1360g.Animations_PopUpMenu_Right : C1360g.Animations_PopDownMenu_Right);
                return;
            case 3:
                this.f5687b.setAnimationStyle(z ? C1360g.Animations_PopUpMenu_Center : C1360g.Animations_PopDownMenu_Center);
                return;
            case 4:
                this.f5687b.setAnimationStyle(z ? C1360g.Animations_PopUpMenu_Reflect : C1360g.Animations_PopDownMenu_Reflect);
                return;
            case 5:
                if (measuredWidth <= i / 4) {
                    this.f5687b.setAnimationStyle(z ? C1360g.Animations_PopUpMenu_Left : C1360g.Animations_PopDownMenu_Left);
                    return;
                } else if (measuredWidth <= i / 4 || measuredWidth >= (i / 4) * 3) {
                    this.f5687b.setAnimationStyle(z ? C1360g.Animations_PopUpMenu_Right : C1360g.Animations_PopDownMenu_Right);
                    return;
                } else {
                    this.f5687b.setAnimationStyle(z ? C1360g.Animations_PopUpMenu_Center : C1360g.Animations_PopDownMenu_Center);
                    return;
                }
            default:
                return;
        }
    }

    public void addActionItem(ActionItem actionItem) {
        this.f5705t.add(actionItem);
        String title = actionItem.getTitle();
        Drawable icon = actionItem.getIcon();
        View inflate = this.f5701p ? this.f5694i.inflate(C1359f.quickaction_item_horiz, (ViewGroup) null) : this.f5694i.inflate(C1359f.quickaction_item, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(C1358e.iv_icon);
        TextView textView = (TextView) inflate.findViewById(C1358e.tv_title);
        if (icon != null) {
            imageView.setImageDrawable(icon);
        } else {
            imageView.setVisibility(8);
        }
        if (title != null) {
            textView.setText(title);
        } else {
            textView.setVisibility(8);
        }
        inflate.setOnClickListener(new C1372b(this, this.f5698m, actionItem.getActionId()));
        inflate.setFocusable(true);
        inflate.setClickable(true);
        if (this.f5701p && this.f5698m != 0) {
            View inflate2 = this.f5694i.inflate(C1359f.quickaction_horiz_separator, (ViewGroup) null);
            inflate2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
            inflate2.setPadding(5, 0, 5, 0);
            this.f5695j.addView(inflate2, this.f5699n);
            this.f5699n++;
        }
        this.f5695j.addView(inflate, this.f5699n);
        this.f5698m++;
        this.f5699n++;
    }

    public boolean didAction() {
        return this.f5702q;
    }

    public ActionItem getActionItem(int i) {
        return this.f5705t.get(i);
    }

    public void onDismiss() {
        if (this.f5703r && !this.f5702q && this.f5697l != null) {
            this.f5697l.onQuickActionClick(this, -1, this.f5704s);
        }
    }

    public void sendDismissNotification(int i) {
        this.f5703r = true;
        this.f5704s = i;
        setOnDismissListener(this);
    }

    public void setAnimStyle(int i) {
        this.f5700o = i;
    }

    public void setOnActionItemClickListener(OnActionItemClickListener onActionItemClickListener) {
        this.f5697l = onActionItemClickListener;
    }

    public void setRootViewId(int i) {
        this.f5691f = this.f5694i.inflate(i, (ViewGroup) null);
        this.f5695j = (ViewGroup) this.f5691f.findViewById(C1358e.tracks);
        this.f5693h = (ImageView) this.f5691f.findViewById(C1358e.arrow_down);
        this.f5692g = (ImageView) this.f5691f.findViewById(C1358e.arrow_up);
        this.f5696k = (ScrollView) this.f5691f.findViewById(C1358e.scroller);
        this.f5691f.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.f5691f);
    }

    public void show(View view) {
        int i;
        mo9394b();
        this.f5702q = false;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        this.f5691f.measure(-2, -2);
        int measuredHeight = this.f5691f.getMeasuredHeight();
        int measuredWidth = this.f5691f.getMeasuredWidth();
        int width = this.f5690e.getDefaultDisplay().getWidth();
        int height = this.f5690e.getDefaultDisplay().getHeight();
        int width2 = rect.left + measuredWidth > width ? rect.left - (measuredWidth - view.getWidth()) : view.getWidth() > measuredWidth ? rect.centerX() - (measuredWidth / 2) : rect.left;
        int i2 = rect.top;
        int i3 = height - rect.bottom;
        boolean z = i2 > i3;
        if (!z) {
            int i4 = rect.bottom;
            if (measuredHeight > i3) {
                this.f5696k.getLayoutParams().height = i3;
            }
            i = i4;
        } else if (measuredHeight > i2) {
            this.f5696k.getLayoutParams().height = i2 - view.getHeight();
            i = 15;
        } else {
            i = rect.top - measuredHeight;
        }
        m5610a(z ? C1358e.arrow_down : C1358e.arrow_up, rect.centerX() - width2);
        m5611a(width, rect.centerX(), z);
        this.f5687b.showAtLocation(view, 0, width2, i);
    }
}
