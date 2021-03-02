package com.flurry.android;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Html;
import android.text.SpannedString;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.games.GamesActivityResultCodes;

/* renamed from: com.flurry.android.ac */
final class C0089ac extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final SpannedString f101a = new SpannedString(Html.fromHtml("<html><div='style:font-size:7px'>&lt; Previous</div></html>"));
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final SpannedString f102b = new SpannedString(Html.fromHtml("<html><div='style:font-size:7px;color:#ffA500'>&lt; Previous</div></html>"));

    public C0089ac(CatalogActivity catalogActivity, Context context) {
        super(context);
        setBackgroundColor(-16777216);
        TextView textView = new TextView(context);
        textView.setTextColor(ColorStateList.valueOf(-1));
        textView.setId(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED);
        textView.setText(this.f101a);
        textView.setPadding(5, 2, 5, 2);
        textView.setFocusable(true);
        textView.setOnFocusChangeListener(new C0090ad(this, textView));
        textView.setOnClickListener(catalogActivity);
        textView.setEnabled(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(2, 0, 0, 0);
        layoutParams2.addRule(4);
        addView(textView, layoutParams2);
    }
}
