package com.tapcrowd.app.modules;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.actionbarsherlock.app.ActionBar;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCActivity;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Internet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import twitter4j.conf.PropertyConfiguration;

public class Register extends TCActivity {
    ViewGroup container;
    HashMap<String, EditText> fields = new HashMap<>();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        setContentView((int) C0846R.layout.conference_bag_layout);
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        String color = Integer.toHexString(C1216LO.getLo(C1216LO.navigationColor));
        if (color.length() == 8) {
            color = color.substring(2);
        }
        ab.setDisplayShowTitleEnabled(true);
        ab.setTitle((CharSequence) Html.fromHtml("<font color='#" + color + "'>Register</font>"));
        if (C1216LO.getLoDrawable(C1216LO.navbar) != null) {
            ab.setBackgroundDrawable(new BitmapDrawable(getResources(), ((BitmapDrawable) C1216LO.getLoDrawable(C1216LO.navbar)).getBitmap()));
        } else {
            ab.setBackgroundDrawable(new ColorDrawable(C1216LO.getLo(C1216LO.titleBackgroundColor)));
        }
        this.container = (ViewGroup) findViewById(C0846R.C0847id.container);
        Button submitbutton = (Button) findViewById(C0846R.C0847id.submit);
        submitbutton.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
        submitbutton.setText("Submit".toUpperCase());
        submitbutton.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        ((Button) findViewById(C0846R.C0847id.register)).setVisibility(8);
        addTextField("Login Name", "loginname", 1);
        addTextField("Password", PropertyConfiguration.PASSWORD, 129);
        addTextField("Name", DBFavorites.KEY_NAME, 1);
        addTextField("First Name", "firstname", 1);
        addTextField("Company", "company", 1);
        addTextField("Function", "function", 1);
        addTextField("Email", "email", 1);
        addTextField("Phone", "phone", 3);
    }

    public void submit(View v) {
        new registerTask().execute(new Void[0]);
    }

    public class registerTask extends AsyncTask<Void, Void, Boolean> {
        String company;
        String country;
        String email;
        String firstname;
        String function;
        String loginname;
        String name;

        /* renamed from: ok */
        boolean f2009ok = true;
        String password;
        String phone;

        public registerTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.loginname = Register.this.fields.get("loginname").getText().toString();
            this.password = Register.this.fields.get(PropertyConfiguration.PASSWORD).getText().toString();
            this.name = Register.this.fields.get(DBFavorites.KEY_NAME).getText().toString();
            this.firstname = Register.this.fields.get("firstname").getText().toString();
            this.company = Register.this.fields.get("company").getText().toString();
            this.email = Register.this.fields.get("email").getText().toString();
            this.phone = Register.this.fields.get("phone").getText().toString();
            if (this.loginname.equals("")) {
                Register.this.show("Please insert user name.");
                this.f2009ok = false;
            } else if (this.password.equals("")) {
                Register.this.show("Please insert password.");
                this.f2009ok = false;
            } else if (this.name.equals("") || this.firstname.equals("")) {
                Register.this.show("Please complete name.");
                this.f2009ok = false;
            } else if (!Register.this.isValidEmail(this.email)) {
                Register.this.show("Please insert valid email.");
                this.f2009ok = false;
            }
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            String response = "";
            if (this.f2009ok) {
                String passsalt = Converter.md5(String.valueOf(this.password) + "wvcV23efGead!(va$43");
                List<NameValuePair> postparams = new ArrayList<>();
                postparams.add(new BasicNameValuePair("appid", App.f2123id));
                postparams.add(new BasicNameValuePair("username", String.valueOf(this.firstname) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.name));
                postparams.add(new BasicNameValuePair("userlogin", this.loginname));
                postparams.add(new BasicNameValuePair("userpassword", passsalt));
                postparams.add(new BasicNameValuePair("useremail", this.email));
                postparams.add(new BasicNameValuePair("attendeename", this.name));
                postparams.add(new BasicNameValuePair("attendeefirstname", this.firstname));
                postparams.add(new BasicNameValuePair("attendeecompany", this.company));
                postparams.add(new BasicNameValuePair("attendeefunction", this.function));
                postparams.add(new BasicNameValuePair("attendeephonenr", this.phone));
                response = Internet.request("registerUser", postparams);
            }
            return Boolean.valueOf(response.contains("succes"));
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean result) {
            if (result.booleanValue()) {
                new AlertDialog.Builder(Register.this).setMessage("You have been registered.").setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent data = new Intent();
                        data.putExtra("login", registerTask.this.loginname);
                        data.putExtra(PropertyConfiguration.PASSWORD, registerTask.this.password);
                        Register.this.setResult(-1, data);
                        Register.this.finish();
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        Intent data = new Intent();
                        data.putExtra("login", registerTask.this.loginname);
                        data.putExtra(PropertyConfiguration.PASSWORD, registerTask.this.password);
                        Register.this.setResult(-1, data);
                        Register.this.finish();
                    }
                }).show();
            } else {
                new AlertDialog.Builder(Register.this).setMessage("An error has occured while registering, please try again later.").setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
            }
            super.onPostExecute(result);
        }
    }

    public void addTextField(String hint, String name, int inputtype) {
        FormEditText fet = new FormEditText(this, hint);
        fet.setInputType(inputtype);
        this.container.addView(fet);
        this.fields.put(name, fet);
    }

    private class FormEditText extends EditText {
        public FormEditText(Context context, String hint) {
            super(context);
            setHint(hint);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, (int) Converter.convertDpToPixel(40.0f, context));
            lp.setMargins(0, 0, 0, (int) Converter.convertDpToPixel(10.0f, Register.this));
            setLayoutParams(lp);
            GradientDrawable bg = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, -1});
            bg.setStroke((int) Converter.convertDpToPixel(2.0f, context), Color.parseColor("#e3e3e3"));
            setBackgroundDrawable(bg);
        }
    }

    public void show(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(message);
        dialog.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        dialog.show();
    }

    public boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
