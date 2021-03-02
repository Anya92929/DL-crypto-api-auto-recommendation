package com.jackhenry.godough.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jackhenry.android.p022a.p023a.C1349a;
import com.jackhenry.android.p022a.p023a.C1353e;
import com.jackhenry.godough.core.model.ImageTextArrowRow;

/* renamed from: com.jackhenry.godough.core.z */
public class C1944z implements C1353e<ImageTextArrowRow> {
    /* renamed from: a */
    public C1349a<ImageTextArrowRow> mo9278a(int i) {
        return null;
    }

    /* renamed from: a */
    public void mo9279a(LayoutInflater layoutInflater, ViewGroup viewGroup, ImageTextArrowRow imageTextArrowRow) {
        View inflate = layoutInflater.inflate(C1496ak.image_text_arrow_row, viewGroup);
        ((TextView) inflate.findViewById(C1494ai.text)).setText(imageTextArrowRow.getText());
        ((ImageView) inflate.findViewById(C1494ai.image)).setImageResource(imageTextArrowRow.getDrawableId());
    }

    /* renamed from: a */
    public boolean mo9280a(View view, Exception exc) {
        return false;
    }
}
