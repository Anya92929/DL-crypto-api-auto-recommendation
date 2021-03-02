package com.tapcrowd.app.modules.launcher;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.service.UpdateService;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.Converter;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.UserModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import twitter4j.conf.PropertyConfiguration;

public class RegisterFragment extends TCFragment implements View.OnClickListener {
    private ViewGroup container;
    /* access modifiers changed from: private */
    public HashMap<String, EditText> fields = new HashMap<>();
    private boolean retained;
    private registerTask task;

    /* renamed from: v */
    private View f2058v;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container2, Bundle savedInstanceState) {
        if (this.f2058v == null) {
            this.f2058v = inflater.inflate(C0846R.layout.conference_bag_layout, container2, false);
        } else {
            ((ViewGroup) this.f2058v.getParent()).removeView(this.f2058v);
            this.retained = true;
        }
        return this.f2058v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            this.container = (ViewGroup) this.f2058v.findViewById(C0846R.C0847id.container);
            Button submitbutton = (Button) this.f2058v.findViewById(C0846R.C0847id.submit);
            submitbutton.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
            submitbutton.setText("Submit".toUpperCase());
            submitbutton.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
            submitbutton.setOnClickListener(this);
            ((Button) this.f2058v.findViewById(C0846R.C0847id.register)).setVisibility(8);
            addTextField("Login Name / Email", "loginname", 1);
            addTextField("Password", PropertyConfiguration.PASSWORD, 129);
            addTextField("Confirm Password", "passwordconf", 129);
            addTextField("Name", DBFavorites.KEY_NAME, 1);
            addTextField("First Name", "firstname", 1);
        }
    }

    public void addTextField(String hint, String name, int inputtype) {
        FormEditText fet = new FormEditText(getActivity(), hint);
        fet.setInputType(inputtype);
        this.container.addView(fet);
        this.fields.put(name, fet);
    }

    private class FormEditText extends EditText {
        public FormEditText(Context context, String hint) {
            super(context);
            setHint(hint);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, (int) Converter.convertDpToPixel(40.0f, context));
            lp.setMargins(0, 0, 0, (int) Converter.convertDpToPixel(10.0f, RegisterFragment.this.getActivity()));
            setLayoutParams(lp);
            GradientDrawable bg = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1, -1});
            bg.setStroke((int) Converter.convertDpToPixel(2.0f, context), Color.parseColor("#e3e3e3"));
            setBackgroundDrawable(bg);
        }
    }

    public void onClick(View v) {
        if (this.task == null || this.task.getStatus() != AsyncTask.Status.RUNNING) {
            this.task = new registerTask();
            this.task.execute(new Void[0]);
        }
    }

    public class registerTask extends AsyncTask<Void, Void, Boolean> {
        String company;
        String country;
        ProgressDialog dialog;
        String email;
        String firstname;
        String function;
        String loginname;
        String name;

        /* renamed from: ok */
        boolean f2059ok = true;
        String password;
        String passwordconf;
        String phone;

        public registerTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.dialog = new ProgressDialog(RegisterFragment.this.getActivity());
            this.dialog.setMessage(RegisterFragment.this.getActivity().getString(C0846R.string.loading));
            this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    registerTask.this.cancel(true);
                }
            });
            this.dialog.show();
            this.loginname = ((EditText) RegisterFragment.this.fields.get("loginname")).getText().toString();
            this.password = ((EditText) RegisterFragment.this.fields.get(PropertyConfiguration.PASSWORD)).getText().toString();
            this.passwordconf = ((EditText) RegisterFragment.this.fields.get("passwordconf")).getText().toString();
            this.name = ((EditText) RegisterFragment.this.fields.get(DBFavorites.KEY_NAME)).getText().toString();
            this.firstname = ((EditText) RegisterFragment.this.fields.get("firstname")).getText().toString();
            if (!this.password.equals(this.passwordconf)) {
                RegisterFragment.this.show("Your passwords do not match.");
                this.f2059ok = false;
            } else if (this.loginname.equals("")) {
                RegisterFragment.this.show("Please insert user name.");
                this.f2059ok = false;
            } else if (this.password.equals("")) {
                RegisterFragment.this.show("Please insert password.");
                this.f2059ok = false;
            } else if (this.name.equals("") || this.firstname.equals("")) {
                RegisterFragment.this.show("Please complete name.");
                this.f2059ok = false;
            }
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            String response = "";
            if (this.f2059ok) {
                String passsalt = Converter.md5(String.valueOf(this.password) + "wvcV23efGead!(va$43");
                List<NameValuePair> postparams = new ArrayList<>();
                postparams.add(new BasicNameValuePair("appid", App.f2123id));
                postparams.add(new BasicNameValuePair("username", String.valueOf(this.firstname) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.name));
                postparams.add(new BasicNameValuePair("userlogin", this.loginname));
                postparams.add(new BasicNameValuePair("userpassword", passsalt));
                postparams.add(new BasicNameValuePair("attendeeeventid", C1199DB.getFirstObject("events").get(DBFavorites.KEY_EVENT_ID)));
                postparams.add(new BasicNameValuePair("attendeename", this.name));
                postparams.add(new BasicNameValuePair("attendeefirstname", this.firstname));
                postparams.add(new BasicNameValuePair("userparenttype", "launcher"));
                postparams.add(new BasicNameValuePair("userparentid", C1199DB.getFirstObject("launchers", "moduletypeid", "14").get(DBFavorites.KEY_EVENT_ID)));
                response = Internet.request("registerUser", postparams);
            }
            return Boolean.valueOf(response.contains("succes"));
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (this.dialog != null && this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (this.f2059ok) {
                if (result.booleanValue()) {
                    new UserModule.LoginUserTask(RegisterFragment.this.getActivity(), this.loginname, this.password).execute(new Void[0]);
                    new UpdateService.GetAppTask(RegisterFragment.this.getActivity()).execute(new Void[0]);
                    new AlertDialog.Builder(RegisterFragment.this.getActivity()).setMessage("You have been registered.").setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            RegisterFragment.this.getActivity().onBackPressed();
                        }
                    }).setOnCancelListener((DialogInterface.OnCancelListener) null).show();
                    return;
                }
                new AlertDialog.Builder(RegisterFragment.this.getActivity()).setMessage("An error has occured while registering, please try again later.").setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public void show(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
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
