package com.jackhenry.godough.core.accounts.statements.model;

import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughType;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StatementDetailHeader implements GoDoughType {
    private Calendar date;
    private String statementId;
    private String statementTitle;
    private boolean titleIsDate;

    public String getFileName() {
        String str = new SimpleDateFormat("MMddyyyy").format(getStatementDate().getTime()) + ".pdf";
        return !isTitleIsDate() ? getStatementTitle().replace(" ", "_").replace("\\", "_").substring(0, 8) + str : GoDoughApp.getApp().getString(C1506am.statements_filename) + str;
    }

    public Calendar getStatementDate() {
        return this.date;
    }

    public String getStatementId() {
        return this.statementId;
    }

    public String getStatementTitle() {
        return this.statementTitle;
    }

    public boolean isTitleIsDate() {
        return this.titleIsDate;
    }

    public void setStatementDate(Calendar calendar) {
        this.date = calendar;
    }

    public void setStatementId(String str) {
        this.statementId = str;
    }

    public void setStatementTitle(String str) {
        this.statementTitle = str;
    }

    public void setTitleIsDate(boolean z) {
        this.titleIsDate = z;
    }
}
