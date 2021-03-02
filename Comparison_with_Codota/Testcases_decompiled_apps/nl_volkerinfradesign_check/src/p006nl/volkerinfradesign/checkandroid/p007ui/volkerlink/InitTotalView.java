package p006nl.volkerinfradesign.checkandroid.p007ui.volkerlink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.C1352R;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitTotalView */
public class InitTotalView extends FrameLayout {

    /* renamed from: a */
    private boolean f5593a;

    /* renamed from: b */
    private boolean f5594b;

    /* renamed from: c */
    private Button f5595c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnLoginClickedObserver f5596d;

    /* renamed from: e */
    private final View.OnClickListener f5597e = new View.OnClickListener() {
        public void onClick(View view) {
            if (InitTotalView.this.f5596d != null && view.getId() == C1352R.C1354id.ensureUser) {
                InitTotalView.this.f5596d.onLoginClicked();
            }
        }
    };

    /* renamed from: f */
    private TextView f5598f;

    /* renamed from: g */
    private SetupState f5599g = SetupState.NO_USER;

    /* renamed from: h */
    private LinearLayout f5600h;

    /* renamed from: i */
    private LinearLayout f5601i;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.volkerlink.InitTotalView$OnLoginClickedObserver */
    public interface OnLoginClickedObserver {
        void onLoginClicked();
    }

    public InitTotalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InitTotalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public OnLoginClickedObserver getLoginClickedObserver() {
        return this.f5596d;
    }

    public void setLoginClickedObserver(OnLoginClickedObserver onLoginClickedObserver) {
        this.f5596d = onLoginClickedObserver;
    }

    public void setState(SetupState setupState) {
        this.f5599g = setupState;
        this.f5594b = true;
        if (this.f5593a) {
            m6437a();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5600h = (LinearLayout) findViewById(C1352R.C1354id.userContainer);
        this.f5601i = (LinearLayout) findViewById(C1352R.C1354id.loadingContainer);
        this.f5598f = (TextView) findViewById(C1352R.C1354id.loadingDescription);
        this.f5595c = (Button) findViewById(C1352R.C1354id.ensureUser);
        this.f5595c.setOnClickListener(this.f5597e);
        this.f5593a = true;
        if (this.f5594b) {
            m6437a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f5593a = false;
        super.onDetachedFromWindow();
        this.f5595c.setOnClickListener((View.OnClickListener) null);
    }

    /* renamed from: a */
    private void m6437a() {
        m6438b();
        m6439c();
        this.f5594b = false;
    }

    /* renamed from: b */
    private void m6438b() {
        if (this.f5599g == SetupState.NO_USER) {
            this.f5600h.setVisibility(0);
            this.f5601i.setVisibility(4);
            return;
        }
        this.f5600h.setVisibility(4);
        this.f5601i.setVisibility(0);
    }

    /* renamed from: c */
    private void m6439c() {
        switch (this.f5599g) {
            case RE_DOWNLOAD_FORM:
            case DOWNLOAD_FORM:
                this.f5598f.setText(C1352R.string.loading_desc_form);
                return;
            case RE_DOWNLOAD_COMPANIES:
            case DOWNLOAD_COMPANIES:
                this.f5598f.setText(C1352R.string.loading_desc_companies);
                return;
            default:
                this.f5598f.setText((CharSequence) null);
                return;
        }
    }
}
