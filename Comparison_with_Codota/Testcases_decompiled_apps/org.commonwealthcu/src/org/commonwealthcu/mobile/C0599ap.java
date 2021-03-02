package org.commonwealthcu.mobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.app.ActionBarActivity;
import android.support.p003v7.appcompat.C0137R;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.vertifi.CameraActivity;
import com.vertifi.RDCGlobal;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonwealthcu.mobile.p038a.C0579a;
import org.commonwealthcu.mobile.p038a.C0581c;
import org.commonwealthcu.mobile.p038a.C0583e;
import org.json.JSONArray;
import org.json.JSONObject;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.commonwealthcu.mobile.ap */
public class C0599ap extends Fragment implements C0583e {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f741A = false;

    /* renamed from: B */
    private String f742B = null;

    /* renamed from: a */
    protected ImageView f743a;

    /* renamed from: b */
    protected ImageView f744b;

    /* renamed from: c */
    protected TextView f745c;

    /* renamed from: d */
    protected TextView f746d;

    /* renamed from: e */
    ProgressDialog f747e;

    /* renamed from: f */
    private String f748f;

    /* renamed from: g */
    private TextView f749g;

    /* renamed from: h */
    private TextView f750h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Activity f751i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ActionBarActivity f752j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Button f753k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Button f754l;

    /* renamed from: m */
    private int f755m;

    /* renamed from: n */
    private int f756n;

    /* renamed from: o */
    private EditText f757o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f758p;

    /* renamed from: q */
    private int f759q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f760r;

    /* renamed from: s */
    private int f761s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public String f762t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f763u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public C0583e f764v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f765w = false;

    /* renamed from: x */
    private boolean f766x = false;

    /* renamed from: y */
    private boolean f767y = false;

    /* renamed from: z */
    private boolean f768z = false;

