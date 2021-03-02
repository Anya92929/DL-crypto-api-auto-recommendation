package com.jackhenry.godough.core.locations;

import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.p032a.C1408a;

/* renamed from: com.jackhenry.godough.core.locations.h */
class C1609h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Button f6243a;

    /* renamed from: b */
    final /* synthetic */ LocationDetailFragment f6244b;

    C1609h(LocationDetailFragment locationDetailFragment, Button button) {
        this.f6244b = locationDetailFragment;
        this.f6243a = button;
    }

    public void onClick(View view) {
        String string;
        C1408a aVar;
        if (this.f6244b.f6183ak.getHeight() > 0) {
            string = this.f6244b.getResources().getString(C1506am.lbl_show_map);
            aVar = new C1408a(this.f6244b.f6183ak, 0, 0);
        } else {
            string = this.f6244b.getResources().getString(C1506am.lbl_hide_map);
            aVar = new C1408a(this.f6244b.f6183ak, 0, (int) TypedValue.applyDimension(1, 250.0f, this.f6244b.getResources().getDisplayMetrics()));
        }
        aVar.setAnimationListener(new C1610i(this, string));
        this.f6244b.f6183ak.startAnimation(aVar);
    }
}
