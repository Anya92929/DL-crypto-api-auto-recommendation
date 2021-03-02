package com.tapcrowd.app.modules.notifications;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.Superminds4060.C0846R;
import com.tapcrowd.app.TCFragment;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import com.tapcrowd.app.utils.App;
import com.tapcrowd.app.utils.C1199DB;
import com.tapcrowd.app.utils.C1216LO;
import com.tapcrowd.app.utils.C1232UI;
import com.tapcrowd.app.utils.Fragments;
import com.tapcrowd.app.utils.Internet;
import com.tapcrowd.app.utils.ItemPickerFragment;
import com.tapcrowd.app.utils.LinkedObjects;
import com.tapcrowd.app.utils.OnFragmentResultListener;
import com.tapcrowd.app.utils.TCDBHelper;
import com.tapcrowd.app.utils.TCListObject;
import com.tapcrowd.app.utils.TCObject;
import com.tapcrowd.app.utils.UserModule;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class RequestMeetingFragment extends TCFragment {
    /* access modifiers changed from: private */
    public TCObject att;
    /* access modifiers changed from: private */
    public String attendeeid;
    int day = -1;
    private View.OnClickListener etClick = new View.OnClickListener() {
        public void onClick(View v) {
            RequestMeetingFragment.this.click(v);
        }
    };
    /* access modifiers changed from: private */
    public EditText etDate;
    /* access modifiers changed from: private */
    public EditText etMeetingPoints;
    /* access modifiers changed from: private */
    public EditText etMessage;
    /* access modifiers changed from: private */
    public EditText etOtherPoints;
    /* access modifiers changed from: private */
    public EditText etTime;
    private View.OnFocusChangeListener focusChange = new View.OnFocusChangeListener() {
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                RequestMeetingFragment.this.click(v);
            }
        }
    };
    int hour = -1;
    int min = -1;
    int month = -1;
    /* access modifiers changed from: private */
    public String poiId;
    private View.OnClickListener sendMessage = new View.OnClickListener() {
        public void onClick(View v) {
            if (RequestMeetingFragment.this.year == -1 || RequestMeetingFragment.this.hour == -1 || RequestMeetingFragment.this.etMessage.getText().length() == 0 || (RequestMeetingFragment.this.etMeetingPoints.getText().length() == 0 && RequestMeetingFragment.this.etOtherPoints.length() == 0)) {
                new AlertDialog.Builder(RequestMeetingFragment.this.getActivity()).setMessage(C0846R.string.complete_form).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
            } else {
                new SendRequest(RequestMeetingFragment.this, (SendRequest) null).execute(new Void[0]);
            }
        }
    };
    private TextView tvAttendeeName;
    private TextView tvSendRequest;

    /* renamed from: tw */
    private TextWatcher f2099tw = new TextWatcher() {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (RequestMeetingFragment.this.etOtherPoints.getText().length() > 0) {
                RequestMeetingFragment.this.etMeetingPoints.setEnabled(false);
            } else {
                RequestMeetingFragment.this.etMeetingPoints.setEnabled(true);
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void afterTextChanged(Editable s) {
        }
    };
    int year = -1;

    public static RequestMeetingFragment newInstance(String attendeeid2) {
        RequestMeetingFragment fr = new RequestMeetingFragment();
        fr.attendeeid = attendeeid2;
        fr.att = C1199DB.getFirstObject(LinkedObjects.TABLE_ATT, DBFavorites.KEY_EVENT_ID, attendeeid2);
        return fr;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.f2005v == null) {
            this.f2005v = inflater.inflate(C0846R.layout.layout_request_meeting, container, false);
        } else {
            this.retained = true;
            ((ViewGroup) this.f2005v.getParent()).removeView(this.f2005v);
        }
        return this.f2005v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!this.retained) {
            initUI();
            this.tvAttendeeName.setText(this.att.get(DBFavorites.KEY_NAME));
        }
    }

    private void initUI() {
        this.tvAttendeeName = (TextView) this.f2005v.findViewById(C0846R.C0847id.attendee_name);
        this.tvSendRequest = (TextView) this.f2005v.findViewById(C0846R.C0847id.send_request);
        this.etMeetingPoints = (EditText) this.f2005v.findViewById(C0846R.C0847id.meeting_points);
        this.etOtherPoints = (EditText) this.f2005v.findViewById(C0846R.C0847id.other_points);
        this.etDate = (EditText) this.f2005v.findViewById(C0846R.C0847id.date);
        this.etTime = (EditText) this.f2005v.findViewById(C0846R.C0847id.time);
        this.etMessage = (EditText) this.f2005v.findViewById(C0846R.C0847id.message);
        this.etMeetingPoints.setClickable(true);
        this.etMeetingPoints.setInputType(0);
        this.etMeetingPoints.setOnFocusChangeListener(this.focusChange);
        this.etMeetingPoints.setOnClickListener(this.etClick);
        this.etOtherPoints.addTextChangedListener(this.f2099tw);
        this.etDate.setClickable(true);
        this.etDate.setInputType(0);
        this.etDate.setOnFocusChangeListener(this.focusChange);
        this.etDate.setOnClickListener(this.etClick);
        this.etTime.setClickable(true);
        this.etTime.setInputType(0);
        this.etTime.setOnFocusChangeListener(this.focusChange);
        this.etTime.setOnClickListener(this.etClick);
        this.etMessage.setSingleLine(false);
        this.tvAttendeeName.setTextColor(C1216LO.getLo(C1216LO.titleFontColor));
        this.tvAttendeeName.setBackgroundColor(C1216LO.getLo(C1216LO.titleBackgroundColor));
        this.tvSendRequest.setTextColor(C1216LO.getLo(C1216LO.textcolorButtons));
        this.tvSendRequest.setBackgroundColor(C1216LO.getLo(C1216LO.buttonBackgroundColor));
        this.tvSendRequest.setOnClickListener(this.sendMessage);
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (this.poiId != null) {
            this.etMeetingPoints.setText(C1199DB.getFirstObject("poi", DBFavorites.KEY_EVENT_ID, this.poiId).get(DBFavorites.KEY_NAME));
            C1232UI.getColorOverlay((int) C0846R.drawable.icon_x, C1216LO.getLo(C1216LO.buttonBackgroundColor));
            this.etMeetingPoints.setCompoundDrawablesWithIntrinsicBounds(0, 0, C0846R.drawable.icon_x, 0);
            this.etOtherPoints.setEnabled(false);
            if (this.etDate.getText().length() == 0) {
                this.etDate.requestFocus();
                return;
            }
            return;
        }
        this.etMeetingPoints.setText("");
        this.etMeetingPoints.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.etOtherPoints.setEnabled(true);
    }

    /* access modifiers changed from: private */
    public void click(View v) {
        hideIme(v);
        if (v.getId() == C0846R.C0847id.meeting_points) {
            showMeetingPoints();
        } else if (v.getId() == C0846R.C0847id.date) {
            showDate();
        } else {
            showTime();
        }
    }

    private void showMeetingPoints() {
        if (this.poiId == null) {
            Fragments.add(this, ItemPickerFragment.newInstance(new OnFragmentResultListener() {
                public void onFragmentResult(Intent data, int requestCode, int resultCode) {
                    RequestMeetingFragment.this.poiId = data.getStringExtra(DBFavorites.KEY_EVENT_ID);
                }
            }, new TCListObject.TCListObjectAdapter(TCDBHelper.getTCListFromDb("SELECT id, order_value, name FROM poi ORDER BY name", new TCDBHelper.TCListHelperObject(DBFavorites.KEY_NAME, (String) null, (String) null))), 0), getString(C0846R.string.meeting_points));
            return;
        }
        this.poiId = null;
        this.etMeetingPoints.setText("");
        this.etMeetingPoints.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.etOtherPoints.setEnabled(true);
    }

    private void showDate() {
        int i;
        int i2;
        int i3;
        Calendar cal = Calendar.getInstance();
        FragmentActivity activity = getActivity();
        C10916 r2 = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                RequestMeetingFragment.this.year = year;
                RequestMeetingFragment.this.month = monthOfYear;
                RequestMeetingFragment.this.day = dayOfMonth;
                String yearStr = String.valueOf(year);
                String yearStr2 = yearStr.substring(yearStr.length() - 2, yearStr.length());
                String monthString = String.valueOf(monthOfYear + 1);
                if (monthString.length() < 2) {
                    monthString = "0" + monthString;
                }
                RequestMeetingFragment.this.etDate.setText(String.valueOf(dayOfMonth) + "/" + monthString + "/" + yearStr2);
                if (RequestMeetingFragment.this.etTime.getText().length() == 0) {
                    RequestMeetingFragment.this.etTime.requestFocus();
                }
            }
        };
        if (this.year == -1) {
            i = cal.get(1);
        } else {
            i = this.year;
        }
        if (this.month == -1) {
            i2 = cal.get(2);
        } else {
            i2 = this.month;
        }
        if (this.day == -1) {
            i3 = cal.get(5);
        } else {
            i3 = this.day;
        }
        new DatePickerDialog(activity, r2, i, i2, i3).show();
    }

    private void showTime() {
        int i;
        int i2;
        Calendar cal = Calendar.getInstance();
        FragmentActivity activity = getActivity();
        C10927 r2 = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                RequestMeetingFragment.this.hour = hourOfDay;
                RequestMeetingFragment.this.min = minute;
                RequestMeetingFragment.this.etTime.setText(String.valueOf(hourOfDay < 10 ? "0" + hourOfDay : new StringBuilder(String.valueOf(hourOfDay)).toString()) + ":" + (minute < 10 ? "0" + minute : new StringBuilder(String.valueOf(minute)).toString()));
                if (RequestMeetingFragment.this.etMessage.getText().length() == 0) {
                    RequestMeetingFragment.this.etMessage.post(new Runnable() {
                        public void run() {
                            RequestMeetingFragment.this.etMessage.requestFocus();
                            RequestMeetingFragment.this.showIme(RequestMeetingFragment.this.etMessage);
                        }
                    });
                }
            }
        };
        if (this.hour == -1) {
            i = cal.get(11);
        } else {
            i = this.hour;
        }
        if (this.min == -1) {
            i2 = cal.get(12);
        } else {
            i2 = this.min;
        }
        new TimePickerDialog(activity, r2, i, i2, true).show();
    }

    private void hideIme(View v) {
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /* access modifiers changed from: private */
    public void showIme(View v) {
        ((InputMethodManager) getActivity().getSystemService("input_method")).showSoftInput(v, 1);
    }

    private class SendRequest extends AsyncTask<Void, Void, Void> {
        private ProgressDialog dialog;
        private String response;

        private SendRequest() {
        }

        /* synthetic */ SendRequest(RequestMeetingFragment requestMeetingFragment, SendRequest sendRequest) {
            this();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.dialog = new ProgressDialog(RequestMeetingFragment.this.getActivity());
            this.dialog.setMessage(RequestMeetingFragment.this.getString(C0846R.string.loading));
            this.dialog.setCancelable(false);
            this.dialog.show();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... params) {
            String parenttype;
            String parentid;
            if (RequestMeetingFragment.this.att.has("eventid")) {
                parenttype = "event";
                parentid = RequestMeetingFragment.this.att.get("eventid");
            } else {
                parenttype = "venue";
                parentid = RequestMeetingFragment.this.att.get("venueid");
            }
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("parenttype", parenttype));
            parameters.add(new BasicNameValuePair("parentid", parentid));
            if (RequestMeetingFragment.this.poiId != null) {
                parameters.add(new BasicNameValuePair("meetingpoiid", RequestMeetingFragment.this.poiId));
            }
            if (RequestMeetingFragment.this.etOtherPoints.getText().length() != 0) {
                parameters.add(new BasicNameValuePair("meetingpoiname", RequestMeetingFragment.this.etOtherPoints.getText().toString()));
            }
            parameters.add(new BasicNameValuePair("meetingdatetime", String.valueOf(RequestMeetingFragment.this.year) + "-" + (RequestMeetingFragment.this.month + 1) + "-" + RequestMeetingFragment.this.day + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + RequestMeetingFragment.this.hour + ":" + RequestMeetingFragment.this.min));
            parameters.add(new BasicNameValuePair("meetingconfirmed", ""));
            parameters.add(new BasicNameValuePair("appid", App.f2123id));
            parameters.add(new BasicNameValuePair("senderuserid", UserModule.getUserId(RequestMeetingFragment.this.getActivity())));
            parameters.add(new BasicNameValuePair("attendeeid", RequestMeetingFragment.this.attendeeid));
            parameters.add(new BasicNameValuePair(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, RequestMeetingFragment.this.title));
            parameters.add(new BasicNameValuePair(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, RequestMeetingFragment.this.etMessage.getText().toString()));
            this.response = Internet.request("sendMeetMeMessage", parameters);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            if (this.response.contains("SUCCES")) {
                RequestMeetingFragment.this.getActivity().onBackPressed();
            } else {
                new AlertDialog.Builder(RequestMeetingFragment.this.getActivity()).setMessage(C0846R.string.noti_error).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
            }
        }
    }
}
