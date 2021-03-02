package com.jackhenry.godough.core.accounts;

import android.graphics.drawable.LayerDrawable;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.accounts.p033a.C1421c;
import com.jackhenry.godough.core.p038e.C1586o;

/* renamed from: com.jackhenry.godough.core.accounts.f */
public class C1426f extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener, C1421c {

    /* renamed from: k */
    public final TextView f5854k;

    /* renamed from: l */
    public final TextView f5855l;

    /* renamed from: m */
    public final TextView f5856m;

    /* renamed from: n */
    public final ImageView f5857n;

    /* renamed from: o */
    public final ImageView f5858o;

    /* renamed from: p */
    public final TextView f5859p;

    /* renamed from: q */
    public C1427g f5860q;

    /* renamed from: r */
    private final RelativeLayout f5861r;

    public C1426f(View view, int i, C1427g gVar) {
        super(view);
        switch (i) {
            case 0:
                this.f5859p = (TextView) view.findViewById(C1494ai.header_text);
                C1586o.m6198a((LayerDrawable) this.f5859p.getBackground());
                this.f5854k = null;
                this.f5855l = null;
                this.f5856m = null;
                this.f5857n = null;
                this.f5858o = null;
                this.f5861r = null;
                break;
            default:
                this.f5854k = (TextView) view.findViewById(C1494ai.line1);
                this.f5855l = (TextView) view.findViewById(C1494ai.line2);
                this.f5856m = (TextView) view.findViewById(C1494ai.line2_right);
                this.f5857n = (ImageView) view.findViewById(C1494ai.draghandle);
                this.f5858o = (ImageView) view.findViewById(C1494ai.nav_icon);
                this.f5861r = (RelativeLayout) view.findViewById(C1494ai.account_layout);
                this.f5859p = null;
                break;
        }
        this.f5860q = gVar;
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
    }

    /* renamed from: a */
    public void mo9571a(boolean z) {
        if (z) {
            this.itemView.setBackground(C1586o.m6211f());
            C1586o.m6201a(this.f5861r, 10, 0, 0, 10);
            C1586o.m6201a(this.f5857n, 0, 0, 15, 10);
            C1586o.m6201a(this.f5858o, 0, 0, 15, 10);
            return;
        }
        this.itemView.setBackground(C1586o.m6212g());
        C1586o.m6201a(this.f5861r, 10, 5, 0, 5);
        C1586o.m6201a(this.f5857n, 0, 0, 15, 0);
        C1586o.m6201a(this.f5858o, 0, 0, 15, 0);
    }

    public void onClick(View view) {
        this.f5860q.mo9574a(getPosition());
    }

    public boolean onLongClick(View view) {
        this.f5860q.mo9575b(getPosition());
        return true;
    }

    /* renamed from: t */
    public void mo9563t() {
    }

    /* renamed from: u */
    public void mo9564u() {
    }
}
