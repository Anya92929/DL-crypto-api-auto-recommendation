package com.forexcrunch.forexcrunch.gui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p000v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import com.caldroid.CaldroidFragment;
import com.caldroid.CaldroidListener;
import com.forexcrunch.forexcrunch.C0089R;
import com.forexcrunch.forexcrunch.custom.FlagListAdapter;
import com.forexcrunch.forexcrunch.gui.utils.Constants;
import com.forexcrunch.forexcrunch.gui.utils.Utils;
import com.forexcrunch.forexcrunch.local.NewsController;
import com.forexcrunch.forexcrunch.model.CountryItem;
import com.forexcrunch.forexcrunch.model.FilterModel;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.lucasr.twowayview.TwoWayView;

public class FiltersActivity extends FragmentActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private CheckBox allCategories;
    private CheckBox allCountries;
    ArrayList<CountryItem> allCountriesList;
    private Button btnApplyFilters;
    private Button btnEndDate;
    private Button btnRestoreDefaults;
    private Button btnStartDate;
    private String categoriesIds = "";
    private CheckBox centralCheckBox;
    private CheckBox condifdenceCheckBox;
    private CheckBox consumpCheckBox;
    ArrayList<CountryItem> countriesList1;
    ArrayList<CountryItem> countriesList2;
    private String countryCodesList1 = "";
    private String countryCodesList2 = "";
    /* access modifiers changed from: private */
    public int currentSelectedButtonId;
    /* access modifiers changed from: private */
    public CaldroidFragment dialogCaldroidFragment;
    private CheckBox economicCheckBox;
    private CheckBox employmentCheckBox;
    /* access modifiers changed from: private */
    public Date endDate;
    private TwoWayView flagList1;
    private TwoWayView flagList2;
    /* access modifiers changed from: private */
    public SimpleDateFormat formatter;
    private CheckBox governmentCheckBox;
    /* access modifiers changed from: private */
    public boolean isShowingCalendarDialog;
    private CheckBox liquidityCheckBox;
    private CheckBox saveFilters;
    private SeekBar seekBar;
    /* access modifiers changed from: private */
    public Date startDate;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0089R.layout.filters_activity);
        initComponents();
        this.allCountriesList = Utils.createCountriesList(this);
        createCountriesLists();
        this.flagList1.setAdapter((ListAdapter) new FlagListAdapter(this, C0089R.layout.flag_item, this.countriesList1));
        this.flagList2.setAdapter((ListAdapter) new FlagListAdapter(this, C0089R.layout.flag_item, this.countriesList2));
        restoreFiltersPreferences();
    }

    private void restoreFiltersPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (prefs.getBoolean("restoreFilters", false)) {
            this.saveFilters.setChecked(true);
            this.btnStartDate.setText(prefs.getString("startDate", ""));
            this.btnEndDate.setText(prefs.getString("endDate", ""));
            restoreCategories(prefs.getString("categoriesIds", ""));
            toogleAllCountries(false);
            restoreSelectedCountries(prefs.getString("countriesList1", ""), prefs.getString("countriesList2", ""));
            this.seekBar.setProgress(prefs.getInt("volatility", 0));
        }
    }

    private void restoreSelectedCountries(String list1, String list2) {
        String[] codeList1;
        String[] codeList2;
        if (!list1.equals("")) {
            codeList1 = list1.split(",");
        } else {
            codeList1 = new String[1];
        }
        checkFlagsByCodes(((FlagListAdapter) this.flagList1.getAdapter()).getItems(), codeList1);
        ((FlagListAdapter) this.flagList1.getAdapter()).notifyDataSetChanged();
        if (!list2.equals("")) {
            codeList2 = list2.split(",");
        } else {
            codeList2 = new String[1];
        }
        checkFlagsByCodes(((FlagListAdapter) this.flagList2.getAdapter()).getItems(), codeList2);
        ((FlagListAdapter) this.flagList2.getAdapter()).notifyDataSetChanged();
    }

    private void checkFlagsByCodes(ArrayList<CountryItem> countriesList, String[] codeList) {
        Iterator<CountryItem> it = countriesList.iterator();
        while (it.hasNext()) {
            CountryItem countryItem = it.next();
            for (String equals : codeList) {
                if (countryItem.getCountryCode().equals(equals)) {
                    countryItem.setSelected(true);
                }
            }
        }
    }

    private void restoreCategories(String categoriesList) {
        if (!categoriesList.equals("")) {
            String[] categories = categoriesList.split(",");
            for (String valueOf : categories) {
                ((CheckBox) findViewById(Integer.valueOf(valueOf).intValue())).setChecked(true);
            }
        }
    }

    private void createCountriesLists() {
        this.countriesList1 = new ArrayList<>(21);
        this.countriesList2 = new ArrayList<>(21);
        for (int i = 0; i < this.allCountriesList.size(); i++) {
            if (i >= 20) {
                this.countriesList2.add(this.allCountriesList.get(i));
            } else {
                this.countriesList1.add(this.allCountriesList.get(i));
            }
        }
    }

    private void initComponents() {
        this.btnStartDate = (Button) findViewById(C0089R.idFiltersFragment.btnStartDate);
        this.btnStartDate.setOnClickListener(this);
        this.btnEndDate = (Button) findViewById(C0089R.idFiltersFragment.btnEndDate);
        this.btnEndDate.setOnClickListener(this);
        this.btnApplyFilters = (Button) findViewById(C0089R.idFiltersFragment.btnApplyFilters);
        this.btnApplyFilters.setOnClickListener(this);
        this.btnRestoreDefaults = (Button) findViewById(C0089R.idFiltersFragment.btnRestoreDefault);
        this.btnRestoreDefaults.setOnClickListener(this);
        this.centralCheckBox = (CheckBox) findViewById(C0089R.idFiltersFragment.central_bank_checkbox);
        this.consumpCheckBox = (CheckBox) findViewById(C0089R.idFiltersFragment.consump_checkbox);
        this.condifdenceCheckBox = (CheckBox) findViewById(C0089R.idFiltersFragment.confidence);
        this.economicCheckBox = (CheckBox) findViewById(C0089R.idFiltersFragment.economic);
        this.governmentCheckBox = (CheckBox) findViewById(C0089R.idFiltersFragment.government);
        this.employmentCheckBox = (CheckBox) findViewById(C0089R.idFiltersFragment.employment);
        this.liquidityCheckBox = (CheckBox) findViewById(C0089R.idFiltersFragment.liquidity);
        this.allCategories = (CheckBox) findViewById(C0089R.idFiltersFragment.all_categories_checkbox);
        this.allCategories.setOnCheckedChangeListener(this);
        this.allCountries = (CheckBox) findViewById(C0089R.idFiltersFragment.all_countries_checkbox);
        this.allCountries.setOnCheckedChangeListener(this);
        this.saveFilters = (CheckBox) findViewById(C0089R.idFiltersFragment.save_settings);
        this.saveFilters.setOnCheckedChangeListener(this);
        this.seekBar = (SeekBar) findViewById(C0089R.idFiltersFragment.seekBar);
        this.flagList1 = (TwoWayView) findViewById(C0089R.idFiltersFragment.flag_listview_1);
        this.flagList2 = (TwoWayView) findViewById(C0089R.idFiltersFragment.flag_listview_2);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0089R.idFiltersFragment.btnStartDate:
                this.currentSelectedButtonId = v.getId();
                synchronized (this) {
                    if (!this.isShowingCalendarDialog) {
                        this.isShowingCalendarDialog = true;
                        showCalendarDialog();
                    }
                }
                return;
            case C0089R.idFiltersFragment.btnEndDate:
                this.currentSelectedButtonId = v.getId();
                synchronized (this) {
                    if (!this.isShowingCalendarDialog) {
                        this.isShowingCalendarDialog = true;
                        showCalendarDialog();
                    }
                }
                return;
            case C0089R.idFiltersFragment.btnApplyFilters:
                applyFilters();
                return;
            case C0089R.idFiltersFragment.btnRestoreDefault:
                restoreDefaults();
                return;
            default:
                return;
        }
    }

    private void showCalendarDialog() {
        this.formatter = new SimpleDateFormat("MM-dd-yyyy");
        CaldroidListener listener = new CaldroidListener() {
            public void onSelectDate(Date date, View view) {
                if (FiltersActivity.this.currentSelectedButtonId == C0089R.idFiltersFragment.btnStartDate) {
                    FiltersActivity.this.startDate = date;
                } else {
                    FiltersActivity.this.endDate = date;
                }
                FiltersActivity.this.setDateButtonText(FiltersActivity.this.formatter.format(date));
                FiltersActivity.this.isShowingCalendarDialog = false;
                FiltersActivity.this.dialogCaldroidFragment.dismiss();
            }

            public void onChangeMonth(int month, int year) {
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("dialogTitle", "Select a date");
        this.dialogCaldroidFragment = new CaldroidFragment();
        this.dialogCaldroidFragment.setArguments(bundle);
        this.dialogCaldroidFragment.setCaldroidListener(listener);
        setMaxOrMinDate();
        this.dialogCaldroidFragment.show(getSupportFragmentManager(), "CALDROID_DIALOG_FRAGMENT");
        if (this.dialogCaldroidFragment.getDialog() != null) {
            this.dialogCaldroidFragment.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    dialog.dismiss();
                    FiltersActivity.this.isShowingCalendarDialog = false;
                }
            });
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && this.dialogCaldroidFragment != null && this.dialogCaldroidFragment.getShowsDialog()) {
            this.isShowingCalendarDialog = false;
        }
    }

    public void onBackPressed() {
        if (this.isShowingCalendarDialog) {
            this.isShowingCalendarDialog = false;
        }
        super.onBackPressed();
    }

    private void setMaxOrMinDate() {
        if (this.currentSelectedButtonId == C0089R.idFiltersFragment.btnStartDate) {
            if (this.endDate != null) {
                this.dialogCaldroidFragment.setMaxDate(this.endDate);
            }
        } else if (this.startDate != null) {
            this.dialogCaldroidFragment.setMinDate(this.startDate);
        }
    }

    private void restoreDefaults() {
        this.btnStartDate.setText("");
        this.btnEndDate.setText("");
        toogleAllCategories(false);
        this.allCountries.setChecked(false);
        this.allCountriesList = Utils.createCountriesList(this);
        createCountriesLists();
        ((FlagListAdapter) this.flagList1.getAdapter()).setItems(this.countriesList1);
        ((FlagListAdapter) this.flagList1.getAdapter()).notifyDataSetChanged();
        ((FlagListAdapter) this.flagList2.getAdapter()).setItems(this.countriesList2);
        ((FlagListAdapter) this.flagList2.getAdapter()).notifyDataSetChanged();
        this.seekBar.setProgress(0);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == -1) {
            setDateButtonText(data.getStringExtra("result"));
        }
    }

    public void setDateButtonText(String date) {
        ((Button) findViewById(this.currentSelectedButtonId)).setText(date);
        if (this.currentSelectedButtonId == C0089R.idFiltersFragment.btnEndDate) {
            if (this.btnStartDate.getText().toString().equals("")) {
                this.btnStartDate.setText(date);
            }
        } else if (this.btnEndDate.getText().toString().equals("")) {
            this.btnEndDate.setText(date);
        }
    }

    public void applyFilters() {
        int volatility = this.seekBar.getProgress();
        String categories = getSelectedCategories();
        String startDate2 = this.btnStartDate.getText().toString();
        String endDate2 = this.btnEndDate.getText().toString();
        FilterModel filterModel = new FilterModel(categories, getSelectedCountries(), FilterModel.formatStringForRequest(startDate2), FilterModel.formatStringForRequest(endDate2), volatility);
        if (this.saveFilters.isChecked()) {
            saveFiltersInPreferences(filterModel);
        } else {
            clearFilterPreference();
        }
        filterModel.setStartDateOriginal(startDate2);
        filterModel.setEndDateOriginal(endDate2);
        NewsController.getInstance(this).setCalendarFilters(filterModel);
        setResult(-1);
        finish();
    }

    private void clearFilterPreference() {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.remove("categoriesIds");
        editor.remove("countriesList1");
        editor.remove("countriesList2");
        editor.remove("startData");
        editor.remove("endData");
        editor.remove("volatility");
        editor.remove("restoreFilters");
        editor.commit();
    }

    private void saveFiltersInPreferences(FilterModel filterModel) {
        Gson gson = new Gson();
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        editor.putString("categoriesIds", this.categoriesIds);
        editor.putString("countriesList1", this.countryCodesList1);
        editor.putString("countriesList2", this.countryCodesList2);
        editor.putString("startDate", this.btnStartDate.getText().toString());
        editor.putString("endDate", this.btnEndDate.getText().toString());
        editor.putInt("volatility", this.seekBar.getProgress());
        editor.putBoolean("restoreFilters", true);
        editor.putString("filterModel", gson.toJson((Object) filterModel));
        editor.commit();
    }

    private String getSelectedCountries() {
        return getSelectedCountryCodes(((FlagListAdapter) this.flagList1.getAdapter()).getItems(), ((FlagListAdapter) this.flagList2.getAdapter()).getItems());
    }

    private String getSelectedCountryCodes(ArrayList<CountryItem> items1, ArrayList<CountryItem> items2) {
        String result = "";
        String list1 = "";
        String list2 = "";
        Iterator<CountryItem> it = items1.iterator();
        while (it.hasNext()) {
            CountryItem countryItem = it.next();
            if (countryItem.isSelected()) {
                if (!result.equals("")) {
                    result = String.valueOf(result) + "," + countryItem.getCountryCode();
                    list1 = String.valueOf(list1) + "," + countryItem.getCountryCode();
                } else {
                    result = countryItem.getCountryCode();
                    list1 = countryItem.getCountryCode();
                }
            }
        }
        Iterator<CountryItem> it2 = items2.iterator();
        while (it2.hasNext()) {
            CountryItem countryItem2 = it2.next();
            if (countryItem2.isSelected()) {
                result = String.valueOf(result) + "," + countryItem2.getCountryCode();
                if (list2.equals("")) {
                    list2 = countryItem2.getCountryCode();
                } else {
                    list2 = String.valueOf(list2) + "," + countryItem2.getCountryCode();
                }
            }
        }
        if (this.saveFilters.isChecked()) {
            this.countryCodesList1 = list1;
            this.countryCodesList2 = list2;
        }
        return result;
    }

    private String getSelectedCategories() {
        String result;
        String result2;
        String result3;
        String result4;
        String result5;
        String result6;
        String result7 = "";
        String categoriesIds2 = "";
        if (this.centralCheckBox.isChecked()) {
            result7 = String.valueOf(result7) + Constants.CENTRAL_BANKS_KEY;
            categoriesIds2 = new StringBuilder().append(this.centralCheckBox.getId()).toString();
        }
        if (this.consumpCheckBox.isChecked()) {
            if (result.equals("")) {
                result = String.valueOf(result) + Constants.CONSUMP_AND_INFLATION_KEY;
            } else {
                result = String.valueOf(result) + "," + Constants.CONSUMP_AND_INFLATION_KEY;
            }
            if (categoriesIds2.equals("")) {
                categoriesIds2 = new StringBuilder().append(this.consumpCheckBox.getId()).toString();
            } else {
                categoriesIds2 = String.valueOf(categoriesIds2) + "," + this.consumpCheckBox.getId();
            }
        }
        if (this.condifdenceCheckBox.isChecked()) {
            if (result.equals("")) {
                result6 = String.valueOf(result) + Constants.CONFIDENCE_INDICES_KEY;
            } else {
                result6 = String.valueOf(result) + "," + Constants.CONFIDENCE_INDICES_KEY;
            }
            if (categoriesIds2.equals("")) {
                categoriesIds2 = new StringBuilder().append(this.condifdenceCheckBox.getId()).toString();
            } else {
                categoriesIds2 = String.valueOf(categoriesIds2) + "," + this.condifdenceCheckBox.getId();
            }
        }
        if (this.economicCheckBox.isChecked()) {
            if (result.equals("")) {
                result5 = String.valueOf(result) + Constants.ECONOMIC_ACTIVITY_KEY;
            } else {
                result5 = String.valueOf(result) + "," + Constants.ECONOMIC_ACTIVITY_KEY;
            }
            if (categoriesIds2.equals("")) {
                categoriesIds2 = new StringBuilder().append(this.economicCheckBox.getId()).toString();
            } else {
                categoriesIds2 = String.valueOf(categoriesIds2) + "," + this.economicCheckBox.getId();
            }
        }
        if (this.governmentCheckBox.isChecked()) {
            if (result.equals("")) {
                result4 = String.valueOf(result) + Constants.GOVERNMENT_KEY;
            } else {
                result4 = String.valueOf(result) + "," + Constants.GOVERNMENT_KEY;
            }
            if (categoriesIds2.equals("")) {
                categoriesIds2 = new StringBuilder().append(this.governmentCheckBox.getId()).toString();
            } else {
                categoriesIds2 = String.valueOf(categoriesIds2) + "," + this.governmentCheckBox.getId();
            }
        }
        if (this.employmentCheckBox.isChecked()) {
            if (result.equals("")) {
                result3 = String.valueOf(result) + Constants.EMPLOYMENT_KEY;
            } else {
                result3 = String.valueOf(result) + "," + Constants.EMPLOYMENT_KEY;
            }
            if (categoriesIds2.equals("")) {
                categoriesIds2 = new StringBuilder().append(this.employmentCheckBox.getId()).toString();
            } else {
                categoriesIds2 = String.valueOf(categoriesIds2) + "," + this.employmentCheckBox.getId();
            }
        }
        if (this.liquidityCheckBox.isChecked()) {
            if (result.equals("")) {
                result2 = String.valueOf(result) + Constants.LIQUIDITY_AND_BALANCE_KEY;
            } else {
                result2 = String.valueOf(result) + "," + Constants.LIQUIDITY_AND_BALANCE_KEY;
            }
            if (categoriesIds2.equals("")) {
                categoriesIds2 = new StringBuilder().append(this.liquidityCheckBox.getId()).toString();
            } else {
                categoriesIds2 = String.valueOf(categoriesIds2) + "," + this.liquidityCheckBox.getId();
            }
        }
        if (this.saveFilters.isChecked()) {
            this.categoriesIds = categoriesIds2;
        }
        return result;
    }

    public void onCheckedChanged(CompoundButton view, boolean isChecked) {
        switch (view.getId()) {
            case C0089R.idFiltersFragment.all_countries_checkbox:
                toogleAllCountries(isChecked);
                return;
            case C0089R.idFiltersFragment.all_categories_checkbox:
                toogleAllCategories(isChecked);
                return;
            default:
                return;
        }
    }

    private void toogleAllCountries(boolean isChecked) {
        ((FlagListAdapter) this.flagList1.getAdapter()).checkAllItems(isChecked);
        ((FlagListAdapter) this.flagList2.getAdapter()).checkAllItems(isChecked);
    }

    private void toogleAllCategories(boolean isChecked) {
        this.centralCheckBox.setChecked(isChecked);
        this.consumpCheckBox.setChecked(isChecked);
        this.condifdenceCheckBox.setChecked(isChecked);
        this.economicCheckBox.setChecked(isChecked);
        this.governmentCheckBox.setChecked(isChecked);
        this.employmentCheckBox.setChecked(isChecked);
        this.liquidityCheckBox.setChecked(isChecked);
    }

    public void onStart() {
        super.onStart();
        EasyTracker.getInstance();
        EasyTracker.getTracker().sendView("Calendar Filters View");
    }
}
