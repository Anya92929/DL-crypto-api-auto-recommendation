package p000;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.view.ItemView;
import p006nl.volkerinfradesign.checkandroid.p007ui.widgets.ImageStateButton;

/* renamed from: in */
public final class C1279in {

    /* renamed from: a */
    final CheckBox f4477a;

    /* renamed from: b */
    final ViewGroup f4478b;

    /* renamed from: c */
    final ViewGroup f4479c;

    /* renamed from: d */
    final ImageStateButton f4480d;

    /* renamed from: e */
    final ImageStateButton f4481e;

    /* renamed from: f */
    final ImageStateButton f4482f;

    /* renamed from: g */
    final ImageStateButton f4483g;

    /* renamed from: h */
    final ImageButton f4484h;

    /* renamed from: i */
    final ImageButton f4485i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final ItemView f4486j;

    /* renamed from: k */
    private final View.OnClickListener f4487k = new View.OnClickListener() {
        public void onClick(View view) {
            int id = view.getId();
            if (id == C1352R.C1354id.nvt) {
                C1279in.this.f4486j.mo10063a(C1279in.this.f4477a.isChecked());
            } else if (id == C1352R.C1354id.camera) {
                C1279in.this.f4486j.mo10065c();
            } else if (id == C1352R.C1354id.gallery) {
                C1279in.this.f4486j.mo10067e();
            } else if (id == C1352R.C1354id.drawing) {
                C1279in.this.f4486j.mo10066d();
            } else if (id == C1352R.C1354id.location) {
                C1279in.this.f4486j.mo10068f();
            } else if (id == C1352R.C1354id.remark) {
                C1279in.this.f4486j.mo10069g();
            } else if (id == C1352R.C1354id.more) {
                C1279in.this.f4486j.mo10070h();
            }
        }
    };

    public C1279in(ItemView itemView) {
        this.f4486j = itemView;
        this.f4478b = (LinearLayout) itemView.findViewById(C1352R.C1354id.options);
        this.f4477a = (CheckBox) this.f4478b.findViewById(C1352R.C1354id.nvt);
        this.f4479c = (ViewGroup) this.f4478b.findViewById(C1352R.C1354id.buttonWrapper);
        this.f4480d = (ImageStateButton) this.f4479c.findViewById(C1352R.C1354id.camera);
        this.f4481e = (ImageStateButton) this.f4479c.findViewById(C1352R.C1354id.gallery);
        this.f4482f = (ImageStateButton) this.f4479c.findViewById(C1352R.C1354id.location);
        this.f4483g = (ImageStateButton) this.f4479c.findViewById(C1352R.C1354id.drawing);
        this.f4484h = (ImageButton) this.f4479c.findViewById(C1352R.C1354id.remark);
        this.f4485i = (ImageButton) this.f4478b.findViewById(C1352R.C1354id.more);
        this.f4477a.setOnClickListener(this.f4487k);
        this.f4480d.setOnClickListener(this.f4487k);
        this.f4483g.setOnClickListener(this.f4487k);
        this.f4481e.setOnClickListener(this.f4487k);
        this.f4482f.setOnClickListener(this.f4487k);
        this.f4484h.setOnClickListener(this.f4487k);
        this.f4485i.setOnClickListener(this.f4487k);
    }

    /* renamed from: a */
    public void mo8626a() {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 8;
        if (this.f4486j.f5271u == null || this.f4486j.f5271u == InspectionItemType.PROJECTS) {
            this.f4478b.setVisibility(8);
        } else if (!this.f4486j.f5253c) {
            boolean z2 = this.f4486j.f5263m && !this.f4486j.f5260j;
            if (!this.f4486j.f5264n || this.f4486j.f5265o) {
                z = false;
            } else {
                z = true;
            }
            this.f4478b.setVisibility(0);
            this.f4479c.setVisibility(0);
            if (this.f4486j.f5258h) {
                this.f4477a.setChecked(this.f4486j.f5257g);
                this.f4477a.setEnabled(true);
                this.f4477a.setVisibility(0);
            } else {
                this.f4477a.setVisibility(8);
            }
            ImageStateButton imageStateButton = this.f4480d;
            if (z2 || this.f4486j.f5266p) {
                i = 0;
            } else {
                i = 8;
            }
            imageStateButton.setVisibility(i);
            this.f4480d.setRequired(z2);
            ImageStateButton imageStateButton2 = this.f4481e;
            if (this.f4486j.f5266p) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageStateButton2.setVisibility(i2);
            this.f4481e.setRequired(z2);
            ImageStateButton imageStateButton3 = this.f4483g;
            if (this.f4486j.f5266p) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageStateButton3.setVisibility(i3);
            this.f4483g.setRequired(z2);
            ImageStateButton imageStateButton4 = this.f4482f;
            if (this.f4486j.f5266p || this.f4486j.f5264n) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            imageStateButton4.setVisibility(i4);
            this.f4482f.setRequired(z);
            ImageButton imageButton = this.f4484h;
            if (!this.f4486j.f5261k && this.f4486j.f5266p) {
                i5 = 0;
            }
            imageButton.setVisibility(i5);
            this.f4485i.setVisibility(0);
        } else if (this.f4486j.f5258h) {
            this.f4477a.setChecked(this.f4486j.f5257g);
            this.f4477a.setEnabled(false);
            this.f4478b.setVisibility(0);
            this.f4479c.setVisibility(8);
            this.f4485i.setVisibility(8);
        } else {
            this.f4478b.setVisibility(8);
        }
    }
}
