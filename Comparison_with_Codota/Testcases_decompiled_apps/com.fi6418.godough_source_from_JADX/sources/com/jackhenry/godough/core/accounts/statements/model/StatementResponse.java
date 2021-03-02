package com.jackhenry.godough.core.accounts.statements.model;

import com.jackhenry.godough.core.model.GoDoughType;
import java.util.ArrayList;

public class StatementResponse implements GoDoughType {
    String message;
    private ArrayList<StatementGroup> statements;

    public String getMessage() {
        return this.message;
    }

    public ArrayList<StatementGroup> getStatements() {
        return this.statements;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatements(ArrayList<StatementGroup> arrayList) {
        this.statements = arrayList;
    }
}
