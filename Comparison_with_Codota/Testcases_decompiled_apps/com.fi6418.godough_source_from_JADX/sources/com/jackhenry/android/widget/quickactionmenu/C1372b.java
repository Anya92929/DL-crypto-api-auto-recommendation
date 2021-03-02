package com.jackhenry.android.widget.quickactionmenu;

import android.view.View;

/* renamed from: com.jackhenry.android.widget.quickactionmenu.b */
class C1372b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f5707a;

    /* renamed from: b */
    final /* synthetic */ int f5708b;

    /* renamed from: c */
    final /* synthetic */ QuickAction f5709c;

    C1372b(QuickAction quickAction, int i, int i2) {
        this.f5709c = quickAction;
        this.f5707a = i;
        this.f5708b = i2;
    }

    public void onClick(View view) {
        if (this.f5709c.f5697l != null) {
            this.f5709c.f5697l.onQuickActionClick(this.f5709c, this.f5707a, this.f5708b);
        }
        if (!this.f5709c.getActionItem(this.f5707a).isSticky()) {
            boolean unused = this.f5709c.f5702q = true;
            this.f5709c.dismiss();
        }
    }
}
