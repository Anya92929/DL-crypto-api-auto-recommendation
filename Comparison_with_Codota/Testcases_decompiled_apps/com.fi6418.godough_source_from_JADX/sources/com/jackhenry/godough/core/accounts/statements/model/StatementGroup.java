package com.jackhenry.godough.core.accounts.statements.model;

import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughType;
import com.jackhenry.godough.core.p038e.C1567a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class StatementGroup implements GoDoughType {
    private static String FORMAT_OUT = "yyyy-MM-dd'T'HH:mm:ss";
    private boolean isDate;
    private ArrayList<StatementDetailHeader> statementDetails;
    private String statementTitle;

    public ArrayList<StatementDetailHeader> getStatementDetails() {
        return this.statementDetails;
    }

    public String getStatementTitle() {
        if (!isDate()) {
            return this.statementTitle;
        }
        GoDoughApp.getApp().getString(C1506am.statements_invalid_date_format);
        try {
            Date parse = new SimpleDateFormat(FORMAT_OUT).parse(this.statementTitle);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            return C1567a.m6122a(GoDoughApp.getApp(), Long.valueOf(instance.getTimeInMillis()));
        } catch (ParseException e) {
            e.printStackTrace();
            return this.statementTitle;
        }
    }

    public boolean isDate() {
        return this.isDate;
    }

    public void setIsDate(boolean z) {
        this.isDate = z;
    }

    public void setStatementDetails(ArrayList<StatementDetailHeader> arrayList) {
        this.statementDetails = arrayList;
    }

    public void setStatementTitle(String str) {
        this.statementTitle = str;
    }
}
