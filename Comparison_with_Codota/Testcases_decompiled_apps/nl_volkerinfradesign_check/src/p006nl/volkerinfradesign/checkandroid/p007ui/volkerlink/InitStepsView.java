package p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.C1352R;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitStepsView */
public class InitStepsView extends ScrollView {

    /* renamed from: a */
    private boolean f5559a;

    /* renamed from: b */
    private View f5560b;

    /* renamed from: c */
    private View f5561c;

    /* renamed from: d */
    private boolean f5562d;

    /* renamed from: e */
    private boolean f5563e;

    /* renamed from: f */
    private boolean f5564f = true;

    /* renamed from: g */
    private boolean f5565g;

    /* renamed from: h */
    private boolean f5566h = true;

    /* renamed from: i */
    private Button f5567i;

    /* renamed from: j */
    private Button f5568j;

    /* renamed from: k */
    private Button f5569k;

    /* renamed from: l */
    private Button f5570l;

    /* renamed from: m */
    private Button f5571m;

    /* renamed from: n */
    private Button f5572n;

    /* renamed from: o */
    private Button f5573o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public InitViewObserver f5574p;

    /* renamed from: q */
    private final View.OnClickListener f5575q = new View.OnClickListener() {
        public void onClick(View view) {
            if (InitStepsView.this.f5574p != null) {
                int id = view.getId();
                if (id == C1352R.C1354id.ensureUser) {
                    InitStepsView.this.f5574p.onLoginClicked();
                } else if (id == C1352R.C1354id.showUser) {
                    InitStepsView.this.f5574p.onShowUserClicked();
                } else if (id == C1352R.C1354id.downloadForm) {
                    InitStepsView.this.f5574p.onDownloadFormClicked();
                } else if (id == C1352R.C1354id.retryDownloadForm) {
                    InitStepsView.this.f5574p.onRetryDownloadFormClicked();
                } else if (id == C1352R.C1354id.downloadCompany) {
                    InitStepsView.this.f5574p.onRetryCompaniesClicked();
                } else if (id == C1352R.C1354id.retryDownloadCompany) {
                    InitStepsView.this.f5574p.onDownloadCompaniesClicked();
                } else if (id == C1352R.C1354id.pickCompany) {
                    InitStepsView.this.f5574p.onPickCompanyClicked();
                }
            }
        }
    };

    /* renamed from: r */
    private SetupState f5576r = SetupState.NO_USER;

    /* renamed from: s */
    private TextView f5577s;

    /* renamed from: t */
    private TextView f5578t;

    /* renamed from: u */
    private TextView f5579u;

    /* renamed from: v */
    private TextView f5580v;

    /* renamed from: w */
    private TextView f5581w;

    /* renamed from: x */
    private TextView f5582x;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitStepsView$InitViewObserver */
    public interface InitViewObserver {
        void onDownloadCompaniesClicked();

        void onDownloadFormClicked();

        void onLoginClicked();

        void onPickCompanyClicked();

        void onRetryCompaniesClicked();

        void onRetryDownloadFormClicked();

        void onShowUserClicked();
    }

    public InitStepsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InitStepsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InitViewObserver getInitViewObserver() {
        return this.f5574p;
    }

    public void setCompaniesDownloadEnabled(boolean z) {
        if (this.f5559a) {
            this.f5572n.setEnabled(z);
            this.f5573o.setEnabled(z);
            this.f5565g = false;
            return;
        }
        this.f5565g = true;
        this.f5566h = z;
    }

    public void setFormDownloadEnabled(boolean z) {
        if (this.f5559a) {
            this.f5569k.setEnabled(z);
            this.f5570l.setEnabled(z);
            this.f5563e = false;
            return;
        }
        this.f5563e = true;
        this.f5564f = z;
    }

    public void setInitViewObserver(InitViewObserver initViewObserver) {
        this.f5574p = initViewObserver;
    }

