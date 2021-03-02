package com.jackhenry.godough.core.rda;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.model.Deposit;
import com.jackhenry.godough.core.model.DepositTransaction;
import com.jackhenry.godough.core.widgets.TouchImageView;

public class CheckViewFragment extends C1802r {
    public static final String PARAM_DEPOSIT_TRANSACTION = "depositTransAction";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TouchImageView f6608a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f6609b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Bitmap f6610c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Bitmap f6611d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Deposit.Side f6612e = Deposit.Side.FRONT;

    /* renamed from: f */
    private DepositTransaction f6613f;

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m6668n() {
        mo10986b(getString(C1506am.ellipse_requesting_image));
        new C1878u(this.f6613f.getTransactionId(), this.f6612e, new C1811b(this, this, new C1803a(this))).execute(new Void[0]);
    }

    public void flipCheck() {
        if (this.f6612e == Deposit.Side.FRONT) {
            this.f6612e = Deposit.Side.BACK;
            if (this.f6611d == null) {
                m6668n();
            } else {
                this.f6608a.setImageBitmap(this.f6611d);
            }
        } else {
            this.f6612e = Deposit.Side.FRONT;
            this.f6608a.setImageBitmap(this.f6610c);
        }
    }

    public Deposit.Side getSide() {
        return this.f6612e;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6613f = (DepositTransaction) getActivity().getIntent().getSerializableExtra("depositTransAction");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1496ak.deposit_check_view_fragment, viewGroup);
        this.f6608a = (TouchImageView) inflate.findViewById(C1494ai.imageView);
        this.f6609b = (TextView) inflate.findViewById(C1494ai.no_image);
        if ((this.f6612e == Deposit.Side.FRONT && this.f6610c == null) || (this.f6612e == Deposit.Side.BACK && this.f6611d == null)) {
            m6668n();
        } else {
            this.f6608a.setImageBitmap(this.f6612e == Deposit.Side.FRONT ? this.f6610c : this.f6611d);
        }
        return inflate;
    }

    public void onDestroy() {
        this.f6608a.setOnTouchListener((View.OnTouchListener) null);
        this.f6608a.setImageBitmap((Bitmap) null);
        super.onDestroy();
    }
}
