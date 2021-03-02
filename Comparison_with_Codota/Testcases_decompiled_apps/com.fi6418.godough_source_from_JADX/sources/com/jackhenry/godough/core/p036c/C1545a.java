package com.jackhenry.godough.core.p036c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.android.p022a.p023a.C1353e;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GodoughMenuItem;

/* renamed from: com.jackhenry.godough.core.c.a */
public class C1545a implements C1353e<GodoughMenuItem> {
    /* renamed from: a */
    public C1349a<GodoughMenuItem> mo9278a(int i) {
        return null;
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, GodoughMenuItem godoughMenuItem) {
        View inflate = layoutInflater.inflate(C1496ak.flyout_list_item, viewGroup, true);
        TextView textView = (TextView) inflate.findViewById(C1494ai.buttonText);
        textView.setTag(godoughMenuItem);
        textView.setText(godoughMenuItem.getText());
        ((ImageView) inflate.findViewById(C1494ai.menuItemImage)).setImageDrawable(GoDoughApp.getApp().getResources().getDrawable(godoughMenuItem.getImageID()));
        if (GoDoughApp.getUserSettings().getAlertCount() > 0 && godoughMenuItem.getType() == GodoughMenuItem.Type.ALERTS) {
            TextView textView2 = (TextView) inflate.findViewById(C1494ai.buttonBadge);
            textView2.setVisibility(0);
            textView2.setText(String.valueOf(GoDoughApp.getUserSettings().getAlertCount()));
        }
    }

    /* renamed from: a */
    public boolean mo9280a(View view, Exception exc) {
        return false;
    }
}
