package com.myip.vpnroot;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.ViewCompat;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.vending.billing.IInAppBillingService;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.myip.vpnroot.util.ObscuredSharedPreferences;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderActivity extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final int ACCOUNT_SELECT_CODE = 3;
    private static final int OPENVPN_REQUEST_CODE = 1212;
    public static final int REQUEST_CODE_PURCHASE = 1001;
    public static final int REQUEST_CODE_RESOLVE_ADDRESS_LOOKUP = 1006;
    public static final int REQUEST_CODE_RESOLVE_ERR = 1007;
    public static final String TAG = "Test";
    private static final int VPN_REQUEST_CODE = 121;
    private AccountManager accountManager;
    /* access modifiers changed from: private */
    public String accountName;
    String billing;
    String chosenCountry;
    String chosenCountryCode;
    /* access modifiers changed from: private */
    public String config_hostname;
    /* access modifiers changed from: private */
    public String config_ipv4;
    EditText etAdd1;
    EditText etAdd2;
    EditText etCity;
    EditText etName;
    EditText etPass1;
    EditText etPass2;
    EditText etPhone;
    TextView etProd1;
    TextView etProd2;
    EditText etState;
    CheckBox etTerms;
    EditText etUser;
    EditText etZip;
    /* access modifiers changed from: private */
    public String gapi_clientid;
    String location;
    /* access modifiers changed from: private */
    public ConnectionResult mConnectionResult;
    private GoogleApiClient mGoogleApiClient;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressDialog;
    private boolean mPromoWasSelected = false;
    IInAppBillingService mService;
    ServiceConnection mServiceConn = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName name) {
            OrderActivity.this.mService = null;
        }

        public void onServiceConnected(ComponentName name, IBinder service) {
            OrderActivity.this.mService = IInAppBillingService.Stub.asInterface(service);
        }
    };
    private SharedPreferences prefs;
    public String product_name;
    RadioButton radio_billing_1;
    RadioButton radio_billing_2;
    RadioButton radio_location_1;
    RadioButton radio_location_2;
    String sku;
    Spinner spCountry;
    TextView txt_add1;
    TextView txt_city;
    TextView txt_country;
    TextView txt_name;
    TextView txt_pass1;
    TextView txt_pass2;
    TextView txt_phone;
    TextView txt_state;
    TextView txt_terms;
    TextView txt_zip;
    UserAddress userAddress;
    /* access modifiers changed from: private */
    public String whmcs_clientid;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C2344R.layout.order);
        this.sku = getIntent().getExtras().getString(Prop.EXTRA_SKU);
        this.product_name = this.sku;
        this.prefs = new ObscuredSharedPreferences(this, getSharedPreferences("myip.cfg", 0));
        this.accountName = this.prefs.getString("accountName", (String) null);
        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        bindService(serviceIntent, this.mServiceConn, 1);
        this.mProgressDialog = initializeProgressDialog();
        this.etName = (EditText) findViewById(C2344R.C2346id.et_name);
        this.etUser = (EditText) findViewById(C2344R.C2346id.et_user);
        this.etPass1 = (EditText) findViewById(C2344R.C2346id.et_pass1);
        this.etPass2 = (EditText) findViewById(C2344R.C2346id.et_pass2);
        this.etAdd1 = (EditText) findViewById(C2344R.C2346id.et_add1);
        this.etAdd2 = (EditText) findViewById(C2344R.C2346id.et_add2);
        this.etCity = (EditText) findViewById(C2344R.C2346id.et_city);
        this.etState = (EditText) findViewById(C2344R.C2346id.et_state);
        this.etZip = (EditText) findViewById(C2344R.C2346id.et_zip);
        this.etPhone = (EditText) findViewById(C2344R.C2346id.et_phone);
        this.spCountry = (Spinner) findViewById(C2344R.C2346id.sp_country);
        this.txt_name = (TextView) findViewById(C2344R.C2346id.txt_name);
        this.txt_pass1 = (TextView) findViewById(C2344R.C2346id.txt_pass1);
        this.txt_pass2 = (TextView) findViewById(C2344R.C2346id.txt_pass2);
        this.txt_add1 = (TextView) findViewById(C2344R.C2346id.txt_add1);
        this.txt_city = (TextView) findViewById(C2344R.C2346id.txt_city);
        this.txt_state = (TextView) findViewById(C2344R.C2346id.txt_state);
        this.txt_zip = (TextView) findViewById(C2344R.C2346id.txt_zip);
        this.txt_phone = (TextView) findViewById(C2344R.C2346id.txt_phone);
        this.txt_country = (TextView) findViewById(C2344R.C2346id.txt_country);
        this.txt_terms = (TextView) findViewById(C2344R.C2346id.txt_terms);
        this.txt_terms.setText(Html.fromHtml(getString(C2344R.string.terms)));
        Linkify.addLinks(this.txt_terms, 15);
        this.txt_terms.setMovementMethod(LinkMovementMethod.getInstance());
        this.etTerms = (CheckBox) findViewById(C2344R.C2346id.et_terms);
        this.etUser.setEnabled(false);
        this.spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String[] codes = OrderActivity.this.getResources().getStringArray(C2344R.array.country_codes);
                OrderActivity.this.chosenCountry = OrderActivity.this.spCountry.getSelectedItem().toString();
                OrderActivity.this.chosenCountryCode = codes[position];
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.prefs = new ObscuredSharedPreferences(this, getSharedPreferences("myip.cfg", 0));
        this.accountName = this.prefs.getString("accountName", (String) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.mService != null) {
            unbindService(this.mServiceConn);
        }
    }

    private boolean isFormValid() {
        if (!this.etName.getText().toString().trim().equalsIgnoreCase("") && !this.etAdd1.getText().toString().trim().equalsIgnoreCase("") && !this.etCity.getText().toString().trim().equalsIgnoreCase("") && !this.etState.getText().toString().trim().equalsIgnoreCase("") && !this.etZip.getText().toString().trim().equalsIgnoreCase("") && !this.etPhone.getText().toString().trim().equalsIgnoreCase("") && this.etTerms.isChecked()) {
            return true;
        }
        return false;
    }

    public void onSubmit(View view) {
        if (isFormValid()) {
            RegisterMyIP(this.accountName, this.etName.getText().toString(), this.etAdd1.getText().toString(), this.etAdd2.getText().toString(), this.etCity.getText().toString(), this.etState.getText().toString(), this.etZip.getText().toString(), this.etPhone.getText().toString(), this.chosenCountry, this.chosenCountryCode, this.etPass1.getText().toString(), this.etPass2.getText().toString());
            return;
        }
        Toast.makeText(this, "Please fill all the fields", 0).show();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (this.accountName == null) {
            this.accountManager = AccountManager.get(this);
            startActivityForResult(AccountPicker.newChooseAccountIntent((Account) null, (ArrayList<Account>) null, new String[]{GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE}, false, (String) null, (String) null, (String[]) null, (Bundle) null), 3);
            return;
        }
        this.etUser.setText(this.accountName);
        ShowDialogProduct();
    }

    private ProgressDialog initializeProgressDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setMessage("Loading...");
        return dialog;
    }

    private ProgressDialog initializeRegisterDialog(String msg) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setMessage(msg.toString());
        return dialog;
    }

    /* access modifiers changed from: private */
    public void resolveConnection() {
        try {
            if (this.mConnectionResult == null || !this.mConnectionResult.hasResolution()) {
                this.mGoogleApiClient.connect();
            } else {
                this.mConnectionResult.startResolutionForResult(this, REQUEST_CODE_RESOLVE_ERR);
            }
        } catch (IntentSender.SendIntentException e) {
            this.mConnectionResult = null;
            this.mGoogleApiClient.connect();
        }
    }

    /* access modifiers changed from: private */
    public void lookupAddress() {
        if (this.mGoogleApiClient.isConnected()) {
            showProgressDialog();
            Address.requestUserAddress(this.mGoogleApiClient, UserAddressRequest.newBuilder().build(), REQUEST_CODE_RESOLVE_ADDRESS_LOOKUP);
            return;
        }
        if (!this.mGoogleApiClient.isConnecting()) {
            this.mGoogleApiClient.connect();
        }
        this.mPromoWasSelected = true;
    }

    private void showProgressDialog() {
        if (this.mProgressDialog != null && !this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
    }

    private void dismissProgressDialog() {
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VPN_REQUEST_CODE) {
            if (data.getIntExtra("found", 0) == 0) {
                show_dialog("Error", "\nCan not import profile in VpnRoot !\n");
            } else {
                show_dialog("Info", "\nProfile imported in VpnRoot !\n");
            }
            show_configure_dialog();
        }
        if (requestCode == OPENVPN_REQUEST_CODE) {
            show_dialog("Info", "\nProfile imported in OpenVPN !\n");
            show_configure_dialog();
        }
        switch (requestCode) {
            case 3:
                this.accountName = data.getStringExtra("authAccount");
                Account[] accountsByType = this.accountManager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
                int length = accountsByType.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Account account = accountsByType[i];
                        if (account.name.equals(this.accountName)) {
                            Account userAccount = account;
                        } else {
                            i++;
                        }
                    }
                }
                if (this.accountName != null && !this.accountName.isEmpty()) {
                    this.prefs.edit().putString("accountName", this.accountName).commit();
                    this.etUser.setText(this.accountName);
                    ShowDialogProduct();
                    break;
                } else {
                    show_dialog("Error", "No Google Account Found !");
                    break;
                }
                break;
            case 1001:
                for (String key : data.getExtras().keySet()) {
                    data.getExtras().get(key);
                }
                int intExtra = data.getIntExtra("RESPONSE_CODE", 0);
                String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
                String stringExtra = data.getStringExtra("INAPP_DATA_SIGNATURE");
                if (resultCode != -1) {
                    return;
                }
                if (purchaseData != null) {
                    try {
                        JSONObject jo = new JSONObject(purchaseData);
                        Log.i(TAG, "MYIP_ORDER_INFO=" + purchaseData);
                        String purchase_time = jo.getString("purchaseTime");
                        String token = jo.getString("purchaseToken");
                        String orderId = "notfound";
                        if (purchaseData.contains("orderId")) {
                            orderId = jo.getString("orderId");
                        }
                        OrderMyIP(this.accountName, this.gapi_clientid, this.whmcs_clientid, this.sku, this.location, orderId, purchase_time, token);
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                } else {
                    Toast.makeText(this, "Purchase Data Null", 0).show();
                    return;
                }
            case REQUEST_CODE_RESOLVE_ADDRESS_LOOKUP /*1006*/:
                dismissProgressDialog();
                this.mPromoWasSelected = false;
                switch (resultCode) {
                    case -1:
                        this.userAddress = UserAddress.fromIntent(data);
                        preFillForm(this.userAddress);
                        return;
                    case 0:
                        return;
                    default:
                        Toast.makeText(this, "No Address", 1).show();
                        return;
                }
            case REQUEST_CODE_RESOLVE_ERR /*1007*/:
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                dismissProgressDialog();
                return;
        }
        this.mGoogleApiClient.connect();
    }

    private void preFillForm(UserAddress userAdd) {
        if (isValid(userAdd.getName())) {
            this.etName.setText(userAdd.getName());
            this.etName.setEnabled(false);
        } else {
            this.txt_name.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        if (isValid(userAdd.getAddress1())) {
            this.etAdd1.setText(userAdd.getAddress1());
            this.etAdd1.setEnabled(false);
        } else {
            this.txt_add1.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        if (isValid(userAdd.getAddress2())) {
            this.etAdd2.setText(userAdd.getAddress2());
            this.etAdd2.setEnabled(false);
        }
        if (isValid(userAdd.getLocality())) {
            this.etCity.setText(userAdd.getLocality());
            this.etCity.setEnabled(false);
        } else {
            this.txt_city.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        if (isValid(userAdd.getAdministrativeArea())) {
            this.etState.setText(userAdd.getAdministrativeArea());
            this.etState.setEnabled(false);
        } else {
            this.txt_state.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        if (isValid(userAdd.getPostalCode())) {
            this.etZip.setText(userAdd.getPostalCode());
            this.etZip.setEnabled(false);
        } else {
            this.txt_zip.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        if (isValid(userAdd.getPhoneNumber())) {
            this.etPhone.setText(userAdd.getPhoneNumber());
            this.etPhone.setEnabled(false);
        } else {
            this.txt_phone.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        if (isValid(userAdd.getCountryCode())) {
            this.spCountry.setSelection(((ArrayAdapter) this.spCountry.getAdapter()).getPosition(new Locale("", userAdd.getCountryCode()).getDisplayCountry()));
            this.spCountry.setEnabled(false);
        } else {
            this.txt_country.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        if (!this.etTerms.isChecked()) {
            this.txt_terms.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            this.txt_terms.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (((LinearLayout) findViewById(C2344R.C2346id.linearlayoutPass1)).isShown()) {
            this.txt_pass1.setTextColor(SupportMenu.CATEGORY_MASK);
            this.txt_pass2.setTextColor(SupportMenu.CATEGORY_MASK);
        }
    }

    private static String formatUsAddress(UserAddress address) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        if (appendIfValid(address.getName(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getEmailAddress(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getAddress1(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getAddress2(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getAddress3(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getAddress4(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getAddress5(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getLocality(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getAdministrativeArea(), builder)) {
            builder.append(", ");
        }
        if (appendIfValid(address.getPostalCode(), builder)) {
            builder.append(", ");
        }
        appendIfValid(address.getCountryCode(), builder);
        return builder.toString();
    }

    private static boolean appendIfValid(String string, StringBuilder builder) {
        if (string == null || string.length() <= 0) {
            return false;
        }
        builder.append(string);
        return true;
    }

    private static boolean isValid(String string) {
        if (string == null || string.length() <= 0) {
            return false;
        }
        return true;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.mConnectionResult = result;
        if (this.mPromoWasSelected) {
            resolveConnection();
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.mPromoWasSelected) {
            lookupAddress();
        }
    }

    public void onConnectionSuspended(int cause) {
    }

    public void RegisterMyIP(String email, String name, String addr1, String addr2, String city, String state, String zip, String phone, String country, String country_code, String pass1, String pass2) {
        this.gapi_clientid = null;
        this.whmcs_clientid = null;
        if (!pass1.equals(pass2)) {
            show_dialog("Error", "Password don't match !");
            return;
        }
        this.mProgressDialog = initializeRegisterDialog("Registering on myIP.io...");
        this.mProgressDialog.show();
        mCrypt mcrypt = new mCrypt();
        String[] strArr = new String[6];
        final List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("action", "register"));
        try {
            params.add(new BasicNameValuePair("email", mCrypt.bytesToHex(mcrypt.encrypt(email))));
            params.add(new BasicNameValuePair("name", mCrypt.bytesToHex(mcrypt.encrypt(name))));
            params.add(new BasicNameValuePair("addr1", mCrypt.bytesToHex(mcrypt.encrypt(addr1))));
            params.add(new BasicNameValuePair("addr2", mCrypt.bytesToHex(mcrypt.encrypt(addr2))));
            params.add(new BasicNameValuePair("city", mCrypt.bytesToHex(mcrypt.encrypt(city))));
            params.add(new BasicNameValuePair("state", mCrypt.bytesToHex(mcrypt.encrypt(state))));
            params.add(new BasicNameValuePair("zip", mCrypt.bytesToHex(mcrypt.encrypt(zip))));
            params.add(new BasicNameValuePair("phone", mCrypt.bytesToHex(mcrypt.encrypt(phone))));
            params.add(new BasicNameValuePair("country", mCrypt.bytesToHex(mcrypt.encrypt(country))));
            params.add(new BasicNameValuePair("country_code", mCrypt.bytesToHex(mcrypt.encrypt(country_code))));
            params.add(new BasicNameValuePair("pass1", mCrypt.bytesToHex(mcrypt.encrypt(pass1))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AsyncTask<String, Void, String>() {
            String out;

            /* access modifiers changed from: protected */
            public String doInBackground(String... params2) {
                this.out = Utils.notifyWeb(params);
                return "";
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String out_web) {
                if (OrderActivity.this.mProgressDialog != null && OrderActivity.this.mProgressDialog.isShowing()) {
                    OrderActivity.this.mProgressDialog.dismiss();
                }
                try {
                    this.out = new String(new mCrypt().decrypt(this.out));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String[] tmp = this.out.split("\n");
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].contains("error")) {
                        OrderActivity.this.show_dialog("Error", tmp[i].split(":")[1].toString());
                    }
                    if (tmp[i].contains("gapi_clientid")) {
                        String unused = OrderActivity.this.gapi_clientid = tmp[i].split(":")[1].toString();
                    }
                    if (tmp[i].contains("whmcs_clientid")) {
                        String unused2 = OrderActivity.this.whmcs_clientid = tmp[i].split(":")[1].toString();
                    }
                    if (!(OrderActivity.this.gapi_clientid == null || OrderActivity.this.whmcs_clientid == null)) {
                        try {
                            Integer num = 0;
                            Integer num2 = 0;
                            Integer num3 = 0;
                            OrderActivity.this.startIntentSenderForResult(((PendingIntent) OrderActivity.this.mService.getBuyIntent(3, OrderActivity.this.getPackageName(), OrderActivity.this.sku, "subs", "").getParcelable("BUY_INTENT")).getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        } catch (IntentSender.SendIntentException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null, null, null});
    }

    public void OrderMyIP(String email, String gapi_clientid2, String whmcs_clientid2, String sku2, String location2, String order_id, String purchase_time, String token) {
        this.mProgressDialog = initializeRegisterDialog("Configure services on myIP.io...");
        this.mProgressDialog.show();
        mCrypt mcrypt = new mCrypt();
        String[] strArr = new String[6];
        final List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("action", "order"));
        try {
            params.add(new BasicNameValuePair("email", mCrypt.bytesToHex(mcrypt.encrypt(email))));
            params.add(new BasicNameValuePair("gapi_clientid", mCrypt.bytesToHex(mcrypt.encrypt(gapi_clientid2))));
            params.add(new BasicNameValuePair("whmcs_clientid", mCrypt.bytesToHex(mcrypt.encrypt(whmcs_clientid2))));
            params.add(new BasicNameValuePair(Prop.EXTRA_SKU, mCrypt.bytesToHex(mcrypt.encrypt(sku2))));
            params.add(new BasicNameValuePair("location", mCrypt.bytesToHex(mcrypt.encrypt(location2))));
            params.add(new BasicNameValuePair("order_id", mCrypt.bytesToHex(mcrypt.encrypt(order_id))));
            params.add(new BasicNameValuePair("purchase_time", mCrypt.bytesToHex(mcrypt.encrypt(purchase_time))));
            params.add(new BasicNameValuePair("token", mCrypt.bytesToHex(mcrypt.encrypt(token))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AsyncTask<String, Void, String>() {
            String out;

            /* access modifiers changed from: protected */
            public String doInBackground(String... params2) {
                this.out = Utils.notifyWeb(params);
                return "";
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String out_web) {
                if (OrderActivity.this.mProgressDialog != null && OrderActivity.this.mProgressDialog.isShowing()) {
                    OrderActivity.this.mProgressDialog.dismiss();
                }
                try {
                    this.out = new String(new mCrypt().decrypt(this.out));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String[] tmp = this.out.split("\n");
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].contains("error")) {
                        OrderActivity.this.show_dialog("Error", tmp[i].split(":")[1].toString());
                    }
                    if (tmp[i].contains("Hostname")) {
                        String unused = OrderActivity.this.config_hostname = tmp[i].split(":")[1].toString();
                    }
                    if (tmp[i].contains("ipv4")) {
                        String unused2 = OrderActivity.this.config_ipv4 = tmp[i].split(":")[1].toString();
                    }
                }
                if (OrderActivity.this.config_hostname == null || OrderActivity.this.config_ipv4 == null) {
                    OrderActivity.this.show_dialog("Error", "Error activating service, please conntact support@myip.io !");
                } else {
                    OrderActivity.this.show_configure_dialog();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null, null, null});
    }

    public void CheckUser(String email) {
        this.mProgressDialog = initializeRegisterDialog("Checking account on myIP.io...");
        this.mProgressDialog.show();
        mCrypt mcrypt = new mCrypt();
        String[] strArr = new String[6];
        final List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("action", "checkuser"));
        try {
            params.add(new BasicNameValuePair("email", mCrypt.bytesToHex(mcrypt.encrypt(email))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AsyncTask<String, Void, String>() {
            String out;

            /* access modifiers changed from: protected */
            public String doInBackground(String... params2) {
                this.out = Utils.notifyWeb(params);
                return "";
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String out_web) {
                if (OrderActivity.this.mProgressDialog != null && OrderActivity.this.mProgressDialog.isShowing()) {
                    OrderActivity.this.mProgressDialog.dismiss();
                }
                try {
                    this.out = new String(new mCrypt().decrypt(this.out));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String[] tmp = this.out.split("\n");
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].contains("whmcs_clientid")) {
                        String unused = OrderActivity.this.whmcs_clientid = tmp[i].split(":")[1].toString();
                    }
                }
                if (OrderActivity.this.whmcs_clientid.equals("0")) {
                    ((LinearLayout) OrderActivity.this.findViewById(C2344R.C2346id.linearlayoutPass1)).setVisibility(0);
                    ((LinearLayout) OrderActivity.this.findViewById(C2344R.C2346id.linearlayoutPass2)).setVisibility(0);
                } else {
                    ((LinearLayout) OrderActivity.this.findViewById(C2344R.C2346id.linearlayoutPass1)).setVisibility(8);
                    ((LinearLayout) OrderActivity.this.findViewById(C2344R.C2346id.linearlayoutPass2)).setVisibility(8);
                }
                if (OrderActivity.this.mConnectionResult != null) {
                    OrderActivity.this.resolveConnection();
                } else {
                    OrderActivity.this.lookupAddress();
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null, null, null});
    }

    public void show_dialog(String title, String message) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(message).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setIcon(17301543).show();
    }

    public void show_configure_dialog() {
        configure_vpn(this.product_name, this.config_hostname, this.config_ipv4, this.accountName);
    }

    public void configure_vpn(String product_name2, String hostname, String ipv4, String username) {
        new AlertDialog.Builder(this);
        ((TextView) new AlertDialog.Builder(this).setMessage("\t\tYour product " + product_name2.toString() + " will be available in a few minutes.\n" + "\n" + "\t\tTo import VPN profile use the Services TAB.").setTitle("Info").setIcon(17301543).setNegativeButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                OrderActivity.this.finish();
            }
        }).show().findViewById(16908299)).setTextSize(15.0f);
    }

    public void ShowDialogProduct() {
        this.mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Address.API, new Address.AddressOptions(1)).addConnectionCallbacks(this).setAccountName(this.accountName).addOnConnectionFailedListener(this).build();
        View dialoglayout = getLayoutInflater().inflate(C2344R.layout.product, (ViewGroup) null);
        this.etProd1 = (TextView) dialoglayout.findViewById(C2344R.C2346id.et_product1);
        this.etProd2 = (TextView) dialoglayout.findViewById(C2344R.C2346id.et_product2);
        this.radio_location_1 = (RadioButton) dialoglayout.findViewById(C2344R.C2346id.radio_location_1);
        this.radio_location_2 = (RadioButton) dialoglayout.findViewById(C2344R.C2346id.radio_location_2);
        LinearLayout ll1 = (LinearLayout) dialoglayout.findViewById(C2344R.C2346id.lynear_location_1);
        LinearLayout ll2 = (LinearLayout) dialoglayout.findViewById(C2344R.C2346id.lynear_location_2);
        ll1.setVisibility(8);
        ll2.setVisibility(8);
        this.radio_billing_1 = (RadioButton) dialoglayout.findViewById(C2344R.C2346id.radio_billing_1);
        this.radio_billing_2 = (RadioButton) dialoglayout.findViewById(C2344R.C2346id.radio_billing_2);
        this.location = "1";
        this.billing = "2";
        this.radio_location_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    OrderActivity.this.radio_location_2.setChecked(false);
                    OrderActivity.this.location = "1";
                }
            }
        });
        this.radio_location_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    OrderActivity.this.radio_location_1.setChecked(false);
                    OrderActivity.this.location = "2";
                }
            }
        });
        this.radio_billing_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    OrderActivity.this.radio_billing_2.setChecked(false);
                    OrderActivity.this.billing = "1";
                }
            }
        });
        this.radio_billing_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    OrderActivity.this.radio_billing_1.setChecked(false);
                    OrderActivity.this.billing = "2";
                }
            }
        });
        this.product_name = this.sku;
        if (this.sku.equals("Dedicated VPN")) {
            this.etProd2.setVisibility(0);
            ll1.setVisibility(0);
            ll2.setVisibility(0);
            this.radio_billing_1.setText("7.99$/month\n(billed monthly)");
            this.radio_billing_2.setText("$5.99/month\n(billed 1 time $71.88)");
        }
        if (this.sku.equals("Personal VPN")) {
            this.etProd1.setVisibility(0);
            this.radio_billing_1.setText("2.99$/month\n(billed monthly)");
            this.radio_billing_2.setText("$2.49/month\n(billed 1 time $29.88)");
        }
        final Dialog builder = new Dialog(this);
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode != 4 || event.getAction() != 1 || event.isCanceled()) {
                    return false;
                }
                OrderActivity.this.finish();
                return true;
            }
        });
        builder.setContentView(dialoglayout);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        builder.findViewById(builder.getContext().getResources().getIdentifier("android:id/titleDivider", (String) null, (String) null)).setBackgroundColor(0);
        ((Button) dialoglayout.findViewById(C2344R.C2346id.btn_purchase)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder.dismiss();
                if (OrderActivity.this.sku.equals("Personal VPN")) {
                    if (OrderActivity.this.billing.equals("1")) {
                        OrderActivity.this.sku = "com.myip.vpnroot.share.m";
                    } else {
                        OrderActivity.this.sku = "com.myip.vpnroot.shared.y";
                    }
                }
                if (OrderActivity.this.location.equals("1") && OrderActivity.this.sku.equals("Dedicated VPN")) {
                    if (OrderActivity.this.billing.equals("1")) {
                        OrderActivity.this.sku = "com.myip.vpnroot.1.m";
                    }
                    if (OrderActivity.this.billing.equals("2")) {
                        OrderActivity.this.sku = "com.myip.vpnroot.1.y";
                    }
                }
                if (OrderActivity.this.location.equals("2") && OrderActivity.this.sku.equals("Dedicated VPN")) {
                    if (OrderActivity.this.billing.equals("1")) {
                        OrderActivity.this.sku = "com.myip.vpnroot.1.eu.m";
                    }
                    if (OrderActivity.this.billing.equals("2")) {
                        OrderActivity.this.sku = "com.myip.vpnroot.1.eu.y";
                    }
                }
                OrderActivity.this.CheckUser(OrderActivity.this.accountName);
            }
        });
        ((Button) dialoglayout.findViewById(C2344R.C2346id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OrderActivity.this.finish();
            }
        });
        builder.show();
    }

    public void GetProfile(final String ipv4, String email) {
        this.mProgressDialog = initializeRegisterDialog("Getting Profile from myIP.io...");
        this.mProgressDialog.show();
        mCrypt mcrypt = new mCrypt();
        String[] strArr = new String[6];
        final List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("action", "getprofile"));
        try {
            params.add(new BasicNameValuePair("email", mCrypt.bytesToHex(mcrypt.encrypt(email))));
            params.add(new BasicNameValuePair("ipv4", mCrypt.bytesToHex(mcrypt.encrypt(ipv4))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AsyncTask<String, Void, String>() {
            String out;

            /* access modifiers changed from: protected */
            public String doInBackground(String... params2) {
                this.out = Utils.notifyWeb(params);
                return "";
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String out_web) {
                if (OrderActivity.this.mProgressDialog != null && OrderActivity.this.mProgressDialog.isShowing()) {
                    OrderActivity.this.mProgressDialog.dismiss();
                }
                try {
                    this.out = new String(new mCrypt().decrypt(this.out));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                StringBuffer temp_file = new StringBuffer();
                String[] tmp = this.out.split("\n");
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].contains("error")) {
                        OrderActivity.this.show_dialog("Error", tmp[i].split("\\|")[1].toString());
                    } else {
                        temp_file.append(tmp[i] + "\n");
                    }
                }
                File myIPDirectory = new File("/sdcard/myip/");
                myIPDirectory.mkdirs();
                try {
                    try {
                        new FileOutputStream(new File(myIPDirectory, ipv4 + ".ovpn")).write(temp_file.toString().getBytes());
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse("file:///sdcard/myip/" + ipv4 + ".ovpn"), "application/x-openvpn-profile");
                OrderActivity.this.startActivityForResult(intent, OrderActivity.OPENVPN_REQUEST_CODE);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null, null, null});
    }

    public boolean isPackageExisted(String targetPackage) {
        for (ApplicationInfo packageInfo : getPackageManager().getInstalledApplications(0)) {
            if (packageInfo.packageName.equals(targetPackage)) {
                return true;
            }
        }
        return false;
    }
}