    public void setState(SetupState setupState) {
        this.f5576r = setupState;
        this.f5562d = true;
        if (this.f5559a) {
            m6417a();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5560b = findViewById(C1352R.C1354id.divider1);
        this.f5561c = findViewById(C1352R.C1354id.divider2);
        this.f5577s = (TextView) findViewById(C1352R.C1354id.userTitle);
        this.f5578t = (TextView) findViewById(C1352R.C1354id.userDescription);
        this.f5579u = (TextView) findViewById(C1352R.C1354id.formTitle);
        this.f5580v = (TextView) findViewById(C1352R.C1354id.formDescription);
        this.f5581w = (TextView) findViewById(C1352R.C1354id.companyTitle);
        this.f5582x = (TextView) findViewById(C1352R.C1354id.companyDescription);
        this.f5567i = (Button) findViewById(C1352R.C1354id.ensureUser);
        this.f5568j = (Button) findViewById(C1352R.C1354id.showUser);
        this.f5569k = (Button) findViewById(C1352R.C1354id.downloadForm);
        this.f5570l = (Button) findViewById(C1352R.C1354id.retryDownloadForm);
        this.f5571m = (Button) findViewById(C1352R.C1354id.pickCompany);
        this.f5572n = (Button) findViewById(C1352R.C1354id.downloadCompany);
        this.f5573o = (Button) findViewById(C1352R.C1354id.retryDownloadCompany);
        this.f5567i.setOnClickListener(this.f5575q);
        this.f5568j.setOnClickListener(this.f5575q);
        this.f5569k.setOnClickListener(this.f5575q);
        this.f5570l.setOnClickListener(this.f5575q);
        this.f5572n.setOnClickListener(this.f5575q);
        this.f5573o.setOnClickListener(this.f5575q);
        this.f5571m.setOnClickListener(this.f5575q);
        this.f5559a = true;
        if (this.f5562d) {
            m6417a();
        }
        if (this.f5563e) {
            setFormDownloadEnabled(this.f5564f);
        }
        if (this.f5565g) {
            setCompaniesDownloadEnabled(this.f5566h);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f5559a = false;
        super.onDetachedFromWindow();
        this.f5567i.setOnClickListener((View.OnClickListener) null);
        this.f5568j.setOnClickListener((View.OnClickListener) null);
        this.f5569k.setOnClickListener((View.OnClickListener) null);
        this.f5570l.setOnClickListener((View.OnClickListener) null);
        this.f5572n.setOnClickListener((View.OnClickListener) null);
        this.f5573o.setOnClickListener((View.OnClickListener) null);
        this.f5571m.setOnClickListener((View.OnClickListener) null);
    }

    /* renamed from: a */
    private void m6417a() {
        m6419c();
        m6420d();
        m6418b();
        this.f5562d = false;
    }

    private SetupActivity getActivity() {
        return (SetupActivity) getContext();
    }

    /* renamed from: b */
    private void m6418b() {
        if (this.f5576r.ordinal() < SetupState.DOWNLOAD_COMPANIES.ordinal()) {
            this.f5561c.setVisibility(8);
            this.f5581w.setVisibility(8);
            this.f5582x.setVisibility(8);
            this.f5572n.setVisibility(8);
            this.f5573o.setVisibility(8);
            this.f5571m.setVisibility(8);
            return;
        }
        this.f5561c.setVisibility(0);
        this.f5581w.setVisibility(0);
        this.f5582x.setVisibility(0);
        if (this.f5576r.ordinal() < SetupState.FINISHED.ordinal()) {
            this.f5581w.setText("Geen bedrijven beschikbaar");
            this.f5582x.setText("De bedrijven moeten eerst gedownload worden voordat u er een kan selecteren.");
        } else {
            this.f5581w.setText("Bedrijven beschikbaar");
            this.f5582x.setText("De bedrijven zijn gedownload.");
        }
        switch (this.f5576r) {
            case DOWNLOAD_COMPANIES:
                this.f5572n.setVisibility(0);
                this.f5573o.setVisibility(8);
                return;
            case RE_DOWNLOAD_COMPANIES:
                this.f5572n.setVisibility(8);
                this.f5573o.setVisibility(0);
                return;
            case FINISHED:
                this.f5571m.setVisibility(0);
                break;
        }
        this.f5572n.setVisibility(8);
        this.f5573o.setVisibility(8);
    }

    /* renamed from: c */
    private void m6419c() {
        switch (this.f5576r) {
            case NO_USER:
                this.f5577s.setText("Geen gebruiker beschikbaar");
                this.f5578t.setText("Voordat u formulieren kunt invullen, moet u eerst ingelogd zijn.");
                this.f5567i.setVisibility(0);
                this.f5568j.setVisibility(8);
                return;
            default:
                this.f5577s.setText("Gebruiker aanwezig");
                this.f5578t.setText("Gevonden gebruiker: " + getActivity().mo10375b().getModel().getAccount().getEmail());
                this.f5567i.setVisibility(8);
                this.f5568j.setVisibility(0);
                return;
        }
    }

    /* renamed from: d */
    private void m6420d() {
        if (this.f5576r == SetupState.NO_USER) {
            this.f5560b.setVisibility(8);
            this.f5579u.setVisibility(8);
            this.f5580v.setVisibility(8);
            this.f5569k.setVisibility(8);
            this.f5570l.setVisibility(8);
            return;
        }
        this.f5560b.setVisibility(0);
        this.f5579u.setVisibility(0);
        this.f5580v.setVisibility(0);
        if (this.f5576r.ordinal() < SetupState.DOWNLOAD_COMPANIES.ordinal()) {
            this.f5579u.setText("Formulier niet aanwezig");
            this.f5580v.setText("Het formulier moet eerst gedownload worden voordat u het kan gebruiken.");
        } else {
            this.f5579u.setText("Formulier aanwezig");
            this.f5580v.setText("Het formulier is gevonden. De volgende stap is het kiezen van uw bedrijf");
        }
        switch (this.f5576r) {
            case DOWNLOAD_FORM:
                this.f5569k.setVisibility(0);
                this.f5570l.setVisibility(8);
                return;
            case RE_DOWNLOAD_FORM:
                this.f5569k.setVisibility(8);
                this.f5570l.setVisibility(0);
                return;
            default:
                this.f5569k.setVisibility(8);
                this.f5570l.setVisibility(8);
                return;
        }
    }
}
