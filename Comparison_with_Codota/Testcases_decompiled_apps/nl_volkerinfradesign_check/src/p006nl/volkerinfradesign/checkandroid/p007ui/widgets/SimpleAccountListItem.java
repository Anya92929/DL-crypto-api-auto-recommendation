package p006nl.volkerinfradesign.checkandroid.p007ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;

@Deprecated
/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.SimpleAccountListItem */
public class SimpleAccountListItem extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Accounts.AccountCursor f5632a;

    /* renamed from: b */
    private FrameLayout f5633b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnRefreshClickedListener f5634c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f5635d = -1;

    /* renamed from: e */
    private ImageButton f5636e;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.SimpleAccountListItem$OnRefreshClickedListener */
    public interface OnRefreshClickedListener {
        void onRefreshClicked(Accounts.AccountCursor accountCursor);
    }

    public SimpleAccountListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleAccountListItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public OnRefreshClickedListener getOnRefreshClickedListener() {
        return this.f5634c;
    }

    public void setAccount(Accounts.AccountCursor accountCursor) {
        this.f5632a = accountCursor;
        this.f5635d = accountCursor.getPosition();
        ((TextView) findViewById(16908308)).setText(accountCursor.getEmail());
        ((TextView) findViewById(16908309)).setText(accountCursor.getVerificationStep().getDescription(getContext()));
        setVerificationStep(accountCursor.getVerificationStep());
    }

    public void setOnRefreshClickedListener(OnRefreshClickedListener onRefreshClickedListener) {
        this.f5634c = onRefreshClickedListener;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getRefreshButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SimpleAccountListItem.this.f5634c != null && SimpleAccountListItem.this.f5632a != null && !SimpleAccountListItem.this.f5632a.isClosed() && SimpleAccountListItem.this.f5632a.moveToPosition(SimpleAccountListItem.this.f5635d)) {
                    SimpleAccountListItem.this.f5634c.onRefreshClicked(SimpleAccountListItem.this.f5632a);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getRefreshButton().setOnClickListener((View.OnClickListener) null);
    }

    private ImageButton getRefreshButton() {
        if (this.f5636e != null) {
            return this.f5636e;
        }
        ImageButton imageButton = (ImageButton) findViewById(16908313);
        this.f5636e = imageButton;
        return imageButton;
    }

    /* renamed from: a */
    private void m6451a(boolean z, int i) {
        int i2;
        if (this.f5633b == null) {
            this.f5633b = (FrameLayout) findViewById(16908293);
        }
        if (z) {
            this.f5633b.setVisibility(0);
            for (int i3 = 0; i3 < this.f5633b.getChildCount(); i3++) {
                View childAt = this.f5633b.getChildAt(i3);
                if (childAt.getId() == i) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                childAt.setVisibility(i2);
            }
            return;
        }
        this.f5633b.setVisibility(8);
    }

    private void setVerificationStep(Accounts.VerificationStep verificationStep) {
        switch (verificationStep) {
            case A_PENDING_VERIFICATION:
                m6451a(true, 16908301);
                return;
            case B_RED_LISTED:
            case C_VERIFICATION_FAILED:
                m6451a(true, 16908313);
                return;
            default:
                m6451a(false, 0);
                return;
        }
    }
}