    /* renamed from: a */
    private static GradientDrawable m1293a(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i, i2});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{20.0f, 20.0f, 20.0f, 20.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setStroke(1, Color.rgb(119, 119, 119));
        return gradientDrawable;
    }

    /* renamed from: a */
    private String m1294a(JSONObject jSONObject) {
        try {
            boolean z = jSONObject.getBoolean("IsDepositLimitExceeded");
            boolean z2 = jSONObject.getBoolean("IsPreProcSuccessful");
            String string = jSONObject.getString("PreProcResult");
            boolean z3 = jSONObject.getBoolean("IsFoldedCorners");
            boolean z4 = jSONObject.getBoolean("IsExcessSkew");
            boolean z5 = jSONObject.getBoolean("IsTooDark");
            boolean z6 = jSONObject.getBoolean("IsTooLight");
            boolean z7 = jSONObject.getBoolean("IsBelowMinSize");
            boolean z8 = jSONObject.getBoolean("IsAboveMaxSize");
            boolean z9 = jSONObject.getBoolean("IsUndersizedImage");
            boolean z10 = jSONObject.getBoolean("IsOversizedImage");
            boolean z11 = jSONObject.getBoolean("IsSpotNoise");
            if (z || !z2 || z4 || z3 || z5 || z6 || z7 || z8 || z9 || z10 || z11) {
                this.f765w = true;
            }
            if (!this.f765w) {
                return null;
            }
            String str = "Error - The image ";
            if (z) {
                str = "This deposit would exceed your deposit limit. Please ensure the amount is correct or deposit a check for a smaller amount.";
            } else if (z2) {
                str = "Preprocessing Failure - " + string + ".";
            } else if (z3) {
                str = str + "has folded corners.";
            } else if (z4) {
                str = str + "is skewed.";
            } else if (z5) {
                str = str + "is too dark.";
            } else if (z6) {
                str = str + "is too light.";
            } else if (z7) {
                str = str + "is too small.";
            } else if (z8) {
                str = str + "is too large.";
            } else if (z9) {
                str = str + "is too small.";
            } else if (z10) {
                str = str + "is too large.";
            } else if (z11) {
                str = str + "has bad quality.";
            }
            return str + " Please retake the picture.";
        } catch (Exception e) {
            try {
                boolean z12 = jSONObject.getBoolean("IsPreProcSuccessful");
                boolean z13 = jSONObject.getBoolean("IsTooDark");
                boolean z14 = jSONObject.getBoolean("IsTooLight");
                boolean z15 = jSONObject.getBoolean("IsBelowMinSize");
                boolean z16 = jSONObject.getBoolean("IsAboveMaxSize");
                boolean z17 = jSONObject.getBoolean("IsUndersizedImage");
                boolean z18 = jSONObject.getBoolean("IsOversizedImage");
                if (!z12 || z13 || z14 || z15 || z16 || z17 || z18) {
                    this.f765w = true;
                }
                if (!this.f765w) {
                    return null;
                }
                String str2 = "Error - The image ";
                if (z12) {
                    str2 = "Preprocessing Failure.";
                } else if (z13) {
                    str2 = str2 + "is too dark.";
                } else if (z14) {
                    str2 = str2 + "is too light.";
                } else if (z15) {
                    str2 = str2 + "is too small.";
                } else if (z16) {
                    str2 = str2 + "is too large.";
                } else if (z17) {
                    str2 = str2 + "is too small.";
                } else if (z18) {
                    str2 = str2 + "is too large.";
                }
                return str2 + " Please retake the picture.";
            } catch (Exception e2) {
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1295a() {
        this.f757o.setText("");
        this.f765w = false;
        this.f766x = false;
        this.f767y = false;
        this.f741A = false;
        this.f742B = null;
        this.f743a.setImageBitmap((Bitmap) null);
        this.f744b.setImageBitmap((Bitmap) null);
        mo5507a(this.f758p, 0, true);
        mo5507a(this.f760r, 0, false);
        this.f745c.setTextColor(Color.rgb(119, 119, 119));
        this.f746d.setTextColor(Color.rgb(119, 119, 119));
        File fileStreamPath = this.f751i.getFileStreamPath("front_color.jpg");
        File fileStreamPath2 = this.f751i.getFileStreamPath("front.png");
        File fileStreamPath3 = this.f751i.getFileStreamPath("back.png");
        fileStreamPath.delete();
        fileStreamPath2.delete();
        fileStreamPath3.delete();
    }

    /* renamed from: b */
    private String m1298b(JSONObject jSONObject) {
        try {
            boolean z = jSONObject.getBoolean("IsDateUsable");
            boolean z2 = jSONObject.getBoolean("IsPayeeUsable");
            boolean z3 = jSONObject.getBoolean("IsSignatureUsable");
            boolean z4 = jSONObject.getBoolean("IsPayorUsable");
            boolean z5 = jSONObject.getBoolean("IsMICRUsable");
            boolean z6 = jSONObject.getBoolean("IsCARMatch");
            double d = jSONObject.getDouble("CARAmount");
            ArrayList arrayList = new ArrayList();
            if (!z || !z2 || !z3 || !z4 || !z5 || !z6) {
                this.f766x = true;
            }
            if (!this.f766x) {
                return null;
            }
            if (!z) {
                arrayList.add("Date not usable");
            }
            if (!z2) {
                arrayList.add("Payee not usable");
            }
            if (!z3) {
                arrayList.add("Signature not usable");
            }
            if (!z4) {
                arrayList.add("Payor not usable");
            }
            if (!z5) {
                arrayList.add("MICR not usable");
            }
            if (!z6 && d > 0.0d) {
                arrayList.add("Amount did not match");
            } else if (!z6) {
                arrayList.add("Amount not readable");
            }
            String str = "The following warnings were found:\n\n";
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        return str + "\nYou may want to retake the picture, but can still submit the deposit.";
                    }
                    str = str + ((String) arrayList.get(i2)) + "\n";
                    i = i2 + 1;
                } catch (Exception e) {
                    return str;
                }
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: b */
    private void m1299b(String str, String str2) {
        if (str.equals("Held for Review") || str.equals("Deposit Successful")) {
            new AlertDialog.Builder(this.f751i).setTitle(str).setMessage(str2).setPositiveButton(17039370, new C0600aq(this)).setCancelable(false).create().show();
        } else {
            new AlertDialog.Builder(this.f751i).setTitle(str).setMessage(str2).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
        }
    }

    /* renamed from: a */
    public final void mo5507a(View view, int i, boolean z) {
        int i2;
        int i3 = 0;
        if (z) {
            this.f759q = i;
        } else {
            this.f761s = i;
        }
        if (i == 0) {
            view.setBackgroundDrawable(getActivity().getResources().getDrawable(C0137R.C0138drawable.vertifi_header));
            i2 = 0;
        } else if (i == 1) {
            i2 = Color.argb(122, 255, 0, 0);
            i3 = Color.argb(255, 255, 0, 0);
        } else if (i == 2) {
            i2 = Color.argb(122, 255, 255, 0);
            i3 = Color.argb(255, 255, 255, 0);
        } else if (i == 3) {
            i2 = Color.argb(122, 0, 255, 0);
            i3 = Color.argb(255, 0, 255, 0);
        } else {
            i2 = 0;
        }
        view.setBackgroundDrawable(m1293a(i2, i3));
    }

    /* renamed from: a */
    public final void mo5450a(String str) {
        String str2 = "The request timed out, please verify connection to the internet and try again.";
        if (str.equals("depositinit")) {
            this.f743a.setImageBitmap((Bitmap) null);
        } else if (str.equals("depositcommit")) {
            m1295a();
            str2 = "The request timed out. The deposit may or may not have been successful. Please check the deposit review and history, if the deposit is not listed please resubmit.";
        }
        m1299b("Request Timed Out", str2);
        if (this.f747e != null) {
            this.f747e.dismiss();
        }
        this.f747e = null;
    }

    /* renamed from: a */
    public final void mo5451a(String str, String str2) {
        String substring;
        String str3;
        String str4 = null;
        int i = 0;
        if (this.f747e != null) {
            this.f747e.dismiss();
        }
        this.f747e = null;
        JSONObject jSONObject = new JSONObject(str);
        if (str2.equals("depositinit")) {
            this.f767y = true;
            if (jSONObject.getBoolean("IsInputValid")) {
                boolean z = jSONObject.getBoolean("IsRecognized");
                this.f766x = false;
                this.f765w = false;
                String a = m1294a(jSONObject);
                String b = m1298b(jSONObject);
                int rgb = Color.rgb(255, 255, 255);
                if (a != null) {
                    m1299b("Front Check Image Validation", a);
                    mo5507a(this.f758p, 1, true);
                    this.f745c.setTextColor(rgb);
                    this.f755m = rgb;
                } else if (z) {
                    if (b != null) {
                        m1299b("Front Check Image Validation", b);
                        mo5507a(this.f758p, 2, true);
                        this.f745c.setTextColor(rgb);
                        this.f755m = rgb;
                    } else {
                        mo5507a(this.f758p, 3, true);
                        this.f745c.setTextColor(rgb);
                        this.f755m = rgb;
                    }
                    try {
                        this.f742B = jSONObject.getString("SSOKey");
                    } catch (Exception e) {
                    }
                }
            }
        } else if (str2.equals("depositcommit")) {
            this.f765w = false;
            String a2 = m1294a(jSONObject);
            int rgb2 = Color.rgb(255, 255, 255);
            if (!jSONObject.getBoolean("IsInputValid")) {
                m1299b("Image Validation", "An unknown error has occurred. Please verify information on the form, if you continue to get this message please contact your financial institution.");
                mo5507a(this.f760r, 1, false);
                this.f746d.setTextColor(rgb2);
                this.f756n = rgb2;
            } else if (a2 != null) {
                m1299b("Back Check Image Validation", a2);
                mo5507a(this.f760r, 1, false);
                this.f746d.setTextColor(rgb2);
                this.f756n = rgb2;
            } else if (jSONObject.getBoolean("IsRecognized")) {
                String obj = this.f757o.getText().toString();
                String string = jSONObject.getString("DepositID");
                if (jSONObject.getInt("DepositDisposition") == 0) {
                    m1299b("Deposit Successful", "Deposit of " + obj + " to account " + this.f749g.getText().toString() + " has been accepted. The Deposit ID for this transaction is " + string);
                    mo5507a(this.f760r, 3, false);
                    this.f746d.setTextColor(rgb2);
                    this.f756n = rgb2;
                    return;
                }
                m1299b("Held for Review", "Your deposit has been received but is held for administrative review. Expect this review to occur within 1 business day and an e-mail notification sent. Please do not redeposit this check.");
                mo5507a(this.f760r, 3, false);
                this.f746d.setTextColor(rgb2);
                this.f756n = rgb2;
            } else {
                m1299b("Image Validation", "An unknown error has occurred. Please verify information on the form, if you continue to get this message please contact your financial institution.");
                mo5507a(this.f760r, 1, false);
                this.f746d.setTextColor(rgb2);
                this.f756n = rgb2;
            }
        } else {
            JSONArray jSONArray = jSONObject.getJSONArray("Accounts");
            String str5 = this.f748f;
            Matcher matcher = Pattern.compile("[^a-zA-Z0-9\\.]").matcher(str5);
            if (matcher.find()) {
                substring = str5.substring(matcher.start() + 1);
            } else {
                Matcher matcher2 = Pattern.compile("\\D").matcher(str5);
                substring = matcher2.find() ? str5.substring(matcher2.start()) : null;
            }
            if (substring != null) {
                this.f748f = substring.replaceFirst("^0+(?!$)", "");
            } else {
                this.f748f = "N/A";
            }
            while (true) {
                if (i >= jSONArray.length()) {
                    str3 = null;
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.getString("acctNo").equals(this.f748f)) {
                    str4 = jSONObject2.getString("name");
                    str3 = jSONObject2.getString("balance");
                    break;
                } else if (jSONObject2.getString("special").equals(this.f748f)) {
                    str4 = jSONObject2.getString("name");
                    str3 = jSONObject2.getString("balance");
                    break;
                } else {
                    i++;
                }
            }
            this.f749g.setText(str4);
            this.f750h.setText(str3);
        }
    }

    /* renamed from: b */
    public final void mo5454b(String str) {
        if (this.f747e != null) {
            this.f747e.dismiss();
        }
        this.f747e = null;
        if (str.equals("depositinit")) {
            AlertDialog.Builder message = new AlertDialog.Builder(this.f751i).setTitle("Error Sending Request").setMessage("The request encountered an error, please verify connection to the internet and try again.");
            message.setPositiveButton("Try Again", new C0602as(this));
            message.setNegativeButton("Reset", new C0603at(this));
            message.setCancelable(false);
            message.show();
        } else if (str.equals("depositcommit")) {
            AlertDialog.Builder message2 = new AlertDialog.Builder(this.f751i).setTitle("Error Sending Request").setMessage("The request encountered an error, please verify connection to the internet and try again.");
            message2.setPositiveButton("Try Again", new C0604au(this));
            message2.setNegativeButton("Reset", new C0605av(this));
            message2.setCancelable(false);
            message2.show();
        }
    }

    /* renamed from: c */
    public final HashMap mo5508c(String str) {
        HashMap hashMap = new HashMap();
        Map f = ((MobileBankingApp) getActivity().getApplicationContext()).mo5470f();
        this.f748f = (String) f.get("account");
        if (f != null) {
            for (Map.Entry entry : f.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("action", str);
        String obj = this.f757o.getText().toString();
        if (obj != null) {
            hashMap.put("amount", obj.replace("$", ""));
        }
        if (this.f742B != null && this.f742B.length() > 0) {
            hashMap.put("ssokey", this.f742B);
        }
        return hashMap;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 1:
                new C0606aw(this, (byte) 0).execute(new Intent[]{intent});
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f751i = getActivity();
        this.f752j = (ActionBarActivity) getActivity();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(C0137R.layout.vertifi_depositview, viewGroup, false);
        this.f743a = (ImageView) inflate.findViewById(C0137R.C0139id.vertifi_deposit_frontimage);
        this.f744b = (ImageView) inflate.findViewById(C0137R.C0139id.vertifi_deposit_backimage);
        this.f754l = (Button) inflate.findViewById(C0137R.C0139id.vertifi_deposit_backbutton);
        this.f753k = (Button) inflate.findViewById(C0137R.C0139id.vertifi_deposit_frontbutton);
        this.f757o = (EditText) inflate.findViewById(C0137R.C0139id.vertifi_deposit_amounttext);
        inflate.findViewById(C0137R.C0139id.vertifi_deposit_submitbutton);
        this.f749g = (TextView) inflate.findViewById(C0137R.C0139id.vertifi_deposit_accountlabel);
        this.f750h = (TextView) inflate.findViewById(C0137R.C0139id.vertifi_deposit_accountbalance);
        this.f758p = inflate.findViewById(C0137R.C0139id.vertifi_deposit_frontheader);
        this.f760r = inflate.findViewById(C0137R.C0139id.vertifi_deposit_backheader);
        this.f746d = (TextView) inflate.findViewById(C0137R.C0139id.vertifi_deposit_backlabel);
        this.f745c = (TextView) inflate.findViewById(C0137R.C0139id.vertifi_deposit_frontlabel);
        View findViewById = inflate.findViewById(C0137R.C0139id.vertifi_accountheader);
        if (bundle != null) {
            this.f768z = bundle.getBoolean("isCameraActivity");
            this.f765w = bundle.getBoolean("hasError");
            this.f767y = bundle.getBoolean("frontFinished");
            this.f741A = bundle.getBoolean("backFinished");
            this.f742B = bundle.getString("SSOKey");
            this.f757o.setText(bundle.getString("amountText"));
            mo5507a(this.f758p, bundle.getInt("frontCheckHeaderCondition"), true);
            this.f745c.setTextColor(bundle.getInt("labelFrontImageTextColor"));
            mo5507a(this.f760r, bundle.getInt("backCheckHeaderCondition"), true);
            this.f746d.setTextColor(bundle.getInt("labelBackImageTextColor"));
        }
        this.f757o.setFilters(new InputFilter[]{new C0579a(4, 1)});
        double d = getActivity().getIntent().getExtras().getDouble("DEPOSIT_LIMIT");
        TextView textView = (TextView) inflate.findViewById(C0137R.C0139id.vertifi_deposit_limit);
        String format = NumberFormat.getCurrencyInstance().format(d);
        MobileBankingApp mobileBankingApp = (MobileBankingApp) getActivity().getApplicationContext();
        String a = mobileBankingApp.mo5460a("AppBackgroundColor");
        View findViewById2 = inflate.findViewById(C0137R.C0139id.vertifi_depositbackground);
        if (a != null && a.length() == 7) {
            findViewById2.setBackgroundDrawable(new ColorDrawable(Color.parseColor(a)));
        }
        String a2 = mobileBankingApp.mo5460a("TabBarColor");
        GradientDrawable gradientDrawable = null;
        if (a2 != null && a2.length() == 7) {
            gradientDrawable = m1293a(Color.parseColor(a2.replace("#", "#7A")), Color.parseColor(a2.replace("#", "#FF")));
        }
        if (gradientDrawable == null) {
            gradientDrawable = m1293a(Color.argb(122, 0, 0, 0), Color.argb(255, 0, 0, 0));
        }
        findViewById.setBackgroundDrawable(gradientDrawable);
        String a3 = mobileBankingApp.mo5460a("VertifiAccountTextColor");
        if (a3 != null && a3.length() == 7) {
            this.f749g.setTextColor(Color.parseColor(a3));
        }
        this.f764v = this;
        this.f751i = getActivity();
        this.f752j = (ActionBarActivity) getActivity();
        this.f763u = mobileBankingApp.mo5468d();
        this.f762t = mobileBankingApp.mo5471g();
        textView.setText(format);
        Map f = mobileBankingApp.mo5470f();
        String str = f.get("accountname") != null ? (String) f.get("accountname") : "Validation Error";
        String str2 = f.get("accountbalance") != null ? (String) f.get("accountbalance") : "Could not validate account";
        this.f749g.setText(str);
        this.f750h.setText(str2);
        C0250b.m92a((Context) getActivity(), inflate);
        return inflate;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (!this.f768z) {
            m1295a();
        } else {
            this.f768z = false;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("isCameraActivity", this.f768z);
        bundle.putString("amountText", this.f757o.toString());
        bundle.putBoolean("hasError", this.f765w);
        bundle.putBoolean("frontFinished", this.f767y);
        bundle.putBoolean("backFinished", this.f741A);
        bundle.putString("SSOKey", this.f742B);
        bundle.putInt("frontCheckHeaderCondition", this.f759q);
        bundle.putInt("labelFrontImageTextColor", this.f755m);
        bundle.putInt("backCheckHeaderCondition", this.f761s);
        bundle.putInt("labelBackImageTextColor", this.f756n);
        super.onSaveInstanceState(bundle);
    }

    public void startCameraActivity(View view) {
        this.f768z = true;
        String obj = this.f757o.getText().toString();
        Double valueOf = Double.valueOf(0.0d);
        if (obj.length() > 0 && !obj.equals(".")) {
            valueOf = Double.valueOf(Double.parseDouble(obj));
        }
        if (obj == null || obj.length() <= 0 || valueOf.doubleValue() <= 0.0d) {
            m1299b("Amount Not Entered", "An amount greater than zero must be entered");
            this.f757o.requestFocus();
            return;
        }
        Intent intent = new Intent(getActivity(), CameraActivity.class);
        intent.putExtra("com.Vertifi.ImageProcessing.FrontImage", true);
        intent.putExtra("com.Vertifi.ImageProcessing.CameraOverlayTitle", "FRONT CHECK IMAGE");
        startActivityForResult(intent, RDCGlobal.FRONT_IMAGE);
    }

    public void startCameraActivityBack(View view) {
        this.f768z = true;
        if (this.f767y) {
            Intent intent = new Intent(getActivity(), CameraActivity.class);
            intent.putExtra("com.Vertifi.ImageProcessing.FrontImage", false);
            intent.putExtra("com.Vertifi.ImageProcessing.CameraOverlayTitle", "BACK CHECK IMAGE");
            startActivityForResult(intent, RDCGlobal.BACK_IMAGE);
            return;
        }
        m1299b("Image Validation", "Please wait for the Front Check Image to be validated.");
    }

    public void submitDeposit(View view) {
        String obj = this.f757o.getText().toString();
        Double valueOf = Double.valueOf(0.0d);
        if (obj.length() > 0 && !obj.equals(".")) {
            valueOf = Double.valueOf(Double.parseDouble(obj));
        }
        if (this.f765w) {
            m1299b("Image Validation", "Please correct errors on the form before submitting.");
        } else if (valueOf.doubleValue() <= 0.0d) {
            m1299b("Amount Not Entered", "An amount greater than zero must be entered.");
        } else if (!this.f767y) {
            m1299b("Image Validation", "Please wait for the Front Check Image to be validated.");
        } else if (!this.f741A) {
            m1299b("Image Validation", "Back image not validated. Please correct before continuing.");
        } else if (this.f765w || obj == null || obj.length() <= 0 || this.f742B == null || this.f742B.length() <= 0 || !this.f741A) {
            m1299b("Form Error", "Please check the form and ensure all areas are complete.");
        } else {
            this.f747e = ProgressDialog.show(this.f751i, "", "Processing. Please wait...", true);
            File fileStreamPath = this.f751i.getFileStreamPath("back.png");
            new C0581c(this.f764v, mo5508c("depositcommit"), fileStreamPath, (File) null).execute(new String[]{this.f763u + "/commonfiles/iphone/asppages/vertifi.aspx", this.f762t});
        }
    }
}
