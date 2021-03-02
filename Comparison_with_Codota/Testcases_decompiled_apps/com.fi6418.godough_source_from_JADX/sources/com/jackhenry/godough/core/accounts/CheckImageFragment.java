package com.jackhenry.godough.core.accounts;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.android.p022a.C1364k;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.AccountTransaction;
import com.jackhenry.godough.core.model.CheckImageData;
import com.jackhenry.godough.core.p038e.C1580i;
import com.jackhenry.godough.core.widgets.TouchImageView;
import java.lang.reflect.Array;
import java.util.Iterator;

public class CheckImageFragment extends C1802r {
    public static final String EXTRA_TRANSACTION = "EXTRA_TRANSACTION";

    /* renamed from: a */
    private final int f5833a = 2;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public int f5834aj = 0;

    /* renamed from: ak */
    private TextView f5835ak;

    /* renamed from: b */
    private final int f5836b = 0;

    /* renamed from: c */
    private final int f5837c = 1;

    /* renamed from: d */
    private TouchImageView f5838d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AccountTransaction f5839e;

    /* renamed from: f */
    private boolean f5840f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TabLayout f5841g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Bitmap[][] f5842h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f5843i = 0;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5787a(int i) {
        if (this.f5835ak != null) {
            this.f5835ak.setText(getString(C1506am.check_image_x_of_x, Integer.valueOf(i + 1), Integer.valueOf(this.f5839e.getImages().size())));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5788a(int i, int i2) {
        mo10986b(getString(C1506am.ellipse_requesting_image));
        new C1438r(this.f5839e.getImages().get(i).getId(), i2 == 0, new C1436p(this, this, i, i2, new C1435o(this, i, i2))).execute(new Void[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5793b(int i, int i2) {
        if (this.f5842h[i][i2] == null) {
            m5788a(i, i2);
            return;
        }
        setCheckImage(this.f5842h[i][i2]);
        this.f5843i = i;
        this.f5834aj = i2;
        m5787a(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m5802n() {
        int i = 1;
        if (this.f5834aj == 1) {
            i = 0;
        }
        this.f5834aj = i;
        if (this.f5842h[this.f5843i][i] != null) {
            setCheckImage(this.f5842h[this.f5843i][i]);
        } else {
            m5788a(this.f5843i, i);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5839e = (AccountTransaction) getActivity().getIntent().getExtras().getSerializable("EXTRA_TRANSACTION");
        this.f5842h = (Bitmap[][]) Array.newInstance(Bitmap.class, new int[]{this.f5839e.getImages().size(), 2});
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.check_image_fragment, viewGroup, false);
        ((TextView) inflate.findViewById(C1494ai.check_flip)).setOnClickListener(new C1433m(this));
        getActivity().setTitle(this.f5839e.getDescription());
        this.f5838d = (TouchImageView) inflate.findViewById(C1494ai.check_image);
        this.f5841g = (TabLayout) inflate.findViewById(C1494ai.checkImageTabLayout);
        this.f5835ak = (TextView) inflate.findViewById(C1494ai.check_item_count);
        String string = this.f5839e.isCredit() ? getString(C1506am.reference) : getString(C1506am.check);
        if (this.f5839e.getImages().size() > 1) {
            this.f5838d.setFlingCallBack(new C1437q(this, (C1433m) null));
            this.f5838d.setSwipeEnable(true);
            this.f5841g.setTabMode(0);
            this.f5841g.setOnTabSelectedListener(new C1434n(this));
            ((AbstractActivity) getActivity()).getSupportActionBar().setSubtitle((CharSequence) getString(C1506am.check_image_subtitle, this.f5839e.getReferenceNumber(), C1580i.m6152a(this.f5839e.getAmount()), C1364k.m5588a(this.f5839e.getPostDate()), string));
            populateTabs();
            m5787a(this.f5843i);
        } else {
            this.f5835ak.setVisibility(4);
            this.f5838d.setSwipeEnable(false);
            this.f5841g.setVisibility(4);
            ((AbstractActivity) getActivity()).getSupportActionBar().setSubtitle((CharSequence) getString(C1506am.check_image_subtitle, this.f5839e.getReferenceNumber(), C1580i.m6152a(this.f5839e.getAmount()), C1364k.m5588a(this.f5839e.getPostDate()), string));
        }
        m5788a(this.f5843i, this.f5834aj);
        return inflate;
    }

    public void populateTabs() {
        Iterator<CheckImageData> it = this.f5839e.getImages().iterator();
        while (it.hasNext()) {
            this.f5841g.mo150a(this.f5841g.mo147a().mo204a((CharSequence) C1580i.m6152a(it.next().getAmount())));
        }
    }

    public void setCheckImage(Bitmap bitmap) {
        this.f5838d.setImageBitmap(bitmap);
    }
}
