package com.jackhenry.godough.core.accounts;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1492ag;
import com.jackhenry.godough.core.C1494ai;
import java.util.Iterator;

/* renamed from: com.jackhenry.godough.core.accounts.d */
class C1424d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ AccountTransactionsFragment f5852a;

    C1424d(AccountTransactionsFragment accountTransactionsFragment) {
        this.f5852a = accountTransactionsFragment;
    }

    public void onGlobalLayout() {
        this.f5852a.f5823h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int dimensionPixelSize = (int) (((float) this.f5852a.getResources().getDimensionPixelSize(C1492ag.max_balance_width)) - this.f5852a.getResources().getDimension(C1492ag.balance_holder_9_patch_right_padding));
        Iterator it = this.f5852a.f5822g.iterator();
        int i = 0;
        while (it.hasNext()) {
            View view = (View) it.next();
            int width = view.getWidth();
            int i2 = width > i ? width : i;
            if (width > dimensionPixelSize) {
                if (view == this.f5852a.f5824i) {
                    TextView textView = (TextView) this.f5852a.f5823h.findViewById(C1494ai.available_balance_label);
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    layoutParams.width = (int) (((float) (dimensionPixelSize - ((int) (((float) this.f5852a.f5816aj.getWidth()) + this.f5852a.getResources().getDimension(C1492ag.info_icon_margin))))) - (this.f5852a.getResources().getDimension(C1492ag.avail_balance_holder_padding) * 2.0f));
                    textView.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.width = dimensionPixelSize;
                view.setLayoutParams(layoutParams2);
            }
            i = i2;
        }
        View findViewById = this.f5852a.f5823h.findViewById(C1494ai.balance_holder);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        if (i > dimensionPixelSize) {
            i = dimensionPixelSize;
        }
        layoutParams3.width = (int) (((float) i) + this.f5852a.getResources().getDimension(C1492ag.balance_holder_9_patch_right_padding));
        findViewById.setLayoutParams(layoutParams3);
    }
}
