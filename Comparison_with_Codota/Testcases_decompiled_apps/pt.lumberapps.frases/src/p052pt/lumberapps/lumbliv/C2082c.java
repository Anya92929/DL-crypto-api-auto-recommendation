package p052pt.lumberapps.lumbliv;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: pt.lumberapps.lumbliv.c */
public class C2082c extends Dialog {

    /* renamed from: a */
    private Typeface f7839a;

    /* renamed from: d */
    TextView f7840d;

    /* renamed from: e */
    TextView f7841e;

    /* renamed from: f */
    TextView f7842f = ((TextView) findViewById(C2099t.dialog_tv_msg));

    /* renamed from: g */
    TextView f7843g = ((TextView) findViewById(C2099t.dialog_ok_titulo));

    /* renamed from: h */
    Activity f7844h;

    /* renamed from: i */
    String f7845i;

    public C2082c(Activity activity, String str) {
        super(activity);
        requestWindowFeature(1);
        setContentView(C2100u.dialog_l);
        this.f7844h = activity;
        this.f7845i = str;
        this.f7842f.setText(str);
        mo10273a(this.f7842f);
        this.f7840d = (TextView) findViewById(C2099t.dialog_tv_bt_ok);
        this.f7840d.setText("OK");
        mo10273a(this.f7840d);
        this.f7840d.setClickable(true);
        this.f7840d.setOnClickListener(new C2083d(this));
        this.f7841e = (TextView) findViewById(C2099t.dialog_tv_bt_cancel);
        this.f7841e.setClickable(true);
        this.f7841e.setText("Cancel");
        mo10273a(this.f7841e);
        this.f7841e.setOnClickListener(new C2084e(this));
        mo10274a(true);
        setCancelable(true);
        setOnCancelListener(new C2085f(this));
        mo10272a(-16777216, -1);
    }

    /* renamed from: a */
    public void mo10233a() {
    }

    /* renamed from: a */
    public void mo10272a(int i, int i2) {
        this.f7842f.setTextColor(i2);
        this.f7843g.setTextColor(i2);
        ((RelativeLayout) findViewById(C2099t.dialogo_rela_root)).setBackgroundColor(i);
    }

    /* renamed from: a */
    public void mo10273a(TextView textView) {
        try {
            if (this.f7839a == null) {
                this.f7839a = Typeface.createFromAsset(this.f7844h.getAssets(), "roboto-medium.ttf");
            }
            textView.setTypeface(this.f7839a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo10274a(boolean z) {
        this.f7841e.setVisibility(z ? 0 : 4);
    }

    public void cancel() {
    }

    /* renamed from: e */
    public C2082c mo10271e() {
        show();
        return this;
    }

    public void onBackPressed() {
        if (isShowing()) {
            dismiss();
        } else {
            super.onBackPressed();
        }
    }
}
